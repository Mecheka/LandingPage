package com.traning.suriya.landingpage.landing

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.properties.Delegates

class CurvesView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mPath by Delegates.notNull<Path>()
    private var mPaint by Delegates.notNull<Paint>()

    private lateinit var startPoint: PointF
    private lateinit var endPoint: PointF
    private lateinit var controlPoint1: PointF

    init {
        mPath = Path()
        mPaint = Paint()
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.color = Color.WHITE
        setBackgroundColor(Color.TRANSPARENT)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        startPoint = PointF(0f, 0f)
        endPoint = PointF(width.toFloat(),0f )
        controlPoint1 =
            PointF((width / 2).toFloat(), (height / 2).toFloat() + (height / 3).toFloat())

        mPath.reset()
        mPath.moveTo(0f, 0f)
        mPath.lineTo(startPoint.x, startPoint.y)

        mPath.cubicTo(
            controlPoint1.x, controlPoint1.y
            , controlPoint1.x, controlPoint1.y
            , endPoint.x, endPoint.y
        )

        mPath.lineTo(width.toFloat(), 0f)
        mPath.lineTo(width.toFloat(), height.toFloat())
        mPath.lineTo(0f, height.toFloat())
        mPath.close()

        canvas?.drawPath(mPath, mPaint)
    }
}