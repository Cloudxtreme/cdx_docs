library(RJDBC)

get.cp.data = function(conn, date.string) {
	query = "
	select distinct s.container_id as plate_id, cv.cp_run_id as run_id, 
	(s.container_row - 1) * cm.container_columns + s.container_column as well, cv.cp_value as raw_cp
  from cp_value cv, sample s, container c, container_map cm
  where cv.sample_id = s.sample_id
	and c.container_id = s.container_id
	and c.container_map_id = cm.container_map_id
	and c.date_created >= DATE '%s'
	"
	query = sprintf(query, date.string)
	r = dbGetQuery(conn, query)
	names(r) = gsub("_", ".", tolower(names(r)))
  
	r$raw.cp = as.numeric(r$raw.cp)
	r
}

get.aggregated.cp.data = function(conn, date.string) {
	query = "
	select distinct ccrb.batch, cr.container_id as plate_id, a.accession_id, cnv.cp_run_id as run_id, 
	regexp_replace(o.oligo_name, '^..*-', '') as GENE_NAME,
	cnv.cp_normalized_value as CPSD,
	cnv.offset, cnv.num_no_calls, cnv.num_replicates, cnv.date_calculated
	from cp_normalized_value cnv, oligo_design o, cdx_cp_run_batch ccrb, cp_run cr, accession a, sample s
	where cnv.cp_run_id = ccrb.cp_run_id
	and cnv.oligo_id = o.oligo_id
	and cnv.cp_run_id = cr.cp_run_id
	and cr.sample_id = s.sample_id
	and s.accession_id = a.accession_id
	and cnv.date_calculated >= DATE '%s'
	"
	query = sprintf(query, date.string)
	r = dbGetQuery(conn, query)
	names(r) = gsub("_", ".", tolower(names(r)))

	r$cp = as.numeric(do.call(rbind, strsplit(r$cpsd, '\\|'))[,1])
	r$cp.sd = as.numeric(do.call(rbind, strsplit(r$cpsd, '\\|'))[,2])
	r$cpsd = NULL

	r$date = as.POSIXct(r$date.calculated)
  r$date.calculated = NULL

	r$batch = as.numeric(r$batch)
	r
}

get.all.accession.data = function(conn) {
	query = "
	select a.accession_id, a.accession_number as accession, sp.study_number, avv1.value as gender, avv2.value as dob, 
	avv3.value as dst, to_number(avv4.value) as min_score, to_number(avv5.value) as max_score
	from accession a 
	inner join study_protocol sp on a.study_protocol_id = sp.study_protocol_id 
	left outer join (select accession_id, value from accession_variable_view where variable_label = 'Gender') avv1 on a.accession_id = avv1.accession_id 
	left outer join (select accession_id, value from accession_variable_view where variable_label = 'Date of Birth') avv2 on a.accession_id = avv2.accession_id 
	left outer join (select accession_id, value from accession_variable_view where variable_label = 'Date Sample Taken') avv3 on a.accession_id = avv3.accession_id
	left outer join (select accession_id, value from accession_variable_view where variable_label = 'Poscontrol Min Score') avv4 on a.accession_id = avv4.accession_id
	left outer join (select accession_id, value from accession_variable_view where variable_label = 'Poscontrol Max Score') avv5 on a.accession_id = avv5.accession_id
	"
  r = dbGetQuery(conn, query)
	names(r) = gsub("_", ".", tolower(names(r)))

  r = transform(r, dob=as.POSIXct(dob, format="%d-%b-%Y"), dst=as.POSIXct(dst, format="%d-%b-%Y"), 
						gender = ifelse(gender == "Male", 1, ifelse(gender == "Female", 0, 0.5)))
	r = transform(r, age=as.numeric(dst - dob, units="secs")/(60 * 60 * 24 * 365.25))
	acc = substr(r$accession, 1, 3)
	r$sample.type = ifelse(acc == "AP0", "WAT", ifelse(acc == "NEG", "NEG", ifelse(acc == "POS", "POS", "SAM")))
	r
}

get.all.qc.data = function(conn) {
	query = "select * from cdx_cp_run_qc"
	r = dbGetQuery(conn, query)
	names(r) = gsub("_", ".", tolower(names(r)))

  r = transform(r, cdx.cp.run.qc.id = NULL, run.id = cp.run.id, cp.run.id = NULL)
	r
}

get.all.plate.lot.data = function(conn) {
	query = "
	SELECT cbr.container_id as plate_id, upper(cc.entered_value) as plate_lot
	FROM checklist c, checklist_content cc, 
	(SELECT DISTINCT cb.checklist_id, cr.container_id  
	 FROM container_batch cb, container_reagent cr  
	 WHERE cr.container_batch_id = cb.container_batch_id) cbr
	WHERE cc.checklist_id = c.checklist_id  
	AND   cc.checklist_row = 1  
	AND   cc.checklist_col = -1  
	AND c.checklist_id = cbr.checklist_id 
	"
	query = sprintf(query)
	r = dbGetQuery(conn, query)
	names(r) = gsub("_", ".", tolower(names(r)))
	r
}

