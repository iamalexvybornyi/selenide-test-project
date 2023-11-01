package org.iamalexvybornyi.selenide.test.project.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;
import com.github.javafaker.Faker;
import org.iamalexvybornyi.selenide.test.project.config.browser.BrowserConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableConfigurationProperties
@ComponentScan(basePackages = "org.iamalexvybornyi.selenide.test.project")
public class CommonConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "app.browser")
    public BrowserConfigurationProperties browserConfigurationProperties() {
        return new BrowserConfigurationProperties();
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
