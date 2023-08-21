package mock.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import io.cucumber.java.en.*;
import mock.manager.ObjectManager;

public class AmazonStepDefintions {
	ObjectManager obj = new ObjectManager();

@Given("Launch the browser")
public void launch_the_browser() {
    // Write code here that turns the phrase above into concrete actions
}



@When("user Search amazon on searchbar")
public void user_Search_amazon_on_searchbar() throws Exception {
obj.getKartPageInstance().searchTheAmazon();

}
@When("user Print list of search result")
public void user_Print_list_of_search_result() {
	obj.getKartPageInstance().printAllResult();
}
@When("user Clicks on amazon application")
public void user_Clicks_on_amazon_application() {
obj.getKartPageInstance().userClicksAmazon();
}
@When("user Enter valid credentials")
public void user_Enter_valid_credentials() throws IOException {
obj.getKartPageInstance().userEnterUserNamePassword();
}
@When("user selects Electronic button through all button in searchbar")
public void user_selects_Electronic_button_through_all_button_in_searchbar() {
obj.getKartPageInstance().userSelectElectronicsFromDropDown();
}
@When("user Enters dell computers")
public void user_Enters_dell_computers() throws IOException {
 obj.getKartPageInstance().userSearchsOnAmazon();
}

@When("user Applies filter range rs30000 to rs50000")
public void user_Applies_filter_range_rs30000_to_rs50000()throws IOException {
obj.getKartPageInstance().userAppliesFilter();
}

@Then("user Validates the result first two pages in the range of rs30000 to rs50000")
public void user_Validates_the_result_first_two_pages_in_the_range_of_rs30000_to_rs50000() throws IOException, InterruptedException{
obj.getKartPageInstance().validateTheFilterResult();
}

@Then("user Prints rating5 rating from result on two pages")
public void user_Prints_rating5_rating_from_result_on_two_pages() throws InterruptedException{
obj.getKartPageInstance().userPrintFiveStarRatingInTwoPage();
}

@When("user Add the the selected rating5 product in wish list")
public void user_Add_the_the_selected_rating5_product_in_wish_list() throws IOException {
obj.getKartPageInstance().userAddingFirstproductToWishList();
}
@Then("user validating the product added in the wish list")
public void user_validating_the_product_added_in_the_wish_list() throws AWTException, InterruptedException {
obj.getKartPageInstance().userValidatingTheProductInTheWishList();
obj.getRemoveListPageInstance().userDeleteExistingList();
}



}
