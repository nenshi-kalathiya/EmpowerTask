package com.example.empowertask.common

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.empowertask.R

//custom Textview for common UI creation
class TitleTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        // Apply any customizations or default settings here
        // For example, you can set a custom font or modify the text appearance
        val customColor = ContextCompat.getColor(context, R.color.title_gray)
        setTextColor(customColor)
        setTextSize(25f)
        setTypeface(null, Typeface.BOLD)
    }
}
