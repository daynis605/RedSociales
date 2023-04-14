package com.app.gantabi.auth.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.app.gantabi.auth.R
import com.app.gantabi.auth.databinding.FragmentAuthBinding
import com.app.gantabi.auth.domain.model.Account
import com.app.gantabi.auth.ui.viewModel.AuthViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthFragment @Inject constructor() : Fragment(), LoginResultCallBacks {

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("FRAGMENT")
        redirectRegistrer()
        setupTextFields()
        onClickLogin()

    }

    private fun redirectRegistrer() {
        binding.registre.setOnClickListener {
            findNavController().navigate(
                R.id.action_authFragment_to_registerFragment, null, null
            )
        }
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun onClickLogin() {
        binding.btonLogin.setOnClickListener {

            authViewModel.login(
                binding.textEmail.text.toString().trim(),
                binding.textPassword.text.toString().trim()
            )
            authViewModel._uiToken.observe(this) {
                when {
                    (it.code == 400) -> {
                        Snackbar.make(binding.root, "ERROR", Snackbar.LENGTH_SHORT).show()
                    }
                    (it.code == 200) -> {
                        Snackbar.make(binding.root, "SIN ERROR", Snackbar.LENGTH_SHORT).show()
                    }
                    else -> false
                }
            }
        }
    }

    private fun setupTextFields() {
        with(binding) {
            textEmail.setOnFocusChangeListener { _, hasFocus ->
                if (!hasFocus)
                    textEmail.inputType = InputType.TYPE_NULL
            }

            textEmail.addTextChangedListener {
                val isInvalid: Boolean = validateFields(titleEmail)
                binding.btonLogin.isEnabled = isInvalid
            }
            textPassword.addTextChangedListener {
                val isInvalid: Boolean = validateFields(titlePassword)
                binding.btonLogin.isEnabled = isInvalid
            }

        }
    }

    private fun validateFields(vararg textFields: TextInputLayout): Boolean {
        var isValid = true

        for (textField in textFields) {
            if (textField.editText?.text.toString().trim().isEmpty()) {
                textField.error = "Este campo es requerido"
                isValid = false
            } else textField.error = null
        }

        if (!isValid) {
            Snackbar.make(
                binding.root,
                "Campos inválidos ${binding.btonLogin.isEnabled}",
                Snackbar.LENGTH_SHORT
            ).show()
        }


        return isValid
    }

    private fun hideKeyboard() {
        val mActivity = activity as? AuthActivity
        val imm = mActivity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)
    }

    override fun onDestroyView() {
        hideKeyboard()
        super.onDestroyView()
        _binding = null
    }

    override fun onSuccess(message: String) {
        println(message)
        // Snackbar.make(binding.root, "SATISFACTORIO $message" , Snackbar.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        println(message)
        binding.textEmail.setText(message)
        //    Snackbar.make(view, "ERROR", Snackbar.LENGTH_SHORT).show()
    }

    private fun showMessge() {
        Snackbar.make(this.binding.root, "ERROR", Snackbar.LENGTH_SHORT).show()
    }

}
