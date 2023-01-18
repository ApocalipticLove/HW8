package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.WebDriverProvider;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        WebDriverProvider.config();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.addVideo();
    }
}
