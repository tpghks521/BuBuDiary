package tpghks521.bubudiary;

import android.app.Activity;
import android.app.Application;

import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.KakaoAdapter;
import com.kakao.auth.KakaoSDK;

/**
 * Created by tpghk on 2018-05-16.
 */

public class ApplicationController extends Application {
private static ApplicationController instance=null;
private static volatile Activity ourrentActivity=null;



public static ApplicationController getinstance(){return instance;}


    @Override
    public void onCreate() {
        super.onCreate();

        
        ApplicationController.instance=this;
        KakaoSDK.init(new KakaoAdapter() {
            @Override
            public IApplicationConfig getApplicationConfig() {
                return null;
            }
        });

    }
}
