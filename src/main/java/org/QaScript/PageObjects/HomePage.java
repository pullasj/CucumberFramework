package org.QaScript.PageObjects;

import org.QaScript.BaseClass;
import org.QaScript.Utils.browserUtils;
import org.openqa.selenium.By;

public class HomePage extends BaseClass{
    private static String myAccountText = "(//div[@id='content']/h2)[1]";

    public static void ValidateLogin(String expectedText) {
        browserUtils.validateText(myAccountText,expectedText);

    }
}
