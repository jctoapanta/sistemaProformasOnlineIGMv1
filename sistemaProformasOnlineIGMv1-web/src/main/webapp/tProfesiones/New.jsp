<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New TProfesiones</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New TProfesiones</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{tProfesiones.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="NoProfesion:"/>
                    <h:inputText id="noProfesion" value="#{tProfesiones.TProfesiones.noProfesion}" title="NoProfesion" required="true" requiredMessage="The noProfesion field is required." />
                    <h:outputText value="Descrip:"/>
                    <h:inputText id="descrip" value="#{tProfesiones.TProfesiones.descrip}" title="Descrip" />
                    <h:outputText value="Abrev:"/>
                    <h:inputText id="abrev" value="#{tProfesiones.TProfesiones.abrev}" title="Abrev" />
                    <h:outputText value="Codigo:"/>
                    <h:inputText id="codigo" value="#{tProfesiones.TProfesiones.codigo}" title="Codigo" />
                    <h:outputText value="TDatEmpleadoList:"/>
                    <h:selectManyListbox id="TDatEmpleadoList" value="#{tProfesiones.tProfesiones.jsfcrud_transform[jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.arrayToList].TDatEmpleadoList}" title="TDatEmpleadoList" size="6" converter="#{TDatEmpleado.converter}" >
                        <f:selectItems value="#{TDatEmpleado.TDatEmpleadoItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tProfesiones.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{TProfesiones.listSetup}" value="Show All TProfesiones Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
