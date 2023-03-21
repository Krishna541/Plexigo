package com.release.plexigo.Common

import android.graphics.Color
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

open class MySpannable(isUnderline: Boolean) : ClickableSpan() {
    private var isUnderline = true
    override fun updateDrawState(ds: TextPaint) {
        ds.isUnderlineText = isUnderline
        ds.color = Color.parseColor("#87CEEB")
    }

    override fun onClick(widget: View) {}

    init {
        this.isUnderline = isUnderline
    }
}