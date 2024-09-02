package com.example.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import com.example.databinding.databinding.ActivityMainFragmentBinding

class MainFragment : Fragment() {

    // Initialize variables
    private lateinit var binding: ActivityMainFragmentBinding
    private lateinit var view: View

    private var mParam1: String? = null
    private var mParam2: String? = null

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mParam1 = it.getString(ARG_PARAM1)
            mParam2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Assign variable
        binding = inflate(inflater, R.layout.activity_main_fragment, container, false)
        view = binding.root

        binding.btSubmit.setOnClickListener {
            // Get text from edit text
            val sText = binding.etInput.text.toString().trim()

            // Check condition
            if (sText.isNotEmpty()) {
                // When text is not empty
                // Set text on text view
                binding.tvOutput.text = sText
            } else {
                // When text is empty
                // Display Toast
                Toast.makeText(view.context, "Please enter text", Toast.LENGTH_SHORT).show()
            }
        }

        // Return view
        return view
    }
}
