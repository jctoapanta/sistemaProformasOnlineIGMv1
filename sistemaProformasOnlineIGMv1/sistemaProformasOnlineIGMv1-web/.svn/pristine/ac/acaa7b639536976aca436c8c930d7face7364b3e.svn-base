package gob.igm.ec.controladores.util;


import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.CloseEvent;

@Named
@ViewScoped
public class TestBean implements Serializable {


   public void close(CloseEvent event) {
      event.getComponent().getChildren().clear();
   }


}