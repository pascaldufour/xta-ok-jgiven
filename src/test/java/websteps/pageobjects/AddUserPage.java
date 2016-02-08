package websteps.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddUserPage extends Page {

    @FindBy(name = "name")
    private WebElement txtName;
    @FindBy(name = "addplayer")
    private WebElement btnAddPlayer;
    @FindBy(name = "startgame")
    private WebElement btnStartGame;


    @FindBy(css = "#players > ul")
    private WebElement players;

    public AddUserPage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public AddUserPage addUser(String name) {
        this.txtName.sendKeys(name);
        this.btnAddPlayer.click();

        waitForAllAjaxRequestsToBeHandled();

        assertTrue(players.getText().contains(name + ": money: 1500; possessions:"));

        return this;
    }

    public PlayGamePage clickStart() {
        btnStartGame.click();
        return new PlayGamePage(webDriver);
    }

    public PlayGamePage startGame() {
        btnStartGame.click();

        waitForAllAjaxRequestsToBeHandled();

        assertFalse("start game button is still visible", btnStartGame.isDisplayed());

        return new PlayGamePage(webDriver);
    }


    public AddUserPage validateModal(String message) {
        Alert alertDialog = webDriver.switchTo().alert();
        assertTrue("\nAlert dialog text did not match." +
                        "\nExpected was: " + message + "" +
                        "\nActual was: " + alertDialog.getText(),
                alertDialog.getText().equals(message));
        alertDialog.dismiss();
        webDriver.switchTo().defaultContent();

        return this;
    }

    /**
     * Verifies that the current page is loaded.
     */
    protected void isLoaded() {
        Assert.assertTrue(
                "The page was not loaded correctly." +
                        "\nActual URL: " + webDriver.getCurrentUrl() +
                        "\nExpected URL: " + this.getRelativePath()

                , webDriver.getCurrentUrl().contains(this.getRelativePath()));

        Assert.assertFalse(
                "The state of the page was not fresh.", isGameStarted()
        );

    }

    public boolean isGameStarted() {

        return !btnStartGame.isDisplayed();
    }

}
