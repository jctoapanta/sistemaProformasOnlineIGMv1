package gob.igm.ec;

import gob.igm.ec.Tcanton;
import gob.igm.ec.Tdireccionesusr;
import gob.igm.ec.TparroquiaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-06T14:10:05")
@StaticMetamodel(Tparroquia.class)
public class Tparroquia_ { 

    public static volatile ListAttribute<Tparroquia, Tdireccionesusr> tdireccionesusrList;
    public static volatile SingularAttribute<Tparroquia, TparroquiaPK> tparroquiaPK;
    public static volatile SingularAttribute<Tparroquia, String> parroquia;
    public static volatile SingularAttribute<Tparroquia, Tcanton> tcanton;

}