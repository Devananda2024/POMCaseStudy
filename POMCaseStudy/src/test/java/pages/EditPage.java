package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {
	@FindBy (xpath = "//a[contains(text(),  'Edit Article')]")
	WebElement Edit;
	
	@FindBy (xpath = "//input[@name= 'title']")
	WebElement arcTitle;
	
	@FindBy (xpath = "//button[@type= 'submit']")
	WebElement arcUpdate;
	
	
	public EditPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void Editarticle()
	{
		Edit.click();
	}
	
	public void Arttitle(String strtitle)
	{
		arcTitle.clear();
		arcTitle.sendKeys(strtitle);
		arcUpdate.click();
	}

}
