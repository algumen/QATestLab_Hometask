import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Script_B {
    public static void main(String[] args) {
        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement titleSubMenu,titleSubMenu_new;
        String titleSubMenuText,titleSubMenuNewTextText;


        try {Thread.sleep(1000);}
        catch (InterruptedException e) {e.printStackTrace();}

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("webinar.test@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Xcg7299bnSmMuRLp9ITw");

        try {Thread.sleep(1000);}
        catch (InterruptedException e) {e.printStackTrace();}

        WebElement submitLoginBtn = driver.findElement(By.name("submitLogin"));
        submitLoginBtn.click();


//        DASHBOARD
    checkLeftSideMenu(driver, "//li[@id='tab-AdminDashboard']", "/html/body/div[1]/div[2]/div[1]/div/h2");

//        ORDERS
    checkLeftSideMenu(driver, "//li[@id='subtab-AdminParentOrders']", "/html/body/div[1]/div[2]/div[1]/div/h2");



//        CATALOG
        try {Thread.sleep(1000);}
        catch (InterruptedException e) {e.printStackTrace();}

        WebElement catalogBtn = driver.findElement(By.xpath("//*[@id=\"subtab-AdminCatalog\"]/a"));
        catalogBtn.click();

        try {Thread.sleep(2000);}
        catch (InterruptedException e) {e.printStackTrace();}

        titleSubMenu = driver.findElement(By.xpath("//*[@id=\"main-div\"]/div[1]/h2"));
        titleSubMenuText = titleSubMenu.getText();
        System.out.println(titleSubMenuText);

        driver.navigate().refresh();

        try {Thread.sleep(1000);}
        catch (InterruptedException e) {e.printStackTrace();}

        titleSubMenu_new = driver.findElement(By.xpath("//*[@id=\"main-div\"]/div[1]/h2"));
        titleSubMenuNewTextText = titleSubMenu_new.getText();

        if (titleSubMenuNewTextText.equals(titleSubMenuText)) {
            System.out.println(titleSubMenuText + "   is equial  " + titleSubMenuNewTextText);
        } else {System.out.println(titleSubMenuText + "   is NOT equial   " + titleSubMenuNewTextText);}

//        CUSTOMERS
//        try {Thread.sleep(1000);}
//        catch (InterruptedException e) {e.printStackTrace();}
//
//        WebElement customersBtn = driver.findElement(By.xpath("//*[@id=\"subtab-AdminParentCustomer\"]/a/span"));
//        customersBtn.click();
//
//        try {Thread.sleep(2000);}
//        catch (InterruptedException e) {e.printStackTrace();}
//
//        titleSubMenu = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/h2"));
//        titleSubMenuText = titleSubMenu.getText();
//        System.out.println(titleSubMenuText);
//
//        driver.navigate().refresh();
//
//        try {Thread.sleep(1000);}
//        catch (InterruptedException e) {e.printStackTrace();}
//
//        titleSubMenu_new = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/h2"));
//        titleSubMenuNewTextText = titleSubMenu_new.getText();
//
//        if (titleSubMenuNewTextText.equals(titleSubMenuText)) {
//            System.out.println(titleSubMenuText + "   is equial  " + titleSubMenuNewTextText);
//        } else {System.out.println(titleSubMenuText + "   is NOT equial   " + titleSubMenuNewTextText);}



        try {Thread.sleep(1000);}
        catch (InterruptedException e) {e.printStackTrace();}

        driver.quit();

    }


    public static void checkLeftSideMenu(WebDriver driver, String menuButtonLocator, String titleLocator) {
        try {Thread.sleep(1000);}
        catch (InterruptedException e) {e.printStackTrace();}

        WebElement dashBoardBtn = driver.findElement(By.xpath(menuButtonLocator));
        dashBoardBtn.click();

        try {Thread.sleep(1000);}
        catch (InterruptedException e) {e.printStackTrace();}

        WebElement titleSubMenu = driver.findElement(By.xpath(titleLocator));
        String titleSubMenuText = titleSubMenu.getText();
        System.out.println(titleSubMenuText);

        driver.navigate().refresh();

        try {Thread.sleep(1000);}
        catch (InterruptedException e) {e.printStackTrace();}

        WebElement titleSubMenu_new = driver.findElement(By.xpath(titleLocator));
        String titleSubMenuNewTextText = titleSubMenu_new.getText();

        if (titleSubMenuNewTextText.equals(titleSubMenuText)) {
            System.out.println(titleSubMenuText + "   is equial  " + titleSubMenuNewTextText + "  after page refresh");
        } else {System.out.println(titleSubMenuText + "   is NOT equial   " + titleSubMenuNewTextText);}
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}

