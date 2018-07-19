/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.controladores;

/**
 *
 * @author PULE_DIEGO
 * @modify JC_TOAPANTA
 */
import gob.igm.ec.Tdetproforma;
import gob.igm.ec.TdetproformaPK;
import gob.igm.ec.Tdireccionesusr;
import gob.igm.ec.Tentidad;
import gob.igm.ec.Titem;
import gob.igm.ec.Tproforma;
import gob.igm.ec.TproformaPK;
import gob.igm.ec.controladores.util.FacesUtil;
import gob.igm.ec.controladores.util.JsfUtil;
import gob.igm.ec.servicios.TcontrolIvaFacade;
import gob.igm.ec.servicios.TdetproformaFacade;
import gob.igm.ec.servicios.TdireccionesusrFacade;
import gob.igm.ec.servicios.TitemServicio;
import gob.igm.ec.servicios.TtarifarioFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.ExternalContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.log4j.Logger;

@Named("order")
@SessionScoped
public class OrderBean extends FacesUtil implements Serializable {

     @EJB
    private TtarifarioFacade ttarifarioFacade;
    
    
    /**
     * @return the tipoEntregaH
     */
    public HtmlInputHidden getTipoEntregaH() {
        return tipoEntregaH;
    }

    /**
     * @param tipoEntregaH the tipoEntregaH to set
     */
    public void setTipoEntregaH(HtmlInputHidden tipoEntregaH) {
        this.tipoEntregaH = tipoEntregaH;
    }

    /**
     * @return the direccionEnvio
     */
    public Tdireccionesusr getDireccionEnvio() {
        return direccionEnvio;
    }

