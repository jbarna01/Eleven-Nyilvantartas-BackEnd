alter table operatorok add constraint fk_operatorok_jogok foreign key (jogok_fk) references jogok(id);
