package tpghks521.bubudiary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
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

    Context context;

    FragmentManager fragmentManager;

    public DBclass(Context context) {
        this.context=context;


    }

boolean check_id;


void uploadDB(String personEmail){
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

    boolean loadDB(final String personEmail, final FragmentManager fragmentManager){
        this.fragmentManager=fragmentManager;

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

return check_id;
    }//loadDB

}
