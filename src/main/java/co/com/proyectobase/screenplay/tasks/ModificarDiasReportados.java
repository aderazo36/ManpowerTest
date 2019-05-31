package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.interactions.Esperar;
import co.com.proyectobase.screenplay.model.InformacionLaboral;
import co.com.proyectobase.screenplay.model.builder.InformacionLaboralBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.proyectobase.screenplay.userinterface.DiasCerradosUserInterface.*;
import static co.com.proyectobase.screenplay.userinterface.BotonesMenuVerticalUserInterface.*;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.*;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.BTN_GUARDAR_Y_CERRAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ModificarDiasReportados implements Task {

    private InformacionLaboral infoLaboral;

    public ModificarDiasReportados(InformacionLaboral infoLaboral) {
        this.infoLaboral=infoLaboral;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo((WaitUntil.the(BTN_ABRIR_DIAS_CERRADOS, isVisible()).forNoMoreThan(10).seconds()),
                Click.on(BTN_ABRIR_DIAS_CERRADOS));
        verificaCarga(actor);
        actor.attemptsTo();



        modificarDiarepotado(actor);


    }

    private void verificaCarga(Actor actor) {

    }

    private  void modificarDiarepotado(Actor actor){
        actor.attemptsTo((WaitUntil.the(TXT_BUSCAR_DIAS, isVisible()).forNoMoreThan(10).seconds()),
                Enter.theValue(infoLaboral.getFecha()).into(TXT_BUSCAR_DIAS),
                Click.on(BTN_BUSCAR_DIAS),(WaitUntil.the(GRID_DIAS_REPORTADOS,isVisible()).forNoMoreThan(30).seconds()),
                Click.on(GRID_DIAS_REPORTADOS),(WaitUntil.the(LBL_DIA_REPORTADO,isVisible()).forNoMoreThan(30).seconds()),
                Click.on(LBL_DIA_REPORTADO),(WaitUntil.the(BTN_EDITAR_REPORTE_DIA,isVisible()).forNoMoreThan(30).seconds()),
                Click.on(BTN_EDITAR_REPORTE_DIA));
        Esperar.unMomento(5);
        actor.attemptsTo(WaitUntil.the(BTN_BUSCAR_PROYECTOS,isVisible()).forNoMoreThan(60).seconds(),
                Click.on(BTN_BUSCAR_PROYECTOS));

        actor.attemptsTo(WaitUntil.the(TXT_BUSCAR_FRAME,isVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(infoLaboral.getProyecto()).into(TXT_BUSCAR_FRAME),
                Click.on(BTN_BUSCAR_FRAME),
                (WaitUntil.the(LBL_TABLE_FRAME_PROYECTOS.of(infoLaboral.getProyecto()),isVisible()).forNoMoreThan(60).seconds()),
                Click.on(LBL_TABLE_FRAME_PROYECTOS.of(infoLaboral.getProyecto())));

        actor.attemptsTo(WaitUntil.the(ICON_CMB_TIPO_HORA,isVisible()).forNoMoreThan(60).seconds(),
                Click.on(ICON_CMB_TIPO_HORA),(WaitUntil.the(CMB_TIPO_HORA.of(infoLaboral.getTipoHora()),isVisible()).forNoMoreThan(60).seconds()),
                Click.on(CMB_TIPO_HORA.of(infoLaboral.getTipoHora())));

        Esperar.unMomento(2).performAs(actor);
        actor.attemptsTo(WaitUntil.the(BTN_BUSCAR_SERVICIO,isVisible()).forNoMoreThan(60).seconds());
        actor.attemptsTo(Click.on(BTN_BUSCAR_SERVICIO));

        actor.attemptsTo(WaitUntil.the(TXT_BUSCAR_FRAME,isVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(infoLaboral.getServicio()).into(TXT_BUSCAR_FRAME),
                Click.on(BTN_BUSCAR_FRAME));

        actor.attemptsTo((WaitUntil.the(LBL_TABLE_FRAME_SERVICIOS.of(infoLaboral.getServicio()),isVisible()).forNoMoreThan(60).seconds()),
                Click.on(LBL_TABLE_FRAME_SERVICIOS.of(infoLaboral.getServicio())));

        actor.attemptsTo(WaitUntil.the(ICON_CMB_ACTIVIDAD,isVisible()).forNoMoreThan(60).seconds(),
                Click.on(ICON_CMB_ACTIVIDAD),(WaitUntil.the(CMB_ACTIVIDAD.of(infoLaboral.getActividad()),isVisible()).forNoMoreThan(60).seconds()),
                Click.on(CMB_ACTIVIDAD.of(infoLaboral.getActividad())));

        actor.attemptsTo(WaitUntil.the(TXT_HORAS_EJECUTADAS,isVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(infoLaboral.getHoraEjecutada()).into(TXT_HORAS_EJECUTADAS),
                Enter.theValue(infoLaboral.getComentario()).into(TXT_COMENTARIO),
                Click.on(BTN_GUARDAR_Y_CERRAR));

    }

    public static ModificarDiasReportados con(InformacionLaboralBuilder informacionLaboral) {
        return Tasks.instrumented(ModificarDiasReportados.class, informacionLaboral.build());
    }

}