    /**
     * @param direccionEnvio the direccionEnvio to set
     */
    public void setDireccionEnvio(Tdireccionesusr direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    @EJB
    private TdetproformaFacade tdetproformaFacade;

    @EJB
    private TcontrolIvaFacade tcontrolIvaFacade;

    @EJB
    private gob.igm.ec.servicios.TproformaFacade ejbFacade;

    @Inject
    private TdireccionesusrController direccionesControlador;

    @EJB
    private TdireccionesusrFacade direccionesServicio;
    private Titem detalleItems = new Titem();
    private Tproforma selected = new Tproforma();
    private TproformaPK proformapk = new TproformaPK();
    private TdetproformaPK detproformapk = new TdetproformaPK();
    private List<Tdetproforma> detalleProformas = new ArrayList();
    private Tdetproforma detalleproforma = new Tdetproforma();
    private Collection<Tdetproforma> tdetproformaCollection = new ArrayList<>();
    private HtmlInputHidden ciuH = new HtmlInputHidden();
    private HtmlInputHidden tipoEntregaH = new HtmlInputHidden();
    private HtmlInputHidden dirEntregaH = new HtmlInputHidden();
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
    private Tdireccionesusr direccionEnvio = new Tdireccionesusr();
    private BigDecimal totalp = BigDecimal.ZERO;
    private BigInteger mostrariva;
    private static Logger logger;

    public OrderBean() {
        this.direccionesControlador = new TdireccionesusrController();
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
            BigDecimal cien = new BigDecimal("100");

            this.piva = tcontrolIvaFacade.recuperaIva().divide(cien);

            this.totalp = (((this.cantidad.multiply(item.getCosto())).multiply(this.piva))).setScale(2, BigDecimal.ROUND_UP).add(this.cantidad.multiply(item.getCosto()));
            Order order = new Order(item.getIdItem(), item.getDescItem(), this.cantidad, item.getCosto(), this.piva, this.totalp);
            ORDERLIST.add(order);
            // Suma total de la proforma
            //   this.totalProforma = (((this.cantidad.multiply(item.getCosto())).multiply(this.piva.add(BigDecimal.valueOf(1)))).add(this.totalProforma)).setScale(2, BigDecimal.ROUND_UP);
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

    public String addProforma() {
        short reg = 0;

        Long direccionDomicilioUsrExiste;
        List<Tdireccionesusr> direccionEncontrada = new ArrayList<>();
        Tdireccionesusr dirFacturacion = new Tdireccionesusr();
        List<Tdireccionesusr> direccionEnvioEncontrada = new ArrayList<>();
        Tdireccionesusr dirEnvio = new Tdireccionesusr();
        String regla = "/tproforma/ListProXCli.xhtml";
        BigDecimal cantidad;
        BigDecimal valor=new BigDecimal("90");
        BigDecimal tarifario;    
        try {
            Date fechaActual = new Date();
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            String tEntrega = ec.getRequestParameterMap().get("principalForm:tipoEntregaHidden2");
            Short vIdPeriodo;
            Short vOnline = 1;
            direccionDomicilioUsrExiste = this.direccionesServicio.buscarExisteDireccionDomicilioCliente(this.getCiuH().getValue().toString());
            if (direccionDomicilioUsrExiste.equals(0L)) {
                JsfUtil.addErrorMessage("Usted aún no ha registrado una dirección, por favor agréguela.");
                regla = "/tdireccionesusr/List.xhtml";
            } else {
                direccionEncontrada = this.direccionesControlador.buscaDomicilioCliente();
                for (Tdireccionesusr tdireccionesusr : direccionEncontrada) {
                    dirFacturacion = tdireccionesusr;
                }
                direccionEnvioEncontrada = this.direccionesControlador.buscaDirEnvioCliente();
                for (Tdireccionesusr tdireccionesusr : direccionEnvioEncontrada) {
                    dirEnvio = tdireccionesusr;
                }
                regla = this.direccionesControlador.activaDirEnvio();
                if (regla.equals("/tproforma/ListProXCli")) {
                    vIdPeriodo = Short.parseShort(new SimpleDateFormat("yy").format(fechaActual));
                    this.proformapk.setIdPeriodo(vIdPeriodo);
                    this.proformapk.setIdSucursal(1L);
                    this.proformapk.setIdProforma(this.ejbFacade.maxId() + 1L);
                    this.selected.setTproformaPK(this.proformapk);
                    entidad.setCiu(this.getCiuH().getValue().toString());
                    this.selected.setCiu(entidad);
                    this.selected.setEstado("G");
                    this.selected.setTipoProforma("OP");
                    this.selected.setFechaCreacion(fechaActual);
                    this.selected.setDirCabeceraEf(dirFacturacion.getTparroquia().getTcanton().getTprovincia().getProvincia() + "/" + dirFacturacion.getTparroquia().getTcanton().getCanton() + "/" + dirFacturacion.getTparroquia().getParroquia() + "/" + dirFacturacion.toString());
                    this.selected.setDirEnvioEf(dirEnvio.getTparroquia().getTcanton().getTprovincia().getProvincia() + "/" + dirEnvio.getTparroquia().getTcanton().getCanton() + "/" + dirEnvio.getTparroquia().getParroquia() + "/" + dirEnvio.toString());
                    this.selected.setLVentaOnline(vOnline);
                    this.selected.setFormaEntrega(Short.parseShort(this.getTipoEntregaH().getValue().toString()));
                    this.ejbFacade.create(selected);
                    this.detalleProformas = new ArrayList();
                    for (Order order : ORDERLIST) {
                        reg++;
                        detalleproforma.setCantidad(order.getCantidad());
                        detalleproforma.setDetalleItem(order.getDescripcion());
                        this.detalleItems.setIdItem(order.getIdItem());
                        detalleproforma.setIdItem(detalleItems);
                        detalleproforma.setIvaPorcentaje(BigDecimal.valueOf(0.12));
                        detalleproforma.setPvpTotal(order.totalp);
                        this.detproformapk.setIdPeriodo(vIdPeriodo);
                        this.detproformapk.setIdProforma(this.proformapk.getIdProforma());
                        this.detproformapk.setIdSucursal(1L);
                        this.detproformapk.setNoReg(reg);
                        detalleproforma.setTdetproformaPK(detproformapk);
                        this.tdetproformaFacade.create(detalleproforma);
                        JsfUtil.addSuccessMessage("Su pedido ha sido guardado correctamente.");
                    }
                    cantidad = this.tdetproformaFacade.cantidad_peso(this.proformapk.getIdProforma()).multiply(valor);
                    tarifario = this.ttarifarioFacade.valor_tarifario(cantidad);
                    this.ejbFacade.grabarRecargo(tarifario, this.proformapk.getIdProforma());         
                    return regla;
                } else {
                    return regla;
                }
            }
            return regla;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "#";
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
        private int idItem;

        public int getIdItem() {
            return idItem;
        }

        public void setIdItem(int idItem) {
            this.idItem = idItem;
        }

        public BigDecimal getTotalp() {
            return totalp;
        }

        public void setTotalp(BigDecimal totalp) {
            this.totalp = totalp;
        }

        public BigDecimal getTotalProforma() {
            return totalProforma;
        }

        public void setTotalProforma(BigDecimal totalProforma) {
            this.totalProforma = totalProforma;
        }
        private BigDecimal totalp;
        private BigDecimal totalProforma;

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

        public Order(Integer idItem, String descripcion, BigDecimal cantidad, BigDecimal total, BigDecimal piva, BigDecimal totalp) {
            this.descripcion = descripcion;
            this.cantidad = cantidad;
            this.total = total;
            //this.iva = iva;
            this.piva = piva;
            this.idItem = idItem;
            this.totalp = totalp;
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

    /**
     * @return the dirEntregaH
     */
    public HtmlInputHidden getDirEntregaH() {
        return dirEntregaH;
    }

    /**
     * @param dirEntregaH the dirEntregaH to set
     */
    public void setDirEntregaH(HtmlInputHidden dirEntregaH) {
        this.dirEntregaH = dirEntregaH;
    }
}
