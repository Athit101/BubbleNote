package com.example.shawn.bubblenote;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Note extends Activity {

    private NoteM nm;
    private String filename = null;
    private Bundle extras;
    private EditText et_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);

        et_note = (EditText) findViewById(R.id.et_note);

        extras = getIntent().getExtras();

        if(extras != null){

            filename = extras.getString("filename");
            nm = new NoteM(Note.this);
            String text = nm.readNote(filename);
            et_note.setText(text);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_save, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_save:
                SaveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void SaveNote(){

        if(filename == null){

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Note Name");
            alert.setMessage("Please input the note name.");

            // Set an EditText view to get user input
            final EditText input = new EditText(this);
            alert.setView(input);

            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    String value = input.getText().toString();
                    filename = value + ".txt";
                    new NoteM(Note.this).SaveNote(filename, et_note.getText().toString());
                }
            });

            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    // Canceled.
                }
            });

            alert.show();

        }else{

            new NoteM(Note.this).SaveNote(filename, et_note.getText().toString());
        }
    }

}
