package com.aemelyanova;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeEach
    void openSiteApple() {
        Configuration.baseUrl = "1920x1080";
        open("https://www.apple.com");
    }
}
