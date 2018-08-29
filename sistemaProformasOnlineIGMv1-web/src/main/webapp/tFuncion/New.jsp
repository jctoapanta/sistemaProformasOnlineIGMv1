<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New TFuncion</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New TFuncion</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{tFuncion.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="NoFuncion:"/>
                    <h:inputText id="noFuncion" value="#{tFuncion.TFuncion.noFuncion}" title="NoFuncion" required="true" requiredMessage="The noFuncion field is required." />
                    <h:outputText value="Descrip:"/>
                    <h:inputText id="descrip" value="#{tFuncion.TFuncion.descrip}" title="Descrip" />
                    <h:outputText value="Abrev:"/>
                    <h:inputText id="abrev" value="#{tFuncion.TFuncion.abrev}" title="Abrev" />
                    <h:outputText value="TContratacionesList:"/>
                    <h:selectManyListbox id="TContratacionesList" value="#{tFuncion.tFuncion.jsfcrud_transform[jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.arrayToList].TContratacionesList}" title="TContratacionesList" size="6" converter="#{TContrataciones.converter}" >
                        <f:selectItems value="#{TContrataciones.TContratacionesItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tFuncion.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{TFuncion.listSetup}" value="Show All TFuncion Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
