package com.dmt.design.oderfood.BananAdapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmt.design.oderfood.DAO.LoaiMonAnDAO;
import com.dmt.design.oderfood.DTO.LoaiMonAnDTO;
import com.dmt.design.oderfood.R;

import java.util.List;

/**
 * Created by Administrator on 11/25/2017.
 */

public class HienThiLoaiMonAnThucDonAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<LoaiMonAnDTO> list;
    private LoaiMonAnDAO loaiMonAnDAO;

    public HienThiLoaiMonAnThucDonAdapter(Context context, int layout, List<LoaiMonAnDTO> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        loaiMonAnDAO = new LoaiMonAnDAO(context);
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
        ImageView imgHinhLoaiThucDon;
        TextView txtTenLoaiThucDon;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.imgHinhLoaiThucDon = (ImageView) convertView.findViewById(R.id.imgHienThiMonAn);
            holder.txtTenLoaiThucDon = (TextView) convertView.findViewById(R.id.txtHienThiLoaiMonAn);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        LoaiMonAnDTO loaiMonAnDTO = list.get(position);
        holder.txtTenLoaiThucDon.setText(loaiMonAnDTO.getTenLoai());
        int maloai = loaiMonAnDTO.getMaLoai();
        String hinhanh = loaiMonAnDAO.layHinhLoaiMonAn(maloai);
        Uri uri = Uri.parse(hinhanh);
        holder.txtTenLoaiThucDon.setText(loaiMonAnDTO.getTenLoai());
        holder.imgHinhLoaiThucDon.setImageURI(uri);

        return convertView;
    }
}
