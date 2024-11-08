/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DeudaModel;
import model.TransaccionModel;
import view.IniciarSesion;
import view.MenuPrincipal;
import view.NuevoRegistro;
import java.util.List;

public class TransaccionController {

public TransaccionController() {}

private TransaccionModel modeloTra;
private IniciarSesion vistaSesion;
private MenuPrincipal vistaMenu;
private NuevoRegistro vistaNueRegi;


public TransaccionController(TransaccionModel model, IniciarSesion view) {
    this.modeloTra = model;
    this.vistaSesion = view;
}
public TransaccionController(TransaccionModel model, MenuPrincipal view) {
    this.modeloTra = model;
    this.vistaMenu = view;
}
public TransaccionController(TransaccionModel model, NuevoRegistro view) {
    this.modeloTra = model;
    this.vistaNueRegi = view;
}


public String InsertarTransaccion(int idUsuario, int idCategoria, String fecha, double monto, String descripcion, String tipo) {
    modeloTra = new TransaccionModel();
    modeloTra.setIdUsuario(idUsuario);
    modeloTra.setIdCategoria(idCategoria);
    modeloTra.setFecha(fecha);
    modeloTra.setMonto(monto);
    modeloTra.setDescripcion(descripcion);
    modeloTra.setTipo(tipo);
        
    String mensaje = modeloTra.InsertarTransaccion(modeloTra);
    return mensaje;
    }

public int obtenerIdCategoria(String nombre) {
    modeloTra = new TransaccionModel();
    return modeloTra.obtenerIdCategoria(nombre);
    }

public String obtenerNombreCategoria(int idCategoria) {
    modeloTra = new TransaccionModel();
    return modeloTra.obtenerNombreCategoria(idCategoria);
    }

public List<TransaccionModel> obtenerTransaccion(int idUsuario) {
    modeloTra = new TransaccionModel();
    return modeloTra.obtenerTransaccion(idUsuario);
    }

public String modificarTransaccion(int idTransaccion, int idCategoria, String fecha, double monto, String descripcion, String tipo) {
    modeloTra = new TransaccionModel();
    modeloTra.setIdTransaccion(idTransaccion); 
    modeloTra.setIdCategoria(idCategoria);
    modeloTra.setFecha(fecha);
    modeloTra.setMonto(monto);
    modeloTra.setDescripcion(descripcion);
    modeloTra.setTipo(tipo);
    return modeloTra.modificarTransaccion(modeloTra);
}

}
