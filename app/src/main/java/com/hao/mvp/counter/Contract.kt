package com.hao.mvp.counter

import com.hao.mvp.base.IPresenter
import com.hao.mvp.base.IView


/**
 *@date: 2022/11/19
 *@author: 锅得铁
 *Presenter功能约束/描述
 */
internal interface ICounterPresenter : IPresenter<ICounterView> {

    /**
     * 加法运算
     */
    fun plus()

    /**
     * 减法运算
     */
    fun minus()
}

/**
 *@date: 2022/11/19
 *@author: 锅得铁
 *View功能约束/描述
 */
internal interface ICounterView : IView<ICounterPresenter> {
    /**
     * 运算结果
     */
    fun result(number: Int)
    /**
     * show Progress
     */
    fun showLoading()

    /**
     * hide Progress
     */
    fun hideLoading()
}