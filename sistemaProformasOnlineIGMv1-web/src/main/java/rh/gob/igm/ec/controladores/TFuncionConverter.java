/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec.controladores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import rh.gob.igm.ec.TFuncion;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TFuncionConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Short id = new Short(string);
        TFuncionController controller = (TFuncionController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tFuncion");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof TFuncion) {
            TFuncion o = (TFuncion) object;
            return o.getNoFuncion() == null ? "" : o.getNoFuncion().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: rh.gob.igm.ec.TFuncion");
        }
    }
    
}
