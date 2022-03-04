use quan_ly_sinh_vien;

SELECT * FROM `subject`
WHERE credit = (SELECT  MAX(credit) FROM `subject`);

SELECT `subject`.*, mark. mark as so_diem FROM
`subject` INNER JOIN mark 
ON mark.sub_id = `subject`.sub_id AND mark.mark = (SELECT  MAX(mark) FROM mark);

SELECT student.*,AVG(mark) AS diem_trung_binh
FROM student LEFT JOIN mark 
ON student.student_id = mark.student_id
GROUP BY student.student_id
ORDER BY diem_trung_binh DESC;

