CREATE TABLE if not exists "unidade"(
    "id" SERIAL NOT NULL,
    "nome" VARCHAR(100) NOT NULL,
    "endereco" VARCHAR(150) NOT NULL
);
--ALTER TABLE "UNIDADE" ADD CONSTRAINT "PK_UNIDADE_ID" PRIMARY KEY("ID");
CREATE TABLE if not exists "tb_cliente"(
    "id" SERIAL NOT NULL,
    "nro_cpf" VARCHAR(14) NOT NULL,
    "txt_nome" VARCHAR(255)
);
--ALTER TABLE "TB_CLIENTE" ADD CONSTRAINT "PK_CLIENTE_ID" PRIMARY KEY("ID");
CREATE TABLE if not exists "tb_animal"(
    "id" SERIAL NOT NULL,
    "data_nascimento" date,
    "nome" varchar(255),
    "tipo_animal" varchar(255),
    "id_cliente" integer
);
--ALTER TABLE "TB_ANIMAL" ADD CONSTRAINT "PK_ANIMAL_ID" PRIMARY KEY("ID");
CREATE TABLE if not exists "tb_atendimento"(
    "id" serial not null,
    "data_hora" timestamp not null,
    "descricao_servico" varchar(255),
    "funcionario" varchar(255),
    "tipo_servico" varchar(255) not null,
    "valor_total" decimal(19, 2),
    "id_animal" bigint not null
);
--ALTER TABLE "TB_ATENDIMENTO" ADD CONSTRAINT "PK_ATENDIMENTO_ID" PRIMARY KEY("ID");
--alter table "tb_atendimento" add constraint "fk_cliente_animal" foreign key("id_animal") references "tb_animal"("id");
--alter table "tb_animal" add constraint "fk_animal_cliente" foreign key("id_cliente") references "tb_cliente"("id");
