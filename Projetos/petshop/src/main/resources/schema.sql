CREATE TABLE "unidade"(
    "id" SERIAL NOT NULL,
    "nome" VARCHAR(100) NOT NULL,
    "endereco" VARCHAR(150) NOT NULL
);
ALTER TABLE "unidade" ADD CONSTRAINT "pk_unidade_id" PRIMARY KEY("id");

CREATE TABLE "tb_cliente"(
    "id" SERIAL NOT NULL,
    "nro_cpf" VARCHAR(14) NOT NULL,
    "txt_nome" VARCHAR(255)
);
ALTER TABLE "tb_cliente" ADD CONSTRAINT "pk_cliente_id" PRIMARY KEY("id");

CREATE TABLE "tb_animal"(
    "id" SERIAL NOT NULL,
    "data_nascimento" date,
    "nome" varchar(255),
    "tipo_animal" varchar(255),
1    "id_cliente" integer
);
ALTER TABLE "tb_animal" ADD CONSTRAINT "pk_animal_id" PRIMARY KEY("id");

CREATE TABLE "tb_atendimento"(
    "id" serial not null,
    "data_hora" timestamp not null,
    "descricao_servico" varchar(255),
    "funcionario" varchar(255),
    "tipo_servico" varchar(255) not null,
    "valor_total" decimal(19, 2),
    "id_animal" bigint not null
);
ALTER TABLE "tb_atendimento" ADD CONSTRAINT "pk_atendimento_id" PRIMARY KEY("id");

alter table "tb_atendimento" add constraint "fk_cliente_animal" foreign key("id_animal") references "tb_animal"("id");
alter table "tb_animal" add constraint "fk_animal_cliente" foreign key("id_cliente") references "tb_cliente"("id");

insert into "unidade" values
(1, 'Zona Norte', 'Rua Assis Brasil, 998'),
(2, 'Zona Sul', 'Rua Mario Totta, 31'),
(3, 'Centro', 'Rua Borges de Medeiros, 4440'),
(4, 'Gramado Centro', 'Av. Hortencias, 130'),
(5, 'Porto Alegre Centro', 'Rua Alberto Bins, 52'),
(6, 'Porto Alegre Lindoia 2', 'Av. Assis Brasil, 3940');

INSERT INTO "tb_cliente" VALUES
(1, '985.228.490-80', 'Joao da Silva'),
(2, '445.720.030-17', 'Pedro dos Santos');
