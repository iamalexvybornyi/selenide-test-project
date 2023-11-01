package org.iamalexvybornyi.selenide.test.project;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.iamalexvybornyi.selenide.test.project.action.CommonAction;
import org.iamalexvybornyi.selenide.test.project.action.LoginAction;
import org.iamalexvybornyi.selenide.test.project.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

@Slf4j
public class LoginTest extends BaseTest {
    @Autowired
    private LoginAction loginAction;
    @Autowired
    private CommonAction commonAction;

    @BeforeEach
    void goToAuthPage() {
        navigationAction.goToAuthPage();
    }

    @Test
    public void signUpWithNewAccount() {
        final Account account = testDataGenerator.generateAccount();
        this.loginAction.signUp(account);
        this.commonAction.verifySignOutLinkIsDisplayed();
    }

    @ParameterizedTest(name = "loginWithExistingAccount_{0}")
    @MethodSource("provideExistingAccounts")
    public void loginWithExistingAccount(@NonNull Account account) {
        this.loginAction.signIn(account);
        this.commonAction.verifySignOutLinkIsDisplayed();
    }

    private static Stream<Arguments> provideExistingAccounts() {
        return Stream.of(
                Arguments.of(new Account("Test", "test+1@mail.com", "TestPassword"))
        );
    }
}
