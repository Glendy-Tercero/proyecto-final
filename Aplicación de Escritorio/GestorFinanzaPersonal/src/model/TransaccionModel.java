package model;

import gestorfinanzapersonal.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sound.Sound;

public class TransaccionModel {
    
    private String fecha, descripcion, tipo, nombreCategoria;
    private int idTransaccion, idUsuario, idCategoria;
    private double monto;
    private Conexion conexion;
    
    public TransaccionModel() {
        conexion = new Conexion();
    }
    
    public int getIdTransaccion() {
       return this.idTransaccion;
    } 
    public int getIdUsuario() {
       return this.idUsuario;
    }
    public int getIdCategoria() {
       return this.idCategoria;
    }
    public String getFecha() {
       return this.fecha;
    }
    public String getDescripcion() {
       return this.descripcion;
    }
    public String getTipo() {
       return this.tipo;
    }
    public double getMonto() {
       return this.monto;
    }
    public String getNombreCategoria() {
        return nombreCategoria;
    }
   
    public void setIdTransaccion(int idTransaccion) {
    this.idTransaccion = idTransaccion;
    } 
    public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
    } 
    public void setIdCategoria(int idCategoria) {
    this.idCategoria = idCategoria;
    }
    public void setFecha(String fecha) {
    this.fecha = fecha;
    }
    public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
    }    
    public void setTipo(String tipo) {
    this.tipo = tipo;
    }
    public void setMonto(double monto) {
    this.monto = monto;
    }  
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

public String InsertarTransaccion(TransaccionModel modeloTra) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String spInsertarTransaccion = "{call InsertarTransaccion(?, ?, ?, ?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spInsertarTransaccion);
            statement.setInt(1, modeloTra.getIdUsuario());
            statement.setInt(2, modeloTra.getIdCategoria());
            statement.setString(3, modeloTra.getFecha());
            statement.setDouble(4, modeloTra.getMonto());
            statement.setString(5, modeloTra.getDescripcion());    
            statement.setString(6, modeloTra.getTipo());   
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
        return "No se puedo conectar";
    }
}    

public int obtenerIdCategoria(String nombre) {
    int idCategoria = -1;
        String query = "SELECT idCategoria FROM Categoria WHERE nombre = ?";
        try (Connection cx = conexion.conectar();
             PreparedStatement statement = cx.prepareStatement(query)) {
            statement.setString(1, nombre);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    idCategoria = resultSet.getInt("idCategoria");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return idCategoria;
    }

public String obtenerNombreCategoria(int idCategoria) {
   String nombreCategoria = null;
        String nombre = "SELECT nombre FROM Categoria WHERE idCategoria = ?";
        try (Connection cx = conexion.conectar();
            PreparedStatement statement = cx.prepareStatement(nombre)) {
            statement.setInt(1, idCategoria);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    nombreCategoria = resultSet.getString("nombre");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombreCategoria;
    }

public List<TransaccionModel> obtenerTransaccion(int idUsuario) {
    List<TransaccionModel> transacciones = new ArrayList<>();
    String query = "{call obtenerTransaccion(?)}";
    try (Connection cx = conexion.conectar();
         CallableStatement statement = cx.prepareCall(query)) {
        statement.setInt(1, idUsuario);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                TransaccionModel transaccion = new TransaccionModel();
                transaccion.setIdTransaccion(resultSet.getInt("idTransaccion"));
                transaccion.setIdCategoria(resultSet.getInt("idCategoria"));
                transaccion.setFecha(resultSet.getString("fecha"));
                transaccion.setMonto(resultSet.getDouble("monto"));
                transaccion.setDescripcion(resultSet.getString("descripcion"));
                transaccion.setTipo(resultSet.getString("tipo"));
                transacciones.add(transaccion);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return transacciones;
}

public String modificarTransaccion(TransaccionModel modeloTra) {
    Connection cx = conexion.conectar();
    if (cx != null) {       
        try {
            String spModificarTransaccion = "{call modificarTransaccion(?, ?, ?, ?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spModificarTransaccion); 
            statement.setInt(1, modeloTra.getIdTransaccion());
            statement.setInt(2, modeloTra.getIdCategoria());
            statement.setString(3, modeloTra.getFecha());
            statement.setDouble(4, modeloTra.getMonto());
            statement.setString(5, modeloTra.getDescripcion());    
            statement.setString(6, modeloTra.getTipo());   
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
