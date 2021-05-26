package com.example.converterdatas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //habilitar campos de entrada e saida
        val txt_Ano = findViewById<EditText>(R.id.txt_Ano)
        val txt_Mes = findViewById<EditText>(R.id.txt_Mes)
        val txt_Dia = findViewById<EditText>(R.id.txt_Dia)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)
        val btn_Converter = findViewById<Button>(R.id.btn_Converter)

        btn_Converter.setOnClickListener{
            //validação de dados
            if(txt_Ano.text.isEmpty()){
                txt_Ano.error = "Digite a quantidade de ano(s)"
            }
            else if(txt_Mes.text.isEmpty()) {
                txt_Mes.error = "Digite a quantidade de mes(es)"
            }
            else if(txt_Dia.text.isEmpty()){
                txt_Dia.error = "Digite a quantidade de dia(as)"
            }else{
                //entrada de dados
                val ano = txt_Ano.text.toString().toInt()
                val mes = txt_Mes.text.toString().toInt()
                val dia = txt_Dia.text.toString().toInt()
                if(mes > 12){
                    txt_Mes.text.clear()
                    txt_Mes.error = "Digite uma quantidade de mes(es) valida"
                }else if(dia > 31){
                    txt_Dia.text.clear()
                    txt_Dia.error = "Digite uma quantidade de dia(as) valida"
                }else {
                    //processamento
                    val resultado: Int
                    resultado = ano * 360 + mes * 30 + dia
                    //saida
                    txt_Resultado.text = "Voce tem $resultado dia(s) de vida"
                    txt_Ano.text.clear()
                    txt_Mes.text.clear()
                    txt_Dia.text.clear()
                }
            }
        }
    }
}