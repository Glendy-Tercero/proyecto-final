/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DeudaModel;
import view.IniciarSesion;
import view.MenuPrincipal;
import view.NuevoRegistro;
import java.util.List;

public class DeudaController {

public DeudaController() {}

private DeudaModel modeloDeu;
private IniciarSesion vistaSesion;
private MenuPrincipal vistaMenu;
private NuevoRegistro vistaNueRegi;


public DeudaController(DeudaModel model, IniciarSesion view) {
    this.modeloDeu = model;
    this.vistaSesion = view;
}
public DeudaController(DeudaModel model, MenuPrincipal view) {
    this.modeloDeu = model;
    this.vistaMenu = view;
}
public DeudaController(DeudaModel model, NuevoRegistro view) {
    this.modeloDeu = model;
    this.vistaNueRegi = view;
}


public String InsertarDeuda(int idUsuario, String descripcion, double monto, double interes, String plazo) {
    modeloDeu = new DeudaModel();
    modeloDeu.setIdUsuario(idUsuario);
    modeloDeu.setDescripcion(descripcion);
    modeloDeu.setMonto(monto);
    modeloDeu.setInteres(interes);
    modeloDeu.setPlazo(plazo);
        
    String mensaje = modeloDeu.InsertarDeuda(modeloDeu);
    return mensaje;
    }

public List<DeudaModel> obtenerDeuda(int idUsuario) {
    modeloDeu = new DeudaModel();
    return modeloDeu.obtenerDeuda(idUsuario);
    }

public String modificarDeuda(int idDeuda, String descripcion, double monto, double interes, String plazo) {
    modeloDeu = new DeudaModel();
    modeloDeu.setIdDeuda(idDeuda);
    modeloDeu.setDescripcion(descripcion);
    modeloDeu.setMonto(monto);
    modeloDeu.setInteres(interes);
    modeloDeu.setPlazo(plazo);
    return modeloDeu.modificarDeuda(modeloDeu);
}

}
