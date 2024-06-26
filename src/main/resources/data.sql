-- Заполнение таблиц тестовыми данными
-------------------------------------------------------------------------Иерархия проектов
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
VALUES ('f1fe404b-90ff-4ba1-9dbd-43a50f9130b9', 'Канарейка B18', '25128e21-f498-41d7-8e4c-68d3497bd09e', 'B18_POWERBOAT',
        'PROJECT');
-------------------------2
-- подкласс 2
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('a2d4f351-9131-4924-a6ba-994ec0d22486', 'Крейсера А750', '84d135f8-9846-416f-93af-a5af1e988929', 'А750_CRUISER',
        'SUB_CLASS');

-- проект 2
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('1363a221-e97f-4192-a45f-8c676d16189c', 'Союз А750', 'a2d4f351-9131-4924-a6ba-994ec0d22486', 'А750_UNION',
        'PROJECT');
-------------------------3
-- подкласс 3
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('726cd83b-3e90-4a5a-9299-67d002e9e2be', 'Боевые корабли Т1000', '84d135f8-9846-416f-93af-a5af1e988929',
        'Т1000_SHIP', 'SUB_CLASS');

-- проект 3
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('471b0eaf-897c-46b4-9dbd-920333cd95bd', 'Мир Т1000', '726cd83b-3e90-4a5a-9299-67d002e9e2be', 'Т1000_WAR',
        'PROJECT');
-------------------------4
-- подкласс 4
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('01576f12-bf0f-4851-8730-34c80e480ef2', 'Крейсера В800', '84d135f8-9846-416f-93af-a5af1e988929', 'В800_CRUISER',
        'SUB_CLASS');

-- проект 4
INSERT INTO duty_statistics.project (id, name, parent_id, code, project_type)
VALUES ('18107c9c-ece2-4974-89af-1fc7df7668b9', 'Восток В800', '01576f12-bf0f-4851-8730-34c80e480ef2', 'В800_EAST',
        'PROJECT');

-------------------------------------------------------------------------ТТХ
INSERT INTO duty_statistics.vehicle_tth(id, project_id, engine_resource, annual_passage_rate)
VALUES ('ec2b8e95-4618-4fe4-bd74-ab563c115411', 'f1fe404b-90ff-4ba1-9dbd-43a50f9130b9', 16000, 1200),
       ('e275ce06-2ac5-46ec-abb9-c81d3611a36e', '1363a221-e97f-4192-a45f-8c676d16189c', 20000, 1500),
       ('5691b006-483f-4670-b057-2adb88a38a27', '471b0eaf-897c-46b4-9dbd-920333cd95bd', 12000, 4000),
       ('cf2cbc80-9da1-42e1-955f-7cc618eae14b', '18107c9c-ece2-4974-89af-1fc7df7668b9', 18000, 1300);

-- 5 дежурных ТС
--------------------------------------------------------------------------Корабли
-- Союз
INSERT INTO duty_statistics.vehicle(id, name, project_id, start_service_date)
VALUES ('490ba512-d18e-4024-8048-56089f389a3a', 'Союз 1', '1363a221-e97f-4192-a45f-8c676d16189c', '1970-05-16 22:12:17.221000 +00:00'),
       ('3ca457ae-5455-4245-ba99-cf04b6d51b1c', 'Союз 2', '1363a221-e97f-4192-a45f-8c676d16189c', '1970-05-16 22:12:17.221000 +00:00');

-- канарейка
INSERT INTO duty_statistics.vehicle(id, name, project_id, start_service_date)
VALUES ('46c36eba-dc28-4e10-9b8c-b863d226d33a', 'Канарейка 1', 'f1fe404b-90ff-4ba1-9dbd-43a50f9130b9', '1980-05-16 22:12:17.221000 +00:00'),
       ('8c45acfc-0d94-4eb3-a910-0471d52c0afe', 'Канарейка 2', 'f1fe404b-90ff-4ba1-9dbd-43a50f9130b9', '1980-05-16 22:12:17.221000 +00:00'),
       ('4d67fb4b-0e78-4bbb-9288-2f6ba39210dc', 'Канарейка 3', 'f1fe404b-90ff-4ba1-9dbd-43a50f9130b9', '1980-05-16 22:12:17.221000 +00:00');

