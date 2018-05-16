package tpghks521.bubudiary;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;


public class KakaoLoginActivity extends AppCompatActivity {

    SessionCallback callback;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao_login);



        callback=new SessionCallback();

        Session.getCurrentSession().addCallback(callback);
       Session.getCurrentSession().checkAndImplicitOpen();
//        Session.getCurrentSession().open(AuthType.KAKAO_TALK_EXCLUDE_NATIVE_LOGIN,KakaoLoginActivity.this);

    }//onCreate


    @Override
    protected void onDestroy() {
        System.out.println("a1");
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);


    }

    private  class SessionCallback implements ISessionCallback{

        @Override
        public void onSessionOpened() {
            System.out.println("a2");
                redirectSignupActivity();
        }//onSessionOpened

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            System.out.println("a3");
            if(exception != null){
                Logger.e(exception);
            }
            setContentView(R.layout.kakao_login_layout);

        }//onSessionOpenFailed





    }//SessionCallback

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("a4");

        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data))
            return;

        super.onActivityResult(requestCode, resultCode, data);



    }
    protected void redirectSignupActivity(){
        System.out.println("a5");
        final Intent intent = new Intent(this,KakaoSignupActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();


    }
}//class
