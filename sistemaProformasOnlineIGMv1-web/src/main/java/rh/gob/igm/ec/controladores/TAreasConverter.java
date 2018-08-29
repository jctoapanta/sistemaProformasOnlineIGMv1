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
import rh.gob.igm.ec.TAreas;
import rh.gob.igm.ec.TAreasPK;
import rh.gob.igm.ec.servicios.TAreasFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TAreasConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        TAreasPK id = getId(string);
        TAreasController controller = (TAreasController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tAreas");
        return controller.getJpaController().find(id);
    }

    TAreasPK getId(String string) {
        TAreasPK id = new TAreasPK();
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
        id.setNoCd(Short.parseShort(params[0]));
        id.setNoEmpMatriz(Short.parseShort(params[1]));
        return id;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof TAreas) {
            TAreas o = (TAreas) object;
            TAreasPK id = o.getTAreasPK();
            if (id == null) {
                return "";
            }
            String delim = "#";
            String escape = "~";
            Object noCdObj = id.getNoCd();
            String noCd = noCdObj == null ? "" : String.valueOf(noCdObj);
            noCd = noCd.replace(escape, escape + escape);
            noCd = noCd.replace(delim, escape + delim);
            Object noEmpMatrizObj = id.getNoEmpMatriz();
            String noEmpMatriz = noEmpMatrizObj == null ? "" : String.valueOf(noEmpMatrizObj);
            noEmpMatriz = noEmpMatriz.replace(escape, escape + escape);
            noEmpMatriz = noEmpMatriz.replace(delim, escape + delim);
            return noCd + delim + noEmpMatriz;
            // TODO: no setter methods were found in your primary key class
            //    rh.gob.igm.ec.TAreasPK
            // and therefore getAsString() method could not be pre-generated.
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: rh.gob.igm.ec.TAreas");
        }
    }
    
}
