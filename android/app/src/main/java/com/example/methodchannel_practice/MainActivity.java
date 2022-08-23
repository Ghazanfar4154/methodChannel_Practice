package com.example.methodchannel_practice;

import android.content.Intent;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private  static  final String  Channel="myChannel";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(),Channel).setMethodCallHandler(
                (call, result) -> {
                    if(call.method.equals("openCamera"))
                    openCamera();
                }
        );
    }

    private void openCamera() {
        Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }
}