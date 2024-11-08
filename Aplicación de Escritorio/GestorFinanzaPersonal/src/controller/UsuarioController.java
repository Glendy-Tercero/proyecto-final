package controller;

import gestorfinanzapersonal.Sesion;
import model.UsuarioModel;
import view.IniciarSesion;
import view.MenuPrincipal;
import view.NuevoRegistro;
import view.UsuarioPerfil;

public class UsuarioController {

public UsuarioController() {}

private UsuarioModel modeloUsu;
private IniciarSesion vistaSesion;
private MenuPrincipal vistaMenu;
private NuevoRegistro vistaNueRegi;
private UsuarioPerfil vistaUsuPer;

public UsuarioController(UsuarioModel model, IniciarSesion view) {
    this.modeloUsu = model;
    this.vistaSesion = view;
}
public UsuarioController(UsuarioModel model, MenuPrincipal view) {
    this.modeloUsu = model;
    this.vistaMenu = view;
}
public UsuarioController(UsuarioModel model, NuevoRegistro view) {
    this.modeloUsu = model;
    this.vistaNueRegi = view;
}
public UsuarioController(UsuarioModel model, UsuarioPerfil view) {
    this.modeloUsu = model;
    this.vistaUsuPer= view;
}

public String InsertarUsuario(String nombre, String email, String contraseña) {
    modeloUsu = new UsuarioModel();
    modeloUsu.setNombre(nombre);
    modeloUsu.setEmail(email);
    modeloUsu.setContraseña(contraseña);
        
    String mensaje = modeloUsu.InsertarUsuario(modeloUsu);
    return mensaje;
    }

public String IniciarSesion(String email, String contraseña) {
    modeloUsu = new UsuarioModel();
    String mensaje = modeloUsu.IniciarSesion(email, contraseña);
   if (mensaje.equals("Inicio de sesión exitoso")) {
        int idUsuario = modeloUsu.getIdUsuario();
        Sesion.getInstancia().setIdUsuario(idUsuario);
   }
   return mensaje;
}

    public int obtenerIdUsuario() {
        return Sesion.getInstancia().getIdUsuario();
    }

public UsuarioModel obtenerUsuario() {
    modeloUsu = new UsuarioModel();
    return modeloUsu.obtenerUsuario(Sesion.getInstancia().getIdUsuario());
}

public String ModificarUsuario(int idUsuario, String nombre, String email, String contraseña) {
    modeloUsu = new UsuarioModel();
    modeloUsu.setIdUsuario(idUsuario);
    modeloUsu.setNombre(nombre);
    modeloUsu.setEmail(email);
    modeloUsu.setContraseña(contraseña);
    return  modeloUsu.modificarUsuario( modeloUsu);
    }

public String eliminarUsuario(int idUsuario) {
    modeloUsu = new UsuarioModel();
    return modeloUsu.eliminarUsuario(Sesion.getInstancia().getIdUsuario());
    }

}
