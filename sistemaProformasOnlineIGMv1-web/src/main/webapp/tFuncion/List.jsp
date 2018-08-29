<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TFuncion Items</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TFuncion Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TFuncion Items Found)<br />" rendered="#{tFuncion.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tFuncion.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tFuncion.pagingInfo.firstItem + 1}..#{tFuncion.pagingInfo.lastItem} of #{tFuncion.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tFuncion.prev}" value="Previous #{tFuncion.pagingInfo.batchSize}" rendered="#{tFuncion.pagingInfo.firstItem >= tFuncion.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tFuncion.next}" value="Next #{tFuncion.pagingInfo.batchSize}" rendered="#{tFuncion.pagingInfo.lastItem + tFuncion.pagingInfo.batchSize <= tFuncion.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tFuncion.next}" value="Remaining #{tFuncion.pagingInfo.itemCount - tFuncion.pagingInfo.lastItem}"
                                   rendered="#{tFuncion.pagingInfo.lastItem < tFuncion.pagingInfo.itemCount && tFuncion.pagingInfo.lastItem + tFuncion.pagingInfo.batchSize > tFuncion.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tFuncion.TFuncionItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="NoFuncion"/>
                            </f:facet>
                            <h:outputText value="#{item.noFuncion}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Descrip"/>
                            </f:facet>
                            <h:outputText value="#{item.descrip}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Abrev"/>
                            </f:facet>
                            <h:outputText value="#{item.abrev}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{tFuncion.detailSetup}">
                                <f:param name="jsfcrud.currentTFuncion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tFuncion.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tFuncion.editSetup}">
                                <f:param name="jsfcrud.currentTFuncion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tFuncion.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tFuncion.remove}">
                                <f:param name="jsfcrud.currentTFuncion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tFuncion.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tFuncion.createSetup}" value="New TFuncion"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
