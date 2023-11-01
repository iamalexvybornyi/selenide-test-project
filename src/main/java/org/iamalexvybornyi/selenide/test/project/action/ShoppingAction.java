package org.iamalexvybornyi.selenide.test.project.action;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.iamalexvybornyi.selenide.test.project.page.ShopPage;
import org.iamalexvybornyi.selenide.test.project.util.Category;
import org.springframework.stereotype.Service;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Slf4j
@AllArgsConstructor
@Service
public class ShoppingAction {
    @NonNull
    private final ShopPage shopPage;

    @Step("Add product from category to cart")
    public void addProductFromCategoryToCart(@NonNull String productName, @NonNull Category category) {
        log.info("Adding product '{}' from category '{}' to cart", productName, category);
        $x(shopPage.getProductNameElement().getProductName(productName)).scrollTo();
        $x(shopPage.getProductNameElement().getProductName(productName)).hover();
        $x(shopPage.getAddToCartButtonOfProductFromCategory(productName, category)).click();
    }

    @Step("Open cart from header")
    public void openCartFromHeader() {
        log.info("Opening cart from header");
        $x(shopPage.getHeaderElement().getCartIcon()).click();
        log.info("Verifying that the checkout button is displayed");
        $x(shopPage.getHeaderElement().getCartPreviewElement().getGoToCheckoutButton()).shouldBe(visible);
    }

    @Step("Verify product is present in cart preview")
    public void verifyProductIsPresentInCartPreview(@NonNull String productName) {
        log.info("Verifying that the product '{}' is present in the cart", productName);
        $x(shopPage.getHeaderElement().getCartPreviewElement()
                .getProductFromCartPreview(productName)).shouldBe(visible);
    }
}
