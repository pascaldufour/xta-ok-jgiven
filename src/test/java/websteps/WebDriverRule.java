package websteps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverRule {

    protected WebDriver webDriver;

    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("http://localhost:8081/xta-ok-jgiven/");
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void after() {
        webDriver.close();
    }
}