-- Мир
INSERT INTO duty_statistics.vehicle(id, name, project_id, start_service_date)
VALUES ('a195b720-367d-49de-afc0-5b6c82ac8e60', 'Мир 1', '471b0eaf-897c-46b4-9dbd-920333cd95bd', '1985-05-16 22:12:17.221000 +00:00'),
       ('2ca1be56-aa82-42bb-95f4-914bb21f8ad3', 'Мир 2', '471b0eaf-897c-46b4-9dbd-920333cd95bd', '1985-05-16 22:12:17.221000 +00:00');

-- Восток
INSERT INTO duty_statistics.vehicle(id, name, project_id, start_service_date)
VALUES ('01977873-fcf0-4af1-8027-760003748c49', 'Восток 1', '18107c9c-ece2-4974-89af-1fc7df7668b9', '1980-05-16 22:12:17.221000 +00:00'),
       ('36581568-d322-457b-a2e7-037dba39c39a', 'Восток 2', '18107c9c-ece2-4974-89af-1fc7df7668b9', '1980-05-16 22:12:17.221000 +00:00'),
       ('f617b491-9882-4cae-8430-5bba3d1d5d96', 'Восток 3', '18107c9c-ece2-4974-89af-1fc7df7668b9', '1980-05-16 22:12:17.221000 +00:00');

--------------------------------------------------------------------------Дежурные объекты
INSERT INTO duty_statistics.duty_object(id, vehicle_id)
VALUES
-- Союз
('e65b7b7d-be57-4972-ac79-7a61fa1ce4d0', '490ba512-d18e-4024-8048-56089f389a3a'),
('f0359771-4fe7-4eb1-a401-8e6be8000999', '3ca457ae-5455-4245-ba99-cf04b6d51b1c'),
-- канарейка
('32e1db08-72a3-43f9-b264-89f1e30713c0', '46c36eba-dc28-4e10-9b8c-b863d226d33a'),
('95dd9e88-68d1-4443-863f-15ba1e77c53a', '8c45acfc-0d94-4eb3-a910-0471d52c0afe'),
('59e048ae-baf6-4fed-8e68-abf412d0e46b', '4d67fb4b-0e78-4bbb-9288-2f6ba39210dc'),
-- Мир
('6eafd091-f724-4838-ba5e-703d0425fb40', 'a195b720-367d-49de-afc0-5b6c82ac8e60'),
('3ea7e69c-764a-4663-a918-6cb73d44b36a', '2ca1be56-aa82-42bb-95f4-914bb21f8ad3'),
-- Восток
('49973537-5a20-4507-9c1e-7ee3840f1a69', '01977873-fcf0-4af1-8027-760003748c49'),
('fc791e66-8c56-4c9a-9f3b-8accbd773fbe', '36581568-d322-457b-a2e7-037dba39c39a'),
('dbb3ed75-64c3-4948-88e1-22374559182b', 'f617b491-9882-4cae-8430-5bba3d1d5d96');

--------------------------------------------------------------------------Дежурства
-- 3 дежурства на корабль, длительность дежурства - условно 2 недели
INSERT INTO duty_statistics.duty(id, duty_object_id, begin_date, end_date)
VALUES
-- 2023-10-20 05:00 - 2023-11-04 22:00
-- Мир 1
('cf8f00b3-8c97-4fa0-8cb9-bd5ebb5d4a7a', '6eafd091-f724-4838-ba5e-703d0425fb40', '2023-10-20 05:12:17.221000 +00:00', '2023-11-04 22:12:17.221000 +00:00'),
-- канарейка 1
('ad580eae-12f4-455d-8d64-9e7fc86ece80', '32e1db08-72a3-43f9-b264-89f1e30713c0', '2023-10-20 05:12:17.221000 +00:00', '2023-11-04 22:12:17.221000 +00:00'),

-- 2023-11-05 05:00 - 2023-11-19 22:00
-- Восток 1
('26140794-4a23-471f-afa8-03c0913deba2', 'fc791e66-8c56-4c9a-9f3b-8accbd773fbe', '2023-11-05 05:12:17.221000 +00:00', '2023-11-19 22:12:17.221000 +00:00'),
-- Мир 2
('2c12c5ee-c39e-43d5-b2a6-f3135cd2a2e6', '3ea7e69c-764a-4663-a918-6cb73d44b36a', '2023-11-05 05:12:17.221000 +00:00', '2023-11-19 22:12:17.221000 +00:00'),

