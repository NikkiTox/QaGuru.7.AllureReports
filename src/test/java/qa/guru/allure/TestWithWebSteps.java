package qa.guru.allure;

import org.junit.jupiter.api.Test;

public class TestWithWebSteps {
    private static final String REPO = "NikkiTox/QaGuru.2.DemoTest";
    WebSteps steps = new WebSteps();
    @Test
    public void issuesSearch (){
        steps.openMainPage();
        steps.searchRepository(REPO);
        steps.checkRepository(REPO);
        steps.openRepository(REPO);
        steps.checkIssueTab();


    }
}
