package com.asadmansr.navigationapp.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.asadmansr.navigationapp.R


class TutorialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tutorial, container, false)

        view.findViewById<Button>(R.id.btn_tutorial_get_started).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_tutorialFragment_to_signUpFragment)
        }

        view.findViewById<Button>(R.id.btn_tutorial_login).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_tutorialFragment_to_logInFragment)
        }

        return view
    }
}
