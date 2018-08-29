<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing TNacionalidad</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing TNacionalidad</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="IdNacionalidad:"/>
                    <h:outputText value="#{tNacionalidad.TNacionalidad.idNacionalidad}" title="IdNacionalidad" />
                    <h:outputText value="Nacionalidad:"/>
                    <h:inputText id="nacionalidad" value="#{tNacionalidad.TNacionalidad.nacionalidad}" title="Nacionalidad" />
                    <h:outputText value="TDatEmpleadoList:"/>
                    <h:selectManyListbox id="TDatEmpleadoList" value="#{tNacionalidad.tNacionalidad.jsfcrud_transform[jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method.arrayToList].TDatEmpleadoList}" title="TDatEmpleadoList" size="6" converter="#{TDatEmpleado.converter}" >
                        <f:selectItems value="#{TDatEmpleado.TDatEmpleadoItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tNacionalidad.edit}" value="Save">
                    <f:param name="jsfcrud.currentTNacionalidad" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tNacionalidad.TNacionalidad][tNacionalidad.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tNacionalidad.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTNacionalidad" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tNacionalidad.TNacionalidad][tNacionalidad.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{tNacionalidad.listSetup}" value="Show All TNacionalidad Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
