package tpghks521.bubudiary;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;

public class Google_Login_Activity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "SignInActivity";
    String personName;
    String personEmail;
    String personId;

    GoogleSignInClient googleSignInclient;
    GoogleApiClient mGoogleApiClient;

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google__login_);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if( checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
//                //허용이 안되어 있는 상태이므로 퍼미션요청 다이얼로그 보이기
//                requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
//            }
//        }
//
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleSignInclient = GoogleSignIn.getClient(this,gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
            if(account!=null){
                personName = account.getDisplayName();
                personEmail=account.getEmail();
                Intent intent = new Intent(this,Calender_Activity.class);
                intent.putExtra("personName",personName);
                intent.putExtra("personEmail",personEmail);

                startActivity(intent);

            }


mGoogleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        Button button =findViewById(R.id.sign_out_button);
        fragmentManager=getSupportFragmentManager();
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

    }//constructer

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){


            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            handleSignInResult(task);


            //-------------------------------------------------------------------------------------------------
            DBclass checkId =new DBclass(this);
            checkId.loadDB(personEmail,fragmentManager);

        }

    }//onActivityResu
    private  void handleSignInResult(Task<GoogleSignInAccount> completedTask){

        try {

            GoogleSignInAccount googleSignInAccount = completedTask.getResult(ApiException.class);
            Log.d(TAG,"handlesignInresult :" + completedTask.toString()  +personEmail  +personName);

            personEmail= googleSignInAccount.getEmail();
           personName=googleSignInAccount.getDisplayName();

        } catch (ApiException e) {

            e.printStackTrace();
        }

    }//handleSignInResult
    private void signIn(){

       Intent sighInIntent=googleSignInclient.getSignInIntent();
        startActivityForResult(sighInIntent,RC_SIGN_IN);


    }//signIn
    private void signOut()  {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {

            }
        });
    }//signOut

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}//class
