package com.hao.mvp.counter

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *@date: 2022/11/19
 *@author: 锅得铁
 *@param view 注入view
 *@param lifecycleScope 注入lifecycleScope以实现协程
 *#功能实现
 */
internal class CounterPresenter(
    private val view: ICounterView,
    private val lifecycleScope: LifecycleCoroutineScope
) :
    ICounterPresenter {

    var number = 0

    init {
        //绑定 view <->presenter
        view.bind(this)
    }

    override fun plus() {
        //返回加法运算结果
        view.result(++number)
    }

    override fun minus() {
        view.showLoading()
        //通过view lifecycleScope开协程
        lifecycleScope.launch {
            //在IO线程运算
            withContext(Dispatchers.IO) {
                //模拟需要2秒才能算完
                Thread.sleep(2000)
                //调度回Main线程
                withContext(Dispatchers.Main) {
                    view.hideLoading()
                    view.result(--number)
                }
            }
        }
    }
}