-- 2023-11-20 05:00 - 2023-12-04 22:00
-- Мир 1
('beaf4391-6d26-4fa7-ada2-c0a6b9d0d9e7', '6eafd091-f724-4838-ba5e-703d0425fb40', '2023-11-20 05:12:17.221000 +00:00', '2023-12-4 22:12:17.221000 +00:00'),
-- Союз1
('03342200-f1c4-4698-a10c-516e7e6b05f2', 'e65b7b7d-be57-4972-ac79-7a61fa1ce4d0', '2023-11-20 05:12:17.221000 +00:00', '2023-12-4 22:12:17.221000 +00:00'),

-- 2023-12-5 05:00 - 2023-12-19 22:00
-- Союз 1
('1c98624d-bd4c-4ec0-a118-ac5d531f42e3', 'e65b7b7d-be57-4972-ac79-7a61fa1ce4d0', '2023-12-5 05:12:17.221000 +00:00', '2023-12-19 22:12:17.221000 +00:00'),
-- Восток 1
('490e465e-9ee1-4f79-9645-a3cb54c2843a', 'fc791e66-8c56-4c9a-9f3b-8accbd773fbe', '2023-12-5 05:12:17.221000 +00:00', '2023-12-19 22:12:17.221000 +00:00'),

-- 2023-12-20 05:00 - 2024-01-3 22:00
-- Мир 2
('bfdbb189-a822-471e-aa50-c11830a505a0', '3ea7e69c-764a-4663-a918-6cb73d44b36a', '2023-12-20 05:12:17.221000 +00:00', '2024-01-03 22:12:17.221000 +00:00'),
-- Канарейка 1
('f0e0c5b6-eee6-42ed-b3c4-8ec7476224c1', '32e1db08-72a3-43f9-b264-89f1e30713c0', '2023-12-20 05:12:17.221000 +00:00', '2024-01-03 22:12:17.221000 +00:00'),

-- 2024-01-04 05:00 - 2024-01-18 22:00
-- Союз2
('bc2f9ab4-d219-4cdb-96f4-03ac54431d35', 'f0359771-4fe7-4eb1-a401-8e6be8000999', '2024-01-04 05:12:17.221000 +00:00', '2024-02-18 22:12:17.221000 +00:00'),
-- Восток 2
('ba2ba098-5f77-45b3-99d3-60b24631d83e', 'dbb3ed75-64c3-4948-88e1-22374559182b', '2024-01-04 05:12:17.221000 +00:00', '2024-02-18 22:12:17.221000 +00:00'),

-- 2024-01-19 05:00 - 2024-02-2 22:00
-- Мир 3
('df45f351-cf0b-481a-b216-d71738f9572d', '49973537-5a20-4507-9c1e-7ee3840f1a69', '2024-01-19 05:12:17.221000 +00:00', '2024-02-02 22:12:17.221000 +00:00'),
-- канарейка 3
('a11e385d-710f-4eb9-845b-afdf5b6a6e43', '59e048ae-baf6-4fed-8e68-abf412d0e46b', '2024-01-19 05:12:17.221000 +00:00', '2024-02-02 22:12:17.221000 +00:00'),

-- 2024-02-3 05:00 - 2024-02-17 22:00
-- Мир 3
('befced92-a3bf-4637-80ab-79d587ad123d', '49973537-5a20-4507-9c1e-7ee3840f1a69', '2024-02-3 05:12:17.221000 +00:00', '2024-02-17 22:12:17.221000 +00:00'),
-- Канарейка 3
('254ad360-76c4-44cb-aa27-c0f5768a36cd', '59e048ae-baf6-4fed-8e68-abf412d0e46b', '2024-02-3 05:12:17.221000 +00:00', '2024-02-17 22:12:17.221000 +00:00'),

