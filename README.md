import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class AccountCreationTest
{
    public static WebDriver webdriver = new ChromeDriver();
    private final JavascriptExecutor js = (JavascriptExecutor) webdriver;

    @Test
    public void setup() throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webdriver.manage().deleteAllCookies();
        webdriver.get("https://www.demoblaze.com/");
        webdriver.manage().window().maximize();
//        //webdriver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[8]")).click();
//
//        //waitForElementToBeVisibleViaXPath("//*[@id=\"sign-username\"]");
//
//        //SignUp code
//        //webdriver.findElement(By.xpath("//*[@id=\"sign-username\"]")).clear();
//        //webdriver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys("KapudiMora");
//        //waitForElementToBeVisibleViaXPath("//*[@id=\"sign-password\"]");
//
//        webdriver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys("PKmm21#$");
//        waitForElementToBeVisibleViaXPath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
//        webdriver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
//       // Alert alert = webdriver.switchTo().alert();
//
//       // alert.accept();
//     //   waitForElementToBeVisibleViaXPath("//*[@id=\"signInModal\"]");
//
//        acceptDialogBox();
        //lOGIN bUTTON
        waitForElementToBeVisibleViaXPath("//*[@id=\"login2\"]");
        webdriver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
        TakeScreenShot(webdriver,"login");
        waitForElementToBeVisibleViaXPath("//*[@id=\"loginusername\"]");
        webdriver.findElement(By.xpath("//*[@id=\"loginusername\"]")).clear();
        webdriver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("KapudiMora");

        waitForElementToBeVisibleViaXPath("//*[@id=\"loginpassword\"]");
        webdriver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("PKmm21#$");
        TakeScreenShot(webdriver,"Credentials");
        webdriver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
        TakeScreenShot(webdriver,"Click login button");
        acceptDialogBox();

        //Loop to select the cellphone twice
        for (int i = 0; i < 2; i++)
        {
            if (i == 0)
            {

                waitForElementToBeVisibleViaCssSelector("#itemc");
                webdriver.findElement(By.cssSelector("#itemc")).click();
                TakeScreenShot(webdriver,"Nexus6 phone");

                waitForElementToBeVisibleViaCssSelector("#tbodyid > div:nth-child(3) > div > a > img");            //Items Selection
                //Click cellphone
                webdriver.findElement(By.cssSelector("#tbodyid > div:nth-child(3) > div > a > img")).click();
                TakeScreenShot(webdriver,"Click phone");
                waitForElementToBeVisibleViaCssSelector("#tbodyid > div.row > div > a");          //Items Selection
                //Select the cellphone Item(nexus 6)
                webdriver.findElement(By.cssSelector("#tbodyid > div.row > div > a")).click();
                TakeScreenShot(webdriver,"select Nexus 6 phone");
                acceptDialogBox();


            }
            else
            {
                waitForElementToBeVisibleViaCssSelector("#tbodyid > div.row > div > a");          //Items Selection
                //Select the cellphone Item(nexus 6)
                webdriver.findElement(By.cssSelector("#tbodyid > div.row > div > a")).click();
                TakeScreenShot(webdriver,"select Nexus 6 phone");
                acceptDialogBox();

            }
        }

        webdriver.findElement(By.cssSelector("#navbarExample > ul > li.nav-item.active > a")).click();
        TakeScreenShot(webdriver,"Home");
        Thread.sleep(500);
        //Select Monitor category
        waitForElementToBeVisibleViaXPath("//*[@id=\"itemc\"]");
//        webdriver.findElement(By.xpath("//*[@id=\"itemc\"]")).click();
        webdriver.findElement(By.xpath("//*[@id=\"next2\"]")).click();
        // select asus monitor
        Thread.sleep(2000);
        waitForElementToBeVisibleViaXPath("//*[@id=\"tbodyid\"]/div[5]/div/div/h4");
        webdriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[5]/div/div/h4")).click();
        //Select add to cart
        waitForElementToBeVisibleViaXPath("//*[@id=\"tbodyid\"]/div[2]/div/a");
        webdriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
        acceptDialogBox();

        // view cart
        waitForElementToBeVisibleViaXPath("//*[@id=\"navbarExample\"]/ul/li[4]/a");
        webdriver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a")).click();
        Thread.sleep(5000);

        // place order
        waitForElementToBeVisibleViaXPath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
        webdriver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
        waitForElementToBeVisibleViaXPath("//*[@id=\"name\"]");
        webdriver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Kapudi");
        waitForElementToBeVisibleViaXPath("//*[@id=\"country\"]");
        webdriver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("SA");
        waitForElementToBeVisibleViaXPath("//*[@id=\"city\"]");
        webdriver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("JHB");
        waitForElementToBeVisibleViaXPath("//*[@id=\"card\"]");
        webdriver.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys("4700563214332569");
        waitForElementToBeVisibleViaXPath("//*[@id=\"month\"]");
        webdriver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys("09");
        waitForElementToBeVisibleViaXPath("//*[@id=\"year\"]");
        webdriver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys("2024");
        // purchase button
        waitForElementToBeVisibleViaXPath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
        webdriver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
        // confirm purchase
        Thread.sleep(2000);
        waitForElementToBeVisibleViaXPath("/html/body/div[10]/div[7]/div/button");
        webdriver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
        // logout
        Thread.sleep(2000);
        waitForElementToBeVisibleViaXPath("//*[@id=\"logout2\"]");
        webdriver.findElement(By.xpath("//*[@id=\"logout2\"]")).click();
    }

    boolean isDialogPresent(WebDriver driver)
    {
        Alert alert = ExpectedConditions.alertIsPresent().apply(driver);
        return (alert != null);
    }

    public void waitForElementToBeVisibleViaXPath(String elementXpath)
    {

        WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(1000));
        WebElement webElementViaXPath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));


    }

    public void waitForElementToBeVisibleViaCssSelector(String elementSelector)
    {
        WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(1000));
        WebElement webElementCssSelector = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementSelector)));
    }

    private void acceptDialogBox() throws Exception
    {
        Thread.sleep(2000);
        if (isDialogPresent(webdriver))
        {
            try
            {
                // Check the presence of alert
                Alert alert = webdriver.switchTo().alert();


                // if present consume the alert
                alert.accept();
            }
            catch (NoAlertPresentException ex)
            {
                //code to do if not exist.
                throw new RuntimeException("pop-up does not exist " + ex.getMessage());
            }
        }
    }
      //Create report in form of screenshots
    private void TakeScreenShot(WebDriver driver,String AutomationScreenshotsNames) throws IOException {
        File F=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(F.toPath(), new File("C:\\Temp\\Test Reports"+"\\"+ UUID.randomUUID().toString().substring(0,5) +AutomationScreenshotsNames
        +".jpeg").toPath());
    }
}
