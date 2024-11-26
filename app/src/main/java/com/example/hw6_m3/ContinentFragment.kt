package com.example.hw6_m3


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw6_m3.databinding.FragmentContinentBinding

class ContinentFragment : Fragment() {

    private lateinit var binding: FragmentContinentBinding
    private val continentList = arrayListOf("Eurasia", "Africa", "North America", "South America")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContinentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val continentAdapter = ContinentAdapter(continentList) { position ->
            val action = ContinentFragmentDirections.actionToCountryFragment(continentList[position])
            findNavController().navigate(action)
        }

        binding.rvContinent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = continentAdapter
        }
    }
}
