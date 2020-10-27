package no.store.maast

import android.R.attr
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_sign_up.*


class SignUpFragment : Fragment() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance();
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    private fun onClick() {

        btn_register_sign_up.setOnClickListener {
            val mFullName = edt_email_sign_up.text!!
            val mPassw = edt_pass_sign_up.text!!
            registerNewUser(mFullName.toString(), mPassw.toString())
            /*if (isEmptyFields() == true) {
                Toast.makeText(activity, "One or more fields is left empty", Toast.LENGTH_LONG).show()
            }else
            if (isSamePasswordEntered() == false) {
                Toast.makeText(activity, "Passwords did not match", Toast.LENGTH_LONG).show()
            }else{
                val mFullName = edt_name_sign_up.text!!
                val mPassw = edt_pass_sign_up.text!!
                Toast.makeText(activity,"registered",Toast.LENGTH_LONG).show()
                registerNewUser( mFullName.toString(), mPassw.toString() )
            }*/
        }
    }

     fun registerNewUser(email: String, password: String) {
         mAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task: Task<AuthResult> ->
                 if (task.isSuccessful) {
                     // Sign in success, update UI with the signed-in user's information
                     Log.d("Firebase", "createUserWithEmail:success")
                     val user = mAuth!!.currentUser
                     updateUI(user)
                 } else {
                     // If sign in fails, display a message to the user.
                     Log.w("Firebase", "createUserWithEmail:failure", task.exception)
                     Toast.makeText(activity, "Authentication failed.",
                         Toast.LENGTH_SHORT).show()
                     updateUI(null)
                 }

             }
    }



    fun isEmptyFields(): Boolean? {
        val mFullName = edt_name_sign_up.text!!;
        val mEmail = edt_email_sign_up.text!!;
        val mPhone = edt_phoneNumber_sign_up.text!!;

        if (TextUtils.isEmpty(mFullName.toString()) || TextUtils.isEmpty(mEmail.toString()) || TextUtils.isEmpty(mPhone.toString())) {
            return true;
        }
        return false;
    }

    fun isSamePasswordEntered(): Boolean? {
        val mPassw = edt_pass_sign_up.text!!;
        val mPasswRep = edt_pass_sign_up_repeat.text!!;

        if (!mPassw.toString().equals(mPasswRep.toString())) {
            return false;
        }
        return true;
    }

    fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            Toast.makeText(activity, "Signed in as 'username'", Toast.LENGTH_LONG).show()
            //startActivity(Intent(this, AnotherActivity::class.java))
        } else {
            Toast.makeText(activity, "Not signed in", Toast.LENGTH_LONG).show()
        }
    }


}

