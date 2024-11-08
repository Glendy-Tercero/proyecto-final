package com.rest.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class Firebase {

	public static void main(String[] args) throws IOException {
		if (FirebaseApp.getApps().isEmpty()) {
			FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://diariopersonalgp-default-rtdb.firebaseio.com/")
					.setStorageBucket("diariopersonalgp.appspot.com")
					.build();

			FirebaseApp.initializeApp(options);

			SpringApplication.run(Firebase.class, args);
		}
	}
}
