package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureTest extends TestBase {
    static final String URL = "https://github.com";
    static final String REPOSITORY = "ApocalipticLove/HW7";
    static final int ISSUE = 1;

    @Test
    public void testIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);
    }

    @Test
    public void testLambdaIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу",()->{
        open(URL);
            });
        step("Ищем репозиторий" + REPOSITORY,()->{
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        });
        step("Открываем репозиторий" + REPOSITORY,()->{
        $(linkText(REPOSITORY)).click();
        });
        step("Открываем вкладку",()->{
        $("#issues-tab").click();
        });
        step("Проверяем наличие вкладки с номером" + ISSUE,()->{
        $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage(URL);
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}
