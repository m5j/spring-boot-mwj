package com.mwj.springbootmwj.jianrong;

import cn.hutool.http.HttpUtil;
import org.python.util.PythonInterpreter;

import java.io.IOException;

/**
 * Created by minwujun on 2022/7/29
 */
public class JavaRunPython {
//http://webapi.http.zhimacangku.com/getip?num=1&type=1&pro=110000&city=110200&yys=0&port=1&pack=255717&ts=0&ys=0&cs=0&lb=1&sb=0&pb=4&mr=1&regions=
    private static final String API_URL = "http://webapi.http.zhimacangku.com/getip?num=1&type=1&pro=110000&city=110200&yys=0&port=1&pack=255717&ts=0&ys=0&cs=0&lb=1&sb=0&pb=4&mr=1&regions=";

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 2; i++) {
//            String result = HttpUtil.get(API_URL);
//            String proxyIp = result.trim();

            String proxyIp = "61.120.155.71";
            System.out.println("从接口获取回来的ip:" + proxyIp);

//            String url = "http://api.hailiangip.com:8422/api/myIp";
            String url = "https://www.baidu.com";
            func2(url, proxyIp);
            Thread.sleep(10);
        }
    }

    //执行py脚本
    private static void func2(String url, String ip) throws IOException {
        String[] args1 = new String[]{"C:\\Users\\minwujun\\AppData\\Local\\Programs\\Python\\Python310\\python.exe",
                "D:\\code\\main.py", url, ip};
        Runtime.getRuntime().exec(args1);
    }

}
