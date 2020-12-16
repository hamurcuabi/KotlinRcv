package com.emrhmrc.kotlinrcv

import com.emrhmrc.kotlingrcv.base.BaseDiffUtil

/**Created by hamurcuabi on 16,December,2020 **/
class TestDiffUtilCallback(oldList: List<TestItem>, newList: List<TestItem>) :
    BaseDiffUtil<TestItem>(oldList, newList)