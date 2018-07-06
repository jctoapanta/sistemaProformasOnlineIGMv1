package gob.igm.ec;

import gob.igm.ec.TcantonPK;
import gob.igm.ec.Tparroquia;
import gob.igm.ec.Tprovincia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-06T13:22:57")
@StaticMetamodel(Tcanton.class)
public class Tcanton_ { 

    public static volatile SingularAttribute<Tcanton, Tprovincia> tprovincia;
    public static volatile CollectionAttribute<Tcanton, Tparroquia> tparroquiaCollection;
    public static volatile SingularAttribute<Tcanton, String> canton;
    public static volatile SingularAttribute<Tcanton, Short> idZona;
    public static volatile SingularAttribute<Tcanton, TcantonPK> tcantonPK;
    public static volatile SingularAttribute<Tcanton, Short> lPrincipal;

}