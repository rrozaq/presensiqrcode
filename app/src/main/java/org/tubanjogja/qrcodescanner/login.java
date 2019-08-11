package org.tubanjogja.qrcodescanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.tubanjogja.qrcodescanner.DataHelper;
import org.tubanjogja.qrcodescanner.R;

import java.text.Normalizer;


public class login extends AppCompatActivity {
    SQLiteOpenHelper dbhelper;
    SQLiteDatabase db;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().setTitle("Login - Presensi");

        //Referencing UserEmail, Password EditText and TextView for SignUp Now
        final EditText txtusername = findViewById(R.id.username);
        final EditText txtpassword = findViewById(R.id.password);
        Button btnlogin = findViewById(R.id.masuk);

        //Opening SQLite Pipeline
        dbhelper = new DataHelper(this);
        db = dbhelper.getReadableDatabase();


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = txtusername.getText().toString();
                String pass = txtpassword.getText().toString();

//                cursor = db.rawQuery("SELECT * FROM user WHERE user=? AND pass=?",new String[] {user,pass});
//                if (user != null) {
//                    if(cursor.getCount() > 0) {
                if(user.equals("rozaq") && pass.equals("123")) {
//                        cursor.moveToFirst();
                        Toast.makeText(login.this, "Login Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login.this,MainActivity.class);
                        startActivity(intent);

                        //Removing MainActivity[Login Screen] from the stack for preventing back button press.
                        finish();
                    }
                    else {

                        //I am showing Alert Dialog Box here for alerting user about wrong credentials
                        final AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                        builder.setTitle("Alert");
                        builder.setMessage("Username or Password is wrong.");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();

                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                        //-------Alert Dialog Code Snippet End Here
                    }

            }
        });

    }

}