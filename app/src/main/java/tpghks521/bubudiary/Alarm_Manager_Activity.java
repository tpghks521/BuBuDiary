package tpghks521.bubudiary;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Alarm_Manager_Activity extends AppCompatActivity {
    RelativeLayout alarm_layout_before_at_clock;
    RelativeLayout alarm_layout_before_d1_clock;
    RelativeLayout alarm_layout_before_d2_clock;
    RelativeLayout alarm_layout_before_h12_clock;
    RelativeLayout alarm_layout_before_h1_clock;
    RelativeLayout alarm_layout_before_h2_clock;
    RelativeLayout alarm_layout_before_h3_clock;
    RelativeLayout alarm_layout_before_m10_clock;
    RelativeLayout alarm_layout_before_m15_clock;
    RelativeLayout alarm_layout_before_m30_clock;
    RelativeLayout alarm_layout_before_m5_clock;
    RelativeLayout alarm_layout_before_w1_clock;
    TextView before_d1;
    TextView before_d2;
    TextView before_h1;
    TextView before_h12;
    TextView before_h2;
    TextView before_h3;
    TextView before_m10;
    TextView before_m15;
    TextView before_m30;
    TextView before_m5;
    TextView before_w1;
    TextView before_at;
    RelativeLayout[] relativeLayouts = new RelativeLayout[12];
    TextView[] befores = new TextView[12];
    TextView[] befores_text = new TextView[12];
    TextView alarm_manager_popup;
    TextView alarm_manager_email;
    TextView alarm_manager_popup_textview;
    TextView alarm_manager_email_textview;
    ImageView alarm_manager_click_add;
    View[] views = new View[12];
    boolean[] check_selcet = new boolean[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm__manager_);

        findId();

        for (int i = 0; i < 12; i++) {
            System.out.println(views[i] + "여기요");
        }

        alarm_manager_click_add.setOnClickListener(click_add);
        for (int i = 0; i < 12; i++) {
            relativeLayouts[i].setBackgroundColor(Color.parseColor("#bbbbbb"));

            views[i].setOnClickListener(view_listner);

        }


    }//oncreate

    //--------------------------------------------------------------------------------------- 버튼 레이아웃 클릭리스너
    boolean clickbtn_layout = false;
    View.OnClickListener view_listner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            switch (view.getId()) {
//-------------------------------------------------------------------------------------------------------
                case R.id.view01:
                    if (check_selcet[0]) {
                        relativeLayouts[0].setBackgroundColor(Color.parseColor("#bbbbbb"));
                        befores[0].setTextColor(Color.parseColor("#000000"));
                        check_selcet[0] = false;

                    } else {
                        relativeLayouts[0].setBackgroundColor(Color.parseColor("#ffffff"));
                        befores[0].setTextColor(Color.parseColor("#0097a7"));
                        check_selcet[0] = true;
                    }
                    break;
//-------------------------------------------------------------------------------------------------------
                case R.id.view02:

                    if (check_selcet[1]) {
                        returnColor(1);
                        delet_popup_text(1);
                    } else {
                        changeColor(1);
                        input_popup_text(1);
                    }
                    break;
//-------------------------------------------------------------------------------------------------------
                case R.id.view03:
                    if (check_selcet[2]) {
                        returnColor(2);
                        delet_popup_text(2);
                    } else {
                        changeColor(2);
                        input_popup_text(2);
                    }
                    break;
//-------------------------------------------------------------------------------------------------------
                case R.id.view04:
                    if (check_selcet[3]) {
                        returnColor(3);
                        delet_popup_text(3);
                    } else {
                        changeColor(3);
                        input_popup_text(3);
                    }
                    break;
//-------------------------------------------------------------------------------------------------------
                case R.id.view05:
                    if (check_selcet[4]) {
                        returnColor(4);
                    } else {
                        changeColor(4);
                        input_popup_text(4);
                    }
                    break;
//-------------------------------------------------------------------------------------------------------
                case R.id.view06:
                    if (check_selcet[5]) {
                        returnColor(5);
                        delet_popup_text(5);
                    } else {
                        changeColor(5);
                        input_popup_text(5);
                    }
                    break;
//-------------------------------------------------------------------------------------------------------
                case R.id.view07:
                    if (check_selcet[6]) {
                        returnColor(6);
                        delet_popup_text(6);
                    } else {
                        changeColor(6);
                        input_popup_text(6);
                    }
                    break;
//-------------------------------------------------------------------------------------------------------
                case R.id.view08:
                    if (check_selcet[7]) {
                        returnColor(7);
                        delet_popup_text(7);
                    } else {
                        changeColor(7);
                        input_popup_text(7);
                    }
                    break;
//-------------------------------------------------------------------------------------------------------
                case R.id.view09:
                    if (check_selcet[8]) {
                        returnColor(8);
                        delet_popup_text(8);
                    } else {
                        changeColor(8);
                        input_popup_text(8);
                    }
                    break;
//-------------------------------------------------------------------------------------------------------
                case R.id.view10:
                    if (check_selcet[9]) {
                        returnColor(9);
                        delet_popup_text(9);
                    } else {
                        changeColor(9);
                        input_popup_text(9);
                    }
                    break;
//-------------------------------------------------------------------------------------------------------
                case R.id.view11:
                    if (check_selcet[10]) {
                        returnColor(10);
                        delet_popup_text(10);
                    } else {
                        changeColor(10);
                        input_popup_text(10);
                    }
                    break;
//-------------------------------------------------------------------------------------------------------
                case R.id.view12:
                    if (check_selcet[11]) {
                        returnColor(11);
                        delet_popup_text(11);
                    } else {
                        changeColor(11);
                        input_popup_text(11);
                    }
                    break;

            }//switch

        }//onclick
    };

    //-----------------------------------------------------------------------------------------------------
    void changeColor(int num) {
        relativeLayouts[num].setBackgroundColor(Color.parseColor("#ffffff"));
        befores[num].setTextColor(Color.parseColor("#0097a7"));
        befores_text[num].setTextColor(Color.parseColor("#0097a7"));
        check_selcet[num] = true;
    }//changeColor

    void returnColor(int num) {
        relativeLayouts[num].setBackgroundColor(Color.parseColor("#bbbbbb"));
        befores[num].setTextColor(Color.parseColor("#000000"));
        befores_text[num].setTextColor(Color.parseColor("#000000"));
        check_selcet[num] = false;
    }//returnColor

    void input_popup_text(int number) {

        String num = befores[number].getText().toString();
        String num_text = befores_text[number].getText().toString();
        String inputtext = num + num_text;


        if (alarm_manager_popup_textview.getText().toString().equals("")) {
            alarm_manager_popup_textview.append(inputtext);

        } else {

            alarm_manager_popup_textview.append(",  " + inputtext);

        }
    }//input_popup_text

    String inputtext;

    //체크 셀렉트 사용해서 트루인것들만 출력하기 선택한걸 false로 바꾸고
    void delet_popup_text(int number) {

        inputtext = "";

        alarm_manager_popup_textview.setText(inputtext);
        for (int i = 0; i < 12; i++) {
            if (check_selcet[i]) {

                String num = befores[i].getText().toString();
                String num_text = befores_text[i].getText().toString();
                if (inputtext == "") {
                    inputtext = inputtext + num + num_text;
                } else {
                    inputtext = inputtext + ",  " + num + num_text;
                }

                alarm_manager_popup_textview.setText(inputtext);

            }

        }
    }//delet_popup_text

