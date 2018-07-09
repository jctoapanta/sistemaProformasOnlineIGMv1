package gob.igm.ec;

import gob.igm.ec.TdetproformaPK;
import gob.igm.ec.Titem;
import gob.igm.ec.Tiva;
import gob.igm.ec.Tproforma;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-09T11:04:37")
@StaticMetamodel(Tdetproforma.class)
public class Tdetproforma_ { 

    public static volatile SingularAttribute<Tdetproforma, Short> idCentroGestion;
    public static volatile SingularAttribute<Tdetproforma, Integer> idProyecto;
    public static volatile SingularAttribute<Tdetproforma, Tproforma> tproforma;
    public static volatile SingularAttribute<Tdetproforma, Date> fecimp;
    public static volatile SingularAttribute<Tdetproforma, BigInteger> numDesde;
    public static volatile SingularAttribute<Tdetproforma, String> formato;
    public static volatile SingularAttribute<Tdetproforma, Tiva> idIva;
    public static volatile SingularAttribute<Tdetproforma, Short> impreso;
    public static volatile SingularAttribute<Tdetproforma, BigInteger> numActual;
    public static volatile SingularAttribute<Tdetproforma, BigDecimal> dimension;
    public static volatile SingularAttribute<Tdetproforma, Titem> idItem;
    public static volatile SingularAttribute<Tdetproforma, BigInteger> codsec;
    public static volatile SingularAttribute<Tdetproforma, BigDecimal> ivaPorcentaje;
    public static volatile SingularAttribute<Tdetproforma, BigDecimal> descuento;
    public static volatile SingularAttribute<Tdetproforma, BigInteger> idFacturaAnterior;
    public static volatile SingularAttribute<Tdetproforma, String> detalleItem;
    public static volatile SingularAttribute<Tdetproforma, Short> lAcepta;
    public static volatile SingularAttribute<Tdetproforma, TdetproformaPK> tdetproformaPK;
    public static volatile SingularAttribute<Tdetproforma, BigDecimal> pvpTotal;
    public static volatile SingularAttribute<Tdetproforma, String> obsLiberaProf;
    public static volatile SingularAttribute<Tdetproforma, String> tipoItem;
    public static volatile SingularAttribute<Tdetproforma, BigInteger> periodoFactura;
    public static volatile SingularAttribute<Tdetproforma, BigInteger> periodoFacturaAnterior;
    public static volatile SingularAttribute<Tdetproforma, BigInteger> idFactura;
    public static volatile SingularAttribute<Tdetproforma, BigInteger> periodocodigo;
    public static volatile SingularAttribute<Tdetproforma, BigDecimal> cantidad;
    public static volatile SingularAttribute<Tdetproforma, BigInteger> numHasta;

}