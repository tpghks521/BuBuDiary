package tpghks521.bubudiary;



import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
    VH2 vh2;
    FloatingActionButton cal_fab;
    TextView fab_text;
    ViewGroup parent;
    ArrayList<Calendar_Day_calcul_class> calendar_day_calcul_classes;

    FloatingActionButton[] floatingActionButtons;
    View floating_view;
    TextView[] floatingActionButtons_texts;
    TextView floatingActionButton_text;
    String years;
    //-----------------------테스트
    String y;
    String m;
    String d;
    TextView flb_set_date;
    //-----------------------테스트
    String personEmail;
    public Calender_Adapter(Context context, FloatingActionButton cal_fab, TextView fab_text, String years, ArrayList<Calendar_Day_calcul_class> calendar_day_calcul_classes, FloatingActionButton[] floatingActionButtons, View floating_view, TextView[] floatingActionButtons_texts, TextView flb_set_day) {
        this.context = context;
        this.floating_view = floating_view;
        this.cal_fab = cal_fab;
        this.fab_text = fab_text;
        this.years = years;
        this.calendar_day_calcul_classes = calendar_day_calcul_classes;
        this.floatingActionButtons = floatingActionButtons;
        this.floatingActionButtons_texts = floatingActionButtons_texts;
        this.flb_set_date = flb_set_day;
        floatingActionButton_text = floatingActionButtons_texts[3];
    }

    @Override
    public int getItemViewType(int position) {


        if (calendar_day_calcul_classes.get(position).datesum > 36) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = parent;
        if (viewType == 0) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View itemView = inflater.inflate(R.layout.item2_calender_recycler, parent, false);
            VH2 holder2 = new VH2(itemView);

            return holder2;

        } else {
            LayoutInflater inflater = LayoutInflater.from(context);
            View itemView = inflater.inflate(R.layout.item_calender_recycler, parent, false);
            VH holder = new VH(itemView, context);

            return holder;
        }
    }//onCreateViewHolder


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int maxnumber;

        if (holder instanceof VH) {
            vh = (VH) holder;

            maxnumber = 35;
            for (int i = 0; i < maxnumber; i++) {
                vh.number_text[i].setTextSize(15);
                if (i % 7 == 0) {
                    vh.number_text[i].setTextColor(Color.RED);
                } else if (i % 7 == 6) {
                    vh.number_text[i].setTextColor(Color.BLUE);
                } else {
                    vh.number_text[i].setTextColor(Color.BLACK);
                }
            }//for (int i = 0; i < 35; i++)
            for (int i = 0; i < maxnumber; i++) {
                vh.number_text[i].setText(calendar_day_calcul_classes.get(position).date[i]);
              //  vh.addcalendar_textviews[i].setText(calendar_day_calcul_classes.get(position).year + "");
                vh.addcalendar_textviews[i].setText("");
            }
            floating_view.setOnClickListener(onClickListener);
            y = calendar_day_calcul_classes.get(position).year;
          //  m = (position + 1) + "";

//--------------------------------------------------------------------------------------- 이거를 메소드로 만들어서 실행시킴
            input_plan(position,2018,5,21,maxnumber,"내생일");//파라미터로 년  월 일추가 하여서 사용하면 될것같다, 클래스로 만들어야 될가능성도 염두해 두어야한다.

//-------------------------------------------------------------------------------


        } else {

            vh2 = (VH2) holder;
            maxnumber = 42;
            for (int i = 0; i < maxnumber; i++) {
                vh2.number_text[i].setTextSize(15);
                if (i % 7 == 0) {
                    vh2.number_text[i].setTextColor(Color.RED);
                } else if (i % 7 == 6) {
                    vh2.number_text[i].setTextColor(Color.BLUE);
                } else {
                    vh2.number_text[i].setTextColor(Color.BLACK);
                }
            }//for (int i = 0; i < 35; i++)
            for (int i = 0; i < maxnumber; i++) {
                vh2.number_text[i].setText(calendar_day_calcul_classes.get(position).date[i]);
                vh2.addcalendar_textviews[i].setText("");
            }
            floating_view.setOnClickListener(onClickListener);
            y = calendar_day_calcul_classes.get(position).year;
           // m = (position + 1) + "";

        }

    }//onBindViewHolder



    void input_plan(int position,int year,int month,int day,int maxtextnumber,String text){
        if(calendar_day_calcul_classes.get(position).year.equals(year+"")){
            if(position==month-1){
                for(int i =0 ; i<maxtextnumber;i++) {
                    if (vh.number_text[i].getText().equals(day+"")){
                        vh.addcalendar_textviews[day+1].setText(text);
                    }
                }
            }
        }
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            for(int i = 0; i < 35; i++){
//
//                vh.number_text[i].setBackgroundColor(Color.WHITE);
//                System.out.println(i);
//            }//if(number_cal_layout[i]==view)


            for (int i = 0; i < floatingActionButtons.length; i++) {
                floatingActionButtons[i].setVisibility(View.GONE);
                floatingActionButtons_texts[i].setVisibility(View.GONE);
            }
            floatingActionButton_text.setVisibility(View.GONE);
            cal_fab.setVisibility(View.VISIBLE);
            fab_text.setText("오늘");
            floating_view.setVisibility(View.GONE);
        }
    };

    @Override
    public int getItemCount() {
        return 12;
    }//getItemCount

    class VH extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        //멤버변수
        int maxnumber = 35;
        TextView[] number_text = new TextView[maxnumber];
        LinearLayout[] number_cal_layout = new LinearLayout[maxnumber];
        TextView[] addcalendar_textviews = new TextView[maxnumber];

        public VH(View itemView, Context context) {
            super(itemView);

            for (int i = 0; i < maxnumber; i++) {
                number_text[i] = itemView.findViewById(R.id.numberline_01 + i);
                addcalendar_textviews[i] = itemView.findViewById(R.id.addcalendar_textview_01 + i);

            }

            for (int i = 0; i < maxnumber; i++) {
                number_cal_layout[i] = itemView.findViewById(R.id.calendar_01 + i);
                number_cal_layout[i].setClickable(true);
                number_cal_layout[i].setOnClickListener(this);
                number_cal_layout[i].setOnLongClickListener(this);
            }


            floatingActionButtons[0].setOnClickListener(add_flb_listner);

        }//constructer


    View.OnClickListener add_flb_listner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context,Add_Plan_Activity.class);
            intent.putExtra("year",y);
            intent.putExtra("month",m);
            intent.putExtra("day",d);
            intent.putExtra("personEmail",personEmail);
            context.startActivity(intent);
        }
    };



        @Override
        public void onClick(View view) {
            System.out.println("aaaa");
            Toast.makeText(context, "aaaa", Toast.LENGTH_SHORT).show();
        }

        int clicknum;

        @Override
        public boolean onLongClick(View view) {


            for (int i = 0; i < maxnumber; i++) {
                if (number_cal_layout[i] == view) {
                    clicknum = i;
                    //  number_text[clicknum].setBackgroundColor(Color.GREEN);
                    d = number_text[clicknum].getText().toString();
                }//if(number_cal_layout[i]==view)
            }//for(int i = 0; i < 35; i++)
            cal_fab.setVisibility(View.GONE);
            fab_text.setText("");
            floating_view.setVisibility(View.VISIBLE);
            for (int i = 0; i < floatingActionButtons.length; i++) {
                floatingActionButtons[i].setVisibility(View.VISIBLE);
                floatingActionButtons_texts[i].setVisibility(View.VISIBLE);
            }
            floatingActionButton_text.setVisibility(View.VISIBLE);
            m = (getLayoutPosition()+1) + "";
            flb_set_date.setText(y + "년 " + m + "월 " + d + "일");

            return true;
        }//longclick
    }//class VH


    class VH2 extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        //멤버변수
        int maxnumber = 42;
        TextView[] number_text = new TextView[maxnumber];
        LinearLayout[] number_cal_layout = new LinearLayout[maxnumber];
        TextView[] addcalendar_textviews = new TextView[maxnumber];

        public VH2(View itemView) {
            super(itemView);

            for (int i = 0; i < maxnumber; i++) {
                number_text[i] = itemView.findViewById(R.id.ver_2_numberline_01 + i);
                addcalendar_textviews[i] = itemView.findViewById(R.id.ver_2_addcalendar_textview_01 + i);

            }

            for (int i = 0; i < maxnumber; i++) {
                number_cal_layout[i] = itemView.findViewById(R.id.ver_2_calendar_01 + i);
                number_cal_layout[i].setClickable(true);
                number_cal_layout[i].setOnClickListener(this);
                number_cal_layout[i].setOnLongClickListener(this);
            }

        }//constructer

        @Override
        public void onClick(View view) {
            System.out.println("aaaa");
            Toast.makeText(context, "aaaa", Toast.LENGTH_SHORT).show();
        }

        int clicknum;

        @Override
        public boolean onLongClick(View view) {


            for (int i = 0; i < maxnumber; i++) {
                if (number_cal_layout[i] == view) {
                    clicknum = i;
                    //  number_text[clicknum].setBackgroundColor(Color.GREEN);
                    d = number_text[clicknum].getText().toString();
                }//if(number_cal_layout[i]==view)
            }//for(int i = 0; i < 35; i++)
            cal_fab.setVisibility(View.GONE);
            fab_text.setText("");
            floating_view.setVisibility(View.VISIBLE);
            for (int i = 0; i < floatingActionButtons.length; i++) {
                floatingActionButtons[i].setVisibility(View.VISIBLE);
                floatingActionButtons_texts[i].setVisibility(View.VISIBLE);
            }
            floatingActionButton_text.setVisibility(View.VISIBLE);
            m = (getLayoutPosition()+1) + "";
            flb_set_date.setText(y + "년 " + m + "월 " + d + "일");


            return true;
        }// class Calender_Adapter
    }
}