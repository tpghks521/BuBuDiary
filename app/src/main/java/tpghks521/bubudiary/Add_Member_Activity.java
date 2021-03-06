package tpghks521.bubudiary;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class Add_Member_Activity extends DialogFragment {
    String personEmail;
    String userId;


    TextView email_id;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        personEmail=getArguments().getString("personEmail");
        userId=getArguments().getString("userId");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialog = inflater.inflate(R.layout.activity_add__member_, null);

        email_id=dialog.findViewById(R.id.email_id);

        email_id.setText(userId);

        builder.setView(dialog).setPositiveButton("확인", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                new DBclass().uploadDB(getContext(),personEmail);
                new DBclass().createTable(getContext(),personEmail);
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
