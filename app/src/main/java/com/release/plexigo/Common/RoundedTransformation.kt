package com.release.plexigo.Common

import android.graphics.*

//class RoundedTransformation(
//    private val radius: Int, // dp
//    private var margin: Int
//) : Transformation {
//    override fun transform(source: Bitmap): Bitmap {
//        val paint = Paint()
//        paint.isAntiAlias = true
//        paint.shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//        val output = Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_8888)
//        val canvas = Canvas(output)
//        canvas.drawRoundRect(
//            RectF(
//                margin.toFloat(),
//                margin.toFloat(),
//                (source.width - margin).toFloat(),
//                (source.height - margin).toFloat()
//            ), radius.toFloat(), radius.toFloat(), paint
//        )
//        if (source != output) {
//            source.recycle()
//        }
//        return output
//    }
//
//    override fun key(): String {
//        return "rounded"
//    }
//
//    // radius is corner radii in dp
//    // margin is the board in dp
//    init {
//        this.margin = margin
//    }
//}