package org.iamalexvybornyi.selenide.test.project.action;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.iamalexvybornyi.selenide.test.project.page.CategoryPage;
import org.springframework.stereotype.Service;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Slf4j
@AllArgsConstructor
@Service
public class CategoryAction {

    @NonNull
    private final CategoryPage categoryPage;

    @Step("Add product to cart")
    public void addProductToCart(@NonNull String productName) {
        log.info("Adding product {} to cart", productName);
        $x(categoryPage.getProductNameElement().getProductName(productName)).hover();
        $x(categoryPage.getAddToCartButtonOfProduct(productName)).click();
    }

    @Step("Open cart from header")
    public void openCartFromHeader() {
        log.info("Opening cart from header");
        $x(categoryPage.getHeaderElement().getCartIcon()).click();
        log.info("Checking the cart preview is open");
        $x(categoryPage.getHeaderElement().getCartPreviewElement().getGoToCheckoutButton()).shouldBe(visible);
    }

    @Step("Verify product is present in cart preview")
    public void verifyProductIsPresentInCartPreview(@NonNull String productName) {
        log.info("Checking the product '{}' is present in the cart preview", productName);
        $x(categoryPage.getHeaderElement().getCartPreviewElement()
                .getProductFromCartPreview(productName)).shouldBe(visible);
    }
}
