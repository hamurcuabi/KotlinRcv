package com.emrhmrc.kotlinrcv

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.emrhmrc.kotlingrcv.base.BaseAdapter
import com.emrhmrc.kotlinrcv.databinding.ItemTestBinding

/**Created by hamurcuabi on 15,December,2020 **/
class TestAdapter(itemList: ArrayList<TestItem>, listener: TestListener) :
    BaseAdapter<TestItem, TestListener, TestViewHolder>(itemList, listener), Filterable {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val binding = ItemTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TestViewHolder(binding)
    }

    override fun getFilter(): Filter = customFilter

    private val customFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val results = FilterResults()
            val query: String

            if (constraint != null && constraint.isNotEmpty()) {
                query = constraint.toString().toLowerCase()
                val filtered = ArrayList<TestItem>()

                for (i in getFilterItemList().indices) {
                    if ((getFilterItemList()[i]).text.toLowerCase().contains(query)
                    ) {
                        filtered.add(getFilterItemList()[i])
                    }
                }
                results.count = filtered.size
                results.values = filtered
            } else {
                results.count = getItemList().size
                results.values = getItemList()
            }
            return results
        }

        override fun publishResults(p0: CharSequence?, results: FilterResults?) {
            itemFilterList = results?.values as ArrayList<TestItem>
            setItems(itemFilterList)
        }

    }


}