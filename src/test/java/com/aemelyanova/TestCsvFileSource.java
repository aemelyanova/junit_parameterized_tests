package com.aemelyanova;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class TestCsvFileSource extends TestBase {

    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest(name = "Товар {1} есть в списке по запросу {0}")
    @DisplayName("Тест для проверки наличия товара в списке всех найденных товаров по запросу")
    @Tags({@Tag("BLOCKER"), @Tag("SEARCH")})
    void searchForFullNameOfProductInSearchSite(
            String letters,
            String product
    ) {
        $("#globalnav-menubutton-link-search").click();
        $(".globalnav-searchfield-input").setValue(letters).pressEnter();
        $("#exploreCurated").shouldHave(text(product));
    }
}
