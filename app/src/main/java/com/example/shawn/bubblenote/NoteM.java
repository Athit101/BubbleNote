package com.example.shawn.bubblenote;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;


    public class NoteM {

        private Context context;
        private String path = Environment.getExternalStorageDirectory().toString() + "/Notes/";

        public NoteM(Context _context) {
            this.context = _context;
        }

        public NoteM() {

        }

        public void CreateNewDirectory() {
            File mydir = new File(this.path);
            if (!mydir.exists())
                mydir.mkdirs();
            else
                Log.d("error", "dir. already exists");
        }

        public void SaveNote(String sFileName, String sBody) {
            try {
                File root = new File(this.path);
                if (!root.exists()) {
                    root.mkdirs();
                }
                File file = new File(root, sFileName);
                FileWriter writer = new FileWriter(file);
                writer.append(sBody);
                writer.flush();
                writer.close();
                Toast.makeText(this.context, "Saved", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                //importError = e.getMessage();
                //iError();
            }
        }

        public String readNote(String filename) {
            StringBuilder text = new StringBuilder();
            try {
                //File sdcard = Environment.getExternalStorageDirectory() + "/Notes/";
                File file = new File(this.path, filename);
                System.out.println("exception");

                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    text.append(line);
                    System.out.println("text : " + text + " : end");
                    text.append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("hello");

            }

            return text.toString();
        }

        public ArrayList<FileName> GetNotesList() {

            File f = new File(this.path);
            File file[] = f.listFiles();
            if (file != null) {
                System.out.println("Yes");
            } else
                System.out.println("NO");

                ArrayList<FileName> filenames = new ArrayList<FileName>();
                for (int i = 0; i < file.length; i++) {
                    String desc = new NoteM().readNote(file[i].getName());
                    FileName filename = new FileName(file[i].getName(), desc);
                    filenames.add(filename);
                }
                return filenames;
            }
        }
