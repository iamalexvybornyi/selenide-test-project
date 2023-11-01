package org.iamalexvybornyi.selenide.test.project.page;

import lombok.Getter;
import org.iamalexvybornyi.selenide.test.project.page.element.HeaderElement;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public abstract class BasePage {
    @Autowired
    protected HeaderElement headerElement;
}
