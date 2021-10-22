package com.auchan.steps.test;

import com.auchan.context.ScenarioContext;
import com.auchan.pageObjects.CoursePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class CourseStep implements En {

    public CourseStep(
            CoursePage coursePage,
            ScenarioContext scenario
    ){

        Then("The footer copyright is out dated", () -> {
            Assert.assertEquals(coursePage.verifyCopyright(),true);
        });

    }
}
