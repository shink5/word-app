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

public class LearnedWordAdapter extends ArrayAdapter<Learnedword> {

    private int resourceId;

    public LearnedWordAdapter(Context context, int TextViewResourceId, List<Learnedword> objects) {
        super(context, TextViewResourceId, objects);
        resourceId = TextViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Learnedword learnedWord = getItem(position);
        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else{
            view = convertView;
        }
        TextView wordView = (TextView) view.findViewById(R.id.word  );
        TextView word_cnView = (TextView) view.findViewById(R.id.word_cn  );
        wordView.setText(learnedWord.getWord());
        word_cnView.setText(learnedWord.getMeaning());
        return view;
    }
}