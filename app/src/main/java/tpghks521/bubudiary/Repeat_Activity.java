package tpghks521.bubudiary;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Repeat_Activity extends AppCompatActivity {

    View[] select_Views = new View[3];
    RelativeLayout[] select_relativeLayouts = new RelativeLayout[3];
    TextView[] select_texts = new TextView[3];

    TextView alarm_manager_popup_text, alarm_manager_popup_text2;
    TextView alarm_manager_email_edit;
    LinearLayout layouteveryday, layoutend_day, tablinearlayout;
    CardView[] cardViews = new CardView[7];
    View[] weekviews = new View[7];
    TextView[] weektextview = new TextView[7];
    LinearLayout weeklayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat_);
        findView();


    }//oncreate

    View.OnClickListener viewsclickListner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.repeat_clickbtn01:
                    clickbtn(0);
                    clickoff(1);
                    clickoff(2);
                    setvisible(0);
                    weeklayout.setVisibility(View.INVISIBLE);
                    break;
                case R.id.repeat_clickbtn02:
                    weeklayout.setVisibility(View.INVISIBLE);
                    clickbtn(1);
                    clickoff(0);
                    clickoff(2);
                    change_text(1);
                    setvisible(1);
                    break;
                case R.id.repeat_clickbtn03:
                    weeklayout.setVisibility(View.VISIBLE);
                    clickbtn(2);
                    clickoff(1);
                    clickoff(0);
                    change_text(2);
                    setvisible(2);
                    break;


            }

        }
    };

    void setvisible(int num) {
        if (num == 0) {
            layouteveryday.setVisibility(View.INVISIBLE);
            layoutend_day.setVisibility(View.INVISIBLE);


        } else {
            layouteveryday.setVisibility(View.VISIBLE);
            layoutend_day.setVisibility(View.VISIBLE);
        }

    }


    void clickbtn(int num) {

        select_relativeLayouts[num].setBackgroundColor(Color.parseColor("#ffffff"));
        select_texts[num].setTextColor(Color.parseColor("#0097a7"));
    }//clickbtn

    void clickoff(int num) {
        select_relativeLayouts[num].setBackgroundColor(Color.parseColor("#aaaaaa"));
        select_texts[num].setTextColor(Color.parseColor("#000000"));
    }

    void change_text(int num) {
        if (num == 1) {
            alarm_manager_popup_text.setText("매일");
            alarm_manager_popup_text2.setText("반복");
            alarm_manager_email_edit.setText("일마다");
        } else {
            alarm_manager_popup_text.setText("매주");
            alarm_manager_email_edit.setText("주마다");
        }
    }

    boolean[] checkweekviews = new boolean[7];
    View.OnClickListener circleTextOnclicklistner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.weekview_01:
                    int casnumber0 = 0;
                    if (checkweekviews[casnumber0]) {
                        nonclickweeview(casnumber0);
                    } else {
                        clickweekview(casnumber0);
                    }

                    break;
                case R.id.weekview_02:
                    int casnumber1 = 1;
                    if (checkweekviews[casnumber1]) {
                        nonclickweeview(casnumber1);
                    } else {
                        clickweekview(casnumber1);
                    }
                    break;
                case R.id.weekview_03:
                    int casnumber2 = 2;
                    if (checkweekviews[casnumber2]) {
                        nonclickweeview(casnumber2);
                    } else {
                        clickweekview(casnumber2);
                    }
                    break;
                case R.id.weekview_04:
                    int casnumber3 = 3;
                    if (checkweekviews[casnumber3]) {
                        nonclickweeview(casnumber3);
                    } else {
                        clickweekview(casnumber3);
                    }
                    break;
                case R.id.weekview_05:
                    int casnumber4 = 4;
                    if (checkweekviews[casnumber4]) {
                        nonclickweeview(casnumber4);
                    } else {
                        clickweekview(casnumber4);
                    }
                    break;
                case R.id.weekview_06:
                    int casnumber5 = 5;
                    if (checkweekviews[casnumber5]) {
                        nonclickweeview(casnumber5);
                    } else {
                        clickweekview(casnumber5);
                    }

                    break;
                case R.id.weekview_07:
                    int casnumber6 = 6;
                    if (checkweekviews[casnumber6]) {
                        nonclickweeview(casnumber6);
                    } else {
                        clickweekview(casnumber6);
                    }
                    break;


            }//switch


        }//onclick
    };//listner


    void clickweekview(int num) {
        checkweekviews[num] = true;
        cardViews[num].setCardBackgroundColor(Color.parseColor("#0097a7"));
        weektextview[num].setTextColor(Color.parseColor("#ffffff"));

        alarm_manager_popup_text2.append(weektextview[num].getText()+",");
    }//clickweekview

    void nonclickweeview(int num) {
        checkweekviews[num] = false;
        cardViews[num].setCardBackgroundColor(Color.parseColor("#ffffff"));
        weektextview[num].setTextColor(Color.parseColor("#000000"));
        alarm_manager_popup_text2.setText("");
        for(int i=0;i<7;i++) {
            if (checkweekviews[i]){

                alarm_manager_popup_text2.append(weektextview[i].getText().toString()+",");
            }

        }
    }


    void findView() {

        for (int i = 0; i < 3; i++) {
            select_Views[i] = findViewById(R.id.repeat_clickbtn01 + i);
            select_Views[i].setClickable(true);
            select_Views[i].setOnClickListener(viewsclickListner);
        }
        select_relativeLayouts[0] = findViewById(R.id.repeat_None);
        select_relativeLayouts[1] = findViewById(R.id.repeat_everyday);
        select_relativeLayouts[2] = findViewById(R.id.repeat_everyweek);
        select_texts[0] = findViewById(R.id.repeat_None_text);
        select_texts[1] = findViewById(R.id.repeat_everyday_text);
        select_texts[2] = findViewById(R.id.repeat_everyweek_text);
        alarm_manager_popup_text = findViewById(R.id.alarm_manager_popup_text);
        alarm_manager_popup_text2 = findViewById(R.id.alarm_manager_popup_text02);
        alarm_manager_email_edit = findViewById(R.id.alarm_manager_email_edit);
        layouteveryday = findViewById(R.id.layouteveryday);
        layoutend_day = findViewById(R.id.layoutend_day);
        tablinearlayout = findViewById(R.id.tablinearlayout);
        for (int i = 0; i < 7; i++) {
            cardViews[i] = findViewById(R.id.weekcardview_01 + i);
            weekviews[i] = findViewById(R.id.weekview_01 + i);
            weektextview[i] = findViewById(R.id.weektextview_01 + i);
            weekviews[i].setClickable(true);
            weekviews[i].setOnClickListener(circleTextOnclicklistner);

        }
        weeklayout=findViewById(R.id.weeklayout);
    }//findView


    public void click_repeat_add(View view) {
      String result=   alarm_manager_popup_text2.getText().toString();
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        finish();
    }
}//class
