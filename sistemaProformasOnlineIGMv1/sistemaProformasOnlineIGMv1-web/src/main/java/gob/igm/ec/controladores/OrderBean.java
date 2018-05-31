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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.model.SelectItem;
 
@ManagedBean(name="order")
@SessionScoped
public class OrderBean implements Serializable{

    /**
     * @return the mostrariva
     */
    public BigDecimal getMostrariva() {
        return mostrariva;
    }

    /**
     * @param mostrariva the mostrariva to set
     */
    public void setMostrariva(BigDecimal mostrariva) {
        this.mostrariva = mostrariva;
    }
    @EJB
    private gob.igm.ec.servicios.TproformaFacade ejbFacade;
    private Tproforma selected=new Tproforma();
    private TproformaPK proformapk=new TproformaPK();
    private TdetproformaPK detproformapk=new TdetproformaPK(); 
    private List<Tdetproforma> detalleProformas=new ArrayList();
    private Tdetproforma detalleproforma=new Tdetproforma();
    private Collection<Tdetproforma> tdetproformaCollection=new ArrayList<Tdetproforma>();
    private HtmlInputHidden ciuH=new HtmlInputHidden();;
    private BigDecimal mostrariva;
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

	private static final long serialVersionUID = 1L;
        private List<Titem> listaitems=new ArrayList<Titem>();
        @EJB
        private TitemServicio titemServicio;
        private Titem item=new Titem();
	String descripcion;
		//String productName;
		BigDecimal cantidad;
                BigDecimal total;
                BigInteger iva;
                private BigDecimal piva;
                private int seleccionadoItem;
                private Tentidad entidad=new Tentidad();
                private BigDecimal totalp=BigDecimal.ZERO;
           
               
               

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCantidad() {
        this.cantidad=BigDecimal.ONE;
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
              
	private static final ArrayList<Order> orderList = new ArrayList<Order>();

	 
	public ArrayList<Order> getOrderList() {
 
		return orderList;
 
	}
        
  
	public String addAction() {
            try{
	        item=titemServicio.getDatos(this.getSeleccionadoItem());
               
		Order order = new Order(item.getDescItem(), this.cantidad,item.getPvp(),this.piva);
		orderList.add(order);
              //  this.piva = ((this.cantidad.multiply(item.getPvp())).multiply(BigDecimal.valueOf(0.12)));
                //this.totalp = ((this.cantidad.multiply(item.getPvp())).add(this.totalp)).add(BigDecimal.valueOf(0.12));
		
		
            }catch( Exception e ){System.out.print(e.getMessage());}
               return null;     
	}
 
	public String deleteAction(Order order) {
	    
		orderList.remove(order);
                 this.totalp = ((this.totalp).subtract( (this.cantidad.multiply(item.getPvp())))).subtract(BigDecimal.valueOf(0.12));
		;
                         return null;
	}
        
        public String addProforma(){
            try{
                Date fechaActual = new Date();
                Short vIdPeriodo;
                Short vOnline=1;
               
                vIdPeriodo = Short.parseShort(new SimpleDateFormat("yy").format(fechaActual));
                this.proformapk.setIdPeriodo(vIdPeriodo);
                this.proformapk.setIdSucursal(1L);
                this.proformapk.setIdProforma(this.ejbFacade.maxId()+1L);
	        this.selected.setTproformaPK(this.proformapk);
                entidad.setCiu(this.getCiuH().getValue().toString());
                this.selected.setCiu(entidad);
                this.selected.setEstado("P");
                this.selected.setTipoProforma("OP");
                this.selected.setFechaCreacion(fechaActual);
                this.selected.setLVentaOnline(vOnline);
                this.detalleProformas=new ArrayList();
                for(Order order :orderList){
                    short reg=0;
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
                    this.detalleProformas.add(detalleproforma);
                    
                }
                
                this.selected.setTdetproformaCollection(this.detalleProformas);
                this.ejbFacade.create(selected);
                
            }catch( Exception e ){}
               return null;
        }

    /**
     * @return the listaitems
     */
    public List<SelectItem> getItems() {
        listaitems=titemServicio.findAll();
        List<SelectItem> principales = new ArrayList<SelectItem>();
        for(Titem itemp:listaitems){
            SelectItem selectItem=new SelectItem(itemp.getIdItem(),itemp.getDescItem()); 
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

    

	public static class Order{

        /**
         * @return the mostrariva
         */
        public BigDecimal getMostrariva() {
            return mostrariva;
        }

        /**
         * @param mostrariva the mostrariva to set
         */
        public void setMostrariva(BigDecimal mostrariva) {
            this.mostrariva = mostrariva;
        }
private HtmlInputHidden ciuH;
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
		
		String descripcion;
                BigDecimal cantidad;
                BigDecimal total;
                BigInteger iva;
                BigDecimal bigdec;
                private BigDecimal mostrariva;
                private Tentidad entidad=new Tentidad();
                private BigDecimal piva;
                
                public Order(){
                    ciuH=new HtmlInputHidden();
                    /* entidad.setCiu("1716542913");
                     entidad.setNombres("Diego Oswaldo Pule López");
                     entidad.setDireccion("Quito");*/
                     
                }
                
                
                public Order(String descripcion, BigDecimal cantidad, BigDecimal total, BigDecimal piva) {
			this.descripcion = descripcion;
			this.cantidad = cantidad;
			this.total = total;
			//this.iva = iva;
                        this.piva=piva;
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