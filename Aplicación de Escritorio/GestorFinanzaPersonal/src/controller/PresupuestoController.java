/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.PresupuestoModel;
import view.IniciarSesion;
import view.MenuPrincipal;
import view.NuevoRegistro;
import java.util.List;

public class PresupuestoController {
    
    public PresupuestoController() {}
    
    private PresupuestoModel modeloPres;
    private IniciarSesion vistaSesion;
    private MenuPrincipal vistaMenu;
    private NuevoRegistro vistaNueRegi;

    public PresupuestoController(PresupuestoModel model, IniciarSesion view) {
        this.modeloPres = model;
        this.vistaSesion = view;
    }
    public PresupuestoController(PresupuestoModel model, MenuPrincipal view) {
        this.modeloPres = model;
        this.vistaMenu = view;
    }
    public PresupuestoController(PresupuestoModel model, NuevoRegistro view) {
        this.modeloPres = model;
        this.vistaNueRegi = view;
    }

    public String insertarPresupuesto(int idUsuario, double monto, String fechaInicio, String fechaFin) {
        modeloPres = new PresupuestoModel();
        modeloPres.setIdUsuario(idUsuario);
        modeloPres.setMonto(monto);
        modeloPres.setFechaInicio(fechaInicio);
        modeloPres.setFechaFin(fechaFin);

        return modeloPres.insertarPresupuesto(modeloPres);
    }

    public List<PresupuestoModel> obtenerPresupuesto(int idUsuario) {
        modeloPres = new PresupuestoModel();
        return modeloPres.obtenerPresupuesto(idUsuario);
    }

    public String modificarPresupuesto(int idPresupuesto, double monto, String fechaInicio, String fechaFin) {
        modeloPres = new PresupuestoModel();
        modeloPres.setIdPresupuesto(idPresupuesto);
        modeloPres.setMonto(monto);
        modeloPres.setFechaInicio(fechaInicio);
        modeloPres.setFechaFin(fechaFin);

        return modeloPres.modificarPresupuesto(modeloPres);
    }
    
}