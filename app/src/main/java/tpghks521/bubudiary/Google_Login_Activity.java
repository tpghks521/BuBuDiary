package tpghks521.bubudiary;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class Google_Login_Activity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,View.OnClickListener{
    GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "SignInActivity";
    String personName;
    String personEmail;
    String personId;
    boolean b;
    Bundle args;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google__login_);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if( checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                //허용이 안되어 있는 상태이므로 퍼미션요청 다이얼로그 보이기
                requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
        }



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

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 100:
                if(grantResults[0]==PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this, "이미지 선택이 불가능합니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }//onRequestPermissionsResult
    @Override
    public void onStart() {
        super.onStart();


//            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);




    }//onStart

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);

            args = new Bundle();
            args.putString("personEmail",personEmail);
            //-------------------------------------------------------------------------------------------------
            DBclass checkId =new DBclass(this);
//            checkId.setDialogId(R.)
            b =checkId.loadDB(personEmail);
// 다이얼로그 생성을 DB클래스에서 하게끔 코드를 바꾸어야한다.
            // 쓰레드라서 볼리가 먼저 실행이 되버린다.

}

    }//onActivityResu



    void aa(){
        if (b) {
            Add_Member_Activity ama = new Add_Member_Activity();
            ama.setArguments(args);
            ama.show(getSupportFragmentManager(), "test");
        } else {
            Intent intent = new Intent(this, Calender_Activity.class);
            intent.putExtra("personEmail", personEmail);
            startActivity(intent);
        }
    }//aa


    private  void handleSignInResult(GoogleSignInResult result){
        Log.d(TAG,"handlesignInresult :" + result.isSuccess());
        if(result.isSuccess()){
            GoogleSignInAccount acct =result.getSignInAccount();
            personName =acct.getDisplayName();
            personEmail =acct.getEmail();
            personId =acct.getId();

            System.out.println(personName);
            System.out.println(personEmail);
            System.out.println(personId);

        }else{

        }


    }//handleSignInResult
    private void signIn(){
        Intent sighInIntent= Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
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
}//class
