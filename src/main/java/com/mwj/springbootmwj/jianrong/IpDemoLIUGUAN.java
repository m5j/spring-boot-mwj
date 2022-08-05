package com.mwj.springbootmwj.jianrong;

import cn.hutool.http.HttpUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by minwujun on 2022/8/2
 */
public class IpDemoLIUGUAN {

    /**
     * 用户提取订单号（提取包月版、提取充值版）
     */
    public static String orderId = "O22080217294278046348";
    /**
     * 用户秘钥
     */
    public static String secret = "b1ac72d3f1ee46df890b4bde9ed9c3b3";
    /**
     * 提取ip接口链接
     */
    public static String apiUrl = "http://api.hailiangip.com:8422/api/getIp";

    /**
     * 提取ip协议类型 1:http/https 2:socks5
     */
    public static int type = 1;

    /**
     * 提取个数 min:1  max:200
     */
    public static int num = 1;

    /**
     * 解绑时长
     */
    public static int unbindTime = 300;

    /**
     * 返回数据格式 0:json  1:txt  2:html
     */
    public static int dataType = 1;


    public static void main(String[] args) throws IOException {

        Map<String, Object> params = getParamMap();
        StringBuffer sb = new StringBuffer(apiUrl);
        sb.append("?");
        params.entrySet().stream().forEach(param -> {
            sb.append(param.getKey()).append("=").append(param.getValue()).append("&");
        });
        String url = sb.toString();

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        httpget.addHeader("Accept-Encoding", "gzip");
        CloseableHttpResponse response = httpclient.execute(httpget);
        System.out.println(response.getStatusLine());
        String proxyHostStr = EntityUtils.toString(response.getEntity());
        System.out.println("提取到的代理ip:" + proxyHostStr);

        if (StringUtils.isBlank(proxyHostStr) || proxyHostStr.contains("false") || proxyHostStr.contains("余额不足")) {
            return;
        }

//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("111.196.130.119", 4213));
//        URL url = new URL("https://www.baidu.com");
//        URLConnection urlConnection = url.openConnection(proxy);
//        InputStream inputStream = urlConnection.getInputStream();
//        ByteArrayOutputStream result = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int len;
//        while ((len = inputStream.read(buffer)) != -1) {
//            result.write(buffer, 0, len);
//        }
//        String str = result.toString(StandardCharsets.UTF_8.name());
//        System.out.println(str);

        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");
        Proxy proxy = new Proxy().setHttpProxy(proxyHostStr).setSslProxy(proxyHostStr);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox"); //禁用沙盒模式
        options.addArguments("disable-gpu"); //禁用GPU加速
        options.addArguments("disable-infobars"); //去掉Chrome提示受到自动软件控制
        options.setCapability("proxy", proxy);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        driver.get("https://www.baidu.com");

//        driver.get("http://api.hailiangip.com:8422/api/myIp");
        driver.get("https://image.jiayuan.ccbhome.cn/scss/h5/#/pages/pagesA/storageRoom/personRoomDetail/personRoomDetail?id=DY11000020220801211946201YM1WNVK&source=7&roomType=7&cityCode=110000");
        driver.close();
    }


    public static Map<String, Object> getParamMap() {
        Map<String, Object> map = new HashMap(10);
        map.put("type", type);
        map.put("num", num);
        map.put("unbindTime", unbindTime);
        map.put("dataType", dataType);
        map.put("orderId", orderId);
        map.put("time", System.currentTimeMillis() / 1000);
        map.put("sign", getSign(orderId, secret));
        return map;
    }

    public static String getSign(String orderId, String secret) {
        long time = System.currentTimeMillis() / 1000;
        String str1 = String.format("orderId=%s&secret=%s&time=%s", orderId, secret, time);
        String sign = org.apache.commons.codec.digest.DigestUtils.md5Hex(str1).toLowerCase();
        return sign;
    }

}
