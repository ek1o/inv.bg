import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UserHomePage {
    @FindBy(xpath = "//div[@id='tabs_objects']/a")
    private static WebElement itemsHeaderButton;
    @FindBy(xpath = "//h1")
    private static WebElement userAccount;
    @FindBy(xpath = "//div[@class='userpanel-header']")
    private static WebElement userEmail;
    @FindBy(xpath = "//a[@class='onsublink']")
    private static WebElement tabItems;
    @FindBy(xpath = "//a[@class='newbtn selenium-add-item']")
    private static WebElement newItemButton;
    @FindBy(xpath = "//input[@name='name']")
    private static WebElement itemNameField;
    @FindBy(xpath = "//input[@name='name_en']")
    private static WebElement itemNameFieldEng;
    @FindBy(xpath = "//input[@name='price']")
    private static WebElement singlePriceField;
    @FindBy(xpath = "//select[@name='price_currency']")
    private static WebElement priceCurrencySelect;
    @FindBy(xpath = "//select[@name='vat_percent']")
    private static WebElement ddsSelect;
    @FindBy(xpath = "//input[@name='price_quantity']")
    private static WebElement quantityField;
    @FindBy(xpath = "//select[@name='price_quantity_unit']")
    private static WebElement priceUnitQuantitySelect;
    @FindBy(xpath = "//input[@name='do_submit']")
    private static WebElement itemAddButton;


    static {
        PageFactory.initElements(Browser.driver, UserHomePage.class);
    }

    public static void verifySuccessfulLogIn() {
        Assert.assertEquals(userAccount.getText(), "ekioLTD");
    }
    public static void verifyLanguageSetOnBG(String text) {
    String txt = Browser.driver.findElement(By.xpath("//span[@class='inline-block vertical-align-middle']")).getText().trim();
    Assert.assertEquals(txt,text);
    }

    public static void verifyCorrectEmail(String email) {
        Assert.assertEquals(userEmail.getText(), email);
    }

    public static void itemHeaderButtonClick() {
        Action.click(itemsHeaderButton);
        }

        public static void getItemsPageSuccessfullyLoadedMessage(String text) {
        String txt = tabItems.getText();
        String txt2 = Browser.driver.findElement(By.xpath("//div[@id='headline2']/h2")).getText();
        Assert.assertEquals(txt2,txt);
        Assert.assertEquals(text,txt);
    }

    public static void clickOnTabItem() {
            Action.click(tabItems);
            Assert.assertEquals(tabItems.getText(),"Артикули");
        }

     public static void clickOnNewItemBUtton(){
     Action.click(newItemButton);
     }
     public static void verifyAddNewItemPageIsSuccessfullyLoaded(String text){
        String txt = Browser.driver.findElement(By.xpath("//div[@id='headline2']/h2")).getText();
        Assert.assertEquals(text,txt);
     }
     public static void addNewItemWithCertainParameters(){
        Action.type(itemNameField,"Кутия");
        Action.type(itemNameFieldEng,"Box");
        Action.type(singlePriceField,"10");
        Action.dropDownSelect(ddsSelect,"20");
        quantityField.clear();
        Action.type(quantityField,"1.00");
        Action.click(itemAddButton);

     }
     public static void addNewItemWithZeroQuantity(){
         Action.type(itemNameField,"Кутия");
         Action.type(itemNameFieldEng,"Box");
         Action.type(singlePriceField,"10");
         Action.dropDownSelect(ddsSelect,"20");
         quantityField.clear();
         Action.type(quantityField,"0");
         Action.click(itemAddButton);

     }
     public static void verifySuccessfullyItemInsertion(String text) {
        String txt = Browser.driver.findElement(By.xpath("//div[@id='okmsg']")).getText().trim();
        Assert.assertEquals(txt,text);
     }
     public static void verifyInvalidItemAddMessage(String text){
        String message = Browser.driver.findElement(By.xpath("//div[@id='error']")).getText().trim();
        Assert.assertEquals(text,message);
    }
    public static void confirmationMessage(String text) {
        String ok = Browser.driver.getCurrentUrl();
        if (ok.contains("done")) {
            String okMessage = Browser.driver.findElement(By.xpath("//div[@id='okmsg']")).getText().trim();
            Assert.assertEquals(okMessage, text);
        } else {
            String failMessage = Browser.driver.findElement(By.xpath("//div[@id='error']")).getText().trim();
            Assert.assertEquals(failMessage, text);
        }
    }

     public static void verifyDeleteLastCreatedItem(String text){
        if(!Browser.driver.getCurrentUrl().contains("ok")){
            String message = Browser.driver.findElement(By.xpath("//div[@id='error']")).getText().trim();
            Assert.assertEquals(text,message);
        }else{
        itemHeaderButtonClick();
        WebElement itemCheckBox = Browser.driver.findElement(By.xpath("//input[@name='object[]']"));
        if (!itemCheckBox.isSelected()){
            itemCheckBox.click();
        }
        WebElement deleteButton = Browser.driver.findElement(By.xpath("//a[@id='delbtn']"));
        deleteButton.click();
        Alert alert = Browser.driver.switchTo().alert();
        alert.accept();
        String message =Browser.driver.findElement(By.xpath("//div[@id='okmsg']")).getText().trim();
        Assert.assertEquals(message,text);
     }
    }
     public static void addMultipleItems(String name,String nameEng,String singlePrice,String dds,String quantity){
        Action.type(itemNameField,name);
        Action.type(itemNameFieldEng,nameEng);
        Action.type(singlePriceField,singlePrice);
        Action.dropDownSelect(ddsSelect,dds);
        quantityField.clear();
        Action.type(quantityField,quantity);
        Action.click(itemAddButton);

     }
}
