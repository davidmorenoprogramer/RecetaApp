package com.privatedev.recetaApp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.GoogleAuthProvider


class LoginActivity : AppCompatActivity() {
    private val googleRegisterLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ activityResult ->
        if(activityResult.resultCode == RESULT_OK){
           val task = GoogleSignIn.getSignedInAccountFromIntent(activityResult.data)
            manageResults(task)
        }
    }


    var textemail: EditText?= null;
    var textpass: EditText?= null;
    var errortext: TextView?= null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        textemail = findViewById(R.id.email)
        textpass = findViewById(R.id.pass)
        errortext = findViewById(R.id.error)

        session()
    }

    private fun session(){
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val email = prefs.getString("email",null)
        val provider = prefs.getString("provider",null)
        if (email!=null && provider !=null){
            showMenu(email, ProviderType.valueOf(provider))

        }

    }
    fun registrar(view: View) {

        val email = textemail?.text.toString().trim();
        val pass = textpass?.text.toString().trim();


        if (email.isNotEmpty() && pass.isNotEmpty()) {


                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            //en caso de que no exista email se envia string vacio, pero ya hemos comprovado que no puuede ser vacio
                            showMenu(it.result.user?.email ?: "", ProviderType.BASIC)
                        }
                    }.addOnFailureListener(){
                        when(it){
                            is FirebaseAuthException -> errortext?.text = error(it.errorCode);
                            is FirebaseAuthInvalidCredentialsException -> errortext?.text = it.errorCode;
                            is FirebaseAuthWeakPasswordException -> errortext?.text = it.errorCode;
                            else -> errortext?.text = "no sé cual es el error";
                        }


                    }



        }
        else{
            Toast.makeText(this,"Algunos campos están vacios",Toast.LENGTH_SHORT).show();
        }


    }


    fun googleregister(view: View){

        //configuración de google
        val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        val googleClient = GoogleSignIn.getClient(this,googleConf)
        googleClient.signOut()
        val sinInClient = googleClient.signInIntent
        googleRegisterLauncher.launch(sinInClient)

    }


    private fun manageResults(task: Task<GoogleSignInAccount>){
        val account: GoogleSignInAccount? = task.result
        if(account != null){
            val credential = GoogleAuthProvider.getCredential(account.idToken,null)
            FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                if(task.isSuccessful){
                    showMenu(it.result.user?.email ?: "", ProviderType.GOOGLE)
                }
            }
        }

    }

    fun login(view: View){

        val email = textemail?.text.toString().trim();
        val pass = textpass?.text.toString().trim();

        if (email.isNotEmpty() && pass.isNotEmpty()){

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        //en caso de que no exista email se envia string vacio, pero ya hemos comprovado que no puuede ser vacio
                        showMenu(it.result.user?.email ?: "", ProviderType.BASIC)
                   }
                }.addOnFailureListener(){
                    when(it){
                        is FirebaseAuthException -> errortext?.text = error(it.errorCode);
                        is FirebaseAuthInvalidCredentialsException -> errortext?.text = it.message;

                        else -> errortext?.text = "no sé cual es el error";
                    }


                }



        }
        else{
            Toast.makeText(this,"Algunos campos están vacios",Toast.LENGTH_SHORT).show();
        }


    }



    fun alertTask(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autenticar al usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun showMenu(email:String, provider: ProviderType){
        val Menuintent = Intent(this,MenuActivity::class.java)
        Menuintent.putExtra("email",email)
        Menuintent.putExtra("provider",provider.name)
        startActivity(Menuintent)
    }

}