-- 2024-02-18 05:00 - 2024-03-3 22:00
-- Восток 2
('ba3aaadd-4ab4-45af-afe9-614515ca654d', 'dbb3ed75-64c3-4948-88e1-22374559182b', '2024-02-18 05:12:17.221000 +00:00', '2024-03-3 22:12:17.221000 +00:00'),
-- Союз 2
('931d1dea-b390-491e-9391-66be496830ea', 'f0359771-4fe7-4eb1-a401-8e6be8000999', '2024-02-18 05:12:17.221000 +00:00', '2024-03-3 22:12:17.221000 +00:00'),

-- 2024-03-4 05:00 - 2024-03-18 22:00
-- Мир 2
('cfa1e532-eb9a-446a-bf37-a9fb6c1ae6e5', '3ea7e69c-764a-4663-a918-6cb73d44b36a', '2024-03-04 05:12:17.221000 +00:00', '2024-03-18 22:12:17.221000 +00:00'),
-- канарейка 2
('37da8ba6-88cf-4d83-a4a0-77e594842f93', '95dd9e88-68d1-4443-863f-15ba1e77c53a', '2024-03-04 05:12:17.221000 +00:00', '2024-03-18 22:12:17.221000 +00:00'),

-- 2024-03-19 05:00 - 2024-04-2 22:00
-- Мир 3
('45b2e872-5420-48d9-be9c-3d0e2f212389', '49973537-5a20-4507-9c1e-7ee3840f1a69', '2024-03-19 05:12:17.221000 +00:00', '2024-04-2 22:12:17.221000 +00:00'),
-- Союз 2
('cdc62bb9-7bac-4cfa-b4dc-de9ba93acc18', 'f0359771-4fe7-4eb1-a401-8e6be8000999', '2024-03-19 05:12:17.221000 +00:00', '2024-04-2 22:12:17.221000 +00:00'),

-- 2024-04-3 05:00 - 2024-04-17 22:00
-- Восток 1
('43167d84-544e-4823-849a-73370e83fc7d', 'fc791e66-8c56-4c9a-9f3b-8accbd773fbe', '2024-04-3 05:12:17.221000 +00:00', '2024-04-17 22:12:17.221000 +00:00'),
-- Канарейка 3
('602ce4cf-bf2f-4143-b346-4da47efbc3be', '59e048ae-baf6-4fed-8e68-abf412d0e46b', '2024-04-3 05:12:17.221000 +00:00', '2024-04-17 22:12:17.221000 +00:00'),

-- 2024-04-18 05:00 - 2024-05-1 22:00
-- Мир 1
('dc236421-642a-48ab-8998-26405e207bb3', '6eafd091-f724-4838-ba5e-703d0425fb40', '2024-04-18 05:12:17.221000 +00:00', '2024-05-1 22:12:17.221000 +00:00'),
-- Канарейка 2
('c5950b3f-4f03-48d0-b791-180436088856', '95dd9e88-68d1-4443-863f-15ba1e77c53a', '2024-04-18 05:12:17.221000 +00:00', '2024-05-1 22:12:17.221000 +00:00'),

-- 2024-05-2 05:00 - 2024-05-16 22:00
-- Союз 1
('a4a30a43-f716-4bd5-930c-2b56303194e1', 'e65b7b7d-be57-4972-ac79-7a61fa1ce4d0', '2024-05-2 05:12:17.221000 +00:00', '2024-05-16 22:12:17.221000 +00:00'),
-- Канарейка 1
('5c7abf3d-00da-41a0-bee0-06d4567aa2fa', '32e1db08-72a3-43f9-b264-89f1e30713c0',  '2024-05-2 05:12:17.221000 +00:00', '2024-05-16 22:12:17.221000 +00:00'),

-- 2024-05-17 05:00 - 2024-06-01 22:00
-- Канарейка 2
    ('22e267ae-a0a2-4dd5-a8be-13f6417af8db', '95dd9e88-68d1-4443-863f-15ba1e77c53a', '2024-05-17 09:12:17.221000 +00:00', '2024-06-01 21:12:17.221000 +00:00'),
-- Восток 2
('a06ca384-e296-44c6-ac3a-0d327e47d317', 'dbb3ed75-64c3-4948-88e1-22374559182b', '2024-05-17 05:12:17.221000 +00:00', '2024-06-01 22:12:17.221000 +00:00');
--------------------------------------------------------------------------Маршруты

