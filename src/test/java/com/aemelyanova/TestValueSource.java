package com.aemelyanova;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class TestValueSource extends TestBase {


    @ValueSource(
            strings = {"air", "mac"}
    )
    @ParameterizedTest(name = "По запросу есть минимум 3 подходящих значения")
    @DisplayName("Тест для проверки наличия минимум 3 товаров в списке всех найденных товаров по запросу")
    @Tags({@Tag("BLOCKER"), @Tag("SEARCH")})

    void searchSiteLeastThreeSuitableProductNames(String letters) {
        $("#globalnav-menubutton-link-search").click();
        $(".globalnav-searchfield-input").setValue(letters).pressEnter();
        $$(".rf-serp-productdescription").shouldHave(CollectionCondition.sizeGreaterThan(3));
    }
}
