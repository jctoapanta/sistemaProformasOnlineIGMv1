<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing TRhReligion</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing TRhReligion</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="NoRelig:"/>
                    <h:outputText value="#{tRhReligion.TRhReligion.noRelig}" title="NoRelig" />
                    <h:outputText value="Descrip:"/>
                    <h:inputText id="descrip" value="#{tRhReligion.TRhReligion.descrip}" title="Descrip" required="true" requiredMessage="The descrip field is required." />
                    <h:outputText value="TDatEmpleadoList:"/>
                    <h:selectManyListbox id="TDatEmpleadoList" value="#{tRhReligion.tRhReligion.jsfcrud_transform[jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.arrayToList].TDatEmpleadoList}" title="TDatEmpleadoList" size="6" converter="#{TDatEmpleado.converter}" >
                        <f:selectItems value="#{TDatEmpleado.TDatEmpleadoItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tRhReligion.edit}" value="Save">
                    <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tRhReligion.TRhReligion][tRhReligion.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tRhReligion.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tRhReligion.TRhReligion][tRhReligion.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{tRhReligion.listSetup}" value="Show All TRhReligion Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
