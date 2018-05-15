package tpghks521.bubudiary;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by tpghk on 2018-05-14.
 */

public class DBclass_Plan {


    void createTable(Context context , String personEmail){
        String serverUrl="http://tpghks521.dothome.co.kr/android/BuBudiarycreateTable.php";
        SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

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


    void uploadDB(Context context,String year, String month, String day, String plan, String time, String repeat, String alarm, String explain){




        String serverUrl="http://tpghks521.dothome.co.kr/android/BuBudiatyUploadPlan.php";
        SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


         Log.d("성공",response);

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
        multiPartRequest.addStringParam("explain",explain);

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(multiPartRequest);


    }//uploadDB





}//DBclass_plan
