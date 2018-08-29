<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>TAreas Detail</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TAreas Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="NoCd:"/>
                    <h:outputText value="#{tAreas.TAreas.TAreasPK.noCd}" title="NoCd" />
                    <h:outputText value="NoEmpresa:"/>
                    <h:outputText value="#{tAreas.TAreas.noEmpresa}" title="NoEmpresa" />
                    <h:outputText value="Tipo:"/>
                    <h:outputText value="#{tAreas.TAreas.tipo}" title="Tipo" />
                    <h:outputText value="Descrip:"/>
                    <h:outputText value="#{tAreas.TAreas.descrip}" title="Descrip" />
                    <h:outputText value="Responsable:"/>
                    <h:outputText value="#{tAreas.TAreas.responsable}" title="Responsable" />
                    <h:outputText value="Codigo:"/>
                    <h:outputText value="#{tAreas.TAreas.codigo}" title="Codigo" />
                    <h:outputText value="CodigoCentroGestion:"/>
                    <h:outputText value="#{tAreas.TAreas.codigoCentroGestion}" title="CodigoCentroGestion" />
                    <h:outputText value="CPartida:"/>
                    <h:outputText value="#{tAreas.TAreas.CPartida}" title="CPartida" />
                    <h:outputText value="LResponsableP:"/>
                    <h:outputText value="#{tAreas.TAreas.LResponsableP}" title="LResponsableP" />
                    <h:outputText value="TAreas:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tAreas.TAreas.TAreas}"/>
                        <h:panelGroup rendered="#{tAreas.TAreas.TAreas != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TAreas.detailSetup}">
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas][tAreas.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas.TAreas][TAreas.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tAreas"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TAreasController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TAreas.editSetup}">
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas][tAreas.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas.TAreas][TAreas.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tAreas"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TAreasController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TAreas.destroy}">
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas][tAreas.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas.TAreas][TAreas.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tAreas"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TAreasController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>

                    <h:outputText value="TContratacionesList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty tAreas.TAreas.TContratacionesList}" value="(No Items)"/>
                        <h:dataTable value="#{tAreas.TAreas.TContratacionesList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty tAreas.TAreas.TContratacionesList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCont"/>
                                </f:facet>
                                <h:outputText value="#{item.TContratacionesPK.noCont}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoDoc"/>
                                </f:facet>
                                <h:outputText value="#{item.noDoc}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Responsable"/>
                                </f:facet>
                                <h:outputText value="#{item.responsable}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Nivel"/>
                                </f:facet>
                                <h:outputText value="#{item.nivel}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Categoria"/>
                                </f:facet>
                                <h:outputText value="#{item.categoria}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoEmp"/>
                                </f:facet>
                                <h:outputText value="#{item.noEmp}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FContrato"/>
                                </f:facet>
                                <h:outputText value="#{item.FContrato}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FSalida"/>
                                </f:facet>
                                <h:outputText value="#{item.FSalida}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TSalida"/>
                                </f:facet>
                                <h:outputText value="#{item.TSalida}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Estado"/>
                                </f:facet>
                                <h:outputText value="#{item.estado}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CMoneda"/>
                                </f:facet>
                                <h:outputText value="#{item.CMoneda}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="VSueldoImponible"/>
                                </f:facet>
                                <h:outputText value="#{item.VSueldoImponible}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CostoHora"/>
                                </f:facet>
                                <h:outputText value="#{item.costoHora}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CostoHoraExtra"/>
                                </f:facet>
                                <h:outputText value="#{item.costoHoraExtra}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoBanco"/>
                                </f:facet>
                                <h:outputText value="#{item.noBanco}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCta"/>
                                </f:facet>
                                <h:outputText value="#{item.noCta}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="LLicencia"/>
                                </f:facet>
                                <h:outputText value="#{item.LLicencia}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="DiasLicencia"/>
                                </f:facet>
                                <h:outputText value="#{item.diasLicencia}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="DiasUtilizados"/>
                                </f:facet>
                                <h:outputText value="#{item.diasUtilizados}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="HoraIngreso"/>
                                </f:facet>
                                <h:outputText value="#{item.horaIngreso}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="HoraSalida"/>
                                </f:facet>
                                <h:outputText value="#{item.horaSalida}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="LGeneraRol"/>
                                </f:facet>
                                <h:outputText value="#{item.LGeneraRol}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Obs"/>
                                </f:facet>
                                <h:outputText value="#{item.obs}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoEmpPre"/>
                                </f:facet>
                                <h:outputText value="#{item.noEmpPre}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCdPre"/>
                                </f:facet>
                                <h:outputText value="#{item.noCdPre}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCargo"/>
                                </f:facet>
                                <h:outputText value="#{item.noCargo}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="VSueldoImponibleSuc"/>
                                </f:facet>
                                <h:outputText value="#{item.VSueldoImponibleSuc}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CostoHoraSuc"/>
                                </f:facet>
                                <h:outputText value="#{item.costoHoraSuc}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CostoHoraExtraSuc"/>
                                </f:facet>
                                <h:outputText value="#{item.costoHoraExtraSuc}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ManoObra"/>
                                </f:facet>
                                <h:outputText value="#{item.manoObra}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ProyectoCodigo"/>
                                </f:facet>
                                <h:outputText value="#{item.proyectoCodigo}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TipoViatico"/>
                                </f:facet>
                                <h:outputText value="#{item.tipoViatico}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCdPreAnt"/>
                                </f:facet>
                                <h:outputText value="#{item.noCdPreAnt}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NivelAprobacion"/>
                                </f:facet>
                                <h:outputText value="#{item.nivelAprobacion}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Rmu"/>
                                </f:facet>
                                <h:outputText value="#{item.rmu}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TAreas"/>
                                </f:facet>
                                <h:outputText value="#{item.TAreas}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TDatEmpleado"/>
                                </f:facet>
                                <h:outputText value="#{item.TDatEmpleado}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoFuncion"/>
                                </f:facet>
                                <h:outputText value="#{item.noFuncion}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CContrato"/>
                                </f:facet>
                                <h:outputText value="#{item.CContrato}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{tContrataciones.detailSetup}">
                                    <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas][tAreas.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tContrataciones.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tAreas" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TAreasController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{tContrataciones.editSetup}">
                                    <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas][tAreas.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tContrataciones.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tAreas" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TAreasController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{tContrataciones.destroy}">
                                    <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas][tAreas.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tContrataciones.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tAreas" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TAreasController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>
                    <h:outputText value="TAreasList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty tAreas.TAreas.TAreasList}" value="(No Items)"/>
                        <h:dataTable value="#{tAreas.TAreas.TAreasList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty tAreas.TAreas.TAreasList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCd"/>
                                </f:facet>
                                <h:outputText value="#{item.TAreasPK.noCd}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoEmpresa"/>
                                </f:facet>
                                <h:outputText value="#{item.noEmpresa}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Tipo"/>
                                </f:facet>
                                <h:outputText value="#{item.tipo}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Descrip"/>
                                </f:facet>
                                <h:outputText value="#{item.descrip}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Responsable"/>
                                </f:facet>
                                <h:outputText value="#{item.responsable}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Codigo"/>
                                </f:facet>
                                <h:outputText value="#{item.codigo}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CodigoCentroGestion"/>
                                </f:facet>
                                <h:outputText value="#{item.codigoCentroGestion}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CPartida"/>
                                </f:facet>
                                <h:outputText value="#{item.CPartida}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="LResponsableP"/>
                                </f:facet>
                                <h:outputText value="#{item.LResponsableP}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TAreas"/>
                                </f:facet>
                                <h:outputText value="#{item.TAreas}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{tAreas.detailSetup}">
                                    <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas][tAreas.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAreas.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tAreas" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TAreasController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{tAreas.editSetup}">
                                    <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas][tAreas.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAreas.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tAreas" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TAreasController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{tAreas.destroy}">
                                    <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas][tAreas.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAreas.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tAreas" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TAreasController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{TAreas.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas][tAreas.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{TAreas.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tAreas.TAreas][tAreas.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{TAreas.createSetup}" value="New TAreas" />
                <br />
                <h:commandLink action="#{TAreas.listSetup}" value="Show All TAreas Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
