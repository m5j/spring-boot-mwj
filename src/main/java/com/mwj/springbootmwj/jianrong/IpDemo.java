package com.mwj.springbootmwj.jianrong;

import cn.hutool.http.HttpUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

/**
 * Created by minwujun on 2022/8/2
 */
public class IpDemo {
    //http://webapi.http.zhimacangku.com/getip?num=1&type=2&pro=110000&city=110200&yys=0&port=1&time=1&ts=0&ys=0&cs=0&lb=1&sb=0&pb=4&mr=1&regions=
    public static void main(String[] args) throws IOException, InterruptedException {
        String ipApiPath = "http://dw.tiqu.letecs.com/getip_cm?num=1&type=1&pro=110000&city=110200&yys=0&port=1&time=1&ts=0&ys=0&cs=0&lb=1&sb=0&pb=4&mr=1&regions=&code=ccj2f9a08r";
        String ip = HttpUtil.get(ipApiPath).trim();
//        String ip = "111.196.130.119:4213";
        System.out.println(ip);
        if (ip.contains("false")) {
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
        Proxy proxy = new Proxy().setHttpProxy(ip).setSslProxy(ip);
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
        //        driver.close();


    }


}
