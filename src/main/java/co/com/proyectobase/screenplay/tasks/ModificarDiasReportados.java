package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.model.InformacionLaboral;
import co.com.proyectobase.screenplay.model.builder.InformacionLaboralBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.*;
import static co.com.proyectobase.screenplay.userinterface.BotonesMenuVerticalUserInterface.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ModificarDiasReportados implements Task {

    private InformacionLaboral infoLaboral;

    public ModificarDiasReportados(InformacionLaboral infoLaboral) {
        this.infoLaboral=infoLaboral;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(BTN_ABRIR_DIAS_CERRADOS.of(infoLaboral.getFecha()), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_ABRIR_DIAS_CERRADOS));

        verificaCarga(actor);

        modificarDiarepotado(actor);


    }

    private void verificaCarga(Actor actor) {

    }

    private  void modificarDiarepotado(Actor actor){

    }

    public static ModificarDiasReportados con(InformacionLaboralBuilder informacionLaboral) {
        return Tasks.instrumented(ModificarDiasReportados.class, informacionLaboral.build());
    }

}
