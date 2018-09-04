package gob.igm.ec;

import gob.igm.ec.Tentidad;
import gob.igm.ec.TproformaPK;
import gob.igm.ec.Tsucursal;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-29T12:59:20")
@StaticMetamodel(Tproforma.class)
public class Tproforma_ { 

    public static volatile SingularAttribute<Tproforma, String> obsAutoriza;
    public static volatile SingularAttribute<Tproforma, Integer> idModificador;
    public static volatile SingularAttribute<Tproforma, TproformaPK> tproformaPK;
    public static volatile SingularAttribute<Tproforma, String> estado;
    public static volatile SingularAttribute<Tproforma, Short> lVentaOnline;
    public static volatile SingularAttribute<Tproforma, Short> idSucursalFac;
    public static volatile SingularAttribute<Tproforma, BigDecimal> valorEnvio;
    public static volatile SingularAttribute<Tproforma, Integer> idCreador;
    public static volatile SingularAttribute<Tproforma, Tsucursal> tsucursal;
    public static volatile SingularAttribute<Tproforma, Tentidad> ciu;
    public static volatile SingularAttribute<Tproforma, Short> validezDias;
    public static volatile SingularAttribute<Tproforma, Short> lAutoriza;
    public static volatile SingularAttribute<Tproforma, String> obsProforma;
    public static volatile SingularAttribute<Tproforma, String> tiempoEntrega;
    public static volatile SingularAttribute<Tproforma, String> tipoProforma;
    public static volatile SingularAttribute<Tproforma, String> contacto;
    public static volatile SingularAttribute<Tproforma, Date> fechaModificacion;
    public static volatile SingularAttribute<Tproforma, String> dirCabeceraEf;
    public static volatile SingularAttribute<Tproforma, Short> idPeriodoFac;
    public static volatile SingularAttribute<Tproforma, Short> formaEntrega;
    public static volatile SingularAttribute<Tproforma, String> numPedido;
    public static volatile SingularAttribute<Tproforma, Date> fechaConfirmacion;
    public static volatile SingularAttribute<Tproforma, String> obsModificacion;
    public static volatile SingularAttribute<Tproforma, Long> idFactura;
    public static volatile SingularAttribute<Tproforma, String> especTecnica;
    public static volatile SingularAttribute<Tproforma, Date> fechaCreacion;
    public static volatile SingularAttribute<Tproforma, Short> formaPago;
    public static volatile SingularAttribute<Tproforma, Date> fechaValidez;
    public static volatile SingularAttribute<Tproforma, String> dirEnvioEf;
    public static volatile SingularAttribute<Tproforma, Integer> idAutorizador;
    public static volatile SingularAttribute<Tproforma, Date> fechaRecepcion;

}