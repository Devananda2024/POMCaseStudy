package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePage {
	
	@FindBy (xpath = "//button[contains(text(),  ' Delete Article')]")
	WebElement delete;
	
	
	public DeletePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void deleteArc() {
		
		delete.click();	
	}

}
