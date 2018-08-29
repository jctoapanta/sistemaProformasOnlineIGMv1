<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing TDatEmpleado</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing TDatEmpleado</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="NoPersona:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.noPersona}" title="NoPersona" />
                    <h:outputText value="NoProveedor:"/>
                    <h:inputText id="noProveedor" value="#{tDatEmpleado.TDatEmpleado.noProveedor}" title="NoProveedor" />
                    <h:outputText value="Codigo:"/>
                    <h:inputText id="codigo" value="#{tDatEmpleado.TDatEmpleado.codigo}" title="Codigo" />
                    <h:outputText value="NoCedula:"/>
                    <h:inputText id="noCedula" value="#{tDatEmpleado.TDatEmpleado.noCedula}" title="NoCedula" />
                    <h:outputText value="PriApellido:"/>
                    <h:inputText id="priApellido" value="#{tDatEmpleado.TDatEmpleado.priApellido}" title="PriApellido" />
                    <h:outputText value="SegApellido:"/>
                    <h:inputText id="segApellido" value="#{tDatEmpleado.TDatEmpleado.segApellido}" title="SegApellido" />
                    <h:outputText value="Nombres:"/>
                    <h:inputText id="nombres" value="#{tDatEmpleado.TDatEmpleado.nombres}" title="Nombres" />
                    <h:outputText value="NombreC:"/>
                    <h:inputText id="nombreC" value="#{tDatEmpleado.TDatEmpleado.nombreC}" title="NombreC" />
                    <h:outputText value="LibMilitar:"/>
                    <h:inputText id="libMilitar" value="#{tDatEmpleado.TDatEmpleado.libMilitar}" title="LibMilitar" />
                    <h:outputText value="SeguroSocial:"/>
                    <h:inputText id="seguroSocial" value="#{tDatEmpleado.TDatEmpleado.seguroSocial}" title="SeguroSocial" />
                    <h:outputText value="Sexo:"/>
                    <h:inputText id="sexo" value="#{tDatEmpleado.TDatEmpleado.sexo}" title="Sexo" />
                    <h:outputText value="EstCivil:"/>
                    <h:inputText id="estCivil" value="#{tDatEmpleado.TDatEmpleado.estCivil}" title="EstCivil" />
                    <h:outputText value="GSangre:"/>
                    <h:inputText id="GSangre" value="#{tDatEmpleado.TDatEmpleado.GSangre}" title="GSangre" />
                    <h:outputText value="FNacimiento (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="FNacimiento" value="#{tDatEmpleado.TDatEmpleado.FNacimiento}" title="FNacimiento" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="FMuerte (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="FMuerte" value="#{tDatEmpleado.TDatEmpleado.FMuerte}" title="FMuerte" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="Direccion:"/>
                    <h:inputText id="direccion" value="#{tDatEmpleado.TDatEmpleado.direccion}" title="Direccion" />
                    <h:outputText value="Telefono:"/>
                    <h:inputText id="telefono" value="#{tDatEmpleado.TDatEmpleado.telefono}" title="Telefono" />
                    <h:outputText value="Tipo:"/>
                    <h:inputText id="tipo" value="#{tDatEmpleado.TDatEmpleado.tipo}" title="Tipo" />
                    <h:outputText value="Foto:"/>
                    <h:inputText id="foto" value="#{tDatEmpleado.TDatEmpleado.foto}" title="Foto" />
                    <h:outputText value="ColorPiel:"/>
                    <h:inputText id="colorPiel" value="#{tDatEmpleado.TDatEmpleado.colorPiel}" title="ColorPiel" />
                    <h:outputText value="ColorCabello:"/>
                    <h:inputText id="colorCabello" value="#{tDatEmpleado.TDatEmpleado.colorCabello}" title="ColorCabello" />
                    <h:outputText value="ColorOjos:"/>
                    <h:inputText id="colorOjos" value="#{tDatEmpleado.TDatEmpleado.colorOjos}" title="ColorOjos" />
                    <h:outputText value="Estatura:"/>
                    <h:inputText id="estatura" value="#{tDatEmpleado.TDatEmpleado.estatura}" title="Estatura" />
                    <h:outputText value="Peso:"/>
                    <h:inputText id="peso" value="#{tDatEmpleado.TDatEmpleado.peso}" title="Peso" />
                    <h:outputText value="TallaCamisa:"/>
                    <h:inputText id="tallaCamisa" value="#{tDatEmpleado.TDatEmpleado.tallaCamisa}" title="TallaCamisa" />
                    <h:outputText value="TallaPantalon:"/>
                    <h:inputText id="tallaPantalon" value="#{tDatEmpleado.TDatEmpleado.tallaPantalon}" title="TallaPantalon" />
                    <h:outputText value="NoCalzado:"/>
                    <h:inputText id="noCalzado" value="#{tDatEmpleado.TDatEmpleado.noCalzado}" title="NoCalzado" />
                    <h:outputText value="FIngreso (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="FIngreso" value="#{tDatEmpleado.TDatEmpleado.FIngreso}" title="FIngreso" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="Telefono2:"/>
                    <h:inputText id="telefono2" value="#{tDatEmpleado.TDatEmpleado.telefono2}" title="Telefono2" />
                    <h:outputText value="LVivPropia:"/>
                    <h:inputText id="LVivPropia" value="#{tDatEmpleado.TDatEmpleado.LVivPropia}" title="LVivPropia" />
                    <h:outputText value="Alergia:"/>
                    <h:inputText id="alergia" value="#{tDatEmpleado.TDatEmpleado.alergia}" title="Alergia" />
                    <h:outputText value="NoLocNace:"/>
                    <h:inputText id="noLocNace" value="#{tDatEmpleado.TDatEmpleado.noLocNace}" title="NoLocNace" />
                    <h:outputText value="NoLocDir:"/>
                    <h:inputText id="noLocDir" value="#{tDatEmpleado.TDatEmpleado.noLocDir}" title="NoLocDir" />
                    <h:outputText value="NoCabeza:"/>
                    <h:inputText id="noCabeza" value="#{tDatEmpleado.TDatEmpleado.noCabeza}" title="NoCabeza" />
                    <h:outputText value="LUsaLentes:"/>
                    <h:inputText id="LUsaLentes" value="#{tDatEmpleado.TDatEmpleado.LUsaLentes}" title="LUsaLentes" />
                    <h:outputText value="Comisariato:"/>
                    <h:inputText id="comisariato" value="#{tDatEmpleado.TDatEmpleado.comisariato}" title="Comisariato" />
                    <h:outputText value="FReingreso (MM/dd/yyyy HH:mm:ss):"/>
                    <h:inputText id="FReingreso" value="#{tDatEmpleado.TDatEmpleado.FReingreso}" title="FReingreso" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:inputText>
                    <h:outputText value="AliasBaseDatos:"/>
                    <h:inputText id="aliasBaseDatos" value="#{tDatEmpleado.TDatEmpleado.aliasBaseDatos}" title="AliasBaseDatos" />
                    <h:outputText value="PieFirma:"/>
                    <h:inputText id="pieFirma" value="#{tDatEmpleado.TDatEmpleado.pieFirma}" title="PieFirma" />
                    <h:outputText value="NoDirec:"/>
                    <h:inputText id="noDirec" value="#{tDatEmpleado.TDatEmpleado.noDirec}" title="NoDirec" />
                    <h:outputText value="Nivel:"/>
                    <h:inputText id="nivel" value="#{tDatEmpleado.TDatEmpleado.nivel}" title="Nivel" />
                    <h:outputText value="CargoLossca:"/>
                    <h:inputText id="cargoLossca" value="#{tDatEmpleado.TDatEmpleado.cargoLossca}" title="CargoLossca" />
                    <h:outputText value="Patronal:"/>
                    <h:inputText id="patronal" value="#{tDatEmpleado.TDatEmpleado.patronal}" title="Patronal" />
                    <h:outputText value="Personal:"/>
                    <h:inputText id="personal" value="#{tDatEmpleado.TDatEmpleado.personal}" title="Personal" />
                    <h:outputText value="Iece:"/>
                    <h:inputText id="iece" value="#{tDatEmpleado.TDatEmpleado.iece}" title="Iece" />
                    <h:outputText value="Proceso:"/>
                    <h:inputText id="proceso" value="#{tDatEmpleado.TDatEmpleado.proceso}" title="Proceso" />
                    <h:outputText value="Subproceso:"/>
                    <h:inputText id="subproceso" value="#{tDatEmpleado.TDatEmpleado.subproceso}" title="Subproceso" />
                    <h:outputText value="PartidaPresupuestaria:"/>
                    <h:inputText id="partidaPresupuestaria" value="#{tDatEmpleado.TDatEmpleado.partidaPresupuestaria}" title="PartidaPresupuestaria" />
                    <h:outputText value="Gestion:"/>
                    <h:inputText id="gestion" value="#{tDatEmpleado.TDatEmpleado.gestion}" title="Gestion" />
                    <h:outputText value="Unidad:"/>
                    <h:inputText id="unidad" value="#{tDatEmpleado.TDatEmpleado.unidad}" title="Unidad" />
                    <h:outputText value="Email:"/>
                    <h:inputText id="email" value="#{tDatEmpleado.TDatEmpleado.email}" title="Email" />
                    <h:outputText value="LDiscapacidad:"/>
                    <h:inputText id="LDiscapacidad" value="#{tDatEmpleado.TDatEmpleado.LDiscapacidad}" title="LDiscapacidad" />
                    <h:outputText value="NoConadis:"/>
                    <h:inputText id="noConadis" value="#{tDatEmpleado.TDatEmpleado.noConadis}" title="NoConadis" />
                    <h:outputText value="AutoidentificacionEtnica:"/>
                    <h:inputText id="autoidentificacionEtnica" value="#{tDatEmpleado.TDatEmpleado.autoidentificacionEtnica}" title="AutoidentificacionEtnica" />
                    <h:outputText value="NacionalidadIndigena:"/>
                    <h:inputText id="nacionalidadIndigena" value="#{tDatEmpleado.TDatEmpleado.nacionalidadIndigena}" title="NacionalidadIndigena" />
                    <h:outputText value="LCatastrofica:"/>
                    <h:inputText id="LCatastrofica" value="#{tDatEmpleado.TDatEmpleado.LCatastrofica}" title="LCatastrofica" />
                    <h:outputText value="NoConadisCatastrofica:"/>
                    <h:inputText id="noConadisCatastrofica" value="#{tDatEmpleado.TDatEmpleado.noConadisCatastrofica}" title="NoConadisCatastrofica" />
                    <h:outputText value="CalleSecundaria:"/>
                    <h:inputText id="calleSecundaria" value="#{tDatEmpleado.TDatEmpleado.calleSecundaria}" title="CalleSecundaria" />
                    <h:outputText value="Referencia:"/>
                    <h:inputText id="referencia" value="#{tDatEmpleado.TDatEmpleado.referencia}" title="Referencia" />
                    <h:outputText value="Extension:"/>
                    <h:inputText id="extension" value="#{tDatEmpleado.TDatEmpleado.extension}" title="Extension" />
                    <h:outputText value="ContactoApellidos:"/>
                    <h:inputText id="contactoApellidos" value="#{tDatEmpleado.TDatEmpleado.contactoApellidos}" title="ContactoApellidos" />
                    <h:outputText value="ContactoNombres:"/>
                    <h:inputText id="contactoNombres" value="#{tDatEmpleado.TDatEmpleado.contactoNombres}" title="ContactoNombres" />
                    <h:outputText value="ContactoTelefono:"/>
                    <h:inputText id="contactoTelefono" value="#{tDatEmpleado.TDatEmpleado.contactoTelefono}" title="ContactoTelefono" />
                    <h:outputText value="ContactoCelular:"/>
                    <h:inputText id="contactoCelular" value="#{tDatEmpleado.TDatEmpleado.contactoCelular}" title="ContactoCelular" />
                    <h:outputText value="EmailInstitucional:"/>
                    <h:inputText id="emailInstitucional" value="#{tDatEmpleado.TDatEmpleado.emailInstitucional}" title="EmailInstitucional" />
                    <h:outputText value="TContratacionesList:"/>
                    <h:outputText escape="false" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getCollectionAsString'][tDatEmpleado.tDatEmpleado.TContratacionesList == null ? jsfcrud_null : tDatEmpleado.tDatEmpleado.TContratacionesList].jsfcrud_invoke}" title="TContratacionesList" />
                    <h:outputText value="NoLicencia:"/>
                    <h:selectOneMenu id="noLicencia" value="#{tDatEmpleado.TDatEmpleado.noLicencia}" title="NoLicencia" >
                        <f:selectItems value="#{TLicencia.TLicenciaItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="IdNacionalidad:"/>
                    <h:selectOneMenu id="idNacionalidad" value="#{tDatEmpleado.TDatEmpleado.idNacionalidad}" title="IdNacionalidad" >
                        <f:selectItems value="#{TNacionalidad.TNacionalidadItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="NoProfesion:"/>
                    <h:selectOneMenu id="noProfesion" value="#{tDatEmpleado.TDatEmpleado.noProfesion}" title="NoProfesion" >
                        <f:selectItems value="#{TProfesiones.TProfesionesItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="NoRelig:"/>
                    <h:selectOneMenu id="noRelig" value="#{tDatEmpleado.TDatEmpleado.noRelig}" title="NoRelig" >
                        <f:selectItems value="#{TRhReligion.TRhReligionItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="NoSeg:"/>
                    <h:selectOneMenu id="noSeg" value="#{tDatEmpleado.TDatEmpleado.noSeg}" title="NoSeg" >
                        <f:selectItems value="#{TRhTipoSegSocial.TRhTipoSegSocialItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tDatEmpleado.edit}" value="Save">
                    <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tDatEmpleado.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{tDatEmpleado.listSetup}" value="Show All TDatEmpleado Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
