package com.tgdevelops.wealthmate.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitializer {

    @PostConstruct
    public void initialize() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/static/tgdevelops-firebaseKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                        .setProjectId("tgdevelops-investment-tracker")
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();
        FirebaseApp.initializeApp(options);
    }
}
