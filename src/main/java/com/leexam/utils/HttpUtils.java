package com.leexam.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    public static String request(String api) {
        HttpURLConnection httpURLConnection = null;
        int code = 0;//获取HTTP请求状态码
        try {//连接API(需要有网络)
            URL url = new URL(api);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            code = httpURLConnection.getResponseCode();
        } catch (Exception e) {
            return "##出现错误，网络连接异常，请检查网络##";
        }
        if (code >= 200 && code < 300) {//状态码2开头代表成功。

            try (InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                return stringBuilder.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "##出现错误，错误编码##：" + code;
    }
}
