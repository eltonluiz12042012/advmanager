create table movimentacao_processual(
 id bigint not null auto_increment,
 processo_id bigint not null,
 descricao text,
data_movimentacao timestamp not null,
primary key(id),
constraint fk_processos_id foreign key(processo_id) references processos(id)
);