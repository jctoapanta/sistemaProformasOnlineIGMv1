/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec.controladores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import rh.gob.igm.ec.TProfesiones;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TProfesionesConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Short id = new Short(string);
        TProfesionesController controller = (TProfesionesController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tProfesiones");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof TProfesiones) {
            TProfesiones o = (TProfesiones) object;
            return o.getNoProfesion() == null ? "" : o.getNoProfesion().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: rh.gob.igm.ec.TProfesiones");
        }
    }
    
}
