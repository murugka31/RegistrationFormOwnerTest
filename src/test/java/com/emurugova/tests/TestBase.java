package com.emurugova.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.emurugova.config.ConfigForTests;
import com.emurugova.reportData.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        String remoteLaunch = System.getProperty("remoteLaunch", "false");

        if (remoteLaunch.equals("true")) {
            System.setProperty("platform", "remoteBrowser");
            ConfigForTests config = ConfigFactory.create(ConfigForTests.class, System.getProperties());

            String browserSize = config.getSize();
            String browser = config.getBrowser();
            String browserVersion = config.getVersion();
            String remoteUrl = config.getRemoteUrl();
            String login = config.getLogin();
            String password = config.getPassword();

            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

            Configuration.browserCapabilities = capabilities;
            Configuration.browserSize = browserSize;
            Configuration.browser = browser;
            Configuration.browserVersion = browserVersion;
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.remote = format("https://%s:%s@%s", login, password, remoteUrl);

        } else {
            System.setProperty("platform", "localBrowser");
            ConfigForTests config = ConfigFactory.create(ConfigForTests.class, System.getProperties());

            String browserSize = config.getSize();
            String browser = config.getBrowser();
            String browserVersion = config.getVersion();

            Configuration.browserSize = browserSize;
            Configuration.browser = browser;
            Configuration.browserVersion = browserVersion;
            Configuration.baseUrl = "https://demoqa.com";
        }
    }

    @AfterEach
    public void attachMethods() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
