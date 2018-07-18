package gob.igm.ec;

import gob.igm.ec.Titem;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-18T13:36:58")
@StaticMetamodel(Tunidadmedida.class)
public class Tunidadmedida_ { 

    public static volatile SingularAttribute<Tunidadmedida, String> obsUnidad;
    public static volatile SingularAttribute<Tunidadmedida, Long> idModificador;
    public static volatile SingularAttribute<Tunidadmedida, String> descUnidad;
    public static volatile SingularAttribute<Tunidadmedida, Date> fechaModificacion;
    public static volatile CollectionAttribute<Tunidadmedida, Titem> titemCollection;
    public static volatile SingularAttribute<Tunidadmedida, Long> idUnidad;
    public static volatile SingularAttribute<Tunidadmedida, Date> fechaCreacion;
    public static volatile SingularAttribute<Tunidadmedida, Long> idResponsable;
    public static volatile SingularAttribute<Tunidadmedida, BigInteger> version;

}