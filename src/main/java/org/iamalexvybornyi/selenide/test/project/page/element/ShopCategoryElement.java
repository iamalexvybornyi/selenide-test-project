package org.iamalexvybornyi.selenide.test.project.page.element;

import lombok.Getter;
import lombok.NonNull;
import org.iamalexvybornyi.selenide.test.project.util.Category;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ShopCategoryElement implements Element {
    private static final String CATEGORY_HEADER_TEMPLATE = "//a[contains(text(), '%s')]/parent::h2";

    public String getCategory(@NonNull Category categoryName) {
        return String.format(CATEGORY_HEADER_TEMPLATE, categoryName);
    }
}
