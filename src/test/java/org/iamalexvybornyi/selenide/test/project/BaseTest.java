package org.iamalexvybornyi.selenide.test.project;

import com.codeborne.selenide.Configuration;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.iamalexvybornyi.selenide.test.project.action.NavigationAction;
import org.iamalexvybornyi.selenide.test.project.config.CommonConfiguration;
import org.iamalexvybornyi.selenide.test.project.config.CustomTestWatcher;
import org.iamalexvybornyi.selenide.test.project.config.UrlConfiguration;
import org.iamalexvybornyi.selenide.test.project.config.browser.BrowserConfigurationProperties;
import org.iamalexvybornyi.selenide.test.project.util.GlobalKeys;
import org.iamalexvybornyi.selenide.test.project.util.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@ExtendWith(CustomTestWatcher.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {CommonConfiguration.class})
public class BaseTest {

    @Autowired
    protected UrlConfiguration urlConfiguration;
    @Autowired
    protected TestDataGenerator testDataGenerator;
    @Autowired
    protected NavigationAction navigationAction;
    @Autowired
    private BrowserConfigurationProperties browserConfigurationProperties;

    @BeforeEach
    protected void prepareBrowser(@NonNull TestInfo testInfo) {
        MDC.put(GlobalKeys.TEST_ID.getKey(), testInfo.getDisplayName());
        setSelenideConfig();
        navigationAction.navigateToUrl(urlConfiguration.getHome(), urlConfiguration.getHome());
    }

    private void setSelenideConfig() {
        Configuration.browser = browserConfigurationProperties.getName();
        Configuration.headless = browserConfigurationProperties.getHeadless();
        Configuration.browserSize = browserConfigurationProperties.getResolution();
        Configuration.browserVersion = browserConfigurationProperties.getVersion();
    }
}
