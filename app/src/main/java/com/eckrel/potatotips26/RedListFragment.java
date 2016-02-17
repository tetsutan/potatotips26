package com.eckrel.potatotips26;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class RedListFragment extends Fragment {

    RedAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_red, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setDividerHeight(5);

        adapter = new RedAdapter();
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        String[] items = {"宮本フレデリカ"};
//
//        // 間違ってここに書いた
//        adapter.setItems(items);
//        adapter.notifyDataSetChanged();

        if(items.length == 1) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, new BlueDetailFragment())
                            .commit();
                }
            },200);

        }
        else{
            // ほんとはここ
            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        }

    }

    private static class RedAdapter extends BaseAdapter {

        String[] items = {};
        public void setItems(String[] items){
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public String getItem(int position) {
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LinearLayout view = (LinearLayout) convertView;
            if(view == null) {
                view = (LinearLayout) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cell_red, parent, false);
            }

            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setTextSize(30);

            textView.setText(getItem(position));

            return view;
        }
    }
}
