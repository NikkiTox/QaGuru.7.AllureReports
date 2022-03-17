package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideListenerTest {

    @Test
    public void testIssueSearch(){
    open("https://github.com");
    $(".header-search-input").click();
    $(".header-search-input").sendKeys("NikkiTox/QaGuru.2.DemoTest");
    $(".header-search-input").submit();
    $(By.linkText("NikkiTox/QaGuru.2.DemoTest")).click();
    $(By.partialLinkText("Issue")).click();
    $(withText("Issue")).should(Condition.exist);
    }
}
