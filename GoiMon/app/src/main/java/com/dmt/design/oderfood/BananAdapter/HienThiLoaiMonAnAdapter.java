package com.dmt.design.oderfood.BananAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dmt.design.oderfood.DTO.LoaiMonAnDTO;
import com.dmt.design.oderfood.R;

import java.util.List;

/**
 * Created by Administrator on 11/23/2017.
 */

public class HienThiLoaiMonAnAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<LoaiMonAnDTO> list;

    public HienThiLoaiMonAnAdapter(Context context, int layout, List<LoaiMonAnDTO> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getMaLoai();
    }
    class ViewHolder{
        TextView txtTenLoaiMonAn;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            holder.txtTenLoaiMonAn = (TextView) convertView.findViewById(R.id.txtLoaiThucDon);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        LoaiMonAnDTO loaiMonAnDTO = list.get(position);
        holder.txtTenLoaiMonAn.setText(loaiMonAnDTO.getTenLoai());
        holder.txtTenLoaiMonAn.setTag(loaiMonAnDTO.getMaLoai());
        return convertView;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            holder.txtTenLoaiMonAn = (TextView) convertView.findViewById(R.id.txtLoaiThucDon);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        LoaiMonAnDTO loaiMonAnDTO = list.get(position);
        holder.txtTenLoaiMonAn.setText(loaiMonAnDTO.getTenLoai());
        holder.txtTenLoaiMonAn.setTag(loaiMonAnDTO.getMaLoai());
        return convertView;
    }
}
