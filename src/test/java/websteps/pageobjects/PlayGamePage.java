package websteps.pageobjects;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayGamePage extends Page {

    @FindBy(name = "startgame")
    private WebElement startGameButton;
    @FindBy(css = "#players ul li")
    private List<WebElement> playerList;

    public PlayGamePage(WebDriver webDriver) {
        super(webDriver, "/");
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

        Assert.assertTrue(
                "The state of the page was not fresh.", playerList.isEmpty()
        );
        Assert.assertFalse(
                "The state of the page was not fresh.", isGameStarted()
        );

    }

    public boolean isGameStarted() {
        return !startGameButton.isDisplayed();
    }



}
