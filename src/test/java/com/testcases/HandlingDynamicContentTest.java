package com.testcases;

import base.BaseTest;
import main.DynamicPage;
import org.testng.annotations.Test;

public class HandlingDynamicContentTest extends BaseTest {
    DynamicPage DynamicPage = new DynamicPage();

    @Test
    public void HandlingDynamicContent() {

        DynamicPage.DynamicContent();
    }

    @Test
    public void NotificationMessage() {
        DynamicPage.NotificationMessage();

    }

    @Test
    public void ExplicitWait() {

        DynamicPage.ExplicitWait();
    }

    @Test
    public void DynamicControlsExplicitWait() {

        DynamicPage.DynamicControlsExplicitWait();
    }

    @Test
    public void HandleDynamicContent() {

        DynamicPage.HandleDynamicContent();
    }
}
