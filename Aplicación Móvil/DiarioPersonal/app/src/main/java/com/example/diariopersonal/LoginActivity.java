package com.example.diariopersonal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {

    private RelativeLayout layoutLogin, layoutRegister;
    private EditText edTxtNuevoEmail, edTxtNuevaContra, edTxtEmail, edTxtContra;
    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient googleSignInClient;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnRegistrarse = findViewById(R.id.BtnRegistrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutRegister.setVisibility(View.VISIBLE);
                layoutLogin.setVisibility(View.GONE);
            }
        });

        Button btnIniciar = findViewById(R.id.BtnIniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutLogin.setVisibility(View.VISIBLE);
                layoutRegister.setVisibility(View.GONE);
            }
        });

        Button btnCrear = findViewById(R.id.BtnCrear);
        layoutRegister = findViewById(R.id.LayoutRegister);
        edTxtNuevoEmail = findViewById(R.id.EdTxtNuevoEmail);
        edTxtNuevaContra = findViewById(R.id.EdTxtNuevaContra);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edTxtNuevoEmail.getText().toString().trim();
                String contra = edTxtNuevaContra.getText().toString().trim();
                String emailPattern = "[a-z0-9._-]+@[a-z]+\\.+[a-z]+";
                String contraPattern = "^(?=.*[0-9]).{8,}$";
                if (email.isEmpty() || contra.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
                }
                else if (!contra.matches(contraPattern)) {
                    Toast.makeText(LoginActivity.this, "La contraseña debe tener al menos 8 caracteres y 1 número", Toast.LENGTH_LONG).show();
                }
                else if (email.matches(emailPattern)) {
                    registrarCuenta(email, contra);
                } else {
                    Toast.makeText(LoginActivity.this, "Email no válido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnEntrar = findViewById(R.id.BtnEntrar);
        layoutLogin = findViewById(R.id.LayoutLogin);
        edTxtEmail = findViewById(R.id.EdTxtEmail);
        edTxtContra = findViewById(R.id.EdTxtContra);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edTxtEmail.getText().toString().trim();
                String contra = edTxtContra.getText().toString().trim();
                String emailPattern = "[a-z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (email.isEmpty() || contra.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
                }
                else if (email.matches(emailPattern)) {
                    iniciarSesion(email, contra);
                } else {
                    Toast.makeText(LoginActivity.this, "Email no válido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnGoogle = findViewById(R.id.BtnGoogle);
        auth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarYCerrar();
            }
        });
    }

    private void limpiarCampos() {
        edTxtEmail.setText("");
        edTxtContra.setText("");
        edTxtNuevoEmail.setText("");
        edTxtNuevaContra.setText("");
    }

    private void registrarCuenta(String email, String contra) {
        auth.createUserWithEmailAndPassword(email, contra)
            .addOnSuccessListener(authResult -> {
                Toast.makeText(LoginActivity.this, "Cuenta creada con éxito", Toast.LENGTH_SHORT).show();
                layoutLogin.setVisibility(View.VISIBLE);
                layoutRegister.setVisibility(View.GONE);
                limpiarCampos();
            })
            .addOnFailureListener(e -> {
                Toast.makeText(LoginActivity.this, "Error al crear la cuenta", Toast.LENGTH_SHORT).show();
            });
    }

    public void iniciarSesion(String email, String contra) {
        auth.signInWithEmailAndPassword(email, contra)
            .addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    FirebaseUser user = auth.getCurrentUser();
                    if (user != null) {
                    SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("uid", user.getUid());
                    editor.putString("email", user.getEmail());
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();

                    Toast.makeText(LoginActivity.this, "Se inició sesión correctamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, DiaryActivity.class);
                    startActivity(intent);
                    limpiarCampos();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
                }
            });
    }

    private void iniciarYCerrar() {
        googleSignInClient.signOut()
            .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                        iniciarConGoogle();
                    }
            });
    }
    private void iniciarConGoogle() {
        Intent intent = googleSignInClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            }
            catch (ApiException e) {
                Log.w("LoginActivity", "Error al iniciar sesión con Google", e);
                Toast.makeText(this, "Error de autenticación", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = auth.getCurrentUser();
                    if (user != null) {
                        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("uid", user.getUid());
                        editor.putString("email", user.getEmail());
                        editor.apply();

                        Toast.makeText(LoginActivity.this, "Se inició sesión correctamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, DiaryActivity.class);
                        startActivity(intent);
                        limpiarCampos();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}