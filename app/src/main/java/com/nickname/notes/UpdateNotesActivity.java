package com.nickname.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateNotesActivity extends AppCompatActivity {

    EditText title,description;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notes);

        title=findViewById(R.id.title);
        description=findViewById(R.id.description);

        Intent i =getIntent();
        title.setText(i.getStringExtra("title"));
        description.setText(i.getStringExtra("description"));
        id=i.getStringExtra("id");
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        //replaces the default 'Back' button action
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            com.nickname.notes.DatabaseClass db = new com.nickname.notes.DatabaseClass(com.nickname.notes.UpdateNotesActivity.this);
            db.updateNotes(title.getText().toString(),description.getText().toString(),id);

            Intent i=new Intent(com.nickname.notes.UpdateNotesActivity.this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        }
        return true;
    }

}