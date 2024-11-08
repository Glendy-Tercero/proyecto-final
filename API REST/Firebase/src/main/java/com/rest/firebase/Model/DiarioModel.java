package com.rest.firebase.Model;

public class DiarioModel {

    private String key;
    private String usuarioUid;
    private String fecha;
    private String hora;
    private String ubicacion;
    private String descripcion;
    private String imagen;

    public DiarioModel() {}

    public DiarioModel(String key, String usuarioUid, String fecha, String hora, String ubicacion, String descripcion, String imagen) {
        this.key = key;
        this.usuarioUid = usuarioUid;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getKey() {
        return key;
    }
    public String getUsuarioUid() {
        return usuarioUid;
    }
    public String getFecha() {
        return fecha;
    }
    public String getHora() {
        return hora;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getImagen() {
        return imagen;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public void setUsuarioUid(String usuarioUid) {
        this.usuarioUid = usuarioUid;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
