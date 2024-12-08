alter table student add column clazz_id int;

ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_CLAZZ FOREIGN KEY (clazz_id) REFERENCES clazz (id);