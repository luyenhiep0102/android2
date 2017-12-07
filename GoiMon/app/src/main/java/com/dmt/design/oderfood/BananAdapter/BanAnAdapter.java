package com.dmt.design.oderfood.BananAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmt.design.oderfood.DTO.BanAnDTO;
import com.dmt.design.oderfood.R;

import java.util.List;

/**
 * Created by Administrator on 11/19/2017.
 */

public class BanAnAdapter extends BaseAdapter implements View.OnClickListener{
    private Context context;
    private int layout;
    private List<BanAnDTO> list;
    ViewHolder holder;

    public BanAnAdapter(Context context, int layout, List<BanAnDTO> list) {
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
        return list.get(position).getMaBan();
    }



    class ViewHolder{
        TextView txtBanAn;
        ImageView imgBanAn, imgGoiMon, imgThanhToan, imgAnButton;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtBanAn = (TextView) convertView.findViewById(R.id.txtBanAn);
            holder.imgAnButton = (ImageView) convertView.findViewById(R.id.imgAnButton);
            holder.imgGoiMon = (ImageView) convertView.findViewById(R.id.imgGoiMon);
            holder.imgThanhToan = (ImageView) convertView.findViewById(R.id.imgThanhToan);
            holder.imgBanAn = (ImageView) convertView.findViewById(R.id.imgBanAn);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        if(list.get(position).isDuocChon()){
            hienButton();
        }else {
            anButton();

        }

        BanAnDTO banAnDTO = list.get(position);
        holder.txtBanAn.setText(banAnDTO.getTenban());
        holder.imgBanAn.setTag(position);
        holder.imgBanAn.setOnClickListener(this);
        return convertView;
    }
    public void hienButton(){
        holder.imgGoiMon.setVisibility(View.VISIBLE);
        holder.imgThanhToan.setVisibility(View.VISIBLE);
        holder.imgAnButton.setVisibility(View.VISIBLE);
    }
    public void anButton(){
        holder.imgGoiMon.setVisibility(View.INVISIBLE);
        holder.imgThanhToan.setVisibility(View.INVISIBLE);
        holder.imgAnButton.setVisibility(View.INVISIBLE);
    }
    @Override
    public void onClick(View v) {
        holder = (ViewHolder) ((View)v.getParent()).getTag();
    switch (v.getId()){
        case R.id.imgBanAn:
            int vitri = (int) v.getTag();
            hienButton();
            list.get(vitri).setDuocChon(true);
            break;
    }
    }
}
