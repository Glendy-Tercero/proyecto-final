package com.example.diariopersonal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
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

public class SearchActivity extends AppCompatActivity {
    private RecyclerView recyclerDiario;
    private List<Diary> diarios = new ArrayList<>();
    private DiaryAdapter adapter;
    private Retrofit retrofit;
    private DiaryService diaryService;
    private RelativeLayout relativeMenu;
    private int posicionSeleccionada = -1;
    private int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);
        String key = getIntent().getStringExtra("key");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Activity_Search), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        relativeMenu = findViewById(R.id.RelativeMenu);
        relativeMenu.setVisibility(View.GONE);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.66:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        diaryService = retrofit.create(DiaryService.class);

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        EditText edTxtBuscar = findViewById(R.id.EdTxtBuscar);
        edTxtBuscar.setOnEditorActionListener((v, action, event) -> {
            if (action == EditorInfo.IME_ACTION_SEARCH) {
                String usuarioUid = sharedPreferences.getString("uid", null);
                String fecha = edTxtBuscar.getText().toString().trim();
                buscarDiario(usuarioUid, fecha);
                return true;
            } return false;
        });

        Button btnEditar = findViewById(R.id.BtnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posicionSeleccionada != -1) {
                    Diary diarioSeleccionado = diarios.get(posicionSeleccionada);
                    Intent intent = new Intent(SearchActivity.this, SaveActivity.class);
                    intent.putExtra("diario", diarioSeleccionado);
                    startActivity(intent);
                }
            }
        });

        Button btnEliminar = findViewById(R.id.BtnEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Diary diary =  adapter.getPosicionDiario(posicion);
                String key = diary.getKey();
                if (key != null) {
                    eliminarDiario(key);
                    diarios.remove(posicionSeleccionada);
                    adapter.notifyItemRemoved(posicionSeleccionada);
                    relativeMenu.setVisibility(View.GONE);
                }
            }
        });

        recyclerDiario = findViewById(R.id.RecyclerDiarioB);
        recyclerDiario.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DiaryAdapter(diarios);
        recyclerDiario.setAdapter(adapter);
        adapter.setOnItemClickListener(new DiaryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int posicion) {
                diarioSeleccionado(posicion);
            }
        });
    }
    private void buscarDiario(String usuarioUid, String fecha) {
        if (usuarioUid != null) {
            Call<List<Diary>> call = diaryService.buscarDiario(usuarioUid, fecha);
            call.enqueue(new Callback<List<Diary>>() {
                @Override
                public void onResponse(Call<List<Diary>> call, Response<List<Diary>> response) {
                    List<Diary> diary = response.body();
                    if (diary != null && !diary.isEmpty()) {
                        diarios.clear();
                        diarios.addAll(diary);
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(SearchActivity.this, "No se encontraron resultados", Toast.LENGTH_SHORT).show();
                    }
                    if (!response.isSuccessful()) {
                        Toast.makeText(SearchActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<List<Diary>> call, Throwable t) {
                    Toast.makeText(SearchActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("Error", t.getMessage());
                }
            });
        }
    }

    public void eliminarDiario(String key){
        Call<Void> call = diaryService.eliminarDiario(key);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SearchActivity.this, "Eliminado con éxito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SearchActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "Error en la conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void diarioSeleccionado(int posicion) {
        if (posicionSeleccionada == posicion) {
            diarios.get(posicion).setSeleccionado(false);
            posicionSeleccionada = -1;
            relativeMenu.setVisibility(View.GONE);
        } else {
            if(posicion >= 0) {
                diarios.get(posicion).setSeleccionado(false);
            }
            diarios.get(posicion).setSeleccionado(true);
            posicionSeleccionada = posicion;
            relativeMenu.setVisibility(View.VISIBLE);
        }
        adapter.notifyItemChanged(posicion);
    }
}
