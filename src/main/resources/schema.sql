-- Создание тестовой БД
-- CREATE DATABASE "duty_statistics"
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     CONNECTION LIMIT = -1;
-- Расширение для БД поддерживающее работу с типом uuid
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
-- Создать схему в БД
CREATE SCHEMA IF NOT EXISTS duty_statistics;
-- Создание таблиц
--Таблица дежурства
CREATE TABLE IF NOT EXISTS duty_statistics.duty
(
    id        UUID PRIMARY KEY DEFAULT public.uuid_generate_v4(),
    beginDate timestamptz,
    endDate   timestamptz
);
COMMENT ON TABLE duty_statistics.duty IS 'Дежурства';

--Таблица проекта
CREATE TABLE IF NOT EXISTS duty_statistics.project
(
    id                UUID PRIMARY KEY DEFAULT public.uuid_generate_v4(),
    name              VARCHAR,
    parent_id         UUID
        CONSTRAINT parent_fk REFERENCES duty_statistics.duty ON DELETE CASCADE,
    code              VARCHAR UNIQUE,
    projectType       VARCHAR,
    engineResource    BIGINT,
    annualPassageRate BIGINT
);
COMMENT ON TABLE duty_statistics.project IS 'Проекты транспортного средства';

--Таблица транспортного средства
CREATE TABLE IF NOT EXISTS duty_statistics.vehicle
(
    id                 UUID PRIMARY KEY DEFAULT public.uuid_generate_v4(),
    name               VARCHAR,
    start_service_date timestamptz,
    project_id         UUID
        CONSTRAINT project_fk REFERENCES duty_statistics.project ON DELETE SET NULL
);
COMMENT ON TABLE duty_statistics.vehicle IS 'Транспорные средства';

--Таблица транспортного средства
CREATE TABLE IF NOT EXISTS duty_statistics.duty_object
(
    id         UUID PRIMARY KEY DEFAULT public.uuid_generate_v4(),
    duty_id    UUID NOT NULL
        CONSTRAINT duty_fk REFERENCES duty_statistics.duty ON DELETE CASCADE,
    vehicle_id UUID NOT NULL
        CONSTRAINT vehicle_fk REFERENCES duty_statistics.vehicle ON DELETE CASCADE
);
COMMENT ON TABLE duty_statistics.duty_object IS 'Дежурные объекты';

--Таблица транспортного средства
CREATE TABLE IF NOT EXISTS duty_statistics.route
(
    id                    UUID PRIMARY KEY DEFAULT public.uuid_generate_v4(),
    length                BIGINT,
    operatingFullResource BIGINT,
    start_date            timestamptz,
    end_date              timestamptz,
    vehicle_id            UUID
        CONSTRAINT project_fk REFERENCES duty_statistics.vehicle ON DELETE CASCADE
);
COMMENT ON TABLE duty_statistics.route IS 'Маршруты';