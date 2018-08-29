/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec.controladores;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import rh.gob.igm.ec.TContrataciones;
import rh.gob.igm.ec.TContratacionesPK;
import rh.gob.igm.ec.servicios.TContratacionesFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TContratacionesConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        TContratacionesPK id = getId(string);
        TContratacionesController controller = (TContratacionesController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tContrataciones");
        return controller.getJpaController().find(id);
    }

    TContratacionesPK getId(String string) {
        TContratacionesPK id = new TContratacionesPK();
        String[] params = new String[2];
        int p = 0;
        int grabStart = 0;
        String delim = "#";
        String escape = "~";
        Pattern pattern = Pattern.compile(escape + "*" + delim);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String found = matcher.group();
            if (found.length() % 2 == 1) {
                params[p] = string.substring(grabStart, matcher.start());
                p++;
                grabStart = matcher.end();
            }
        }
        if (p != params.length - 1) {
            throw new IllegalArgumentException("string " + string + " is not in expected format. expected 2 ids delimited by " + delim);
        }
        params[p] = string.substring(grabStart);
        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].replace(escape + delim, delim);
            params[i] = params[i].replace(escape + escape, escape);
        }
        id.setNoPersona(Integer.parseInt(params[0]));
        id.setNoCont(Integer.parseInt(params[1]));
        return id;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof TContrataciones) {
            TContrataciones o = (TContrataciones) object;
            TContratacionesPK id = o.getTContratacionesPK();
            if (id == null) {
                return "";
            }
            String delim = "#";
            String escape = "~";
            String noPersona = String.valueOf(id.getNoPersona());
            noPersona = noPersona.replace(escape, escape + escape);
            noPersona = noPersona.replace(delim, escape + delim);
            String noCont = String.valueOf(id.getNoCont());
            noCont = noCont.replace(escape, escape + escape);
            noCont = noCont.replace(delim, escape + delim);
            return noPersona + delim + noCont;
            // TODO: no setter methods were found in your primary key class
            //    rh.gob.igm.ec.TContratacionesPK
            // and therefore getAsString() method could not be pre-generated.
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: rh.gob.igm.ec.TContrataciones");
        }
    }
    
}
