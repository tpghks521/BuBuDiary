package tpghks521.bubudiary;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.icu.util.Calendar;

import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.Toast;



public class Calender_Activity extends AppCompatActivity {
NavigationView navigationView;
    int[] year= new int[150];
    Toolbar toolbar;
    DrawerLayout drawerLayout;
 View floating_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        saveYear();
        floating_view=findViewById(R.id.floating_view);

        toolbar=findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.cal_navi);
        RecyclerView recyclerView = findViewById(R.id.cal_recyclerview);
        Calender_Adapter calender_adapter = new Calender_Adapter(this,floating_view);
        recyclerView.setAdapter(calender_adapter);

        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawerlayout);






    }







void saveYear(){
for(int i=0;i<year.length;i++){
    year[i]=1900+i;
    cal(year[i]);
}


}

 void cal(int years) {

     java.util.Calendar c = java.util.Calendar.getInstance();

     for (int k = 1; k <= 12; k++) {
         c.set(years, k - 1, 1);
         @SuppressLint("WrongConstant") int lastOfDate = c.getActualMaximum(Calendar.DATE);
         @SuppressLint("WrongConstant") int week = c.get(Calendar.DAY_OF_WEEK);

         for (int i = 1; i < week; i++) {
             System.out.print("    ");
         }
         for (int i = 1; i <= lastOfDate; i++) {
             System.out.print((i < 10) ? "  " + i : "  " + i);
             if (week % 7 == 0) System.out.println();
             week++;
         }
         System.out.println("\n=====================================");
     }
 }



    public void click_actionbar_menu(View view) {

        drawerLayout.openDrawer(navigationView);


    }

    public void click_Selcet_Date(View view) {

        MyYearMonthPickerDialog pd = new MyYearMonthPickerDialog();

        pd.show(getSupportFragmentManager(),"test");

   }
}
