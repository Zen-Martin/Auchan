package com.auchan.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.ArrayList;

public class CoursePage extends Page{

    @FindBy(css = "div > div:nth-child(2) > div.footer-legal__copyright")
    private WebElement copyRight;

    @FindBy(xpath = "//settings-ui")
    private WebElement clearCaches;

    private String text = "";

    private void switchOnTab(int tabNumber){
        ArrayList<String> Tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(Tab.get(tabNumber));
    }

    public void deleteCaches(){
        driver.manage().deleteAllCookies();
        get("chrome://settings/clearBrowserData");
        clearCaches.sendKeys(Keys.ENTER);
        setCookieHandled(0);
    }

    private void goToDefaultTab(){
        deleteCaches();
        driver.close();
        switchOnTab(0);
        driver.switchTo().defaultContent();
    }

    private void goToCopyright(){
        scroll(copyRight.getLocation().getY()+10);
        text = copyRight.getText();
        goToDefaultTab();
    }

    public CoursePage(){}

    public boolean verifyCopyright(){
        goToCopyright();
        return text.contains(LocalDate.now().getYear()+"");
    }
}
