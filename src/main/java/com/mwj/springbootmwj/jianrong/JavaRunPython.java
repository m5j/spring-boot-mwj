package com.mwj.springbootmwj.jianrong;

import cn.hutool.http.HttpUtil;
import org.python.util.PythonInterpreter;

import java.io.IOException;

/**
 * Created by minwujun on 2022/7/29
 */
public class JavaRunPython {

    private static final String API_URL = "http://webapi.http.zhimacangku.com/getip?num=1&type=1&pro=110000&city=110200&yys=0&port=1&pack=255717&ts=0&ys=0&cs=0&lb=1&sb=0&pb=4&mr=1&regions=";
    public static void main(String[] args) throws IOException, InterruptedException {


        for(int i =0 ; i<2;i++) {
            String result = HttpUtil.get(API_URL);
            String proxyIp = result.trim();
            System.out.println("从接口获取回来的ip:" + proxyIp);

            String url = "http://api.hailiangip.com:8422/api/myIp";
            func2(url, proxyIp);
         //   func2(url, proxyIp);

            Thread.sleep(1000);
        }


    }


    //直接执行代码
    private void func1() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("a='hello world'; ");
        interpreter.exec("print a;");
    }

    //执行py脚本
    private static void func2(String url, String ip) throws IOException {
        String [] args1 = new String[] {"D:\\pythoncode\\venv\\Scripts\\python.exe", "D:\\pythoncode\\main.py", url, ip};
        Runtime.getRuntime().exec(args1);
    }

}
