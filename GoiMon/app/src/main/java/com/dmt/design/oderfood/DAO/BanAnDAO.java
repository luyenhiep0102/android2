package com.dmt.design.oderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dmt.design.oderfood.DTO.BanAnDTO;
import com.dmt.design.oderfood.Database.CreateDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/18/2017.
 */

public class BanAnDAO {
    SQLiteDatabase database;

    public BanAnDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }
    public Boolean ThemBanAn(String banso){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_BANAN_TENBAN, banso);
        contentValues.put(CreateDatabase.TB_BANAN_TINHTRANGBAN, false);
        long tinhtrang = database.insert(CreateDatabase.TB_BANAN, null, contentValues);
        if(tinhtrang != 0){
            return true;
        }else {
            return false;
        }
    }
    public List<BanAnDTO> LayTatCaBanAn(){
        List<BanAnDTO> banAnDTOList = new ArrayList<BanAnDTO>();
        String truyvan = "SELECT * FROM " + CreateDatabase.TB_BANAN;
        Cursor cursor = database.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            BanAnDTO banAnDTO = new BanAnDTO();
            banAnDTO.setMaBan(cursor.getInt(0));
            banAnDTO.setTenban(cursor.getString(1));
            banAnDTOList.add(banAnDTO);
            cursor.moveToNext();
        }
        return banAnDTOList;
    }
}

