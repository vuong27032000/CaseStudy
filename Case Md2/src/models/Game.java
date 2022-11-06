package models;

import java.io.Serializable;

public class Game implements Serializable {
    private String ten;
    private String theloai;
    private String dungluong;
    private String nhasanxuat;
    private double gia;

    public Game(String ten, String theloai, String dungluong, String nhasanxuat, double gia) {
        this.ten = ten;
        this.theloai = theloai;
        this.dungluong = dungluong;
        this.nhasanxuat = nhasanxuat;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getDungluong() {
        return dungluong;
    }

    public void setDungluong(String dungluong) {
        this.dungluong = dungluong;
    }

    public String getNhasanxuat() {
        return nhasanxuat;
    }

    public void setNhasanxuat(String nhasanxuat) {
        this.nhasanxuat = nhasanxuat;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Game{" +
               "ten='" + ten + '\'' +
               ", theloai='" + theloai + '\'' +
               ", dungluong='" + dungluong + '\'' +
               ", nhasanxuat='" + nhasanxuat + '\'' +
               ", gia=" + gia +
               '}';
    }
}
