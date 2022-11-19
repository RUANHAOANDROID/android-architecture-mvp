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
 *# 页面实现抽象的CounterView
 */
internal class CounterFragment : Fragment(), ICounterView {
    private lateinit var mPresenter: ICounterPresenter
    private val dialog: ProgressDialog by lazy {
        ProgressDialog.show(
            context, "Loading",
            "Please wait...", true
        )
    }
    private val mBinding by lazy {
        FragmentCounterBinding.inflate(layoutInflater).apply {
            btnMinus.setOnClickListener {
                mPresenter.minus()
            }
            btnPlus.setOnClickListener {
                mPresenter.plus()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lifecycle.addObserver(CounterPresenter(this, lifecycleScope))
        return mBinding.root
    }

    override fun result(number: Int) {
        mBinding.tvNumber.text = "$number"
    }

    override fun bind(presenter: ICounterPresenter) {
        this.mPresenter = presenter
    }


    override fun showLoading() {
        dialog.show()
    }

    override fun hideLoading() {
        dialog.dismiss()
    }
}