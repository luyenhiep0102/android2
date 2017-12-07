package com.dmt.design.oderfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dmt.design.oderfood.DAO.LoaiMonAnDAO;

/**
 * Created by Administrator on 11/22/2017.
 */

public class ThemLoaiThucDonActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtThemLoaiThucDon;
    Button btnThemLoaiThucDon;
    LoaiMonAnDAO loaiMonAnDAO;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themloaithucdon);
        loaiMonAnDAO = new LoaiMonAnDAO(this);
        edtThemLoaiThucDon = (EditText) findViewById(R.id.edtThemLoaiThucDon);
        btnThemLoaiThucDon = (Button) findViewById(R.id.btnThemLoaiThucDon);

        btnThemLoaiThucDon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnThemLoaiThucDon:
                String dulieu = edtThemLoaiThucDon.getText().toString();
                if (dulieu != null || dulieu.equals("")) {
                    boolean kiemtra = loaiMonAnDAO.ThemLoaiMonAn(dulieu);
                    Intent intent = new Intent();
                    intent.putExtra("kiemtraloaithucdon", kiemtra);
                    setResult(Activity.RESULT_OK, intent);
                    if (kiemtra) {
                        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();

                    }
                    break;
                }
        }
    }
}
