USE quan_ly_sinh_vien;


SELECT * FROM student
WHERE student_name LIKE "h%";

SELECT * FROM class 
WHERE MONTH(start_date) = 12;

SELECT * FROM subject 
WHERE credit BETWEEN 3 AND 5;

UPDATE student 
SET class_id = 2
WHERE student_name = "Hung";

SELECT student.student_name, `subject`.sub_name, mark.mark 
FROM student 
INNER JOIN mark 
ON student.student_id = mark.student_id 
INNER JOIN `subject` 
ON mark.sub_id = `subject`.sub_id
ORDER BY mark DESC, student.student_name ASC;