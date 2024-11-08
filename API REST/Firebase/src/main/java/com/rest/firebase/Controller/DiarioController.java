package com.rest.firebase.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.firebase.Model.DiarioModel;
import com.rest.firebase.Service.DiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/diario")
public class DiarioController {

    @Autowired
    private DiarioService diarioService;

    @PostMapping
    public String guardarDiario(@RequestPart("diario") String diarioJson, @RequestPart("imagen") MultipartFile imagen) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            DiarioModel diario = objectMapper.readValue(diarioJson, DiarioModel.class);
            diarioService.guardarDiario(diario, imagen);
            return "Diario guardado";
        } catch (IOException e) {
            return "Error al guardar: " + e.getMessage();
        }
    }

    @GetMapping("/{uid}")
    public ResponseEntity<List<DiarioModel>> obtenerDiarioPorUID(@PathVariable String uid) {
        CompletableFuture<List<DiarioModel>> futureDiarios = diarioService.obtenerDiarioPorUID(uid);
        return (ResponseEntity<List<DiarioModel>>) futureDiarios.thenApply(diarios -> {
            if (diarios.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(diarios);
            }).exceptionally(error -> { return ResponseEntity.internalServerError().build(); }).join();
    }

    @GetMapping("/{uid}/{fecha}")
    public ResponseEntity<List<DiarioModel>> buscarDiarioPorFecha(@PathVariable String uid, @PathVariable String fecha) {
        CompletableFuture<List<DiarioModel>> futureDiarios = diarioService.buscarDiarioPorFecha(uid, fecha);
        return (ResponseEntity<List<DiarioModel>>) futureDiarios.thenApply(diarios -> {
            if (diarios.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(diarios);
        }).exceptionally(error -> { return ResponseEntity.internalServerError().build(); }).join();
    }

    @PutMapping("/{diarioKey}")
    public ResponseEntity<String> editarDiario(@PathVariable String diarioKey, @RequestPart("diario") String diarioJson, @RequestPart("imagen") MultipartFile nuevaImagen) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            DiarioModel diario = objectMapper.readValue(diarioJson, DiarioModel.class);
            diario.setKey(diarioKey);
            diarioService.editarDiario(diario, nuevaImagen);
            return ResponseEntity.ok("Diario modificado");
        } catch (IOException e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{diarioKey}")
    public ResponseEntity<String> eliminarDiario(@PathVariable String diarioKey) {
        diarioService.eliminarDiario(diarioKey);
        return ResponseEntity.ok("Diario eliminado");
    }
}
