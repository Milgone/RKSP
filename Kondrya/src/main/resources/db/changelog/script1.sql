CREATE SCHEMA utmn;
CREATE TABLE utmn.student
(
    id          bigserial            NOT
NULL,
    fio         varchar(128)           NOT
NULL
);
COMMENT ON TABLE utmn.student IS 'Таблица для хранения информации о судентах';
COMMENT ON COLUMN utmn.student.fio IS 'ФИО';