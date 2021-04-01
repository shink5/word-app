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
import com.example.tabbartest.DataBase.LearnedWordHelper;
import com.example.tabbartest.model.Learnedword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener{
    private Button speechBtn; // 按钮控制开始朗读 {
    private int id=1;
    DBOpenHelper dbOpenHelper;
    private TextToSpeech tts;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        final ListView listView=(ListView)findViewById(R.id.listview);
        Button btn=(Button)findViewById(R.id.button);
        Button read_btn=(Button)findViewById(R.id.read_button) ;
        final LearnedWordHelper learnedWordHelper=new LearnedWordHelper(this);
        tts=new TextToSpeech(this, (TextToSpeech.OnInitListener) this);
        dbOpenHelper=new DBOpenHelper(ReviewActivity.this,"learnedwords_db",null,1);
        cursor=dbOpenHelper.getReadableDatabase().query("learnedwords",null,"id=?",new String[]{id+""},null,null,null);
        ArrayList<Map<String,String>> resultList= new ArrayList<Map<String,String>>();
        while(cursor.moveToNext()){
            if(Integer.valueOf(cursor.getString(3))<=4){

                Map<String,String> map=new HashMap<String, String>();
                map.put("word",cursor.getString(1));
                map.put("ph","");
                map.put("trans",cursor.getString(cursor.getColumnIndex(Learnedword.COLUME_MEANING)));
                resultList.add(map);
                SimpleAdapter simpleAdapter=new SimpleAdapter(ReviewActivity.this,resultList,
                        R.layout.item,
                        new String[]{"word","ph","trans"},
                        new int[]{R.id.word,R.id.ph,R.id.trans});
                listView.setAdapter(simpleAdapter);
                ContentValues cv = new ContentValues();
                cv.put("word", cursor.getString(1));
                cv.put("meaning",cursor.getString(2));
                cv.put("learned_times",Integer.valueOf(cursor.getString(3))+1+"");
                dbOpenHelper.getReadableDatabase().update("learnedwords",cv,"id=?",new String[]{id+""});
                id++;
            }
            else{
                id++;
                cursor=dbOpenHelper.getReadableDatabase().query("learnedwords",null,"id=?",new String[]{id+""},null,null,null);
            }

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                cursor=dbOpenHelper.getReadableDatabase().query("learnedwords",null,"id=?",new String[]{id+""},null,null,null);
                ArrayList<Map<String,String>> resultList= new ArrayList<Map<String,String>>();
                while(cursor.moveToNext()){
                    if(Integer.valueOf(cursor.getString(3))<=4){

                        Map<String,String> map=new HashMap<String, String>();
                        map.put("word",cursor.getString(1));
                        map.put("ph","");
                        map.put("trans",cursor.getString(cursor.getColumnIndex(Learnedword.COLUME_MEANING)));
                        resultList.add(map);
                        SimpleAdapter simpleAdapter=new SimpleAdapter(ReviewActivity.this,resultList,
                            R.layout.item,
                            new String[]{"word","ph","trans"},
                            new int[]{R.id.word,R.id.ph,R.id.trans});
                        listView.setAdapter(simpleAdapter);
                        ContentValues cv = new ContentValues();
                        cv.put("word", cursor.getString(1));
                        cv.put("meaning",cursor.getString(2));
                        cv.put("learned_times",Integer.valueOf(cursor.getString(3))+1+"");
                        dbOpenHelper.getReadableDatabase().update("learnedwords",cv,"id=?",new String[]{id+""});
                        id++;
                    }
                    else{
                       id++;
                       cursor=dbOpenHelper.getReadableDatabase().query("learnedwords",null,"id=?",new String[]{id+""},null,null,null);
                    }

                }
            }

        });
        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id--;
                cursor=dbOpenHelper.getReadableDatabase().query("learnedwords",null,"id=?",new String[]{id+""},null,null,null);
                while(cursor.moveToNext()){
                    // 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                    tts.setPitch(0.5f);
                    //设定语速 ，默认1.0正常语速
                    tts.setSpeechRate(1.5f);
                    //朗读，注意这里三个参数的added in API level 4   四个参数的added in API level 21
                    tts.speak(cursor.getString(cursor.getColumnIndex(Learnedword.COLUME_WORD)).toString(), TextToSpeech.QUEUE_FLUSH, null);
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

    }
}
