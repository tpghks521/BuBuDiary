package tpghks521.bubudiary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.LayoutDirection;
import android.util.Xml;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by tpghk on 2018-04-23.
 */

public class Calender_Adapter extends RecyclerView.Adapter {
    Context context;
    VH vh;

    public Calender_Adapter(Context context) {
        this.context = context;

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


    CoordinatorLayout.LayoutParams params;

    @Override
    public int getItemCount() {
        return 2;
    }



    
    class VH extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        //멤버변수
        TextView[] number_text = new TextView[35];
        TextView[] text_list = new TextView[4 * 7 * 5];
        LinearLayout[] number_cal_layout =new LinearLayout[35];
        FloatingActionButton floatingActionButton;
CoordinatorLayout coordinatorLayout;

        public VH(View itemView,Context context) {
             super(itemView);



            for (int i = 0; i < 35; i++) {
                number_text[i] = itemView.findViewById(R.id.numberline_1_1 + i);



            }
            for (int i = 0; i < 35; i++) {
                number_cal_layout[i] = itemView.findViewById(R.id.calendar_1 + i);
                number_cal_layout[i].setClickable(true);
                number_cal_layout[i].setOnClickListener(this);
                number_cal_layout[i].setOnLongClickListener(this);
            }


            for (int i = 0; i < 4 * 7 * 5; i++) {
                text_list[i] = itemView.findViewById(R.id.textview_1_1_1 + i);


            }

            floatingActionButton = new FloatingActionButton(context);




            floatingActionButton.setImageResource(R.drawable.ic_action_palne);




            params=new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.WRAP_CONTENT,CoordinatorLayout.LayoutParams.WRAP_CONTENT);

            params.setAnchorId(number_cal_layout[5].getId());
            params.anchorGravity = Gravity.BOTTOM;


            floatingActionButton.setLayoutParams(params);
            floatingActionButton.setSize(FloatingActionButton.SIZE_MINI);
            floatingActionButton.setBackgroundColor(Color.WHITE);
            floatingActionButton.setColorFilter(Color.WHITE);
           

            coordinatorLayout=itemView.findViewById(R.id.coordinator);



            coordinatorLayout.addView(floatingActionButton);



//            floatingActionButton.setVisibility(View.VISIBLE);
//            floatingActionButton.show();






//                for (int i = 0; i < 3; i++) {
//
//
//                    floatingActionButtons[i] = itemView.findViewById(R.id.fab01_activity_addPlan + i);
//                    params = (CoordinatorLayout.LayoutParams) floatingActionButtons[i].getLayoutParams();
//
//
//                    params.setAnchorId(number_cal_layout[0].getId());
//
//
//                    if (i == 1) {
//                        params.anchorGravity = Gravity.BOTTOM;
//                    } else if (i == 2) {
//                        params.anchorGravity = Gravity.TOP;
//                    } else {
//                        params.anchorGravity = Gravity.CENTER_VERTICAL;
//                    }
//
//                    floatingActionButtons[i].setLayoutParams(params);
//                    floatingActionButtons[i].setImageResource(R.drawable.ic_action_palne + i);
//                    floatingActionButtons[i].setVisibility(View.VISIBLE);
//                    floatingActionButtons[i].setBackgroundColor(Color.WHITE);
//
//                }


        }

        @Override
        public void onClick(View view) {
            System.out.println("aaaa");
            Toast.makeText(context, "aaaa", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {

            for(int i = 0; i < 35; i++){
                if(number_cal_layout[i]==view){
                    number_text[i].setBackgroundColor(Color.GREEN);
                }
            }




            Toast.makeText(context, view.getId()+"", Toast.LENGTH_SHORT).show();
            return true;
        }

    }
}
