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
import android.widget.TextView;

public class Add_Plan_Activity extends AppCompatActivity {

    EditText add_activity_title,add_activity_place;
    TextView addactivity_date,addactivity_time;
    ImageView add_activity_alarm;
    String date;
    String year;
    String month;
    String day;
   String plan;
   String time;
   String repeat;
   String alarm;
   String explain;



    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__plan_);


        add_activity_title=findViewById(R.id.add_activity_title);
        add_activity_place=findViewById(R.id.add_activity_place);
        addactivity_date=findViewById(R.id.addactivity_date);
        addactivity_time=findViewById(R.id.addactivity_time);
        add_activity_alarm=findViewById(R.id.add_activity_alarm);

        Intent intent = getIntent();
         year=  intent.getStringExtra("year");
         month =  intent.getStringExtra("month");
         day= intent.getStringExtra("day");



         if(year==(null)) {
             year="2018";
         }
        if(month==(null)) {
            month="05";
        }
        if(day==(null)) {
            day="21";
        }
        if(plan==null){
             plan="테스트중입니다.";
        }

        date = year+"-"+month+"-"+day;
        addactivity_date.setText(date);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("테스트");

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.add_plan_dialog,null);
        builder.setView(view);
        builder.setPositiveButton("저장", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                new DBclass_Plan().uploadDB(Add_Plan_Activity.this,year,month,day,plan,time,repeat,alarm,explain);


            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

         dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);


    }


    public void click_set_alarm(View view) {
    }

    public void click_set_repeat(View view) {
    }


    public void click_set_date(View view) {
    }

    public void click_set_time(View view) {
    }

    public void click_add(View view) {

        dialog.show();

    }

    public void click_back(View view) {
    }
}
