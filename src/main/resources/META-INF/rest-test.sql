create table paises
(
 pai_inic VARCHAR(2) not null,  
 pai_nomb VARCHAR(50) not null,	
 pai_nomcor VARCHAR(5) not null, 
 pai_activ smallint not null default -1,
 loc_codi varchar(5) not null default 'es_ES',
 primary key (pai_inic)
);
create table locales
(
loc_codi varchar(5) not null, 
loc_nomb varchar(30) not null,
primary key (loc_codi)
);
insert into locales values('es_ES','Español (España)');

alter table paises add constraint loc_codi foreign key (loc_codi)
    references locales(loc_codi);	
