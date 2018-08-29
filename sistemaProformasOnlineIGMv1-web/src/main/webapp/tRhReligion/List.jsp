<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TRhReligion Items</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TRhReligion Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TRhReligion Items Found)<br />" rendered="#{tRhReligion.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tRhReligion.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tRhReligion.pagingInfo.firstItem + 1}..#{tRhReligion.pagingInfo.lastItem} of #{tRhReligion.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tRhReligion.prev}" value="Previous #{tRhReligion.pagingInfo.batchSize}" rendered="#{tRhReligion.pagingInfo.firstItem >= tRhReligion.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tRhReligion.next}" value="Next #{tRhReligion.pagingInfo.batchSize}" rendered="#{tRhReligion.pagingInfo.lastItem + tRhReligion.pagingInfo.batchSize <= tRhReligion.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tRhReligion.next}" value="Remaining #{tRhReligion.pagingInfo.itemCount - tRhReligion.pagingInfo.lastItem}"
                                   rendered="#{tRhReligion.pagingInfo.lastItem < tRhReligion.pagingInfo.itemCount && tRhReligion.pagingInfo.lastItem + tRhReligion.pagingInfo.batchSize > tRhReligion.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tRhReligion.TRhReligionItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="NoRelig"/>
                            </f:facet>
                            <h:outputText value="#{item.noRelig}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Descrip"/>
                            </f:facet>
                            <h:outputText value="#{item.descrip}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{tRhReligion.detailSetup}">
                                <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tRhReligion.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tRhReligion.editSetup}">
                                <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tRhReligion.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tRhReligion.remove}">
                                <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tRhReligion.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tRhReligion.createSetup}" value="New TRhReligion"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
