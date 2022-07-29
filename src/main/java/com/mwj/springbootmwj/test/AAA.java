package com.mwj.springbootmwj.test;

import cn.hutool.http.HttpUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by minwujun on 2022/7/27
 */
public class AAA {

    //    需要请求的目标网址
    private static final String TARGET_URL = "http://api.hailiangip.com:8422/api/myIp";
    //    提取链接
    private static final String API_URL = "http://webapi.http.zhimacangku.com/getip?num=1&type=1&pro=440000&city=440100&yys=0&port=11&pack=255168&ts=0&ys=0&cs=0&lb=0&sb=0&pb=4&mr=1&regions=";

    public static void main(String[] args) {

        String result = HttpUtil.get(API_URL);

        System.out.println("从接口获取回来的ip:" + result.trim());
        String proxyIp = result.trim();
        try {
            Proxies(TARGET_URL, proxyIp);
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void Proxies(String urlString, String ipPort) {
        try {
            Response response = null;
            try {
                System.out.println("代理ip：" + ipPort);

                String ip = ipPort.split(":")[0];
                int port = Integer.parseInt(ipPort.split(":")[1]);
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
                OkHttpClient httpClient = new OkHttpClient().newBuilder().proxy(proxy).connectTimeout(10, TimeUnit.SECONDS)
                        .build();

                Request request = null;
                request = (new Request.Builder().url(urlString).build());
                response = httpClient.newCall(request).execute();
                System.out.println("输出结果2：" + Objects.requireNonNull(response.body()).string());
            } catch (IOException e) {
                System.out.println("请求出错1");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("请求出错2");
            e.printStackTrace();
        }
    }


}
