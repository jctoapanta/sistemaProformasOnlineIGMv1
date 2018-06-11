/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.controladores;

/**
 *
 * @author PULE_DIEGO
 */
import gob.igm.ec.Tdetproforma;
import gob.igm.ec.TdetproformaPK;
import gob.igm.ec.Tentidad;
import gob.igm.ec.Titem;
import gob.igm.ec.Tproforma;
import gob.igm.ec.TproformaPK;
import gob.igm.ec.servicios.TcontrolIvaFacade;
import gob.igm.ec.servicios.TdetproformaFacade;
import gob.igm.ec.servicios.TitemServicio;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;




import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.model.SelectItem;
import org.apache.log4j.Logger;

@ManagedBean(name = "order")
@SessionScoped
public class OrderBean implements Serializable {

    @EJB
    private TdetproformaFacade tdetproformaFacade;

    @EJB
    private TcontrolIvaFacade tcontrolIvaFacade;
    @EJB
    private gob.igm.ec.servicios.TproformaFacade ejbFacade;
    
    private Tproforma selected = new Tproforma();
    private TproformaPK proformapk = new TproformaPK();
    private TdetproformaPK detproformapk = new TdetproformaPK();
    private List<Tdetproforma> detalleProformas = new ArrayList();
    private Tdetproforma detalleproforma = new Tdetproforma();
    private Collection<Tdetproforma> tdetproformaCollection = new ArrayList<>();
    private HtmlInputHidden ciuH = new HtmlInputHidden();
    private static final long serialVersionUID = 1L;
    private List<Titem> listaitems;
    @EJB
    
        
    private TitemServicio titemServicio;
    private Titem item = new Titem();
    String descripcion;
    //String productName;
    BigDecimal cantidad;
    BigDecimal total;
    BigInteger iva;
    private BigDecimal piva;
    
    private int seleccionadoItem;
    private Tentidad entidad = new Tentidad();
    private BigDecimal totalp = BigDecimal.ZERO;
    private BigInteger mostrariva;
     private static Logger logger;
    
    
    @ManagedBean
    public class GrowlView {

