<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TTiposContrato Items</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TTiposContrato Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TTiposContrato Items Found)<br />" rendered="#{tTiposContrato.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tTiposContrato.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tTiposContrato.pagingInfo.firstItem + 1}..#{tTiposContrato.pagingInfo.lastItem} of #{tTiposContrato.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tTiposContrato.prev}" value="Previous #{tTiposContrato.pagingInfo.batchSize}" rendered="#{tTiposContrato.pagingInfo.firstItem >= tTiposContrato.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tTiposContrato.next}" value="Next #{tTiposContrato.pagingInfo.batchSize}" rendered="#{tTiposContrato.pagingInfo.lastItem + tTiposContrato.pagingInfo.batchSize <= tTiposContrato.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tTiposContrato.next}" value="Remaining #{tTiposContrato.pagingInfo.itemCount - tTiposContrato.pagingInfo.lastItem}"
                                   rendered="#{tTiposContrato.pagingInfo.lastItem < tTiposContrato.pagingInfo.itemCount && tTiposContrato.pagingInfo.lastItem + tTiposContrato.pagingInfo.batchSize > tTiposContrato.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tTiposContrato.TTiposContratoItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="CContrato"/>
                            </f:facet>
                            <h:outputText value="#{item.CContrato}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Descrip"/>
                            </f:facet>
                            <h:outputText value="#{item.descrip}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="LDuracion"/>
                            </f:facet>
                            <h:outputText value="#{item.LDuracion}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="TTiempo"/>
                            </f:facet>
                            <h:outputText value="#{item.TTiempo}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Duracion"/>
                            </f:facet>
                            <h:outputText value="#{item.duracion}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="LValido"/>
                            </f:facet>
                            <h:outputText value="#{item.LValido}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{tTiposContrato.detailSetup}">
                                <f:param name="jsfcrud.currentTTiposContrato" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tTiposContrato.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tTiposContrato.editSetup}">
                                <f:param name="jsfcrud.currentTTiposContrato" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tTiposContrato.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tTiposContrato.remove}">
                                <f:param name="jsfcrud.currentTTiposContrato" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tTiposContrato.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tTiposContrato.createSetup}" value="New TTiposContrato"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
