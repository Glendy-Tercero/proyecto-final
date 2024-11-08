package com.rest.firebase.Service;

import com.google.cloud.storage.BlobInfo;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.database.*;
import com.rest.firebase.Model.DiarioModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class DiarioService {

    private final DatabaseReference databaseReference;

    public DiarioService() {
        databaseReference = FirebaseDatabase.getInstance().getReference("diarios");
    }

    public String guardarImagen(MultipartFile imagen) throws IOException {
        String fileName = "imagenes/" + "-" + UUID.randomUUID().toString() + ".jpg";
        BlobInfo blobInfo = StorageClient.getInstance().bucket().create(fileName, imagen.getInputStream(), "image/jpeg");
        String mediaLink = blobInfo.getMediaLink();
        String[] parts = mediaLink.split("\\?token=");
        String token = parts.length > 1 ? parts[1] : "";

        return String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media&token=%s", "diariopersonalgp.appspot.com",
                URLEncoder.encode(fileName, "UTF-8"),
                token);
    }

    public void guardarDiario(DiarioModel diario, MultipartFile imagen) throws IOException {
        String key = databaseReference.push().getKey();
        diario.setKey(key);
        String imagenUrl = guardarImagen(imagen);
        diario.setImagen(imagenUrl);
        databaseReference.child(key).setValueAsync(diario);
    }

    public CompletableFuture<List<DiarioModel>> obtenerDiarioPorUID(String uid) {
        CompletableFuture<List<DiarioModel>> future = new CompletableFuture<>();
        List<DiarioModel> diarios = new ArrayList<>();
        databaseReference.orderByChild("usuarioUid").equalTo(uid)
            .addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        for (DataSnapshot diarioSnapshot : snapshot.getChildren()) {
                            DiarioModel diario = diarioSnapshot.getValue(DiarioModel.class);
                            diarios.add(diario);
                        }
                    } future.complete(diarios);
                } @Override
                public void onCancelled(DatabaseError error) {
                    future.completeExceptionally(error.toException());
                }
            }); return future;
    }

    public CompletableFuture<List<DiarioModel>> buscarDiarioPorFecha(String uid, String fecha) {
        CompletableFuture<List<DiarioModel>> future = new CompletableFuture<>();
        List<DiarioModel> diarios = new ArrayList<>();
        databaseReference.orderByChild("fecha").equalTo(fecha)
            .addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        for (DataSnapshot diarioSnapshot : snapshot.getChildren()) {
                            DiarioModel diario = diarioSnapshot.getValue(DiarioModel.class);
                            if (diario.getUsuarioUid().equals(uid)) {
                                diarios.add(diario);
                            }
                        }
                    } future.complete(diarios);
                } @Override
                public void onCancelled(DatabaseError error) {
                    future.completeExceptionally(error.toException());
                }
            }); return future;
    }

    public void editarDiario(DiarioModel diario, MultipartFile nuevaImagen) throws IOException {
        DatabaseReference diarioRef = databaseReference.child(diario.getKey());
        diarioRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    DiarioModel diario = dataSnapshot.getValue(DiarioModel.class);
                    if (diario != null && diario.getImagen() != null) {
                        eliminarImagen(diario.getImagen());
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        String nuevaImagenUrl = guardarImagen(nuevaImagen);
        diario.setImagen(nuevaImagenUrl);
        String diaryKey = diario.getKey();
        databaseReference.child(diaryKey).setValueAsync(diario);
    }

    private void eliminarImagen(String imagenUrl) {
        try {
            String fileName = imagenUrl.split("\\?")[0];
            fileName = fileName.replace("https://firebasestorage.googleapis.com/v0/b/diariopersonalgp.appspot.com/o/", "");
            fileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8.name());
            StorageClient.getInstance().bucket().get(fileName).delete();
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar: " + e.getMessage(), e);
        }
    }

    public void eliminarDiario(String diarioKey) {
        DatabaseReference diarioRef = databaseReference.child(diarioKey);
        diarioRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    DiarioModel diario = dataSnapshot.getValue(DiarioModel.class);
                    if (diario != null && diario.getImagen() != null) {
                        eliminarImagen(diario.getImagen());
                    }
                    diarioRef.removeValueAsync(); }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }
}
