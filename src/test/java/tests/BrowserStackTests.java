package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;
import static java.nio.channels.Selector.open;

public class BrowserStackTests extends TestBase {
    @Tag("selenide_android")
    @Test
    @DisplayName("Search on Wikipedia test")
    void simpleWikiSearchTest() {
        step("Open app", () -> {
            open();
        });

        step("If opened onboarding page - press back button", () -> {
            if ($(MobileBy.id("org.wikipedia.alpha:id/view_onboarding_page_indicator")).isDisplayed()) {
                back();
            }
        });

        step("Click on 'Search Wikipedia'", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
        });

        step("Type 'Browserstack'", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Browserstack");
        });

        step("Verify success search", () -> {
            $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });
    }
}