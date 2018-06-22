package gob.igm.ec;

import gob.igm.ec.Tdireccionesusr;
import gob.igm.ec.Tproforma;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-22T14:22:23")
@StaticMetamodel(Tentidad.class)
public class Tentidad_ { 

    public static volatile SingularAttribute<Tentidad, String> apellidos;
    public static volatile SingularAttribute<Tentidad, Integer> idModificador;
    public static volatile SingularAttribute<Tentidad, String> clave;
    public static volatile SingularAttribute<Tentidad, String> direccion;
    public static volatile CollectionAttribute<Tentidad, Tdireccionesusr> tdireccionesusrCollection;
    public static volatile SingularAttribute<Tentidad, Integer> idCreador;
    public static volatile SingularAttribute<Tentidad, String> telefonoConvencional;
    public static volatile SingularAttribute<Tentidad, String> ciu;
    public static volatile SingularAttribute<Tentidad, String> nombres;
    public static volatile CollectionAttribute<Tentidad, Tproforma> tproformaCollection;
    public static volatile SingularAttribute<Tentidad, String> telefonoCelular;
    public static volatile SingularAttribute<Tentidad, String> cCtble;
    public static volatile SingularAttribute<Tentidad, Short> lNatural;
    public static volatile SingularAttribute<Tentidad, String> fax;
    public static volatile SingularAttribute<Tentidad, String> email;

}