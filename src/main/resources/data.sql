-- Заполнение таблиц тестовыми данными
-- 4 проекта
-- Группа
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('2dd70f5c-a170-49ca-8ff8-b0a7f1026044', 'Корабли и суда', NULL, 'SHIPS_AND_VESSELS', 'GROUP');
-- Класс
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('84d135f8-9846-416f-93af-a5af1e988929', 'Надводные суда', '2dd70f5c-a170-49ca-8ff8-b0a7f1026044',
        'SURFACE_VESSELS', 'CLASS');
-------------------------1
-- подкласс 1
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('25128e21-f498-41d7-8e4c-68d3497bd09e', 'Катера B18', '84d135f8-9846-416f-93af-a5af1e988929', 'B18_BOAT',
        'SUB_CLASS');

-- проект 1
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('f1fe404b-90ff-4ba1-9dbd-43a50f9130b9', 'Канарейка B18', '25128e21-f498-41d7-8e4c-68d3497bd09e', 'B18_BOAT',
        'PROJECT');
-------------------------2
-- подкласс 2
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('a2d4f351-9131-4924-a6ba-994ec0d22486', 'Крейсера B18', '84d135f8-9846-416f-93af-a5af1e988929', 'B18_BOAT',
        'SUB_CLASS');

-- проект 2
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('1363a221-e97f-4192-a45f-8c676d16189c', 'Жуков А750', 'a2d4f351-9131-4924-a6ba-994ec0d22486', 'B18_BOAT',
        'PROJECT');
-------------------------3
-- подкласс 3
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('726cd83b-3e90-4a5a-9299-67d002e9e2be', 'Боевые корабли Т1000', '84d135f8-9846-416f-93af-a5af1e988929',
        'B18_BOAT', 'SUB_CLASS');

-- проект 3
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('471b0eaf-897c-46b4-9dbd-920333cd95bd', 'Мир Т1000', '726cd83b-3e90-4a5a-9299-67d002e9e2be', 'B18_BOAT',
        'PROJECT');
-------------------------4
-- подкласс 4
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('01576f12-bf0f-4851-8730-34c80e480ef2', 'Крейсера К900', '84d135f8-9846-416f-93af-a5af1e988929', 'B18_BOAT',
        'SUB_CLASS', );

-- проект 4
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('18107c9c-ece2-4974-89af-1fc7df7668b9', 'СОЮЗ К900', '01576f12-bf0f-4851-8730-34c80e480ef2', 'B18_BOAT',
        'PROJECT');

----------------------------------------------------------------------------------------------------------------ТТХ
INSERT INTO duty_statistics.vehicle_tth(id, project_id, engine_resource, annual_passage_rate)
VALUES
    ('', '', 16000, 1000),
    ('', '', 20000, 1200),
    ('', '', 16000, 1000),
    ('', '', 16000, 1000),
-----------------------------------------------------------------------------------------------------------Дежурные силы

-- 5 дежурных ТС
-----------------------------------------------------------------------------------------------------------------Корабли
-- Корабли союз
INSERT INTO duty_statistics.vehicle(id, name, project_id)
VALUES ('490ba512-d18e-4024-8048-56089f389a3a', 'Союз 1', '18107c9c-ece2-4974-89af-1fc7df7668b9');

INSERT INTO duty_statistics.vehicle(id, name, project_id)
VALUES ('3ca457ae-5455-4245-ba99-cf04b6d51b1c', 'Союз 2', '18107c9c-ece2-4974-89af-1fc7df7668b9');

-- Корабли канарейка
INSERT INTO duty_statistics.vehicle(id, name, project_id)
VALUES ('46c36eba-dc28-4e10-9b8c-b863d226d33a', 'Канарейка 1', '18107c9c-ece2-4974-89af-1fc7df7668b9');

INSERT INTO duty_statistics.vehicle(id, name, project_id)
VALUES ('8c45acfc-0d94-4eb3-a910-0471d52c0afe', 'Канарейка 2', '18107c9c-ece2-4974-89af-1fc7df7668b9');

INSERT INTO duty_statistics.vehicle(id, name, project_id)
VALUES ('4d67fb4b-0e78-4bbb-9288-2f6ba39210dc', 'Канарейка 3', '18107c9c-ece2-4974-89af-1fc7df7668b9');

-- Корабли Жуков
INSERT INTO duty_statistics.vehicle(id, name, project_id)
VALUES ('382a6096-581d-4277-a87f-278f53c91e75', 'Жуков 1', '18107c9c-ece2-4974-89af-1fc7df7668b9');

-- Мир
INSERT INTO duty_statistics.vehicle(id, name, project_id)
VALUES ('a195b720-367d-49de-afc0-5b6c82ac8e60', 'Мир 1', '18107c9c-ece2-4974-89af-1fc7df7668b9');

INSERT INTO duty_statistics.vehicle(id, name, project_id)
VALUES ('2ca1be56-aa82-42bb-95f4-914bb21f8ad3', 'Мир 2', '18107c9c-ece2-4974-89af-1fc7df7668b9');

-- Восток
INSERT INTO duty_statistics.vehicle(id, name, project_id)
VALUES ('01977873-fcf0-4af1-8027-760003748c49', 'Восток 1', '18107c9c-ece2-4974-89af-1fc7df7668b9');

INSERT INTO duty_statistics.vehicle(id, name, project_id)
VALUES ('36581568-d322-457b-a2e7-037dba39c39a', 'Восток 2', '18107c9c-ece2-4974-89af-1fc7df7668b9');

INSERT INTO duty_statistics.vehicle(id, name, project_id)
VALUES ('f617b491-9882-4cae-8430-5bba3d1d5d96', 'Восток 3', '18107c9c-ece2-4974-89af-1fc7df7668b9');



select uuid_generate_v4()

-- 3 корабля за последние 3 месяца
--  2 в апреле
--  2 в марте
--
-- 5 кораблей по 1 в месяц в маршрутах