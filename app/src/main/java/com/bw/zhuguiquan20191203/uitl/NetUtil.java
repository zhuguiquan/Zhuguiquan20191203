package com.bw.zhuguiquan20191203.uitl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * DateTime:2019/12/3 0003
 * author:朱贵全(Administrator)
 * function:
 */
public class NetUtil {
    private static NetUtil netUtil=new NetUtil();

    private NetUtil() {
    }

    public static NetUtil getInstance() {
        return netUtil;
    }
    @SuppressLint("StaticFieldLeak")
    public void getJson(final String str, final MyCallBack myCallBack){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPostExecute(String value) {
              if(TextUtils.isEmpty(value)){
                  myCallBack.onError(new Exception("请求失败"));
              }else{
                  myCallBack.ongetjson(value);
              }
            }

            @Override
            protected String doInBackground(Void... voids) {
                InputStream inputStream=null;
                String json="";
                try {
                    URL url = new URL(str);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setReadTimeout(5000);
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.connect();
                    if (urlConnection.getResponseCode()==200) {
                         inputStream = urlConnection.getInputStream();
                         json = orString(inputStream);
                    }else{
                        Log.i("xxx","请求失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return json;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private String orString(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len=-1;
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String s = new String(bytes1);
        return s;
    }
    @SuppressLint("StaticFieldLeak")
    public void getPhoto(final String sr, final ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
               imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                InputStream inputStream=null;
                Bitmap bitmap=null;
                try {
                    URL url = new URL(sr);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setReadTimeout(5000);
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.connect();
                    if (urlConnection.getResponseCode()==200) {
                        inputStream = urlConnection.getInputStream();
                         bitmap = orBitMap(inputStream);
                    }else{
                        Log.i("xxx","请求失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return bitmap;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private Bitmap orBitMap(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }
    public boolean hanNet(Context context){
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo != null&&activeNetworkInfo.isAvailable()) {
            return true;
        }else{
            return false;
        }
    }

    public interface MyCallBack{
        void ongetjson(String json);
        void onError(Throwable throwable);
    }
}
