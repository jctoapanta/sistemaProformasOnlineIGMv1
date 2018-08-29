<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing TLicencia</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing TLicencia</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="NoLicencia:"/>
                    <h:outputText value="#{tLicencia.TLicencia.noLicencia}" title="NoLicencia" />
                    <h:outputText value="Descrip:"/>
                    <h:inputText id="descrip" value="#{tLicencia.TLicencia.descrip}" title="Descrip" />
                    <h:outputText value="Obs:"/>
                    <h:inputText id="obs" value="#{tLicencia.TLicencia.obs}" title="Obs" />
                    <h:outputText value="TDatEmpleadoList:"/>
                    <h:selectManyListbox id="TDatEmpleadoList" value="#{tLicencia.tLicencia.jsfcrud_transform[jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.arrayToList].TDatEmpleadoList}" title="TDatEmpleadoList" size="6" converter="#{TDatEmpleado.converter}" >
                        <f:selectItems value="#{TDatEmpleado.TDatEmpleadoItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tLicencia.edit}" value="Save">
                    <f:param name="jsfcrud.currentTLicencia" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tLicencia.TLicencia][tLicencia.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tLicencia.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTLicencia" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tLicencia.TLicencia][tLicencia.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{tLicencia.listSetup}" value="Show All TLicencia Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
