package tpghks521.bubudiary;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import java.util.Calendar;

/**
 * Created by tpghk on 2018-04-24.
 */

public class MyYearMonthPickerDialog extends DialogFragment {
    TextView yeartext,monthtext;
    private static final int MAX_YEAR = 2045;
    private static final int MIN_YEAR = 1900;
   static int yearpic;
   static int monthpic;
        int curr_year;
     DatePickerDialog.OnDateSetListener listener;
    public Calendar cal = Calendar.getInstance();


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        curr_year=getArguments().getInt("year");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialog = inflater.inflate(R.layout.cal_select_dialog, null);


        yeartext=dialog.findViewById(R.id.year);

        yeartext.setText(curr_year+"");



        final NumberPicker monthPicker = dialog.findViewById(R.id.picker_month);
        final NumberPicker yearPicker = dialog.findViewById(R.id.picker_year);


        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);
        monthPicker.setValue(cal.get(Calendar.MONTH) + 1);

        final int year = cal.get(Calendar.YEAR);
        yearPicker.setMinValue(MIN_YEAR);
        yearPicker.setMaxValue(MAX_YEAR);
        yearPicker.setValue(year);

        builder.setView(dialog)
        // Add action buttons

        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

              yearpic=   yearPicker.getValue();
              monthpic=   monthPicker.getValue();

            Calender_Activity.actionbar_year.setText(yearpic+"");
                Calendaer_calcul_year.calendar_day_calcul_classes.clear();

                new Calendaer_calcul_year().cal(yearpic,Calender_Activity.calender_adapter);

                Calender_Activity.linearLayoutManager.scrollToPosition(monthpic-1);
                if(monthpic<10) {
                    Calender_Activity.month.setText("0"+monthpic + "");
                }else if(monthpic>=10){
                    Calender_Activity.month.setText(monthpic + "");
                }

            }
        })
        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
              //  MyYearMonthPickerDialog.this.getDialog().cancel();
            }
        });



        return builder.create();
    }
}
