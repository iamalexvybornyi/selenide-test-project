package org.iamalexvybornyi.selenide.test.project.action;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.iamalexvybornyi.selenide.test.project.config.UrlConfiguration;
import org.iamalexvybornyi.selenide.test.project.page.HomePage;
import org.iamalexvybornyi.selenide.test.project.util.Category;
import org.springframework.stereotype.Service;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@AllArgsConstructor
@Service
public class CommonAction {
    @NonNull
    private final HomePage homePage;
    @NonNull
    private UrlConfiguration urlConfiguration;

    @Step("Verify sign out link is displayed")
    public void verifySignOutLinkIsDisplayed() {
        log.info("Verifying the sign out link is displayed");
        $x(this.homePage.getHeaderElement().getSignOutLink()).shouldBe(visible);
        $x(this.homePage.getHeaderElement().getSignOutLink()).shouldBe(visible);
    }

    @Step("Navigate to category from home page")
    public void navigateToCategoryFromHomePage(@NonNull Category category) {
        log.info("Navigating to the category {} from home page", category);
        $x(homePage.getHomeCategoryElement().getCategory(category)).click();
        log.info("Verifying that the current URL matches the expected");
        assertThat(webdriver().driver().url())
                .isEqualTo(urlConfiguration.getShop() + "/" + category.toString().toLowerCase());
    }
}
