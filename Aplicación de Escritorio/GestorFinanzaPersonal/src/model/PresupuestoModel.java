package model;

import gestorfinanzapersonal.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import sound.Sound;

public class PresupuestoModel {

    private int idPresupuesto;
    private int idUsuario;
    private double monto;
    private String fechaInicio;
    private String fechaFin;
    private Conexion conexion;

    public PresupuestoModel() {
        conexion = new Conexion();
    }
    public int getIdPresupuesto() {
        return idPresupuesto;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public double getMonto() {
        return monto;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }
    public String getFechaFin() {
        return fechaFin;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String insertarPresupuesto(PresupuestoModel modeloPres) {
        Connection cx = conexion.conectar();
        if (cx != null) {
            try {
                String spInsertarPresupuesto = "{call insertarPresupuesto(?, ?, ?, ?)}";
                CallableStatement statement = cx.prepareCall(spInsertarPresupuesto);
                statement.setInt(1, modeloPres.getIdUsuario());
                statement.setDouble(2, modeloPres.getMonto());
                statement.setString(3, modeloPres.getFechaInicio());
                statement.setString(4, modeloPres.getFechaFin());
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

    public List<PresupuestoModel> obtenerPresupuesto(int idUsuario) {
        List<PresupuestoModel> presupuestos = new ArrayList<>();
        String query = "{call obtenerPresupuesto(?)}";
        try (Connection cx = conexion.conectar();
             CallableStatement statement = cx.prepareCall(query)) {
            statement.setInt(1, idUsuario);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    PresupuestoModel presupuesto = new PresupuestoModel();
                    presupuesto.setIdPresupuesto(resultSet.getInt("idPresupuesto"));
                    presupuesto.setMonto(resultSet.getDouble("monto"));
                    presupuesto.setFechaInicio(resultSet.getString("fechaInicio"));
                    presupuesto.setFechaFin(resultSet.getString("fechaFin"));
                    presupuestos.add(presupuesto);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return presupuestos;
    }

    public String modificarPresupuesto(PresupuestoModel modeloPres) {
        Connection cx = conexion.conectar();
        if (cx != null) {
            try {
                String spModificarPresupuesto = "{call modificarPresupuesto(?, ?, ?, ?)}";
                CallableStatement statement = cx.prepareCall(spModificarPresupuesto);
                statement.setInt(1, modeloPres.getIdPresupuesto());
                statement.setDouble(2, modeloPres.getMonto());
                statement.setString(3, modeloPres.getFechaInicio());
                statement.setString(4, modeloPres.getFechaFin());
                statement.executeUpdate();
                Sound.playSound("src/sound/success.wav");
                return "Modificado exitosamente";
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
}
