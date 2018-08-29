<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing TRhTipoSegSocial Items</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing TRhTipoSegSocial Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TRhTipoSegSocial Items Found)<br />" rendered="#{tRhTipoSegSocial.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tRhTipoSegSocial.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tRhTipoSegSocial.pagingInfo.firstItem + 1}..#{tRhTipoSegSocial.pagingInfo.lastItem} of #{tRhTipoSegSocial.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tRhTipoSegSocial.prev}" value="Previous #{tRhTipoSegSocial.pagingInfo.batchSize}" rendered="#{tRhTipoSegSocial.pagingInfo.firstItem >= tRhTipoSegSocial.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tRhTipoSegSocial.next}" value="Next #{tRhTipoSegSocial.pagingInfo.batchSize}" rendered="#{tRhTipoSegSocial.pagingInfo.lastItem + tRhTipoSegSocial.pagingInfo.batchSize <= tRhTipoSegSocial.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tRhTipoSegSocial.next}" value="Remaining #{tRhTipoSegSocial.pagingInfo.itemCount - tRhTipoSegSocial.pagingInfo.lastItem}"
                                   rendered="#{tRhTipoSegSocial.pagingInfo.lastItem < tRhTipoSegSocial.pagingInfo.itemCount && tRhTipoSegSocial.pagingInfo.lastItem + tRhTipoSegSocial.pagingInfo.batchSize > tRhTipoSegSocial.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tRhTipoSegSocial.TRhTipoSegSocialItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="NoSeg"/>
                            </f:facet>
                            <h:outputText value="#{item.noSeg}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Descrip"/>
                            </f:facet>
                            <h:outputText value="#{item.descrip}"/>
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
                            <h:commandLink value="Show" action="#{tRhTipoSegSocial.detailSetup}">
                                <f:param name="jsfcrud.currentTRhTipoSegSocial" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tRhTipoSegSocial.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{tRhTipoSegSocial.editSetup}">
                                <f:param name="jsfcrud.currentTRhTipoSegSocial" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tRhTipoSegSocial.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{tRhTipoSegSocial.remove}">
                                <f:param name="jsfcrud.currentTRhTipoSegSocial" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tRhTipoSegSocial.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tRhTipoSegSocial.createSetup}" value="New TRhTipoSegSocial"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
