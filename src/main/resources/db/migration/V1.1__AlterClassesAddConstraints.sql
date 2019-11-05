ALTER TABLE Classes
ADD CONSTRAINT classes_teachers_fk FOREIGN KEY (teacher_id) REFERENCES Teachers (id);