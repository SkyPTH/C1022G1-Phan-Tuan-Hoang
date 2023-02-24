use library;
INSERT INTO category (`name` ) VALUES ('Tự nhiên ');
INSERT INTO category (`name` ) VALUES ('Xã Hội ');
INSERT INTO category (`name` ) VALUES ('Truyện ');
INSERT INTO category (`name` ) VALUES ('Tiểu Thuyết ');
INSERT INTO category (`name` ) VALUES ('Khác ');
INSERT INTO author (`name` ) VALUES ('Nguyễn Thái Học ');
INSERT INTO author (`name`) VALUES ('Trần Mình Hoàng ');
INSERT INTO author (`name`) VALUES ('Dương Trung Quốc ');
INSERT INTO author (`name`) VALUES ('Lê Văn Hiến ');
INSERT INTO author (`name`) VALUES ('Hà Văn Minh ');
INSERT INTO student (`name`, birthday, class_name ) VALUES ('Nguyễn Văn A', '12-12-1999', 'C0822G1 ');
INSERT INTO student (`name`, birthday, class_name ) VALUES ('Nguyễn Văn B', '12-13-1999', 'C0822G1 ');
INSERT INTO student (`name`, birthday, class_name ) VALUES ('Nguyễn Văn C', '12-14-1999', 'C0822G1 ');
INSERT INTO student (`name`, birthday, class_name ) VALUES ('Nguyễn Văn D', '12-15-1999', 'C0922G1 ');
INSERT INTO student (`name`, birthday, class_name ) VALUES ('Nguyễn Văn E', '12-16-1999', 'C1022G1 ');
INSERT INTO book (`name`, page_size, author_id, category_id ) VALUES ('Toán', 45, 1, 1 );
INSERT INTO book (`name`, page_size, author_id, category_id ) VALUES ('Văn', 34, 2, 2 );
INSERT INTO book (`name`, page_size, author_id, category_id ) VALUES ('Sử', 56, 3, 2 );
INSERT INTO book (`name`, page_size, author_id, category_id ) VALUES ('Địa', 76,4, 2 );
INSERT INTO book (`name`, page_size, author_id, category_id ) VALUES ('Hoá', 32, 5, 1 );
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (1, 1, '12-12-2022', '12-13-2022' );
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (2, 2, '12-12-2022', '12-15-2022' );
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (3, 3, '12-12-2022', '12-15-2022' );
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (4, 4, '12-12-2022', '12-12-2022 ');
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (1, 5, '12-13-2022', '12-15-2022 ');
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (1, 5, '12-14-2022', '12-14-2022 ');
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (3, 4, '12-15-2022', '12-29-2022 ');
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (3, 3, '12-8-2022', '12-14-2022 ');
INSERT INTO borrow (student_id, book_id, borrow_day, return_day ) VALUES (1, 2, '12-6-2022', '12-30-2022 ');

-- Lấy ra toàn bộ sách có trong thư viện, cùng với tên thể loại và tác giả
select book.`name`, page_size, c.`name`,a.`name` from book 
left join category c on book.category_id=c.category_id
left join author a on book.author_id=a.author_id  ;
-- Lấy ra danh sách các học viên đã từng mượn sách và sắp xếp danh sách theo theo tên từ a->z
select s.name from  student s join borrow b on s.student_id=b.student_id group by s.`name` order by s.`name`;
-- Lấy ra  2 quyển sách được mượn nhiều nhất
select book.`name`,count(b.book_id) from book join  borrow b on book.book_id=b.book_id group by b.book_id order by count(b.book_id) desc limit 2 ;