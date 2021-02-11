package com.example.cxrili

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cxrili.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.*

class Registration : AppCompatActivity() {
    fun OnGobackBtn(v: View?) {
        finish()
    }


    fun EnterBtn2(v: View?){
        val MainActivityintent = Intent(this, MainActivity::class.java)
        startActivity(MainActivityintent)


    }
    private lateinit var registartionView : TextView
    private lateinit var Email : EditText
    private lateinit var Password1 : EditText
    private lateinit var OnGoBackBtn : Button
    private lateinit var EnterBtn2 : Button












    private lateinit var signInButton: SignInButton
        private lateinit var auth: FirebaseAuth
        private val TAG: String = "LOGIN"

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_registration)
            registartionView = findViewById(R.id.registartionView)
            Email = findViewById(R.id.Email)
            Password1 = findViewById(R.id.Password1)
            OnGoBackBtn = findViewById(R.id.OnGoBackBtn)
            EnterBtn2 = findViewById(R.id.EnterBtn2)







            signInButton = findViewById(R.id.signInButton)
            auth = FirebaseAuth.getInstance()
            // Configure Google Sign In
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build()
            val client = GoogleSignIn.getClient(this, gso);

            signInButton.setOnClickListener {

                val signInIntent = client.signInIntent
                startActivityForResult(signInIntent, constants.RC_SIGN_IN)

            }

        }


        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
            if (requestCode == constants.RC_SIGN_IN) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    val account = task.getResult(ApiException::class.java)!!
                    Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    // Google Sign In failed, update UI appropriately
                    Log.w(TAG, "Google sign in failed", e)
                    // ...
                }
            }
        }

        private fun firebaseAuthWithGoogle(idToken: String) {
            val credential = GoogleAuthProvider.getCredential(idToken, null)

            auth.signInWithCredential(credential)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success")
                            val user = auth.currentUser
                            updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.exception)

                            Toast.makeText(this, "Authentication Failed.", Toast.LENGTH_SHORT).show()
                            updateUI(null)
                        }

                    }
        }







    override fun onStart() {
            super.onStart()
            // Check if user is signed in (non-null) and update UI accordingly.
            val currentUser = auth.currentUser
            updateUI(currentUser)
    }

    private fun signIn() {
      //  val signInIntent = googleSignInClient.signInIntent
       // startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user == null) {
            Log.d("Login", "Go Back");
            return
        }

        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }
}




























