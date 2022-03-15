package com.song.worterdemo.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.song.worterdemo.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseUtil {

    private final int BUFFER_SIZE = 400000;
    public static final String DB_NAME = "worter.db"; //保存的数据库文件名
    public static final String PACKAGE_NAME = "com.song.worterdemo";//此处改为自己应用的包名。
    public static final String DB_PATH = "/data/data/"
            + PACKAGE_NAME+"/databases";  //在手机里存放数据库的位置
    private SQLiteDatabase database;
    public Context context;

    public DatabaseUtil(Context context) {
        this.context = context;
    }

    public void openDatabase() {
        this.database = this.openDatabase(DB_PATH + "/" + DB_NAME);
    }

    public SQLiteDatabase openDatabase(String dbfile) {
        try {
            if (!(new File(dbfile).exists()))
            {
                //没有创建文件夹
                File f=new File(DB_PATH);
                if (!f.exists()){
                    f.mkdir();
                }
                //判断数据库文件是否存在，若不存在则执行导入，否则直接打开数据库
                InputStream is = this.context.getResources().openRawResource(
                        R.raw.worter); //欲导入的数据库
                FileOutputStream fos = new FileOutputStream(new File(dbfile));
                byte[] buffer = new byte[BUFFER_SIZE];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            }
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile,
                    null);
            return db;
        } catch (FileNotFoundException e) {
            Log.e("Database", "File not found");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("Database", "IO exception");
            e.printStackTrace();
        }
        return null;
    }

    //do something else h
    public void closeDatabase() {
        this.database.close();
    }

}