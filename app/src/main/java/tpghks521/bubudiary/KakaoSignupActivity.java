package tpghks521.bubudiary;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kakao.auth.ErrorCode;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.helper.log.Logger;

/**
 * Created by tpghk on 2018-05-16.
 */

public class KakaoSignupActivity extends AppCompatActivity {

     static String userName;
     static String userId;
     static String profileUrl;
     static FragmentManager fragmentManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("a1");
        requestMe();
        fragmentManager=getSupportFragmentManager();
    }


    protected  void requestMe(){
        UserManagement.requestMe(new MeResponseCallback() {
            @Override
            public void onFailure(ErrorResult errorResult) {
                String message = "failed to get user info. msg=" +errorResult;
                Logger.d(message);
                Log.v("실패","실패");

                ErrorCode result = ErrorCode.valueOf(errorResult.getErrorCode());
                if(result == ErrorCode.CLIENT_ERROR_CODE){
                    finish();
                } else {

                }


            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                redirectLoginActivity();
            }

            @Override
            public void onNotSignedUp() {
                showSigup();
            }

            @Override
            public void onSuccess(UserProfile userProfile) {

                profileUrl = userProfile.getProfileImagePath();
                userId = String.valueOf(userProfile.getId());
                userName = userProfile.getNickname();
                System.out.println(userId+"아이디");
                System.out.println(userName+"네임");
                LoginMemberClass.personId=userId;
                LoginMemberClass.personName=userName;

                redirectMainActivity();
            }
        });

    }

    protected void showSigup(){
        Log.i("에러","에러");
    }
    private void redirectMainActivity(){

//        Intent intent =new Intent(this,Calender_Activity.class);
//        intent.putExtra("personEmail",userId);
//        intent.putExtra("userName",userName);


        DBclass dBclass = new DBclass();
        dBclass.loadDB(KakaoSignupActivity.this,userId,userName,fragmentManager);



//
//        startActivity(intent);

//            finish();
    }
    protected void redirectLoginActivity(){
        final Intent intent = new Intent(this,KakaoLoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();

    }
}
