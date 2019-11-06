-- get the students counts of each class

SELECT class_id, COUNT (student_id) FROM grades GROUP BY class_id ORDER BY class_id;

-- get student id and name for those who have token the class with class_id = 1 and earned more than 80

SELECT s.id, s.name,g.score FROM students s , Grades g WHERE s.id = g.student_id AND g.class_id = 1 AND g.score >= 80;

-- get number of students of each class (only count when have more than 6 students)

SELECT c.name, COUNT(*) FROM grades g , classes c WHERE c.id = g.class_id GROUP BY c.name HAVING COUNT(*)> 6;

-- get students who take al least 2 classes

SELECT g.student_id, s.name,count(g.class_id) FROM students s, grades g WHERE s.id = g.student_id GROUP BY s.name, g.student_id HAVING count(g.class_id) >=2;
