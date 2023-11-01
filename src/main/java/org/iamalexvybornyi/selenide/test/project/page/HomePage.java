package org.iamalexvybornyi.selenide.test.project.page;

import lombok.Getter;
import org.iamalexvybornyi.selenide.test.project.page.element.HomeCategoryElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class HomePage extends BasePage implements Page {
    @Autowired
    private HomeCategoryElement homeCategoryElement;
}
