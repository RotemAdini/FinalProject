import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Clock {
    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    @BeforeClass

    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:appPackage", "com.google.android.deskclock");
        desiredCapabilities.setCapability("appium:appActivity", "com.android.deskclock.DeskClock");
        desiredCapabilities.setCapability("appium:noReset", true);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub/");

        driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    void alarmClock() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement clockPageButtom = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Alarm\"]");
        clockPageButtom.click();
        MobileElement addClockButtom = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\'Add alarm\']");

        addClockButtom.click();
        Thread.sleep(2000);
        MobileElement addClockSevenAM = (MobileElement) driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"7\"]");
        addClockSevenAM.click();
        MobileElement addClockZeroMin = (MobileElement) driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"0\"]");
        Thread.sleep(2000);
        MobileElement addClockOkButtom = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
        addClockZeroMin.click();
        addClockOkButtom.click();
        MobileElement clockDateButtom = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Clock\"]");
        clockDateButtom.click();
        Thread.sleep(2000);
        MobileElement dateText = (MobileElement) driver.findElementById("com.google.android.deskclock:id/date");
        System.out.println("The date is:"+dateText.getText());


    }


}