package com.auchan.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HelpPage extends Page{

    @FindBy(css = "#navigation_menu > span")
    private WebElement rayon;

    @FindBy(css = "#navigation_menu_list li a")
    private List<WebElement> rayonOptions;

    private void clickOnNavBarItem(String elementNavigation){
        WebElement button = rayonOptions
                .stream()
                .filter( elt -> elt.getText().equals(elementNavigation))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Not element Found !"));


        get(button.getAttribute("href"));
        waitForLoadingPage();
    }

    public HelpPage(){}

    public void selectAuchanDrive(){
        clickOn(rayon);
        clickOnNavBarItem("Auchan Drive");
    }


}
