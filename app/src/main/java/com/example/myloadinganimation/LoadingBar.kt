package com.example.myloadinganimation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class LoadingBar:View {
    //constructor
    constructor(context: Context):super(context){}
    constructor(context: Context, attrs: AttributeSet?):super(context,attrs){}
    //加载条画笔
    private val mBarPaint: Paint by lazy{
        Paint().apply {
            color = Color.BLUE
            style = Paint.Style.FILL
        }

    }
    //动画相关变量////////////////////
    private var loadingBar:ValueAnimator? = null
    private var barRight = 5f
    //动画相关变量////////////////////
    //函数重写
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {}

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawRect(0f,5f,barRight,height.toFloat()-5f,mBarPaint)


    }
    //创建动画
    fun createAnim(){
        if(loadingBar == null){
            loadingBar = ValueAnimator.ofFloat(5f,1000f).apply {
                duration = 2000
                addUpdateListener {
                    barRight = it.animatedValue as Float
                    invalidate()
                }
            }
        }

    }
    //开始动画
    fun startAnim(){
        createAnim()
        loadingBar?.start()

    }
}