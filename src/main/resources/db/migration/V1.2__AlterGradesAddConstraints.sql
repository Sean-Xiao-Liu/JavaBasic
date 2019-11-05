ALTER TABLE Grades
ADD CONSTRAINT grade_student_fk FOREIGN KEY (student_id) REFERENCES Students(id);

ALTER TABLE Grades
ADD CONSTRAINT grade_class_fk FOREIGN KEY (class_id) REFERENCES Classes(id);