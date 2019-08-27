package com.choice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.image.DirectColorModel;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;


public class Login {
    private String name;
    private String pwd;
    private String url;
    public WebDriver driver;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void initAtion(){
        System.setProperty("webdriver.chrome.driver", "D:/Tool/idea/chromedriver.exe");
        driver= new ChromeDriver();
        
    }

//    /**
//     * 构造方法
//     * @param url
//     * @param name
//     * @param pwd
//     */
//    public Login(String url,String name,String pwd){
//        this.url = url;
//        this.name = name;
//        this.pwd = pwd;
//    }

    /**
     * 登录方法
     */
    public void  loginMethod() throws InterruptedException {
        this.initAtion();
        driver.manage().window().maximize();

        driver.get(this.url);
//        WebElement name = driver.findElement(By.id("accountName"));
        WebElement name = this.element(this.byStr("id","accountName"));
        name.sendKeys(this.name);
        name.isDisplayed();

        WebElement pwd = driver.findElement(By.id("accountPwd"));
        pwd.sendKeys(this.pwd);
        pwd.isDisplayed();
        /**
         * 查找验证码
         */
        WebElement find_code = driver.findElement(By.id("code"));
        System.out.println(find_code.getText());
        /**
         *输入验证码
         */
        WebElement input_code = driver.findElement(By.id("inputCode"));
        input_code.sendKeys(new CharSequence[]{find_code.getText()});
        input_code.isDisplayed();
        /**
         * 提交表单
         */
        WebElement login = driver.findElement(By.id("login"));
        login.submit();
        /**
         * 门店品牌设置
         */
        /**
         * 进入新增品牌界面
         */
        driver.findElement(By.xpath("//*[@id=\"menubar\"]/ul/li[1]/div")).click();
        Thread.sleep(300);
        //进入树
        driver.findElement(By.xpath("//*[@id=\"menubar\"]/ul/li[1]/ul/li[13]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"menubar\"]/ul/li[1]/ul/li[13]/ul/li[1]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"menubar\"]/ul/li[1]/ul/li[13]/ul/li[1]/ul/li[1]/div")).click();
        //frame跳转
        driver.switchTo().frame(driver.findElement(By.id("iframe_4ec02b4937da498bacf710753d0bb67a")));
        driver.findElement(By.id("autoId-button-101")).click();
        driver.switchTo().frame(driver.findElement(By.id("saveFrame")));
        driver.findElement(By.id("vname")).sendKeys("磐石");
        /**
         * 保存
         */
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("iframe_4ec02b4937da498bacf710753d0bb67a")));
        Thread.sleep(300);
        WebElement save =driver.findElement(By.xpath("//*[@id=\"autoId-button-107\"]/div[1]/div"));
        save.click();
        System.out.print(save.getText());
        Thread.sleep(300);


        //每页显示数量
       driver.findElement(By.className("pgPerSize")).sendKeys("180");
        Thread.sleep(300);
        driver.findElement(By.linkText("磐石")).click();






    }

    /**
     * 封装by
     * @param by
     * @param local
     * @return
     */
    public By byStr(String by,String local){
        if(by.equals("id")){
            return  By.id(local);
        }else if (by.equals("name")){
            return By.name(local);
        }else {
            return null;
        }

    }


    public WebElement  element(By by){
        WebElement ele = driver.findElement(this.byStr("id","accountName"));
        return ele;
    }
}

