
package utility;

import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

    public class AllureUtil {

        public static void attachScreenshot(byte[] screenshot) {

            Allure.addAttachment(
                    "Failure Screenshot",
                    new ByteArrayInputStream(screenshot)
            );

        }
    }

