USE casestudy_furama;
-- Truy vấn dữ liệu Furama
-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT 
    *
FROM
    nhan_vien
WHERE
    (SUBSTRING_INDEX(ho_ten, ' ', - 1) LIKE 'H%'
        OR SUBSTRING_INDEX(ho_ten, ' ', - 1) LIKE 'Y%'
        OR SUBSTRING_INDEX(ho_ten, ' ', - 1) LIKE 'K%')
        AND LENGTH(ho_ten) <= 16;
-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT 
    *
FROM
    khach_hang
WHERE
    (dia_chi LIKE '% Đà Nẵng'
        OR dia_chi LIKE '% Quảng Trị')
        AND (YEAR(CURDATE()) - YEAR(ngay_sinh) BETWEEN 18 AND 50);
-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”
SELECT 
    khach_hang.ma_khach_hang,
    ho_ten,
    COUNT(hop_dong.ma_khach_hang) so_lan_dat_phong
FROM
    khach_hang
        JOIN
    hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        JOIN
    loai_khach ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
WHERE
    ten_loai_khach = 'Diamond'
GROUP BY hop_dong.ma_khach_hang
ORDER BY so_lan_dat_phong;
-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, 
-- tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, 
-- với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. 
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
set sql_mode=(select replace(@@sql_mode,'ONLY_FULL_GROUP_BY','

'));
SELECT 
    khach_hang.ma_khach_hang,
    ho_ten,
    ten_loai_khach,
    hop_dong.ma_hop_dong,
    ten_dich_vu,
    ngay_lam_hop_dong,
    ngay_ket_thuc,
    SUM((dich_vu.chi_phi_thue + IFNULL((hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia),
            0))) 'Tổng tiền'
FROM
    khach_hang
        LEFT JOIN
    loai_khach ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
        LEFT JOIN
    hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        LEFT JOIN
    dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY ma_hop_dong , khach_hang.ma_khach_hang
ORDER BY khach_hang.ma_khach_hang;
-- 6.Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, 
-- ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
SELECT 
    ma_dich_vu,
    ten_dich_vu,
    dien_tich,
    chi_phi_thue,
    ten_loai_dich_vu
FROM
    dich_vu dv
        JOIN
    loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
WHERE
    dv.ma_dich_vu NOT IN (SELECT 
            ma_dich_vu
        FROM
            hop_dong
        WHERE
            (QUARTER(ngay_lam_hop_dong) = 1)
                AND (YEAR(ngay_lam_hop_dong) = 2021))
GROUP BY dv.ma_dich_vu;
-- 7.Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, 
-- ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
SELECT 
    ma_dich_vu,
    ten_dich_vu,
    dien_tich,
    so_nguoi_toi_da,
    chi_phi_thue,
    ten_loai_dich_vu
FROM
    dich_vu dv
        JOIN
    loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
WHERE
    dv.ma_dich_vu NOT IN (SELECT 
            ma_dich_vu
        FROM
            hop_dong
        WHERE
            (YEAR(ngay_lam_hop_dong) = 2021))
        AND dv.ma_dich_vu IN (SELECT 
            ma_dich_vu
        FROM
            hop_dong
        WHERE
            (YEAR(ngay_lam_hop_dong) = 2020));
-- 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
SELECT DISTINCT
    ho_ten
FROM
    khach_hang;
SELECT 
    ho_ten
FROM
    khach_hang
GROUP BY ho_ten;
SELECT 
    ho_ten
FROM
    khach_hang 
UNION SELECT 
    ho_ten
FROM
    khach_hang;
-- 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
SELECT 
    MONTH(ngay_lam_hop_dong) thang, COUNT(*) so_luong_khach_hang
FROM
    hop_dong
WHERE
    YEAR(ngay_lam_hop_dong) = 2021
GROUP BY thang
ORDER BY thang;
-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, 
-- ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
SELECT 
    hd.ma_hop_dong,
    ngay_lam_hop_dong,
    ngay_ket_thuc,
    tien_dat_coc,
    IFNULL(SUM(so_luong), 0) so_luong_dich_vu_di_kem
FROM
    hop_dong hd
        LEFT JOIN
    hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
GROUP BY hd.ma_hop_dong;
-- 11.Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
SELECT 
    dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
FROM
    khach_hang kh
        JOIN
    loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
        JOIN
    hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
        JOIN
    hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
        JOIN
    dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
WHERE
    lk.ten_loai_khach = 'Diamond'
        AND kh.dia_chi LIKE '% Vinh'
        OR '% Quảng Ngãi';
 -- 12.Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), 
SELECT 
    hd.ma_hop_dong,
    nv.ho_ten,
    kh.ho_ten,
    kh.so_dien_thoai,
    dv.ten_dich_vu,
    IFNULL(SUM(so_luong), 0) so_luong_dich_vu_di_kem,
    tien_dat_coc
FROM
    hop_dong hd
        LEFT JOIN
    nhan_vien nv ON hd.ma_nhan_vien = nv.ma_nhan_vien
        LEFT JOIN
    khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
        LEFT JOIN
    dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
WHERE
    (QUARTER(ngay_lam_hop_dong) = 4
        AND YEAR(ngay_lam_hop_dong) = 2020)
        AND hd.ma_hop_dong NOT IN (MONTH(ngay_lam_hop_dong) BETWEEN 1 AND 6
        AND YEAR(ngay_lam_hop_dong) = 2021)
GROUP BY hd.ma_hop_dong;
-- 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
SELECT 
    dvdk.ma_dich_vu_di_kem,
    ten_dich_vu_di_kem,
    IFNULL(SUM(so_luong), 0) so_luong_dich_vu_chi_tiet
FROM
    dich_vu_di_kem dvdk
        JOIN
    hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY dvdk.ma_dich_vu_di_kem
HAVING so_luong_dich_vu_chi_tiet = (SELECT 
        MAX(so_luong)
    FROM
        hop_dong_chi_tiet);
-- 14.Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
set sql_mode=(select replace(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
SELECT 
    hd.ma_hop_dong,
    ten_loai_dich_vu,
    ten_dich_vu_di_kem,
    COUNT(hdct.ma_dich_vu_di_kem) so_lan_su_dung
FROM
    hop_dong hd
        JOIN
    dich_vu dv ON dv.ma_dich_vu = hd.ma_dich_vu
        JOIN
    loai_dich_vu ldv ON ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
        JOIN
    hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
        JOIN
    dich_vu_di_kem dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY hdct.ma_dich_vu_di_kem
HAVING so_lan_su_dung = 1
ORDER BY hd.ma_hop_dong;
-- 15.Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, 
-- dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
SELECT 
    nv.ma_nhan_vien,
    ho_ten,
    ten_trinh_do,
    ten_bo_phan,
    so_dien_thoai,
    dia_chi,
    COUNT(hd.ma_hop_dong) so_lan_su_dung
FROM
    hop_dong hd
        JOIN
    nhan_vien nv ON nv.ma_nhan_vien = hd.ma_nhan_vien
        JOIN
    trinh_do td ON td.ma_trinh_do = nv.ma_trinh_do
        JOIN
    bo_phan bp ON bp.ma_bo_phan = nv.ma_bo_phan
GROUP BY hd.ma_nhan_vien
HAVING so_lan_su_dung < 4;
-- 16.Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
DELETE FROM nhan_vien 
WHERE
    ma_nhan_vien NOT IN (SELECT 
        ma_nhan_vien
    FROM
        hop_dong
    
    WHERE
        YEAR(ngay_lam_hop_dong) BETWEEN 2019 AND 2021);
-- select ho_ten from nhan_vien
-- 17.Cập nhật thông tin những khách hàng có ten_loai_khach từ Platininum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 1.000.000 VNĐ.
CREATE VIEW view_tong_tien AS
    SELECT 
        kh.ma_khach_hang,
        lk.ten_loai_khach,
        SUM(IFNULL(dv.chi_phi_thue, 0) + IFNULL(hdct.so_luong, 0) * IFNULL(dvdk.gia, 0)) tong_tien
    FROM
        khach_hang kh
            JOIN
        loai_khach lk ON lk.ma_loai_khach = kh.ma_loai_khach
            JOIN
        hop_dong hd ON hd.ma_khach_hang = kh.ma_khach_hang
            JOIN
        dich_vu dv ON dv.ma_dich_vu = hd.ma_dich_vu
            JOIN
        hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
            JOIN
        dich_vu_di_kem dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
    WHERE
        lk.ten_loai_khach = 'Platinium'
            AND YEAR(ngay_lam_hop_dong) = 2021
    GROUP BY lk.ma_loai_khach , kh.ma_khach_hang;

UPDATE khach_hang 
SET 
    ma_loai_khach = 1
WHERE
    ma_khach_hang = (SELECT 
            v_tong_tien.ma_khach_hang
        FROM
            v_tong_tien
        WHERE
            v_tong_tien.tong_tien > '1000000'
                AND ten_loai_khach = 'Platinium');

SELECT 
    kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach
FROM
    khach_hang kh
        JOIN
    loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE
    kh.ho_ten = 'Nguyễn Tâm Đắc';
-- 18.Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
set foreign_key_checks = 0;
DELETE FROM khach_hang 
WHERE
    ma_khach_hang IN (SELECT 
        ma_khach_hang
    FROM
        hop_dong
    
    WHERE
        YEAR(ngay_lam_hop_dong) < 2021);
SELECT 
    ma_khach_hang, ho_ten
FROM
    khach_hang;
-- 19.Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi
UPDATE dich_vu_di_kem 
SET 
    gia = gia * 2
WHERE
    ma_dich_vu_di_kem IN (SELECT 
            hdct.ma_dich_vu_di_kem
        FROM
            hop_dong_chi_tiet hdct
                JOIN
            hop_dong hd ON hd.ma_hop_dong = hdct.ma_hop_dong
        WHERE
            YEAR(hd.ngay_lam_hop_dong) = 2020
        GROUP BY ma_dich_vu_di_kem
        HAVING IFNULL(SUM(so_luong), 0) > 10);
-- select * from dich_vu_di_kem;
-- 20.Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống,
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
SELECT 
    ma_nhan_vien,
    ho_ten,
    email,
    so_dien_thoai,
    ngay_sinh,
    dia_chi
FROM
    nhan_vien 
UNION ALL SELECT 
    ma_khach_hang,
    ho_ten,
    email,
    so_dien_thoai,
    ngay_sinh,
    dia_chi
FROM
    khach_hang
    