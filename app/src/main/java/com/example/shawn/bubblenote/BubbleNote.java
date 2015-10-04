package com.example.shawn.bubblenote;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;



public class BubbleNote extends Activity {

    ArrayList<FileName> filenames;
    ListViewA adapter;
    ListView lv_filenames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_note);
        NoteM nm = new NoteM(getApplicationContext());
        nm.CreateNewDirectory();
        filenames = nm.GetNotesList();

        adapter = new ListViewA(this, R.layout.list, filenames);

        lv_filenames = (ListView) findViewById(R.id.List);
        lv_filenames.setAdapter(adapter);
        lv_filenames.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(BubbleNote.this, Note.class);
                intent.putExtra("filename", filenames.get(position).getName());
                startActivity(intent);
            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bubble_note, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_add:
                Intent intent = new Intent(BubbleNote.this, Note.class);
                startActivity(intent);
                return true;

            case R.id.ME:

                AlertDialog.Builder builder = new AlertDialog.Builder(BubbleNote.this);

                builder.setMessage("Created by : The A Team")
                        .setTitle("Credits");

                AlertDialog dialog = builder.create();
                dialog.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}