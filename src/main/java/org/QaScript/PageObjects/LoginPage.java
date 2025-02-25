package org.QaScript.PageObjects;

import org.QaScript.BaseClass;
import org.QaScript.Utils.browserUtils;
import org.openqa.selenium.By;

public class LoginPage extends BaseClass {

    private static String txtEmail = "//input[@id='input-email']";
    private static String txtPassword = "//input[@id='input-password']";
    private static String btnLogin = "//input[@value='Login']";
    private static String LinkForgotPassword = "(//a[text()='Forgotten Password'])[1]";
    private static String AlertLoginError = "//div[contains(@class,'alert-danger')]";

    public static void enterUsername(String username){
        browserUtils.enterText(txtEmail,username);
    }

    public static void enterPassword(String password){
        browserUtils.enterText(txtPassword,password);
    }

    public static void clickLogin(){
        browserUtils.clickElement(btnLogin);
    }

    public static void forgetPassword(){
        driver.findElement(By.xpath(LinkForgotPassword)).click();
    }

    public static void validateInvalidLogin(String expectedMessage) {
        browserUtils.validateText(AlertLoginError,expectedMessage);
    }
}
