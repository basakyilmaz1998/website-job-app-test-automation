import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Log log = new Log();


    // Locator'i kullanarak bir elementi bulur ve doner
    public WebElement find(By by) {
        return driver.findElement(by);
    }

    // Elemente tiklar
    public void click(By by) {
        find(by).click();
    }

    // Elementin textini alır ve döner
    public String getText(By by) {
        return find(by).getText();
    }

    // Element gorunur olana kadar bekler
    public void waitUntilVisible(By by) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Elementin text'i, istenen text ile eslesene kadar bekler
    public void waitUntilTextEquals(By by, String string) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, string));
    }

    // Elementin sayfada mevcut olup olmadigini kontrol eder
    public boolean isElementPresent(By by) {
        try {
            return findElement(by) != null;
        } catch (Exception e) {
            return false;
        }
    }

    // Eger element varsa elemente tiklar
    public void clickIfElementExists(By by) {
        try {
            // Elementin var olup olmadigini kontrol et
            if (isElementPresent(by)) {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
                element.click();
            }
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
        }
    }

    // Element bulmak icin kullanilan metod
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    // Sayfayi asagiya kaydirir (300 piksel)
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
    }

    // Sayfayı yukarıya kaydırır (300 piksel)
    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -300);");
    }

    // Belirtilen elemente fare ile hover yapar
    public void hoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    // Sayfadaki URL'nin beklenen text'i icerip icermediğini kontrol eder
    public void checkLinkUrl(String expectedText) {
        String currentUrl = driver.getCurrentUrl();
        Assert.isTrue(currentUrl.contains(expectedText), "Link beklenilen text'i icermiyor.");
    }

    // İkinci sekmeye gecer
    public void changeToSecondTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    // Sayfada belirtilen element gorunur olana kadar asagi ve yukari kaydirir
    public void scrollUntilElementVisible(By by) {
        boolean elementFound = false;
        int scrollCount = 0;
        int maxScrollCount = 10; // Maksimum kaydirma sayisi
        int scrollStep = 250; // Her kaydirma adiminda hareket mesafesi (piksel)

        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (!elementFound && scrollCount < maxScrollCount) {
            try {
                WebElement element = driver.findElement(by);

                if (element.isDisplayed()) {
                    // Elementi gorunur hale getirmek icin kaydir
                    js.executeScript("arguments[0].scrollIntoView(true);", element);
                    Thread.sleep(500); // Kaydırdıktan sonra küçük bir bekleme süresi

                    // Element gorunur hale geldiyse, islemi bitir
                    if (element.isDisplayed()) {
                        elementFound = true;
                        break;
                    }
                }
            } catch (Exception e) {
                // Element bulunamadığında sayfayı aşağı kaydır
                js.executeScript("window.scrollBy(0, " + scrollStep + ")"); // Sayfayi yukari kaydir
                scrollCount++;

                try {
                    Thread.sleep(1000); // 1 saniye bekle
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }

        // Yeniden yukari kaydirmayi dene
        while (!elementFound && scrollCount < maxScrollCount) {
            try {
                WebElement element = driver.findElement(by);

                if (element.isDisplayed()) {
                    // Elementi gorunur hale getirmek icin kaydir
                    js.executeScript("arguments[0].scrollIntoView(true);", element);
                    Thread.sleep(500); // Kaydırdıktan sonra küçük bir bekleme süresi

                    // Element gorunur hale geldiyse, islemi bitir
                    if (element.isDisplayed()) {
                        elementFound = true;
                        break;
                    }
                }
            } catch (Exception e) {
                // Element bulunamadiginda sayfayi yukari kaydir
                js.executeScript("window.scrollBy(0, -" + scrollStep + ")"); // Sayfayı yukarı kaydır
                scrollCount++;

                try {
                    Thread.sleep(1000); // 1 saniye bekle
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }

        if (!elementFound) {
            log.info("Element not found");
        }
    }


}
