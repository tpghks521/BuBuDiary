package tpghks521.bubudiary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.wefika.horizontalpicker.HorizontalPicker;

/**
 * Created by tpghk on 2018-05-17.
 */

public class Add_Plan_alram_picker_dialog extends DialogFragment{

    private static final int MAX_YEAR = 2045;
    private static final int MIN_YEAR = 1900;

    TextView am_view,fm_view;
    int yearlistsize=MAX_YEAR-MIN_YEAR;
    String[] yearlist = new String[yearlistsize];
   // CharSequence[] yearlist_final= new CharSequence[yearlist.length];
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialog = inflater.inflate(R.layout.add_select_alram,null);

       // final HorizontalPicker yearPicker= dialog.findViewById(R.id.add_yearpicker);
        final NumberPicker yearPicker= dialog.findViewById(R.id.add_yaerpicker1);
        final NumberPicker monthPicker= dialog.findViewById(R.id.add_monthpicker);
        final NumberPicker datePicker= dialog.findViewById(R.id.add_datepicker);
        final NumberPicker hourPicker= dialog.findViewById(R.id.add_hourpicker);
        final NumberPicker minitePicker= dialog.findViewById(R.id.add_minitepicker);

        am_view=dialog.findViewById(R.id.add_timepicker_am);
        fm_view=dialog.findViewById(R.id.add_timepicker_fm);
        yearPicker.setMaxValue(MAX_YEAR);
        yearPicker.setMinValue(MIN_YEAR);

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);
        datePicker.setMinValue(1);
        datePicker.setMaxValue(31);
        hourPicker.setMaxValue(12);
        hourPicker.setMinValue(1);
        minitePicker.setMaxValue(60);
        minitePicker.setMinValue(0);
//        for(int i=0;i<MAX_YEAR-MIN_YEAR;i++){
//            yearlist[i]= Integer.toString(MIN_YEAR+i);
//            yearlist_final[i]=yearlist[i];
//
//        }

//        yearPicker.setValues(yearlist_final);


        builder.setView(dialog);

        return builder.create();
    }//oncreateDialog
}//class




