package org.QaScript.StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.zh_tw.並且;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.QaScript.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends BaseClass {



    @Before
    public void Setup(){
        initializeDriver();
    }

    @After
    public void Close(){
        closeDriver();
    }
}
