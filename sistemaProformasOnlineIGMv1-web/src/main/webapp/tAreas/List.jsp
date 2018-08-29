<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TAreas Items</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TAreas Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TAreas Items Found)<br />" rendered="#{tAreas.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tAreas.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tAreas.pagingInfo.firstItem + 1}..#{tAreas.pagingInfo.lastItem} of #{tAreas.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tAreas.prev}" value="Previous #{tAreas.pagingInfo.batchSize}" rendered="#{tAreas.pagingInfo.firstItem >= tAreas.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tAreas.next}" value="Next #{tAreas.pagingInfo.batchSize}" rendered="#{tAreas.pagingInfo.lastItem + tAreas.pagingInfo.batchSize <= tAreas.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tAreas.next}" value="Remaining #{tAreas.pagingInfo.itemCount - tAreas.pagingInfo.lastItem}"
                                   rendered="#{tAreas.pagingInfo.lastItem < tAreas.pagingInfo.itemCount && tAreas.pagingInfo.lastItem + tAreas.pagingInfo.batchSize > tAreas.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tAreas.TAreasItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
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
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAreas.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tAreas.editSetup}">
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAreas.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tAreas.remove}">
                                <f:param name="jsfcrud.currentTAreas" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tAreas.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tAreas.createSetup}" value="New TAreas"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
