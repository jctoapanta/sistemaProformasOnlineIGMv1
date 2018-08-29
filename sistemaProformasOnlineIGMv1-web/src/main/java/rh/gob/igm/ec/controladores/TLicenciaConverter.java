/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec.controladores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import rh.gob.igm.ec.TLicencia;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TLicenciaConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Short id = new Short(string);
        TLicenciaController controller = (TLicenciaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tLicencia");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof TLicencia) {
            TLicencia o = (TLicencia) object;
            return o.getNoLicencia() == null ? "" : o.getNoLicencia().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: rh.gob.igm.ec.TLicencia");
        }
    }
    
}
