package tpghks521.bubudiary;

import android.annotation.SuppressLint;
import android.icu.util.Calendar;

import java.util.ArrayList;

/**
 * Created by tpghk on 2018-05-11.
 */

public class Calendaer_calcul_year {
    public static ArrayList<Calendar_Day_calcul_class> calendar_day_calcul_classes= new ArrayList<>();
    public static String years_string;
    Calender_Adapter calender_adapter;
       String[] date;

        String month;

    void cal(int years,Calender_Adapter calender_adapter) {
        this.years_string=years+"";
        System.out.println("년도 : "+years_string);
        this.calender_adapter=calender_adapter;
        java.util.Calendar c = java.util.Calendar.getInstance();

        for (int k = 1; k <= 12; k++) {
            date = new String[42];
            c.set(years, k - 1, 1);
            @SuppressLint("WrongConstant") int lastOfDate = c.getActualMaximum(Calendar.DATE);
            @SuppressLint("WrongConstant") int week = c.get(Calendar.DAY_OF_WEEK);
          int datesum=week+lastOfDate;
             System.out.println(datesum+ " : 여기");
            for (int i = 0; i < week - 1; i++) {


                date[i] = " ";
            }

            for (int i = 1; i <= lastOfDate; i++) {

//                if (week - 1 + i > 35) {
//                    date[week - 1 + i - 8] = i - 7 + " / " + i;
//                }
                if (i == 1) {
                    //   vh.number_text[week - 2].setText("5."+i + "");
                    date[week - 2 + i] = k + "." + i;
                } else {
                    //  vh.number_text[week - 2].setText(i + "");
                    date[week - 2 + i] = i + "";

                }

            }

            for (int i = lastOfDate + week; i < 34; i++) {
                //vh.number_text[i+1].setText(" ");
                date[i + 1] = " ";
            }
            //  System.out.println("\n=====================================");

            month = k + "";
           calendar_day_calcul_classes.add(new Calendar_Day_calcul_class(years_string,month,date,datesum));


        }
       if(calender_adapter!=null) {
           calender_adapter.notifyDataSetChanged();
       }
    }
}