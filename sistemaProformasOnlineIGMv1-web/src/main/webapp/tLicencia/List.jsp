<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TLicencia Items</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TLicencia Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TLicencia Items Found)<br />" rendered="#{tLicencia.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tLicencia.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tLicencia.pagingInfo.firstItem + 1}..#{tLicencia.pagingInfo.lastItem} of #{tLicencia.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tLicencia.prev}" value="Previous #{tLicencia.pagingInfo.batchSize}" rendered="#{tLicencia.pagingInfo.firstItem >= tLicencia.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tLicencia.next}" value="Next #{tLicencia.pagingInfo.batchSize}" rendered="#{tLicencia.pagingInfo.lastItem + tLicencia.pagingInfo.batchSize <= tLicencia.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tLicencia.next}" value="Remaining #{tLicencia.pagingInfo.itemCount - tLicencia.pagingInfo.lastItem}"
                                   rendered="#{tLicencia.pagingInfo.lastItem < tLicencia.pagingInfo.itemCount && tLicencia.pagingInfo.lastItem + tLicencia.pagingInfo.batchSize > tLicencia.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tLicencia.TLicenciaItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="NoLicencia"/>
                            </f:facet>
                            <h:outputText value="#{item.noLicencia}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Descrip"/>
                            </f:facet>
                            <h:outputText value="#{item.descrip}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Obs"/>
                            </f:facet>
                            <h:outputText value="#{item.obs}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{tLicencia.detailSetup}">
                                <f:param name="jsfcrud.currentTLicencia" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tLicencia.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tLicencia.editSetup}">
                                <f:param name="jsfcrud.currentTLicencia" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tLicencia.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tLicencia.remove}">
                                <f:param name="jsfcrud.currentTLicencia" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tLicencia.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tLicencia.createSetup}" value="New TLicencia"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
