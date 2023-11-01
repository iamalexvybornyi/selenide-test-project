package org.iamalexvybornyi.selenide.test.project.config;

import io.qameta.allure.Allure;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.iamalexvybornyi.selenide.test.project.util.GlobalKeys;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.slf4j.MDC;

import static com.codeborne.selenide.Selenide.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Slf4j
public class CustomTestWatcher implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        attachLogsToAllureReport(context);
        closeWebDriver();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        attachLogsToAllureReport(context);
        closeWebDriver();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        attachLogsToAllureReport(context);
        closeWebDriver();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        attachLogsToAllureReport(context);
        String screenshotAsBase64 = screenshot(OutputType.BASE64);
        byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
        Allure.addAttachment(context.getRequiredTestMethod().getName() + "-screenshot",
                new ByteArrayInputStream(decoded));
        closeWebDriver();
    }

    private void attachLogsToAllureReport(@NonNull ExtensionContext context) {
        final File logFile = new File(String.format("./target/logs/%s.log", MDC.get(GlobalKeys.TEST_ID.getKey())));
        byte[] logFileAsBytes;
        try {
            logFileAsBytes = FileUtils.readFileToByteArray(logFile);
            Allure.addAttachment(context.getRequiredTestMethod().getName() + "-log",
                    new ByteArrayInputStream(logFileAsBytes));
        } catch (IOException e) {
            log.error("Couldn't attach log file to the allure report");
            throw new RuntimeException(e);
        }
    }
}
