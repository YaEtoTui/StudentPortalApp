package sazhin.pp.studentportalapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class LineView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = android.graphics.Color.BLACK
        strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Рисуем линию от (0, 0) до (width, height)
        canvas.drawLine(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}