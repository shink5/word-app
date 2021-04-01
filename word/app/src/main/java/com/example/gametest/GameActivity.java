package com.example.gametest;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.menu.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private String[] words = {"collection","fire","adapter","drawable","constant","select","data","external","bill","gravity"};
    private Character[][] Matrix=new Character[2][2];
    private Map<String,int[]> wordlist = new HashMap();/**存放单词以及它的起始坐标(包括横纵向信息)*/
    private Boolean created = false;
    private GridLayout gridLayout;
    private TextView textView,word_1,word_2,word_3,word_4,word_5,word_6,word_7,word_8,word_9,word_10;
    private TextView[] wordtext = new TextView[10];
    private int Maxtri_length;
    private int[][] used = new int[][]{{0}};
    private MutableLiveData<int[][]> mutableLiveData = new MutableLiveData<>();
    private Map<String,Integer> found = new HashMap<>();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        findTextViewId();

        Create_Matrix();
        buildfullMatrix();

        gridLayout = findViewById(R.id.grid_layout);
        textView = findViewById(R.id.words);

        gridLayout.setColumnCount(Maxtri_length);
        gridLayout.setRowCount(Maxtri_length);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            int x,y;
            @Override
            public void onClick(View v) {
                if (v instanceof Button){
                    x = (int)v.getTag(R.id.x); y = (int)v.getTag(R.id.y);
                    if (used[x][y]==2){
                    }else {
                        if (used[x][y]==0){
                            v.setBackgroundColor(Color.RED);
                            used[x][y] = 1;
                            mutableLiveData.postValue(used);
                        }else {
                            v.setBackgroundColor(Color.WHITE);
                            used[x][y] = 0;
                            mutableLiveData.postValue(used);
                        }
                    }
                }
            }
        };

        mutableLiveData.observe(this, new Observer<int[][]>() {
            int x,y;
            int make_it = 0;
            @Override
            public void onChanged(int[][] ints) {
                for (Map.Entry<String, int[]> entry : wordlist.entrySet()){
                    x = entry.getValue()[0]; y = entry.getValue()[1];
                    if (found.get(entry.getKey())==1) continue;
                    Boolean singel_success = true;
                    for (int i = 0; i < entry.getKey().length(); i++){
                        if (entry.getValue()[2]==0){//水平
                            if (ints[x][y+i]==0) singel_success = false;
                        }else {//竖直
                            if (ints[x+i][y]==0) singel_success = false;
                        }
                    }
                    if (singel_success) {
                        Toast.makeText(getApplicationContext(),entry.getKey(),Toast.LENGTH_SHORT).show();
                        make_it++; one_success(entry.getKey()); found.put(entry.getKey(),1);
                        refleshtextword(entry.getKey());
                    }
                }
                if (make_it == 10){
                    Toast.makeText(getApplicationContext(),"你成功了",Toast.LENGTH_LONG).show();
                }
            }
        });

        for (int i = 0; i < Maxtri_length; i++) {/**行*/
            for (int j = 0; j < Maxtri_length;j++){/**列*/
                Button button = new Button(this);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width =0;
                params.height =0;

                    // 设置行列下标，和比重
                    params.rowSpec = GridLayout.spec(i,1f);
                    params.columnSpec = GridLayout.spec(j,1f);

                    // 背景
                    button.setBackgroundColor(Color.WHITE);

                    // 居中显示
                    button.setGravity(Gravity.CENTER);

                    //设置标记
                    button.setTag(R.id.x,i); button.setTag(R.id.y,j);/**横纵坐标*/

                    //设置监听
                    button.setOnClickListener(onClickListener);

                    // 设置边距
                    params.setMargins(2,2,2,2);


                // 设置文字
                button.setText(Matrix[i][j].toString());
                button.setTextSize(10);

                // 添加item
                gridLayout.addView(button,params);
            }
        }

        if(Matrix[0][0]==null){
            Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
        }
        print_Matrix();

    }

    public int Matrix_Long(String[] wordlist){
        int l = 0;
        for (String s : wordlist){
            if (s.length() > l) l=s.length();
        }
        return l+1;
    }

    public void one_success(String word){
        int[] ints = wordlist.get(word);
        int x = ints[0]; int y = ints[1];
        for (int i = 0; i < word.length(); i++){
            if (ints[2]==0){//水平
                used[x][y+i] = 2;
            }else {//竖直
                used[x+i][y] = 2;
            }
        }
    }

    public void Create_Matrix() {
        Maxtri_length = Matrix_Long(words);
        Matrix = new Character[Maxtri_length][Maxtri_length];
        used = new int[Maxtri_length][Maxtri_length];

        int[] firstlist_1 = new int[]{0,1,0,1,0,1,0,1,0,1};
        int[] firstlist_2 = new int[]{0,0,0,0,0,1,1,1,1,1};
        /**两个横纵探测数组，如第一个不成功，调用第二个，再不成功就算了*/

        Boolean flag = true;

        int i = 0;
        for (String s : words){
            if (!input_word(s,firstlist_1[i])) {/**插入不成功时换一个探测数组*/
                flag = false;
                break;
            }
            i++;
        }
        if (!flag){
            Matrix = new Character[Maxtri_length][Maxtri_length];
//            used = new int[Matrix_Long(words)][Matrix_Long(words)];
            int j = 0;
            for (String s : words){
                if (!input_word(s,firstlist_2[j])) {/**插入不成功时换一个探测数组*/
                    flag = false;
                    break;
                }
                j++;
            }
        }
        if (!flag){
            Toast.makeText(getApplicationContext(),"构建矩阵失败！",Toast.LENGTH_SHORT);
        }else created = true;
    }

    private Boolean input_word(String word,int first){/**first为0则先横，为1则先纵*/
        int[] start_layout = null;
        if (first==0){
            start_layout = horizon_search(word);
            if (start_layout==null){
                start_layout = vertical_search(word);
            }
        }
        if (first==1){
            start_layout = vertical_search(word);
            if (start_layout==null){
                start_layout = horizon_search(word);
            }
        }
        if (start_layout==null){
            return false;

        }
        int j = 0;
        if (start_layout[2]==0){/**水平放置单词*/
            for (Character c : word.toCharArray()){
                Matrix[start_layout[0]][start_layout[1]+j] = c;
                j++;
            }
        }else {/**竖直放置单词*/
            for (Character c : word.toCharArray()){
                Matrix[start_layout[0]+j][start_layout[1]] = c;
                j++;
            }
        }
        wordlist.put(word,start_layout);
        found.put(word,0);
        return true;
    }

    /**横向探测是否有效
     * @return*/
    private int[] horizon_search(String s){

        int max_size = Maxtri_length;
        int available_size = max_size - s.length() + 1;
        int[][] available_startpiont = new int[max_size][available_size];
        Random random = new Random();

        while (isavailable(available_startpiont)){
            int[] start = new int[]{random.nextInt(max_size),random.nextInt(available_size),0};/**起始坐标[0_x][1_y],最后一个为0是横，为1是竖*/
            if (available_startpiont[start[0]][start[1]]==1) continue;/**起始点已探测过，重来！*/
            else {
                int j = 0;
                for (Character c : s.toCharArray()){
                    if (Matrix[start[0]][start[1]+j]!=null && Matrix[start[0]][start[1]+j]!=c){
                        available_startpiont[start[0]][start[1]] = 1;
                        break;
                    }
                    j++;
                }
                if (available_startpiont[start[0]][start[1]]==0 && j==s.length()){
                    return start;
                }
            }
        }
        return null;
    }

    /**纵向探测是否有效*/
    private int[] vertical_search(String s){
        int max_size = Maxtri_length;
        int available_size = max_size - s.length() + 1;
        int[][] available_startpiont = new int[available_size][max_size];
        Random random = new Random();

        while (isavailable(available_startpiont)){
            int[] start = new int[]{random.nextInt(available_size),random.nextInt(max_size),1};/**起始坐标[0_x][1_y],最后一个为0是横，为1是竖*/
            if (available_startpiont[start[0]][start[1]]==1) continue;/**起始点已探测过，重来！*/
            else {
                int j = 0;
                for (Character c : s.toCharArray()){
                    if (Matrix[start[0]+j][start[1]]!=null && Matrix[start[0]+j][start[1]]!=c){
                        available_startpiont[start[0]][start[1]] = 1;
                        break;
                    }
                    j++;
                }
                if (available_startpiont[start[0]][start[1]]==0 && j==s.length()){
                    return start;
                }
            }
        }
        return null;
    }

    Boolean isavailable(int[][] arr){
        for(int i = 0;i < arr.length;i++){
            //System.out.println(arr[i]);//arr中元素：2个数组的地址
            //遍历arr[0]，arr中元素第一个数组
            for(int j = 0;j < arr[i].length;j++){
                if (j==0) return true;
            }
        }
        return false;
    }

    public void print_Matrix(){
        for(int i = 0;i < Matrix.length;i++){
            //System.out.println(arr[i]);//arr中元素：2个数组的地址
            //遍历arr[0]，arr中元素第一个数组
            for(int j = 0;j < Matrix[i].length;j++){
                if (Matrix[i][j]!=null){
                    System.out.print(Matrix[i][j]+",");
                }else {
                    System.out.print("# ,");
                }
            }
            System.out.print("\n");
        }

    }

    public void buildfullMatrix(){
        for(int i = 0;i < Matrix.length;i++){
            //System.out.println(arr[i]);//arr中元素：2个数组的地址
            //遍历arr[0]，arr中元素第一个数组
            Character c = 'R';
            for(int j = 0;j < Matrix[i].length;j++){
                if (Matrix[i][j]!=null){

                }else {
                    Matrix[i][j] = c;
                }
            }
        }
    }

    public Boolean iscearted(){
        return created;
    }

    public void findTextViewId(){
        String t = "word_";
        wordtext[0] = word_1 = findViewById(R.id.word_1);
        wordtext[1] = word_2 = findViewById(R.id.word_2);
        wordtext[2] = word_3 = findViewById(R.id.word_3);
        wordtext[3] = word_4 = findViewById(R.id.word_4);
        wordtext[4] = word_5 = findViewById(R.id.word_5);
        wordtext[5] = word_6 = findViewById(R.id.word_6);
        wordtext[6] = word_7 = findViewById(R.id.word_7);
        wordtext[7] = word_8 = findViewById(R.id.word_8);
        wordtext[8] = word_9 = findViewById(R.id.word_9);
        wordtext[9] = word_10 = findViewById(R.id.word_10);
        for (int i = 0; i < 10 ; i++){
           wordtext[i].setText(words[i]);
        }
    }

    public void refleshtextword(String s){
        for (int i = 0; i < 10 ; i++){
            if (wordtext[i].getText().equals(s)){
                wordtext[i].setTextColor(Color.RED);
            }
        }
    }
}
