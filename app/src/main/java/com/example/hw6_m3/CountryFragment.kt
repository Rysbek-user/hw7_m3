package com.example.hw6_m3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw6_m3.databinding.FragmentCountryBinding

class CountryFragment : Fragment() {

    private lateinit var binding: FragmentCountryBinding
    private val countryList = arrayListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = CountryFragmentArgs.fromBundle(requireArguments())

        val continent = args.continent
        loadCountries(continent)

        val countryAdapter = CountryAdapter(countryList) { position ->
            val action = CountryFragmentDirections.actionToCityFragment(countryList[position])
            findNavController().navigate(action)
                }

        binding.rvCountry.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryAdapter
        }
    }

    private fun loadCountries(continent: String) {
        countryList.clear()
        when (continent) {
            "Eurasia" -> countryList.addAll(listOf("Russia", "Kyrgyzstan", "China"))
            "Africa" -> countryList.addAll(listOf("Egypt", "Nigeria", "Morocco"))
            "North America" -> countryList.addAll(listOf("Canada", "USA", "Mexico"))
            "South America" -> countryList.addAll(listOf("Brazil", "Argentina", "Columbia"))


        }
    }
}
