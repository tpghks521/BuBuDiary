package tpghks521.bubudiary;


import android.annotation.SuppressLint;

import android.icu.util.Calendar;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class Calender_Activity extends AppCompatActivity {
NavigationView navigationView;

    Toolbar toolbar;
    DrawerLayout drawerLayout;
 View floating_view;

    FloatingActionButton cal_fab;
    TextView fab_text;

    ArrayList<Calendar_Day_calcul_class> calendar_day_calcul_classes= new ArrayList<>();
    int[] year= new int[150];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);


        floating_view=findViewById(R.id.floating_view);
        cal_fab=findViewById(R.id.cal_fab);
        fab_text=findViewById(R.id.fab_text);
        toolbar=findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.cal_navi);
        RecyclerView recyclerView = findViewById(R.id.cal_recyclerview);
       // saveYear();
        cal(2018);
        Calender_Adapter calender_adapter = new Calender_Adapter(this,floating_view,cal_fab,fab_text,calendar_day_calcul_classes);
        recyclerView.setAdapter(calender_adapter);

        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawerlayout);

        //-------------------------------------------------------------------------------

    }
    void saveYear(){
        for(int i=0;i<year.length;i++){
            year[i]=1900+i;
            cal(year[i]);
        }


    }//saveYear

    void cal(int years) {
        String[] date;
        java.util.Calendar c = java.util.Calendar.getInstance();

        for (int k = 1; k <= 12; k++) {
            date = new String[35];
            c.set(2018, k-1, 1);
            @SuppressLint("WrongConstant") int lastOfDate = c.getActualMaximum(Calendar.DATE);
            @SuppressLint("WrongConstant") int week = c.get(Calendar.DAY_OF_WEEK);

            for (int i = 0; i < week-1; i++) {
                System.out.println(lastOfDate);
                System.out.println(week);
                date[i]=" ";
            }

            for (int i = 1; i <= lastOfDate; i++) {

                if(week-1+i>35){
                    date[week-1+i-8]=i-7+ " / "+i;
                }

                else if(i==1){
                    //   vh.number_text[week - 2].setText("5."+i + "");
                    date[week-2+i]=k+"."+i;
                }else {
                    //  vh.number_text[week - 2].setText(i + "");
                    date[week-2+i]=i+"";

                }

            }

            for(int i =lastOfDate+week;i<34;i++){
                //vh.number_text[i+1].setText(" ");
                date[i+1]=" ";
            }
            //  System.out.println("\n=====================================");
            String years_string=years+"";
            String month=k+"";
            calendar_day_calcul_classes.add(new Calendar_Day_calcul_class(years_string,month,date));

            System.out.println(years);
            System.out.println(month);
            for(int i=0;i<date.length;i++) {
                System.out.print(date[i]+" , ");
            }
            System.out.println("");


        }
        System.out.println(calendar_day_calcul_classes.size());




//        for( int k =1; k<12; k++){
//            c.set(2018,5,1);
//            @SuppressLint("WrongConstant") int lastOfDate = c.getActualMaximum(Calendar.DATE);
//            @SuppressLint("WrongConstant") int week = c.get(Calendar.DAY_OF_WEEK);
//            for(int i = 1; i<week; i++){
//
//            }
//
//
//        }



    }//cal










    public void click_actionbar_menu(View view) {

        drawerLayout.openDrawer(navigationView);


    }

    public void click_Selcet_Date(View view) {

        MyYearMonthPickerDialog pd = new MyYearMonthPickerDialog();

        pd.show(getSupportFragmentManager(),"test");

   }
}
