package com.example.menu.ui.notifications;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.chart.ChartView;
import com.example.chart.Constant;
import com.example.tabbartest.DataBase.LearnedWordHelper;
import com.example.tabbartest.model.Learnedword;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChartFragment extends Fragment {


    LearnedWordHelper learnedWordHelper;

    private String[] X;
    private String[] Y;
    private String[] data;
    private int[] Yint;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        /* 显示App icon左侧的back键 */


        X = new String[] { "7-11", "7-12", "7-13", "7-14", "7-15",
                "7-16", "7-17" };
        Y = new String[] { "", "50", "100", "150", "200", "250" };

        Yint = new int[] {0,0,0,0,0,0,0};
        data = new String[] { "150", "23", "10", "36", "45", "40", "12" };
        Constant.point = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(Constant.point);//获取屏幕分辨率

        ChartView myView=new ChartView(getActivity());


//        learnedword.id 为从1开始的自增
//        List<Learnedword> learnedwordList = new ArrayList<>();
//        learnedWordHelper.getReadableDatabase();
//        learnedwordList = learnedWordHelper.getAllLearnedwords();
//        for (int i=1;i<learnedwordList.size();i++){
//            Log.d("MainActivity2","This is ID:" + String.valueOf(learnedwordList.get(i).getId()));
//        }


        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日");

        String dateNow = dateFormat.format(date);
        String monthNow = dateNow.substring(0,dateNow.lastIndexOf("月"));
        String dayNow = dateNow.substring(dateNow.lastIndexOf("月")+1,dateNow.lastIndexOf("日"));

//        Toast.makeText(getActivity(),dateNow,Toast.LENGTH_LONG).show();


        learnedWordHelper = new LearnedWordHelper(getActivity());
        int latestId = learnedWordHelper.getLearnedwordsCount()-1;
//        Toast.makeText(this,String.valueOf(latestId),Toast.LENGTH_LONG).show();


        for(int counter = 6;counter > -1;counter--){

            X[counter] = dateNow;

            int newId,state;
            state = 0;
            newId = latestId;

            do {
                state = Judge(newId,monthNow,dayNow,counter,state);
                newId--;
                Log.d("TAG:",String.valueOf(newId));
            }while (state != -1);

            dateNow = getNextDay(dateNow,"-1");
//            Toast.makeText(this,dateNow,Toast.LENGTH_LONG).show();

            monthNow = dateNow.substring(0,dateNow.lastIndexOf("月"));
            dayNow = dateNow.substring(dateNow.lastIndexOf("月")+1,dateNow.lastIndexOf("日"));

        }

        for (int i=0;i<data.length;i++){
            data[i] = String.valueOf(Yint[i]);
        }


        myView.SetInfo(X, // X轴刻度
                Y, // Y轴刻度
                data, // 数据
                "图标的标题");

        return myView;
    }

    // 顶部返回键
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                this.onStop();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private int Judge(int id,String monthNow,String dayNow,int index,int state0){

        learnedWordHelper.getReadableDatabase();
        Learnedword learnedword = learnedWordHelper.getLearnedword(id);

        if (learnedword == null){
//            Toast.makeText(getActivity(),"你最近还没有学过单词，快去学习吧！",Toast.LENGTH_LONG).show();
            return -1;
        }
        String timeStamp = learnedword.getTimestamp();

        String Month,Day;
        Month = timeStamp.substring(5,timeStamp.lastIndexOf("-"));

        if(timeStamp.substring(timeStamp.lastIndexOf("-")+2,timeStamp.lastIndexOf("-")+3) == "-"){
            Day = timeStamp.substring(timeStamp.lastIndexOf("-")+1,timeStamp.lastIndexOf("-")+2);
        }
        else
            Day = timeStamp.substring(timeStamp.lastIndexOf("-")+1,timeStamp.lastIndexOf("-")+3);

        Log.d("MainActivity2","Time:" + Month +"月"+ Day + "日");


        if ((Month.equals(monthNow))&&(Day.equals(dayNow))){
            Yint[index]++;
            return 1;
        }
        else if(state0 == 1){
            return -1;
        }
        else return 0;
    }


    /**
     * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
     */
    public String getNextDay(String nowdate, String delay) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
            String mdate = "";
            Date d = strToDate(nowdate);
            long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
            d.setTime(myTime * 1000);
            mdate = format.format(d);

            return mdate;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }




}