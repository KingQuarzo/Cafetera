package com.example.cafetera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cafetera.Usuario.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    Button btnLogin;
    EditText txtUderId, txtPassword;

    DatabaseReference bbdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void initialize(){
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtUderId = (EditText) findViewById(R.id.txtUserId);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        bbdd = FirebaseDatabase.getInstance().getReference(getString(R.string.campo_id));
    }

    public  void validate(String userId, String password){

//        Usuario usuario = new Usuario(txtUderId.getText().toString(), txtPassword.getText().toString());
//        String clave = bbdd.push().getKey();
//        bbdd.child(clave);

        bbdd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Usuario usuario = dataSnapshot.getValue(Usuario.class);

                    if (usuario.getId().equals(txtUderId.getText().toString()) &&
                            usuario.getPassword().equals(txtPassword.getText().toString())){
                        
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    public void nextPage(){
        Intent i = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(i);
    }

}
