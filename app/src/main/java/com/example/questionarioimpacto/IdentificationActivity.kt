package com.example.questionarioimpacto

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.questionarioimpacto.connection.IncrementList
import com.example.questionarioimpacto.databinding.ActivityIdentificationBinding
import com.example.questionarioimpacto.models.QuestionIdModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class IdentificationActivity : AppCompatActivity() {

    var incrementList = IncrementList()
    private var arrayList: ArrayList<QuestionIdModel> = ArrayList()
    private lateinit var viewModel: IdentificationViewModel
    private lateinit var binding: ActivityIdentificationBinding
    private lateinit var dwellerId: String
    val formataData = SimpleDateFormat("dd-MM-yyyy")
    val formataHour = SimpleDateFormat("dd-MM-yyyy")
    var rightNow = Calendar.getInstance()
    val data = Date()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdentificationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel =  ViewModelProvider(this).get(IdentificationViewModel::class.java)
        initObserver()
        viewModel.getDwellerId()

    }

    fun initObserver(){
        viewModel.dwellerIdGenerate.observe(this, Observer {

            dwellerId = it

        })
    }

     fun nextScreen(view: View?) {
         if (emptyFields()){
             showDialog()
         }else
             nextScreen()

    }

    private fun adicionarNaLista(){
        arrayList.add(QuestionIdModel(dwellerId, "07b700c0-2ed3-4fc4-bc85-117058d53a2f", binding.endereco.text.toString(), "5d41b0ce34e4386291d1a769"))
        arrayList.add(QuestionIdModel(dwellerId, "577350b6-fad1-4d1e-b214-b531ea4028ce", formataData.format(data), "5d41b0ce34e4386291d1a769"))
        arrayList.add(QuestionIdModel(dwellerId, "93808a97-9bab-4f05-901b-382c7fcb0dc9", getHour(), "5d41b0ce34e4386291d1a769"))
        arrayList.add(QuestionIdModel(dwellerId, "fcdbf778-c92d-46b7-876f-b02af4aa8026", binding.telefone.text.toString(), "5d41b0ce34e4386291d1a769"))
    }

    private fun getHour(): String{
        return  (rightNow.get(Calendar.HOUR_OF_DAY)-3).toString() + ":" +rightNow.get(Calendar.MINUTE).toString()
    }

    private fun emptyFields(): Boolean{
        if( binding.endereco.text.isEmpty()||binding.telefone.text.isEmpty())
            return true
        return false
    }

    private fun nextScreen(){
        val intent = Intent(this@IdentificationActivity, GeneralInformationActivity::class.java)
        adicionarNaLista()
        intent.putExtra("list", arrayList)
        intent.putExtra("dwellerId", dwellerId)
        startActivity(intent)
    }

    private fun showDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Campos Vazios")
        builder.setMessage("Preencha todos os campos para seguir")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setPositiveButton("Entendi") { dialog, which ->

        }


        builder.show()


    }
}