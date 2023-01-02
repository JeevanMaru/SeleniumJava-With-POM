package com.testcases;
import base.BaseTest;
import main.ActionsPage;
import org.testng.annotations.Test;

public class ActionsTest extends BaseTest {

    ActionsPage Actions = new ActionsPage();

    @Test()
    public void CheckboxesHandle() {

        Actions.CheckboxesHandle();
    }

    @Test
    public void ContextMenu() {

        Actions.ContextMenu();
    }

    @Test
    public void ValidateTDropDown() {

        Actions.DropDown();
    }

    @Test
    public void HandleDragnDrop() {
        Actions.DragandDrop();
    }

    @Test
    public void HandleFrames() {

        Actions.HandleFrames();
    }

    @Test
    public void HandleMouseOver() {
        Actions.MouseOver();
    }

}