INSERT INTO duty_statistics.route(id, length, operating_full_resource, duty_id, start_date, end_date)
VALUES
    ('c9b2eaba-9534-4c9a-8711-43211be84c10', 10000, 100, 'a06ca384-e296-44c6-ac3a-0d327e47d317', '2024-05-17 05:12:17.221000 +00:00', '2024-06-01 22:12:17.221000 +00:00'),
    ('3be5d1ce-5533-404a-85de-b5940c15f70c', 40000, 100, '22e267ae-a0a2-4dd5-a8be-13f6417af8db', '2024-05-17 09:12:17.221000 +00:00', '2024-06-01 21:12:17.221000 +00:00'),

    ('ba356b97-d9a8-4b05-9dcc-542251ece8ea', 16000, 250, '5c7abf3d-00da-41a0-bee0-06d4567aa2fa', '2024-05-2 05:12:17.221000 +00:00', '2024-05-16 22:12:17.221000 +00:00'),
    ('091c910d-7587-4630-9c58-2ce79ac3b2ce', 15000, 250, 'a4a30a43-f716-4bd5-930c-2b56303194e1', '2024-05-2 05:12:17.221000 +00:00', '2024-05-16 22:12:17.221000 +00:00'),

    ('47d34a75-ea2a-478f-a03b-6115d57f5377', 10000, 200, 'c5950b3f-4f03-48d0-b791-180436088856', '2024-04-18 05:12:17.221000 +00:00', '2024-05-1 22:12:17.221000 +00:00'),
    ('92b8f44c-2e51-441d-9688-02faa7204ffa', 13000, 200, 'dc236421-642a-48ab-8998-26405e207bb3', '2024-04-18 05:12:17.221000 +00:00', '2024-05-1 22:12:17.221000 +00:00'),

    ('1b3a41a7-0ce4-4e43-906e-f1bcbd73c5c1', 13000, 1000, '602ce4cf-bf2f-4143-b346-4da47efbc3be', '2024-04-3 05:12:17.221000 +00:00', '2024-04-17 22:12:17.221000 +00:00'),
    ('94b15456-fd83-47e8-8661-cc7d78b43d45', 13000, 1000, '43167d84-544e-4823-849a-73370e83fc7d', '2024-04-3 05:12:17.221000 +00:00', '2024-04-17 22:12:17.221000 +00:00'),

    ('6b25ff6b-f45c-4f12-8f0a-9c353e430cfe', 13000, 100, 'cdc62bb9-7bac-4cfa-b4dc-de9ba93acc18', '2024-03-19 05:12:17.221000 +00:00', '2024-04-2 22:12:17.221000 +00:00'),
    ('2cf4ae14-f653-4ea3-bbcc-336ef20b41d3', 13000, 100, '45b2e872-5420-48d9-be9c-3d0e2f212389', '2024-03-19 05:12:17.221000 +00:00', '2024-04-2 22:12:17.221000 +00:00'),

    ('c0354460-3ee6-4b72-a87b-777d181213af', 13000, 10000, '37da8ba6-88cf-4d83-a4a0-77e594842f93', '2024-03-04 05:12:17.221000 +00:00', '2024-03-18 22:12:17.221000 +00:00'),
    ('effaee01-fd3f-4926-87a7-bfb5ba5c5d14', 13000, 10000, 'cfa1e532-eb9a-446a-bf37-a9fb6c1ae6e5', '2024-03-04 05:12:17.221000 +00:00', '2024-03-18 22:12:17.221000 +00:00'),

    ('24859c85-d01a-4842-b9bf-60d643f45dc7', 13000, 700, '931d1dea-b390-491e-9391-66be496830ea', '2024-02-18 05:12:17.221000 +00:00', '2024-03-3 22:12:17.221000 +00:00'),
    ('a91f75af-df51-4b64-9381-924afc3b9d4f', 13000, 700, 'ba3aaadd-4ab4-45af-afe9-614515ca654d', '2024-02-18 05:12:17.221000 +00:00', '2024-03-3 22:12:17.221000 +00:00'),

    ('79fd5a67-2d48-476b-9796-326d5ddbc00d', 13000, 200, '254ad360-76c4-44cb-aa27-c0f5768a36cd', '2024-02-3 05:12:17.221000 +00:00', '2024-02-17 22:12:17.221000 +00:00'),
    ('757be4db-481a-41ae-977e-38d26ffbaca0', 13000, 200, 'befced92-a3bf-4637-80ab-79d587ad123d', '2024-02-3 05:12:17.221000 +00:00', '2024-02-17 22:12:17.221000 +00:00'),

    ('0fe818c7-1eea-466d-a53d-b137997bb5c5', 13000, 300, 'a11e385d-710f-4eb9-845b-afdf5b6a6e43', '2024-01-19 05:12:17.221000 +00:00', '2024-02-02 22:12:17.221000 +00:00'),
    ('e60cd56e-bec6-4af7-9c8f-6757546f3492', 13000, 300, 'df45f351-cf0b-481a-b216-d71738f9572d', '2024-01-19 05:12:17.221000 +00:00', '2024-02-02 22:12:17.221000 +00:00'),

    ('859f03d6-0b52-45e6-a774-b09bbae3984d', 13000, 1100, 'ba2ba098-5f77-45b3-99d3-60b24631d83e', '2024-01-04 05:12:17.221000 +00:00', '2024-02-18 22:12:17.221000 +00:00'),
    ('9f3e731e-4602-4fc0-a315-05e5b56e6229', 13000, 1100, 'bc2f9ab4-d219-4cdb-96f4-03ac54431d35', '2024-01-04 05:12:17.221000 +00:00', '2024-02-18 22:12:17.221000 +00:00'),

    ('3d437c7e-05e2-4b75-ac1c-a7f271713c66', 13000, 2000, 'f0e0c5b6-eee6-42ed-b3c4-8ec7476224c1', '2023-12-20 05:12:17.221000 +00:00', '2024-01-03 22:12:17.221000 +00:00'),
    ('b8199003-3298-4275-9e1e-b9bf074f4dda', 13000, 2000, 'bfdbb189-a822-471e-aa50-c11830a505a0', '2023-12-20 05:12:17.221000 +00:00', '2024-01-03 22:12:17.221000 +00:00'),

    ('2a3d90ef-39eb-42bb-99f7-c57c5f7b558b', 13000, 1200, '490e465e-9ee1-4f79-9645-a3cb54c2843a', '2023-12-5 05:12:17.221000 +00:00', '2023-12-19 22:12:17.221000 +00:00'),
    ('9fd4dabe-9b87-45dd-a21b-b017b171b33c', 13000, 1200, '1c98624d-bd4c-4ec0-a118-ac5d531f42e3', '2023-12-5 05:12:17.221000 +00:00', '2023-12-19 22:12:17.221000 +00:00'),

    ('038caff1-cd02-4798-b17f-21bfad7736f5', 13000, 1300, '03342200-f1c4-4698-a10c-516e7e6b05f2', '2023-11-20 05:12:17.221000 +00:00', '2023-12-4 22:12:17.221000 +00:00'),
    ('f83271c2-f725-4194-b7bf-b2235a94a27e', 13000, 1300, 'beaf4391-6d26-4fa7-ada2-c0a6b9d0d9e7', '2023-11-20 05:12:17.221000 +00:00', '2023-12-4 22:12:17.221000 +00:00'),

    ('fdb62526-37a8-4b16-8457-95dc5b689ab1', 13000, 1400, '2c12c5ee-c39e-43d5-b2a6-f3135cd2a2e6', '2023-11-05 05:12:17.221000 +00:00', '2023-11-19 22:12:17.221000 +00:00'),
    ('d7267e84-e5cb-4916-bca4-f042b79c19e0', 13000, 1400, '26140794-4a23-471f-afa8-03c0913deba2', '2023-11-05 05:12:17.221000 +00:00', '2023-11-19 22:12:17.221000 +00:00'),

    ('53ec0138-d0f0-43c2-9ca6-8e86fd9c913e', 13000, 1500, 'ad580eae-12f4-455d-8d64-9e7fc86ece80', '2023-10-20 05:12:17.221000 +00:00', '2023-11-04 22:12:17.221000 +00:00'),
    ('f4973707-8441-4da4-aaa7-00dbea709b47', 13000, 1500, 'cf8f00b3-8c97-4fa0-8cb9-bd5ebb5d4a7a', '2023-10-20 05:12:17.221000 +00:00', '2023-11-04 22:12:17.221000 +00:00');
