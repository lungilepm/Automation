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
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import static TestHelp.MethodHelpers.getinputFile;

public class openFirefoxBrow {



    @Test
   public static  void webDrivo () throws IOException, InterruptedException {

       System.setProperty("webdriver.gecko.driver","C:\\Users\\lungilemo\\Documents\\logs\\geckodriver.exe");
       WebDriver driver=new FirefoxDriver();
       Actions actions = new Actions(driver);

        driver.get("https://platform.easyequities.co.za/Account/SignIn");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //login to account
        driver.findElement(By.id("user-identifier-input")).sendKeys("lungilepm");
        driver.findElement(By.id("Password")).sendKeys("5744Lungile#1");
        driver.findElement(By.id("login")).click();
        String line;
        BufferedReader inputFile;
        inputFile = getinputFile("C:\\Users\\lungilemo\\Documents\\yml\\usa.txt");
        while ((line=inputFile.readLine()) != null)
        {
            List<WebElement> unfriend= driver.findElements(By.id("trust-account-types"));


            if (unfriend.size()>1)
            {
                System.out.println("When 1 is  ____" + unfriend.size());
                WebElement elementLocator = unfriend.get(2);
                actions.doubleClick(elementLocator).perform();

            }
            List<WebElement> png = driver.findElements(By.xpath("//a[@href='/Equity/Details?ContractCode=EQU.US.MMM']"));

            if (png.size()>1)
            {
                System.out.println("When png ____" + png.size());
                WebElement elementLocator = png.get(0);
                actions.doubleClick(elementLocator).perform();

            }


            if (!driver.getTitle().contains("Buy "))
            {   continue;
            }
           System.out.println("https://platform.easyequities.co.za/Equity/Details?ContractCode=EQU.US."+line);

            driver.findElement(By.id("CustomTradeValue")).sendKeys("0.5");
            driver.findElement(By.id("CustomTradeValue")).click();
            driver.findElement(By.id("recurringBtn")).click();

            Boolean isPresent = driver.findElements(By.cssSelector(".field-validation-error > span:nth-child(1)")).size() > 0;
            if (isPresent)
            {   continue;
            }
            driver.findElement(By.cssSelector(".col-md-12")).click();

            driver.findElement(By.id("cbTransactionFeeType_2")).click();
            driver.findElement(By.cssSelector("#FrequencyDay_chosen > .chosen-single > div")).click();
            driver.findElement(By.cssSelector(".active-result:nth-child(4)")).click();
            driver.findElement(By.id("ConfirmBankDetails")).click();
            driver.findElement(By.id("AcceptTsCs")).click();
            driver.findElement(By.cssSelector(".pull-right")).click();
            driver.findElement(By.cssSelector(".btn-left-margin")).click();


        }
        }

/**
 driver.navigate().to("https://platform.easyequities.co.za/RecurringInvestment");
 driver.findElement(By.cssSelector("tr:nth-child(1) .caret")).click();
 driver.findElement(By.linkText("CANCEL")).click();
 driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/button")).click();

        driver.findElement(By.cssSelector(".fa-bars")).click();
        driver.findElement(By.linkText("My Recurring Investments")).click();
        driver.findElement(By.cssSelector("tr:nth-child(1) .caret")).click();
        driver.findElement(By.linkText("EDIT")).click();
        driver.findElement(By.id("Amount")).clear();
        driver.findElement(By.id("Amount")).sendKeys("5.00");

        driver.findElement(By.id("ConfirmBankDetails")).click();
        driver.findElement(By.id("AcceptTsCs")).click();
        driver.findElement(By.id("Amount")).click();
        driver.findElement(By.cssSelector(".col-md-7 .radio:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".btn-left-margin")).click();


 **/}


