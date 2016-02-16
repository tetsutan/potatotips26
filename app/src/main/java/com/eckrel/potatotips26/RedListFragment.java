package com.eckrel.potatotips26;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RedListFragment extends Fragment {

    RedAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_red, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);

        adapter = new RedAdapter();
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

//        String[] items = {"aaaaaaaaa"};
        String[] items = {"aaaaaaaaa", "bbbbbbbbbbbb"};

        // ここでやっちゃった
        adapter.setItems(items);
        adapter.notifyDataSetChanged();

        if(items.length == 1) {

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content, new BlueDetailFragment())
                    .commit();

        }
        else{
            // ほんとはここ
//            adapter.setItems(items);
//            adapter.notifyDataSetChanged();
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

            TextView textView = (TextView) convertView;
            if(textView == null) {
                textView = new TextView(parent.getContext());
                textView.setTextColor(Color.RED);
                textView.setTextSize(30);
            }

            textView.setText(getItem(position));

            return textView;
        }
    }
}
