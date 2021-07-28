package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AmazonCartPage;
import pages.AmazonPage;
import pages.AmazonProductPage;
import pages.AmazonResultPage;

public class AmazonPageTest {

    WebDriver driver;
    AmazonPage amazonPage;
    AmazonResultPage amazonResultPage;
    AmazonProductPage amazonProductPage;
    AmazonCartPage amazonCartPage;

    double expectedPrice;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        amazonPage = new AmazonPage(driver);
        amazonResultPage = new AmazonResultPage(driver);
        amazonProductPage = new AmazonProductPage(driver);
        amazonCartPage = new AmazonCartPage(driver);
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test1(){
        amazonPage.validateSearch("qa testing for beginners");
        expectedPrice = amazonResultPage.getPrice();
        amazonResultPage.clickFirstItem();
        Assert.assertEquals(amazonProductPage.getPrice(), expectedPrice);
    }
    @Test(dependsOnMethods = "test1")
    public void test2(){
        amazonProductPage.clickAddToCart();
        Assert.assertEquals(amazonCartPage.getPrice(), expectedPrice);
    }


}
