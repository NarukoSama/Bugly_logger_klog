package com.bwie.day0616_bugly_logger_klog;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * 什么是符号表？
 符号表是内存地址与函数名、文件名、行号的映射表。符号表元素如下所示：

 <起始地址> <结束地址> <函数> [<文件名:行号>]

 为什么要配置符号表？
 为了能快速并准确地定位用户APP发生Crash的代码位置，Bugly使用符号表对APP发生Crash的程序堆栈进行解析和还原。
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, MyService.class));

        ActivityInfo info= null;

//        try {
//
//            info = this.getPackageManager()
//                    .getActivityInfo(getComponentName(),
//                            PackageManager.GET_META_DATA);
//
//            ApplicationInfo appInfo = this.getPackageManager()
//                    .getApplicationInfo(getPackageName(),
//                            PackageManager.GET_META_DATA);
//
//
//            String BUGLY_APPID =appInfo.metaData.getString("BUGLY_APPID");
//            String BUGLY_APP_VERSION =appInfo.metaData.getString("BUGLY_APP_VERSION");
//            String BUGLY_APP_CHANNEL =appInfo.metaData.getString("BUGLY_APP_CHANNEL");
//            boolean BUGLY_ENABLE_DEBUG =appInfo.metaData.getBoolean("BUGLY_ENABLE_DEBUG");
//
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    public void test(View view){

//        CrashReport.testJavaCrash();
        CrashReport.testNativeCrash();

    }
}
