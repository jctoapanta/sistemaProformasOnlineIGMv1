<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TProfesiones Items</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TProfesiones Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TProfesiones Items Found)<br />" rendered="#{tProfesiones.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tProfesiones.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tProfesiones.pagingInfo.firstItem + 1}..#{tProfesiones.pagingInfo.lastItem} of #{tProfesiones.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tProfesiones.prev}" value="Previous #{tProfesiones.pagingInfo.batchSize}" rendered="#{tProfesiones.pagingInfo.firstItem >= tProfesiones.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tProfesiones.next}" value="Next #{tProfesiones.pagingInfo.batchSize}" rendered="#{tProfesiones.pagingInfo.lastItem + tProfesiones.pagingInfo.batchSize <= tProfesiones.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tProfesiones.next}" value="Remaining #{tProfesiones.pagingInfo.itemCount - tProfesiones.pagingInfo.lastItem}"
                                   rendered="#{tProfesiones.pagingInfo.lastItem < tProfesiones.pagingInfo.itemCount && tProfesiones.pagingInfo.lastItem + tProfesiones.pagingInfo.batchSize > tProfesiones.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tProfesiones.TProfesionesItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="NoProfesion"/>
                            </f:facet>
                            <h:outputText value="#{item.noProfesion}"/>
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
                                <h:outputText value="Codigo"/>
                            </f:facet>
                            <h:outputText value="#{item.codigo}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{tProfesiones.detailSetup}">
                                <f:param name="jsfcrud.currentTProfesiones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tProfesiones.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tProfesiones.editSetup}">
                                <f:param name="jsfcrud.currentTProfesiones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tProfesiones.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tProfesiones.remove}">
                                <f:param name="jsfcrud.currentTProfesiones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tProfesiones.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tProfesiones.createSetup}" value="New TProfesiones"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
