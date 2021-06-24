package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ProjectConfig;
import helpers.Browserstack;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        return getAndroidDriver();
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", "qa_guru_20");
        capabilities.setCapability("build", "Android");
        capabilities.setCapability("name", "MobileTests");
        capabilities.setCapability("autoGrantPermissions", "true");

        return capabilities;
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("device", ProjectConfig.androidConfig.device());
        capabilities.setCapability("os_version", ProjectConfig.androidConfig.osVersion());
        capabilities.setCapability("app", ProjectConfig.androidConfig.app());

        return new AndroidDriver(Browserstack.getBrowserstackUrl(), capabilities);
    }
}