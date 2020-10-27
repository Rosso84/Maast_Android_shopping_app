package no.store.maast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_sign_in.*


class SignInFragment : Fragment() {

    private var mAuth: FirebaseAuth? = null
    //public var user:
    lateinit var signUpFragment: SignUpFragment;

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
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser: FirebaseUser? = mAuth?.getCurrentUser();
        updateUI(currentUser);
    }

    fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            Toast.makeText(activity, "Signed in as 'username'", Toast.LENGTH_LONG).show()
            //startActivity(Intent(this, AnotherActivity::class.java))
        } else {
            Toast.makeText(activity, "Not signed in", Toast.LENGTH_LONG).show()
        }
    }

    fun onClick(){
        btn_forgotPass.setOnClickListener {
            Toast.makeText(
                activity, "btn forgot pressed",
                Toast.LENGTH_SHORT
            ).show()
        }

        btn_signIn_google.setOnClickListener {
            Toast.makeText(
                activity, "btn google pressed.",
                Toast.LENGTH_SHORT
            ).show()
        }

        btn_login.setOnClickListener {
            Toast.makeText(
                activity, "btn login pressed.",
                Toast.LENGTH_SHORT
            ).show()
        }

        btn_signup.setOnClickListener {
            signUpFragment = SignUpFragment();
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout, signUpFragment)
            transaction?.addToBackStack("BackToSignInPage")
            transaction?.commit()

        }
    }

}