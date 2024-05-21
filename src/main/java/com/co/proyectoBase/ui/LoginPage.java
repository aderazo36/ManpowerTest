package com.co.proyectoBase.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target USERNAME_FIELD = Target
            .the("Username field")
            .locatedBy("#username");

    public static final Target PASSWORD_FIELD = Target
            .the("Password field")
            .locatedBy("#password");

    public static final Target LOGIN_BUTTON = Target
            .the("Login button")
            .locatedBy("button[type='submit']");
    public static final Target START_NOW_BUTTON = Target
            .the("Start_now_button")
            .locatedBy("//span[normalize-space()='START NOW']");
}
