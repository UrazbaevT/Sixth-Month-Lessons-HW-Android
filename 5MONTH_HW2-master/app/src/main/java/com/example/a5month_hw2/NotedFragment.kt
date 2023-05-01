package com.example.a5month_hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a5month_hw2.databinding.FragmentNotedBinding

class NotedFragment : Fragment() {

    private lateinit var binding: FragmentNotedBinding
    private val lists = arrayListOf<Sheep>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedPhotos = arguments?.getSerializable(SheepFragment.fFragSFrag) as? ArrayList<Sheep>

        if (selectedPhotos.isNullOrEmpty()) {
            binding.recyclerView.visibility = View.GONE
        } else {
            lists.addAll(selectedPhotos)
            val adapter = NotedAdapter(lists)
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(context, 3)
                this.adapter = adapter
            }
        }

    }
}