package model;

import gestorfinanzapersonal.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import sound.Sound;

public class CuentaModel {
    
    String nombre, tipo;
    int idCuenta, idUsuario;
    double saldo;
    private Conexion conexion;
    
    public CuentaModel() {
        conexion = new Conexion();
    }
    
    public int getIdCuenta() {
       return this.idCuenta;
    }  
    public int getIdUsuario() {
       return this.idUsuario;
    }  
    public String getNombre() {
       return this.nombre;
    }
    public String getTipo() {
       return this.tipo;
    }
    public double getSaldo() {
       return this.saldo;
    }
   
    public void setIdCuenta(int idCuenta) {
    this.idCuenta = idCuenta;
    }  
    public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
    }  
    public void setNombre(String nombre) {
    this.nombre = nombre;
    }
    public void setTipo(String tipo) {
    this.tipo = tipo;
    }    
    public void setSaldo(double saldo) {
    this.saldo = saldo;
    }  
    
public String InsertarCuenta(CuentaModel modeloCue) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String spInsertarCuenta = "{call InsertarCuenta(?, ?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spInsertarCuenta);
            statement.setInt(1, modeloCue.getIdUsuario());
            statement.setString(2, modeloCue.getNombre());
            statement.setString(3, modeloCue.getTipo());
            statement.setDouble(4, modeloCue.getSaldo());
            statement.execute();
            Sound.playSound("src/sound/success.wav");
            return "Guardado exitosamente";
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
            conexion.desconectar();
        }
    } else {
        Sound.playSound("src/sound/error.wav");
        return "Algo salió mal";
    }
}    

public List<CuentaModel> obtenerCuenta(int idUsuario) {
    List<CuentaModel> cuentas = new ArrayList<>();
    String query = "{call obtenerCuenta(?)}";
    try (Connection cx = conexion.conectar();
         CallableStatement statement = cx.prepareCall(query)) { 
        statement.setInt(1, idUsuario);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                CuentaModel cuenta = new CuentaModel();
                cuenta.setIdCuenta(resultSet.getInt("idCuenta"));
                cuenta.setNombre(resultSet.getString("nombre"));
                cuenta.setTipo(resultSet.getString("tipo"));
                cuenta.setSaldo(resultSet.getDouble("saldo"));
                cuentas.add(cuenta);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return cuentas;
}

public String modificarCuenta(CuentaModel modeloCue) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String spModificarCuenta = "{call modificarCuenta(?, ?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spModificarCuenta);
            statement.setInt(1, modeloCue.getIdUsuario());
            statement.setString(2, modeloCue.getNombre());
            statement.setString(3, modeloCue.getTipo());
            statement.setDouble(4, modeloCue.getSaldo());
            statement.executeUpdate();
            Sound.playSound("src/sound/success.wav");
            return "Modificado exitosamente";
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
            conexion.desconectar();
        }} else {
        Sound.playSound("src/sound/error.wav");
        return "Algo salió mal";
    }
}
}
