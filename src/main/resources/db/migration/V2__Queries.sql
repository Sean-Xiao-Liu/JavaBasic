-- get the students counts of each class

SELECT class_id, COUNT (student_id)
FROM grades
GROUP BY class_id
ORDER BY class_id;

-- get student id and name for those who have token the class with class_id = 1 and earned more than 80

SELECT s.id, s.name,g.score
FROM students s , Grades g
WHERE s.id = g.student_id
AND g.class_id = 1
AND g.score >= 80;

-- get number of students of each class (only count when have more than 6 students)

SELECT c.name, COUNT(*)
FROM grades g , classes c
WHERE c.id = g.class_id
GROUP BY c.name
HAVING COUNT(*)> 6;

-- get students info who take al least 2 classes

SELECT g.student_id, s.name,COUNT(g.class_id)
FROM students s, grades g
WHERE s.id = g.student_id
GROUP BY s.name, g.student_id
HAVING COUNT(g.class_id) >=2;

-- get info of students who take all three classes

SELECT s.* -- select all column in students table
FROM grades g, students s
WHERE s.id = g.student_id
GROUP BY s.id
HAVING COUNT(g.class_id) = (SELECT COUNT(*) FROM classes)
ORDER BY s.id;

-- get courses with fail score (<60)

SELECT DISTINCT c.*
FROM classes c, grades g
WHERE c.id = g.class_id
AND g.score < 60;


--查询任何一门课程成绩在 70 分以上的学生姓名、课程名称和分数

SELECT s.name , c.name , g.score
FROM students s, classes c, grades g
WHERE s.id = g.student_id AND c.id = g.class_id
AND g.score > 70

--查询所有学生的课程及分数情况（存在学生没成绩，没选课的情况）

SELECT s.name, c.name, g.score
FROM students s LEFT JOIN grades g ON s.id = g.student_id
LEFT JOIN classes c ON c.id = g.class_id;

--查询课程名称为「math」，且分数低于 60 的学生姓名和分数

SELECT s.name, g.score
FROM students s, grades g , classes c
WHERE g.student_id = s.id
AND c.name = 'math'
AND g.class_id = c.id
AND g.score < 60
