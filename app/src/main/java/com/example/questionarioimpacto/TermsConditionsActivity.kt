package com.example.questionarioimpacto

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import com.example.questionarioimpacto.R
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.content.Intent
import android.view.View
import com.example.questionarioimpacto.IdentificationActivity
import com.example.questionarioimpacto.ShowMoreActivity
import com.example.questionarioimpacto.connection.IncrementList

class TermsConditionsActivity : AppCompatActivity() {
    private var tvShowMore: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_conditions)
        tvShowMore = findViewById<View>(R.id.tv_show_more) as TextView
        val content = SpannableString("Saiba mais")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        tvShowMore!!.text = content
    }

    fun acceptButtom(view: View?) {
        val intent = Intent(this@TermsConditionsActivity, IdentificationActivity::class.java)
        startActivity(intent)
    }

    fun goToShowMoreScreen(view: View?) {
        val intent = Intent(this@TermsConditionsActivity, ShowMoreActivity::class.java)
        startActivity(intent)
    }
}