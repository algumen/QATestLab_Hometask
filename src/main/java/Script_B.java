import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;


public class Script_B {
    public static void main(String[] args) {
        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("webinar.test@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement submitLoginBtn = driver.findElement(By.name("submitLogin"));
        submitLoginBtn.click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
        }

        WebElement profileImg = driver.findElement(By.xpath("//img[(@class='imgm img-thumbnail')]"));
        profileImg.click();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
        }

        WebElement logoutBtn = driver.findElement(By.id("header_logout"));
        logoutBtn.click();

        driver.quit();

    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}

