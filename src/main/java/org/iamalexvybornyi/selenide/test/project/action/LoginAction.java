package org.iamalexvybornyi.selenide.test.project.action;

import io.qameta.allure.Step;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.iamalexvybornyi.selenide.test.project.model.Account;
import org.iamalexvybornyi.selenide.test.project.page.LoginPage;
import org.springframework.stereotype.Service;

import static com.codeborne.selenide.Selenide.$x;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginAction {
    @NonNull
    private final LoginPage loginPage;

    @Step("Sign up")
    public void signUp(@NonNull Account account) {
        log.info("Signing up user with the following details: {}", account);
        log.info("Filling in the required form fields");
        $x(this.loginPage.getDisplayNameInput()).type(account.getDisplayName());
        $x(this.loginPage.getSignUpEmailInput()).type(account.getEmail());
        $x(this.loginPage.getSignUpPasswordInput()).type(account.getPassword());
        $x(this.loginPage.getConfirmPasswordInput()).type(account.getPassword());
        log.info("Clicking the sign up button");
        $x(this.loginPage.getSignUpButton()).click();
    }

    @Step("Sign in")
    public void signIn(@NonNull Account account) {
        log.info("Signing in user with the following details: {}", account);
        log.info("Filling in the required form fields");
        $x(this.loginPage.getSignInEmailInput()).type(account.getEmail());
        $x(this.loginPage.getSignInPasswordInput()).type(account.getPassword());
        log.info("Clicking the sign in button");
        $x(this.loginPage.getSignInButton()).click();
    }
}
