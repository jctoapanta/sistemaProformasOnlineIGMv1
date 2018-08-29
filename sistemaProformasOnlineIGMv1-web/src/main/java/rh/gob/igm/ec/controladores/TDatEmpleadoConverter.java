/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec.controladores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import rh.gob.igm.ec.TDatEmpleado;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TDatEmpleadoConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Integer id = new Integer(string);
        TDatEmpleadoController controller = (TDatEmpleadoController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tDatEmpleado");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof TDatEmpleado) {
            TDatEmpleado o = (TDatEmpleado) object;
            return o.getNoPersona() == null ? "" : o.getNoPersona().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: rh.gob.igm.ec.TDatEmpleado");
        }
    }
    
}
