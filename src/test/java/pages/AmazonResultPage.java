package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonResultPage {
    public AmazonResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@data-index='1']//h2//a")
    WebElement firstItem;

    @FindBy(xpath = "//div[@data-index='1']//span[@class='a-price']/span[@class='a-offscreen']")
    WebElement firstItemPrice;

    public void clickFirstItem(){
        firstItem.click();
    }
    public double getPrice(){
        String priceText = firstItemPrice.getAttribute("innerHTML").substring(1).trim();
        double price = Double.parseDouble(priceText);
        return price;
    }
}
