package com.example.jinotas.custom_textview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.FontMetricsInt
import android.graphics.drawable.Drawable
import android.text.style.ImageSpan
import com.example.jinotas.utils.DisplayUtils

// From https://stackoverflow.com/a/38788432/309558
class CenteredImageSpan(context: Context?, d: Drawable) :
    ImageSpan(d) {
    // Ensures icon is centered properly
    private val mIconOversizeAdjustment: Int = DisplayUtils().dpToPx(context!!, 1)

    override fun getSize(
        paint: Paint, text: CharSequence, start: Int, end: Int,
        fontMetricsInt: FontMetricsInt?
    ): Int {
        val drawable = drawable
        val rect = drawable.bounds
        if (fontMetricsInt != null) {
            val fmPaint = paint.fontMetricsInt
            val fontHeight = fmPaint.descent - fmPaint.ascent
            val drHeight = (rect.bottom - rect.top) + mIconOversizeAdjustment
            val centerY = fmPaint.ascent + fontHeight / 2

            fontMetricsInt.ascent = centerY - drHeight / 2
            fontMetricsInt.top = fontMetricsInt.ascent
            fontMetricsInt.bottom = centerY + drHeight / 2
            fontMetricsInt.descent = fontMetricsInt.bottom
        }
        return rect.right
    }

    override fun draw(
        canvas: Canvas, text: CharSequence, start: Int, end: Int,
        x: Float, top: Int, y: Int, bottom: Int, paint: Paint
    ) {
        val drawable = drawable
        val rect = drawable.bounds
        canvas.save()
        val fmPaint = paint.fontMetricsInt
        val fontHeight = fmPaint.descent - fmPaint.ascent
        val centerY = y + fmPaint.descent - fontHeight / 2
        val drHeight = (rect.bottom - rect.top) + mIconOversizeAdjustment
        val transY = centerY - drHeight / 2
        canvas.translate(x, transY.toFloat())
        drawable.draw(canvas)
        canvas.restore()
    }
}