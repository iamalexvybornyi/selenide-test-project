package org.iamalexvybornyi.selenide.test.project.action;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.iamalexvybornyi.selenide.test.project.config.UrlConfiguration;
import org.iamalexvybornyi.selenide.test.project.page.HomePage;
import org.springframework.stereotype.Service;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@AllArgsConstructor
@Service
public class NavigationAction {

    @NonNull
    private final HomePage homePage;
    @NonNull
    private UrlConfiguration urlConfiguration;

    @Step("Go to shop page")
    public void goToShopPage() {
        log.info("Navigating to the shop page");
        $x(homePage.getHeaderElement().getShopLink()).click();
        log.info("Verifying that the current URL matches the expected");
        assertThat(webdriver().driver().url()).isEqualTo(urlConfiguration.getShop());
    }

    @Step("Go to auth page")
    public void goToAuthPage() {
        log.info("Navigating to the auth page");
        $x(homePage.getHeaderElement().getSignInLink()).click();
        log.info("Verifying that the current URL matches the expected");
        assertThat(webdriver().driver().url()).isEqualTo(urlConfiguration.getAuth());
    }

    @Step("Go to home page")
    public void goToHomePage() {
        log.info("Navigating to the auth page");
        $x(homePage.getHeaderElement().getHomeLink()).click();
        log.info("Verifying that the current URL matches the expected");
        assertThat(webdriver().driver().url()).isEqualTo(urlConfiguration.getHome());
    }

    @Step("Navigate to URL")
    public void navigateToUrl(@NonNull String urlToNavigateTo, @NonNull String expectedUrl) {
        log.info("Navigating to the URL '{}'", urlToNavigateTo);
        open(urlToNavigateTo);
        log.info("Verifying that the current URL matches the expected");
        assertThat(webdriver().driver().url()).startsWith(expectedUrl);
    }
}
