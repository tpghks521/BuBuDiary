package tpghks521.bubudiary;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Add_Plan_Activity extends AppCompatActivity {

    LinearLayout setting_alarm;
    EditText add_activity_title, add_activity_place;
    public static TextView addactivity_date, addactivity_time;
    public static TextView alarmText, repeatText;
    ImageView add_activity_alarm;
    String date;
    String year;
    String month;
    String day;
    String plan;
    String time;
    String repeat;
    String alarm;

    String personEmail;
    String cu_year;
    String cu_month_date;
    String cu_time;
    String sel_fm_am;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__plan_);
        getTime();

        alarmText = findViewById(R.id.alaramText);
        repeatText = findViewById(R.id.repeatTest);
        setting_alarm = findViewById(R.id.setting_alarm);
        add_activity_title = findViewById(R.id.add_activity_title);
        add_activity_place = findViewById(R.id.add_activity_place);
        addactivity_date = findViewById(R.id.addactivity_date);
        addactivity_time = findViewById(R.id.addactivity_time);
        add_activity_alarm = findViewById(R.id.add_activity_alarm);

        Intent intent = getIntent();
        year = intent.getStringExtra("year");
        month = intent.getStringExtra("month");
        day = intent.getStringExtra("day");


        addactivity_time.setText(sel_fm_am + " " + cu_time);
        if (year == (null)) {
            date = cu_year + "-" + cu_month_date;
        }

        if (plan == null) {
            plan = "테스트중입니다.";
        }


        addactivity_date.setText(date);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.add_plan_dialog, null);
        builder.setView(view);
        builder.setPositiveButton("저장", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                plan = add_activity_title.getText().toString();
                String date = addactivity_date.getText().toString();
                String[] dates = date.split("-");

                new DBclass().table_uploadDB(Add_Plan_Activity.this, dates[0], dates[1], dates[2], plan, addactivity_time.getText().toString(), Add_Plan_Datas.getRepeat_week_data(), Add_Plan_Datas.getAlarm_popdup_data());

                finish();
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);

        setting_alarm.setOnClickListener(setalarm);
    }//oncerate

    View.OnClickListener setalarm = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Add_Plan_Activity.this, Alarm_Manager_Activity.class);
            startActivity(intent);
        }
    };

    public void click_set_repeat(View view) {
        Intent intent = new Intent(Add_Plan_Activity.this, Repeat_Activity.class);
        startActivity(intent);
    }
//----------------------------------------------------------------

    public void click_set_date(View view) {

        Add_Plan_alram_picker_dialog add_plan_alram_picker_dialog = new Add_Plan_alram_picker_dialog();

        add_plan_alram_picker_dialog.show(getSupportFragmentManager(), "test");

    }

    public void click_set_time(View view) {

        Add_Plan_alram_picker_dialog add_plan_alram_picker_dialog = new Add_Plan_alram_picker_dialog();

        add_plan_alram_picker_dialog.show(getSupportFragmentManager(), "test");


    }

    //----------------------------------------------------------------
    public void click_add(View view) {

        dialog.show();

    }

    public void click_back(View view) {

        finish();
    }


    void getTime() {
        long now = System.currentTimeMillis();

        Date date = new Date(now);
        SimpleDateFormat sdg = new SimpleDateFormat("yyyy/MM/dd/aa/HH/mm");
        String getTime = sdg.format(date);

        String[] timelist = getTime.split("/");

        cu_year = timelist[0];
        cu_month_date = timelist[1] + "-" + timelist[2];
        sel_fm_am = timelist[3];
        cu_time = timelist[4] + ":" + timelist[5];


    }
}//class
