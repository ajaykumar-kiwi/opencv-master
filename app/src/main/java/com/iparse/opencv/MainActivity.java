package com.iparse.opencv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {

/*    private static boolean mLibrariesLoaded = false;
    private static boolean needsPermissionCheck = true;

    static {
        System.loadLibrary("libopencv_core");
        if (OpenCVLoader.initDebug()) {
            mLibrariesLoaded = true;
            Log.e("TAG", "------------------------OpenCV loaded");
        } else {
            Log.e("TAG", "------------------------OpenCV load failed");
        }

        needsPermissionCheck = true;
    }*/

    public native String stringFromJNI(String str);

    static {
        System.loadLibrary("opencv-static-libs");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.textView)).setText(stringFromJNI("Hey this is from JNI"));
    }
}
