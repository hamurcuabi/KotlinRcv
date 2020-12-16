package com.emrhmrc.kotlinrcv

import com.emrhmrc.kotlingrcv.base.BaseViewHolder
import com.emrhmrc.kotlinrcv.databinding.ItemTestBinding

/**Created by hamurcuabi on 15,December,2020 **/
class TestViewHolder(private val binding: ItemTestBinding) :
    BaseViewHolder<TestItem, TestListener>(binding) {
    override fun onBind(item: TestItem, listener: TestListener?, position: Int) {
        binding.item = item
    }
}