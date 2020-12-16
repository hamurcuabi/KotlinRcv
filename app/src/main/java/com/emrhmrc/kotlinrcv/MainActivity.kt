package com.emrhmrc.kotlinrcv

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.emrhmrc.kotlinrcv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TestListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TestAdapter
    private lateinit var itemList: ArrayList<TestItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        itemList = ArrayList()
        for (i in 1..30) itemList.add(TestItem("Hİ $i"))

        adapter = TestAdapter(itemList, this)
        binding.rcv.adapter = adapter

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }

        })

        binding.btn.setOnClickListener {
            val diffitemList = ArrayList<TestItem>()
            diffitemList.add(TestItem("Selam"))
            diffitemList.add(TestItem("Hamm"))
            diffitemList.add(TestItem("Hamdasdsaur"))
            diffitemList.add(TestItem("Cdsadsau"))
            adapter.updateItems(diffitemList, TestDiffUtilCallback(itemList, diffitemList))
        }

        adapter.isEmpty.observe(this, {
            it?.let {
                when (it) {
                    true -> binding.btn.visibility = View.VISIBLE
                    false -> binding.btn.visibility = View.INVISIBLE
                }
            }
        })


    }
}