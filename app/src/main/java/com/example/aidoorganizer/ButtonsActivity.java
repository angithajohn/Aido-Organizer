package com.example.aidoorganizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ButtonsActivity extends AppCompatActivity {

    FloatingActionButton mrem, mcamera, maudio, mhand, mnote;
    TextView trem,tcam,taudio,thand,tnote, myCustomMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_buttons);

        mrem = findViewById(R.id.add_reminder);
        mcamera = findViewById(R.id.add_camera);
        maudio = findViewById(R.id.add_audio);
        mhand = findViewById(R.id.add_handwriting);
        mnote = findViewById(R.id.add_note);

        trem = findViewById(R.id.add_reminder_text);
        tcam = findViewById(R.id.add_camera_text);
        taudio = findViewById(R.id.add_audio_text);
        thand = findViewById(R.id.add_hand_text);
        tnote = findViewById(R.id.add_note_text);
        myCustomMessage = (TextView)findViewById(R.id.myCustommessage);

        mrem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_showMessage(view);
            }
        });
    }
    public void btn_showMessage(View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(ButtonsActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
        final EditText txt_inputText = (EditText)mView.findViewById(R.id.txt_input);
        Button btn_cancel = (Button)mView.findViewById(R.id.btn_cancel);
        Button btn_okay = (Button)mView.findViewById(R.id.btn_okay);
        alert.setView(mView);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCustomMessage.setText(txt_inputText.getText().toString());
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
