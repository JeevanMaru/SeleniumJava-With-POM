package com.testcases;

import base.BaseTest;
import main.FileActionPage;
import org.testng.annotations.Test;

public class HandlingFileActionsTest extends BaseTest {

    FileActionPage FilePage = new FileActionPage();

    @Test
    public void HandlingFileUpload() throws InterruptedException {

        FilePage.FileUpload();
    }

    @Test
    public void HandlingFileDownload() throws InterruptedException {

        FilePage.FileDownload();
    }

    @Test
    public void HandlingFloatingMenu() throws InterruptedException {

        FilePage.HandlingFloatingMenu();
    }

    @Test
    public void HandlingTabs() throws InterruptedException {
        FilePage.HandlingTab();

    }

}




