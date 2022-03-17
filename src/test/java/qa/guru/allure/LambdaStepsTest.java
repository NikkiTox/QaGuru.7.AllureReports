package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class LambdaStepsTest {
    private static final String REPO = "NikkiTox/QaGuru.2.DemoTest";

    @Test
    public void issueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    step ("Открываем главную страницу", () ->{
        open("https://github.com");
    });
    step ("Ищем репозиторий" +REPO, () ->{
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPO);
        $(".header-search-input").submit();
    });
    step ("Открываем репозиторий" +REPO, () -> {
            $(By.linkText(REPO)).click();
        });
    step ("Проверяем что таб Issues видимый", () ->{
        $(By.partialLinkText("Issue")).shouldBe(Condition.visible);
    });

    }
}
