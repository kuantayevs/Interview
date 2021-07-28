package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCartPage {
    public AmazonCartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='hlb-subcart']//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")
    WebElement price;

    public double getPrice(){
        return Double.parseDouble(price.getText().trim().substring(1));
    }
}
