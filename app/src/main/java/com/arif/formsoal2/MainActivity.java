package com.arif.formsoal2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextTelp;
    private RadioGroup radioGroupGender;
    private RadioButton radioMale, radioFemale;
    private CheckBox checkboxHobi1, checkboxHobi2, checkboxHobi3;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi view
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelp = findViewById(R.id.editTextTelp);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        checkboxHobi1 = findViewById(R.id.checkboxHobi1);
        checkboxHobi2 = findViewById(R.id.checkboxHobi2);
        checkboxHobi3 = findViewById(R.id.checkboxHobi3);
        buttonSubmit = findViewById(R.id.buttonSubmit);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {

        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String telp = editTextTelp.getText().toString();


        String gender = "";
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        if (selectedId == R.id.radioMale) {
            gender = "Laki-Laki";
        } else if (selectedId == R.id.radioFemale) {
            gender = "Perempuan";
        }


        StringBuilder hobbies = new StringBuilder("Hobi: ");
        if (checkboxHobi1.isChecked()) hobbies.append("Olahraga ");
        if (checkboxHobi2.isChecked()) hobbies.append("Akademis ");
        if (checkboxHobi3.isChecked()) hobbies.append("Seni ");


        String message = "Nama: " + name + "\nEmail: " + email + "\nTelepon: " + telp +
                "\nGender: " + gender + "\n" + hobbies.toString().trim();

        new AlertDialog.Builder(this)
                .setTitle("Informasi Pendaftaran")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Menutup dialog
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info) // Ikon opsional
                .show();
    }

}