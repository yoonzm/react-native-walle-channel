package com.reactnativewallechannel;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.meituan.android.walle.ChannelInfo;
import com.meituan.android.walle.WalleChannelReader;

import java.util.Map;

@ReactModule(name = WalleChannelModule.NAME)
public class WalleChannelModule extends ReactContextBaseJavaModule {
    public static final String NAME = "WalleChannel";
    private ReactApplicationContext reactContext;

    public WalleChannelModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getChannel(Promise promise) {
      String channel = WalleChannelReader.getChannel(reactContext);
      promise.resolve(channel);
    }

    @ReactMethod
    public void getExtraInfo(Promise promise) {
      ChannelInfo channelInfo = WalleChannelReader.getChannelInfo(reactContext);
      if (channelInfo != null) {
        Map extraInfo = channelInfo.getExtraInfo();
        WritableMap writableMap = Arguments.makeNativeMap(extraInfo);
        promise.resolve(writableMap);
        return;
      }
      promise.resolve(null);
    }
}
