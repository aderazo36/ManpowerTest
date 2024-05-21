package com.co.proyectoBase.ui;
import net.serenitybdd.screenplay.targets.Target;
public class CompanyInfoPage {

    public static final Target COMPANY_NAME = Target
            .the("Company Name")
            .locatedBy("//*[@id=\"customerName\"]");




    public static final Target COUNTRY_NAME = Target
            .the("Country Name")
            .locatedBy("#countryId");

    public static final Target COUNTRY_NAME_SELECTED = Target
            .the("Country Name")
            .locatedBy("//div[@class='ant-select-item-option-content']");

    public static final Target STATE_NAME = Target
            .the("State Name")
            .locatedBy("#stateId");

    public static final Target CITY_NAME = Target
            .the("City Name")
            .locatedBy("#city");

    public static final Target AGREE_CHECKBOX = Target
            .the("Agree Checkbox")
            .locatedBy("//input[@type='checkbox']");

    public static final Target NEXT_BUTTON = Target
            .the("Next Button")
            .locatedBy("//span[@nztheme='outline']//*[name()='svg']");


}
