package com.dmt.design.oderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.dmt.design.oderfood.DTO.MonAnDTO;
import com.dmt.design.oderfood.Database.CreateDatabase;

/**
 * Created by Administrator on 11/24/2017.
 */

public class MonAnDAO {
    SQLiteDatabase database;

    public MonAnDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }
    public boolean ThemDanhSachMonAn(MonAnDTO monAnDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_MONAN_TENMONAN, monAnDTO.getTenMonAn());
        contentValues.put(CreateDatabase.TB_MONAN_GIATIEN, monAnDTO.getGiaTien());
        contentValues.put(CreateDatabase.TB_MONAN_HINHANH, monAnDTO.getHinhAnh());
        contentValues.put(CreateDatabase.TB_MONAN_MALOAI, monAnDTO.getGiaTien());
        long kiemtra = database.insert(CreateDatabase.TB_MONAN, null, contentValues);
        if(kiemtra !=0) {
            return true;
        }else {
            return false;
        }

    }
}
