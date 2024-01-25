package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Purchase_Stepdefs {
    HomePage homePage=new HomePage();
    CartPage cartPage = new CartPage();
    int expectedPurchaseAmount = 0;


    @When("The user adds {string} product from {string} category")
    public void the_user_adds_product_from_category(String product, String category) {
        expectedPurchaseAmount += homePage.addProduct(product, category);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }
    @When("The user removes {string} chosen product from Cart Page")
    public void the_user_removes_chosen_product_from_cart_page(String removeProduct) {

        expectedPurchaseAmount -= cartPage.removeProduct(removeProduct);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }
    @When("The user places order and captures and lo amount")
    public void the_user_places_order_and_captures_and_lo_amount() {
        cartPage.finishPurchase_logAmount();

    }
    @Then("The user verifies purchase amount")
    public void the_user_verifies_purchase_amount() {
        cartPage.verifyPurchaseAmount(expectedPurchaseAmount);
    }

    @When("THE user adds following productions from related category to the Cart and return Home Page")
    public void theUserAddsFollowingProductionsFromRelatedCategoryToTheCartAndReturnHomePage(List<Map<String,String >> datatable) {
        System.out.println("datatable.size() = " + datatable.size());
        for (int i = 0; i < datatable.size(); i++) {
            System.out.println("i = " + i);
            System.out.println("datatable.get(i).values() = " + datatable.get(i).values());
            String [] dataArray=datatable.get(i).values().toArray(new String[i]);

            if(dataArray.length>=2){
                String category=dataArray[0];
                String product=dataArray[1];
                System.out.println("category = " + category);
                System.out.println("product = " + product);
                expectedPurchaseAmount += homePage.addProduct(product, category);
                System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
            }else {
                System.out.println("There is Not enugh element value");
            }
        }
    }

    @And("The user removes {string} chosen product from {string} Page")
    public void theUserRemovesChosenProductFromPage(String removeProduct, String menu) {
        expectedPurchaseAmount -= cartPage.removeProduct(removeProduct,menu);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }
}
