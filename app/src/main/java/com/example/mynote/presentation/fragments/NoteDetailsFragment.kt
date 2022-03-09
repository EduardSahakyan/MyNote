package com.example.mynote.presentation.fragments

import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mynote.R
import com.example.mynote.data.di.Component
import com.example.mynote.data.entity.Note
import com.example.mynote.databinding.FragmentNoteDetailsBinding
import com.example.mynote.presentation.viewmodels.NoteDetailsViewModel
import com.example.mynote.presentation.viewmodels.NoteListViewModel
import java.lang.RuntimeException

class NoteDetailsFragment : Fragment() {

    private var editable: Boolean = false
    private var _binding:FragmentNoteDetailsBinding? = null
    private val binding:FragmentNoteDetailsBinding
    get() = _binding ?: throw RuntimeException("NoteDetailBinding is null")
    lateinit var viewModel: NoteDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save ->{
                if(editable){
                    viewModel.add(binding.edTitile.text.toString(),
                    binding.edText.text.toString(),
                    200)
                }
            }
        }
        return false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[NoteDetailsViewModel::class.java]
        Component().injectDetailsFragment(this)
        requireArguments().getString(TITLE_EXTRA)?.let {
            binding.edTitile.setText(it)
        }
        requireArguments().getString(TEXT_EXTRA)?.let {
            binding.edText.setText(it)
        }
        requireArguments().getBoolean(EDITABLE_EXTRA).let {
            editable = it
        }
        /*setEditable(binding.edTitile, editable)
        setEditable(binding.edText, editable)*/


    }


    private fun setEditable(editText: EditText, editable:Boolean){
        editText.isFocusable = editable
        editText.isFocusableInTouchMode = editable
        editText.isClickable = editable
        editText.isCursorVisible = editable
    }

    companion object{

        private const val TITLE_EXTRA = "title"
        private const val TEXT_EXTRA = "text"
        const val EDITABLE_EXTRA = "flag"

        fun newInstance(note:Note, editable:Boolean) : NoteDetailsFragment{
            return NoteDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(TITLE_EXTRA, note.title)
                    putString(TEXT_EXTRA, note.text)
                    putBoolean(EDITABLE_EXTRA, editable)
                }
            }
        }

    }
}