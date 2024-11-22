create table processos(
 id bigint not null auto_increment,
 processo varchar(50) not null,
 autor_id bigint not null,
 reu varchar(150) not null,
 comarca varchar(100) not null,
 estado varchar(2) not null,
 numero_vara int not null,
 vara varchar(50) not null,
 acao varchar(100)not null,
 situacao_atual varchar(100) not null,
 valor_causa decimal(30,4),
 status varchar(50) not null,
 data_protocolo timestamp not null,
 primary key(id),
 constraint fk_autor_id foreign key(autor_id) references pessoas(id)
 )