package tpghks521.bubudiary;



import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;


public class Calender_Activity extends AppCompatActivity {
    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    FloatingActionButton cal_fab;
    TextView fab_text;
    FloatingActionButton[] floatingActionButtons=new FloatingActionButton[3];
    View floating_view;
    TextView[] floatingActionButtons_text=new TextView[4];
    Button sign_out_button;
    TextView flb_set_date;

   public static TextView actionbar_year;
   public static int actionbar_year_number=2018;
   public static LinearLayoutManager linearLayoutManager;
   public static TextView month;
   public static  Calender_Adapter calender_adapter;


   RecyclerView recyclerView;
    int month_position;
    ImageView actionbar_allow_down;
String personEmail;
    String   personName;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        Intent intent = new Intent();
            personEmail=  intent.getStringExtra("personEmail");
            personName=  intent.getStringExtra("personName");

//------------------------------------------------------------------------------------------------------------
            cal_fab=findViewById(R.id.cal_fab);
        fab_text=findViewById(R.id.fab_text);
        toolbar=findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.cal_navi);
        recyclerView = findViewById(R.id.cal_recyclerview);
        floating_view=findViewById(R.id.floating_view);
        floatingActionButtons[0]=findViewById(R.id.FloatingActionButton_add);
        floatingActionButtons[1]=findViewById(R.id.FloatingActionButton_wallet);
        floatingActionButtons[2]=findViewById(R.id.FloatingActionButton_weather);
        floatingActionButtons_text[0]=findViewById(R.id.FloatingActionButton_add_text);
        floatingActionButtons_text[1]=findViewById(R.id.FloatingActionButton_wallet_text);
        floatingActionButtons_text[2]=findViewById(R.id.FloatingActionButton_weather_text);
        floatingActionButtons_text[3]=findViewById(R.id.flb_set_date);
        flb_set_date=findViewById(R.id.flb_set_date);
            sign_out_button=findViewById(R.id.sign_out_button);
//------------------------------------------------------------------------------------------------------------

        new Calendaer_calcul_year().cal(actionbar_year_number,calender_adapter);
        actionbar_year=findViewById(R.id.actionbar_year);
        actionbar_year.setText(actionbar_year_number+"");
        month=findViewById(R.id.month_select);
        calender_adapter = new Calender_Adapter(this, cal_fab, fab_text,Calendaer_calcul_year.years_string, Calendaer_calcul_year.calendar_day_calcul_classes, floatingActionButtons, floating_view, floatingActionButtons_text,flb_set_date);
        recyclerView.setAdapter(calender_adapter);
//------------------------------------------------------------------------------------------------------------


        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawerlayout);
        recyclerView.addOnScrollListener(onScrollListener);
        linearLayoutManager=(LinearLayoutManager) recyclerView.getLayoutManager();
        month_position= 5;
        linearLayoutManager.scrollToPosition(4);
//------------------------------------------------------------------------------------------------------------


        if(month_position<10) {
            month.setText("0"+month_position + "");
        }else if(month_position>10){
            month.setText(month_position + "");
        }

//------------------------------------------------------------------------------------------------------------

        //제스처리스너를 달아서 플리핑을 햇을때 다음 아이템을 포지션시키면된다.
        actionbar_allow_down=findViewById(R.id.actionbar_allow_down);
        actionbar_allow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyYearMonthPickerDialog pd = new MyYearMonthPickerDialog();


                Bundle args = new Bundle();
                args.putInt("year",actionbar_year_number);

                pd.setArguments(args);
                pd.show(getSupportFragmentManager(),"test");
            }
        });
//------------------------------------------------------------------------------------------------------------
            sign_out_button.setOnClickListener(sign_out_buttonclick);
    }//oncreate
View.OnClickListener sign_out_buttonclick = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
//        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
//            @Override
//            public void onResult(@NonNull Status status) {
//
//            }
//        });

    }
};
//------------------------------------------------------------------------------------------------------------

    RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

            if(month_position!=linearLayoutManager.findFirstVisibleItemPosition()+1){

                month_position=linearLayoutManager.findFirstVisibleItemPosition()+1;
                if(month_position<10) {
                    month.setText("0"+month_position + "");
                }else if(month_position>=10){
                    month.setText(month_position + "");
                }
            }//if
        }//onScrollStateChanged
    };
//------------------------------------------------------------------------------------------------------------
    public void click_actionbar_menu(View view) {

        drawerLayout.openDrawer(navigationView);

    }//click_actionbar_menu

//------------------------------------------------------------------------------------------------------------


    public void click_add(View view) {
        Intent intent = new Intent(this,Add_Plan_Activity.class);
        startActivity(intent);
    }

}//class
