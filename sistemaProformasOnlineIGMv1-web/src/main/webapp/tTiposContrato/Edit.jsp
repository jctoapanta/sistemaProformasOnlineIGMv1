<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing TTiposContrato</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing TTiposContrato</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="CContrato:"/>
                    <h:outputText value="#{tTiposContrato.TTiposContrato.CContrato}" title="CContrato" />
                    <h:outputText value="Descrip:"/>
                    <h:inputText id="descrip" value="#{tTiposContrato.TTiposContrato.descrip}" title="Descrip" />
                    <h:outputText value="LDuracion:"/>
                    <h:inputText id="LDuracion" value="#{tTiposContrato.TTiposContrato.LDuracion}" title="LDuracion" />
                    <h:outputText value="TTiempo:"/>
                    <h:inputText id="TTiempo" value="#{tTiposContrato.TTiposContrato.TTiempo}" title="TTiempo" />
                    <h:outputText value="Duracion:"/>
                    <h:inputText id="duracion" value="#{tTiposContrato.TTiposContrato.duracion}" title="Duracion" />
                    <h:outputText value="LValido:"/>
                    <h:inputText id="LValido" value="#{tTiposContrato.TTiposContrato.LValido}" title="LValido" />
                    <h:outputText value="TContratacionesList:"/>
                    <h:selectManyListbox id="TContratacionesList" value="#{tTiposContrato.tTiposContrato.jsfcrud_transform[jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.arrayToList].TContratacionesList}" title="TContratacionesList" size="6" converter="#{TContrataciones.converter}" >
                        <f:selectItems value="#{TContrataciones.TContratacionesItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tTiposContrato.edit}" value="Save">
                    <f:param name="jsfcrud.currentTTiposContrato" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tTiposContrato.TTiposContrato][tTiposContrato.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tTiposContrato.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTTiposContrato" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tTiposContrato.TTiposContrato][tTiposContrato.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{tTiposContrato.listSetup}" value="Show All TTiposContrato Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
