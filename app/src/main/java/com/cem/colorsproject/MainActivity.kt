package com.cem.colorsproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Tanıtma ve tıklanma işlemlerinin başlatılmasını sağlayan satır
        setListeners()

    }

    // Buttonlara veya TextViewlara basılma durumunda yapılacak işlemi tanımlayan fonksiyon.
    private fun makeColored(view: View) {
        // Basılan viewa göre yapılacak işlemi belirttiğimiz when metodu
        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        when (view.id) {
            R.id.textView1 -> view.setBackgroundColor(Color.WHITE)
            R.id.textView2 -> view.setBackgroundColor(Color.WHITE)
            R.id.textView3 -> view.setBackgroundColor(Color.WHITE)
            R.id.button -> textView1.setBackgroundResource(R.color.my_red)
            R.id.button2 -> textView2.setBackgroundResource(R.color.my_yellow)
            R.id.button3 -> textView3.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    //İşlemleri gerçekleştireceğimiz viewların tanıtıldığı ve basılma durumlarının dinlendiği fonksiyon
    fun setListeners() {
        //viewların tanıtıldığı alan
        val boxOneText = findViewById<TextView>(R.id.textView1)
        val boxTwoText = findViewById<TextView>(R.id.textView2)
        val boxThreeText = findViewById<TextView>(R.id.textView3)
        val redButton = findViewById<Button>(R.id.button)
        val greenButton = findViewById<Button>(R.id.button2)
        val yellowButton = findViewById<Button>(R.id.button3)
        val rootConstraintLayout = findViewById<View>(R.id.constraintLayout)
        //viewların listelendiği kısım
        val clickableViews: List<View> =
            listOf(
                boxOneText, boxTwoText, boxThreeText, rootConstraintLayout,
                redButton, greenButton, yellowButton
            )
        //listelenen viewlardan birisine tıklandığında gerçekleşek işlemin belirtildiği for döngüsü
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }

    }
}