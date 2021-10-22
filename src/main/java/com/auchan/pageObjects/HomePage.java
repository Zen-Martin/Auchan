package com.auchan.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {

    @FindBy(id = "onetrust-reject-all-handler")
    private WebElement cookieOption;

    @FindBy(linkText = "Espace presse")
    private WebElement pressSpace;

    @FindBy(css = "div.pre-header--select-sign > a:nth-child(2)")
    private WebElement drive;

    @FindBy(linkText = "Star Wars")
    private WebElement starWarsItem;

    @FindBy(xpath = "//a[contains(text(),'filières responsables')]")
    private WebElement majorAffiliation;

    @FindBy(css = "#navigation > ul li a")
    private List<WebElement> NavBarOption;

    @FindBy(css = "div.pre-header--right-nav > label > span:nth-child(2)")
    private WebElement help;

    @FindBy(css = "div > a.faq.bb1 > span:nth-child(2)")
    private WebElement request;

    @FindBy(css = "div.content > div > div > p")
    private WebElement pageAccess;

    private String driveURI = config.getEnvironment()+"courses";

    public HomePage() {
    }

    private void handleCookie(){
      shortUntil(visibilityOf(cookieOption));
      clickOn(cookieOption);
    }

    public void goToHomePage(){
        get(config.getEnvironment());
        if(getCookieHandled()==0)
        {
            handleCookie();
            setCookieHandled(1);
        }
    }

    private void clickOnNavBarItem(String elementNavigation){
        WebElement button = NavBarOption
                .stream()
                .filter( elt -> elt.getText().equals(elementNavigation))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Not element Found !"));

        clickOn(button);
        waitForLoadingPage();
    }

    public void scrollToFooter(){
        shortUntil(visibilityOf(pressSpace));
        scroll(pressSpace.getLocation().getY()+20);
    }

    private void goToDefaultTab(){
        switchOnTab(0);
        driver.switchTo().defaultContent();
    }

    public void clickOnPressSpace(){
        clickOn(pressSpace);
        switchOnTab(1);
        waitForLoadingPage();
        driver.close();
    }

    public void clickOnMajorAffiliate(){
        clickOn(majorAffiliation);
        waitForLoadingPage();
    }

    public void selectHelpRequest(){
        clickOn(help);
        shortUntil(visibilityOf(request));
        clickOn(request);
        waitForLoadingPage();
    }

    public void selectStarWarItem(){
        clickOnNavBarItem("Jouets, Jeux vidéo");
        clickOnNavBarItem("Jouets");
        clickOnNavBarItem("Les héros préférés");
        shortUntil(visibilityOf(starWarsItem));
        get(starWarsItem.getAttribute("href"));
    }

    private void switchOnTab(int tabNumber){
        ArrayList<String> Tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(Tab.get(tabNumber));
    }

    private void openLinkOnNewTab(WebElement element){
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        element.sendKeys(selectLinkOpeninNewTab);
    }

    public void clickOnIndrive(){
        openLinkOnNewTab(drive);
        switchOnTab(1);
        waitForLoadingPage();
        driver.switchTo().defaultContent();
        overPassTutorial();
    }

    private void overPassTutorial(){
        driver.switchTo().defaultContent();
        action.moveByOffset(0,0)
                .click()
                .build().perform();
    }

    public boolean verifyPressSpaceRedirection(){
        goToDefaultTab();
        return verifyLink(pressSpace);
    }

    public boolean verifyStarWarsLink(){
        return !pageAccess.getText().contains("La page que vous cherchez n'est plus disponible");
    }

}
