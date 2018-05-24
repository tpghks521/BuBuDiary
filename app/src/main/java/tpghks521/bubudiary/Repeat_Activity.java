package tpghks521.bubudiary;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Repeat_Activity extends AppCompatActivity {

    View[] select_Views = new View[3];
    RelativeLayout[] select_relativeLayouts = new RelativeLayout[3];
    TextView[] select_texts = new TextView[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat_);
        findView();


    }//oncreate

    View.OnClickListener viewsclickListner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(Repeat_Activity.this, view.toString(), Toast.LENGTH_SHORT).show();
            switch(view.getId()){

                case R.id.repeat_clickbtn01:
                    clickbtn(0);

                    break;
                case R.id.repeat_clickbtn02:
                    clickbtn(1);
                   break;
                case R.id.repeat_clickbtn03:
                    clickbtn(2);
                    break;


            }

        }
    };


    void clickbtn(int num){

        select_relativeLayouts[num].setBackgroundColor(Color.parseColor("#ffffff"));
        select_texts[num].setTextColor(Color.parseColor("#0097a7"));

    }//clickbtn




    void findView() {

        for (int i = 0; i < 3; i++) {
            select_Views[i] = findViewById(R.id.repeat_clickbtn01+i);
            select_Views[i].setClickable(true);
            select_Views[i].setOnClickListener(viewsclickListner);
        }
        select_relativeLayouts[0] = findViewById(R.id.repeat_None);
        select_relativeLayouts[1] = findViewById(R.id.repeat_everyday);
        select_relativeLayouts[2] = findViewById(R.id.repeat_everyweek);
        select_texts[0] =findViewById(R.id.repeat_None_text);
        select_texts[1]=findViewById(R.id.repeat_everyday_text);
        select_texts[2]=findViewById(R.id.repeat_everyweek_text);

    }//findView


}//class
