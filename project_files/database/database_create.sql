DROP  SCHEMA IF EXISTS segcartorio CASCADE ;
CREATE SCHEMA IF NOT EXISTS segcartorio;
ALTER SCHEMA segcartorio OWNER TO postgres;

DROP TABLE IF EXISTS segcartorio.sc_sistema ;
CREATE TABLE segcartorio.sc_sistema
(
  id_sistema bigint NOT NULL,
  nm_sistema character varying(50) NOT NULL,
  ds_sistema character varying(100) NOT NULL,
  sg_sistema character varying(10) NOT NULL,
  dt_ult_validacao date NOT NULL,
  tx_chave_validacao character varying(100) NOT NULL,
  tx_url character varying(256) NOT NULL,
  CONSTRAINT sc_cad_sistema_pkey PRIMARY KEY (id_sistema)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE segcartorio.sc_sistema
  OWNER TO postgres;

DROP TABLE IF EXISTS segcartorio.sc_usuario ;
CREATE TABLE segcartorio.sc_usuario
(
  id_usuario bigint NOT NULL,
  nm_usuario character varying(50) NOT NULL,
  dt_nascimento date NOT NULL,
  tx_cpf character varying(11) NOT NULL,
  tx_email character varying(50) NOT NULL,
  nm_login character varying(20) NOT NULL,
  nm_senha character varying(50) NOT NULL,
  bt_foto bytea,
  dt_ult_acesso date,
  st_usuario character varying(1) NOT NULL DEFAULT 'A'::character varying,
  nm_funcao character varying(100),
  CONSTRAINT sc_cad_usuario_pkey PRIMARY KEY (id_usuario)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE segcartorio.sc_usuario
  OWNER TO postgres;


DROP TABLE IF EXISTS segcartorio.sc_perfil ;
CREATE TABLE segcartorio.sc_perfil
(
  id_perfil bigint NOT NULL,
  nm_perfil character varying(20) NOT NULL,
  ds_perfil character varying(50) NOT NULL,
  fk_id_sistema bigint NOT NULL,
  CONSTRAINT sc_cad_perfil_pkey PRIMARY KEY (id_perfil),
  CONSTRAINT fk1ed18730f279134e FOREIGN KEY (fk_id_sistema)
      REFERENCES segcartorio.sc_sistema (id_sistema) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE segcartorio.sc_perfil
  OWNER TO postgres;

  DROP TABLE IF EXISTS segcartorio.sc_usuario_perfil ;
CREATE TABLE segcartorio.sc_usuario_perfil
(
  fk_id_usuario bigint NOT NULL,
  fk_id_perfil bigint NOT NULL,
  CONSTRAINT fkae2037727341097 FOREIGN KEY (fk_id_usuario)
      REFERENCES segcartorio.sc_usuario (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkea84773aaa2172138h FOREIGN KEY (fk_id_perfil)
      REFERENCES segcartorio.sc_perfil (id_perfil) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE segcartorio.sc_usuario_perfil
  OWNER TO postgres;

  
  CREATE SEQUENCE segcartorio.seq_id_perfil
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999999
    CACHE 10;


ALTER TABLE segcartorio.seq_id_perfil OWNER TO postgres;

CREATE SEQUENCE segcartorio.seq_id_sistema
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999999
    CACHE 10;


ALTER TABLE segcartorio.seq_id_sistema OWNER TO postgres;


CREATE SEQUENCE segcartorio.seq_id_usuario
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999999
    CACHE 10;


ALTER TABLE segcartorio.seq_id_usuario OWNER TO postgres;


CREATE SEQUENCE segcartorio.seq_id_usuario_perfil
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999999
    CACHE 10;


ALTER TABLE segcartorio.seq_id_usuario_perfil OWNER TO postgres;