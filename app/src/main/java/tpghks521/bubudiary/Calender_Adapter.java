package tpghks521.bubudiary;


import android.annotation.SuppressLint;
import android.content.Context;

import android.graphics.Color;

import android.icu.util.Calendar;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by tpghk on 2018-04-23.
 */

public class Calender_Adapter extends RecyclerView.Adapter {
    Context context;
    VH vh;

    FloatingActionButton cal_fab;
    TextView fab_text;
    ViewGroup parent;
    ArrayList<Calendar_Day_calcul_class> calendar_day_calcul_classes;

    FloatingActionButton[] floatingActionButtons;
    View floating_view;
    TextView[] floatingActionButtons_text;
    TextView flb_set_date;
    public Calender_Adapter(Context context,FloatingActionButton cal_fab,TextView fab_text,ArrayList<Calendar_Day_calcul_class> calendar_day_calcul_classes, FloatingActionButton[] floatingActionButtons, View floating_view,TextView[] floatingActionButtons_text) {
        this.context = context;
            this.floating_view=floating_view;
            this.cal_fab=cal_fab;
            this.fab_text=fab_text;
            this.calendar_day_calcul_classes=calendar_day_calcul_classes;
            this.floatingActionButtons=floatingActionButtons;
            this.floatingActionButtons_text=floatingActionButtons_text;
        flb_set_date=floatingActionButtons_text[3];
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_calender_recycler, parent, false);
        VH holder = new VH(itemView,context);
        this.parent=parent;
        return holder;
    }//onCreateViewHolder



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        vh = (VH) holder;



        for (int i = 0; i < 35; i++) {
            vh.number_text[i].setTextSize(15);
            if (i % 7 == 0) {
                vh.number_text[i].setTextColor(Color.RED);
            } else if (i % 7 == 6) {
                vh.number_text[i].setTextColor(Color.BLUE);
            } else {
                vh.number_text[i].setTextColor(Color.BLACK);
            }
        }//for (int i = 0; i < 35; i++)
        for (int i = 0; i < 4 * 7 * 5; i++) {
            vh.text_list[i].setText("");

        }//for (int i = 0; i < 4 * 7 * 5; i++)


        for(int i = 0;i<35;i++){
          vh.number_text[i].setText(calendar_day_calcul_classes.get(position).date[i]);
        }


        floating_view.setOnClickListener(onClickListener);




    }//onBindViewHolder


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for(int i = 0; i < 35; i++){

                vh.number_text[i].setBackgroundColor(Color.WHITE);
                System.out.println(i);
            }//if(number_cal_layout[i]==view)


            for(int i=0;i<floatingActionButtons.length;i++) {
                floatingActionButtons[i].setVisibility(View.GONE);
                floatingActionButtons_text[i].setVisibility(View.GONE);
            }
            flb_set_date.setVisibility(View.GONE);
            cal_fab.setVisibility(View.VISIBLE);
            fab_text.setText("오늘");
            floating_view.setVisibility(View.GONE);
        }
    };

    @Override
    public int getItemCount() {
        return 12;
    }//getItemCount

    class VH extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        //멤버변수

        TextView[] number_text = new TextView[35];
        TextView[] text_list = new TextView[4 * 7 * 5];
        LinearLayout[] number_cal_layout =new LinearLayout[35];




        public VH(View itemView,Context context) {
             super(itemView);



            for (int i = 0; i < 35; i++) {
                number_text[i] = itemView.findViewById(R.id.numberline_1_1 + i);



            }
            for (int i = 0; i < 35; i++) {
                number_cal_layout[i] = itemView.findViewById(R.id.calendar_01 + i);
                number_cal_layout[i].setClickable(true);
                number_cal_layout[i].setOnClickListener(this);
                number_cal_layout[i].setOnLongClickListener(this);
            }


            for (int i = 0; i < 4 * 7 * 5; i++) {
                text_list[i] = itemView.findViewById(R.id.textview_1_1_1 + i);


            }



        }

        @Override
        public void onClick(View view) {
            System.out.println("aaaa");
            Toast.makeText(context, "aaaa", Toast.LENGTH_SHORT).show();
        }
        int clicknum;
        @Override
        public boolean onLongClick(View view) {


            for(int i = 0; i < 35; i++){
                if(number_cal_layout[i]==view){
                    clicknum=i;
                    number_text[clicknum].setBackgroundColor(Color.GREEN);
                }//if(number_cal_layout[i]==view)
            }//for(int i = 0; i < 35; i++)
            cal_fab.setVisibility(View.GONE);
            fab_text.setText("");
            floating_view.setVisibility(View.VISIBLE);
            for(int i=0;i<floatingActionButtons.length;i++) {
                floatingActionButtons[i].setVisibility(View.VISIBLE);
                floatingActionButtons_text[i].setVisibility(View.VISIBLE);
            }
            flb_set_date.setVisibility(View.VISIBLE);





            return true;
        }//longclick






    }//class VH
}// class Calender_Adapter
