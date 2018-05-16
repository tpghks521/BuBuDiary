package tpghks521.bubudiary;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.KakaoAdapter;
import com.kakao.auth.KakaoSDK;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tpghk on 2018-05-16.
 */

public class ApplicationController extends Application {
private static ApplicationController instance=null;
private static volatile Activity currentActivity=null;



public static ApplicationController getinstance(){
    if(instance ==null)
        throw new IllegalStateException("this application does not inherit GlobalApplication");
    return instance;}


    @Override
    public void onCreate() {
        super.onCreate();


        instance=this;
        KakaoSDK.init(new kakaoSDKAdapter());

    }//oncreate

    public static Activity getCurrentActivity() { return currentActivity;};

    public static void setCurrentActivity(Activity currentActivity){
        ApplicationController.currentActivity=currentActivity;

    }//setCurrentActivity

    @Override
    public void onTerminate() {
        super.onTerminate();
    instance=null;
    }
}//class
