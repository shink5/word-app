package com.example.wordsearch.ui.main;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.wordsearch.DataBasePackage.MySqliteHelper;
import com.example.menu.R;
import com.example.wordsearch.word.search.model.Word;
import com.example.wordsearch.word.search.model.WordSearchManager;

import java.util.HashSet;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private EditText searchEdit;
    private Button enter;
    private WordSearchManager wordSearchManager;
    private MySqliteHelper helper;
    private TextView message,result_1,result_2,result_3,result_4,result_5,
            result_6,result_7,result_8,result_9,result_10;

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.search_fragment, container, false);

        intiTextView(root);

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {

                HashSet<Word> Result = wordSearchManager.searchWord(searchEdit.getText().toString());
                if (Result!=null){
                    layResultOnText(Result);
                }else {
                    Log.i("TAG","Result is null !");
                }
            }
        };
        searchEdit.addTextChangedListener(afterTextChangedListener);

        /**
         * searchEdit.addTextChangedListener(afterTextChangedListener);
         *         helper = DataBaseManager.getInstance(getActivity());
         *         SQLiteDatabase db = helper.getWritableDatabase();
         *
         *         int i = WordSearchManager.searchword(db,"CET4_1");
         *         message.setText(i+"");
         *
         *         db.close();
         */

        String[] pak = {"CET4_1"};
                wordSearchManager = WordSearchManager.initManager(getActivity(),pak);
                if (wordSearchManager.isInit()){
                     wordSearchManager.startManager();
                }

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 HashSet<Word> Result = wordSearchManager.searchWord(searchEdit.getText().toString());
                    if (Result!=null){
                        layResultOnText(Result);
                    }else {
                        Log.i("TAG","Result is null !");
                    }

            }
        });

        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel


    }



    public void layResultOnText(HashSet<Word> words){
        int i = 1;
        for (int j = 1; j <= 10; j++ ) {
            gettextview(i).setText(String.format("%s\n%s", "", ""));
        }
        for (Word word:words
             ) {
            gettextview(i).setText(String.format("%s\n%s", word.getWordspell(), word.getMaining()));
            i++;
            if (i > 10) return;
        }
    }

    public void intiTextView(View root){
        searchEdit = root.findViewById(R.id.search_edit_test);
        message = root.findViewById(R.id.message);
        enter = root.findViewById(R.id.enter);
        result_1 = root.findViewById(R.id.result_1);
        result_2 = root.findViewById(R.id.result_2);
        result_3 = root.findViewById(R.id.result_3);
        result_4 = root.findViewById(R.id.result_4);
        result_5 = root.findViewById(R.id.result_5);
        result_6 = root.findViewById(R.id.result_6);
        result_7 = root.findViewById(R.id.result_7);
        result_8 = root.findViewById(R.id.result_8);
        result_9 = root.findViewById(R.id.result_9);
        result_10 = root.findViewById(R.id.result_10);
    }

    public TextView gettextview(int i){
        switch (i){
            case 1:return result_1;
            case 2:return result_2;
            case 3:return result_3;
            case 4:return result_4;
            case 5:return result_5;
            case 6:return result_6;
            case 7:return result_7;
            case 8:return result_8;
            case 9:return result_9;
            case 10:return result_10;
            default: return null;
        }
    }
}
