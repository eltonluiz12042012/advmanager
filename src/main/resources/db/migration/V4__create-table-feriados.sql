create table feriados(
id bigint not null auto_increment,
nome varchar(200) not null,
tipo_feriado varchar(100) not null,
data date not null,
primary key(id)
);