package mock.pages;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import junit.framework.Assert;
import mock.baseclass.BaseClass;

public class GooglePage extends BaseClass {
	public GooglePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath  = "//*[@name='q']")
	private WebElement searchBox;

	public WebElement getSearchBox() {
		return searchBox;
	}


	public WebElement getAllGoogleResult() {
		return allGoogleResult;
	}


	public WebElement getGoogleSearchButton() {
		return googleSearchButton;
	}


	public WebElement getGoogleStaySignedOutButton() {
		return googleStaySignedOutButton;
	}
	
	@FindBy(xpath="//*[@id='center_col']")
	private WebElement allGoogleResult;
	
	@FindBy(xpath="//*[@id='APjFqb']/ancestor::div[@class='A8SBwf']/child::div/child::center/child::input[@value='Google Search']")
	private WebElement googleSearchButton;
	
	@FindBy(xpath="//*[text()='Stay signed out']")
	private WebElement googleStaySignedOutButton;
	
	@FindBy(xpath="//h3[text()='Amazon.in']")
	private WebElement firstAmazonLink;
	
	@FindBy(xpath="//span[text()='Amazon']")
	private WebElement firstAmazonSuggestion;
	
	@FindBy(xpath ="//span[@id='nav-link-accountList-nav-line-1']")
	private WebElement loginButton;
	
	@FindBy(xpath ="//*[@id='ap_email']")
	private WebElement userNameTextBox;
	
	@FindBy(xpath ="//span[@id='continue']")
	private WebElement loginContinueButton;
	
	@FindBy(xpath ="//*[@id='ap_password']")
	private WebElement passTextBox;
	
	@FindBy(xpath ="//*[@id='signInSubmit']")
	private WebElement signinButton;
	
	@FindBy(xpath ="//select[@id='searchDropdownBox']")
	private WebElement dropDownAll;
	
	@FindBy(xpath ="//input[@id='twotabsearchtextbox']")
	private WebElement searchBoxAmazon;
	
	@FindBy(xpath ="//input[@id='nav-search-submit-button']")
	private WebElement searchSumbitAmazon;
	
	@FindBy(xpath ="//*[@id='low-price']")
	private WebElement lowFilterField;
	
	@FindBy(xpath ="//input[@id='high-price']")
	private WebElement highFilterField;
	
	@FindBy(xpath ="//span[@id='a-autoid-1-announce']/preceding-sibling::input")
	private WebElement enterFilterButton;
	
	@FindBy(xpath ="//*[@class='a-price-whole']")
	private List<WebElement> searchListFirstPage;
	
	@FindBy(xpath ="//a[text()='1']")
	private WebElement pageOneButton;
	
	@FindBy(xpath ="//a[text()='2']")
	private WebElement searchPageTwoButton;
	
	@FindBy(xpath ="//span[text()='5.0']/parent::*/parent::*/parent::*/parent::*/child::*/child::h2/child::a/child::span")
	private List<WebElement> fiveStarProduct;
	
	@FindBy(xpath ="//div[@id='averageCustomerReviews_feature_div']/div/span/span[contains(@title,'5.0')]")
	private WebElement selectedLaptop;
	
	@FindBy(xpath ="//*[@id='add-to-wishlist-button-submit']")
	private WebElement wishListButton;
	
	@FindBy(xpath ="//input[@id='list-name']")
	private WebElement popupAddListTextBoxt;
	
	@FindBy(xpath ="//*[text()='Create List']/preceding-sibling::input")
	private WebElement popupCreatelistSumbit;
	
	@FindBy(xpath ="//a[contains(text(),'Wish')]/parent::span")
	private WebElement viewWishListButton;
	
	@FindBy(xpath ="//h2[@class='a-size-base']/a")
	private WebElement InListBucket;
	
	@FindBy(xpath ="//h4[@id='a-popover-header-9']")
	private WebElement popHeaderviewListClose;
	
	@FindBy(xpath ="//h4[@id='a-popover-header-9']/following-sibling::button")
	private WebElement popHeaderviewListCloseXbutton;
	
	
	
	
	
	
	

	
	
	
	public void searchTheAmazon() throws Exception {
		String fromExcell = readFromExcell("dataSheet",1,0);
		elementInsertValue(searchBox, fromExcell);
		try {
			
		elementClick(firstAmazonSuggestion);
	}
		catch (Exception e) {
    Robot rob = new Robot();
    rob.keyPress(KeyEvent.VK_ENTER);
    rob.keyRelease(KeyEvent.VK_ENTER);
	}
		
	}
	
	public void printAllResult() {
		List<WebElement> results = driver.findElements(By.tagName("h3"));
//		explicitWait(10).until(ExpectedConditions.invisibilityOfAllElements(results));
System.out.println(results.size());
for(int i=0;i<results.size();i++) {
	String textRes = results.get(i).getText();
	System.out.println(textRes);
}
	}
	public void userClicksAmazon() {
elementClick(firstAmazonLink);
		
	}
	
	public void userEnterUserNamePassword() throws IOException {
         elementClick(loginButton);
         explicitWait(10).until(ExpectedConditions.elementToBeClickable(userNameTextBox));
         elementInsertValue(userNameTextBox, readFromExcell("dataSheet",1,2));
         elementClick(loginContinueButton);
         explicitWait(10).until(ExpectedConditions.elementToBeClickable(passTextBox));
         elementInsertValue(passTextBox, readFromExcell("dataSheet",1,3));
         elementClick(signinButton);
         
	}
	
	public void userSelectElectronicsFromDropDown(){
		selectByVisibleText(dropDownAll, "Electronics");
		
	}
	
	public void userSearchsOnAmazon() throws IOException{
        elementInsertValue(searchBoxAmazon, readFromExcell("dataSheet",1,1));
		elementClick(searchSumbitAmazon);
	}
	public void userAppliesFilter() throws IOException {
		  elementInsertValue(lowFilterField, readFromExcell("dataSheet",1,4));
		  elementInsertValue(highFilterField, readFromExcell("dataSheet",1,5));
		  elementClick(enterFilterButton);
	}
	public void validateTheFilterResult() throws InterruptedException {
		Thread.sleep(5000);
		int lowerLimit = 30000;
        int upperLimit = 50000;
		List<String> allAmount = new LinkedList<String>();
		List<WebElement> firstPage = searchListFirstPage;
		for(int i = 0; i<firstPage.size();i++) {
			allAmount.add(firstPage.get(i).getText().replaceAll(",", ""));
			int intNum = Integer.parseInt(firstPage.get(i).getText().replaceAll(",", ""));
			if(intNum<=50000 && intNum>=30000) {
				System.out.print("inRange:"+intNum+" , ");
			} else{
				System.out.print("outOfRange:"+intNum+" , ");
				assertTrue("Filter is not working properly", false);
			}
		} 
		System.out.println(allAmount);
		System.out.println();
		
		elementClick(searchPageTwoButton);
		Thread.sleep(5000);
		List<String> allAmount2 = new LinkedList<String>();
		List<WebElement> firstPage2 = searchListFirstPage;
		System.out.println(allAmount2);
		for(int i = 0; i<firstPage2.size();i++) {
			allAmount2.add(firstPage2.get(i).getText().replaceAll(",", ""));
			
			int intNum = Integer.parseInt(firstPage2.get(i).getText().replaceAll(",.", ""));
			if(intNum<=50000 && intNum>=30000) {
				System.out.print("inRange:"+intNum+" , ");
			} else{
				System.out.print("OutofRange:"+intNum+" , ");
				assertTrue("Filter is not working properly", false);
			}
			
		} 

	}

	public void userPrintFiveStarRatingInTwoPage() throws InterruptedException{
		elementClick(pageOneButton);
		List<WebElement> fivestarItems = fiveStarProduct;
		System.out.println("list size page 1 size:"+fivestarItems.size()+"__"+fivestarItems);
		for (WebElement x : fivestarItems) {
            System.out.println(x.getText());
		}
		elementClick(searchPageTwoButton);
		Thread.sleep(5000);
		List<WebElement> fivestarItems2 = fiveStarProduct;
		System.out.println("list size page 2:"+fivestarItems2.size());
		for (WebElement x : fivestarItems2) {
            System.out.println(x.getText());}
		System.out.println();
		   
	}
	public void userAddingFirstproductToWishList() throws IOException {
//			elementClick(selectedLaptop);
		String selectedEle ="";
			for (WebElement x : fiveStarProduct) {
				if(!x.getText().contains("Refurbished") && !x.getText().contains("refurbished") ) {
					elementClick(x);
					selectedEle=selectedEle+x.getText();
					System.out.println(x.getText()); 
					System.out.println("true block");
					break;
				} {System.out.println("else block of refurbish");}
				
			}System.out.println();
			Set<String> allWin = driver.getWindowHandles();
			List<String> orderedWin = new ArrayList<String>(allWin);
			driver.switchTo().window(orderedWin.get(1));
			
			elementClick(wishListButton);
//			elementClick(wishListButton);
//			if(popHeaderviewListClose.isDisplayed()) { clickByJs(popHeaderviewListCloseXbutton );}
//			elementClick(wishListButton);
			elementClear(popupAddListTextBoxt);
			elementInsertValue(popupAddListTextBoxt, readFromExcell("dataSheet",1,6));
			elementClick(popupCreatelistSumbit);
	}
	public void userValidatingTheProductInTheWishList() {
		elementClick(viewWishListButton);
		boolean displayed = InListBucket.isDisplayed();
		assertTrue("validating the product in wishlist", displayed);
		


	}
	
	}
	
	
	
