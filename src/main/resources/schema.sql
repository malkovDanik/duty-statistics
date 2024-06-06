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
COMMENT ON TABLE duty_statistics.project IS 'Проекты транспортного средства';
COMMENT ON COLUMN duty_statistics.project.id IS 'Идентификатор проекта';
COMMENT ON COLUMN duty_statistics.project.name IS 'Наименование проекта';
COMMENT ON COLUMN duty_statistics.project.parent_id IS 'Родительская запись проекта';
COMMENT ON COLUMN duty_statistics.project.code IS 'Код проекта';
COMMENT ON COLUMN duty_statistics.project.project_type IS 'Позиция в иерархии';

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
COMMENT ON TABLE duty_statistics.vehicle_tth IS 'ТТХ транспортных средств';
COMMENT ON COLUMN duty_statistics.vehicle_tth.id IS 'Идентификатор ТТХ средства';
COMMENT ON COLUMN duty_statistics.vehicle_tth.project_id IS 'Проект транспортного средства';
COMMENT ON COLUMN duty_statistics.vehicle_tth.engine_resource IS 'Установленный полный ресурс двигателя, ч';
COMMENT ON COLUMN duty_statistics.vehicle_tth.annual_passage_rate IS 'Годовая норма, ч';

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
COMMENT ON TABLE duty_statistics.vehicle IS 'Транспорные средства';
COMMENT ON COLUMN duty_statistics.vehicle.id IS 'Идентификатор транспортного средства';
COMMENT ON COLUMN duty_statistics.vehicle.name IS 'Наименование транспортного средства';
COMMENT ON COLUMN duty_statistics.vehicle.start_service_date IS 'Дата начала эксплуатации';
COMMENT ON COLUMN duty_statistics.vehicle.project_id IS 'Проект транспортного средства';

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
COMMENT ON TABLE duty_statistics.duty_object IS 'Дежурные объекты';
COMMENT ON COLUMN duty_statistics.duty_object.vehicle_id IS 'Транспотрное средство';


--Таблица дежурства
CREATE TABLE IF NOT EXISTS duty_statistics.duty
(
    id             UUID PRIMARY KEY DEFAULT public.uuid_generate_v4
        (
        ),
    begin_date     timestamptz,
    end_date       timestamptz,
    duty_object_id UUID
        CONSTRAINT duty_object_fk REFERENCES duty_statistics.duty_object ON DELETE CASCADE
);
COMMENT ON TABLE duty_statistics.duty IS 'Дежурства';
COMMENT ON COLUMN duty_statistics.duty.id IS 'Идентификатор дежурства';
COMMENT ON COLUMN duty_statistics.duty.begin_date IS 'Дата начала дежурства';
COMMENT ON COLUMN duty_statistics.duty.end_date IS 'Дата окончания дежурства';
COMMENT ON COLUMN duty_statistics.duty.duty_object_id IS 'Дежурный объект';


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
COMMENT ON TABLE duty_statistics.route IS 'Маршруты';
COMMENT ON COLUMN duty_statistics.route.id IS 'Идентификатор маршрута';
COMMENT ON COLUMN duty_statistics.route.length IS 'Длина маршрута';
COMMENT ON COLUMN duty_statistics.route.operating_full_resource IS 'Наработка полного технического ресурса двигателя, ч';
COMMENT ON COLUMN duty_statistics.route.start_date IS 'Дата начала прохождения маршрута';
COMMENT ON COLUMN duty_statistics.route.end_date IS 'Дата окончания прохождения маршрута';
COMMENT ON COLUMN duty_statistics.route.duty_id IS 'Дежурство';