package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VerifyResultsComponent {
    public void verifyTableResults(String key, String value) {

        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));
    }

}
