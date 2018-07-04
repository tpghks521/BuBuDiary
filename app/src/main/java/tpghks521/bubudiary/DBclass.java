package tpghks521.bubudiary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by alfo6-13 on 2018-05-04.
 */

public class DBclass {
public static ArrayList<Plan_list> plan_lists=new ArrayList<>();

    void uploadDB(Context context, String personEmail) {
        String serverUrl = "http://tpghks521.dothome.co.kr/android/BuBudaiary_DB.php";
        // String serverUrl="http://tpghks521.dothome.co.kr/android/aaa.php";
        SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println("성공 : " + response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("연결실패" + error);
            }
        });


        multiPartRequest.addStringParam("personEmail", personEmail);

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(multiPartRequest);


    }//uploadDB

    void loadDB(final Context context, final String personEmail, final String userId, final FragmentManager fragmentManager) {

        String serverUrl = "http://tpghks521.dothome.co.kr/android/DuDudaiary_DB_load.php";
        SimpleMultiPartRequest multiPartRequest_load = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("yes")) {
                    System.out.println("된다");


                    Intent intent = new Intent(context, Calender_Activity.class);
                    context.startActivity(intent);


                } else if (response.equals("no")) {
                    System.out.println("없다");
                    Bundle args = new Bundle();
                    args.putString("personEmail", personEmail);
                    args.putString("userId", userId);
                    Add_Member_Activity ama = new Add_Member_Activity();
                    ama.setArguments(args);
                    ama.show(fragmentManager, "test");


                }

                //여기서 테이블정보불러오기
                loadTable(context, personEmail);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);

            }
        });

        multiPartRequest_load.addStringParam("personEmail", personEmail);

        RequestQueue requestQueue_load = Volley.newRequestQueue(context);
        requestQueue_load.add(multiPartRequest_load);

    }//loadDB


    void table_uploadDB(Context context, String year, String month, String day, String plan, String time, String repeat, String alarm) {


        String serverUrl = "http://tpghks521.dothome.co.kr/android/BuBudiatyUploadPlan.php";
        SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Log.d("테이블 입력 성공", response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("실패", error.toString());
            }
        });
        if(year==null)year="null";
        if(month==null)month="null";
        if(day==null)day="null";
        if(plan==null)plan="null";
        if(time==null)time="null";
        if(repeat==null)repeat="null";
        if(alarm==null)alarm="null";


        multiPartRequest.addStringParam("year", year);
        multiPartRequest.addStringParam("month", month);
        multiPartRequest.addStringParam("day", day);
        multiPartRequest.addStringParam("plan", plan);
        multiPartRequest.addStringParam("time", time);
        multiPartRequest.addStringParam("repeat", repeat);
        multiPartRequest.addStringParam("alarm", alarm);
        multiPartRequest.addStringParam("personEmail", LoginMemberClass.personId);
        System.out.println(LoginMemberClass.personId + "여기요");
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(multiPartRequest);


    }//uploadDB


    void loadTable(final Context context, final String personEmail) {

        String serverUrl = "http://tpghks521.dothome.co.kr/android/BuBudiaryLoadPlan.php";

        SimpleMultiPartRequest multiPartRequest_load_table = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                plan_lists.clear();
                System.out.println(response+"이거");

                String row[] =response.split("%");
                String colume[][]= new String[row.length][];

                for(int i =0;i<row.length;i++) {
                    colume[i]  = row[i].split("&");
                    plan_lists.add(new Plan_list(colume[i][0],colume[i][1],colume[i][2],colume[i][3],colume[i][4],colume[i][5],colume[i][6],colume[i][7]));
                }
                Calender_Activity.calender_adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error + "에러");
            }
        }
        );
        multiPartRequest_load_table.addStringParam("personEmail", personEmail);
        RequestQueue requestQueue_loadTable = Volley.newRequestQueue(context);
        requestQueue_loadTable.add(multiPartRequest_load_table);

    }//loadTable


    void createTable(Context context, String personEmail) {
        String serverUrl = "http://tpghks521.dothome.co.kr/android/BuBudiarycreateTable.php";
        SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("테이블 만들기 성공", response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        multiPartRequest.addStringParam("personEmail", personEmail);
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(multiPartRequest);
    }//DBclass_Plan


}//class
