<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TNacionalidad Items</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TNacionalidad Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TNacionalidad Items Found)<br />" rendered="#{tNacionalidad.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tNacionalidad.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tNacionalidad.pagingInfo.firstItem + 1}..#{tNacionalidad.pagingInfo.lastItem} of #{tNacionalidad.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tNacionalidad.prev}" value="Previous #{tNacionalidad.pagingInfo.batchSize}" rendered="#{tNacionalidad.pagingInfo.firstItem >= tNacionalidad.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tNacionalidad.next}" value="Next #{tNacionalidad.pagingInfo.batchSize}" rendered="#{tNacionalidad.pagingInfo.lastItem + tNacionalidad.pagingInfo.batchSize <= tNacionalidad.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tNacionalidad.next}" value="Remaining #{tNacionalidad.pagingInfo.itemCount - tNacionalidad.pagingInfo.lastItem}"
                                   rendered="#{tNacionalidad.pagingInfo.lastItem < tNacionalidad.pagingInfo.itemCount && tNacionalidad.pagingInfo.lastItem + tNacionalidad.pagingInfo.batchSize > tNacionalidad.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tNacionalidad.TNacionalidadItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="IdNacionalidad"/>
                            </f:facet>
                            <h:outputText value="#{item.idNacionalidad}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Nacionalidad"/>
                            </f:facet>
                            <h:outputText value="#{item.nacionalidad}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{tNacionalidad.detailSetup}">
                                <f:param name="jsfcrud.currentTNacionalidad" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tNacionalidad.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tNacionalidad.editSetup}">
                                <f:param name="jsfcrud.currentTNacionalidad" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tNacionalidad.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tNacionalidad.remove}">
                                <f:param name="jsfcrud.currentTNacionalidad" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tNacionalidad.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tNacionalidad.createSetup}" value="New TNacionalidad"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
