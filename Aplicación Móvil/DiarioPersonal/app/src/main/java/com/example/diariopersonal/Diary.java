package com.example.diariopersonal;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Diary implements Serializable {
    private String key;
    private String usuarioUid;
    private String fecha;
    private String hora;
    private String ubicacion;
    private String descripcion;
    private String imagen;
    private boolean seleccionar;

    public Diary(String usuarioUid, String fecha, String hora, String ubicacion, String descripcion) {
        this.usuarioUid = usuarioUid;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
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
    public Diary(boolean seleccionar){
        this.seleccionar = seleccionar;
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
    public boolean getSeleccionar() {
        return seleccionar;
    }
    public void setSeleccionado(boolean seleccionado) {
        seleccionar = seleccionado;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("usuarioUid", this.usuarioUid);
        jsonObject.addProperty("fecha", this.fecha);
        jsonObject.addProperty("hora", this.hora);
        jsonObject.addProperty("ubicacion", this.ubicacion);
        jsonObject.addProperty("descripcion", this.descripcion);

        return jsonObject;
    }
}
