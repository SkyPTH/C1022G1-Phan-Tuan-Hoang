package Bai3.model.Model;

public class SoTietKiem {
    private String idSTK;
    private String soTien;
    private String kyHan;
    private String laiSuat;
    private String idKH;

    public SoTietKiem(String idSTK, String soTien, String kyHan, String laiSuat, String idKH) {
        this.idSTK = idSTK;
        this.soTien = soTien;
        this.kyHan = kyHan;
        this.laiSuat = laiSuat;
        this.idKH = idKH;
    }

    public SoTietKiem() {
    }

    public String getIdSTK() {
        return idSTK;
    }

    public void setIdSTK(String idSTK) {
        this.idSTK = idSTK;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    @Override
    public String toString() {
        return "SoTietKiem{" +
                "idSTK='" + idSTK + '\'' +
                ", soTien=" + soTien +
                ", kyHan='" + kyHan + '\'' +
                ", laiSuat=" + laiSuat +
                ", idKH='" + idKH + '\'' +
                '}';
    }
}
