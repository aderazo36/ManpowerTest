package com.co.proyectoBase.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.cucumber.suiteslicing.ScenarioLineCountStatistics;
import net.serenitybdd.screenplay.actions.Click;

import static com.co.proyectoBase.stepdefinitions.setupConfiguration.User;
import static com.co.proyectoBase.task.BasicInfoTask.withInfo;
import static com.co.proyectoBase.task.CompanyInfoTask.withinfo;
import static com.co.proyectoBase.task.OpenPage.openPage;
import static com.co.proyectoBase.ui.LoginPage.START_NOW_BUTTON;

public class loginStepDeinitions {
    @Given("that the user is in the application")
    public void that_the_user_is_in_the_application() {
        String url = "https://app-qa.enginebi.net/subscription/2-basic";
        User.attemptsTo(openPage(url));
        User.attemptsTo(Click.on(START_NOW_BUTTON));
        //throw new io.cucumber.java.PendingException();
    }
    @When("the user logs in successfully")
    public void the_user_logs_in_successfully() {
        User.attemptsTo(withInfo("Angel","erazo","prue3ba1@prueba.com","3145551124"));
        User.attemptsTo(withinfo("Empresa12345","Canada","Alberta","Popayan"));
        //throw new io.cucumber.java.PendingException();
    }
    @Then("the user should see a success message displayed")
    public void the_user_should_see_a_success_message_displayed() {
        //throw new io.cucumber.java.PendingException();
    }

}
