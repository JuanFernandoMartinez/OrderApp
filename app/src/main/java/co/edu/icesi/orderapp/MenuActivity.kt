package co.edu.icesi.orderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import co.edu.icesi.orderapp.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMenuBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.item1Btn.setOnClickListener(::selectItem)
        binding.item2Btn.setOnClickListener(::selectItem)
        binding.item3Btn.setOnClickListener(::selectItem)

    }

    fun selectItem(view: View){
        val button = view as Button
        var text = button.text.toString()
        val intent = Intent()
        intent.putExtra("item", text)
        setResult(RESULT_OK, intent)
        finish()
    }
}