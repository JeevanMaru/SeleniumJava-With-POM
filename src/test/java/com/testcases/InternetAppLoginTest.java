package com.testcases;

import base.BaseTest;
import main.LoginPage;
import org.testng.annotations.Test;

import static base.Page.config;

public class InternetAppLoginTest extends BaseTest {

    LoginPage login = new LoginPage();

    //Login with Valid credentials
    @Test
    public void LoginTest() {

        login.doLogin(config.getProperty("username"), config.getProperty("password"));
    }

    //Login with InValid credentials
    @Test
    public void InvalidLoginTest() {
        login.InvalidLogin(config.getProperty("username"), config.getProperty("Invalidpassword"));

    }

}
