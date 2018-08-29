/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec.controladores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import rh.gob.igm.ec.TNacionalidad;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TNacionalidadConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Short id = new Short(string);
        TNacionalidadController controller = (TNacionalidadController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tNacionalidad");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof TNacionalidad) {
            TNacionalidad o = (TNacionalidad) object;
            return o.getIdNacionalidad() == null ? "" : o.getIdNacionalidad().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: rh.gob.igm.ec.TNacionalidad");
        }
    }
    
}
