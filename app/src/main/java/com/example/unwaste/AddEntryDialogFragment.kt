package com.example.unwaste

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.unwaste.databinding.FragmentAddEntryDialogItemBinding
import com.example.unwaste.databinding.FragmentAddEntryDialogBinding

// TODO: Customize parameter argument names
const val ARG_ITEM_COUNT = "item_count"

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    AddEntryDialogFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 */
class AddEntryDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentAddEntryDialogBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddEntryDialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = activity?.findViewById<RecyclerView>(R.id.list)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        if (recyclerView?.isAttachedToWindow == true) {
            recyclerView.adapter = arguments?.getInt(ARG_ITEM_COUNT)?.let { EntryAdapter(it) }
        } else {
            Log.w("AddEntryDialogFragment", "RecyclerView is not attached to window")
        }
    }

    private inner class EntryAdapter(private val mItemCount: Int) :
        RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = FragmentAddEntryDialogItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.text.text = position.toString()
        }

        override fun getItemCount(): Int {
            return mItemCount
        }
    }

    private inner class ViewHolder(binding: FragmentAddEntryDialogItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val text: TextView = binding.text
    }

    companion object {

        // TODO: Customize parameters
        // Currently using restaurant for testing
        fun newInstance(itemCount: Int): AddEntryDialogFragment =
            AddEntryDialogFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ITEM_COUNT, itemCount)
                }
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}