package com.emrhmrc.kotlingrcv.base

import androidx.recyclerview.widget.DiffUtil

/**Created by hamurcuabi on 16,December,2020 **/
open class BaseDiffUtil<M : BaseModel>(
    private val oldList: List<M>,
    private val newList: List<M>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}