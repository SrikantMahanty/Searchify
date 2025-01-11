package com.srikant.searchify

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.srikant.searchify.adapter.MyAdapter
import com.srikant.searchify.databinding.ActivityMainBinding
import com.srikant.searchify.repository.Repository

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    private val myAdapter by lazy { MyAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Be Patient...")
        progressDialog.setMessage("Please Wait, We are loading data from the Server.This may take several Minutes to complete...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val repository = Repository()
        val mainViewModelFactory = MainViewModelFactory(repository)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val progressDialog = ProgressDialog(this@MainActivity)
                progressDialog.setTitle("Please Be Patient...")
                progressDialog.setMessage("Please Wait, We are loading data from the Server.This may take several Minutes to complete...")
                progressDialog.setCancelable(false)
                progressDialog.show()
                // Call to getWebSearch using the new API parameters
                mainViewModel.getWebSearch(query.toString(), 10, 0, "us", "en")

                mainViewModel.myResponse.observe(this@MainActivity, Observer { response ->
                    if (response.isSuccessful) {
                        progressDialog.dismiss()
                        response.body()?.let { myAdapter.setData(listOf(it))
                            myAdapter.notifyDataSetChanged()}


                    } else {
                        progressDialog.dismiss()
                        Log.d("Response", response.errorBody().toString())
                    }
                })
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

// Call to getWebSearch using the new API parameters
        mainViewModel.getWebSearch("google", 10, 0, "us", "en")

        mainViewModel.myResponse.observe(this@MainActivity, Observer { response ->
            if (response.isSuccessful) {
                progressDialog.dismiss()
                response.body()?.let { myAdapter.setData(listOf(it)) }


            } else {
                progressDialog.dismiss()
                Log.d("Response", response.errorBody().toString())
            }
        })
    }

    fun setupRecyclerView() {
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}