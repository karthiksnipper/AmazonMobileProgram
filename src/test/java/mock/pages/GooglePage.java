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

import org.apache.logging.log4j.*;
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

//ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF.

public class GooglePage extends BaseClass {
    public String valueToCarry;
	private static final Logger logger = LogManager.getLogger(GooglePage.class);
	
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
		logger.info("___________searchTheAmazon______");
		String fromExcell = readFromExcell("dataSheet",1,0);
		logger.info("data fetched from cell");
		elementInsertValue(searchBox, fromExcell);
		logger.info("passing text to webelement from excell");
		try {
			
		elementClick(firstAmazonSuggestion);
		logger.info("try-block element Click");
	}
		catch (Exception e) {
    Robot rob = new Robot();
    logger.info("Catch-block robot class instanciated");
    rob.keyPress(KeyEvent.VK_ENTER);
    rob.keyRelease(KeyEvent.VK_ENTER);
    logger.info("Catch-block robot key_ENTER");
	}
		
	}
	
	public void printAllResult() {
		logger.info("____________printAllResult_____________");
		List<WebElement> results = driver.findElements(By.tagName("h3"));
		logger.info("List<webelement> stored in result of amazon search");
//		explicitWait(10).until(ExpectedConditions.invisibilityOfAllElements(results));
System.out.println(results.size());
for(int i=0;i<results.size();i++) {
	String textRes = results.get(i).getText();
	System.out.println(textRes);
	logger.info("printing amazon result="+textRes);
}
    logger.info("printed amazon result navigated google search ");
	}
	
	public void userClicksAmazon() {
		logger.info("_____________userClicksAmazon___________");
elementClick(firstAmazonLink);
        logger.info("element clicks on amazon link");
		
	}
	
	public void userEnterUserNamePassword() throws IOException {
		logger.info("_____________userEnterUserNamePassword____________"); 
		 elementClick(loginButton);
		logger.info("element click login button"); 		 
         explicitWait(10).until(ExpectedConditions.elementToBeClickable(userNameTextBox));
        logger.info("explicit wait applied to elementToBeClickable"); 
         elementInsertValue(userNameTextBox, readFromExcell("dataSheet",1,2));
        logger.info(readFromExcell("dataSheet",1,2)+"passing text to element from excell"); 
         elementClick(loginContinueButton);
        logger.info("element click loginContinueButton");  
         explicitWait(10).until(ExpectedConditions.elementToBeClickable(passTextBox));
        logger.info("explicit wait till element to be clickable element textbox");  
         elementInsertValue(passTextBox, readFromExcell("dataSheet",1,3));
        logger.info("password text passed from excel by element sendkeys"); 
         elementClick(signinButton);
        logger.info("Clicking on sign button by Webelement");   
	}
	
	public void userSelectElectronicsFromDropDown(){
		 logger.info("________Entering userSelectElectronicsFromDropDown_________");
		selectByVisibleText(dropDownAll, "Electronics");
		 logger.info("Select Dropdown by visible text ");	
		
	}
	
	public void userSearchsOnAmazon() throws IOException{
	    logger.info("________Entering userSearchsOnAmazon_______");  
		elementInsertValue(searchBoxAmazon, readFromExcell("dataSheet",1,1));
        logger.info("inserted Dell in amazon search box by Webelement");
		elementClick(searchSumbitAmazon);
		logger.info("clicked search sumbit button by webelement");
	}
	public void userAppliesFilter() throws IOException {
		 logger.info("________Enters userAppliesFilter_______");  
		  elementInsertValue(lowFilterField, readFromExcell("dataSheet",1,4));
		 logger.info("inserted lower range filter by Webelement");  
		  elementInsertValue(highFilterField, readFromExcell("dataSheet",1,5));
		 logger.info("inserted Higher range filter by Webelement");    
		  elementClick(enterFilterButton);
         logger.info("clicked filter sumbit button");  	  
	}
	public void validateTheFilterResult() throws InterruptedException {
		logger.info("________Enters validateTheFilterResult_______");
		Thread.sleep(5000);
		logger.info("waited for 5000ms by threads sleep");
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
				logger.error("failed: filter is not working as per expected behaviour value="+intNum);
				assertTrue("Filter is not working properly", false);
			}
		} 
		logger.info("success: filter_1 function working as per expected condition");
		System.out.println(allAmount);
		logger.info("printing product price shown on page_1");
		System.out.println();
		
		elementClick(searchPageTwoButton);
		logger.info("clicked by element search page_2 button");
		 elementClick(enterFilterButton);
         logger.info("clicked filter sumbit button");
		Thread.sleep(5000);
		logger.info("waited for 5000ms by threads sleep");
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
				logger.error("failed: filter is not working as per expected behaviour value="+intNum);
				assertTrue("Filter is not working properly", false);
			}
			
		} 
		logger.info("success: filter function is working properly");
	}

	public void userPrintFiveStarRatingInTwoPage() throws InterruptedException{
		logger.info("________Enters userPrintFiveStarRatingInTwoPage________");
		elementClick(pageOneButton);
		logger.info("Clicked by element pagebutton one");		
		List<WebElement> fivestarItems = fiveStarProduct;
		System.out.println("list size page 1 size:"+fivestarItems.size()+"__"+fivestarItems);
		logger.info("printed count of five star rated product on page_1");
		for (WebElement x : fivestarItems) {
            System.out.println(x.getText());
    		logger.info("printing 5star rate product"+x.getText());
		}
		elementClick(searchPageTwoButton);
		logger.info("clicked by element page_2 button");
		Thread.sleep(5000);
		logger.info("waited for 5000ms thread sleep");
		List<WebElement> fivestarItems2 = fiveStarProduct;
		for (WebElement x : fivestarItems2) {
            System.out.println(x.getText());
            logger.info("printing 5star rate product"+x.getText());}
		
		System.out.println();
		   
	}
	public void userAddingFirstproductToWishList() throws IOException {
		logger.info("_______Enters userAddingFirstproductToWishList _______");
//			elementClick(selectedLaptop);
		String selectedEle ="";
			for (WebElement x : fiveStarProduct) {
				if(!x.getText().contains("Refurbished") && !x.getText().contains("refurbished") ) {
					elementClick(x);
					logger.info("clicked element which isn't refurbished through iteration");
					selectedEle=selectedEle+x.getText();
					System.out.println(x.getText()); 
					logger.info("true block gets the webelement text ");
					break;
				} else{System.out.println("else block of refurbish");
				logger.info("else block ");}
				
			}System.out.println();
			Set<String> allWin = driver.getWindowHandles();
			List<String> orderedWin = new ArrayList<String>(allWin);
			driver.switchTo().window(orderedWin.get(1));
			logger.info("driver switched over to next browser tab");
			elementClick(wishListButton);
			logger.info("clicked by element wish list button");
//			elementClick(wishListButton);
//			if(popHeaderviewListClose.isDisplayed()) { clickByJs(popHeaderviewListCloseXbutton );}
//			elementClick(wishListButton);
			elementClear(popupAddListTextBoxt);
			logger.info("clearing text box");
			elementInsertValue(popupAddListTextBoxt, readFromExcell("dataSheet",1,6));
			logger.info("inserted the value by webelement");
			elementClick(popupCreatelistSumbit);
			logger.info("clicked on sumbit button popupCreatelistSumbit");
	}
	public void userValidatingTheProductInTheWishList() {
		logger.info("________Enters userValidatingTheProductInTheWishList________");
		elementClick(viewWishListButton);
		logger.info("clicked by element viewWishListButton");
		boolean displayed = InListBucket.isDisplayed();
		if(displayed) {
			assertTrue("validating the product in wishlist", displayed);
			logger.info("success: wish list is work as per the expected conditions");}
		else{
			logger.error("wish list is not working as per expected");
			assertTrue("failed: validating the product in wishlist", displayed);
		
		}
		


	}
	
	}
	
	
	
