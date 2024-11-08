package model;

import gestorfinanzapersonal.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sound.Sound;

public class UsuarioModel {
    
    private String nombre, email, contraseña;
    private int idUsuario;
    private Conexion conexion;
    
    public UsuarioModel() {
        conexion = new Conexion();
    }
    
    public int getIdUsuario() {
       return this.idUsuario;
    }  
    public String getNombre() {
       return this.nombre;
    }
    public String getEmail() {
       return this.email;
    }
    public String getContraseña() {
       return this.contraseña;
    }
   
    public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
    }  
    public void setNombre(String nombre) {
    this.nombre = nombre;
    }
    public void setEmail(String email) {
    this.email = email;
    }    
    public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
    }
  
    public UsuarioModel(int idUsuario, String nombre, String email, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
    }
    
public String InsertarUsuario(UsuarioModel modeloUsu) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String UsuarioExiste = "SELECT COUNT(*) AS total FROM Usuario WHERE email = ?";
            PreparedStatement statementUsuarioExiste = cx.prepareStatement(UsuarioExiste);
            statementUsuarioExiste.setString(1, modeloUsu.getEmail());
            ResultSet rsUsuarioExiste = statementUsuarioExiste.executeQuery();
        if (rsUsuarioExiste.next() && rsUsuarioExiste.getInt("total") > 0) {
            Sound.playSound("src/sound/error.wav");
            return "Ya existe un usuario con este correo electrónico";
        } else {
            String spInsertarUsuario = "{call InsertarUsuario(?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spInsertarUsuario);
            statement.setString(1, modeloUsu.getNombre());
            statement.setString(2, modeloUsu.getEmail());
            statement.setString(3, modeloUsu.getContraseña());
            statement.execute();
            Sound.playSound("src/sound/success.wav");
        return "Guardado exitosamente";
        }
        } catch (SQLException ex) {
           return ex.getMessage();
        } finally {
        try {
            cx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            }
            }
        } else {
            Sound.playSound("src/sound/error.wav");
            return "No se pudo conectar";
        }
    }

public String IniciarSesion(String email, String contraseña) {
    Connection cx = conexion.conectar();
    if (cx != null) {
        try {
            String usuario = "SELECT * FROM Usuario WHERE email = ? AND contraseña = ?";
            PreparedStatement statement = cx.prepareStatement(usuario);
            statement.setString(1, email);
            statement.setString(2, contraseña);
            ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            this.idUsuario = rs.getInt("idUsuario");
            this.nombre = rs.getString("nombre");
            this.email = rs.getString("email");
            this.contraseña = rs.getString("contraseña");
        return "Inicio de sesión exitoso";
        } else {
            Sound.playSound("src/sound/error.wav");
            return "Correo electrónico y/o contraseña incorrectos";
        }
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
        try {
            cx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            }
            }
        } else {
        return null;
        }
    }

public int obtenerIdUsuario() {
        return this.idUsuario;
    }

public UsuarioModel obtenerUsuario(int idUsuario) {
    UsuarioModel usuario = null;
    String query = "{call obtenerUsuario(?)}"; 

    try (Connection cx = conexion.conectar();
         CallableStatement statement = cx.prepareCall(query)) {
        statement.setInt(1, idUsuario); 
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                String contraseña = resultSet.getString("contraseña");
                usuario = new UsuarioModel(idUsuario, nombre, email, contraseña);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return usuario;
}

public String modificarUsuario(UsuarioModel modeloUsu) {
    Connection cx = conexion.conectar();
    if (cx != null) {       
        try {
            String spModificarUsuario = "{call modificarUsuario(?, ?, ?, ?)}";
            CallableStatement statement = cx.prepareCall(spModificarUsuario); 
            statement.setInt(1, modeloUsu.getIdUsuario());
            statement.setString(2, modeloUsu.getNombre());
            statement.setString(3, modeloUsu.getEmail());
            statement.setString(4, modeloUsu.getContraseña());
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

public String eliminarUsuario(int idUsuario) {
    try (Connection cx = conexion.conectar()) {
        cx.setAutoCommit(false);

        String queryEliminarPresupuesto = "{call eliminarPresupuesto(?)}";
        String queryEliminarTransaccion = "{call eliminarTransaccion(?)}";
        String queryEliminarCuenta = "{call eliminarCuenta(?)}";
        String queryEliminarDeuda = "{call eliminarDeuda(?)}";
        String queryEliminarUsuario = "{call eliminarUsuario(?)}";

        try (CallableStatement stmtEliminarPresupuesto = cx.prepareCall(queryEliminarPresupuesto);
             CallableStatement stmtEliminarTransaccion = cx.prepareCall(queryEliminarTransaccion);
             CallableStatement stmtEliminarCuenta = cx.prepareCall(queryEliminarCuenta);
             CallableStatement stmtEliminarDeuda = cx.prepareCall(queryEliminarDeuda);
             CallableStatement stmtEliminarUsuario = cx.prepareCall(queryEliminarUsuario)) {

            stmtEliminarPresupuesto.setInt(1, idUsuario);
            stmtEliminarTransaccion.setInt(1, idUsuario);
            stmtEliminarCuenta.setInt(1, idUsuario);
            stmtEliminarDeuda.setInt(1, idUsuario);
            stmtEliminarUsuario.setInt(1, idUsuario);

            stmtEliminarPresupuesto.executeUpdate();
            stmtEliminarTransaccion.executeUpdate();
            stmtEliminarCuenta.executeUpdate();
            stmtEliminarDeuda.executeUpdate();
            stmtEliminarUsuario.executeUpdate();

            cx.commit();
            Sound.playSound("src/sound/success.wav");
            return "Cuenta eliminada exitosamente";
        } catch (SQLException ex) {
            cx.rollback();
            return ex.getMessage();
        }
    } catch (SQLException ex) {
        return ex.getMessage();
    }
}
}

