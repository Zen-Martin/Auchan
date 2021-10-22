package com.auchan.steps.test;

import com.auchan.context.ScenarioContext;
import com.auchan.pageObjects.HelpPage;
import io.cucumber.java8.En;

public class HelpStep implements En {

    public HelpStep(
            HelpPage helpPage,
            ScenarioContext scenario
    ){

        When("Open the menu *Nos rayons*, click on *Auchan Drive*", () -> {
            helpPage.selectAuchanDrive();
        });

    }
}
