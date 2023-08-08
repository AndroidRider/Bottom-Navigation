package com.androidrider.bottom_navigation.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import com.androidrider.bottom_navigation.R

class HomeFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>

    private val itemList = mutableListOf(
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
        "Another Item 1", "Another Item 2", "Another Item 3"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)

        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        listView = rootView.findViewById(R.id.listView)
        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, itemList)
        listView.adapter = adapter

        setHasOptionsMenu(true) // Enable options menu for the fragment

        return rootView
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu) // Use the menu XML

        val searchItem = menu.findItem(R.id.search)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })

        super.onCreateOptionsMenu(menu, inflater)
    }



}