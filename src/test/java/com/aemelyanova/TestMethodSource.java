package com.aemelyanova;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.aemelyanova.data.Locale;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class TestMethodSource {

    static Stream<Arguments> siteShouldContainAllOfButtonForGivenLocale() {
        return Stream.of(
                Arguments.of(Locale.Italiano, List.of(
                        "Professionisti SEO", "Content marketer", "Enterprise", "Agenzie", "SaaS", "E-commerce")),
                Arguments.of(Locale.English, List.of(
                        "Pro SEOs", "Content marketers", "Enterprise", "Agencies", "SaaS", "Ecommerce"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Для локали {0} отображаются кнопки {1}")
    @DisplayName("Тест для проверки отображения кнопок при выборе языка на странице")
    @Tags({@Tag("CRITICAL"), @Tag("LANGUAGE")})
    void siteShouldContainAllOfButtonForGivenLocale(
            Locale locale,
            List<String> buttons
    ) {
        open("https://ahrefs.com/");
        $(".css-7uw272-selectWrapper").click();
        $$(".css-kssd3c-innerSelect option").find(text(locale.name())).click();
        $("#social-proof").shouldHave(visible);
        $$(".css-1pm0yzf-menuItem").shouldHave(texts(buttons));

    }
}
