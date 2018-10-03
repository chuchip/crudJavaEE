create table prov_espana(
 cop_codi varchar(2) not null,
 cop_nombre varchar(30) not NULL,
 constraint ix_prov_espana primary  key (cop_codi)
);
insert into prov_espana values(1,'Álava (Vitoria)');
insert into prov_espana values(2,'Albacete');
insert into prov_espana values(3,'Alicante');
insert into prov_espana values(4,'Almería');
insert into prov_espana values(5,'Ávila');
insert into prov_espana values(6,'Badajoz');
insert into prov_espana values(7,'Baleares (Palma de Mallorca)');
insert into prov_espana values(8,'Barcelona');
insert into prov_espana values(9,'Burgos');
insert into prov_espana values(10,'Cáceres');
insert into prov_espana values(11,'Cádiz');
insert into prov_espana values(12,'Castellón');
insert into prov_espana values(13,'Ciudad Real');
insert into prov_espana values(14,'Córdoba');
insert into prov_espana values(15,'Coruña');
insert into prov_espana values(16,'Cuenca');
insert into prov_espana values(17,'Gerona');
insert into prov_espana values(18,'Granada');
insert into prov_espana values(19,'Guadalajara');
insert into prov_espana values(20,'Guipúzcoa (San Sebastián)');
insert into prov_espana values(21,'Huelva');
insert into prov_espana values(22,'Huesca');
insert into prov_espana values(23,'Jaén');
insert into prov_espana values(24,'León');
insert into prov_espana values(25,'Lérida');
insert into prov_espana values(26,'La Rioja (Logroño)');
insert into prov_espana values(27,'Lugo');
insert into prov_espana values(28,'Madrid');
insert into prov_espana values(29,'Málaga');
insert into prov_espana values(30,'Murcia');
insert into prov_espana values(31,'Navarra (Pamplona)');
insert into prov_espana values(32,'Orense');
insert into prov_espana values(33,'Asturias (Oviedo)');
insert into prov_espana values(34,'Palencia');
insert into prov_espana values(35,'Las Palmas');
insert into prov_espana values(36,'Pontevedra');
insert into prov_espana values(37,'Salamanca');
insert into prov_espana values(38,'Santa Cruz de Tenerife');
insert into prov_espana values(39,'Cantabria (Santander)');
insert into prov_espana values(40,'Segovia');
insert into prov_espana values(41,'Sevilla');
insert into prov_espana values(42,'Soria');
insert into prov_espana values(43,'Tarragona');
insert into prov_espana values(44,'Teruel');
insert into prov_espana values(45,'Toledo');
insert into prov_espana values(46,'Valencia');
insert into prov_espana values(47,'Valladolid');
insert into prov_espana values(48,'Vizcaya (Bilbao)');
insert into prov_espana values(49,'Zamora');
insert into prov_espana values(50,'Zaragoza');
insert into prov_espana values(51,'Ceuta');
insert into prov_espana values(52,'Melilla');

create table clientes
(
emp_codi int not null,		
cli_codi int not null,
cli_nomb varchar(50), 
cli_nomco varchar(120), 
cli_direc varchar(50), 
cli_pobl varchar(30), 
cli_codpo varchar(8), 
cli_telef varchar(25),
cli_fax varchar(15),
cli_nif varchar(30), 
cli_percon varchar(30),
cli_telcon varchar(15),
cli_nomen varchar(50), 
cli_diree varchar(50), 
cli_poble varchar(30), 
cli_codpoe varchar(8), 
cli_telefe varchar(15),
cli_faxe varchar(15),	
cli_horenv varchar(50), 
cli_comenv varchar(80), 
tar_codi int,		
cli_codfa int,          
cli_tipfac varchar(1),	
fpa_codi int,		
cli_activ smallint default -1 not null,	
cli_codrut varchar(5),	
cli_dtopp decimal(5,2),	
cli_dtootr decimal(5,2),
cli_albval int,		
cli_recequ smallint,	
cli_agralb int,		
cli_comen varchar(255),	
cli_riesg float,	
pai_inic varchar(2)  not null ,		
cue_codi varchar(12),	
cli_exeiva smallint,	
cli_tipiva VARCHAR(2),
cli_poriva varchar(2), 
cli_tipdoc varchar(2), 
cli_sitfac varchar(2), 
div_codi   int, 	
cli_pdtoco float, 
cli_prapel float, 
rut_codi varchar(2),
cli_precfi int default 0 not null, 
cli_fecalt date not null default current_date,	
cli_feulmo date, 		
cli_gener smallint not null default 0,
sbe_codi smallint not null default 1,
cli_intern smallint not null default 0,
eti_codi smallint not null default 0,	
cli_feulve date,        
cli_feulco date,        
cli_email1 char(60),    
cli_email2 char(60),    
cli_servir smallint default -1 not null,
cli_enalva smallint not null default 0, 
cli_ordrut smallint, 
cli_comped varchar(256),
constraint ix_cliente primary key(emp_codi,cli_codi)
);
create table empresa
(
 emp_codi int not null,  
 emp_nomb varchar(40),	 
 emp_dire varchar(40),	 
 emp_pobl varchar(30),	 
 emp_codpo varchar(15),	 
 emp_telef varchar(15),	 
 emp_fax varchar(15),	 
 emp_nif varchar(12),	 
 primary key(emp_codi)
);
create table formpago
(
fpa_codi int not null,	
fpa_nomb varchar(50),
fpa_dia1 int ,  
fpa_dia2 int ,	
fpa_dia3 int ,	
fpa_esgir int not null,	
primary key (fpa_codi)
);
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
create table subempresa
(
 emp_codi int not null,
 sbe_codi smallint not null,	
 sbe_nomb char(40) not null,	
 sbe_albped smallint not null default 0, 
 constraint ix_subempr primary key (emp_codi,sbe_codi)
);

alter table clientes add constraint cliente_fpa
   foreign key (fpa_codi) references formpago(fpa_codi);
alter table clientes add constraint cliente_pai
   foreign key (pai_inic) references paises(pai_inic);
alter table paises add constraint loc_codi foreign key (loc_codi)
    references locales(loc_codi);	
alter table clientes add constraint cliente_emp
   foreign key (emp_codi) references empresa(emp_codi);
alter table clientes add constraint cliente_sbe
   foreign key (emp_codi,sbe_codi) references subempresa(emp_codi,sbe_codi);
alter table subempresa add constraint subempr_emp
   foreign key (emp_codi) references empresa(emp_codi);