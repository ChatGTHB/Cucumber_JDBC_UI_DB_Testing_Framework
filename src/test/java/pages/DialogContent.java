package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.GWD;

import java.util.List;

public class DialogContent extends Parent {
    @FindBy(css = "input[formcontrolname='username']")
    public WebElement username;
    @FindBy(css = "input[formcontrolname='password']")
    public WebElement password;
    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginButton;
    @FindBy(css = "span[class='mat-mdc-tooltip-trigger logo-text']")
    public WebElement textTechnoStudy;
    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'ADD')]//button")
    public WebElement addButton;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    public WebElement nameInput;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='code' ]//input")
    public WebElement codeInput;
    @FindBy(xpath = "//ms-save-button/button")
    public WebElement saveButton;
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    public WebElement shortName;
    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    public WebElement alreadyExist;
    @FindBy(xpath = "//mat-chip-list[@formcontrolname='roles' ]//input")
    public WebElement userType;
    @FindBy(xpath = "//span[text()=' Student ']")
    public WebElement student;
    @FindBy(xpath = "//span[text()=' Administrator ']")
    public WebElement administrator;
    @FindBy(xpath = "//tbody//tr//td[2]")
    public List<WebElement> nameList;
    @FindBy(xpath = "//mat-form-field//input[@placeholder='Name']")
    private WebElement searchInput;
    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;
    @FindBy(xpath = "(//ms-delete-button//button)[1]")
    private WebElement deleteImageButton;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement deleteDialogButton;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;
    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']/input")
    private WebElement priorityCode;
    @FindBy(xpath = "//mat-slide-toggle[@formcontrolname='active']")
    private WebElement toggleBar;

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    public WebElement getWebElement(String strElement) {
        switch (strElement) {
            case "addButton":
                return this.addButton;
            case "saveButton":
                return this.saveButton;
            case "nameInput":
                return this.nameInput;
            case "shortName":
                return this.shortName;
            case "codeInput":
                return this.codeInput;
            case "integrationCode":
                return this.integrationCode;
            case "priorityCode":
                return this.priorityCode;
            case "toggleBar":
                return this.toggleBar;
            case "userType":
                return this.userType;
            case "student":
                return this.student;
            case "administrator":
                return this.administrator;
        }
        return null;
    }

    public void deleteItem(String searchText) {
        mySendKeys(searchInput, searchText);
        myClick(searchButton);
        // wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        // Alternative Way:
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//ms-delete-button//button"), 1));
        myClick(deleteImageButton);
        myClick(deleteDialogButton);
    }
}
