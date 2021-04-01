package com.example.tabbartest.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.menu.R;

import java.util.List;

;

public class CollectionAdapter extends ArrayAdapter<Collection> {

    private int resourceId;

    public CollectionAdapter(Context context, int TextViewResourceId, List<Collection> objects) {
        super(context, TextViewResourceId, objects);
        resourceId = TextViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Collection collection = getItem(position);
        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else{
            view = convertView;
        }
        TextView wordView = (TextView) view.findViewById(R.id.word  );
        TextView word_cnView = (TextView) view.findViewById(R.id.word_cn  );
        wordView.setText(collection.getWord());
        word_cnView.setText(collection.getMeaning());
        return view;
    }
}