        private String message;
      
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + message) );
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    }
    }       
    public OrderBean() {
        this.listaitems = new ArrayList<>();
    }

    /**
     * @return the mostrariva
     */
    public BigInteger getMostrariva() {
        return mostrariva;
    }

    /**
     * @param mostrariva the mostrariva to set
     */
    public void setMostrariva(BigInteger mostrariva) {
        this.mostrariva = mostrariva;
    }

    /**
     * @return the piva
     */
    public BigDecimal getPiva() {
        return piva;
    }

    /**
     * @param piva the piva to set
     */
    public void setPiva(BigDecimal piva) {
        this.piva = piva;
    }

    /**
     * @return the totalp
     */
    public BigDecimal getTotalp() {
        return totalp;
    }

    /**
     * @param totalp the totalp to set
     */
    public void setTotalp(BigDecimal totalp) {
        this.totalp = totalp;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCantidad() {
        //this.cantidad = BigDecimal.ONE;
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigInteger getIva() {
        return iva;
    }

    public void setIva(BigInteger iva) {
        this.iva = iva;
    }

    private static final ArrayList<Order> ORDERLIST = new ArrayList<Order>();

    public ArrayList<Order> getOrderList() {

        return ORDERLIST;

    }

    public String addAction() {
        try {
            item = titemServicio.getDatos(this.getSeleccionadoItem());
            //this.piva=BigDecimal.valueOf(0.12);
            BigDecimal cien=new BigDecimal("100");
           
            this.piva=tcontrolIvaFacade.recuperaIva().divide(cien);
            //this.piva=BigDecimal.valueOf(this.mostrariva.longValue());
            Order order = new Order(item.getDescItem(), this.cantidad, item.getCosto(), this.piva);
            ORDERLIST.add(order);
            this.totalp = (((this.cantidad.multiply(item.getCosto())).multiply(this.piva.add(BigDecimal.valueOf(1)))).add(this.totalp)).setScale(2, BigDecimal.ROUND_UP);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }

    public String deleteAction(Order order) {
        ORDERLIST.remove(order);
        this.totalp = this.totalp.subtract((order.cantidad.multiply(order.total)).multiply(order.piva.add(BigDecimal.valueOf(1))));
        return null;
    }

       short reg = 1;   
    public String addProforma() {
        try {
            Date fechaActual = new Date();
            Short vIdPeriodo;
            Short vOnline = 1;
            String regla = "/tdireccionesusr/List.xhtml";

            vIdPeriodo = Short.parseShort(new SimpleDateFormat("yy").format(fechaActual));
            this.proformapk.setIdPeriodo(vIdPeriodo);
            this.proformapk.setIdSucursal(1L);
            this.proformapk.setIdProforma(this.ejbFacade.maxId() + 1L);
            this.selected.setTproformaPK(this.proformapk);
            entidad.setCiu(this.getCiuH().getValue().toString());
            this.selected.setCiu(entidad);
            this.selected.setEstado("P");
            this.selected.setTipoProforma("OP");
            this.selected.setFechaCreacion(fechaActual);
            this.selected.setLVentaOnline(vOnline);
             this.ejbFacade.create(selected);
            this.detalleProformas = new ArrayList();
            
            for (Order order : ORDERLIST) {
              
                reg++;
                detalleproforma.setCantidad(order.getCantidad());
                detalleproforma.setDetalleItem(order.getDescripcion());
                detalleproforma.setIdItem(item);
                detalleproforma.setIvaPorcentaje(BigDecimal.valueOf(0.12));
                detalleproforma.setPvpTotal(this.getTotalp());
                this.detproformapk.setIdPeriodo(vIdPeriodo);
                this.detproformapk.setIdProforma(this.proformapk.getIdProforma());
                this.detproformapk.setIdSucursal(1L);
                this.detproformapk.setNoReg(reg);
                detalleproforma.setTdetproformaPK(detproformapk);
                this.tdetproformaFacade.create(detalleproforma);
                //this.detalleProformas.add(detalleproforma);
            }

            //this.selected.setTdetproformaCollection(this.detalleProformas);
           
            return regla;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            
        }
        return null;
    }

    /**
     * @return the listaitems
     */
    public List<SelectItem> getItems() {
        listaitems = titemServicio.findAll();
        List<SelectItem> principales = new ArrayList<SelectItem>();
        for (Titem itemp : listaitems) {
            SelectItem selectItem = new SelectItem(itemp.getIdItem(), itemp.getDescItem());
            principales.add(selectItem);
        }
        return principales;
        //return listaitems;
    }

    /**
     * @param listaitems the listaitems to set
     */
    public void setListaitems(List<Titem> listaitems) {
        this.listaitems = listaitems;
    }

    /**
     * @return the seleccionadoItem
     */
    public int getSeleccionadoItem() {
        return seleccionadoItem;
    }

    /**
     * @param seleccionadoItem the seleccionadoItem to set
     */
    public void setSeleccionadoItem(int seleccionadoItem) {
        this.seleccionadoItem = seleccionadoItem;
    }

    /**
     * @return the entidad
     */
    public Tentidad getEntidad() {

        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Tentidad entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the selected
     */
    public Tproforma getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(Tproforma selected) {
        this.selected = selected;
    }

    /**
     * @return the ciuH
     */
    public HtmlInputHidden getCiuH() {
        return ciuH;
    }

    /**
     * @param ciuH the ciuH to set
     */
    public void setCiuH(HtmlInputHidden ciuH) {
        this.ciuH = ciuH;
    }

    public static class Order {
        String descripcion;
        BigDecimal cantidad;
        BigDecimal total;
        BigInteger iva;
        BigDecimal bigdec;
        private BigInteger mostrariva;
        private Tentidad entidad = new Tentidad();
        private BigDecimal piva;

        /**
         * @return the mostrariva
         */
        public BigInteger getMostrariva() {
            return mostrariva;
        }

        /**
         * @param mostrariva the mostrariva to set
         */
        public void setMostrariva(BigInteger mostrariva) {
            this.mostrariva = mostrariva;
        }

        /**
         * @return the piva
         */
        public BigDecimal getPiva() {
            return piva;
        }

        /**
         * @param piva the piva to set
         */
        public void setPiva(BigDecimal piva) {
            this.piva = piva;
        }


        public Order() {
            ciuH = new HtmlInputHidden();
        }

        public Order(String descripcion, BigDecimal cantidad, BigDecimal total, BigDecimal piva) {
            this.descripcion = descripcion;
            this.cantidad = cantidad;
            this.total = total;
            //this.iva = iva;
            this.piva = piva;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public BigDecimal getCantidad() {
            //detalleproforma.setCantidad(BigDecimal.ONE);
            //return this.setCantidad(BigDecimal.ONE);
            return cantidad;
        }

        public void setCantidad(BigDecimal cantidad) {
            this.cantidad = cantidad;
        }

        public BigDecimal getTotal() {
            return total;
        }

        public void setTotal(BigDecimal total) {
            this.total = total;
        }

        public BigInteger getIva() {
            return iva;
        }

        public void setIva(BigInteger iva) {
            this.iva = iva;
        }
        //String productName;

        public Tentidad getEntidad() {
            return entidad;
        }

        public void setEntidad(Tentidad entidad) {
            this.entidad = entidad;
        }

        private HtmlInputHidden ciuH;

        /**
         * @return the ciuH
         */
        public HtmlInputHidden getCiuH() {
            return ciuH;
        }

        /**
         * @param ciuH the ciuH to set
         */
        public void setCiuH(HtmlInputHidden ciuH) {
            this.ciuH = ciuH;
        }
    }
}