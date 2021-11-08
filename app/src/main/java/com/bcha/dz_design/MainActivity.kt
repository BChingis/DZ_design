package com.bcha.dz_design

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sendButton: Button = findViewById(R.id.sendButton)
        val nameTextinput: TextInputEditText = findViewById(R.id.nameTextInput)
        val emailTextinput: TextInputEditText = findViewById(R.id.emailTextInput)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)

        sendButton.setOnClickListener {
            it.hideKeyboard()
            if (nameTextinput.text.isNullOrEmpty())
                Toast.makeText(this, "input Name", Toast.LENGTH_LONG).show()
            else if (emailTextinput.text.isNullOrEmpty())
                Toast.makeText(this, "input email", Toast.LENGTH_LONG).show()
            else if (radioGroup.checkedRadioButtonId == -1)
                Toast.makeText(this, "select male or female", Toast.LENGTH_LONG).show()
            else
                showSnackbar(it,nameTextinput.text.toString(), emailTextinput.text.toString())
        }

        val clearButton: Button = findViewById(R.id.clearButton)

        clearButton.setOnClickListener {
            nameTextinput.text?.clear()
            emailTextinput.text?.clear()
            radioGroup.clearCheck()
        }

    }

    private fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }


    private fun showSnackbar(view: View, name: String, email: String) {
        Snackbar.make(this,view, name, Snackbar.LENGTH_INDEFINITE)
            .setAction(email) {
                Toast.makeText(this, "Sending...", Toast.LENGTH_LONG).show()
            }
            .show()
    }
}