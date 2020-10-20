package no.store.maast

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_account.*


class AccountFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btn_forgotPass.setOnClickListener {
            Toast.makeText(
                activity,"btn forgot pressed",
                Toast.LENGTH_SHORT).show()
        }

        btn_signIn_google.setOnClickListener {
            Toast.makeText(
                activity,"btn google pressed.",
                Toast.LENGTH_SHORT).show()
        }

        btn_login.setOnClickListener {
            Toast.makeText(
                activity,"btn login pressed.",
                Toast.LENGTH_SHORT).show()
        }

        btn_signup.setOnClickListener {
            Toast.makeText(
                activity,"btn signup pressed.",
                Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }



}