//---------------------------------------------------------------------------------------저장 클릭리스너

    View.OnClickListener click_add = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String email_edit = alarm_manager_email_textview.getText().toString();
            String popup_edit = alarm_manager_popup_textview.getText().toString();
            Add_Plan_Activity.alarmText.setText(popup_edit + " 팝업");
            Add_Plan_Activity.alarmText.setTextSize(15);
            Add_Plan_Datas.setAlarm_popdup_data(popup_edit);

            finish();
        }
    };
//---------------------------------------------------------------------------------------

    void findId() {
        alarm_manager_click_add = findViewById(R.id.alarm_manager_click_add);
        alarm_manager_popup = findViewById(R.id.alarm_manager_popup_text);
        alarm_manager_email = findViewById(R.id.alarm_manager_email_text);
        alarm_manager_popup_textview = findViewById(R.id.alarm_manager_popup_edit);
        alarm_manager_email_textview = findViewById(R.id.alarm_manager_email_edit);


        alarm_layout_before_at_clock = findViewById(R.id.alarm_layout_before_at_clock);
        alarm_layout_before_d1_clock = findViewById(R.id.alarm_layout_before_d1_clock);
        alarm_layout_before_h12_clock = findViewById(R.id.alarm_layout_before_h12_clock);
        alarm_layout_before_h1_clock = findViewById(R.id.alarm_layout_before_h1_clock);
        alarm_layout_before_h2_clock = findViewById(R.id.alarm_layout_before_h2_clock);
        alarm_layout_before_h3_clock = findViewById(R.id.alarm_layout_before_h3_clock);
        alarm_layout_before_m10_clock = findViewById(R.id.alarm_layout_before_m10_clock);
        alarm_layout_before_m15_clock = findViewById(R.id.alarm_layout_before_m15_clock);
        alarm_layout_before_m30_clock = findViewById(R.id.alarm_layout_before_m30_clock);
        alarm_layout_before_m5_clock = findViewById(R.id.alarm_layout_before_m5_clock);
        alarm_layout_before_w1_clock = findViewById(R.id.alarm_layout_before_w1_clock);
        alarm_layout_before_d2_clock = findViewById(R.id.alarm_layout_before_d2_clock);
        relativeLayouts[0] = alarm_layout_before_at_clock;
        relativeLayouts[1] = alarm_layout_before_m5_clock;
        relativeLayouts[2] = alarm_layout_before_m10_clock;
        relativeLayouts[3] = alarm_layout_before_m15_clock;
        relativeLayouts[4] = alarm_layout_before_m30_clock;
        relativeLayouts[5] = alarm_layout_before_h1_clock;
        relativeLayouts[6] = alarm_layout_before_h2_clock;
        relativeLayouts[7] = alarm_layout_before_h3_clock;
        relativeLayouts[8] = alarm_layout_before_h12_clock;
        relativeLayouts[9] = alarm_layout_before_d1_clock;
        relativeLayouts[10] = alarm_layout_before_d2_clock;
        relativeLayouts[11] = alarm_layout_before_w1_clock;
        before_at = findViewById(R.id.before_at);
        before_d1 = findViewById(R.id.before_d1);
        before_d2 = findViewById(R.id.before_d2);
        before_h1 = findViewById(R.id.before_h1);
        before_h12 = findViewById(R.id.before_h12);
        before_h2 = findViewById(R.id.before_h2);
        before_h3 = findViewById(R.id.before_h3);
        before_m10 = findViewById(R.id.before_m10);
        before_m15 = findViewById(R.id.before_m15);
        before_m30 = findViewById(R.id.before_m30);
        before_m5 = findViewById(R.id.before_m5);
        before_w1 = findViewById(R.id.before_w1);


        befores[0] = before_at;
        befores[1] = before_m5;
        befores[2] = before_m10;
        befores[3] = before_m15;
        befores[4] = before_m30;
        befores[5] = before_h1;
        befores[6] = before_h2;
        befores[7] = before_h3;
        befores[8] = before_h12;
        befores[9] = before_d1;
        befores[10] = before_d2;
        befores[11] = before_w1;

        befores_text[0] = before_at;
        befores_text[1] = findViewById(R.id.before_m5_text);
        befores_text[2] = findViewById(R.id.before_m10_text);
        befores_text[3] = findViewById(R.id.before_m15_text);
        befores_text[4] = findViewById(R.id.before_m30_text);
        befores_text[5] = findViewById(R.id.before_h1_text);
        befores_text[6] = findViewById(R.id.before_h2_text);
        befores_text[7] = findViewById(R.id.before_h3_text);
        befores_text[8] = findViewById(R.id.before_h12_text);
        befores_text[9] = findViewById(R.id.before_d1_text);
        befores_text[10] = findViewById(R.id.before_d2_text);
        befores_text[11] = findViewById(R.id.before_w1_text);
        for (int i = 0; i < 12; i++) {

            views[i] = findViewById(R.id.view01 + i);

        }//for

    }//findId

}//class
