package com.example.questionarioimpacto

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShowMoreActivity : AppCompatActivity() {
    private var tvShowMore: TextView? = null
    private var clickHere: TextView? = null
    private var tvBack: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_more)
        tvShowMore = findViewById<View>(R.id.tv_label_show_more) as TextView
        val sourceString = "Esse questionário faz parte da pesquisa intitulada <b>“[BER HOME] Resiliência no ambiente construído em habitação social: métodos de avaliação tecnologicamente avançados” </b>, desenvolvida pelo [MORA] Pesquisa em Habitação da Faculdade Arquitetura e Urbanismo e Design em parceria com a Faculdade de Computação da Universidade Federal de Uberlândia, financiado pelo CNPq. A pesquisa foi aprovada pelo Comitê de Ética de Pesquisa – CEP – Nº Protocolo 20239019.5.0000.5152."
        tvShowMore!!.text = Html.fromHtml(sourceString)
        clickHere = findViewById<View>(R.id.tv_click_here) as TextView
        val content = SpannableString("Clique aqui")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        clickHere!!.text = content
        tvBack = findViewById<View>(R.id.tv_back) as TextView
        val contentBack = SpannableString("Voltar")
        contentBack.setSpan(UnderlineSpan(), 0, contentBack.length, 0)
        tvBack!!.text = contentBack
    }



    fun back(view: View?) {
        super.onBackPressed()
    }
}