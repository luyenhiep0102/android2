package com.dmt.design.oderfood.FragmentApp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.dmt.design.oderfood.BananAdapter.HienThiLoaiMonAnThucDonAdapter;
import com.dmt.design.oderfood.DAO.LoaiMonAnDAO;
import com.dmt.design.oderfood.DTO.LoaiMonAnDTO;
import com.dmt.design.oderfood.R;
import com.dmt.design.oderfood.ThemThucDonActivity;

import java.util.List;


/**
 * Created by Administrator on 11/21/2017.
 */

public class HienThiThucDonFragment extends Fragment {
    GridView gridView;
    LoaiMonAnDAO loaiMonAnDAO;
    List<LoaiMonAnDTO> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_hienthithucdon, container, false);
        setHasOptionsMenu(true);
        gridView = (GridView) view.findViewById(R.id.grvThucDon);
        loaiMonAnDAO = new LoaiMonAnDAO(getActivity());
        list = loaiMonAnDAO.layDanhSachMonAn();
        HienThiLoaiMonAnThucDonAdapter adapter = new HienThiLoaiMonAnThucDonAdapter(getActivity(),
                R.layout.layout_custom_hienthiloaimonan, list
                );
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem menuItem = menu.add(1, R.id.itThemThucDon, 1, "themthucdon");
        menuItem.setIcon(R.drawable.logodangnhap);
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itThemThucDon:
                Intent intent = new Intent(getActivity(), ThemThucDonActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
