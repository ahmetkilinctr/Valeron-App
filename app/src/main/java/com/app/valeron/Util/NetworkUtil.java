package com.app.valeron.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ahmet on 27.04.2017.
 */

public class NetworkUtil {

    public static final String TAG = NetworkUtil.class.getSimpleName();

    private NetworkUtil() {
    }
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable();
    }

    public static String downloadContent(String url) {
        String result = null;
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
        return result;
    }

    public static Bitmap downloadBitmap(String uri) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(uri);
            bitmap = BitmapFactory.decodeStream(url.openStream());
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return bitmap;
    }
}
