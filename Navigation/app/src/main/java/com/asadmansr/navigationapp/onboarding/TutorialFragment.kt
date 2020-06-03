package com.asadmansr.navigationapp.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.asadmansr.navigationapp.R
import com.asadmansr.navigationapp.core.SharedPreference


class TutorialFragment : Fragment(), View.OnClickListener {

    private lateinit var btnGetStarted: Button
    private lateinit var btnLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tutorial, container, false)
        btnGetStarted = view.findViewById<Button>(R.id.btn_tutorial_get_started)
        btnLogin = view.findViewById<Button>(R.id.btn_tutorial_login)
        setupView()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkUserAuthentication()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_tutorial_get_started -> navigateToSignUp()
            R.id.btn_tutorial_login -> navigateToLogin()
        }
    }

    private fun setupView() {
        btnGetStarted.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        modifyButtonState(isEnabled = false)
    }

    private fun modifyButtonState(isEnabled: Boolean) {
        btnGetStarted.isEnabled = isEnabled
        btnLogin.isEnabled = isEnabled
    }

    private fun checkUserAuthentication() {
        val isUserSignedIn = SharedPreference(requireContext()).isUserSignedIn()
        if (isUserSignedIn) {
            navigateToDashboard()
        } else {
            modifyButtonState(isEnabled = true)
        }
    }

    private fun navigateToSignUp() {
        Navigation.findNavController(requireView())
            .navigate(R.id.action_tutorialFragment_to_signUpFragment)
    }

    private fun navigateToLogin() {
        Navigation.findNavController(requireView())
            .navigate(R.id.action_tutorialFragment_to_logInFragment)
    }

    private fun navigateToDashboard() {
        Navigation.findNavController(requireView())
            .navigate(R.id.action_tutorialFragment_to_dashboardFragment)
    }
}
