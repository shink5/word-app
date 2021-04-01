package com.example.english;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.menu.R;
import com.example.tabbartest.DataBase.CollectionHelper;
import com.example.tabbartest.DataBase.LearnedWordHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LearnActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    private Button speechBtn; // 按钮控制开始朗读 {
    private int id=1;
    DBOpenHelper dbOpenHelper;
    private TextToSpeech tts;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        //DatabaseUtil.packDataBase(this);
        final ListView listView=(ListView)findViewById(R.id.listview);
        Button btn=(Button)findViewById(R.id.button);
        Button btn2=(Button)findViewById(R.id.button2);
        Button read_btn=(Button)findViewById(R.id.read_button) ;
        btn.setOnClickListener(this);
        final LearnedWordHelper learnedWordHelper=new LearnedWordHelper(this);
        final CollectionHelper collectionHelper=new CollectionHelper(this);
        tts=new TextToSpeech(this, (TextToSpeech.OnInitListener) this);
        dbOpenHelper=new DBOpenHelper(LearnActivity.this,"word.db",null,1);
        cursor=dbOpenHelper.getReadableDatabase().query("CET6_1",null,"xu=?",new String[]{id+""},null,null,null);
        while(cursor.moveToNext()){
            String acr= cursor.getString(5);
            id=Integer.valueOf(acr);
        }
        if(id<1){
            id=1;
        }
        cursor=dbOpenHelper.getReadableDatabase().query("CET6_1",null,"xu=?",new String[]{id+""},null,null,null);
        while(cursor.moveToNext()){
            Map<String,String> map=new HashMap<String, String>();
            map.put("word",cursor.getString(1));
            map.put("ph","/"+cursor.getString(2)+"/");
            map.put("trans",cursor.getString(3));
            ArrayList<Map<String,String>> resultList= new ArrayList<Map<String,String>>();
            resultList.add(map);
            SimpleAdapter simpleAdapter=new SimpleAdapter(LearnActivity.this,resultList,
                    R.layout.item,
                    new String[]{"word","ph","trans"},
                    new int[]{R.id.word,R.id.ph,R.id.trans});
            listView.setAdapter(simpleAdapter);
            id++;
        }
            btn.setOnClickListener(new View.OnClickListener() {
                @Override


                public void onClick(View v) {
                    cursor=dbOpenHelper.getReadableDatabase().query("CET6_1",null,"xu=?",new String[]{id+""},null,null,null);
                    ArrayList<Map<String,String>> resultList= new ArrayList<Map<String,String>>();
                    while(cursor.moveToNext()){
                        Map<String,String> map=new HashMap<String, String>();
                        map.put("word",cursor.getString(1));
                        map.put("ph","/"+cursor.getString(2)+"/");
                        map.put("trans",cursor.getString(3));
                        resultList.add(map);
                        SimpleAdapter simpleAdapter=new SimpleAdapter(LearnActivity.this,resultList,
                                R.layout.item,
                                new String[]{"word","ph","trans"},
                                new int[]{R.id.word,R.id.ph,R.id.trans});
                        listView.setAdapter(simpleAdapter);
                        ContentValues cv = new ContentValues();
                        cv.put("word", cursor.getString(1));
                        cv.put("ph", cursor.getString(2));
                        cv.put("trans",cursor.getString(3));
                        cv.put("rank","1");
                        cv.put("collect","0");
                        String[] args = {String.valueOf(cursor.getString(4))};
                        dbOpenHelper.getReadableDatabase().update("CET6_1",cv,"xu=?",new String[]{id+""});
                        learnedWordHelper.insertWord(cursor.getString(1),cursor.getString(3));
                        // 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                        tts.setPitch(0.5f);
                        //设定语速 ，默认1.0正常语速
                        tts.setSpeechRate(1.5f);
                        //朗读，注意这里三个参数的added in API level 4   四个参数的added in API level 21
                        tts.speak(cursor.getString(1).toString(), TextToSpeech.QUEUE_FLUSH, null);
                        id++;

                }
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id--;
                cursor=dbOpenHelper.getReadableDatabase().query("CET6_1",null,"xu=?",new String[]{id+""},null,null,null);
                while(cursor.moveToNext()){
                    ContentValues cv = new ContentValues();
                    cv.put("word", cursor.getString(1));
                    cv.put("ph", cursor.getString(2));
                    cv.put("trans",cursor.getString(3));
                    cv.put("rank","1");
                    cv.put("collect","0");
                    String[] args = {String.valueOf(cursor.getString(4))};
                    dbOpenHelper.getReadableDatabase().update("CET6_1",cv,"xu=?",new String[]{id+""});
                    collectionHelper.insertWord(cursor.getString(1),cursor.getString(3));

                    id++;
            }
            }
        });
        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id--;
                cursor=dbOpenHelper.getReadableDatabase().query("CET6_1",null,"xu=?",new String[]{id+""},null,null,null);
                while(cursor.moveToNext()){
                    // 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                    tts.setPitch(0.5f);
                    //设定语速 ，默认1.0正常语速
                    tts.setSpeechRate(1.5f);
                    //朗读，注意这里三个参数的added in API level 4   四个参数的added in API level 21
                    tts.speak(cursor.getString(1).toString(), TextToSpeech.QUEUE_FLUSH, null);
                    id++;

                }

            }
        });




    }


    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.ENGLISH);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "数据丢失或不支持", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (tts != null && !tts.isSpeaking()) {
            // 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
            tts.setPitch(0.5f);
            //设定语速 ，默认1.0正常语速
            tts.setSpeechRate(1.5f);
            //朗读，注意这里三个参数的added in API level 4   四个参数的added in API level 21
            tts.speak(cursor.getString(1).toString(), TextToSpeech.QUEUE_FLUSH, null);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        tts.stop(); // 不管是否正在朗读TTS都被打断
        tts.shutdown(); // 关闭，释放资源
        int tip=1;
        cursor=dbOpenHelper.getReadableDatabase().query("CET6_1",null,"xu=?",new String[]{tip+""},null,null,null);
        while(cursor.moveToNext()){
            ContentValues cv = new ContentValues();
            cv.put("word","a.m");
            cv.put("ph", "ei em");
            cv.put("trans","n.(缩)上午午前");
            cv.put("rank",id);
            cv.put("collect","0");
            dbOpenHelper.getReadableDatabase().update("CET6_1",cv,"xu=?",new String[]{tip+""});
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        int tip=1;
        cursor=dbOpenHelper.getReadableDatabase().query("CET6_1",null,"xu=?",new String[]{tip+""},null,null,null);
        while(cursor.moveToNext()){
            ContentValues cv = new ContentValues();
            cv.put("word","a.m");
            cv.put("ph", "ei em");
            cv.put("trans","n.(缩)上午午前");
            cv.put("rank",id);
            cv.put("collect","0");
            dbOpenHelper.getReadableDatabase().update("CET6_1",cv,"xu=?",new String[]{tip+""});
        }
    }
}