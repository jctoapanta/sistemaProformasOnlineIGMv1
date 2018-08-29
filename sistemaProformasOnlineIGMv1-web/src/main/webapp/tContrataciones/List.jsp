<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TContrataciones Items</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TContrataciones Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TContrataciones Items Found)<br />" rendered="#{tContrataciones.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tContrataciones.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tContrataciones.pagingInfo.firstItem + 1}..#{tContrataciones.pagingInfo.lastItem} of #{tContrataciones.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tContrataciones.prev}" value="Previous #{tContrataciones.pagingInfo.batchSize}" rendered="#{tContrataciones.pagingInfo.firstItem >= tContrataciones.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tContrataciones.next}" value="Next #{tContrataciones.pagingInfo.batchSize}" rendered="#{tContrataciones.pagingInfo.lastItem + tContrataciones.pagingInfo.batchSize <= tContrataciones.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tContrataciones.next}" value="Remaining #{tContrataciones.pagingInfo.itemCount - tContrataciones.pagingInfo.lastItem}"
                                   rendered="#{tContrataciones.pagingInfo.lastItem < tContrataciones.pagingInfo.itemCount && tContrataciones.pagingInfo.lastItem + tContrataciones.pagingInfo.batchSize > tContrataciones.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tContrataciones.TContratacionesItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
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
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tContrataciones.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tContrataciones.editSetup}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tContrataciones.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tContrataciones.remove}">
                                <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tContrataciones.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tContrataciones.createSetup}" value="New TContrataciones"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
