package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductPage {
    public AmazonProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "newBuyBoxPrice")
    WebElement price;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    public double getPrice(){
        return Double.parseDouble(price.getText().trim().substring(1));
    }
    public void clickAddToCart(){
        addToCartButton.click();
    }
}
