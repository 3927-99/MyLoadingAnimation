package com.example.myloadinganimation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*

class RectStroke:View {
    //constructor
    constructor(context: Context):super(context){}
    constructor(context: Context, attrs: AttributeSet?):super(context,attrs){}
    //边框画笔
    private val mRectPaint: Paint by lazy {
        Paint().apply {
            color = Color.BLACK
            style = Paint.Style.STROKE
            strokeWidth = 5f
        }
    }
    //加载条画笔
    private val mBarPaint:Paint by lazy{
        Paint().apply {
            color = Color.BLUE
            style = Paint.Style.FILL
        }

    }
    //动画相关变量////////////////////
    private var left = 5f
    private var rectMove:ValueAnimator? = null
    private var barMove:ValueAnimator? = null
    //动画相关变量////////////////////
    //函数重写
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {}

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawRect(left,0f,width.toFloat()-left,height.toFloat(),mRectPaint)
        mLoading.visibility = View.INVISIBLE;
        canvas?.drawRect(left,5f,width.toFloat()-left,height.toFloat()-5f,mBarPaint)
    }
    //创建动画
    fun createAnim(){
        if(rectMove == null){
            rectMove = ValueAnimator.ofFloat(5f,870/2f).apply {
                duration = 800
                addUpdateListener {
                    left = it.animatedValue as Float
                    invalidate()
                }
            }
        }


    }
    //开始动画
    fun startAnim(){
        createAnim()

    }


}