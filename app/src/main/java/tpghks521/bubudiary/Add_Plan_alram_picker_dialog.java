package tpghks521.bubudiary;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tpghk on 2018-05-17.
 */

public class Add_Plan_alram_picker_dialog extends DialogFragment{

    private static final int MAX_YEAR = 2045;
    private static final int MIN_YEAR = 1900;

    Spinner selcet_fm_am;


    String fm_am;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        getTime();



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialog = inflater.inflate(R.layout.add_select_alram,null);

       // final HorizontalPicker yearPicker= dialog.findViewById(R.id.add_yearpicker);
        final NumberPicker yearPicker= dialog.findViewById(R.id.add_yaerpicker1);
        final NumberPicker monthPicker= dialog.findViewById(R.id.add_monthpicker);
        final NumberPicker datePicker= dialog.findViewById(R.id.add_datepicker);
        final NumberPicker hourPicker= dialog.findViewById(R.id.add_hourpicker);
        final NumberPicker minitePicker= dialog.findViewById(R.id.add_minitepicker);
        selcet_fm_am=dialog.findViewById(R.id.time_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),R.array.time,R.layout.spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        selcet_fm_am.setAdapter(adapter);



        yearPicker.setMaxValue(MAX_YEAR);
        yearPicker.setMinValue(MIN_YEAR);

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);
        datePicker.setMinValue(1);
        datePicker.setMaxValue(31);
        hourPicker.setMaxValue(12);
        hourPicker.setMinValue(1);
        minitePicker.setMaxValue(59);
        minitePicker.setMinValue(0);




        builder.setView(dialog).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    fm_am= selcet_fm_am.getSelectedItem().toString();
                int yearpic=  yearPicker.getValue();
                int monthpic= monthPicker.getValue();
                int datepic = datePicker.getValue();
                int hourpic=  hourPicker.getValue();
                int minitepic=minitePicker.getValue();
                    String date;
                    String time;
                if(monthpic<10) {

                    if(datepic<10) {
                         date = yearpic + "-0" + monthpic + "-0" + datepic;
                    }else{
                         date = yearpic + "-0" + monthpic + "-" + datepic;
                    }

                }else{

                    if(datepic<10) {
                        date = yearpic + "-" + monthpic + "-0" + datepic;
                    }else{
                        date = yearpic + "-" + monthpic + "-" + datepic;
                    }
                }

                if(minitepic<10) {

                     time = fm_am + hourpic + " : 0" + minitepic;
                }else{
                     time = fm_am + hourpic + " : " + minitepic;
                }


                     Add_Plan_Activity.addactivity_date.setText(date);
                    Add_Plan_Activity.addactivity_time.setText(time);

                }
        })
        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                }
        });





        return builder.create();
    }//oncreateDialog

    void getTime(){
        long now = System.currentTimeMillis();

        Date date = new Date(now);
        SimpleDateFormat sdg = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String getTime = sdg.format(date);

        int a= getTime.indexOf("-");
        int b= getTime.indexOf(":");
        String cu_year= getTime.substring(0,a);
        String cu_month_date=getTime.substring(a+1,b-3);
        String cu_time = getTime.substring(b-2);


        System.out.println(getTime + "시간 " + cu_time);

    }



}//class




