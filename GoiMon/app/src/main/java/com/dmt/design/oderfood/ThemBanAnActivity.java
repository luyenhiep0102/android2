package com.dmt.design.oderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dmt.design.oderfood.DAO.BanAnDAO;

/**
 * Created by Administrator on 11/18/2017.
 */

public class ThemBanAnActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtThemBanAn;
    Button btnThem;
    BanAnDAO banAnDAO;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_thembanan);
        edtThemBanAn = (EditText) findViewById(R.id.edtThemBanAn);
        btnThem = (Button) findViewById(R.id.btnThemBanAn);
        banAnDAO = new BanAnDAO(this);
        btnThem.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String tenBanAn = edtThemBanAn.getText().toString();
        if(tenBanAn != null || tenBanAn.equals("")){
            boolean kiemtra = banAnDAO.ThemBanAn(tenBanAn);
            Intent intent = new Intent();
            intent.putExtra("kiemtra", kiemtra);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
