package gob.igm.ec;

import gob.igm.ec.Tentidad;
import gob.igm.ec.Tparroquia;
import gob.igm.ec.Ttipodireccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-29T12:59:20")
@StaticMetamodel(Tdireccionesusr.class)
public class Tdireccionesusr_ { 

    public static volatile SingularAttribute<Tdireccionesusr, Long> idDireccion;
    public static volatile SingularAttribute<Tdireccionesusr, String> referenciaDireccion;
    public static volatile SingularAttribute<Tdireccionesusr, String> callePrincipalDireccion;
    public static volatile SingularAttribute<Tdireccionesusr, String> calleSecundariaDireccion;
    public static volatile SingularAttribute<Tdireccionesusr, String> numeroDireccion;
    public static volatile SingularAttribute<Tdireccionesusr, Short> lEnvio;
    public static volatile SingularAttribute<Tdireccionesusr, Ttipodireccion> idTipoDireccion;
    public static volatile SingularAttribute<Tdireccionesusr, Tentidad> ciu;
    public static volatile SingularAttribute<Tdireccionesusr, Tparroquia> tparroquia;

}