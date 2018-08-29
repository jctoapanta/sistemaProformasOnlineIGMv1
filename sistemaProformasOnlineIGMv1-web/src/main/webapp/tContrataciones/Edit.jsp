<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing TContrataciones</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing TContrataciones</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="NoCont:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.TContratacionesPK.noCont}" title="NoCont" />
                    <h:outputText value="NoDoc:"/>
                    <h:inputText id="noDoc" value="#{tContrataciones.TContrataciones.noDoc}" title="NoDoc" />
                    <h:outputText value="Responsable:"/>
                    <h:inputText id="responsable" value="#{tContrataciones.TContrataciones.responsable}" title="Responsable" />
                    <h:outputText value="Nivel:"/>
                    <h:inputText id="nivel" value="#{tContrataciones.TContrataciones.nivel}" title="Nivel" />
                    <h:outputText value="Categoria:"/>
                    <h:inputText id="categoria" value="#{tContrataciones.TContrataciones.categoria}" title="Categoria" />
                    <h:outputText value="NoEmp:"/>
                    <h:inputText id="noEmp" value="#{tContrataciones.TContrataciones.noEmp}" title="NoEmp" />
                    <h:outputText value="FContrato (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="FContrato" value="#{tContrataciones.TContrataciones.FContrato}" title="FContrato" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="FSalida (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="FSalida" value="#{tContrataciones.TContrataciones.FSalida}" title="FSalida" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="TSalida:"/>
                    <h:inputText id="TSalida" value="#{tContrataciones.TContrataciones.TSalida}" title="TSalida" />
                    <h:outputText value="Estado:"/>
                    <h:inputText id="estado" value="#{tContrataciones.TContrataciones.estado}" title="Estado" />
                    <h:outputText value="CMoneda:"/>
                    <h:inputText id="CMoneda" value="#{tContrataciones.TContrataciones.CMoneda}" title="CMoneda" />
                    <h:outputText value="VSueldoImponible:"/>
                    <h:inputText id="VSueldoImponible" value="#{tContrataciones.TContrataciones.VSueldoImponible}" title="VSueldoImponible" />
                    <h:outputText value="CostoHora:"/>
                    <h:inputText id="costoHora" value="#{tContrataciones.TContrataciones.costoHora}" title="CostoHora" />
                    <h:outputText value="CostoHoraExtra:"/>
                    <h:inputText id="costoHoraExtra" value="#{tContrataciones.TContrataciones.costoHoraExtra}" title="CostoHoraExtra" />
                    <h:outputText value="NoBanco:"/>
                    <h:inputText id="noBanco" value="#{tContrataciones.TContrataciones.noBanco}" title="NoBanco" />
                    <h:outputText value="NoCta:"/>
                    <h:inputText id="noCta" value="#{tContrataciones.TContrataciones.noCta}" title="NoCta" />
                    <h:outputText value="LLicencia:"/>
                    <h:inputText id="LLicencia" value="#{tContrataciones.TContrataciones.LLicencia}" title="LLicencia" />
                    <h:outputText value="DiasLicencia:"/>
                    <h:inputText id="diasLicencia" value="#{tContrataciones.TContrataciones.diasLicencia}" title="DiasLicencia" />
                    <h:outputText value="DiasUtilizados:"/>
                    <h:inputText id="diasUtilizados" value="#{tContrataciones.TContrataciones.diasUtilizados}" title="DiasUtilizados" />
                    <h:outputText value="HoraIngreso (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="horaIngreso" value="#{tContrataciones.TContrataciones.horaIngreso}" title="HoraIngreso" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="HoraSalida (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="horaSalida" value="#{tContrataciones.TContrataciones.horaSalida}" title="HoraSalida" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="LGeneraRol:"/>
                    <h:inputText id="LGeneraRol" value="#{tContrataciones.TContrataciones.LGeneraRol}" title="LGeneraRol" />
                    <h:outputText value="Obs:"/>
                    <h:inputText id="obs" value="#{tContrataciones.TContrataciones.obs}" title="Obs" />
                    <h:outputText value="NoEmpPre:"/>
                    <h:inputText id="noEmpPre" value="#{tContrataciones.TContrataciones.noEmpPre}" title="NoEmpPre" />
                    <h:outputText value="NoCdPre:"/>
                    <h:inputText id="noCdPre" value="#{tContrataciones.TContrataciones.noCdPre}" title="NoCdPre" />
                    <h:outputText value="NoCargo:"/>
                    <h:inputText id="noCargo" value="#{tContrataciones.TContrataciones.noCargo}" title="NoCargo" />
                    <h:outputText value="VSueldoImponibleSuc:"/>
                    <h:inputText id="VSueldoImponibleSuc" value="#{tContrataciones.TContrataciones.VSueldoImponibleSuc}" title="VSueldoImponibleSuc" />
                    <h:outputText value="CostoHoraSuc:"/>
                    <h:inputText id="costoHoraSuc" value="#{tContrataciones.TContrataciones.costoHoraSuc}" title="CostoHoraSuc" />
                    <h:outputText value="CostoHoraExtraSuc:"/>
                    <h:inputText id="costoHoraExtraSuc" value="#{tContrataciones.TContrataciones.costoHoraExtraSuc}" title="CostoHoraExtraSuc" />
                    <h:outputText value="ManoObra:"/>
                    <h:inputText id="manoObra" value="#{tContrataciones.TContrataciones.manoObra}" title="ManoObra" />
                    <h:outputText value="ProyectoCodigo:"/>
                    <h:inputText id="proyectoCodigo" value="#{tContrataciones.TContrataciones.proyectoCodigo}" title="ProyectoCodigo" />
                    <h:outputText value="TipoViatico:"/>
                    <h:inputText id="tipoViatico" value="#{tContrataciones.TContrataciones.tipoViatico}" title="TipoViatico" />
                    <h:outputText value="NoCdPreAnt:"/>
                    <h:inputText id="noCdPreAnt" value="#{tContrataciones.TContrataciones.noCdPreAnt}" title="NoCdPreAnt" />
                    <h:outputText value="NivelAprobacion:"/>
                    <h:inputText id="nivelAprobacion" value="#{tContrataciones.TContrataciones.nivelAprobacion}" title="NivelAprobacion" />
                    <h:outputText value="Rmu:"/>
                    <h:inputText id="rmu" value="#{tContrataciones.TContrataciones.rmu}" title="Rmu" />
                    <h:outputText value="TAreas:"/>
                    <h:selectOneMenu id="TAreas" value="#{tContrataciones.TContrataciones.TAreas}" title="TAreas" >
                        <f:selectItems value="#{TAreas.TAreasItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="TDatEmpleado:"/>
                    <h:outputText value=" #{tContrataciones.TContrataciones.TDatEmpleado}" title="TDatEmpleado" />
                    <h:outputText value="NoFuncion:"/>
                    <h:selectOneMenu id="noFuncion" value="#{tContrataciones.TContrataciones.noFuncion}" title="NoFuncion" >
                        <f:selectItems value="#{TFuncion.TFuncionItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="CContrato:"/>
                    <h:selectOneMenu id="CContrato" value="#{tContrataciones.TContrataciones.CContrato}" title="CContrato" >
                        <f:selectItems value="#{TTiposContrato.TTiposContratoItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tContrataciones.edit}" value="Save">
                    <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tContrataciones.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{tContrataciones.listSetup}" value="Show All TContrataciones Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
