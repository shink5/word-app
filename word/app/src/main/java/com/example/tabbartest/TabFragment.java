package com.example.tabbartest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.menu.R;
import com.example.tabbartest.DataBase.CollectionHelper;
import com.example.tabbartest.DataBase.LearnedWordHelper;
import com.example.tabbartest.model.Collection;
import com.example.tabbartest.model.CollectionAdapter;
import com.example.tabbartest.model.LearnedWordAdapter;
import com.example.tabbartest.model.Learnedword;

import java.util.ArrayList;
import java.util.List;

public class TabFragment extends Fragment {
    private List<Collection> wordList = new ArrayList<>();
    private String mTitle;

    public TabFragment(String title){
        mTitle=title;
    }


    @Override
    public View onCreateView
            (LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState){
        if(mTitle == "已学单词"){

            final View view=inflater.inflate(R.layout.activity_learned_words,container,false);

//            ImageView collectImg = (ImageView) view.findViewById(R.id.shoucangImg);
//            ImageView searchImg = (ImageView) view.findViewById(R.id.chakanImg);
//            searchImg.setOnTouchListener(this);
//            collectImg.setOnTouchListener(this);


            final LearnedWordHelper learnedWordHelper = new LearnedWordHelper(getContext());
            learnedWordHelper.getReadableDatabase();

            List<Learnedword> wordList = learnedWordHelper.getAllLearnedwords();
            LearnedWordAdapter adapter = new LearnedWordAdapter(getContext(), R.layout.word_item, wordList);
            ListView listView = (ListView) view.findViewById(R.id.ListView);
            listView.setAdapter(adapter);

            int number = learnedWordHelper.getLearnedwordsCount();
            TextView numberText = (TextView) view.findViewById(R.id.number);
            numberText.setText("单词数：" + number);

//            Button button = (Button) view.findViewById(R.id.add_learnedword);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    long id = learnedWordHelper.insertWord("Hello","你好");
//                    Learnedword learnedword = learnedWordHelper.getLearnedword(id);
//                    Toast.makeText(getContext(),learnedword.getTimestamp(),Toast.LENGTH_LONG).show();
//                    Onload(learnedWordHelper,view);
//                }
//            });
            return view;
        }

        else {
            View view=inflater.inflate(R.layout.activity_collection,container,false);

            CollectionHelper collectionHelper = new CollectionHelper(getContext());
            collectionHelper.getReadableDatabase();

            wordList = collectionHelper.getAllCollections();
            CollectionAdapter adapter = new CollectionAdapter(getContext(),R.layout.word_item,wordList);
            ListView listView = (ListView) view.findViewById(R.id.ListView);
            listView.setAdapter(adapter);

            int number = collectionHelper.getCollectionsCount();
            TextView numberText = (TextView) view.findViewById(R.id.number);
            numberText.setText("单词数：" + number);
            return view;
        }

    }

//    添加单词 显示时间戳 测试用
    protected void Onload(LearnedWordHelper learnedWordHelper,View view){
        List<Learnedword> wordList = learnedWordHelper.getAllLearnedwords();
        LearnedWordAdapter adapter = new LearnedWordAdapter(getContext(), R.layout.word_item, wordList);
        ListView listView = (ListView) view.findViewById(R.id.ListView);
        listView.setAdapter(adapter);
    }


//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        switch (v.getId()){
//            case R.id.shoucangImg:
//
//                break;
//            case R.id.chakanImg:
//
//                break;
//            default:
//                break;
//        }
//
//        return false;
//    }
}