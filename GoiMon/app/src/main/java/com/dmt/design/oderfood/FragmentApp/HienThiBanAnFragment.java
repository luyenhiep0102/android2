package com.dmt.design.oderfood.FragmentApp;

import android.app.Activity;
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
import android.widget.Toast;

import com.dmt.design.oderfood.BananAdapter.BanAnAdapter;
import com.dmt.design.oderfood.DAO.BanAnDAO;
import com.dmt.design.oderfood.DTO.BanAnDTO;
import com.dmt.design.oderfood.R;
import com.dmt.design.oderfood.ThemBanAnActivity;

import java.util.List;

/**
 * Created by Administrator on 11/18/2017.
 */

public class HienThiBanAnFragment extends Fragment {
    public static int REQUEST_CODE = 111;
    private BanAnAdapter anAdapter;
    private GridView grvBanAn;
    private List<BanAnDTO> arrayList;
    BanAnDAO banAnDAO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_hienthibanan, container, false);
        setHasOptionsMenu(true);
        grvBanAn = (GridView) view.findViewById(R.id.grvBanAn);
        banAnDAO = new BanAnDAO(getActivity());
        HienThiDanhSachBanAn();

        return view;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem menuItem = menu.add(1,R.id.itThemBanAn,1,"thembanan");
        menuItem.setIcon(R.drawable.thembanan);
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itThemBanAn:
                Intent intent = new Intent(getActivity(), ThemBanAnActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Intent intent = data;
            boolean kiemtra = intent.getBooleanExtra("kiemtra", false);
            if(kiemtra){
                HienThiDanhSachBanAn();
            }else {
                Toast.makeText(getActivity(), "thêm không thành công", Toast.LENGTH_SHORT).show();

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void HienThiDanhSachBanAn(){
        arrayList =  banAnDAO.LayTatCaBanAn();
        anAdapter = new BanAnAdapter(getActivity(), R.layout.layout_banan_custom, arrayList);
        grvBanAn.setAdapter(anAdapter);
        anAdapter.notifyDataSetChanged();
    }
}