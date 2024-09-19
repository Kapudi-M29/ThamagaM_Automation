import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class AccountCreationTest {
    public static WebDriver webdriver = new ChromeDriver();

    @Test
    public void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webdriver.get("https://www.demoblaze.com/");

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

        waitForElementToBeVisibleViaXPath("//*[@id=\"loginusername\"]");
        webdriver.findElement(By.xpath("//*[@id=\"loginusername\"]")).clear();
        webdriver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("KapudiMora");

        waitForElementToBeVisibleViaXPath("//*[@id=\"loginpassword\"]");
        webdriver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("PKmm21#$");
        webdriver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
        acceptDialogBox();

        //Loop to select the cellphone twice
        for (int i = 0; i < 2; i++) {
            if (i == 0) {

                waitForElementToBeVisibleViaCssSelector("#itemc");
                webdriver.findElement(By.cssSelector("#itemc")).click();

                waitForElementToBeVisibleViaCssSelector("#tbodyid > div:nth-child(3) > div > a > img");            //Items Selection
                //Click cellphone
                webdriver.findElement(By.cssSelector("#tbodyid > div:nth-child(3) > div > a > img")).click();
                waitForElementToBeVisibleViaCssSelector("#tbodyid > div.row > div > a");          //Items Selection
                //Select the cellphone Item(nexus 6)
                webdriver.findElement(By.cssSelector("#tbodyid > div.row > div > a")).click();
                acceptDialogBox();
            } else {
                waitForElementToBeVisibleViaCssSelector("#tbodyid > div.row > div > a");          //Items Selection
                //Select the cellphone Item(nexus 6)
                webdriver.findElement(By.cssSelector("#tbodyid > div.row > div > a")).click();
                Thread.sleep(2000);
                if (isDialogPresent(webdriver)) {

                    try {
                        // Check the presence of alert
                        Alert alert = webdriver.switchTo().alert();

                        // if present consume the alert
                        alert.accept();

                        if (i == 1) {
                            //Select the Cart
                            waitForElementToBeVisibleViaXPath("//*[@id=\"tbodyid\"]/div[2]/div/a");
                            webdriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
                            break;
                        }
                    } catch (NoAlertPresentException ex) {
                        //code to do if not exist.
                        throw new RuntimeException("pop-up does not exist " + ex.getMessage());
                    }
                }

            }


        }

        acceptDialogBox();
        webdriver.findElement(By.cssSelector("#navbarExample > ul > li.nav-item.active > a")).click();
        Thread.sleep(500);
        //Select Monitor category
        waitForElementToBeVisibleViaXPath("//*[@id=\"itemc\"]");
        webdriver.findElement(By.xpath("//*[@id=\"itemc\"]")).click();
        // select asus monitor
        waitForElementToBeVisibleViaXPath("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a");
        webdriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")).click();
        //Select add to cart
        waitForElementToBeVisibleViaXPath("//*[@id=\"tbodyid\"]/div[2]/div/a");
        webdriver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
        acceptDialogBox();

        // view cart
        waitForElementToBeVisibleViaXPath("//*[@id=\"navbarExample\"]/ul/li[4]/a");
        webdriver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a")).click();
    }

    boolean isDialogPresent(WebDriver driver) {
        Alert alert = ExpectedConditions.alertIsPresent().apply(driver);
        return (alert != null);
    }

    public void waitForElementToBeVisibleViaXPath(String elementXpath) {

        WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(59));
        WebElement webElementViaXPath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));


    }

    public void waitForElementToBeVisibleViaCssSelector(String elementSelector) {
        WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(59));
        WebElement webElementCssSelector = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementSelector)));
    }

    private void acceptDialogBox() throws Exception {
        Thread.sleep(2000);
        if (isDialogPresent(webdriver)) {

            try {
                // Check the presence of alert
                Alert alert = webdriver.switchTo().alert();

                // if present consume the alert
                alert.accept();
            } catch (NoAlertPresentException ex) {
                //code to do if not exist.
                throw new RuntimeException("pop-up does not exist " + ex.getMessage());
            }
        }
    }
}
// @Test
//    void signUp() throws InterruptedException {
//        //webdriver.wait(5000);
//     webdriver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[8]")).click();webdriver.findElement(By.xpath("/htm/html/body`/nav/div[1]/ul/li[8]l/html/body/nav/div[1]/ul/li[8]/body/nav/div[1]/ul/li[8]")).click();
//        System.out.println(webdriver.getTitle());
//
//
//
//
