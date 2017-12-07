package com.dmt.design.oderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dmt.design.oderfood.DTO.NhanVienDTO;
import com.dmt.design.oderfood.Database.CreateDatabase;

/**
 * Created by Administrator on 11/16/2017.
 */

public class NhanVienDAO {
    SQLiteDatabase database;
    public NhanVienDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }
    public long ThemNhanVien(NhanVienDTO nhanVienDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_NHANVIEN_TENDN, nhanVienDTO.getTENDN());
        contentValues.put(CreateDatabase.TB_NHANVIEN_CMND, nhanVienDTO.getCMND());
        contentValues.put(CreateDatabase.TB_NHANVIEN_GIOITINH, nhanVienDTO.getGIOITINH());
        contentValues.put(CreateDatabase.TB_NHANVIEN_MATKHAU, nhanVienDTO.getMATKHAU());
        contentValues.put(CreateDatabase.TB_NHANVIEN_NGAYSINH, nhanVienDTO.getNGAYSINH());
        long kiemTra = database.insert(CreateDatabase.TB_NHANVIEN, null, contentValues);
        return  kiemTra;
    }
    public boolean hienThiButtonDangKivaDangNhap(){
        String data = "SELECT * FROM " + CreateDatabase.TB_NHANVIEN;
        Cursor cursor = database.rawQuery(data, null);
        if(cursor != null) {
            return true;
        }else {
            return false;
        }
    }
    public boolean dangNhap(String tenDN, String matKhau){
        String data = "SELECT * FROM " + CreateDatabase.TB_NHANVIEN + " WHERE " +
                CreateDatabase.TB_NHANVIEN_TENDN + " = '" + tenDN + "' AND " +
                CreateDatabase.TB_NHANVIEN_MATKHAU + " = '" + matKhau + "' ";
        Cursor cursor = database.rawQuery(data, null);
        if(cursor.getCount() != 0){
            return true;
        }else {
            return false;
        }

    }
}
