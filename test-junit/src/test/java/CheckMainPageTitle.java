import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CheckMainPageTitle {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(CheckMainPageTitle.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @Test
    public void checkTitleMainPage() {
        driver.get(cfg.url());
        logger.info("Открыта главная страница https://otus.ru");
        assertEquals(cfg.titleMainPage(), driver.getTitle());
        logger.info("Проверка названия главной страницы https://otus.ru");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
