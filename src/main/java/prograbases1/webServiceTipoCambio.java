/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograbases1;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author
 */
public class webServiceTipoCambio {

    private static final String url = "http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/cuadros/frmvercatcuadro.aspx?CodCuadro=400";
    private static float tipoCambioVenta;
    private static float tipoCambioCompra;
    private static String tipoCambioFecha;

    public static float getTipoCambioVenta() {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements dataCodes = doc.select("td.celda400");
            Element copia = dataCodes.last();
            String tipo = copia.html().toString();
            tipo = tipo.replace(',', '.');
            tipoCambioVenta = Float.parseFloat(tipo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tipoCambioVenta;
    }

    public static float getTipoCambioCompra() {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements dataCodes = doc.select("td.celda400");
            Element copia = dataCodes.get(59);
            String tipo = copia.html().toString();
            tipo = tipo.replace(',', '.');
            tipoCambioCompra = Float.parseFloat(tipo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tipoCambioCompra;
    }

    public static String getTipoCambioFecha() {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements dataCodes = doc.select("td.celda400");
            Element copia = dataCodes.get(29);
            String tipo = copia.html().toString();
            tipoCambioFecha = tipo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tipoCambioFecha;
    }

}
