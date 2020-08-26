package TestHelp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static TestHelp.MethodHelpers.getinputFile;

public class deleteFriends {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;


    @Test
    public static  void webDrivo () throws IOException {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\lungilemo\\Documents\\logs\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //login to account
        driver.findElement(By.id("email")).sendKeys("mariamotshweni07@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("lung5744");
        driver.findElement(By.id("u_0_b")).click();
        String line;
        BufferedReader inputFile;
        inputFile = getinputFile("C:\\Users\\lungilemo\\Documents\\logs\\friend.txt");
        while (true){

            while ((line = inputFile.readLine()) != null) {
            driver.get("https://www.facebook.com");

            if (!driver.getTitle().contains("Facebook")) {
                continue;
            }
            driver.get("https://www.facebook.com/search/top/?q=" + line + "&epa=SEARCH_BOX");
            driver.get("https://m.facebook.com/search/top/?q=" + line + "&epa=SEARCH_BOX");
            System.out.println(line);

            Boolean isPresent = driver.findElements(By.className("cl")).size() > 0;
            if (!isPresent) {
                continue;
            }
            driver.findElement(By.className("cl")).click();
            isPresent = driver.findElements(By.linkText("Unfriend")).size() > 0;
            if (!isPresent) {
                continue;
            }
            driver.findElement(By.linkText("Unfriend")).click();

            isPresent = driver.findElements(By.cssSelector(".bq")).size() > 0;
            if (!isPresent) {
                continue;
            }
            driver.findElement(By.cssSelector(".bq")).click();


        }
    }

    }

/**
 public void yeah() {
 driver.get("https://www.facebook.com/");
 driver.manage().window().setSize(new Dimension(550, 698));
 driver.findElement(By.id("email")).sendKeys("mariamotshweni07@gmail.com");
 driver.findElement(By.id("pass")).click();
 driver.findElement(By.id("pass")).sendKeys("lung5744");
 driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
 driver.findElement(By.cssSelector("#js_1k strong")).click();
 driver.findElement(By.name("q")).sendKeys("lerato earl maleka");
 {
 WebElement element = driver.findElement(By.cssSelector("#u_jsonp_2_1 .\\_5vwz:nth-child(2) .\\_4jq5"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element).perform();
 }
 {
 WebElement element = driver.findElement(By.tagName("body"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element, 0, 0).perform();
 }
 {
 WebElement element = driver.findElement(By.cssSelector(".\\_5vwz:nth-child(2) .\\_4xjz"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element).perform();
 }
 js.executeScript("window.scrollTo(0,0)");
 driver.findElement(By.id("js_28")).click();
 driver.findElement(By.cssSelector(".selected .\\_19bk")).click();
 driver.findElement(By.id("js_28")).sendKeys("dlamini zuma");
 {
 WebElement element = driver.findElement(By.cssSelector(".selected .\\_19bk"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element).perform();
 }
 {
 WebElement element = driver.findElement(By.tagName("body"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element, 0, 0).perform();
 }
 driver.findElement(By.id("js_28")).click();
 driver.findElement(By.id("js_28")).sendKeys("nkosi");
 driver.findElement(By.id("js_28")).sendKeys(Keys.ENTER);
 {
 WebElement element = driver.findElement(By.cssSelector("#u_25_5 > .\\_55pe"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element).perform();
 }
 {
 WebElement element = driver.findElement(By.tagName("body"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element, 0, 0).perform();
 }
 driver.findElement(By.cssSelector("#u_25_5 > .\\_4o_3 > .img")).click();
 {
 WebElement element = driver.findElement(By.cssSelector("#u_25_5 > .\\_55pe > span"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element).perform();
 }
 {
 WebElement element = driver.findElement(By.tagName("body"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element, 0, 0).perform();
 }
 driver.findElement(By.cssSelector(".FriendListUnfriend .itemLabel")).click();
 driver.findElement(By.cssSelector("#u_26_5 > .\\_4o_3 > .img")).click();
 {
 WebElement element = driver.findElement(By.cssSelector("#u_26_5 > .\\_4o_3 > .img"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element).perform();
 }
 {
 WebElement element = driver.findElement(By.tagName("body"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element, 0, 0).perform();
 }
 {
 WebElement element = driver.findElement(By.cssSelector("#u_27_5 > .\\_55pe > span"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element).perform();
 }
 {
 WebElement element = driver.findElement(By.tagName("body"));
 Actions builder = new Actions(driver);
 builder.moveToElement(element, 0, 0).perform();
 }
 driver.findElement(By.cssSelector("#u_26_5 > .\\_4o_3 > .img")).click();
 driver.findElement(By.cssSelector(".FriendListUnfriend .itemLabel")).click();
 driver.findElement(By.cssSelector("#u_27_5 > .\\_4o_3 > .img")).click();
 driver.findElement(By.cssSelector(".FriendListUnfriend .itemLabel")).click();
 driver.close();
 }
 **/}


