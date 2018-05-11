package tpghks521.bubudiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Add_Plan_Activity extends AppCompatActivity {

    EditText add_activity_title,add_activity_place;
    TextView addactivity_date,addactivity_time;
    ImageView add_activity_alarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__plan_);


        add_activity_title=findViewById(R.id.add_activity_title);
        add_activity_place=findViewById(R.id.add_activity_place);
                addactivity_date=findViewById(R.id.addactivity_date);
        addactivity_time=findViewById(R.id.addactivity_time);
                add_activity_alarm=findViewById(R.id.add_activity_alarm);

    }
}
