package gob.igm.ec;

import gob.igm.ec.Tcanton;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T09:21:46")
@StaticMetamodel(Tprovincia.class)
public class Tprovincia_ { 

    public static volatile SingularAttribute<Tprovincia, Integer> idProvincia;
    public static volatile SingularAttribute<Tprovincia, Integer> diasEntrega;
    public static volatile CollectionAttribute<Tprovincia, Tcanton> tcantonCollection;
    public static volatile SingularAttribute<Tprovincia, String> provincia;

}