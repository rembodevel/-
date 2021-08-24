package com.nickname.notes;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddNotesActivity extends AppCompatActivity {

    EditText title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (!TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(description.getText().toString())) {
            keyCode = KeyEvent.KEYCODE_BACK;
            DatabaseClass db = new DatabaseClass(com.nickname.notes.AddNotesActivity.this);
            db.addNotes(title.getText().toString(), description.getText().toString());

            Intent intent = new Intent(com.nickname.notes.AddNotesActivity.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();

        } else {
            DatabaseClass db = new DatabaseClass(com.nickname.notes.AddNotesActivity.this);
            db.deleteAllNotes();
            recreate();
            finish();
        }
        return true;
    }
}