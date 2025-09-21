package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Daftar coffee card yang ada di fragment_list.xml
        val coffeeList = listOf(
            view.findViewById<View>(R.id.affogato),
            view.findViewById<View>(R.id.americano),
            view.findViewById<View>(R.id.latte)
        )

        coffeeList.forEach { coffeeView ->
            coffeeView.setOnClickListener {
                val bundle = Bundle().apply {
                    // kirim ID kopi, bukan ID view
                    when (coffeeView.id) {
                        R.id.affogato -> putString(COFFEE_ID, "AFFOGATO")
                        R.id.americano -> putString(COFFEE_ID, "AMERICANO")
                        R.id.latte -> putString(COFFEE_ID, "LATTE")
                    }
                }
                Navigation.findNavController(view).navigate(
                    R.id.action_listFragment_to_detailFragment,
                    bundle
                )
            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
