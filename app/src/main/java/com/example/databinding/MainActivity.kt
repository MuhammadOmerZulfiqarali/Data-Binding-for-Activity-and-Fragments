package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Initialize variables
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Assign variable
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btSubmit.setOnClickListener {
            // Get text from edit text
            val sText = binding.etInput.text.toString().trim()

            // Check condition
            if (sText.isNotEmpty()) {
                // when text is not empty
                // set text on text view
                binding.tvOutput.text = sText
            } else {
                // When text is empty
                // Display Toast
                Toast.makeText(applicationContext, "Please enter text", Toast.LENGTH_SHORT).show()
            }
        }

        // Initialize fragment
        val fragment: Fragment = MainFragment()

        // Commit fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment).commit()
    }
}
