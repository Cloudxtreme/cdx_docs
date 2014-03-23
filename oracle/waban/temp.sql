  CREATE OR REPLACE FORCE VIEW "DNALIMS"."SAMPLE_DISPLAY_VIEW" ("SAMPLE_TUBE_ID"
, "CLIENT_SAMPLE_TUBE_ID", "SAMPLE_STATUS", "LOCATION", "SOURCE_TYPE", "CONTAINE
R_ID", "CONTAINER_ROW", "CONTAINER_COLUMN", "SAMPLE_CONDITION", "INITIAL_VOLUME"
, "DATE_RECEIVED", "VOLUME", "CONCENTRATION", "FINAL_STORAGE_TUBE", "NUMBER_IN_A
CC_SEQUENCE", "SAMPLE_ID", "PENDING_SAMPLE_ID", "ACCESSION_ID", "ACCESSION_NUMBE
R", "STUDY_PROTOCOL_ID") AS
  (


select sam.sample_tube_id, sam.client_sample_tube_id, nvl(sam.sample_status,da.att_val) sample_status,
  limspackage.container_position (sam.sample_id), sam.source_type,
  sam.container_id, sam.container_row, sam.container_column, sam.sample_condition,
  sam.initial_volume, to_char(sam.date_received,'MM/DD/YYYY'), sam.volume, sam.concentration,
  sam.final_storage_tube, sam.number_in_acc_sequence,
  sam.sample_id, null, acc.accession_id, '', acc.STUDY_PROTOCOL_ID
from sample sam, accession acc, (select max(da.ATTRIBUTE_VALUE) att_val 
                                 from discrete_attribute da
                                 where da.ATTRIBUTE_NAME = 'EXISTING_SAMP_STATUS') da 
where sam.accession_id = acc.accession_id
  and sam.number_in_acc_sequence is not null) union all
(select ps.sponsor_sample_tube_id, ps.sponsor_sample_tube_id, nvl(ddv.SAMPLE_STA
TUS, da.att_val),
DECODE(con.CONTAINER_ID, null, '', con.CONTAINER_ID || '(' ||
  limspackage.get_char_value(psa2.ATTRIBUTE_VALUE)  || limspackage.get_number_va
lue(psa3.ATTRIBUTE_VALUE)  || ')'),
  ps.source_type,  con.CONTAINER_ID, decode(sign(limspackage.get_number_value(ps
a2.ATTRIBUTE_VALUE)),-1,0,limspackage.get_number_value(psa2.ATTRIBUTE_VALUE)),
  decode(sign(limspackage.get_number_value(psa3.ATTRIBUTE_VALUE)),-1,0,limspacka
ge.get_number_value(psa3.ATTRIBUTE_VALUE)),
  psa4.ATTRIBUTE_VALUE, '', to_char(ps.date_created,'MM/DD/YYYY'), ps.volume, ps
.concentration,
  ps.final_storage_tube, 0, null, ps.PENDING_SAMPLE_ID, ps.ACCESSION_ID,
  ps.SPONSOR_ACCESSION_ID, ps.STUDY_PROTOCOL_ID
from pending_sample ps, autoaccession_load al, dna_destruction_vendor ddv,
  pending_sample_attribute psa1, container con, pending_sample_attribute psa2,
  pending_sample_attribute psa3, pending_sample_attribute psa4,
  (select max(da.ATTRIBUTE_VALUE) att_val from discrete_attribute da
  where da.ATTRIBUTE_NAME = 'PENDING_SAMP_STATUS') da
where ps.autoaccession_load_id = al.autoaccession_load_id
  and ddv.PENDING_SAMPLE_ID (+) = ps.PENDING_SAMPLE_ID
  and al.load_succeeded = 1  and ps.sample_id is null
  and ps.PENDING_SAMPLE_ID = psa1.PENDING_SAMPLE_ID (+)
  and UPPER(psa1.ATTRIBUTE_NAME (+)) = 'TARGET_CONTAINER'
  and upper(psa1.ATTRIBUTE_VALUE) = con.CONTAINER_ID (+)
  and ps.PENDING_SAMPLE_ID = psa2.PENDING_SAMPLE_ID (+)
  and UPPER(psa2.ATTRIBUTE_NAME (+)) = 'TARGET_ROW'
  and ps.PENDING_SAMPLE_ID = psa3.PENDING_SAMPLE_ID (+)
  and UPPER(psa3.ATTRIBUTE_NAME (+)) = 'TARGET_COL'
  and ps.PENDING_SAMPLE_ID = psa4.PENDING_SAMPLE_ID (+)
  and UPPER(psa4.ATTRIBUTE_NAME (+)) = 'SAMPLE_CONDITION')


