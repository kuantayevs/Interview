package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
    public AmazonPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;

    public void validateSearch(String searchQuery){
        searchBar.sendKeys(searchQuery + Keys.ENTER);
    }
}
