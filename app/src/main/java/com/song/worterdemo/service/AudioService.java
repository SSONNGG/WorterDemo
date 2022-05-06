package com.song.worterdemo.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class AudioService extends Service {

    private MediaPlayer mp;
    private String query;

    @Override
    public void onCreate() {
        System.out.println("初始化音乐资源  ");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        if (query != null && !query.equals(intent.getStringExtra("query")) && mp != null) {
            mp.start();
        } else {
            String query = intent.getStringExtra("query");
//            Log.e("TAG","http://dict.youdao.com/dictvoice?audio=" + query);
            Uri location = Uri.parse("http://dict.youdao.com/dictvoice?audio=" + query);
            mp = MediaPlayer.create(this, location);
            Log.e("TAG", "onStart:音乐开始播放 " );
            mp.prepareAsync();
            mp.setOnPreparedListener(mp->{
                mp.start();
            });
            //mp.start();

            // 音乐播放完毕的事件处理
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    // 不循环播放
                    try {
                        // mp.start();
                        Log.e("TAG", "onCompletion: Stopped" );
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            });

            // 播放音乐时发生错误的事件处理
            mp.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    // 释放资源
                    try {
                        mp.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                }
            });
        }

        // super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        // 服务停止时停止播放音乐并释放资源
        mp.stop();
        mp.release();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}

