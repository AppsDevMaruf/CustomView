package com.maruf.customview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

@SuppressLint("ResourceType")
class CircleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var paint: Paint = Paint()
    private var isCenter = false
    private var centerOfX = 300F
    private var centerOfY = 400F
    private var radiusOfCircleView = 0F

    init {
        val attributeArray: TypedArray? =
            context.theme.obtainStyledAttributes(attrs, R.styleable.circleview, 0, 0)
        paint.color = attributeArray?.getColor(
            R.styleable.circleview_circle_background,
            ContextCompat.getColor(context, android.R.color.background_dark)
        ) ?: android.R.color.black
        paint.style = Paint.Style.STROKE

        isCenter = attributeArray?.getBoolean(R.styleable.circleview_onCenter,false)?:false
        radiusOfCircleView = attributeArray?.getDimension(R.styleable.circleview_circle_radius,140F)?:40F
        paint.strokeWidth =attributeArray?.getDimension(R.styleable.circleview_circle_stork,50F)?:1F
        paint.isAntiAlias = true
        paint.isDither = true


    }
    override fun onDraw(canvas: Canvas?) {
        isCenter?.run {
            centerOfX = (width/2).toFloat()
            centerOfY = (height/2).toFloat()
        }

        canvas?.drawCircle(centerOfX, centerOfY, radiusOfCircleView, paint)
        super.onDraw(canvas)
    }
}