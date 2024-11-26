package com.example.hw6_m3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw6_m3.databinding.FragmentCityBinding

class CityFragment : Fragment() {

    private lateinit var binding: FragmentCityBinding
    private val cityList = arrayListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = CityFragmentArgs.fromBundle(requireArguments())

        val country = args.country
        loadCities(country)

        val cityAdapter = CityAdapter(cityList) { position ->

        }

        binding.rvCities.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cityAdapter
        }
    }

    private fun loadCities(country: String) {
        cityList.clear()
        when (country) {
            "Russia" -> cityList.addAll(listOf("Moscow", "Saint Petersburg", "Novosibirsk"))
            "Kyrgyzstan" -> cityList.addAll(listOf("Bishkek", "Osh", "Batken"))
            "China" -> cityList.addAll(listOf("Beijing", "Shanghai", "Guangzhou"))
            "Egypt" -> cityList.addAll(listOf("Cairo", "Alexandria", "Giza"))
           "Nigeria" -> cityList.addAll(listOf("Ibadan", "Awka", "Lagos"))
            "Morocco" -> cityList.addAll(listOf("Casablanca", "Rabat", "Fes"))
            "Canada" -> cityList.addAll(listOf("Ottawa", "Toronto", "Montreal"))
            "USA" -> cityList.addAll(listOf("New York", "Los Angeles", "Chicago"))
            "Columbia" -> cityList.addAll(listOf("Cali", "Bogota", "Cartagena"))
            "Brazil" -> cityList.addAll(listOf("Sau Paulo", "Brasilia", "Rio de Janeiro"))
            "Argentina" -> cityList.addAll(listOf("Buenos Aires", "Rosario", "Cordoba"))
            "Mexico" -> cityList.addAll(listOf("Mexico City", "Tijuana", "Leon"))


        }
    }
}
