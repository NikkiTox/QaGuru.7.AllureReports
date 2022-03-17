package qa.guru.allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открыть домашнюю страницу GitHub")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Найти репозиторий {repo}")
    public void searchRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }
    @Step("Проверить найден ли репозиторий {repo}")
    public void checkRepository(String repo) {
        $(".repo-list").should(text("NikkiTox/QaGuru.2.DemoTest"));
    }
    @Step("Открыть репозиторий {repo}")
    public void openRepository(String repo) {
        $(By.linkText(repo)).click();
    }
    @Step("Проверить есть ли таб Issues")
    public void checkIssueTab() {
        $("#issues-tab").should(text("issues"));
    }


}
