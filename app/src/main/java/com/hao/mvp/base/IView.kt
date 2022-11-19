package com.hao.mvp.base

/**
 *@date: 2022/11/19
 *@author: 锅得铁
 *# 基本的View约束/描述
 */
interface IView<T> {
    /**
     * presenter 初始化时通过view.bin（this）注入
     */
    fun bind(presenter: T)
}