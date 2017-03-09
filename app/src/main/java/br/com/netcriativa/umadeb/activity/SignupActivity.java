package br.com.netcriativa.umadeb.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.netcriativa.umadeb.R;
import br.com.netcriativa.umadeb.model.User;

/**
 * Created by AndroidBash on 10/07/16
 */

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "AndroidBash";

    //Add YOUR Firebase Reference URL instead of the following URL
    private Firebase mRef = new Firebase("https://aplicativoumadeb.firebaseio.com/");
    private User user;
    private EditText name;
    private EditText phoneNumber;
    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        name = (EditText) findViewById(R.id.edit_text_username);
        phoneNumber = (EditText) findViewById(R.id.edit_text_phone_number);
        email = (EditText) findViewById(R.id.edit_text_new_email);
        password = (EditText) findViewById(R.id.edit_text_new_password);

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    //Este método configura um novo usuário por buscar os detalhes inseridos pelo usuário.
    protected void setUpUser() {
        user = new User();
        user.setName(name.getText().toString());
        user.setPhoneNumber(phoneNumber.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
    }

    public void onSignUpClicked(View view) {
        createNewAccount(email.getText().toString(), password.getText().toString());
        showProgressDialog();
    }


    private void createNewAccount(String email, String password) {
        Log.d(TAG, "createNewAccount:" + email);
        if (!validateForm()) {
            return;
        }
        // Este método configura um novo Usuário por buscar os detalhes inseridos pelo usuário.
        setUpUser();
        // Este método de método leva em um endereço de e-mail e senha, valida-los e, em seguida, cria um novo usuário
        // com o método createUserWithEmailAndPassword.
        // Se a nova conta foi criada, o usuário também está conectado e o AuthStateListener executa o callback onAuthStateChanged.
        // No callback, você pode usar o método getCurrentUser para obter os dados da conta do usuário.

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        hideProgressDialog();

                        // Se o login falhar, exiba uma mensagem para o usuário. Se o login for bem-sucedido
                        // o ouvinte do estado de autenticação será notificado ea lógica para lidar com o
                        // assinado no usuário pode ser manipulado no ouvinte.
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            onAuthenticationSucess(task.getResult().getUser());
                        }


                    }
                });

    }

    private void onAuthenticationSucess(FirebaseUser mUser) {
        // Escrever novo usuário
        saveNewUser(mUser.getUid(), user.getName(), user.getPhoneNumber(), user.getEmail(), user.getPassword());
        signOut();
        // Ir para LoginActivity
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        finish();
    }

    private void saveNewUser(String userId, String name, String phone, String email, String password) {
        User user = new User(userId, name, phone, email, password);

        mRef.child("users").child(userId).setValue(user);
    }


    private void signOut() {
        mAuth.signOut();
    }

    // Este método, valida o endereço de e-mail e a senhaa
    private boolean validateForm() {
        boolean valid = true;

        String userEmail = email.getText().toString();
        if (TextUtils.isEmpty(userEmail)) {
            email.setError("Required.");
            valid = false;
        } else {
            email.setError(null);
        }

        String userPassword = password.getText().toString();
        if (TextUtils.isEmpty(userPassword)) {
            password.setError("Required.");
            valid = false;
        } else {
            password.setError(null);
        }

        return valid;
    }


    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

}