package com.dmt.design.oderfood.FragmentApp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import com.dmt.design.oderfood.R;

import java.util.Calendar;

/**
 * Created by Administrator on 11/16/2017.
 */

public class DatePickerPragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int iNam = calendar.get(Calendar.YEAR);
        int iThang = calendar.get(Calendar.MONTH);
        int iNgay = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, iNgay, iThang, iNam);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        EditText edtNgaySinh = (EditText) getActivity().findViewById(R.id.edNgaySinhDK);
        String ngaysinh = dayOfMonth + "/" + ( month +1 ) + "/" + year;
        edtNgaySinh.setText(ngaysinh);
    }
}
