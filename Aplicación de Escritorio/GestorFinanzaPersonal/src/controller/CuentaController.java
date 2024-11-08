/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.CuentaModel;
import view.IniciarSesion;
import view.MenuPrincipal;
import view.NuevoRegistro;
import java.util.List;

public class CuentaController {
    
public CuentaController() {}

private CuentaModel modeloCue;
private IniciarSesion vistaSesion;
private MenuPrincipal vistaMenu;
private NuevoRegistro vistaNueRegi;

public CuentaController(CuentaModel model, IniciarSesion view) {
    this.modeloCue = model;
    this.vistaSesion = view;
}
public CuentaController(CuentaModel model, MenuPrincipal view) {
    this.modeloCue = model;
    this.vistaMenu = view;
}
public CuentaController(CuentaModel model, NuevoRegistro view) {
    this.modeloCue = model;
    this.vistaNueRegi = view;
}


public String InsertarCuenta(int idUsuario, String nombre, String tipo, double saldo) {
    modeloCue = new CuentaModel();
    modeloCue.setIdUsuario(idUsuario);
    modeloCue.setNombre(nombre);
    modeloCue.setTipo(tipo);
    modeloCue.setSaldo(saldo);
        
    return modeloCue.InsertarCuenta(modeloCue);
    }

public List<CuentaModel> obtenerCuenta(int idUsuario) {
    modeloCue = new CuentaModel();
    return modeloCue.obtenerCuenta(idUsuario);
    }

public String modificarCuenta(int idCuenta, String nombre, String tipo, double saldo) {
    modeloCue = new CuentaModel();   
    modeloCue.setIdUsuario(idCuenta);
    modeloCue.setNombre(nombre);
    modeloCue.setTipo(tipo);
    modeloCue.setSaldo(saldo);
    return modeloCue.modificarCuenta(modeloCue);
    }

}
