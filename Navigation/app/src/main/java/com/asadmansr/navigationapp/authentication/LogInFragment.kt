package com.asadmansr.navigationapp.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.asadmansr.navigationapp.R

class LogInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_log_in, container, false)

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_logInFragment_to_dashboardFragment)
        }

        return view
    }

}
