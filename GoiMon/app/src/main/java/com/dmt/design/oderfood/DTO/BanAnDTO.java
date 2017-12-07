package com.dmt.design.oderfood.DTO;

/**
 * Created by Administrator on 11/19/2017.
 */

public class BanAnDTO {
    private int maBan;
    private String tenban;
    private boolean duocChon;

    public BanAnDTO(){}
    public boolean isDuocChon() {
        return duocChon;
    }

    public void setDuocChon(boolean duocChon) {
        this.duocChon = duocChon;
    }

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public String getTenban() {
        return tenban;
    }

    public void setTenban(String tenban) {
        this.tenban = tenban;
    }
}