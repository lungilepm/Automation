package TestHelp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static TestHelp.MethodHelpers.getinputFile;

public class deleteFriendsfirefox {
    private WebDriver driver;
    private Map<String, Object> vars;



    @Test
    public static  void webDrivo () throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lungilemo\\Documents\\logs\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //login to account
        driver.findElement(By.id("email")).sendKeys("mariamotshweni07@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("lungile5744");
        driver.findElement(By.id("u_0_b")).click();
        driver.get("https://m.facebook.com/lungile.motsweni.10/friends?lst=100051719950406%3A100051719950406%3A1595699275&source_ref=pb_friends_tl");

        Actions actions = new Actions(driver);


        while (true) {
            driver.get("https://m.facebook.com/lungile.motsweni.10/friends?lst=100051719950406%3A100051719950406%3A1595699275&source_ref=pb_friends_tl");
            System.out.println("Broke");
            List<WebElement> elements = driver.findElements(By.xpath("//button[@value='Friends']"));
            System.out.println("Links  ____" + elements.size());

            System.out.println("the elements  ____" + elements.get(0));
            List<WebElement> unfriend = driver.findElements(By.xpath("//*[@data-sigil='touchable touchable mflyout-remove-on-click m-unfriend-request']"));
            System.out.println("Here  ____" + unfriend.size());
            for (int i =0; i<elements.size();i++)
            {   elements.get(i).click();
                System.out.println("Element got clicked  ____" + elements.size());
                 if (unfriend.size()==1)
                 {
                     System.out.println("When 1 is  ____" + unfriend.size());
                     WebElement elementLocator = unfriend.get(0);
                     actions.doubleClick(elementLocator).perform();

                 }
                 else{
                     System.out.println("When none is  ____" + unfriend.size());
                 break;
                 }

            }
            System.out.println("Brokenesss is here");

    }}}

/**
 *             if (unfriend.size() == 1) {
 *                 System.out.println("is it enabled  ____" + unfriend.get(0).isEnabled());
 *                 System.out.println("is it displayed  ____" + unfriend.get(0).isDisplayed());
 *                 System.out.println("is it selected  ____" + unfriend.get(0).isSelected());
 *                 unfriend.get(0).click();
 *
 *             }
 *
 *             if (unfriend.size() == 2) {
 *
 *                 System.out.println("is it enabled  ____" + unfriend.get(0).isEnabled());
 *                 System.out.println("is it displayed  ____" + unfriend.get(0).isDisplayed());
 *                 System.out.println("is it displayed  ____" + unfriend.get(0).isSelected());
 *
 *                 System.out.println("is it enabled  ____" + unfriend.get(1).isEnabled());
 *                 System.out.println("is it displayed  ____" + unfriend.get(1).isDisplayed());
 *                 System.out.println("is it displayed  ____" + unfriend.get(1).isSelected());
 *             }
 *             System.out.println("Just  ____" + unfriend.size());
 *         }
 */



