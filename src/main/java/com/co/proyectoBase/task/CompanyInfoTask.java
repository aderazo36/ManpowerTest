package com.co.proyectoBase.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.co.proyectoBase.ui.CompanyInfoPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompanyInfoTask implements Task {
    private final String companyname;
    private final String countryname;
    private final String statename;
    private final String cityname;

    public CompanyInfoTask(String companyname, String countryname, String statename, String cityname) {
        this.companyname = companyname;
        this.countryname = countryname;
        this.statename = statename;
        this.cityname = cityname;
    }

    public static CompanyInfoTask withinfo(String companyname, String countryname, String statename, String cityname) {
        return instrumented(CompanyInfoTask.class, companyname,countryname, statename, cityname);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(companyname).into(COMPANY_NAME),
                Enter.theValue(countryname).into(COUNTRY_NAME),
                Click.on(COUNTRY_NAME_SELECTED),
                Enter.theValue(statename).into(STATE_NAME),
                Enter.theValue(cityname).into(CITY_NAME),
                Click.on(AGREE_CHECKBOX),
                Click.on(NEXT_BUTTON)
        );
    }
}
