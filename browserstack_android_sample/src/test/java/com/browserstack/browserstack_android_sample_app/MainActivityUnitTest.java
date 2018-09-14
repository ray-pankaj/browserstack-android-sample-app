package com.browserstack.browserstack_android_sample_app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static org.junit.Assert.assertTrue;

public class MainActivityUnitTest {

  private AndroidDriver driver;

  @Before
  public void setUp() throws Exception {
    String server = "hub.browserstack.com";

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("device", "Google Pixel");
    capabilities.setCapability("build", "junit-browserstack");
    capabilities.setCapability("name", "single_appium_test");
    capabilities.setCapability("browserstack.debug", true);

    String username = "pankajahuja1";

    String accessKey = "aCxhDStUopf8tsyz4d55";

    // App url of the uploaded app on BrowserStack.
    String app = "bs://35d129dfc8b5223d2e6a65e44dab6fbbedf4e1a3";
    System.out.println("USER" + username);
    System.out.println("KEY" + accessKey);
    System.out.println("App ID" + app);
    capabilities.setCapability("app", app);

      driver = new AndroidDriver(new URL("http://" + username + ":" + accessKey + "@" + server + "/wd/hub"), capabilities);
  }

  @After
  public void tearDown() throws Exception {
      driver.quit();
  }


  @Test
  public void checkIfHelloWorldTextViewIsPresent() throws Exception {
    String assertionLabel = "TextView with text 'HelloWorld' is present.";
    Thread.sleep(50);
      List<AndroidElement> elements = driver.findElementsById("HelloWorldTextView");
      if (elements.size() > 0) {
        String textViewText = elements.get(0).getText();
        assertTrue(assertionLabel, textViewText.equals("Hello World!"));
      } else {
        assertTrue(assertionLabel, false);
      }
  }
}
