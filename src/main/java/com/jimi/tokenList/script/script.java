package com.jimi.tokenList.script;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.*;


public interface script {



    public static void call_me() throws Exception {
        String access_token = "";
        String refresh_token = "";

        Boolean should_run = true;
        while (should_run) {



            int ResponseCode = 1;
            while (ResponseCode != 0) {

                if (refresh_token == ""){
                SimpleDateFormat gmtDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                //Current Date Time in GMT
                System.out.println("Current Date and Time in GMT time zone: " + gmtDateFormat.format(new Date()));

                URL url = new URL("http://open.10000track.com/route/rest");
                Map<String, String> params = new HashMap<>();
                params.put("method", "jimi.oauth.token.get");
                params.put("timestamp", gmtDateFormat.format(new Date()));
                params.put("app_key", "8FB345B8693CCD00E24B3F5EEE161B65");
                params.put("sign", "23bfa9c9590a239d9fa25628e3149f96");
                params.put("sign_method", "md5");
                params.put("v", "0.9");
                params.put("format", "json");
                params.put("user_id", "liveasy@97");
                params.put("user_pwd_md5", "cc120882480fd847d5a092a2d9817e75");
                params.put("expires_in", "7200");

                StringBuilder postData = new StringBuilder();

                for (Map.Entry<String, String> param : params.entrySet()) {
                    if (postData.length() != 0) postData.append('&');
                    postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                    postData.append('=');
                    postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
                }
                byte[] postDataBytes = postData.toString().getBytes("UTF-8");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
                conn.setDoOutput(true);
                conn.getOutputStream().write(postDataBytes);
                Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                for (int c; (c = in.read()) >= 0; )
                    sb.append((char) c);
                String response = sb.toString();
                System.out.println(response);

                JSONObject myResponse = new JSONObject(response.toString());
                System.out.println("code- " + myResponse.getString("code"));
                ResponseCode = Integer.parseInt(myResponse.getString("code"));
                if (ResponseCode != 0) {

                    break;
                }
                System.out.println("message- " + myResponse.getString("message"));
                JSONObject result = myResponse.getJSONObject("result");
                System.out.println(result);
                System.out.println("Access Token- " + result.getString("accessToken"));
                System.out.println("Refresh Token- " + result.getString("refreshToken"));
                String accessToken = result.getString("accessToken");
                access_token = result.getString("accessToken");
                refresh_token = result.getString("refreshToken");

                CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                HttpPost request = new HttpPost("http://localhost:1000/token");
                StringEntity output_params = new StringEntity(accessToken);
                request.addHeader("content-type", "application/json");
                request.setEntity(output_params);
                HttpResponse output_response = httpClient.execute(request);
                System.out.println(output_response);
                System.out.println(output_response.toString().substring(27, 30));

            }
            else
                {
                    SimpleDateFormat gmtDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                    //Current Date Time in GMT
                    System.out.println("Current Date and Time in GMT time zone: " + gmtDateFormat.format(new Date()));

                    URL url = new URL("http://open.10000track.com/route/rest");
                    Map<String, String> params = new HashMap<>();
                    params.put("method", "jimi.oauth.token.refresh");
                    params.put("timestamp", gmtDateFormat.format(new Date()));
                    params.put("app_key", "8FB345B8693CCD00E24B3F5EEE161B65");
                    params.put("sign", "23bfa9c9590a239d9fa25628e3149f96");
                    params.put("sign_method", "md5");
                    params.put("v", "0.9");
                    params.put("format", "json");
                    params.put("expires_in", "7200");
                    params.put("access_token", access_token);
                    params.put("refresh_token", refresh_token);

                    StringBuilder postData = new StringBuilder();

                    for (Map.Entry<String, String> param : params.entrySet()) {
                        if (postData.length() != 0) postData.append('&');
                        postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                        postData.append('=');
                        postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
                    }
                    byte[] postDataBytes = postData.toString().getBytes("UTF-8");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
                    conn.setDoOutput(true);
                    conn.getOutputStream().write(postDataBytes);
                    Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    for (int c; (c = in.read()) >= 0; )
                        sb.append((char) c);
                    String response = sb.toString();
                    System.out.println(response);

                    JSONObject myResponse = new JSONObject(response.toString());
                    System.out.println("code- " + myResponse.getString("code"));
                    ResponseCode = Integer.parseInt(myResponse.getString("code"));
                    if (ResponseCode != 0) {

                        break;
                    }
                    System.out.println("message- " + myResponse.getString("message"));
                    JSONObject result = myResponse.getJSONObject("result");
                    System.out.println(result);
                    System.out.println("AccessToken- " + result.getString("accessToken"));
                    System.out.println("RefreshToken- " + result.getString("refreshToken"));
                    String accessToken = result.getString("accessToken");
                    access_token = result.getString("accessToken");
                    refresh_token = result.getString("refreshToken");

                    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                    HttpPost request = new HttpPost("http://localhost:1000/token");
                    StringEntity output_params = new StringEntity(accessToken);
                    request.addHeader("content-type", "application/json");
                    request.setEntity(output_params);
                    HttpResponse output_response = httpClient.execute(request);
                    System.out.println(output_response);
                    System.out.println(output_response.toString().substring(27, 30));
                }}
            if (ResponseCode != 0){
                Thread.sleep(30 * 1000); //wait for 30 sec if didn't got a token
            }
            else {
            Thread.sleep(3600 * 1000); }// Program will run after every 3600 seconds

        }

    }
}
