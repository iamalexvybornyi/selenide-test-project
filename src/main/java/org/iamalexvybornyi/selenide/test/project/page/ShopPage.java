package org.iamalexvybornyi.selenide.test.project.page;

import lombok.Getter;
import lombok.NonNull;
import org.iamalexvybornyi.selenide.test.project.page.element.AddToCartButtonElement;
import org.iamalexvybornyi.selenide.test.project.page.element.ProductNameElement;
import org.iamalexvybornyi.selenide.test.project.page.element.ShopCategoryElement;
import org.iamalexvybornyi.selenide.test.project.util.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ShopPage extends BasePage implements Page {

    @Autowired
    private ShopCategoryElement shopCategoryElement;
    @Autowired
    private AddToCartButtonElement addToCartButtonElement;
    @Autowired
    private ProductNameElement productNameElement;

    @NonNull
    public String getAddToCartButtonOfProductFromCategory(@NonNull String productName, @NonNull Category categoryName) {
        return shopCategoryElement.getCategory(categoryName) + "/.." + productNameElement.getProductName(productName) +
                "/parent::div/.." + addToCartButtonElement.getButton();
    }
}
