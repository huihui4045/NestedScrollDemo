package demo.letv.com.nestedscrolldemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * Created by gavin on 2016/9/21.
 */
public class CatalogFrag extends Fragment {

    private MyListView lv;

    private CatalogAdapter adapter;

    private ArrayList<Integer> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        lv = (MyListView) view.findViewById(R.id.catalog_lv);
        /*lv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                lv.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });*/
        data = new ArrayList<>();
        Bundle bundle = this.getArguments();
        int length = bundle.getInt("DATASIZE");
        for (int i = 0; i < length; i++) {
            data.add(i, i);
        }

        adapter = new CatalogAdapter(getActivity(), data);
        lv.setAdapter(adapter);
    }



}
