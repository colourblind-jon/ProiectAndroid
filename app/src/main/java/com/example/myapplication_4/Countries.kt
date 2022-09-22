package com.example.myapplication_4

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Countries.newInstance] factory method to
 * create an instance of this fragment.
 */
class Countries : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter : Country_Adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var countryArrayList: ArrayList<Country>
    private lateinit var tempArrayList: ArrayList<Country>

    lateinit var heading : Array<String>
    lateinit var country : Array<String>

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
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Countries.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Countries().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        tempArrayList = arrayListOf<Country>()
        tempArrayList.addAll((countryArrayList))

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = Country_Adapter(tempArrayList)
        recyclerView.adapter = adapter



    }

    /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.search_menu, menu)
        val item = menu!!.findItem(R.id.search)
        val searchView = item?.actionView as SearchView
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW)
        item.setActionView(searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        }

        )

    }*/

    @SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.id.searchView, menu)
        val item = menu!!.findItem(R.id.searchView)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                tempArrayList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty())
                {
                    countryArrayList.forEach{
                        if(it.country.toLowerCase(Locale.getDefault()).contains(searchText))
                        {
                            tempArrayList.add(it)
                        }
                    }

                    recyclerView.adapter!!.notifyDataSetChanged()
                }else{
                    tempArrayList.clear()
                    tempArrayList.addAll(countryArrayList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }

                return false
            }

        })
    }

    private fun dataInitialize(){
        countryArrayList = arrayListOf<Country>()

        countryArrayList.add(Country("Romania", "Romania".substring(0,1)))
        countryArrayList.add(Country("Russia", "Romania".substring(0,1)))
        countryArrayList.add(Country("Canada", "Romania".substring(0,1)))
        countryArrayList.add(Country("USA", "Romania".substring(0,1)))
        countryArrayList.add(Country("China", "Romania".substring(0,1)))
        countryArrayList.add(Country("Brazil", "Romania".substring(0,1)))
        countryArrayList.add(Country("Australia", "Romania".substring(0,1)))
        countryArrayList.add(Country("India", "Romania".substring(0,1)))
        countryArrayList.add(Country("Argentina", "Romania".substring(0,1)))
        countryArrayList.add(Country("Kazakhstan", "Romania".substring(0,1)))
        countryArrayList.add(Country("Algeria", "Romania".substring(0,1)))
        countryArrayList.add(Country("Democratic Republic of Congo", "Romania".substring(0,1)))
        countryArrayList.add(Country("Greenland", "Romania".substring(0,1)))
        countryArrayList.add(Country("Saudi Arabia", "Romania".substring(0,1)))
        countryArrayList.add(Country("Mexico", "Romania".substring(0,1)))
        countryArrayList.add(Country("Indonesia", "Romania".substring(0,1)))
        countryArrayList.add(Country("Sudan", "Romania".substring(0,1)))
        countryArrayList.add(Country("Libya", "Romania".substring(0,1)))
        countryArrayList.add(Country("Iran", "Romania".substring(0,1)))
        countryArrayList.add(Country("Mongolia", "Romania".substring(0,1)))
        countryArrayList.add(Country("Peru", "Romania".substring(0,1)))
        countryArrayList.add(Country("Chad", "Romania".substring(0,1)))
        countryArrayList.add(Country("Angola", "Romania".substring(0,1)))
        countryArrayList.add(Country("Mali", "Romania".substring(0,1)))
        countryArrayList.add(Country("South Africa", "Romania".substring(0,1)))
        countryArrayList.add(Country("Colombia", "Romania".substring(0,1)))
        countryArrayList.add(Country("Ethiopia", "Romania".substring(0,1)))
        countryArrayList.add(Country("Bolivia", "Romania".substring(0,1)))
        countryArrayList.add(Country("Mauritania", "Romania".substring(0,1)))
        countryArrayList.add(Country("Egypt", "Romania".substring(0,1)))

       /* country = arrayOf (
            getString(R.string.c_1),
            getString(R.string.c_2),
            getString(R.string.c_3),
            getString(R.string.c_3),
        )*/



    }


}