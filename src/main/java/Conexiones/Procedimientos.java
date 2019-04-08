/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import prograbases1.Correo;
import prograbases1.Password;

public class Procedimientos {

    public static void ingresoCliente(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j) throws SQLException {
        CallableStatement ingreso = Conexion.getConexion().prepareCall("{call ingresoCliente(?,?,?,?,?,?,?,?,?,?)}");
        ingreso.setString(1, a);
        ingreso.setString(2, b);
        ingreso.setString(3, c);
        ingreso.setString(4, d);
        ingreso.setString(5, e);
        ingreso.setString(6, f);
        ingreso.setString(7, g);
        ingreso.setString(8, h);
        ingreso.setString(9, i);
        ingreso.setString(10, j);
        ingreso.execute();

    }

    public static void ingresoEmpresa(String a, String b, String c, String d, String e, String f, String g) throws SQLException {
        CallableStatement empresa = Conexion.getConexion().prepareCall("{call ingresoEmpresa(?,?,?,?,?,?,?)}");
        empresa.setString(1, a);
        empresa.setString(2, b);
        empresa.setString(3, c);
        empresa.setString(4, d);
        empresa.setString(5, e);
        empresa.setString(6, f);
        empresa.setString(7, g);
        empresa.execute();
    }

    public static void ingresoMantenimiento(String a, String b, String c, String d, String e, String f, String g) throws SQLException {
        CallableStatement manten = Conexion.getConexion().prepareCall("{call ingresoMantenimiento(?,?,?,?,?,?,?)}");
        manten.setString(1, a);
        manten.setString(2, b);
        manten.setString(3, c);
        manten.setString(4, d);
        manten.setString(5, e);
        manten.setString(6, f);
        manten.setString(7, g);
        manten.execute();
    }

    public static void ingresoVehiculo(String a, String b, String c, String d, String e, String f, String g, String h, String i, Blob j, String k, String l, String m, String n, String o, String p) throws SQLException {
        CallableStatement vehiculo = Conexion.getConexion().prepareCall("{call ingresarVehiculo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        vehiculo.setString(1, a);
        vehiculo.setString(2, b);
        vehiculo.setString(3, c);
        vehiculo.setString(4, d);
        vehiculo.setString(5, e);
        vehiculo.setString(6, f);
        vehiculo.setString(7, g);
        vehiculo.setString(8, h);
        vehiculo.setString(9, i);
        vehiculo.setBlob(10, j);
        vehiculo.setString(11, k);
        vehiculo.setString(12, l);
        vehiculo.setString(13, m);
        vehiculo.setString(14, n);
        vehiculo.setString(15, o);
        vehiculo.setString(16, p);
        vehiculo.execute();
    }

    public static void ingresoLicencia(String a, String b, String c, String d, Blob e, String f) throws SQLException {
        CallableStatement licencia = Conexion.getConexion().prepareCall("{call ingresarLicencia(?,?,?,?,?,?)}");
        licencia.setString(1, a);
        licencia.setString(2, b);
        licencia.setString(3, c);
        licencia.setString(4, d);
        licencia.setBlob(5, e);
        licencia.setString(6, f);
        licencia.execute();
    }

    public static void buscarCanton(int a) throws SQLException {
        CallableStatement canton = Conexion.getConexion().prepareCall("{call buscarCanton(?)}");
        canton.setInt(1, a);
        canton.execute();
    }

    public static void buscarVehiculo(int a) throws SQLException {
        CallableStatement placa = Conexion.getConexion().prepareCall("{call buscarVehiculo(?)}");
        placa.setInt(1, a);
        placa.execute();
    }

    public static void ingresoReserva(int a, String b, String c, String d, String e, String f, String g, String h, String i, String j) throws SQLException {
        CallableStatement reserva = Conexion.getConexion().prepareCall("{call ingresarReserva(?,?,?,?,?,?,?,?,?,?)}");
        reserva.setInt(1, a);
        reserva.setString(2, b);
        reserva.setString(3, c);
        reserva.setString(4, d);
        reserva.setString(5, e);
        reserva.setString(6, f);
        reserva.setString(7, g);
        reserva.setString(8, h);
        reserva.setString(9, i);
        reserva.setString(10, j);
        reserva.execute();
    }

    public static void ingresoOperador(String correo) throws SQLException {
        CallableStatement ingreso = Conexion.getConexion().prepareCall("{call ingresoOperador(?,?,?)}");
        String contraseña = Password.getPassword();
        String[] parts = correo.split("@");
        String usuario = parts[0];
        ingreso.setString(1, correo);
        ingreso.setString(2, contraseña);
        ingreso.setString(3, usuario);
        ingreso.execute();
        Correo.enviarCorreoOperador(correo, contraseña, usuario);
    }
    
    public static void ingresarRecorrido(String fechaRecorrido, String puntoALat, String puntoALon, String puntoBLat, String puntoBLon) throws SQLException, ParseException {
        CallableStatement recorrido = Conexion.getConexion().prepareCall("{call ingresarRecorrido(?,?,?,?,?)}");
        String fecha=fechaRecorrido.replace('-', '/');
        System.out.println("%" + fecha);
//        float a = (float)puntoALat;
//        float b = (float)puntoALon;
//        float c = (float)puntoBLat;
//        float d = (float)puntoBLon;
//        SimpleDateFormat fechaF = new SimpleDateFormat("MM/dd/yyyy");
//        String fechaEX = fechaF.format(fechaRecorrido);
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date date = sdf1.parse(fechaRecorrido);
//        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//        System.out.println("+" + sqlStartDate);
        recorrido.setString(1, fecha);
        recorrido.setString(2, puntoALat);
        recorrido.setString(3, puntoALon);
        recorrido.setString(4, puntoBLat);
        recorrido.setString(5, puntoBLon);
        recorrido.execute();
    }
}
