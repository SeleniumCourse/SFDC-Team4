package com.selenium.course.pages;

        import com.selenium.course.framework.WebDriverManager;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.CacheLookup;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import static com.selenium.course.common.Globals.TIMEOUT_MIN;
        import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;
        import java.util.concurrent.TimeUnit;

/**
 * Created by Andrea Castro on 6/12/2015.
 */
public class ProductEditPage extends NewProductForm {


    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1[contains(.,'Product Edit:')]")
    @CacheLookup
    WebElement EditProductTitle;


    public ProductEditPage() {
        this.driver = driver;
        wait = WebDriverManager.getInstance().getWait();
        driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
                ExpectedConditions.visibilityOf(EditProductTitle));
        wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
    }


}


