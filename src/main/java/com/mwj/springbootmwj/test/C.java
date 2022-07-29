package com.mwj.springbootmwj.test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.awt.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by minwujun on 2022/7/27
 */
public class C {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
//        URL url = new URL("https://image.jiayuan.ccbhome.cn/scss/h5/#/pages/pagesA/storageRoom/personRoomDetail/personRoomDetail?id=DY11000020220712093710026ENJCZDP&source=7&roomType=7&cityCode=110000");


//        func1("http://api.hailiangip.com:8422/api/myIp");
//        func2("http://api.hailiangip.com:8422/api/myIp");
//        func3("http://api.hailiangip.com:8422/api/myIp");
        func4("https://image.jiayuan.ccbhome.cn/scss/h5/#/pages/pagesA/storageRoom/personRoomDetail/personRoomDetail?id=DY11000020220712093710026ENJCZDP&source=7&roomType=7&cityCode=110000");
    }

    public static void func1(String url) throws IOException, URISyntaxException {
        if (Desktop.isDesktopSupported()) {
            URI uri = new URI(url);
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uri);
        }
    }

    public static void func2(String url) throws IOException {

        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);

//        Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
    }


    public static void func3(String url) throws IOException {
        //设置代理IP
        System.setProperty("proxyPort", "12345");
        System.setProperty("proxyHost", "183.66.209.238");
        System.setProperty("proxySet", "true");
        //打开浏览器
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);


        //设置代理IP
        System.setProperty("proxyPort", "54321");
        System.setProperty("proxyHost", "183.66.209.240");
        System.setProperty("proxySet", "true");
        //打开浏览器
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
    }


    public static void func4(String url) throws IOException {
        Response response;
        OkHttpClient httpClient = new OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.SECONDS).build();
        Request request;
        request = (new Request.Builder().url(url).build());
        response = httpClient.newCall(request).execute();
        System.out.println("输出结果2：" + Objects.requireNonNull(response.body()).string());
    }


}
