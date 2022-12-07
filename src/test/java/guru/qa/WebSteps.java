package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу {url}")
    public void openMainPage(String url){
        open(url);
    }
    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }
    @Step("Открываем репозиторий {repo}")
    public void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
    }
    @Step("Открываем вкладку")
    public void openIssueTab(){
        $("#issues-tab").click();
    }
    @Step("Проверяем наличие вкладки с номером {issue}")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}
