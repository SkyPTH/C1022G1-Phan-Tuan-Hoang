use library;
-- Thông kê các đầu sách được mượn nhiều nhất
select book.`name`,count(b.book_id) as 'Số lần mượn' from book join  borrow b on book.book_id=b.book_id group by  b.book_id 
having count(b.book_id) = (select max(book_count) from (select count(borrow.book_id) as book_count  from  borrow group by book_id) as book_counts);
-- Thông kê các đầu sách chưa được mượn
select * from book left join borrow b on book.book_id=b.book_id 
where b.book_id not in (select b.book_id from borrow b where curdate() between b.borrow_day and b.return_day)
group by  b.book_id ;
-- Lấy ra danh sách các học viên đã từng mượn sách và sắp xếp  theo số lượng mượn sách từ lớn đến nhỏ
select s.student_id,s.`name`,count(b.student_id) as 'Số lần mượn' from student s join borrow b on s.student_id=b.student_id
 group by b.student_id order by count(b.student_id) desc;
 -- Lấy ra các học viên mượn sách nhiều nhất của thư viện
 select s.student_id,s.`name`,count(b.student_id) as 'Số lần mượn' from student s join borrow b on s.student_id=b.student_id
 group by b.student_id 
 having count(b.student_id) = (select max(count_borrow) from (select count(b.student_id) as count_borrow from borrow b group by b.student_id) as max_borrow) ;