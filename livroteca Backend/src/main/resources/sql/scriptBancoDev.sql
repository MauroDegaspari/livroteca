CREATE TABLE CATEGORIAS(
   id     NUMBER PRIMARY KEY NOT NULL,
   nome   VARCHAR2(255) NULL,
   texto  VARCHAR2(2000)NULL

)
/
CREATE TABLE livros(
    id             NUMBER PRIMARY KEY NOT NULL,
   nome           VARCHAR2(255) NULL,
   texto          VARCHAR2(2000)NULL,
   titulo         VARCHAR2(255) NULL,
   categoria_id   NUMBER NOT NULL
)
/
ALTER TABLE livros
  ADD CONSTRAINT cd_livros_fk FOREIGN KEY(
    id)
    REFERENCES CATEGORIAS (
    id)