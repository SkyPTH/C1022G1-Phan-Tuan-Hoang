drop schema case_study;
create schema case_study;
use case_study;
CREATE TABLE vi_tri (
    ma_vi_tri INT AUTO_INCREMENT,
    ten_vi_tri VARCHAR(45),
    PRIMARY KEY (ma_vi_tri)
);
CREATE TABLE trinh_do (
    ma_trinh_do INT auto_increment,
    ten_trinh_do VARCHAR(45),
    PRIMARY KEY (ma_trinh_do)
);
CREATE TABLE bo_phan (
    ma_bo_phan INT AUTO_INCREMENT,
    ten_bo_phan VARCHAR(45),
    PRIMARY KEY (ma_bo_phan)
);
CREATE TABLE nhan_vien (
    ma_vi_tri INT ,
    ma_trinh_do INT,
    ma_bo_phan INT,
    ma_nhan_vien INT auto_increment,
    ho_ten VARCHAR(45),
    ngay_sinh DATE,
    so_cmnd VARCHAR(45),
    luong DOUBLE,
    so_dien_thoai VARCHAR(45),
    dia_chi VARCHAR(45),
    CONSTRAINT ma_vi_tri FOREIGN KEY (ma_vi_tri)
        REFERENCES vi_tri (ma_vi_tri),
    CONSTRAINT ma_trinh_do FOREIGN KEY (ma_trinh_do)
        REFERENCES trinh_do (ma_trinh_do),
    CONSTRAINT ma_bo_phan FOREIGN KEY (ma_bo_phan)
        REFERENCES bo_phan (ma_bo_phan),
    PRIMARY KEY (ma_nhan_vien)
);
alter table nhan_vien add email varchar(45);
CREATE TABLE loai_khach (
    ma_loai_khach INT AUTO_INCREMENT,
    ten_loai_khach VARCHAR(45),
    PRIMARY KEY (ma_loai_khach)
);
CREATE TABLE khach_hang (
    ma_khach_hang INT AUTO_INCREMENT,
    ma_loai_khach INT,
    ho_ten VARCHAR(45),
    so_cmnd VARCHAR(45),
    so_dien_thoai VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    PRIMARY KEY (ma_khach_hang),
    CONSTRAINT ma_loai_khach FOREIGN KEY (ma_loai_khach)
        REFERENCES loai_khach (ma_loai_khach)
);
alter table khach_hang add ngay_sinh date;
alter table khach_hang add gioi_tinh bit(1);
CREATE TABLE loai_dich_vu (
    ma_loai_dich_vu INT AUTO_INCREMENT,
    ten_loai_dich_vu VARCHAR(45),
    PRIMARY KEY (ma_loai_dich_vu)
);
CREATE TABLE kieu_thue (
    ma_kieu_thue INT AUTO_INCREMENT,
    ten_kieu_thue VARCHAR(45),
    PRIMARY KEY (ma_kieu_thue)
);
CREATE TABLE dich_vu (
    ma_dich_vu INT AUTO_INCREMENT,
    ten_dich_vu VARCHAR(45),
    dien_tich INT,
    chi_phi_thue DOUBLE,
    so_nguoi_toi_da INT,
    ma_kieu_thue INT,
    ma_loai_dich_vu INT,
    tieu_chuan_phong VARCHAR(45),
    mo_ta_tien_nghi_khac VARCHAR(45),
    dien_tich_ho_boi DOUBLE,
    so_tang INT,
    dich_vu_mien_phi_di_kem TEXT,
    PRIMARY KEY (ma_dich_vu),
    CONSTRAINT ma_kieu_thue FOREIGN KEY (ma_kieu_thue)
        REFERENCES kieu_thue (ma_kieu_thue),
    CONSTRAINT ma_loai_dich_vu FOREIGN KEY (ma_loai_dich_vu)
        REFERENCES loai_dich_vu (ma_loai_dich_vu)
);
CREATE TABLE hop_dong (
    ma_hop_dong INT AUTO_INCREMENT,
    ngay_lam_hop_dong DATETIME,
    ngay_ket_thuc DATETIME,
    tien_dat_coc DOUBLE,
    ma_nhan_vien INT,
    ma_khach_hang INT,
    ma_dich_vu INT,
    PRIMARY KEY (ma_hop_dong),
    CONSTRAINT ma_nhan_vien FOREIGN KEY (ma_nhan_vien)
        REFERENCES nhan_vien (ma_nhan_vien),
    CONSTRAINT ma_khach_hang FOREIGN KEY (ma_khach_hang)
        REFERENCES khach_hang (ma_khach_hang),
    CONSTRAINT ma_dich_vu FOREIGN KEY (ma_dich_vu)
        REFERENCES dich_vu (ma_dich_vu)
);

CREATE TABLE dich_vu_di_kem (
    ma_dich_vu_di_kem INT AUTO_INCREMENT,
    ten_dich_vu_di_kem VARCHAR(45),
    gia DOUBLE,
    don_vi VARCHAR(45),
    trang_thai VARCHAR(45),
    PRIMARY KEY (ma_dich_vu_di_kem)
);

