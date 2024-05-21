package com.co.proyectoBase.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.co.proyectoBase.ui.BasicInfoPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BasicInfoTask implements Task {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String phone;

    public BasicInfoTask(String firstname, String lastname,String email,String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

    public static BasicInfoTask withInfo(String firstname, String lastname, String email, String phone) {
        return instrumented(BasicInfoTask.class, firstname, lastname, email, phone);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstname).into(FIRST_NAME),
                Enter.theValue(lastname).into(LAST_NAME),
                Enter.theValue(email).into(EMAIL),
                Enter.theValue(phone).into(PHONE_NUMBER),
                Click.on(NEXT_BUTTON)
        );
    }
}
