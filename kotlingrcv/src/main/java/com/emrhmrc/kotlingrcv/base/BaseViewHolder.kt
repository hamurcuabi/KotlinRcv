package com.emrhmrc.kotlingrcv.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**Created by hamurcuabi on 15,December,2020 **/
abstract class BaseViewHolder<
        M : BaseModel,
        L : BaseListener,
        >(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    abstract fun onBind(item: M, listener: L?, position: Int)

}