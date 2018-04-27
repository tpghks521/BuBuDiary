package tpghks521.bubudiary;


import android.content.Context;

import android.graphics.Color;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



/**
 * Created by tpghk on 2018-04-23.
 */

public class Calender_Adapter extends RecyclerView.Adapter {
    Context context;
    VH vh;
    View floating_view;
    FloatingActionButton cal_fab;
    TextView fab_text;
    public Calender_Adapter(Context context,View floating_view,FloatingActionButton cal_fab,TextView fab_text) {
        this.context = context;
            this.floating_view=floating_view;
            this.cal_fab=cal_fab;
            this.fab_text=fab_text;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_calender_recycler, parent, false);
        VH holder = new VH(itemView,context);



        return holder;
    }


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
        }
        for (int i = 0; i < 4 * 7 * 5; i++) {
            vh.text_list[i].setText("");


        }



    }




    @Override
    public int getItemCount() {
        return 2;
    }



    
    class VH extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        //멤버변수
        View floating_view_below;
        TextView[] number_text = new TextView[35];
        TextView[] text_list = new TextView[4 * 7 * 5];
        LinearLayout[] number_cal_layout =new LinearLayout[35];

        int cal_actionButtons_count=3*7*5;
        FloatingActionButton[] cal_actionButtons = new FloatingActionButton[cal_actionButtons_count];













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
            for(int i= 0 ; i<cal_actionButtons_count;i++) {
                cal_actionButtons[i] = itemView.findViewById(R.id.v_cal_01_fab01_activity_addPlan + i);
            }


            floating_view_below=itemView.findViewById(R.id.floating_view_below);

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

                    for(int b= 0 ; b<3;b++) {
                        cal_actionButtons[((clicknum)*3)+b].setVisibility(View.VISIBLE);
                    }

                }

                floating_view.setVisibility(View.VISIBLE);
                floating_view_below.setVisibility(View.VISIBLE);
                cal_fab.setVisibility(View.GONE);
                fab_text.setText("");


            }

            floating_view_below.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cal_fab.setVisibility(View.VISIBLE);
                    fab_text.setText("오늘");
                    floating_view.setVisibility(View.GONE);
                    number_text[clicknum].setBackgroundColor(Color.WHITE);
                    floating_view_below.setVisibility(View.GONE);
                    for(int i= 0 ; i<cal_actionButtons_count;i++) {
                        cal_actionButtons[i].setVisibility(View.GONE);
                    }

                }
            });



            Toast.makeText(context, view.getId()+"", Toast.LENGTH_SHORT).show();
            return true;
        }

    }
}
