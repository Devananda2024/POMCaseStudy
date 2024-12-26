package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArticle {
	
	@FindBy (xpath = "(//i[@class = 'ion-compose']) [2]")
	WebElement NewArticle;
		
	@FindBy (xpath = "//input[@name= 'title']")
	WebElement arcTitle;
	
	@FindBy (xpath = "//input[@name= 'description']")
	WebElement arcDesc;
	
	@FindBy (xpath = "//textarea[@name= 'body']")
	WebElement arcBody;
	
	@FindBy (xpath = "//input[@name = 'tags']")
	WebElement arcTag;
	
	@FindBy (xpath = "//button[@class = 'btn btn-lg pull-xs-right btn-primary']")
	WebElement publish;
	
	
	public NewArticle (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void NewArticle()
	{
		NewArticle.click();
	}
	
	public void CreateArticle(String strtitle, String strDesc, String strbody, String strTag)
	{
		arcTitle.sendKeys(strtitle);
		arcDesc.sendKeys(strDesc);
		arcBody.sendKeys(strbody);
		arcTag.sendKeys(strTag);
		publish.click();
	}
}
