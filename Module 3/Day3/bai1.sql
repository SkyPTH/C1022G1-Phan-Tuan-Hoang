CREATE DATABASE quan_ly_sinh_vien;
USE quan_ly_sinh_vien;
CREATE TABLE class
(
    class_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(60) NOT NULL,
    start_date DATETIME    NOT NULL,
    `status`   BIT
);
INSERT INTO class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO class
VALUES (3, 'B3', current_date, 0);
CREATE TABLE student
(
    student_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(30) NOT NULL,
    address     VARCHAR(50),
    phone       VARCHAR(20),
    `Status`      BIT,
    class_id     INT         NOT NULL,
    FOREIGN KEY (class_id) REFERENCES class (class_id)
);
INSERT INTO student (student_name, address, phone, `status`, class_id)
VALUES ('Phan Van Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (student_name, address, `status`, class_id)
VALUES ('Nguyen Thi Hoa', 'Hai phong', 1, 1);
INSERT INTO student (student_name, address, phone, `status`, class_id)
VALUES ('Nong Duc Manh', 'HCM', '0123123123', 0, 2);
CREATE TABLE `subject`
(
    sub_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_name VARCHAR(30) NOT NULL,
    credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    `status`  BIT                  DEFAULT 1
);
INSERT INTO `subject`
VALUES (5, 'CF', 2, 1),
       (6, 'C', 3, 1),
       (7, 'HDJ', 4, 1),
       (8, 'RDBMS', 7, 1);
CREATE TABLE mark
(
    mark_id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_id     INT NOT NULL,
    student_id INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    exam_times TINYINT DEFAULT 1,
    UNIQUE (sub_id, student_id),
    FOREIGN KEY (sub_id) REFERENCES Subject (sub_id),
    FOREIGN KEY (student_id) REFERENCES Student (student_id)
);
INSERT INTO mark (sub_id, student_id, mark, exam_times)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
select * from student where substring_index(student_name," ",-1) like "h%" ;    
select * from class where month(start_date)  = 12;
select * from `subject` where credit>=3 and credit<=5;
update student set class_id = 2 where student_name like "hung";
select * from student;