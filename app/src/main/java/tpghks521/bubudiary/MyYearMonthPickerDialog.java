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
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by tpghk on 2018-04-24.
 */

public class MyYearMonthPickerDialog extends DialogFragment {

    private static final int MAX_YEAR = 2045;
    private static final int MIN_YEAR = 1900;

     DatePickerDialog.OnDateSetListener listener;
    public Calendar cal = Calendar.getInstance();
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialog = inflater.inflate(R.layout.cal_select_dialog, null);

//        btnConfirm = dialog.findViewById(R.id.btn_confirm);
//        btnCancel = dialog.findViewById(R.id.btn_cancel);

        final NumberPicker monthPicker = (NumberPicker) dialog.findViewById(R.id.picker_month);
        final NumberPicker yearPicker = (NumberPicker) dialog.findViewById(R.id.picker_year);

//        btnCancel.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                MyYearMonthPickerDialog.this.getDialog().cancel();
//            }
//        });
//
//        btnConfirm.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                listener.onDateSet(null, yearPicker.getValue(), monthPicker.getValue(), 0);
//                MyYearMonthPickerDialog.this.getDialog().cancel();
//            }
//        });

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
                listener.onDateSet(null, yearPicker.getValue(), monthPicker.getValue(), 0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Calender_Activity().cal(yearPicker.getValue());

            }
        });

            }
        })
        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
              //  MyYearMonthPickerDialog.this.getDialog().cancel();
            }
        })

        ;

        return builder.create();
    }
}
