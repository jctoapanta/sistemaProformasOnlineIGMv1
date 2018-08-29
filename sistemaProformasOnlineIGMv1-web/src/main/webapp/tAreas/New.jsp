<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New TAreas</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New TAreas</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{tAreas.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="NoCd:"/>
                    <h:inputText id="noCd" value="#{tAreas.TAreas.TAreasPK.noCd}" title="NoCd" required="true" requiredMessage="The noCd field is required." />
                    <h:outputText value="NoEmpresa:"/>
                    <h:inputText id="noEmpresa" value="#{tAreas.TAreas.noEmpresa}" title="NoEmpresa" />
                    <h:outputText value="Tipo:"/>
                    <h:inputText id="tipo" value="#{tAreas.TAreas.tipo}" title="Tipo" required="true" requiredMessage="The tipo field is required." />
                    <h:outputText value="Descrip:"/>
                    <h:inputText id="descrip" value="#{tAreas.TAreas.descrip}" title="Descrip" />
                    <h:outputText value="Responsable:"/>
                    <h:inputText id="responsable" value="#{tAreas.TAreas.responsable}" title="Responsable" />
                    <h:outputText value="Codigo:"/>
                    <h:inputText id="codigo" value="#{tAreas.TAreas.codigo}" title="Codigo" />
                    <h:outputText value="CodigoCentroGestion:"/>
                    <h:inputText id="codigoCentroGestion" value="#{tAreas.TAreas.codigoCentroGestion}" title="CodigoCentroGestion" />
                    <h:outputText value="CPartida:"/>
                    <h:inputText id="CPartida" value="#{tAreas.TAreas.CPartida}" title="CPartida" />
                    <h:outputText value="LResponsableP:"/>
                    <h:inputText id="LResponsableP" value="#{tAreas.TAreas.LResponsableP}" title="LResponsableP" />
                    <h:outputText value="TContratacionesList:"/>
                    <h:selectManyListbox id="TContratacionesList" value="#{tAreas.tAreas.jsfcrud_transform[jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.arrayToList].TContratacionesList}" title="TContratacionesList" size="6" converter="#{TContrataciones.converter}" >
                        <f:selectItems value="#{TContrataciones.TContratacionesItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="TAreasList:"/>
                    <h:selectManyListbox id="TAreasList" value="#{tAreas.tAreas.jsfcrud_transform[jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.arrayToList].TAreasList}" title="TAreasList" size="6" converter="#{TAreas.converter}" >
                        <f:selectItems value="#{TAreas.TAreasItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="TAreas:"/>
                    <h:selectOneMenu id="TAreas" value="#{tAreas.TAreas.TAreas}" title="TAreas" required="true" requiredMessage="The TAreas field is required." >
                        <f:selectItems value="#{TAreas.TAreasItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tAreas.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{TAreas.listSetup}" value="Show All TAreas Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
