package com.github.vvinogra.fonttoggleandroid

import android.graphics.Typeface
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat.getFont
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle_font_style.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        val typeface = if (isChecked) {
            getFont(this, R.font.lobster_two)
        } else {
            getFont(this, R.font.lobster_two_incomplete)
        }

        normal_font.setTypeface(typeface, Typeface.NORMAL)

        italic_font.setTypeface(typeface, Typeface.ITALIC)

        bold_font.setTypeface(typeface, Typeface.BOLD)
        bold_italic_font.setTypeface(typeface, Typeface.BOLD_ITALIC)

        val headerText = if (isChecked) {
            R.string.header_style_true_font
        } else {
            R.string.header_style_fake_font
        }

        header_font_style.setText(headerText)
    }
}