CREATE TABLE hop_dong_chi_tiet (
    ma_hop_dong_chi_tiet INT AUTO_INCREMENT,
    ma_hop_dong INT,
    ma_dich_vu_di_kem INT,
    so_luong INT,
    PRIMARY KEY (ma_hop_dong_chi_tiet),
    CONSTRAINT ma_hop_dong FOREIGN KEY (ma_hop_dong)
        REFERENCES hop_dong (ma_hop_dong),
    CONSTRAINT ma_dich_vu_di_kem FOREIGN KEY (ma_dich_vu_di_kem)
        REFERENCES dich_vu_di_kem (ma_dich_vu_di_kem)
);
-- NHẬP DỮ LIỆU VÀO BẢNG

-- Vị trí
insert into vi_tri (ten_vi_tri) values ('Quản lý'),('Nhân viên');

-- Trình độ
insert into trinh_do (ten_trinh_do) values ('Trung Cấp'),('Cao Đẳng'),('Đại Học'),('Sau Đại Học');

-- Bộ phận
insert into bo_phan (ten_bo_phan) values ('Sale-Marketing'),('Hành chính'),('Phục vụ'),('Quản lý');

-- Nhân viên
insert into nhan_vien (ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan) values 
('Nguyễn Văn An', '1970-11-07', '456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1),
('Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
('Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
('Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
('Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
('Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
('Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
('Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
('Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
('Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);
-- Loại khách
insert into loai_khach (ten_loai_khach) values ('Diamond'),('Platinium'),('Gold'),('Silver'),('Member');
-- Khách hàng
insert into khach_hang (ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi, ma_loai_khach) values 
('Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5),
('Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3),
('Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1),
('Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1),
('Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4),
('Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4),
('Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1),
('Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3),
('Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1),
('Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 2);

-- Loại dịch vụ
insert into loai_dich_vu (ten_loai_dich_vu) values ('Villa'),('House'),('Room');
-- Kiểu thuê
insert into kieu_thue (ten_kieu_thue) values ('year'),('month'),('day'),('hour');

-- Dịch vụ
insert into dich_vu (ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, tieu_chuan_phong,
 mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, dich_vu_mien_phi_di_kem, ma_kieu_thue, ma_loai_dich_vu) values 
('Villa Beach Front', 25000, 1000000, 10, 'vip', 'Có hồ bơi', 500, 4, null, 3, 1),
('House Princess 01', 14000, 5000000, 7, 'vip', 'Có thêm bếp nướng', null, 3, null, 2, 2),
('Room Twin 01', '5000', 1000000, 2, 'normal', 'Có tivi', null, null, '1 Xe máy, 1 Xe đạp', 4, 3),
('Villa No Beach Front', 22000, 9000000, 8, 'normal', 'Có hồ bơi', 300, 3, null, 3, 1),
('House Princess 02', 10000, 4000000, 5, 'normal', 'Có thêm bếp nướng', null, 2, null, 3, 2),
('Room Twin 02', 3000, 900000, 2, 'normal', 'Có tivi', null, null, '1 Xe máy', 4, 3);

-- Dịch vụ đi kèm
insert into dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi, trang_thai) values 
('Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
('Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
('Thuê xe đạp', 20000, 'chiếc', 'tốt'),
('Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
-- Hợp đồng
insert into hop_dong (ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu) values 
('2020-12-08', '2020-12-08', 0, 3, 1, 3),
('2020-07-14', '2020-07-21', 200000, 7, 3, 1),
('2021-03-15', '2021-03-17', 50000, 3, 4, 2),
('2021-01-14', '2021-01-18', 100000, 7, 5, 5),
('2021-07-14', '2021-07-15', 0, 7, 2, 6),
('2021-06-01', '2021-06-03', 0, 7, 7, 6),
('2021-09-02', '2021-09-05', 100000, 7, 4, 4),
('2021-06-17', '2021-06-18', 150000, 3, 4, 1),
('2020-11-19', '2020-11-19', 0, 3, 4, 3),
('2021-04-12', '2021-04-14', '0', '10', '3', '5'),
('2021-04-25', '2021-04-25', '0', '2', '2', '1'),
('2021-05-25', '2021-05-27', '0', '7', '10', '1');
-- Hợp đồng chi tiết
insert into hop_dong_chi_tiet (so_luong, ma_hop_dong, ma_dich_vu_di_kem) values 
(5, 2, 4),(8, 2, 5),(15, 2, 6),(1, 3, 1),(11, 3, 2),(1, 1, 3),(2, 1, 2),(2, 12, 2);
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien 
where 
(substring_index(ho_ten, ' ', -1) like 'H%'
or substring_index(ho_ten, ' ', -1) like 'K%'
or substring_index(ho_ten, ' ', -1) like 'T%')
and length(ho_ten) <= 15;
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”
select * from khach_hang
where ((year(curdate())-year(ngay_sinh)) between 18 and 50)
and (dia_chi like '% Quảng Trị'
or dia_chi like '% Đà Nẵng')
;
-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select ho_ten,count(khach_hang.ma_khach_hang) as 'Số lần ký hợp đồng', ten_loai_khach from khach_hang

join loai_khach on loai_khach.ma_loai_khach=khach_hang.ma_loai_khach
where ten_loai_khach='Diamond'
group by khach_hang.ma_khach_hang
order by count(khach_hang.ma_khach_hang);
-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,
sum(ifnull(dv.chi_phi_thue, 0) + ifnull(hdct.so_luong, 0) * ifnull(dvdk.gia, 0)) as 'tong_tien' 
from khach_hang kh
left join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by ma_hop_dong, ma_khach_hang;
-- 6.Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu as dv
join loai_dich_vu as ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where dv.ma_dich_vu not in (select hd.ma_dich_vu
from hop_dong as hd
where month(hd.ngay_lam_hop_dong) between 1 and 3
and year(hd.ngay_lam_hop_dong) like 2021)
group by dv.ten_dich_vu;

-- 7. Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.

select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where dv.ma_dich_vu in (select hd.ma_dich_vu from hop_dong hd where year(hd.ngay_lam_hop_dong) = 2020) 
and  dv.ma_dich_vu not in (select hd.ma_dich_vu from hop_dong hd where year(hd.ngay_lam_hop_dong) = 2021)
group by dv.ma_dich_vu;

-- 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.

-- cách 1:
select ho_ten from khach_hang
group by ho_ten;

-- cách 2:
select distinct ho_ten 
from khach_hang;

-- cách 3:
select kh.ho_ten 
from khach_hang kh
union 
select kh.ho_ten 
from khach_hang kh;


-- 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(hd.ngay_lam_hop_dong) as thang, 
  count(hd.ma_khach_hang) as so_khach_dat_phong
from hop_dong hd
where year(hd.ngay_lam_hop_dong) = 2021 
group by thang 
order by thang;

-- 10. Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm.
--  Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, 
sum(ifnull(so_luong, 0)) as so_luong_dich_vu_di_kem 
from hop_dong hd
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong 
group by hd.ma_hop_dong;
-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
 select dvdk.ma_dich_vu_di_kem,ten_dich_vu_di_kem from dich_vu_di_kem dvdk
 join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
 join hop_dong hd on hdct.ma_hop_dong=hd.ma_hop_dong
 join khach_hang kh on hd.ma_khach_hang=kh.ma_khach_hang
 join loai_khach on kh.ma_loai_khach=loai_khach.ma_loai_khach
 where loai_khach.ten_loai_khach= 'Diamond' and kh.dia_chi like '% Vinh' or '% Quảng Ngãi';
 -- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem),
 -- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
 select hd.ma_hop_dong,nv.ho_ten as 'Họ tên nhân viên',kh.ho_ten as 'Họ tên khách hàng',kh.so_dien_thoai,dv.ten_dich_vu,ifnull(sum(so_luong),0) as 'Số lượng dịch vụ đi kèm',hd.tien_dat_coc
 from hop_dong hd
join dich_vu dv on hd.ma_dich_vu=dv.ma_dich_vu
join nhan_vien nv on nv.ma_nhan_vien=hd.ma_nhan_vien
join khach_hang kh on kh.ma_khach_hang=hd.ma_khach_hang
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong=hd.ma_hop_dong
where (ngay_lam_hop_dong between '2020-10-1' and '2020-12-31') and
  (ngay_lam_hop_dong not between '2021-1-1' and '2021-6-30')
group by hd.ma_hop_dong;
 -- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau)

 -- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
 -- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem)
 select hd.ma_hop_dong, dv.ten_dich_vu, dvdk.ten_dich_vu_di_kem, count(hdct.ma_dich_vu_di_kem) as so_lan_su_dung from hop_dong hd 
 inner join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
 inner join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
 inner join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
 group by dvdk.ma_dich_vu_di_kem
 having count(hdct.ma_dich_vu_di_kem) = 1
 order by hd.ma_hop_dong;
 -- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm 
 -- ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
 select ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
 from nhan_vien nv 
 left join trinh_do on trinh_do.ma_trinh_do=nv.ma_trinh_do
 left join bo_phan on bo_phan.ma_bo_phan=nv.ma_bo_phan
group by nv.ma_nhan_vien
having count(year(hop_dong.ngay_lam_hop_dong) between 2020 and 2021 )<4;
 -- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
 delete from nhan_vien nv
 where nv.ma_nhan_vien not in 
 (select hop_dong.ma_nhan_vien from hop_dong 
 where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021);
 select * from nhan_vien;
 -- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với 
 -- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
 
 -- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
SET foreign_key_checks = 0;
delete from khach_hang 
where ma_khach_hang in (
    select ma_khach_hang 
    from hop_dong 
    where year(ngay_lam_hop_dong) < 2021
);
select * from khach_hang;
 -- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
 update dich_vu_di_kem dvdk 
 join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
 join hop_dong hd on hd.ma_hop_dong=hdct.ma_hop_dong
 set gia= gia*2
 where (select year(hd.ngay_lam_hop_dong)=2020
 and SUM(hdct.so_luong)  > 10);
 select * from dich_vu_di_kem;
 select * from hop_dong_chi_tiet;
 -- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm 
 -- id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select ma_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from nhan_vien
union
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from khach_hang;