package com.asadmansr.navigationapp.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.asadmansr.navigationapp.R
import com.asadmansr.navigationapp.core.SharedPreference

class DashboardFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        view.findViewById<Button>(R.id.btn_dashboard_sign_out).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_dashboard_sign_out -> signOut()
        }
    }

    private fun signOut() {
        SharedPreference(requireContext()).authenticateUser(false)
        navigateToTutorialScreen()
    }

    private fun navigateToTutorialScreen() {
        Navigation.findNavController(requireView())
            .navigate(R.id.action_dashboardFragment_to_tutorialFragment)
    }

}
