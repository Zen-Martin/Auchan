package com.auchan.steps.test;

import com.auchan.context.ScenarioContext;
import com.auchan.pageObjects.AffiliatePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class AffiliateStep implements En {

    public AffiliateStep(
            AffiliatePage affiliatePage,
            ScenarioContext scenario
    ){

        When("Click on *voir tous les produits*", () -> {
            affiliatePage.clickOnSeeAllProduct();
        });

        Then("A page displaying a message that the page is no longer available", () -> {
            Assert.assertEquals(affiliatePage.verifyAllProductRedirection(),true);
        });

    }
}
