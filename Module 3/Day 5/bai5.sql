-- Tao index cho cột  title của bảng books
use library;
create index tit on book(tittle);
-- Tạo 1 view để lấy ra danh sách các quyển sách đã được mượn, có hiển thị thêm cột số lần đã được mượn
create view borrow_book as select count(borrow.borrow_id) as 'Số lần mượn',borrow.book_id,book.`name` from borrow 
join book on borrow.book_id= book.book_id group by borrow.book_id;
select * from borrow_book;
drop view borrow_book;
-- Viết 1 stored procedure thêm mới book trong database với tham số kiểu IN
DELIMITER && 
create procedure add_book (
in `name` varchar(50),
in tittle varchar (50),
in page_size int,
in category_id int,
in author_id int)
begin 
insert into book(`name`,tittle, page_size, author_id, category_id ) values (`name`,tittle, page_size, author_id, category_id );
END &&  
DELIMITER ; 
call add_book ('Harry','sách',2,2,2 );
drop procedure add_book;
select * from book;