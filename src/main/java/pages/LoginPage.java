package pages;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import utility.CommonActions;
import utility.ConfigReader;

public class LoginPage extends CommonActions {

    String Username=  ConfigReader.getProperty("username");
    String Password=  ConfigReader.getProperty("password");
    String url=  ConfigReader.getProperty("url");

    Locator usernameInputTextField=page.getByPlaceholder("Username");
    Locator passwordInputTextField=page.getByPlaceholder("Password");
    Locator loginButton=BaseTest.page.locator("#login-button");
    Locator burgerMenuBtn = page.getByText("Open Menu");
    Locator logOutLink = page.getByText("Logout");

    public void openSite(){
        BaseTest.page.navigate( url);

    }




    public void login(String username, String password ) {

        usernameInputTextField.fill(username);
        passwordInputTextField.fill(password);
        loginButton.click();

    }

    public void userLogOut()
    {
        burgerMenuBtn.click();
        logOutLink.click();
    }



}