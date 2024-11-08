package com.example.diariopersonal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiaryActivity extends AppCompatActivity {

    private RecyclerView recyclerDiario;
    private List<Diary> diarios = new ArrayList<>();
    private DiaryAdapter adapter;
    private Retrofit retrofit;
    private DiaryService diaryService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_diary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Activity_Diary), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerDiario = findViewById(R.id.RecyclerDiario);
        recyclerDiario.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DiaryAdapter(diarios);
        recyclerDiario.setAdapter(adapter);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.66:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        diaryService = retrofit.create(DiaryService.class);

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        TextView txtEmail = findViewById(R.id.TxtEmail);
        String email = sharedPreferences.getString("email", null);
        txtEmail.setText(email);
        obtenerDiario();

        ImageView btnBuscar = findViewById(R.id.BtnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiaryActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        ImageView btnNuevo = findViewById(R.id.BtnNuevo);
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiaryActivity.this, SaveActivity.class);
                startActivity(intent);
            }
        });

        TextView txtTitulo = findViewById(R.id.TxtTitulo);
        txtTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDiario();
            }
        });

    }

    private void obtenerDiario() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String usuarioUid = sharedPreferences.getString("uid", null);
        if (usuarioUid != null) {
            Call<List<Diary>> call = diaryService.obtenerDiario(usuarioUid);
            call.enqueue(new Callback<List<Diary>>() {
                @Override
                public void onResponse(Call<List<Diary>> call, Response<List<Diary>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(DiaryActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    List<Diary> diary = response.body();
                    if (diary != null && !diary.isEmpty()) {
                        diarios.clear();
                        diarios.addAll(diary);
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<List<Diary>> call, Throwable t) {
                    Toast.makeText(DiaryActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("Error", t.getMessage());
                }
            });
        }
    }
}
