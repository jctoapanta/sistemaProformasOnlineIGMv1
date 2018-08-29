<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>TRhReligion Detail</title>
            <link rel="stylesheet" type="text/css" href="/sistemaProformasOnlineIGMv1-web/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TRhReligion Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="NoRelig:"/>
                    <h:outputText value="#{tRhReligion.TRhReligion.noRelig}" title="NoRelig" />
                    <h:outputText value="Descrip:"/>
                    <h:outputText value="#{tRhReligion.TRhReligion.descrip}" title="Descrip" />

                    <h:outputText value="TDatEmpleadoList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty tRhReligion.TRhReligion.TDatEmpleadoList}" value="(No Items)"/>
                        <h:dataTable value="#{tRhReligion.TRhReligion.TDatEmpleadoList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty tRhReligion.TRhReligion.TDatEmpleadoList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoPersona"/>
                                </f:facet>
                                <h:outputText value="#{item.noPersona}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoProveedor"/>
                                </f:facet>
                                <h:outputText value="#{item.noProveedor}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Codigo"/>
                                </f:facet>
                                <h:outputText value="#{item.codigo}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCedula"/>
                                </f:facet>
                                <h:outputText value="#{item.noCedula}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="PriApellido"/>
                                </f:facet>
                                <h:outputText value="#{item.priApellido}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="SegApellido"/>
                                </f:facet>
                                <h:outputText value="#{item.segApellido}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Nombres"/>
                                </f:facet>
                                <h:outputText value="#{item.nombres}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NombreC"/>
                                </f:facet>
                                <h:outputText value="#{item.nombreC}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="LibMilitar"/>
                                </f:facet>
                                <h:outputText value="#{item.libMilitar}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="SeguroSocial"/>
                                </f:facet>
                                <h:outputText value="#{item.seguroSocial}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Sexo"/>
                                </f:facet>
                                <h:outputText value="#{item.sexo}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="EstCivil"/>
                                </f:facet>
                                <h:outputText value="#{item.estCivil}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="GSangre"/>
                                </f:facet>
                                <h:outputText value="#{item.GSangre}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FNacimiento"/>
                                </f:facet>
                                <h:outputText value="#{item.FNacimiento}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FMuerte"/>
                                </f:facet>
                                <h:outputText value="#{item.FMuerte}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Direccion"/>
                                </f:facet>
                                <h:outputText value="#{item.direccion}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Telefono"/>
                                </f:facet>
                                <h:outputText value="#{item.telefono}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Tipo"/>
                                </f:facet>
                                <h:outputText value="#{item.tipo}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Foto"/>
                                </f:facet>
                                <h:outputText value="#{item.foto}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ColorPiel"/>
                                </f:facet>
                                <h:outputText value="#{item.colorPiel}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ColorCabello"/>
                                </f:facet>
                                <h:outputText value="#{item.colorCabello}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ColorOjos"/>
                                </f:facet>
                                <h:outputText value="#{item.colorOjos}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Estatura"/>
                                </f:facet>
                                <h:outputText value="#{item.estatura}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Peso"/>
                                </f:facet>
                                <h:outputText value="#{item.peso}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TallaCamisa"/>
                                </f:facet>
                                <h:outputText value="#{item.tallaCamisa}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TallaPantalon"/>
                                </f:facet>
                                <h:outputText value="#{item.tallaPantalon}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCalzado"/>
                                </f:facet>
                                <h:outputText value="#{item.noCalzado}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FIngreso"/>
                                </f:facet>
                                <h:outputText value="#{item.FIngreso}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Telefono2"/>
                                </f:facet>
                                <h:outputText value="#{item.telefono2}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="LVivPropia"/>
                                </f:facet>
                                <h:outputText value="#{item.LVivPropia}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Alergia"/>
                                </f:facet>
                                <h:outputText value="#{item.alergia}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoLocNace"/>
                                </f:facet>
                                <h:outputText value="#{item.noLocNace}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoLocDir"/>
                                </f:facet>
                                <h:outputText value="#{item.noLocDir}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoCabeza"/>
                                </f:facet>
                                <h:outputText value="#{item.noCabeza}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="LUsaLentes"/>
                                </f:facet>
                                <h:outputText value="#{item.LUsaLentes}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Comisariato"/>
                                </f:facet>
                                <h:outputText value="#{item.comisariato}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="FReingreso"/>
                                </f:facet>
                                <h:outputText value="#{item.FReingreso}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="AliasBaseDatos"/>
                                </f:facet>
                                <h:outputText value="#{item.aliasBaseDatos}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="PieFirma"/>
                                </f:facet>
                                <h:outputText value="#{item.pieFirma}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoDirec"/>
                                </f:facet>
                                <h:outputText value="#{item.noDirec}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Nivel"/>
                                </f:facet>
                                <h:outputText value="#{item.nivel}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CargoLossca"/>
                                </f:facet>
                                <h:outputText value="#{item.cargoLossca}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Patronal"/>
                                </f:facet>
                                <h:outputText value="#{item.patronal}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Personal"/>
                                </f:facet>
                                <h:outputText value="#{item.personal}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Iece"/>
                                </f:facet>
                                <h:outputText value="#{item.iece}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Proceso"/>
                                </f:facet>
                                <h:outputText value="#{item.proceso}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Subproceso"/>
                                </f:facet>
                                <h:outputText value="#{item.subproceso}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="PartidaPresupuestaria"/>
                                </f:facet>
                                <h:outputText value="#{item.partidaPresupuestaria}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Gestion"/>
                                </f:facet>
                                <h:outputText value="#{item.gestion}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Unidad"/>
                                </f:facet>
                                <h:outputText value="#{item.unidad}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Email"/>
                                </f:facet>
                                <h:outputText value="#{item.email}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="LDiscapacidad"/>
                                </f:facet>
                                <h:outputText value="#{item.LDiscapacidad}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoConadis"/>
                                </f:facet>
                                <h:outputText value="#{item.noConadis}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="AutoidentificacionEtnica"/>
                                </f:facet>
                                <h:outputText value="#{item.autoidentificacionEtnica}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NacionalidadIndigena"/>
                                </f:facet>
                                <h:outputText value="#{item.nacionalidadIndigena}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="LCatastrofica"/>
                                </f:facet>
                                <h:outputText value="#{item.LCatastrofica}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoConadisCatastrofica"/>
                                </f:facet>
                                <h:outputText value="#{item.noConadisCatastrofica}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="CalleSecundaria"/>
                                </f:facet>
                                <h:outputText value="#{item.calleSecundaria}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Referencia"/>
                                </f:facet>
                                <h:outputText value="#{item.referencia}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Extension"/>
                                </f:facet>
                                <h:outputText value="#{item.extension}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ContactoApellidos"/>
                                </f:facet>
                                <h:outputText value="#{item.contactoApellidos}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ContactoNombres"/>
                                </f:facet>
                                <h:outputText value="#{item.contactoNombres}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ContactoTelefono"/>
                                </f:facet>
                                <h:outputText value="#{item.contactoTelefono}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ContactoCelular"/>
                                </f:facet>
                                <h:outputText value="#{item.contactoCelular}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="EmailInstitucional"/>
                                </f:facet>
                                <h:outputText value="#{item.emailInstitucional}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoLicencia"/>
                                </f:facet>
                                <h:outputText value="#{item.noLicencia}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="IdNacionalidad"/>
                                </f:facet>
                                <h:outputText value="#{item.idNacionalidad}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoProfesion"/>
                                </f:facet>
                                <h:outputText value="#{item.noProfesion}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoRelig"/>
                                </f:facet>
                                <h:outputText value="#{item.noRelig}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="NoSeg"/>
                                </f:facet>
                                <h:outputText value="#{item.noSeg}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{tDatEmpleado.detailSetup}">
                                    <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tRhReligion.TRhReligion][tRhReligion.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tRhReligion" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TRhReligionController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{tDatEmpleado.editSetup}">
                                    <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tRhReligion.TRhReligion][tRhReligion.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tRhReligion" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TRhReligionController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{tDatEmpleado.destroy}">
                                    <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tRhReligion.TRhReligion][tRhReligion.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTDatEmpleado" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tDatEmpleado.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="tRhReligion" />
                                    <f:param name="jsfcrud.relatedControllerType" value="rh.gob.igm.ec.controladores.TRhReligionController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{TRhReligion.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tRhReligion.TRhReligion][tRhReligion.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{TRhReligion.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentTRhReligion" value="#{jsfcrud_class['rh.gob.igm.ec.controladores.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tRhReligion.TRhReligion][tRhReligion.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{TRhReligion.createSetup}" value="New TRhReligion" />
                <br />
                <h:commandLink action="#{TRhReligion.listSetup}" value="Show All TRhReligion Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
