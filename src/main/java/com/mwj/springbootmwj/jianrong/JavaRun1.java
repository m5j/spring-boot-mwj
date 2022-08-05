package com.mwj.springbootmwj.jianrong;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executors;

/**
 * Created by minwujun on 2022/8/1
 */
public class JavaRun1 {

    private static final Queue<String> URL_LIST = new ArrayDeque<>();

    static {
        URL_LIST.add("https://www.taobao.com");
//        URL_LIST.add("https://image.jiayuan.ccbhome.cn/scss/h5/#/pages/pagesA/storageRoom/personRoomDetail/personRoomDetail?id=DY330100202207121521091038X2RGSC&source=7&roomType=7&cityCode=330100");
        URL_LIST.add("https://www.baidu.com");
//        URL_LIST.add("https://www.taobao.com");
//        URL_LIST.add("https://www.jd.com");
//        URL_LIST.add("https://www.csdn.net/");
//        URL_LIST.add("https://juejin.cn/");
//        URL_LIST.add("https://www.zhihu.com/");
//        URL_LIST.add("https://gitee.com/");
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");

        WebDriver webDriver = getWebDriver();
        for (String url : URL_LIST) {
            System.out.println(url);
//            Executors.newFixedThreadPool(40).execute(() -> {
//                ChromeOptions option = new ChromeOptions();
//                option.addArguments("no-sandbox");
//                WebDriver driver = new ChromeDriver(option);
//                func1(driver, url);
                webDriver.get(url);
//            });
        }
    }

    private static WebDriver getWebDriver() {
        //获取代理IP，设置进浏览器
//        String proxyIp = ProxyIpUtil.genIp();
//        Proxy proxy = new Proxy().setHttpProxy(proxyIp).setSslProxy(proxyIp);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox"); //禁用沙盒模式
        options.addArguments("disable-gpu"); //禁用GPU加速
        options.addArguments("disable-infobars"); //去掉Chrome提示受到自动软件控制
//        options.setCapability("proxy", proxy);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }


}
