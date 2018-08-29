<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>TContrataciones Detail</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TContrataciones Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="NoCont:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.TContratacionesPK.noCont}" title="NoCont" />
                    <h:outputText value="NoDoc:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.noDoc}" title="NoDoc" />
                    <h:outputText value="Responsable:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.responsable}" title="Responsable" />
                    <h:outputText value="Nivel:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.nivel}" title="Nivel" />
                    <h:outputText value="Categoria:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.categoria}" title="Categoria" />
                    <h:outputText value="NoEmp:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.noEmp}" title="NoEmp" />
                    <h:outputText value="FContrato:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.FContrato}" title="FContrato" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="FSalida:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.FSalida}" title="FSalida" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="TSalida:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.TSalida}" title="TSalida" />
                    <h:outputText value="Estado:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.estado}" title="Estado" />
                    <h:outputText value="CMoneda:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.CMoneda}" title="CMoneda" />
                    <h:outputText value="VSueldoImponible:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.VSueldoImponible}" title="VSueldoImponible" />
                    <h:outputText value="CostoHora:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.costoHora}" title="CostoHora" />
                    <h:outputText value="CostoHoraExtra:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.costoHoraExtra}" title="CostoHoraExtra" />
                    <h:outputText value="NoBanco:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.noBanco}" title="NoBanco" />
                    <h:outputText value="NoCta:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.noCta}" title="NoCta" />
                    <h:outputText value="LLicencia:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.LLicencia}" title="LLicencia" />
                    <h:outputText value="DiasLicencia:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.diasLicencia}" title="DiasLicencia" />
                    <h:outputText value="DiasUtilizados:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.diasUtilizados}" title="DiasUtilizados" />
                    <h:outputText value="HoraIngreso:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.horaIngreso}" title="HoraIngreso" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="HoraSalida:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.horaSalida}" title="HoraSalida" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="LGeneraRol:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.LGeneraRol}" title="LGeneraRol" />
                    <h:outputText value="Obs:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.obs}" title="Obs" />
                    <h:outputText value="NoEmpPre:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.noEmpPre}" title="NoEmpPre" />
                    <h:outputText value="NoCdPre:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.noCdPre}" title="NoCdPre" />
                    <h:outputText value="NoCargo:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.noCargo}" title="NoCargo" />
                    <h:outputText value="VSueldoImponibleSuc:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.VSueldoImponibleSuc}" title="VSueldoImponibleSuc" />
                    <h:outputText value="CostoHoraSuc:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.costoHoraSuc}" title="CostoHoraSuc" />
                    <h:outputText value="CostoHoraExtraSuc:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.costoHoraExtraSuc}" title="CostoHoraExtraSuc" />
                    <h:outputText value="ManoObra:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.manoObra}" title="ManoObra" />
                    <h:outputText value="ProyectoCodigo:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.proyectoCodigo}" title="ProyectoCodigo" />
                    <h:outputText value="TipoViatico:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.tipoViatico}" title="TipoViatico" />
                    <h:outputText value="NoCdPreAnt:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.noCdPreAnt}" title="NoCdPreAnt" />
                    <h:outputText value="NivelAprobacion:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.nivelAprobacion}" title="NivelAprobacion" />
                    <h:outputText value="Rmu:"/>
                    <h:outputText value="#{tContrataciones.TContrataciones.rmu}" title="Rmu" />
                    <h:outputText value="TAreas:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tContrataciones.TContrataciones.TAreas}"/>
                        <h:panelGroup rendered="#{tContrataciones.TContrataciones.TAreas != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TAreas.detailSetup}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.TAreas][TAreas.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TAreas.editSetup}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.TAreas][TAreas.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TAreas.destroy}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.TAreas][TAreas.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="TDatEmpleado:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tContrataciones.TContrataciones.TDatEmpleado}"/>
                        <h:panelGroup rendered="#{tContrataciones.TContrataciones.TDatEmpleado != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TDatEmpleado.detailSetup}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.TDatEmpleado][TDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TDatEmpleado.editSetup}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.TDatEmpleado][TDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TDatEmpleado.destroy}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.TDatEmpleado][TDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="NoFuncion:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tContrataciones.TContrataciones.noFuncion}"/>
                        <h:panelGroup rendered="#{tContrataciones.TContrataciones.noFuncion != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TFuncion.detailSetup}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTFuncion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.noFuncion][TFuncion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TFuncion.editSetup}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTFuncion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.noFuncion][TFuncion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TFuncion.destroy}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTFuncion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.noFuncion][TFuncion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="CContrato:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tContrataciones.TContrataciones.CContrato}"/>
                        <h:panelGroup rendered="#{tContrataciones.TContrataciones.CContrato != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TTiposContrato.detailSetup}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTTiposContrato" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.CContrato][TTiposContrato.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TTiposContrato.editSetup}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTTiposContrato" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.CContrato][TTiposContrato.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TTiposContrato.destroy}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTTiposContrato" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones.CContrato][TTiposContrato.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tContrataciones"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TContratacionesController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{TContrataciones.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{TContrataciones.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tContrataciones.TContrataciones][tContrataciones.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{TContrataciones.createSetup}" value="New TContrataciones" />
                <br />
                <h:commandLink action="#{TContrataciones.listSetup}" value="Show All TContrataciones Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
