package com.example.walkinclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomePatient extends AppCompatActivity {

    private static User loggedInPatient = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        loggedInPatient = LoginActivity.getLoggedInUser();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_patient);

        String welcomeMsg;

        TextView eWelcome = (TextView) findViewById(R.id.welcomeMessage);
        //manipulating welcome text
        welcomeMsg = "Welcome " + loggedInPatient.getFirst_name() + "!\n You're logged in as an patient.";

        PatientClinicProfile.setSelectedClinic(null);
        PatientFilteredClinics.setSelectedClinic(null);
        PatientAllClinics.setSelectedClinic(null);
        PatientFilteredClinicByService.resetSelectedClinic();
        PatientFilteredClinicByService.resetSelectedService();

        eWelcome.setText(welcomeMsg);
    }

    public void profileButton(View view) {
        Intent intent = new Intent(this, PatientProfile.class);
        startActivity(intent);
    }

    public void welcomeSearchButton(View view) {
        Intent intent = new Intent(this, PatientSearch.class);
        startActivity(intent);
    }

    public void allClinicsButton(View view) {
        Intent intent = new Intent(this, PatientAllClinics.class);
        startActivity(intent);
    }

    public void searchByService(View view) {
        Intent intent = new Intent(this, PatientSearchByService.class);
        startActivity(intent);
    }

    public void logoffButton(View view){
        // HAVE TO CLEAR THE USERNAME AND PASSWORD
        //finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void bookingsBtn(View view) {
        Intent intent = new Intent(this, PatientMyBooks.class);
        startActivity(intent);    }

}
