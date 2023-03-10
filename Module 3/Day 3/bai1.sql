use library;
INSERT INTO category (category_name ) VALUES ('Tự nhiên ');
INSERT INTO category (category_name ) VALUES ('Xã Hội ');
INSERT INTO category (category_name ) VALUES ('Truyện ');
INSERT INTO category (category_name ) VALUES ('Tiểu Thuyết ');
INSERT INTO category (category_name ) VALUES ('Khác ');
INSERT INTO author (author_name ) VALUES ('Nguyễn Thái Học ');
INSERT INTO author (author_name) VALUES ('Trần Mình Hoàng ');
INSERT INTO author (author_name) VALUES ('Dương Trung Quốc ');
INSERT INTO author (author_name) VALUES ('Lê Văn Hiến ');
INSERT INTO author (author_name) VALUES ('Hà Văn Minh ');
INSERT INTO student (`name`, birthday, class_name ) VALUES ('Nguyễn Văn A', '1999-12-12', 'C0822G1 ');
INSERT INTO student (`name`, birthday, class_name ) VALUES ('Nguyễn Văn B', '1999-12-13', 'C0822G1 ');
INSERT INTO student (`name`, birthday, class_name ) VALUES ('Nguyễn Văn C', '1999-12-14', 'C0822G1 ');
INSERT INTO student (`name`, birthday, class_name ) VALUES ('Nguyễn Văn D', '1999-12-15', 'C0922G1 ');
INSERT INTO student (`name`, birthday, class_name ) VALUES ('Nguyễn Văn E', '1999-12-16', 'C1022G1 ');
INSERT INTO book (`name`, page_size, author_id, category_id ) VALUES ('Toán', 45, 1, 1 );
INSERT INTO book (`name`, page_size, author_id, category_id ) VALUES ('Văn', 34, 2, 2 );
INSERT INTO book (`name`, page_size, author_id, category_id ) VALUES ('Sử', 56, 3, 2 );
INSERT INTO book (`name`, page_size, author_id, category_id ) VALUES ('Địa', 76,4, 2 );
INSERT INTO book (`name`, page_size, author_id, category_id ) VALUES ('Hoá', 32, 5, 1 );
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (1, 1, '2022-12-12', '2022-12-13' );
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (2, 2, '2022-12-12', '2022-12-15' );
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (3, 3, '2022-12-12', '2022-12-15' );
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (4, 4, '2022-12-12', '2022-12-12');
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (1, 5, '2022-12-13', '2022-12-15');
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (1, 5, '2022-12-14', '2022-12-14');
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (3, 4, '2022-12-15', '2022-12-29');
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (3, 3, '2022-8-12', '2022-12-14');
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (1, 2, '2022-8-12', '2022-12-30');
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (1, 2, '2022-8-12', '2024-12-30');
SELECT book_id, book.name, book.tittle, book.page_size,c.category_name, book.author_id from book join category c on c.category_id = book.category_id;
-- Lấy ra toàn bộ sách có trong thư viện, cùng với tên thể loại và tác giả
select book.`name`, page_size, c.`name`,a.`name` from book 
left join category c on book.category_id=c.category_id
left join author a on book.author_id=a.author_id  ;
-- Lấy ra danh sách các học viên đã từng mượn sách và sắp xếp danh sách theo theo tên từ a->z
select s.name from  student s join borrow b on s.student_id=b.student_id group by s.`name` order by s.`name`;
-- Lấy ra  2 quyển sách được mượn nhiều nhất
select book.`name`,count(b.book_id) as `Số lần mượn` from book join  borrow b on book.book_id=b.book_id group by b.book_id order by count(b.book_id) desc limit 2 ;