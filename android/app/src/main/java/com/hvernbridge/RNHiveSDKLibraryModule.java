package com.hvernbridge;

import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.istnetworks.hivesdk.presentation.SurveyActivity;

import org.json.JSONObject;

public class RNHiveSDKLibraryModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private static String hiveSDK_MODULE = "RNHiveSDKLibraryModule";
    private Promise promise;

    public RNHiveSDKLibraryModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return hiveSDK_MODULE;
    }

    @ReactMethod
    public void log(String message) {
        Log.d(hiveSDK_MODULE, message);
    }

    @ReactMethod
    public void startSurvey(final String arguments, final Promise promise) {
        this.promise = promise;
        try {
            JSONObject details = new JSONObject(arguments);
            String userName = details.optString("userName");
            String password = details.optString("password");
            SurveyActivity.startSurvey(reactContext.getCurrentActivity(), userName, password);
        } catch (Exception e) {
            promise.reject("Error", e.getMessage(), new Throwable(e.getMessage()));
        }
    }


}