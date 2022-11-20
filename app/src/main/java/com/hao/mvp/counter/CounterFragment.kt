package com.hao.mvp.counter

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.hao.mvp.databinding.FragmentCounterBinding

/**
 *@date: 2022/11/19
 *@author: 锅得铁
 *#页面实现抽象的CounterView
 */
internal class CounterFragment : Fragment(), ICounterView {

    override lateinit var presenter: ICounterPresenter
    
    private val dialog: ProgressDialog by lazy {
        ProgressDialog.show(
            context, "Loading",
            "Please wait...", true
        )
    }

    private val mBinding by lazy {
        FragmentCounterBinding.inflate(layoutInflater).apply {
            btnMinus.setOnClickListener {
                presenter.minus()
            }
            btnPlus.setOnClickListener {
                presenter.plus()
            }
        }
    }

    /**
     * Add presenter,then presenter bind to view
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = CounterPresenter(this, lifecycleScope)
        //Tip: add
        lifecycle.addObserver(presenter)
        return mBinding.root
    }

    /**
     * Remove presenter
     */
    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(presenter)
    }

    override fun result(number: Int) {
        mBinding.tvNumber.text = "$number"
    }


    override fun showLoading() {
        dialog.show()
    }

    override fun hideLoading() {
        dialog.dismiss()
    }

}