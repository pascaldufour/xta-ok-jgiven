package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class SharedDriver extends EventFiringWebDriver {

    private static SharedDriver instance = null;
    private static WebDriver REAL_DRIVER;

    static {
        REAL_DRIVER = new FirefoxDriver();
        REAL_DRIVER.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    REAL_DRIVER.quit();
                } catch (UnreachableBrowserException ignored) {} //On calling quit, Firefox tries to cleanup the temporary profile it created. This causes a race condition.
            }
        });
    }

    public static SharedDriver newInstance() {
        if (instance == null) {
            instance = new SharedDriver();
        }
        return instance;
    }

    public SharedDriver() {
        super(REAL_DRIVER);
    }

}
