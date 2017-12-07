package com.dmt.design.oderfood;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.dmt.design.oderfood.BananAdapter.HienThiLoaiMonAnAdapter;
import com.dmt.design.oderfood.DAO.LoaiMonAnDAO;
import com.dmt.design.oderfood.DAO.MonAnDAO;
import com.dmt.design.oderfood.DTO.LoaiMonAnDTO;
import com.dmt.design.oderfood.DTO.MonAnDTO;

import java.util.List;

/**
 * Created by Administrator on 11/21/2017.
 */

public class ThemThucDonActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton ibtnThemLoaiMonan;
    private int REQUET_CODE_THEMTHUCDON = 123;
    private int REQUET_CODE_CHOOSEIMAGE = 321;

    List<LoaiMonAnDTO> list;
    HienThiLoaiMonAnAdapter anAdapter;
    Spinner spinner;
    LoaiMonAnDAO loaiMonAnDAO;
    MonAnDAO monAnDAO;

    ImageView imgHinhMonAn;
    Button btnThemThucDon, btnThoatThemThucDon;
    String sduongDanHinh;
    EditText edttenMonAn;
    EditText edtGiaTien;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themthucdon);
        ibtnThemLoaiMonan = (ImageButton) findViewById(R.id.ibtnThemLoaiThucDon);
        spinner = (Spinner) findViewById(R.id.spinnerChon);
        imgHinhMonAn = (ImageView) findViewById(R.id.imgHinhMonAn);
        btnThemThucDon = (Button) findViewById(R.id.btnDongYThemMonAn);
        btnThoatThemThucDon = (Button) findViewById(R.id.btnThoatMonAn);
        edttenMonAn = (EditText) findViewById(R.id.edtThemTenMonAn);
        edtGiaTien = (EditText) findViewById(R.id.edtThemGiaTien);

        loaiMonAnDAO = new LoaiMonAnDAO(this);
        monAnDAO = new MonAnDAO(this);


        ibtnThemLoaiMonan.setOnClickListener(this);
        imgHinhMonAn.setOnClickListener(this);
        btnThemThucDon.setOnClickListener(this);
        btnThoatThemThucDon.setOnClickListener(this);
        ThemLoaiThucDon();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibtnThemLoaiThucDon:
                Intent intent = new Intent(ThemThucDonActivity.this, ThemLoaiThucDonActivity.class);
                startActivityForResult(intent, REQUET_CODE_THEMTHUCDON);
                break;

            case R.id.imgHinhMonAn:
                Intent intent1 = new Intent(Intent.ACTION_PICK);
                intent1.setType("image/*");
                startActivityForResult(intent1,REQUET_CODE_CHOOSEIMAGE);
                break;
            case R.id.btnDongYThemMonAn:
                int vitri = spinner.getSelectedItemPosition();
                int maloai = list.get(vitri).getMaLoai();
                String tenMonAn = edttenMonAn.getText().toString();
                String giaTien = edtGiaTien.getText().toString();
                if(tenMonAn != null && giaTien != null){
                    MonAnDTO monAnDTO = new MonAnDTO();
                    monAnDTO.setTenMonAn(tenMonAn);
                    monAnDTO.setMaLoai(maloai);
                    monAnDTO.setGiaTien(giaTien);
                    monAnDTO.setHinhAnh(sduongDanHinh);
                    boolean kiemtra = monAnDAO.ThemDanhSachMonAn(monAnDTO);
                    if(kiemtra == true){
                        Toast.makeText(this, "thêm thành công", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "thất bại", Toast.LENGTH_SHORT).show();

                    }

                }else {
                    Toast.makeText(ThemThucDonActivity.this, "vui lòng nhận đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnThoatMonAn:
                finish();
                break;
        }
    }
    public void ThemLoaiThucDon(){
        list = loaiMonAnDAO.layDanhSachMonAn();
        anAdapter = new HienThiLoaiMonAnAdapter(this, R.layout.layout_custom_loaithucdon, list);
        spinner.setAdapter(anAdapter);
        anAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUET_CODE_THEMTHUCDON && resultCode == Activity.RESULT_OK){
            Intent intent = data;
            boolean kiemtra = intent.getBooleanExtra("kiemtraloaithucdon", false);
            if(kiemtra){
                ThemLoaiThucDon();
                finish();
            }else {
                Toast.makeText(this, "Lỗi", Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode == REQUET_CODE_CHOOSEIMAGE && resultCode == Activity.RESULT_OK ){

            imgHinhMonAn.setImageURI(data.getData());
            sduongDanHinh = data.getData().toString();
            Toast.makeText(ThemThucDonActivity.this, data.getData().toString(), Toast.LENGTH_SHORT).show();


        }

    }
}
