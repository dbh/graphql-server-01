INSERT INTO countries (id, name) VALUES (1, 'USA');
INSERT INTO countries (id, name) VALUES (2, 'France');
INSERT INTO countries (id, name) VALUES (3, 'Brazil');
INSERT INTO countries (id, name) VALUES (4, 'Italy');
INSERT INTO countries (id, name) VALUES (5, 'Canada');

INSERT INTO STATES(name, country_id)
SELECT 'Arizona', c.id FROM countries c WHERE c.name='USA';

INSERT INTO STATES(name, country_id)
SELECT 'Arkansas', c.id FROM countries c WHERE c.name='USA';

INSERT INTO STATES(name, country_id)
SELECT 'Mississippi', c.id FROM countries c WHERE c.name='USA';

INSERT INTO STATES(name, country_id)
SELECT 'California', c.id FROM countries c WHERE c.name='USA';

INSERT INTO STATES(name, country_id)
SELECT 'Rhode Island', c.id FROM countries c WHERE c.name='USA';