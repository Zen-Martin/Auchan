package com.auchan.steps.test;

import com.auchan.pageObjects.Page;
import io.cucumber.java.After;

public class Hooks {
        @After()
        public void afterTakeScreenShot(){
            Page.saveScreenShotPNG();
    }
}
