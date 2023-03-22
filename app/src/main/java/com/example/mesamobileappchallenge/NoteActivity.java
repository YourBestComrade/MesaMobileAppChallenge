package com.example.mesamobileappchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class NoteActivity extends AppCompatActivity {
    DatePickerDialog.OnDateSetListener dateSetListener;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity);

        final MediaPlayer lighterSound = MediaPlayer.create(NoteActivity.this,R.raw.zippolighterflickpe1033011);
        ImageButton deleteButton = findViewById(R.id.deleteButton);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText noteTitle = findViewById(R.id.noteTitle);
                EditText noteField = findViewById(R.id.noteField);
                TextView noteDate = findViewById(R.id.noteDate);

                noteTitle.setText("");
                noteField.setText("");
                noteDate.setText("");
                lighterSound.start();
                showSnackbar();
            }
        });

        TextView textDate = findViewById(R.id.noteDate);

        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        NoteActivity.this,
                        android.R.style.Theme_Holo_Light,
                        dateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = month + "/" + dayOfMonth + "/" + year;
                textDate.setText(date);
            }
        };
    }

    public void showSnackbar(){
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Note deleted", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}