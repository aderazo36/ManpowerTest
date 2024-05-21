package com.co.proyectoBase.ui;

import net.serenitybdd.screenplay.targets.Target;

public class BasicInfoPage {
    public static final Target FIRST_NAME = Target
            .the("First name")
            .locatedBy("//*[@id='name']");

    public static final Target LAST_NAME = Target
            .the("Last name")
            .locatedBy("//*[@id='lastName']");

    public static final Target EMAIL = Target
            .the("Email")
            .locatedBy("//*[@id='email']");

    public static final Target PHONE_NUMBER = Target
            .the("Phone number")
            .locatedBy("//*[@id='phone']");

    public static final Target NEXT_BUTTON = Target
            .the("Next button")
            .locatedBy("/html/body/app-root/open/enroller/div/div[2]/div[2]/enroller-form/form/div[1]/nz-form-item/nz-form-control/div/div/button");

}
