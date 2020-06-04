package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.calculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private var operation:String=""

    private var value1:Double=0.0
    private var value2:Double=0.0

    private var result:Double=0.0

    private lateinit var stringBuilder: StringBuilder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        stringBuilder= StringBuilder()
        setContentView(R.layout.activity_main)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btn0.setOnClickListener { btnClick(binding.btn0) }
        binding.btn1.setOnClickListener { btnClick(binding.btn1) }
        binding.btn2.setOnClickListener { btnClick(binding.btn2) }
        binding.btn3.setOnClickListener { btnClick(binding.btn3) }
        binding.btn4.setOnClickListener { btnClick(binding.btn4) }
        binding.btn5.setOnClickListener { btnClick(binding.btn5) }
        binding.btn6.setOnClickListener { btnClick(binding.btn6) }
        binding.btn7.setOnClickListener { btnClick(binding.btn7) }
        binding.btn8.setOnClickListener { btnClick(binding.btn8) }
        binding.btn9.setOnClickListener { btnClick(binding.btn9) }
        binding.btnDot.setOnClickListener { btnClick(binding.btnDot) }


        binding.btnPlus.setOnClickListener { btnMaths(binding.btnPlus) }
        binding.btnMinus.setOnClickListener { btnMaths(binding.btnMinus) }
        binding.btnMul.setOnClickListener { btnMaths(binding.btnMul) }
        binding.btnDiv.setOnClickListener { btnMaths(binding.btnDiv) }
        binding.btnMod.setOnClickListener { btnMaths(binding.btnMod) }

        binding.btnEqual.setOnClickListener { btnEqual() }
        binding.btnClear.setOnClickListener { btnClick(binding.btnClear) }
        binding.btnDel.setOnClickListener { btnClick(binding.btnDel) }

    }

    private fun btnClick(view: View){
        var value=binding.editResult.text.toString()
        when(view.id){
            binding.btn0.id->{
               value+="0"
                stringBuilder.append("0")
            }
            binding.btn1.id->{
                value+="1"
                stringBuilder.append("1")
            }
            binding.btn2.id->{
                value+="2"
                stringBuilder.append("2")
            }
            binding.btn3.id->{
                value+="3"
                stringBuilder.append("3")
            }
            binding.btn4.id->{
                value+="4"
                stringBuilder.append("4")
            }
            binding.btn5.id->{
                value+="5"
                stringBuilder.append("5")
            }
            binding.btn6.id->{
                value+="6"
                stringBuilder.append("6")
            }
            binding.btn7.id->{
                value+="7"
                stringBuilder.append("7")
            }
            binding.btn8.id->{
                value+="8"
                stringBuilder.append("8")
            }
            binding.btn9.id->{
                value+="9"
                stringBuilder.append("9")
            }
            binding.btnDot.id->{
                value+="."
                stringBuilder.append(".")
            }
            binding.btnClear.id->{
                value= ""

                stringBuilder.clear()

            }
            binding.btnDel.id->{
                value= binding.editResult.text.toString()
                if(value.length>0){
                    value=value.substring(0,value.length-1)
                }
                if (stringBuilder.length>0){
                    stringBuilder.deleteCharAt(stringBuilder.length-1)
                   // binding.textView.text=stringBuilder
                }
            }
        }
        binding.editResult.setText(value)

        //stringBuilder.append(value)
        binding.textView.text=stringBuilder
    }

    private fun btnMaths(view: View){
        when(view.id){
            binding.btnPlus.id->{operation="+"}
            binding.btnMinus.id->{operation="-"}
            binding.btnMul.id->{operation="*"}
            binding.btnDiv.id->{operation="/"}
            binding.btnMod.id->{operation="%"}
        }
     val   value=binding.editResult.text.toString()
        value1=value.toDouble()
        //clear the edit text
        binding.editResult.text.clear()


        stringBuilder.append(operation)
        binding.textView.text=stringBuilder
    }

    private  fun btnEqual(){

        var value=binding.editResult.text.toString()
        value2=value.toDouble()
        when(operation){
            "+"->{
                result=value1 + value2
            }
            "-"->{
                result=value1 - value2
            }
            "*"->{
                result=value1 * value2
            }
            "/"->{
                result=value1 / value2
            }
            "%"->{
                result=value1 % value2
            }

        }
        binding.editResult.setText(result.toString())

        stringBuilder.append(" = ")
        stringBuilder.append(result)
        binding.textView.text=stringBuilder
    }
}
