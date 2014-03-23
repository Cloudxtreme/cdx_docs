
drop table if exists entity_type;
create table entity_type(
	code varchar(1),
	description varchar(255)
);


drop table if exists sole_proprietor;
create table sole_proprietor(
  code varchar(1),
  description varchar(255)
);


drop table if exists subpart;
create table subpart(
  code varchar(1),
  description varchar(255)
);


drop table if exists gender;
create table gender(
  code varchar(1),
  description varchar(255)
);

drop table if exists deactivation_reason;
create table deactivation_reason(
  code varchar(2),
  description varchar(255)
);


drop table if exists other_provider_name_type;
create table other_provider_name_type(
  code varchar(1),
  description varchar(255),
  type varchar(10)
);

drop table if exists name_prefix;
create table name_prefix(
  code varchar(10),
  description varchar(255)
);

drop table if exists name_suffix;
create table name_suffix(
  code varchar(10),
  description varchar(255)
);

drop table if exists state;
create table state(
  code varchar(2),
  name varchar(255),
  type varchar(5)
);

drop table if exists country;
create table country(
  code varchar(2),
  name varchar(255)
);

drop table if exists other_provider_identifier_issuer;
create table other_provider_identifier_issuer(
  code varchar(2),
  description varchar(255)
);

drop table if exists taxonomy;
create table taxonomy(
  code varchar(255),
  description varchar(255)
);

create table primary_taxonomy(
  code varchar(1),
  description varchar(255)
);


