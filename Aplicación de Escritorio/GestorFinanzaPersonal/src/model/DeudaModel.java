package model;

import gestorfinanzapersonal.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sound.Sound;

public class DeudaModel {

    String descripcion, plazo;
    int idDeuda, idUsuario;
    double monto, interes;
    private Conexion conexion;
    
    public DeudaModel() {
        conexion = new Conexion();
    }
    
    public int getIdDeuda() {
       return this.idDeuda;
    } 
    public int getIdUsuario() {
       return this.idUsuario;
    }
    public String getDescripcion() {
       return this.descripcion;
    }
    public String getPlazo() {
       return this.plazo;
    }
    public double getMonto() {
       return this.monto;
    }
    public double getInteres() {
       return this.interes;
    }

    public void setIdDeuda(int idDeuda) {
    this.idDeuda = idDeuda;
    } 
    public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
    } 
    public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
    }    
    public void setPlazo(String plazo) {
    this.plazo = plazo;
    }
    public void setMonto(double monto) {
    this.monto = monto;
    }  
    public void setInteres(double interes) {
    this.interes = interes;
    }  

    public String InsertarDeuda(DeudaModel modeloDeu) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String spInsertarDeuda = "{call insertarDeuda(?, ?, ?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spInsertarDeuda);
            statement.setInt(1, modeloDeu.getIdUsuario());
            statement.setString(2, modeloDeu.getDescripcion());
            statement.setDouble(3, modeloDeu.getMonto());
            statement.setDouble(4, modeloDeu.getInteres());
            statement.setString(5, modeloDeu.getPlazo());    
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
 
public List<DeudaModel> obtenerDeuda(int idUsuario) {
    List<DeudaModel> deudas = new ArrayList<>();
    String query = "{call obtenerDeuda(?)}"; 
    try (Connection cx = conexion.conectar();
         CallableStatement statement = cx.prepareCall(query)) {
        statement.setInt(1, idUsuario); 
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                DeudaModel deuda = new DeudaModel();
                deuda.setIdDeuda(resultSet.getInt("idDeuda"));
                deuda.setDescripcion(resultSet.getString("descripcion"));
                deuda.setMonto(resultSet.getDouble("monto"));
                deuda.setInteres(resultSet.getDouble("interes"));
                deuda.setPlazo(resultSet.getString("plazo"));
                deudas.add(deuda);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return deudas;
}
    
public String modificarDeuda(DeudaModel modeloDeu) {
    Connection cx = conexion.conectar();
    if (cx != null) {       
        try {
            String spModificarDeuda = "{call modificarDeuda(?, ?, ?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spModificarDeuda); 
            statement.setInt(1, modeloDeu.getIdDeuda());
            statement.setString(2, modeloDeu.getDescripcion());
            statement.setDouble(3, modeloDeu.getMonto());
            statement.setDouble(4, modeloDeu.getInteres());
            statement.setString(5, modeloDeu.getPlazo());
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
