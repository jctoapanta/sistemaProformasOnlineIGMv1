package gob.igm.ec;

import gob.igm.ec.Tproforma;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-03T12:28:14")
@StaticMetamodel(Tsucursal.class)
public class Tsucursal_ { 

    public static volatile SingularAttribute<Tsucursal, Long> idModificador;
    public static volatile SingularAttribute<Tsucursal, String> ruc;
    public static volatile SingularAttribute<Tsucursal, Date> fechaModificacion;
    public static volatile SingularAttribute<Tsucursal, String> direccion;
    public static volatile SingularAttribute<Tsucursal, Long> idResponsable;
    public static volatile SingularAttribute<Tsucursal, BigInteger> version;
    public static volatile CollectionAttribute<Tsucursal, Tproforma> tproformaCollection;
    public static volatile SingularAttribute<Tsucursal, Long> idSucursal;
    public static volatile SingularAttribute<Tsucursal, String> cCtble;
    public static volatile SingularAttribute<Tsucursal, String> descSucursal;
    public static volatile SingularAttribute<Tsucursal, Date> fechaCreacion;
    public static volatile SingularAttribute<Tsucursal, String> telefono;
    public static volatile SingularAttribute<Tsucursal, String> fax;
    public static volatile SingularAttribute<Tsucursal, String> email;

}