package com.asadmansr.navigationapp.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.asadmansr.navigationapp.R


class WelcomeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        view.findViewById<Button>(R.id.btn_welcome_continue).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_welcome_continue -> navigateToTutorial()
        }
    }

    private fun navigateToTutorial() {
        Navigation.findNavController(requireView())
            .navigate(R.id.action_welcomeFragment_to_tutorialFragment)
    }
}
