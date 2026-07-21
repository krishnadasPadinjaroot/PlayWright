
package utilities;

import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

    public class AllureUtils {

        public static void attachScreenshot(byte[] screenshot) {

            Allure.addAttachment(
                    "Failure Screenshot",
                    new ByteArrayInputStream(screenshot)
            );

        }
    }

