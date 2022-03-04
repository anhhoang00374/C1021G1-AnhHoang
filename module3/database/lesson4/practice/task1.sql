use quan_ly_sinh_vien;
SELECT Address, COUNT(student_id) AS 'Số lượng học viên'
FROM Student
GROUP BY Address;


SELECT S.student_id,S.student_name, AVG(Mark)
FROM Student S join Mark M on S.student_id = M.student_id
GROUP BY S.student_id, S.student_name;

SELECT S.Student_Id,S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name
HAVING AVG(Mark) > 15;

SELECT S.Student_Id, S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.Student_Id);