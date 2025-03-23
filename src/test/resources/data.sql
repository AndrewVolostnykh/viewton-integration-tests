DROP TABLE USERS;

CREATE TABLE USERS (
                       ID bigserial primary key,
                       FIRST_NAME varchar,
                       LAST_NAME varchar,
                       BIRTHDATE timestamp,
                       EMAIL varchar,
                       RANDOM_NUMBER bigint
);

INSERT INTO users(FIRST_NAME, LAST_NAME, BIRTHDATE, EMAIL, RANDOM_NUMBER)VALUES ('Stew', 'Doan', '2000-01-20 20:29:20.536783', 'stewdoan@gmail.com', 10);
INSERT INTO users(FIRST_NAME, LAST_NAME, BIRTHDATE, EMAIL, RANDOM_NUMBER)VALUES ('Stew', 'Doan', '2000-01-20 20:29:20.536783', 'stewdoan@gmail.com', 10);
INSERT INTO users(FIRST_NAME, LAST_NAME, BIRTHDATE, EMAIL, RANDOM_NUMBER)VALUES ('John', 'Boscassi', '1980-10-01 20:29:20.536783', 'johnboscassi@email.com', 15);
INSERT INTO users(FIRST_NAME, LAST_NAME, BIRTHDATE, EMAIL, RANDOM_NUMBER)VALUES ('Andrew', 'Volostnykh', '1999-12-04 20:29:20.536783', 'andrewvolostnykh@somemail.com', 16);
INSERT INTO users(FIRST_NAME, LAST_NAME, BIRTHDATE, EMAIL, RANDOM_NUMBER)VALUES ('Joshua', 'Gianelli', '1992-01-20 20:29:20.536783', 'gianelliej@gmail.com', 20);
INSERT INTO users(FIRST_NAME, LAST_NAME, BIRTHDATE, EMAIL, RANDOM_NUMBER)VALUES ('Vladyslava', 'Prazhmovska', '2005-04-20 20:29:20.536783', 'vladathebest@email.com', 30);
INSERT INTO users(FIRST_NAME, LAST_NAME, BIRTHDATE, EMAIL, RANDOM_NUMBER)VALUES ('Slava', 'Klimov', '2001-01-05 20:29:20.536783', 'klimovbruh@thinkboard.com', 40);
INSERT INTO users(FIRST_NAME, LAST_NAME, BIRTHDATE, EMAIL, RANDOM_NUMBER)VALUES ('Ivan', 'Dickson', '2002-01-20 20:29:20.536783', 'sickSonIva@gmail.com', 50);
INSERT INTO users(FIRST_NAME, LAST_NAME, BIRTHDATE, EMAIL, RANDOM_NUMBER)VALUES ('Stew', 'Smith', '1971-01-01 20:29:20.536783', 'smithactuallytester@gmail.com', 100);