package pages;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import org.slf4j.Logger;
import utilities.CommonActions;
import utilities.ConfigReader;
import utilities.LoggerUtil;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsPage extends CommonActions {

    public ProductsPage() {
        super();
    }
     private static final Logger log =
            LoggerUtil.getLogger(BaseTest.class);
       String firstname=  ConfigReader.getProperty("firstname");
       String lastname=   ConfigReader.getProperty("lastname");
       String zipCode=   ConfigReader.getProperty("Zipcode");

       Locator addToCartSauceLabsBackpack =page.locator("//button[@id='add-to-cart-sauce-labs-backpack']");
       Locator addToCartSauceLabsBikeLight =page.locator("//button[@id='add-to-cart-sauce-labs-bike-light']");
       Locator addToCartSauceLabsBolt_t_Shirt =page.locator("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
       Locator addToCartSauceLabsTestAllTheThingsTshirtRed =page.locator("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
       Locator sortDropdown =page.locator("[data-test='product-sort-container']");

        Locator shoppingCartLink = page.locator("//a[@class='shopping_cart_link']");
        Locator checkOutButton= page.locator("//button[@id='checkout']");
        Locator firstNameBillingAddressInputTextField= page.getByPlaceholder("First Name");
        Locator lastNameBillingAddressInputTextField= page.getByPlaceholder("Last Name");
        Locator zip_PostalCodeInputTextField=page.getByPlaceholder("Zip/Postal Code");
        Locator continueButton=page.locator("//input[@id='continue']");
        Locator finishButton=page.locator("//button[@id='finish']");
        Locator lastNameRequiredErrorMsg=page.getByText("Error: Last Name is required");

    public void addProductsToCart() {

        addToCartSauceLabsBackpack.click();
        addToCartSauceLabsBikeLight.click();
        addToCartSauceLabsBolt_t_Shirt.click();
        addToCartSauceLabsTestAllTheThingsTshirtRed.click();
        sortDropdown.selectOption("Name (Z to A)");
        sortDropdown.selectOption("Name (A to Z)");


    }

    public void navigateToCartPage() {
        page.locator("//a[@class='shopping_cart_link']").click();

    }

    public void navigateToCheckoutPage() {
        page.locator("//button[@id='checkout']").click();

    }

    public void enterCheckoutInfoAndFinish() {
        shoppingCartLink.click();
        checkOutButton.click();
        firstNameBillingAddressInputTextField.type(firstname);
        lastNameBillingAddressInputTextField.type(lastname);
        zip_PostalCodeInputTextField.type(zipCode);
        continueButton.click();
        finishButton.click();

    }
    public void enterCheckoutInfoAndVerifyLastNameErrorMsg(String LastNameErrorMsg) {
        shoppingCartLink.click();
        checkOutButton.click();
        firstNameBillingAddressInputTextField.type(firstname);
        lastNameBillingAddressInputTextField.type(lastname);
        zip_PostalCodeInputTextField.type(zipCode);
        continueButton.click();
        assertThat(lastNameRequiredErrorMsg).hasText("Error: Last Name is required");

    }


    public void verifySuccessMessage() {
        Locator successMessage=page.locator("//div[@id='checkout_complete_container']//h2[contains(text(),'Thank you for your order!')]");
        assertThat(successMessage).hasText("Thank you for your order!");
        log.info("✅ Test Passed");


    }
}