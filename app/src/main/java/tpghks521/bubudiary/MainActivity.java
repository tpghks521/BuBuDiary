package tpghks521.bubudiary;



import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);









        Intent intent = new Intent(this, KakaoLoginActivity.class);
        startActivity(intent);


//        Calendar currentTime = Calendar.getInstance();
//
//          System.out.println(
//
//                  currentTime.get(Calendar.YEAR)+" : "
//                  +
//        currentTime.get(Calendar.DATE)+" : "
//        +currentTime.get(Calendar.MONTH)+" : "
//
//     +   ": 시간");
//

    }//onCreate


}





