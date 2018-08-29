/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec.controladores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import rh.gob.igm.ec.TRhReligion;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TRhReligionConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Short id = new Short(string);
        TRhReligionController controller = (TRhReligionController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tRhReligion");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof TRhReligion) {
            TRhReligion o = (TRhReligion) object;
            return o.getNoRelig() == null ? "" : o.getNoRelig().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: rh.gob.igm.ec.TRhReligion");
        }
    }
    
}
