package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import android.widget.Button as Button

class MainActivity : AppCompatActivity() {

    var code: String = ""

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        val button1: Button = findViewById(R.id.button1)

        button1.setOnClickListener { it ->
            clear()
            textView.append("1")
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener { it ->
            clear()
            textView.append("2")
        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener { it ->
            clear()
            textView.append("3")
        }

        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener { it ->
            clear()
            textView.append("4")
        }

        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener { it ->
            clear()
            textView.append("5")
        }

        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener { it ->
            clear()
            textView.append("6")
        }

        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener { it ->
            clear()
            textView.append("7")
        }

        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener { it ->
            clear()
            textView.append("8")
        }

        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener { it ->
            clear()
            textView.append("9")
        }

        val button_back: Button = findViewById(R.id.back)
        button_back.setOnClickListener { it ->
            clear()
            val asd = textView.getText().toString().dropLast(1)
            textView.setText(asd)
        }

        val button0: Button = findViewById(R.id.button0)
        button0.setOnClickListener { it ->
            clear()
            textView.append("0")
        }

        val buttonOk: Button = findViewById(R.id.OK)
        buttonOk.setOnClickListener { it ->
            clear()
            var isSame: Boolean = false
            if(textView.getText().toString().contains("1567")){ isSame = true }
            if(isSame==true){
                textView.setTextColor(resources.getColor(R.color.blue))
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            }
            else{textView.setTextColor(resources.getColor(R.color.red))}
        }

    }

    fun clear(){
        if(textView.text.contains("Введ")){
            textView.text = ""
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("dan", "onSaveInstanceState")
        outState.putString("key",textView.text.toString())
        outState.putInt("key2",textView.currentTextColor)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("dan", "onRestoreInstanceState")
        val text = savedInstanceState.getString("key")
        val color = savedInstanceState.getInt("key2")
        textView.text = text
        textView.setTextColor(color)
    }

}