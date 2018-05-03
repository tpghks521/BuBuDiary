package tpghks521.bubudiary;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;

public class Add_Member_Activity extends DialogFragment {
    String personEmail;
    TextView email_id;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        personEmail=getArguments().getString("personEmail");


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialog = inflater.inflate(R.layout.activity_add__member_, null);

        email_id=dialog.findViewById(R.id.email_id);

        email_id.setText(personEmail);

        builder.setView(dialog).setPositiveButton("확인", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


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

                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.add(multiPartRequest);




                Intent intent = new Intent(getContext(), Calender_Activity.class);
                intent.putExtra("personEmail",personEmail);
               startActivity(intent);



           }
        })
        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });



        return builder.create();
    }//oncreateDialog
}//class
