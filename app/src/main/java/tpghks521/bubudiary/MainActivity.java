package tpghks521.bubudiary;


import android.content.Intent;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;



public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener{

    GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "SignInActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();




        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        Button button =findViewById(R.id.sign_out_button);
        signInButton.setOnClickListener(this);
        button.setOnClickListener(this);

    }//onCreate
    @Override
    public void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//if(account!=null) {
//    Intent intent = new Intent(this, Calender_Activity.class);
//    startActivity(intent);
//
//}


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }

    }//onActivityResult

    private  void handleSignInResult(GoogleSignInResult result){
        Log.d(TAG,"handlesignInresult :" + result.isSuccess());
        if(result.isSuccess()){
            GoogleSignInAccount acct =result.getSignInAccount();
            String personName =acct.getDisplayName();
            String personEmail =acct.getEmail();
            String personId =acct.getId();
            Uri personPhoto =acct.getPhotoUrl();
            System.out.println(personName);
            System.out.println(personEmail);
            System.out.println(personId);
            System.out.println(personPhoto);

        }else{

        }
    }//handleSignInResult
    private void signIn(){
        Intent sighInIntent= Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(sighInIntent,RC_SIGN_IN);


    }

    private void signOut()  {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {

            }
        });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_button:
                signIn();


                break;
            case R.id.sign_out_button:
                signOut();
                break;
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


//    public void clickLogin(View view) {
//        Intent intent  = new Intent(this,Calender_Activity.class);
//        startActivity(intent);
//    }
}
