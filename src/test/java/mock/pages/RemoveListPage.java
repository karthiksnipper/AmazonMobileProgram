package mock.pages;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveListPage extends GooglePage {
	public RemoveListPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath  = "//a[@id='overflow-menu-popover-trigger']")
	private WebElement moreButton;
	
	@FindBy(xpath  = "//a[@id='editYourList']")
	private WebElement moreManagerListButton;
	
	@FindBy(xpath  = "//div[@id='list-settings-blackout-outer']/following-sibling::span/span/span")
	private WebElement deleteListButton;
	
	@FindBy(xpath  = "//span[@id='list-delete-confirm']/span/input")
	private WebElement yesDeleteListButton;
	
	public void userDeleteExistingList() throws AWTException, InterruptedException {
		clickByJs(moreButton);
		clickByJs(moreManagerListButton);
		elementClick(deleteListButton);
//		clickByJs(deleteListButton);
		
		elementClick(yesDeleteListButton);
		    robotObj().keyPress(KeyEvent.VK_ENTER);
		    robotObj().keyRelease(KeyEvent.VK_ENTER);
		
		
			actionsObj().doubleClick(yesDeleteListButton).perform();
			robotObj().keyPress(KeyEvent.VK_ENTER);
			robotObj().keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
			robotObj().keyPress(KeyEvent.VK_ENTER);
			robotObj().keyRelease(KeyEvent.VK_ENTER);
			}
		
	}
	

