package org.iamalexvybornyi.selenide.test.project.config.browser;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class BrowserConfigurationProperties {

    @NonNull
    private String name;

    @Nullable
    private String resolution;

    @NonNull
    private String version;

    @NonNull
    private Boolean headless;
}
