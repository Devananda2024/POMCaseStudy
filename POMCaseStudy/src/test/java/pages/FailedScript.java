package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FailedScript {
	
	@FindBy (xpath = "//a[@class='nav-link 1']")
	WebElement NewArticle;
	
	public FailedScript (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
public void failedsce()
{
	NewArticle.click();
}
}
