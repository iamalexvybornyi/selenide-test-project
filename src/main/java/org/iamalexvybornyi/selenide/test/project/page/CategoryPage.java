package org.iamalexvybornyi.selenide.test.project.page;

import lombok.Getter;
import lombok.NonNull;
import org.iamalexvybornyi.selenide.test.project.page.element.AddToCartButtonElement;
import org.iamalexvybornyi.selenide.test.project.page.element.ProductNameElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CategoryPage extends BasePage implements Page {
    @Autowired
    private ProductNameElement productNameElement;
    @Autowired
    private AddToCartButtonElement addToCartButtonElement;

    @NonNull
    public String getAddToCartButtonOfProduct(@NonNull String productName) {
        return productNameElement.getProductName(productName) + "/parent::div/.." + addToCartButtonElement.getButton();
    }
}
