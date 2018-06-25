/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.controladores.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.el.ELContext;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import org.apache.log4j.Logger;

/**
 *
 * @author PULE_DIEGO
 * @modified JC TOAPANTA
 */
public class JasperReportUtil {

    public final static String PATH;
    public final static String PATH_IMAGES;
    public final static String PATH_REPORTE_PROFORMA;
    public final static String PATH_REPORTE_PROFORMA_R;
    public final static String TIPO_PDF;
    public final static String TIPO_EXCEL;

    static {
        PATH = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/");
        PATH_IMAGES = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/");
        PATH_REPORTE_PROFORMA = PATH + "/Reporte.jasper";
        PATH_REPORTE_PROFORMA_R = PATH + "/Reporte.jrxml";
        TIPO_PDF = "application/pdf";
        TIPO_EXCEL = "application/xls";
    }
    public static Logger localLogger = Logger.getLogger(JasperReportUtil.class);

    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Retorna el valor ELContext.
     *
     * @return El eL context
     */
    public ELContext getELContext() {
        return this.getFacesContext().getELContext();
    }

    public void jasperReport(Connection conn, final String urlReporte, String tipo, Map<String, Object> params) throws ClassNotFoundException {
        ExternalContext econtext = this.getFacesContext().getExternalContext();
        FacesContext fcontext = this.getFacesContext();
        try {
            JRExporter exporter = null;
            InputStream inputStream = new FileInputStream(urlReporte);

            if (inputStream == null) {
                throw new ClassNotFoundException("Archivo " + urlReporte + " no se encontró");
            }

            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, conn);
            HttpServletResponse response = (HttpServletResponse) econtext.getResponse();
            response.setContentType(tipo);
            if ("application/pdf".equals(tipo)) {
                exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", 0);
            } else {
                exporter = new JRXlsxExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_COLLAPSE_ROW_SPAN, false);
                exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                response.setContentType("application/xls");
                response.setHeader("Content-Disposition", "inline; filename=\"reporte.xls\";");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", 0);

            }

            if (exporter != null) {
                exporter.exportReport();
            } else {
                localLogger.error("error");
            }

            conn.close();
        } catch (IOException | ClassNotFoundException | SQLException | JRException ex) {
            localLogger.error(ex);
        }
        fcontext.responseComplete();
    }

}
