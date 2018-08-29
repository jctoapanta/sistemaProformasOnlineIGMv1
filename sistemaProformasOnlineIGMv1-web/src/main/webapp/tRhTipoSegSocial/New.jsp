<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New TRhTipoSegSocial</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New TRhTipoSegSocial</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{tRhTipoSegSocial.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="NoSeg:"/>
                    <h:inputText id="noSeg" value="#{tRhTipoSegSocial.TRhTipoSegSocial.noSeg}" title="NoSeg" required="true" requiredMessage="The noSeg field is required." />
                    <h:outputText value="Descrip:"/>
                    <h:inputText id="descrip" value="#{tRhTipoSegSocial.TRhTipoSegSocial.descrip}" title="Descrip" required="true" requiredMessage="The descrip field is required." />
                    <h:outputText value="Codigo:"/>
                    <h:inputText id="codigo" value="#{tRhTipoSegSocial.TRhTipoSegSocial.codigo}" title="Codigo" required="true" requiredMessage="The codigo field is required." />
                    <h:outputText value="TDatEmpleadoList:"/>
                    <h:selectManyListbox id="TDatEmpleadoList" value="#{tRhTipoSegSocial.tRhTipoSegSocial.jsfcrud_transform[jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.arrayToList].TDatEmpleadoList}" title="TDatEmpleadoList" size="6" converter="#{TDatEmpleado.converter}" >
                        <f:selectItems value="#{TDatEmpleado.TDatEmpleadoItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tRhTipoSegSocial.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{TRhTipoSegSocial.listSetup}" value="Show All TRhTipoSegSocial Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
