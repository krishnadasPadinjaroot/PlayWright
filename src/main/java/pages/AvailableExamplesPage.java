package pages;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import utility.CommonActions;

public class AvailableExamplesPage extends CommonActions {


     Locator AorBTestingLink=page.getByText("UA/B Testing");
    Locator AorBTestVariation1Text =page.locator("//div[@class='example']/p");


public void clickAorBTestingLink(){
  click(AorBTestingLink);

}
   public String getTextAorBTestVariation1Text(){

       return getText(AorBTestVariation1Text);



}


}
