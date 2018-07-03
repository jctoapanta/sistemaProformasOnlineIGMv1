package gob.igm.ec;

import gob.igm.ec.Tdetproforma;
import gob.igm.ec.Tunidadmedida;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-03T12:28:14")
@StaticMetamodel(Titem.class)
public class Titem_ { 

    public static volatile SingularAttribute<Titem, String> idModificador;
    public static volatile SingularAttribute<Titem, String> descripcionAnterior;
    public static volatile SingularAttribute<Titem, String> estado;
    public static volatile SingularAttribute<Titem, BigDecimal> costo;
    public static volatile SingularAttribute<Titem, BigInteger> lInventariado;
    public static volatile SingularAttribute<Titem, Tunidadmedida> idUnidad;
    public static volatile SingularAttribute<Titem, Short> lVentaOnline;
    public static volatile SingularAttribute<Titem, BigDecimal> pvp;
    public static volatile SingularAttribute<Titem, String> idCreador;
    public static volatile CollectionAttribute<Titem, Tdetproforma> tdetproformaCollection;
    public static volatile SingularAttribute<Titem, Date> fechaCreacion;
    public static volatile SingularAttribute<Titem, String> descItem;
    public static volatile SingularAttribute<Titem, BigInteger> lIva;
    public static volatile SingularAttribute<Titem, Integer> idItem;

}