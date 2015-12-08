/*

package Utils.MyUtils

import geb.testng.GebTest
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.annotations.*



class Grid extends GebTest{

    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        URL hubUrl = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WINDOWS);

        driver = new RemoteWebDriver(hubUrl, capabilities);
        baseUrl = "http://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void windowsTest() {
        driver.get("http://www.google.com");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
*/
