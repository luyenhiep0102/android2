package com.dmt.design.oderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dmt.design.oderfood.DAO.NhanVienDAO;

/**
 * Created by Administrator on 11/17/2017.
 */

public class DangNhapActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnDongYDN, btnDangKiDN;
    EditText edtTenDangNhapDN, edtMatKhauDN;
    NhanVienDAO nhanVienDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangnhap);
        nhanVienDAO = new NhanVienDAO(this);
        btnDongYDN = (Button) findViewById(R.id.btnDongYDangNhap);
        btnDangKiDN = (Button) findViewById(R.id.btnDangKiDangNhap);
        edtMatKhauDN = (EditText) findViewById(R.id.edtMatKhauDN);
        edtTenDangNhapDN = (EditText) findViewById(R.id.edtTenDangNhapDN);
        btnDongYDN.setOnClickListener(this);
        btnDangKiDN.setOnClickListener(this);
        HienThi();

    }

    public void HienThi(){
        boolean kiemtra = nhanVienDAO.hienThiButtonDangKivaDangNhap();
        btnDongYDN.setVisibility(View.VISIBLE);
        btnDangKiDN.setVisibility(View.VISIBLE);
//        if(kiemtra){
//            btnDangKiDN.setVisibility(View.GONE);
//            btnDongYDN.setVisibility(View.VISIBLE);
//        }else {
//            btnDangKiDN.setVisibility(View.VISIBLE);
//            btnDongYDN.setVisibility(View.GONE);
//        }

    }
    public void DangNhap(){
        String tendangnhap = edtTenDangNhapDN.getText().toString();
        String matkhau = edtMatKhauDN.getText().toString();
        boolean kiemtra = nhanVienDAO.dangNhap(tendangnhap, matkhau);
        if(kiemtra){
            Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(DangNhapActivity.this,"đăng nhập không thành công", Toast.LENGTH_SHORT ).show();

        }
    }
    public void DangKy(){
        Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDongYDangNhap:
                DangNhap();
                break;
            case R.id.btnDangKiDangNhap:
                DangKy();
                break;
        }
    }
}
