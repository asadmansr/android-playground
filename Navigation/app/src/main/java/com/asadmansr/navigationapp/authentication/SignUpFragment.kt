package com.asadmansr.navigationapp.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.asadmansr.navigationapp.R
import com.asadmansr.navigationapp.core.SharedPreference


class SignUpFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        view.findViewById<Button>(R.id.btn_sign_up).setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_sign_up -> signUp()
        }
    }

    private fun signUp() {
        SharedPreference(requireContext()).authenticateUser(true)
        navigateToDashboard()
    }

    private fun navigateToDashboard() {
        Navigation.findNavController(requireView())
            .navigate(R.id.action_signUpFragment_to_dashboardFragment)
    }
}
