package com.dmt.design.oderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dmt.design.oderfood.DTO.LoaiMonAnDTO;
import com.dmt.design.oderfood.Database.CreateDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/22/2017.
 */

public class LoaiMonAnDAO {
    SQLiteDatabase database;
    public LoaiMonAnDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }
    public boolean ThemLoaiMonAn(String tenMonAn){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_LOAIMONAN_TENLOAI, tenMonAn);
        long tralai = database.insert(CreateDatabase.TB_LOAIMONAN, null, contentValues);
        if(tralai != 0){
            return true;
        }else {
            return false;
        }
    }
    public List<LoaiMonAnDTO> layDanhSachMonAn(){
        List<LoaiMonAnDTO> loaiMonAnDTOs = new ArrayList<>();
        String truyvan = "SELECT * FROM " + CreateDatabase.TB_LOAIMONAN;
        Cursor cursor = database.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LoaiMonAnDTO loaiMonAnDTO = new LoaiMonAnDTO();
            loaiMonAnDTO.setMaLoai(cursor.getInt(0));
            loaiMonAnDTO.setTenLoai(cursor.getString(1));
            loaiMonAnDTOs.add(loaiMonAnDTO);
            cursor.moveToNext();
        }
        return loaiMonAnDTOs;
    }
    public String layHinhLoaiMonAn(int maloai){
        String hinhanh ="";
        String truyvan = "SELECT * FROM " + CreateDatabase.TB_MONAN + " WHERE " + CreateDatabase.TB_MONAN_MALOAI + " = '" +
                 maloai + "' " + " AND " + CreateDatabase.TB_MONAN_HINHANH + " != '' ORDER BY " + CreateDatabase.TB_MONAN_MAMONAN
                + " LIMIT 1";
        Cursor cursor = database.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            hinhanh = cursor.getString(3);
            cursor.moveToNext();
        }
        return hinhanh;
    }
}
