package com.example.periodictable.view

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.periodictable.R
import com.example.periodictable.adapter.PeriodicRecyclerAdapter
import com.example.periodictable.databinding.CustomDialogBinding
import com.example.periodictable.databinding.FragmentPeriodicTableBinding
import com.example.periodictable.model.DummyData
import com.example.periodictable.model.ElementsModel

class PeriodicTableFragment : Fragment() {
    lateinit var binding: FragmentPeriodicTableBinding
    lateinit var recyclerAdapter: PeriodicRecyclerAdapter
    lateinit var customDialogBinding: CustomDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeriodicTableBinding.inflate(inflater, container, false)

        recyclerAdapter = PeriodicRecyclerAdapter(::showDialog)

        return binding.root
    }

    private fun showDialog(model: ElementsModel) {
        // Toast.makeText(requireContext(),"Item clicked ${model.elementName}",Toast.LENGTH_SHORT).show()
        val builder = AlertDialog.Builder(requireContext())
        val mBinding = CustomDialogBinding.inflate(LayoutInflater.from(requireContext()), null, false)
        val dialog = builder.setView(mBinding.root).show()

        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.setCanceledOnTouchOutside(false)
        dialog.window?.setLayout(1000, 1000)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        mBinding.customProtonNumber.text = model.protonNumber
        mBinding.customElementSymbol.text = model.elementSymbol
        mBinding.customElementName.setText(model.elementName)
        mBinding.customButton.setOnClickListener {
            dialog.dismiss() 
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerView.adapter = recyclerAdapter
            recyclerAdapter.submitList(DummyData.listOfElement)
        }
    }
}
