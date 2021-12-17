package com.dev_yogesh.simplespinnerexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import com.dev_yogesh.simplespinnerexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,
    AdapterView.OnItemSelectedListener {

    var languages = arrayOf("Java", "PHP", "Kotlin", "Javascript", "Python", "Swift")
    val NEW_SPINNER_ID = 1
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(binding.mySpinner)
        {
            adapter = aa
            setSelection(0, false)
            onItemSelectedListener = this@MainActivity
            prompt = "Select your favourite language"
            gravity = Gravity.CENTER

        }

        val spinner = Spinner(this)
        spinner.id = NEW_SPINNER_ID

        val ll = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        ll.setMargins(10, 40, 10, 10)
        binding.linearLayout.addView(spinner)

        val aaa = ArrayAdapter(this, R.layout.spinner_right_aligned, languages)
        aaa.setDropDownViewResource(R.layout.spinner_right_aligned)

        with(spinner)
        {
            adapter = aaa
            setSelection(0, false)
            onItemSelectedListener = this@MainActivity
            layoutParams = ll
            prompt = "Select your favourite language"
            setPopupBackgroundResource(R.color.material_grey_600)

        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
        when (view?.id) {
            1 -> showToast(message = "Spinner 2 Position:${position} and language: ${languages[position]}")
            else -> {
                showToast(message = "Spinner 1 Position:${position} and language: ${languages[position]}")
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        showToast(message = "Nothing selected")
    }

    private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }
}