package indi.aljet.mypreloader_master.preloader.util;

import android.util.Log;

/**
 * Created by LJL-lenovo on 2018/11/5.
 */

public class PreLoaderLogger implements ILogger {

    private boolean isShowLog;

    @Override
    public void showLog(boolean isShowLog) {
        this.isShowLog = isShowLog;
        Log.i(getDefaultTag(),"showLog = " + isShowLog);
    }

    @Override
    public void debug(String message) {
        debug(getDefaultTag(),message);
    }

    @Override
    public void debug(String tag, String message) {
        if (isShowLog){
            if(tag == null){
                tag = "";
            }
            if(message == null){
                message = "";
            }
            Log.d(tag,message);
        }
    }

    @Override
    public void info(String message) {
        info(getDefaultTag(),message);
    }

    @Override
    public void info(String tag, String message) {
        if (isShowLog){
            if(tag == null){
                tag = "";
            }
            if (message == null){
                message = "";
            }
            Log.i(tag,message);
        }
    }

    @Override
    public void warning(String message) {
        warning(getDefaultTag(), message);
    }

    @Override
    public void warning(String tag, String message) {
        if (isShowLog) {
            if (tag == null) {
                tag = "";
            }
            if (message == null) {
                message = "";
            }
            Log.w(tag, message);
        }
    }

    @Override
    public void error(String message) {
        error(getDefaultTag(), message);
    }

    @Override
    public void error(String tag, String message) {
        if (isShowLog) {
            if (tag == null) {
                tag = "";
            }
            if (message == null) {
                message = "";
            }
            Log.e(tag, message);
        }
    }

    @Override
    public void throwable(Throwable th) {
        StackTraceElement stackTraceElement =
                Thread.currentThread()
                .getStackTrace()[3];
                error(getMessageStackTrace(stackTraceElement));
    }

    @Override
    public String getDefaultTag() {
        return "MyPreLoader";
    }


    public static String getMessageStackTrace(StackTraceElement stackTraceElement){
        String separator = " & ";
        StringBuilder sb = new StringBuilder();
        String threadName = Thread
                .currentThread().getName();
        String fileName = stackTraceElement
                .getFileName();
        String className = stackTraceElement
                .getClassName();
        String methodName = stackTraceElement
                .getMethodName();
        long threadID = Thread.currentThread()
                .getId();
        int lineNumber = stackTraceElement
                .getLineNumber();

        sb.append("ThreadId=").append(threadID)
                .append(separator);
        sb.append("ThreadName=").append(threadName).append(separator);
        sb.append("FileName=").append(fileName).append(separator);
        sb.append("ClassName=").append(className).append(separator);
        sb.append("MethodName=").append(methodName).append(separator);
        sb.append("LineNumber=").append(lineNumber);

        sb.append(" ] ");
        return sb.toString();
    }
}
