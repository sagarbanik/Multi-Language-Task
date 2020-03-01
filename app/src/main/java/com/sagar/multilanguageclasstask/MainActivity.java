package com.sagar.multilanguageclasstask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import dmax.dialog.SpotsDialog;

public class MainActivity extends AppCompatActivity {

    Button btnBangla,btnEng;

    TextView firstName,lastName,mobileNumber,address;

    Resources resources;

    String firstNameD,lastNameD,mobileNumberD,addressD;

    private String firstName1,lastName1,mobileNumber1,address1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog dialog = new SpotsDialog.Builder().setContext(this).build();
        dialog.show();

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        mobileNumber = findViewById(R.id.mobileNumber);
        address = findViewById(R.id.address);

        btnBangla = findViewById(R.id.btnBangla);
        btnEng = findViewById(R.id.btnEng);


        //Getting Strings from the array
        firstNameD = getResources().getString(R.string.first_name);
        lastNameD = getResources().getString(R.string.last_name);
        mobileNumberD = getResources().getString(R.string.mobile_number);
        addressD = getResources().getString(R.string.address);



        btnBangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("bn");
                Locale.setDefault(locale);

                Configuration configuration = new Configuration();
                configuration.locale = locale;

                getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());


                firstNameD = getResources().getString(R.string.first_name);
                lastNameD = getResources().getString(R.string.last_name);
                mobileNumberD = getResources().getString(R.string.mobile_number);
                addressD = getResources().getString(R.string.address);

                firstName.setText(firstNameD);
                lastName.setText(lastNameD);
                mobileNumber.setText(mobileNumberD);
                address.setText(addressD);
            }
        });

        btnEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Locale locale = new Locale("en");
                Locale.setDefault(locale);

                Configuration configuration = new Configuration();
                configuration.locale = locale;

                getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

                firstNameD = getResources().getString(R.string.first_name);
                lastNameD = getResources().getString(R.string.last_name);
                mobileNumberD = getResources().getString(R.string.mobile_number);
                addressD = getResources().getString(R.string.address);


                firstName.setText(firstNameD);
                lastName.setText(lastNameD);
                mobileNumber.setText(mobileNumberD);
                address.setText(addressD);

            }
        });



    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putString("FirstName", firstNameD);
        savedInstanceState.putString("LastName",lastNameD);
        savedInstanceState.putString("MobileNumber",mobileNumberD);
        savedInstanceState.putString("Address",addressD);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        firstName1 = savedInstanceState.getString("FirstName");
        lastName1 = savedInstanceState.getString("LastName");
        mobileNumber1 = savedInstanceState.getString("MobileNumber");
        address1 = savedInstanceState.getString("Address");

        firstName.setText(firstName1);
        lastName.setText(lastName1);
        mobileNumber.setText(mobileNumber1);
        address.setText(address1);

    }
}
