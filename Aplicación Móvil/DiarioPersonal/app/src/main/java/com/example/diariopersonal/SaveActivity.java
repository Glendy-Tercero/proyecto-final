package com.example.diariopersonal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SaveActivity extends AppCompatActivity {
    private EditText edTxtFecha, edTxtHora, edTxtUbicacion, edTxtDescripcion;
    private TextView txtImagen, txtDireccion, txtKey;
    private ImageView nuevaImagen;
    private DiaryService diaryService;
    private Retrofit retrofit;
    private boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_save);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Activity_Save), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.66:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        diaryService = retrofit.create(DiaryService.class);

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        edTxtFecha = findViewById(R.id.EdTxtFecha);
        edTxtHora = findViewById(R.id.EdTxtHora);
        edTxtUbicacion = findViewById(R.id.EdTxtUbicacion);
        edTxtDescripcion = findViewById(R.id.EdTxtDescripcion);
        txtImagen = findViewById(R.id.TxtImagen);
        txtDireccion = findViewById(R.id.TxtDireccion);
        txtKey = findViewById(R.id.TxtKey);
        nuevaImagen = findViewById(R.id.NuevaImagen);
        Button btnGuardar = findViewById(R.id.BtnGuardar);

        txtDireccion.setVisibility(View.GONE);
        txtKey.setVisibility(View.GONE);

        txtImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 2);
            }
        });

        Diary diario = (Diary) getIntent().getSerializableExtra("diario");
        if (diario != null) {
            isEditMode = true;
            btnGuardar.setText("Editar");
            obtenerDiario(diario);
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuarioUid = sharedPreferences.getString("uid", null);
                String fecha = edTxtFecha.getText().toString().trim();
                String hora = edTxtHora.getText().toString().trim();
                String ubicacion = edTxtUbicacion.getText().toString().trim();
                String descripcion = edTxtDescripcion.getText().toString().trim();
                Uri imagenUri = Uri.parse(txtDireccion.getText().toString());

                if (fecha.isEmpty() || hora.isEmpty() || ubicacion.isEmpty() || descripcion.isEmpty() || imagenUri == null) {
                    Toast.makeText(SaveActivity.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    if (isEditMode) {
                        Diary diary = new Diary(usuarioUid, fecha, hora, ubicacion, descripcion);
                        editarDiario(diary, imagenUri);
                    } else {
                        Diary diary = new Diary(usuarioUid, fecha, hora, ubicacion, descripcion);
                        guardarDiario(diary, imagenUri);
                    }
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            nuevaImagen.setImageURI(selectedImage);
            txtDireccion.setText(selectedImage.toString());
        }
    }

    public String getRealPathFromURI(Uri uri) {
        String result;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor == null) {
            result = uri.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        } return result;
    }

    private void guardarDiario(Diary diary, Uri imagenUri) {
        JsonObject diarioJson = diary.toJson();
        RequestBody diarioPart = RequestBody.create(MediaType.parse("application/json"), diarioJson.toString());

        File file = new File(getRealPathFromURI(imagenUri));
        RequestBody imagenPart = RequestBody.create(MediaType.parse("image/jpeg"), file);
        MultipartBody.Part imagenBody = MultipartBody.Part.createFormData("imagen", file.getName(), imagenPart);

        Call<Void> call = diaryService.guardarDiario(diarioPart, imagenBody);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.d("JSON enviado", diarioJson.toString());
                    Log.d("Headers", response.headers().toString());
                    Log.d("Respuesta del servidor", response.body() != null ? response.body().toString() : "Respuesta vacía");
                    Toast.makeText(SaveActivity.this, "Guardado con éxito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SaveActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(SaveActivity.this, "Error en la conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void obtenerDiario(Diary diario) {
        edTxtFecha.setText(diario.getFecha());
        edTxtHora.setText(diario.getHora());
        edTxtUbicacion.setText(diario.getUbicacion());
        edTxtDescripcion.setText(diario.getDescripcion());
        txtKey.setText(diario.getKey());
        txtDireccion.setText(diario.getImagen());
        if (diario.getImagen() != null) {
            Uri imagenUri = Uri.parse(diario.getImagen());
            Glide.with(this)
                    .load(imagenUri)
                    .into(nuevaImagen);
        }
    }

    private void editarDiario(Diary diario, Uri imagenUri) {
        JsonObject diarioJson = diario.toJson();
        RequestBody diarioPart = RequestBody.create(MediaType.parse("application/json"), diarioJson.toString());

        File file = new File(getRealPathFromURI(imagenUri));
        RequestBody imagenPart = RequestBody.create(MediaType.parse("image/jpeg"), file);
        MultipartBody.Part imagenBody = MultipartBody.Part.createFormData("imagen", file.getName(), imagenPart);

        String diarioKey = txtKey.getText().toString().trim();
        Call<Void> call = diaryService.editarDiario(diarioKey, diarioPart, imagenBody);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SaveActivity.this, "Editado con éxito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SaveActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(SaveActivity.this, "Error en la conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
