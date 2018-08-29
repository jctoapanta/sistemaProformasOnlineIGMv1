<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>TDatEmpleado Detail</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TDatEmpleado Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="NoPersona:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.noPersona}" title="NoPersona" />
                    <h:outputText value="NoProveedor:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.noProveedor}" title="NoProveedor" />
                    <h:outputText value="Codigo:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.codigo}" title="Codigo" />
                    <h:outputText value="NoCedula:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.noCedula}" title="NoCedula" />
                    <h:outputText value="PriApellido:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.priApellido}" title="PriApellido" />
                    <h:outputText value="SegApellido:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.segApellido}" title="SegApellido" />
                    <h:outputText value="Nombres:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.nombres}" title="Nombres" />
                    <h:outputText value="NombreC:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.nombreC}" title="NombreC" />
                    <h:outputText value="LibMilitar:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.libMilitar}" title="LibMilitar" />
                    <h:outputText value="SeguroSocial:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.seguroSocial}" title="SeguroSocial" />
                    <h:outputText value="Sexo:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.sexo}" title="Sexo" />
                    <h:outputText value="EstCivil:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.estCivil}" title="EstCivil" />
                    <h:outputText value="GSangre:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.GSangre}" title="GSangre" />
                    <h:outputText value="FNacimiento:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.FNacimiento}" title="FNacimiento" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="FMuerte:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.FMuerte}" title="FMuerte" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="Direccion:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.direccion}" title="Direccion" />
                    <h:outputText value="Telefono:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.telefono}" title="Telefono" />
                    <h:outputText value="Tipo:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.tipo}" title="Tipo" />
                    <h:outputText value="Foto:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.foto}" title="Foto" />
                    <h:outputText value="ColorPiel:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.colorPiel}" title="ColorPiel" />
                    <h:outputText value="ColorCabello:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.colorCabello}" title="ColorCabello" />
                    <h:outputText value="ColorOjos:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.colorOjos}" title="ColorOjos" />
                    <h:outputText value="Estatura:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.estatura}" title="Estatura" />
                    <h:outputText value="Peso:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.peso}" title="Peso" />
                    <h:outputText value="TallaCamisa:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.tallaCamisa}" title="TallaCamisa" />
                    <h:outputText value="TallaPantalon:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.tallaPantalon}" title="TallaPantalon" />
                    <h:outputText value="NoCalzado:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.noCalzado}" title="NoCalzado" />
                    <h:outputText value="FIngreso:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.FIngreso}" title="FIngreso" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="Telefono2:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.telefono2}" title="Telefono2" />
                    <h:outputText value="LVivPropia:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.LVivPropia}" title="LVivPropia" />
                    <h:outputText value="Alergia:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.alergia}" title="Alergia" />
                    <h:outputText value="NoLocNace:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.noLocNace}" title="NoLocNace" />
                    <h:outputText value="NoLocDir:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.noLocDir}" title="NoLocDir" />
                    <h:outputText value="NoCabeza:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.noCabeza}" title="NoCabeza" />
                    <h:outputText value="LUsaLentes:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.LUsaLentes}" title="LUsaLentes" />
                    <h:outputText value="Comisariato:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.comisariato}" title="Comisariato" />
                    <h:outputText value="FReingreso:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.FReingreso}" title="FReingreso" >
                        <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                    </h:outputText>
                    <h:outputText value="AliasBaseDatos:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.aliasBaseDatos}" title="AliasBaseDatos" />
                    <h:outputText value="PieFirma:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.pieFirma}" title="PieFirma" />
                    <h:outputText value="NoDirec:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.noDirec}" title="NoDirec" />
                    <h:outputText value="Nivel:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.nivel}" title="Nivel" />
                    <h:outputText value="CargoLossca:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.cargoLossca}" title="CargoLossca" />
                    <h:outputText value="Patronal:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.patronal}" title="Patronal" />
                    <h:outputText value="Personal:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.personal}" title="Personal" />
                    <h:outputText value="Iece:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.iece}" title="Iece" />
                    <h:outputText value="Proceso:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.proceso}" title="Proceso" />
                    <h:outputText value="Subproceso:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.subproceso}" title="Subproceso" />
                    <h:outputText value="PartidaPresupuestaria:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.partidaPresupuestaria}" title="PartidaPresupuestaria" />
                    <h:outputText value="Gestion:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.gestion}" title="Gestion" />
                    <h:outputText value="Unidad:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.unidad}" title="Unidad" />
                    <h:outputText value="Email:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.email}" title="Email" />
                    <h:outputText value="LDiscapacidad:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.LDiscapacidad}" title="LDiscapacidad" />
                    <h:outputText value="NoConadis:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.noConadis}" title="NoConadis" />
                    <h:outputText value="AutoidentificacionEtnica:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.autoidentificacionEtnica}" title="AutoidentificacionEtnica" />
                    <h:outputText value="NacionalidadIndigena:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.nacionalidadIndigena}" title="NacionalidadIndigena" />
                    <h:outputText value="LCatastrofica:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.LCatastrofica}" title="LCatastrofica" />
                    <h:outputText value="NoConadisCatastrofica:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.noConadisCatastrofica}" title="NoConadisCatastrofica" />
                    <h:outputText value="CalleSecundaria:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.calleSecundaria}" title="CalleSecundaria" />
                    <h:outputText value="Referencia:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.referencia}" title="Referencia" />
                    <h:outputText value="Extension:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.extension}" title="Extension" />
                    <h:outputText value="ContactoApellidos:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.contactoApellidos}" title="ContactoApellidos" />
                    <h:outputText value="ContactoNombres:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.contactoNombres}" title="ContactoNombres" />
                    <h:outputText value="ContactoTelefono:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.contactoTelefono}" title="ContactoTelefono" />
                    <h:outputText value="ContactoCelular:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.contactoCelular}" title="ContactoCelular" />
                    <h:outputText value="EmailInstitucional:"/>
                    <h:outputText value="#{tDatEmpleado.TDatEmpleado.emailInstitucional}" title="EmailInstitucional" />
                    <h:outputText value="NoLicencia:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tDatEmpleado.TDatEmpleado.noLicencia}"/>
                        <h:panelGroup rendered="#{tDatEmpleado.TDatEmpleado.noLicencia != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TLicencia.detailSetup}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTLicencia" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noLicencia][TLicencia.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TLicencia.editSetup}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTLicencia" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noLicencia][TLicencia.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TLicencia.destroy}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTLicencia" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noLicencia][TLicencia.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="IdNacionalidad:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tDatEmpleado.TDatEmpleado.idNacionalidad}"/>
                        <h:panelGroup rendered="#{tDatEmpleado.TDatEmpleado.idNacionalidad != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TNacionalidad.detailSetup}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTNacionalidad" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.idNacionalidad][TNacionalidad.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TNacionalidad.editSetup}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTNacionalidad" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.idNacionalidad][TNacionalidad.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TNacionalidad.destroy}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTNacionalidad" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.idNacionalidad][TNacionalidad.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="NoProfesion:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tDatEmpleado.TDatEmpleado.noProfesion}"/>
                        <h:panelGroup rendered="#{tDatEmpleado.TDatEmpleado.noProfesion != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TProfesiones.detailSetup}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTProfesiones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noProfesion][TProfesiones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TProfesiones.editSetup}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTProfesiones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noProfesion][TProfesiones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TProfesiones.destroy}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTProfesiones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noProfesion][TProfesiones.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="NoRelig:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tDatEmpleado.TDatEmpleado.noRelig}"/>
                        <h:panelGroup rendered="#{tDatEmpleado.TDatEmpleado.noRelig != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TRhReligion.detailSetup}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noRelig][TRhReligion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TRhReligion.editSetup}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noRelig][TRhReligion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TRhReligion.destroy}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noRelig][TRhReligion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="NoSeg:"/>
                    <h:panelGroup>
                        <h:outputText value="#{tDatEmpleado.TDatEmpleado.noSeg}"/>
                        <h:panelGroup rendered="#{tDatEmpleado.TDatEmpleado.noSeg != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{TRhTipoSegSocial.detailSetup}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTRhTipoSegSocial" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noSeg][TRhTipoSegSocial.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{TRhTipoSegSocial.editSetup}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTRhTipoSegSocial" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noSeg][TRhTipoSegSocial.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{TRhTipoSegSocial.destroy}">
                                <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTRhTipoSegSocial" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado.noSeg][TRhTipoSegSocial.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="tDatEmpleado"/>
                                <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>

                    <h:outputText value="TContratacionesList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty tDatEmpleado.TDatEmpleado.TContratacionesList}" value="(No Items)"/>
                        <h:dataTable value="#{tDatEmpleado.TDatEmpleado.TContratacionesList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty tDatEmpleado.TDatEmpleado.TContratacionesList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCont"/>
                                </f:facet>
                                <h:outputText value="#{item.TContratacionesPK.noCont}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoDoc"/>
                                </f:facet>
                                <h:outputText value="#{item.noDoc}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Responsable"/>
                                </f:facet>
                                <h:outputText value="#{item.responsable}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Nivel"/>
                                </f:facet>
                                <h:outputText value="#{item.nivel}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Categoria"/>
                                </f:facet>
                                <h:outputText value="#{item.categoria}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoEmp"/>
                                </f:facet>
                                <h:outputText value="#{item.noEmp}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FContrato"/>
                                </f:facet>
                                <h:outputText value="#{item.FContrato}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FSalida"/>
                                </f:facet>
                                <h:outputText value="#{item.FSalida}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TSalida"/>
                                </f:facet>
                                <h:outputText value="#{item.TSalida}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Estado"/>
                                </f:facet>
                                <h:outputText value="#{item.estado}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CMoneda"/>
                                </f:facet>
                                <h:outputText value="#{item.CMoneda}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="VSueldoImponible"/>
                                </f:facet>
                                <h:outputText value="#{item.VSueldoImponible}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CostoHora"/>
                                </f:facet>
                                <h:outputText value="#{item.costoHora}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CostoHoraExtra"/>
                                </f:facet>
                                <h:outputText value="#{item.costoHoraExtra}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoBanco"/>
                                </f:facet>
                                <h:outputText value="#{item.noBanco}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCta"/>
                                </f:facet>
                                <h:outputText value="#{item.noCta}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="LLicencia"/>
                                </f:facet>
                                <h:outputText value="#{item.LLicencia}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="DiasLicencia"/>
                                </f:facet>
                                <h:outputText value="#{item.diasLicencia}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="DiasUtilizados"/>
                                </f:facet>
                                <h:outputText value="#{item.diasUtilizados}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="HoraIngreso"/>
                                </f:facet>
                                <h:outputText value="#{item.horaIngreso}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="HoraSalida"/>
                                </f:facet>
                                <h:outputText value="#{item.horaSalida}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="LGeneraRol"/>
                                </f:facet>
                                <h:outputText value="#{item.LGeneraRol}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Obs"/>
                                </f:facet>
                                <h:outputText value="#{item.obs}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoEmpPre"/>
                                </f:facet>
                                <h:outputText value="#{item.noEmpPre}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCdPre"/>
                                </f:facet>
                                <h:outputText value="#{item.noCdPre}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCargo"/>
                                </f:facet>
                                <h:outputText value="#{item.noCargo}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="VSueldoImponibleSuc"/>
                                </f:facet>
                                <h:outputText value="#{item.VSueldoImponibleSuc}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CostoHoraSuc"/>
                                </f:facet>
                                <h:outputText value="#{item.costoHoraSuc}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CostoHoraExtraSuc"/>
                                </f:facet>
                                <h:outputText value="#{item.costoHoraExtraSuc}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ManoObra"/>
                                </f:facet>
                                <h:outputText value="#{item.manoObra}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ProyectoCodigo"/>
                                </f:facet>
                                <h:outputText value="#{item.proyectoCodigo}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TipoViatico"/>
                                </f:facet>
                                <h:outputText value="#{item.tipoViatico}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCdPreAnt"/>
                                </f:facet>
                                <h:outputText value="#{item.noCdPreAnt}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NivelAprobacion"/>
                                </f:facet>
                                <h:outputText value="#{item.nivelAprobacion}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Rmu"/>
                                </f:facet>
                                <h:outputText value="#{item.rmu}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TAreas"/>
                                </f:facet>
                                <h:outputText value="#{item.TAreas}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TDatEmpleado"/>
                                </f:facet>
                                <h:outputText value="#{item.TDatEmpleado}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoFuncion"/>
                                </f:facet>
                                <h:outputText value="#{item.noFuncion}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CContrato"/>
                                </f:facet>
                                <h:outputText value="#{item.CContrato}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{tContrataciones.detailSetup}">
                                    <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tContrataciones.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tDatEmpleado" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{tContrataciones.editSetup}">
                                    <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tContrataciones.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tDatEmpleado" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{tContrataciones.destroy}">
                                    <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTContrataciones" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tContrataciones.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tDatEmpleado" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TDatEmpleadoController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{TDatEmpleado.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{TDatEmpleado.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tDatEmpleado.TDatEmpleado][tDatEmpleado.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{TDatEmpleado.createSetup}" value="New TDatEmpleado" />
                <br />
                <h:commandLink action="#{TDatEmpleado.listSetup}" value="Show All TDatEmpleado Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
