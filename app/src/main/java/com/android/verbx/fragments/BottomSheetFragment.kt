package com.android.verbx.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import com.android.verbx.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomSheetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomSheetFragment : BottomSheetDialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var button: Button
    private lateinit var chip1: Chip
    private lateinit var chip2: Chip
    private lateinit var chip3: Chip

    private lateinit var chip_brand1: Chip
    private lateinit var chip_brand2: Chip
    private lateinit var chip_brand3: Chip

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        button = view.findViewById(R.id.buttonFilter)
        chip1 = view.findViewById(R.id.chip_1)
        chip2 = view.findViewById(R.id.chip_2)
        chip3 = view.findViewById(R.id.chip_3)

        chip_brand1 = view.findViewById(R.id.chip_brand_1)
        chip_brand2 = view.findViewById(R.id.chip_brand_2)
        chip_brand3 = view.findViewById(R.id.chip_brand_3)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fun showSnackBar(message:String){
            val snackbar = Snackbar.make(button, message, Snackbar.LENGTH_SHORT)
            snackbar.show()
        }

        fun isCheckedChips():Boolean {
            return chip1.isChecked || chip2.isChecked || chip3.isChecked
        }

        fun isChecked():Boolean {
            return chip_brand1.isChecked || chip_brand2.isChecked || chip_brand3.isChecked
        }

        button.setOnClickListener {
            if (isChecked()){}
            else{
                showSnackBar("Please select a any options to continue")
            }
        }

        val listener = CompoundButton.OnCheckedChangeListener{ _, _ ->
            button.isEnabled = isChecked()

            button.setOnClickListener {
                if (isChecked()){
                    showSnackBar("you have to continue")
                }
            }

            if (isChecked()){
                button.setBackgroundColor(Color.BLACK)
                button.setTextColor(Color.WHITE)
            }else{
                button.setBackgroundColor(Color.GRAY)
                button.setTextColor(Color.LTGRAY)
            }
        }

        val listenerChip = CompoundButton.OnCheckedChangeListener{ _, _ ->
          button.isEnabled = isCheckedChips()

            button.setOnClickListener {
                if (isCheckedChips()){
                    showSnackBar("Clicked")
                }
            }

            if (isCheckedChips()){
                button.setBackgroundColor(Color.BLACK)
                button.setTextColor(Color.WHITE)
            }else{
                button.setBackgroundColor(Color.GRAY)
                button.setTextColor(Color.LTGRAY)
            }
        }

        chip1.setOnCheckedChangeListener(listenerChip)
        chip2.setOnCheckedChangeListener(listenerChip)
        chip3.setOnCheckedChangeListener(listenerChip)

        chip_brand1.setOnCheckedChangeListener(listener)
        chip_brand2.setOnCheckedChangeListener(listener)
        chip_brand3.setOnCheckedChangeListener(listener)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BottomSheetFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BottomSheetFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}