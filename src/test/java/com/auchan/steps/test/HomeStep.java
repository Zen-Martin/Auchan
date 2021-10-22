package com.auchan.steps.test;

import com.auchan.context.ScenarioContext;
import com.auchan.pageObjects.HomePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class HomeStep implements En {

    public HomeStep(
            HomePage homePage,
            ScenarioContext scenario
    ){

        Given("I am on the homePage", () -> {
            homePage.goToHomePage();
        });

        When("Scroll down to footer", () -> {
            homePage.scrollToFooter();
        });

        When("Click on *espace presse*", () -> {
            homePage.clickOnPressSpace();
        });

        Then("The link redirects to an address that cannot be found", () -> {
            Assert.assertEquals(homePage.verifyPressSpaceRedirection(),true);
        });

        When("Scroll down, click on the *filières responsables*", () -> {
            homePage.clickOnMajorAffiliate();
        });

        When("Open the menu *besoin d'aide*, click on *Foires aux questions*", () -> {
            homePage.selectHelpRequest();
        });

        When("Go to *Star War* page", () -> {
            homePage.selectStarWarItem();
        });

        When("On the header bar, Click on the icon *in drive*", () -> {
            homePage.clickOnIndrive();
        });

        Then("The page is no longer available", () -> {
            Assert.assertEquals(homePage.verifyStarWarsLink(),true);
        });

    }

}
