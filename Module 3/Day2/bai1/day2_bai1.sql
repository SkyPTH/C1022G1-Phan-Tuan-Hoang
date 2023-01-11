CREATE SCHEMA chuyen_doi;
USE chuyen_doi;
CREATE TABLE phieu_xuat (
    so_px INT PRIMARY KEY,
    ngay_xuat DATE
);
CREATE TABLE vat_tu (
    ma_vt INT PRIMARY KEY,
    ten_vt VARCHAR(50)
);
CREATE TABLE chi_tiet_phieu_xuat (
    dg_xuat INT,
    sl_xuat INT,
    so_px INT,
    ma_vt INT,
    PRIMARY KEY (so_px , ma_vt),
    FOREIGN KEY (so_px)
        REFERENCES phieu_xuat (so_px),
    FOREIGN KEY (ma_vt)
        REFERENCES vat_tu (ma_vt)
);
CREATE TABLE phieu_nhap (
    so_pn INT PRIMARY KEY,
    ngay_nhap DATE
);
CREATE TABLE chi_tiet_phieu_nhap (
    dg_nhap INT,
    sl_nhap INT,
    so_pn INT,
    ma_vt INT,
    PRIMARY KEY (so_pn , ma_vt),
    FOREIGN KEY (so_pn)
        REFERENCES phieu_nhap (so_pn),
    FOREIGN KEY (ma_vt)
        REFERENCES vat_tu (ma_vt)
);
CREATE TABLE nha_cung_cap (
    ma_ncc INT PRIMARY KEY,
    ten_ncc VARCHAR(50),
    dia_chi VARCHAR(50)
);
CREATE TABLE sdt (
    so_dien_thoai VARCHAR(50) PRIMARY KEY,
    ma_ncc INT,
    FOREIGN KEY (ma_ncc)
        REFERENCES nha_cung_cap (ma_ncc)
);
CREATE TABLE don_dat_hang (
    so_dat_hang INT PRIMARY KEY,
    ngay_dat_hang DATE,
    ma_ncc INT,
    FOREIGN KEY (ma_ncc)
        REFERENCES nha_cung_cap (ma_ncc)
);
CREATE TABLE chi_tiet_don_dat_hang (
    ma_vt INT,
    so_dat_hang INT,
    PRIMARY KEY (ma_vt , so_dat_hang),
    FOREIGN KEY (ma_vt)
        REFERENCES vat_tu (ma_vt),
    FOREIGN KEY (so_dat_hang)
        REFERENCES don_dat_hang (so_dat_hang)
);