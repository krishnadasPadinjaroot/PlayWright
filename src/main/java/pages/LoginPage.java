package pages;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import utilities.CommonActions;
import utilities.ConfigReader;

public class LoginPage extends CommonActions {
    public LoginPage() {
        super();
    }

    String Username=  ConfigReader.getUsername();
    String Password=  ConfigReader.getPassword();
    String url=  ConfigReader.getBaseUrl();

    private final Locator usernameInputTextField=page.getByPlaceholder("Username");
    private final Locator passwordInputTextField=page.getByPlaceholder("Password");
    private final Locator loginButton=page.locator("#login-button");
    private final  Locator burgerMenuBtn = page.getByText("Open Menu");
    private final  Locator logOutLink = page.getByText("Logout");

    public void openSite(){
        page.navigate( url);

    }




    public void login(String username, String password ) {

        fillText(usernameInputTextField,Username);
        fillText(passwordInputTextField,Password);
        fillText(passwordInputTextField,Password);
         click(loginButton);

    }

    public void userLogOut()
    {
        click(burgerMenuBtn);
        click(logOutLink);

    }



}