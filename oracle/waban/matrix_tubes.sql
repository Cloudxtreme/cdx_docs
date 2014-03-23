update DNALIMS.sample_variable_fld_tbl
> set value = 'Yes'
> where sample_variable_fld_id in (
> select svf.sample_variable_fld_id
> -- select s.sample_tube_id, a.accession_number, st.study_number ,
> s.concentration, pdv.variable_label, svf.value
> from dnalims.sample_table s, dnalims.accession a,
> DNALIMS.sample_variable_fld_tbl svf, DNALIMS.study_protocol st,
> DNALIMS.protocol_defined_variable pdv
> where s.accession_id = a.accession_id
> and a.study_protocol_id = st.study_protocol_id
> and svf.sample_id = s.sample_id
> and svf.protocol_defined_variable_id =
> pdv.protocol_defined_variable_id
> and st.study_protocol_id = pdv.study_protocol_id
> and pdv.variable_label = 'Proceed Further'
> and s.sample_tube_id in ('1043613091',
> '1043613200',
> '1043608870',
> '1043614235',
> '1043612513',
> '1043613069',
> '1043612784',
> '1043612426',
> '1043612508',
> '1043613324',
> '1043613347')
> )
