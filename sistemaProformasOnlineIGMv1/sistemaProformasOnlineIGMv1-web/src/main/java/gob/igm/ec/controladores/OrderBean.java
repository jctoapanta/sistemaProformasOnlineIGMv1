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
import gob.igm.ec.Tentidad;
import gob.igm.ec.Titem;
import gob.igm.ec.servicios.TitemServicio;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
 
@ManagedBean(name="order")
@SessionScoped
public class OrderBean implements Serializable{

    /**
     * @return the piva
     */
    public double getPiva() {
        return piva;
    }

    /**
     * @param piva the piva to set
     */
    public void setPiva(double piva) {
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
                private double piva;
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
                this.totalp = ((this.cantidad.multiply(item.getPvp())).add(this.totalp)).add(BigDecimal.valueOf(0.12));
		
		
            }catch( Exception e ){}
               return null;     
	}
 
	public String deleteAction(Order order) {
	    
		orderList.remove(order);
                 this.totalp = ((this.totalp).subtract( (this.cantidad.multiply(item.getPvp())))).subtract(BigDecimal.valueOf(0.12));
		;
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

         this.setCantidad(BigDecimal.ONE);
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Tentidad entidad) {
        this.entidad = entidad;
    }

    

	public static class Order{

        /**
         * @return the piva
         */
        public double getPiva() {
            return piva;
        }

        /**
         * @param piva the piva to set
         */
        public void setPiva(double piva) {
            this.piva = piva;
        }
		
		String descripcion;
                BigDecimal cantidad;
                BigDecimal total;
                BigInteger iva;
                BigDecimal bigdec;
                private Tentidad entidad=new Tentidad();
                private double piva;
                
                public Order(){
                     entidad.setCiu("1716542913");
                     entidad.setNombres("Diego Oswaldo Pule López");
                     entidad.setDireccion("Quito");
                     
                }
                
                
                public Order(String descripcion, BigDecimal cantidad, BigDecimal total, double piva) {
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
		

		
		
		
	}
} 