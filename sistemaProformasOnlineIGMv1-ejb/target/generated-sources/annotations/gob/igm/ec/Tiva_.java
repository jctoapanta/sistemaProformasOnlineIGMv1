package gob.igm.ec;

import gob.igm.ec.Tdetproforma;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-03T12:28:14")
@StaticMetamodel(Tiva.class)
public class Tiva_ { 

    public static volatile SingularAttribute<Tiva, Long> idModificador;
    public static volatile SingularAttribute<Tiva, String> estado;
    public static volatile SingularAttribute<Tiva, BigDecimal> porcentajeIva;
    public static volatile SingularAttribute<Tiva, Long> idResponsable;
    public static volatile SingularAttribute<Tiva, BigInteger> version;
    public static volatile SingularAttribute<Tiva, Long> idIva;
    public static volatile SingularAttribute<Tiva, Date> fechaModifica;
    public static volatile SingularAttribute<Tiva, Short> idSucursal;
    public static volatile SingularAttribute<Tiva, Long> idProforma;
    public static volatile SingularAttribute<Tiva, Short> noReg;
    public static volatile CollectionAttribute<Tiva, Tdetproforma> tdetproformaCollection;
    public static volatile SingularAttribute<Tiva, Short> idPeriodo;
    public static volatile SingularAttribute<Tiva, Date> fechaCreacion;

}