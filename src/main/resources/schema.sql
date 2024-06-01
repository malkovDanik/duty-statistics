-- Создание тестовой БД
-- CREATE DATABASE "duty_statistics"
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     CONNECTION LIMIT = -1;
-- Расширение для БД поддерживающее работу с типом uuid
CREATE
    EXTENSION IF NOT EXISTS "uuid-ossp";
-- Создать схему в БД
CREATE SCHEMA IF NOT EXISTS duty_statistics;
-- Создание таблиц

--Таблица проекта
CREATE TABLE IF NOT EXISTS duty_statistics.project
(
    id           UUID PRIMARY KEY DEFAULT public.uuid_generate_v4
        (
        ),
    name         VARCHAR,
    parent_id    UUID
        CONSTRAINT parent_fk REFERENCES duty_statistics.project ON DELETE CASCADE,
    code         VARCHAR UNIQUE,
    project_type VARCHAR
);
COMMENT
    ON TABLE duty_statistics.project IS 'Проекты транспортного средства';

--Таблица ттх трапортных средств
CREATE TABLE IF NOT EXISTS duty_statistics.vehicle_tth
(
    id                  UUID PRIMARY KEY DEFAULT public.uuid_generate_v4
        (
        ),
    project_id          UUID
        CONSTRAINT project_fk REFERENCES duty_statistics.project ON DELETE CASCADE,
    engine_resource     BIGINT,
    annual_passage_rate BIGINT
);
COMMENT
    ON TABLE duty_statistics.vehicle_tth IS 'ТТХ транспортных средств';

--Таблица транспортного средства
CREATE TABLE IF NOT EXISTS duty_statistics.vehicle
(
    id                 UUID PRIMARY KEY DEFAULT public.uuid_generate_v4
        (
        ),
    name               VARCHAR,
    start_service_date timestamptz,
    project_id         UUID
        CONSTRAINT project_fk REFERENCES duty_statistics.project ON DELETE SET NULL
);
COMMENT
    ON TABLE duty_statistics.vehicle IS 'Транспорные средства';

--Таблица объекта дежурства
CREATE TABLE IF NOT EXISTS duty_statistics.duty_object
(
    id         UUID PRIMARY KEY DEFAULT public.uuid_generate_v4
        (
        ),
    vehicle_id UUID NOT NULL
        CONSTRAINT vehicle_fk REFERENCES duty_statistics.vehicle
            ON DELETE CASCADE
);
COMMENT
    ON TABLE duty_statistics.duty_object IS 'Дежурные объекты';

--Таблица дежурства
CREATE TABLE IF NOT EXISTS duty_statistics.duty
(
    id             UUID PRIMARY KEY DEFAULT public.uuid_generate_v4
        (
        ),
    begin_Date     timestamptz,
    end_Date       timestamptz,
    duty_object_id UUID
        CONSTRAINT duty_object_fk REFERENCES duty_statistics.duty_object ON DELETE CASCADE
);
COMMENT
    ON TABLE duty_statistics.duty IS 'Дежурства';

--Таблица маршрута транспортного средства
CREATE TABLE IF NOT EXISTS duty_statistics.route
(
    id                      UUID PRIMARY KEY DEFAULT public.uuid_generate_v4
        (
        ),
    length                  BIGINT,
    operating_full_resource BIGINT,
    start_date              timestamptz,
    end_date                timestamptz,
    duty_id                 UUID
        CONSTRAINT duty_fk REFERENCES duty_statistics.duty ON DELETE CASCADE
);
COMMENT
    ON TABLE duty_statistics.route IS 'Маршруты';