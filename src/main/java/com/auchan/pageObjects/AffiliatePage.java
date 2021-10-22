package com.auchan.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AffiliatePage extends Page{

    @FindBy(css = "#comp_0000LQEQ > section.filieres--edito.row > a")
    private WebElement seeAllProduct;

    public AffiliatePage(){}

    public void clickOnSeeAllProduct(){
        get(seeAllProduct.getAttribute("href"));
    }

    public boolean verifyAllProductRedirection(){
        return !driver.getTitle().equals("Not Found");
    }


}
