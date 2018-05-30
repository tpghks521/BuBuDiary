package tpghks521.bubudiary;



import android.app.AlarmManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Intent intent = new Intent(this, Calender_Activity.class);
        startActivity(intent);


//        Calendar currentTime = Calendar.getInstance();
//
//          System.out.println(
////
////                  currentTime.get(Calendar.YEAR)+" : "
////                  +
////        currentTime.get(Calendar.DATE)+" : "
////        +currentTime.get(Calendar.MONTH)+" : "+
//                  currentTime.getTime()
//     +   ": 시간");

    }//onCreate


}





