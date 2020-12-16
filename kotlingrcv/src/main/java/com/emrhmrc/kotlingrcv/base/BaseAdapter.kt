package com.emrhmrc.kotlingrcv.base

import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**Created by hamurcuabi on 15,December,2020 **/
abstract class BaseAdapter<
        M : BaseModel,
        L : BaseListener,
        VH : BaseViewHolder<M, L>
        >(
    private var itemList: ArrayList<M>,
    private val listener: L,
) : RecyclerView.Adapter<VH>() {
    init {
        setFilterItemList(itemList)
    }

    open val isEmpty: MutableLiveData<Boolean> = MutableLiveData()
    protected lateinit var itemFilterList: ArrayList<M>

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = itemFilterList[position]
        holder.onBind(item, listener, position)
    }

    override fun getItemCount(): Int {
        isEmpty.postValue(itemFilterList.size > 0)
        return itemFilterList.size
    }

    fun getItemList(): List<M> {
        return itemList
    }

    fun getFilterItemList(): List<M> {
        return itemFilterList
    }

    fun setFilterItemList(filterList: List<M>) {
        itemFilterList = filterList as ArrayList<M>
    }

    open fun setItems(items: List<M>, notifyChanges: Boolean = true) {
        itemFilterList = items as ArrayList<M>
        if (notifyChanges) {
            notifyDataSetChanged()
        }
    }

    open fun addItem(item: M) {
        itemFilterList.add(item)
        notifyItemInserted(itemFilterList.size - 1)
    }

    open fun addItem(item: M, position: Int) {
        itemFilterList.add(position, item)
        notifyItemInserted(position)
    }

    open fun removeItem(item: M, position: Int) {
        itemFilterList.remove(item)
        notifyItemRemoved(position)
    }

    open fun updateItems(newItems: List<M>, diffCallback: DiffUtil.Callback?) {
        val result = DiffUtil.calculateDiff(diffCallback!!, false)
        itemList = newItems as ArrayList<M>
        itemFilterList = newItems
        result.dispatchUpdatesTo(this)
    }
}