Alter table topicos
    ADD CONSTRAINT uk_topicos_titulo UNIQUE (titulo),
    ADD CONSTRAINT uk_topicos_mensaje UNIQUE (mensaje);

