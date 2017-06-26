package com.bwie.day0616_bugly_logger_klog;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by muhanxi on 17/6/15.
 */

public class IApplication extends Application {


    public static IApplication application ;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this ;

//        CrashReport.initCrashReport(getApplicationContext(), "1b247ba0cb", true);

        System.out.println("application = " + application);

        //如果有多个进程 只在主进程中上报

        Context context = getApplicationContext();
// 获取当前包名
        String packageName = context.getPackageName();
// 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
// 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
// 初始化Bugly     参数3为true表示实时上报（异常，错误……）
        CrashReport.initCrashReport(context, "1b247ba0cb", true, strategy);
//        Logger.addLogAdapter(new AndroidLogAdapter());
//        Logger.addLogAdapter(new DiskLogAdapter());

    }


    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

}
