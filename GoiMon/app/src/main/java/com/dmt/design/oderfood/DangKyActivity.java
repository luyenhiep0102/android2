package com.dmt.design.oderfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.dmt.design.oderfood.DAO.NhanVienDAO;
import com.dmt.design.oderfood.DTO.NhanVienDTO;
import com.dmt.design.oderfood.FragmentApp.DatePickerPragment;

public class DangKyActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener{
    EditText edtDangNhapDK, edtMatKhauDK, edtNgaySinhDK, edtCMNDdk;
    Button btnDongY, btnThoat;
    RadioGroup rgGioiTinh;
    String gioiTinh;
    NhanVienDAO nhanVienDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangki);
        edtDangNhapDK = (EditText) findViewById(R.id.edtenDangNhapDK);
        edtMatKhauDK = (EditText) findViewById(R.id.edMatKhauDK);
        edtNgaySinhDK = (EditText) findViewById(R.id.edNgaySinhDK);
        edtCMNDdk = (EditText) findViewById(R.id.edCMNDdk);
        btnDongY = (Button) findViewById(R.id.btDongY);
        btnThoat = (Button) findViewById(R.id.btThoat);
        rgGioiTinh = (RadioGroup) findViewById(R.id.rdgGioiTinhDK);

        btnDongY.setOnClickListener(this);
        btnThoat.setOnClickListener(this);
        edtNgaySinhDK.setOnFocusChangeListener(this);
        nhanVienDAO = new NhanVienDAO(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btDongY:
                String tenDN = edtDangNhapDK.getText().toString();
                String matKhau = edtMatKhauDK.getText().toString();

                switch (rgGioiTinh.getCheckedRadioButtonId()){
                    case R.id.rdNam:
                        gioiTinh = "Nam";
                        break;
                    case R.id.rdNu:
                        gioiTinh = "Nữ";
                        break;

                }
                String ngaySinh = edtNgaySinhDK.getText().toString();
                int cmnd = Integer.parseInt(edtCMNDdk.getText().toString());
                if(tenDN == null || tenDN.equals("")){
                    Toast.makeText(DangKyActivity.this, "vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else if(matKhau == null || matKhau.equals("")){
                    Toast.makeText(DangKyActivity.this, "vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    NhanVienDTO nhanVienDTO = new NhanVienDTO();
                    nhanVienDTO.setTENDN(tenDN);
                    nhanVienDTO.setGIOITINH(gioiTinh);
                    nhanVienDTO.setMATKHAU(matKhau);
                    nhanVienDTO.setNGAYSINH(ngaySinh);
                    nhanVienDTO.setCMND(cmnd);
                    long kiemTra  = nhanVienDAO.ThemNhanVien(nhanVienDTO);
                    if(kiemTra != 0){
                        Toast.makeText(DangKyActivity.this, "thành công", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(DangKyActivity.this, "thất bại", Toast.LENGTH_SHORT).show();

                    }

                }
                break;
            case R.id.btThoat: finish();
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()){
            case R.id.edNgaySinhDK:
                if(hasFocus){
                    DatePickerPragment datePickerPragment = new DatePickerPragment();
                    datePickerPragment.show(getFragmentManager(), "Ngày Sinh");
                }
                break;
        }
    }
}
