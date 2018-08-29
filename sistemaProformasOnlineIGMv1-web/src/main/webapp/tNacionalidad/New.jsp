<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New TNacionalidad</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New TNacionalidad</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{tNacionalidad.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="IdNacionalidad:"/>
                    <h:inputText id="idNacionalidad" value="#{tNacionalidad.TNacionalidad.idNacionalidad}" title="IdNacionalidad" required="true" requiredMessage="The idNacionalidad field is required." />
                    <h:outputText value="Nacionalidad:"/>
                    <h:inputText id="nacionalidad" value="#{tNacionalidad.TNacionalidad.nacionalidad}" title="Nacionalidad" />
                    <h:outputText value="TDatEmpleadoList:"/>
                    <h:selectManyListbox id="TDatEmpleadoList" value="#{tNacionalidad.tNacionalidad.jsfcrud_transform[jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.arrayToList].TDatEmpleadoList}" title="TDatEmpleadoList" size="6" converter="#{TDatEmpleado.converter}" >
                        <f:selectItems value="#{TDatEmpleado.TDatEmpleadoItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tNacionalidad.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{TNacionalidad.listSetup}" value="Show All TNacionalidad Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
