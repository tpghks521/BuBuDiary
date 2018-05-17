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

/**
 * Created by alfo6-13 on 2018-05-04.
 */

public class DBclass {





void uploadDB(Context context,String personEmail){
    String serverUrl="http://tpghks521.dothome.co.kr/android/BuBudaiary_DB.php";
    // String serverUrl="http://tpghks521.dothome.co.kr/android/aaa.php";
    SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {

        @Override
        public void onResponse(String response) {
            System.out.println("성공 : "+response);

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            System.out.println("연결실패"+error);
        }
    });


    multiPartRequest.addStringParam("personEmail",personEmail);

    RequestQueue requestQueue = Volley.newRequestQueue(context);
    requestQueue.add(multiPartRequest);


}//uploadDB

    void loadDB(final Context context, final String personEmail, final String userId, final FragmentManager fragmentManager){

        String serverUrl="http://tpghks521.dothome.co.kr/android/DuDudaiary_DB_load.php";
        SimpleMultiPartRequest multiPartRequest_load = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                if(response.equals("yes")) {
                                    System.out.println("된다");


                                    Intent intent = new Intent(context,Calender_Activity.class);
                                    context.startActivity(intent);


                                }else if(response.equals("no")) {
                                    System.out.println("없다");
                                   Bundle args = new Bundle();
                                   args.putString("personEmail",personEmail);
                                    args.putString("userId",userId);
                                   Add_Member_Activity ama = new Add_Member_Activity();
                                  ama.setArguments(args);
                                  ama.show(fragmentManager,"test");



                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                System.out.println(error);

                            }
                          });

        multiPartRequest_load.addStringParam("personEmail",personEmail);

        RequestQueue requestQueue_load = Volley.newRequestQueue(context);
        requestQueue_load.add(multiPartRequest_load);

    }//loadDB


    void table_uploadDB(Context context,String year, String month, String day, String plan, String time, String repeat, String alarm){




        String serverUrl="http://tpghks521.dothome.co.kr/android/BuBudiatyUploadPlan.php";
        SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Log.d("테이블 입력 성공",response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("실패",error.toString());
            }
        });

        multiPartRequest.addStringParam("year",year);
        multiPartRequest.addStringParam("month",month);
        multiPartRequest.addStringParam("day",day);
        multiPartRequest.addStringParam("plan",plan);
        multiPartRequest.addStringParam("time",time);
        multiPartRequest.addStringParam("repeat",repeat);
        multiPartRequest.addStringParam("alarm",alarm);
        multiPartRequest.addStringParam("personEmail",LoginMemberClass.personId);

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(multiPartRequest);


    }//uploadDB




    void createTable(Context context , String personEmail){
        String serverUrl="http://tpghks521.dothome.co.kr/android/BuBudiarycreateTable.php";
        SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("테이블 만들기 성공",response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        multiPartRequest.addStringParam("personEmail",personEmail);
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(multiPartRequest);
    }//DBclass_Plan


}//class
