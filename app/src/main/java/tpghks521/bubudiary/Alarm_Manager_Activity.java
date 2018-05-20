package tpghks521.bubudiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    RelativeLayout[] relativeLayouts = new RelativeLayout[12];
    TextView[] textViews= new TextView[12];
    TextView alarm_manager_popup;
    TextView alarm_manager_email;
    EditText alarm_manager_popup_edit;
    EditText alarm_manager_email_edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm__manager_);
        findId();



    }//oncreate

    void findId(){
        alarm_manager_popup =findViewById(R.id.alarm_manager_popup_text);
        alarm_manager_email=findViewById(R.id.alarm_manager_email_text);
        alarm_manager_popup_edit=findViewById(R.id.alarm_manager_popup_edit);
        alarm_manager_email_edit=findViewById(R.id.alarm_manager_email_edit);


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

        relativeLayouts[0]=alarm_layout_before_at_clock;
        relativeLayouts[1]=alarm_layout_before_m5_clock;
        relativeLayouts[2]=alarm_layout_before_m10_clock;
        relativeLayouts[3]=alarm_layout_before_m15_clock;
        relativeLayouts[4]=alarm_layout_before_m30_clock;
        relativeLayouts[5]=alarm_layout_before_h1_clock;
        relativeLayouts[6]=alarm_layout_before_h2_clock;
        relativeLayouts[7]=alarm_layout_before_h3_clock;
        relativeLayouts[8]=alarm_layout_before_h12_clock;
        relativeLayouts[9]=alarm_layout_before_d1_clock;
        relativeLayouts[10]=alarm_layout_before_d2_clock;


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


















    }

}//class
