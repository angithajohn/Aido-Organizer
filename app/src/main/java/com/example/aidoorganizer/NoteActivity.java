package com.example.aidoorganizer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.evernote.client.android.EvernoteSession;
import com.evernote.client.android.EvernoteUtil;
import com.evernote.client.android.asyncclient.EvernoteCallback;
import com.evernote.client.android.asyncclient.EvernoteNoteStoreClient;
import com.evernote.edam.type.Note;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        EditText edittitle = (EditText)findViewById(R.id.note_title);
        EditText editnote = (EditText)findViewById(R.id.note_content);
        TextView tview1 = (TextView)findViewById(R.id.text1);
        TextView tview2 = (TextView)findViewById(R.id.text2);
        TextView tview3 = (TextView)findViewById(R.id.text3);
        edittitle.getText().toString();
        tview1.setText((CharSequence) edittitle);
        editnote.getText().toString();
        tview2.setText((CharSequence) editnote);
        tview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setup the alert builder
                AlertDialog.Builder builder = new AlertDialog.Builder(NoteActivity.this);
                builder.setTitle("Choose an animal");// add a list
                String[] animals = {"horse", "cow", "camel", "sheep", "goat"};
                builder.setItems(animals, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0: // horse
                            case 1: // cow
                            case 2: // camel
                            case 3: // sheep
                            case 4: // goat
                        }
                    }
                });// create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        EvernoteNoteStoreClient noteStoreClient = EvernoteSession.getInstance().getEvernoteClientFactory().getNoteStoreClient();

        Note note = new Note();
        note.setTitle(String.valueOf(edittitle));
        note.setContent(EvernoteUtil.NOTE_PREFIX + "My content" + EvernoteUtil.NOTE_SUFFIX);

        noteStoreClient.createNoteAsync(note, new EvernoteCallback<Note>() {
            @Override
            public void onSuccess(Note result) {
                Toast.makeText(getApplicationContext(), result.getTitle() + " has been created", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onException(Exception exception) {
                Log.i("Creating note","sucess");
            }
        });
    }

//    public void note_alert(){
//        // setup the alert builder
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Choose an animal");// add a list
//        String[] animals = {"horse", "cow", "camel", "sheep", "goat"};
//        builder.setItems(animals, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                switch (which) {
//                    case 0: // horse
//                    case 1: // cow
//                    case 2: // camel
//                    case 3: // sheep
//                    case 4: // goat
//                }
//            }
//        });// create and show the alert dialog
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }
}