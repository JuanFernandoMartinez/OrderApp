package co.edu.icesi.orderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.icesi.orderapp.databinding.ActivityMainBinding
import co.edu.icesi.orderapp.model.Item

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = ItemAdapter()

        //recycler configuration
        binding.itemsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.itemsRecyclerView.setHasFixedSize(true)
        binding.itemsRecyclerView.adapter = adapter


        var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),::OnResult )

        binding.addItemBtn.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            launcher.launch(intent)
        }
    }

    fun OnResult(result:ActivityResult){
        if (result.resultCode == RESULT_OK){
            val itemSelected = result.data?.extras?.getString("item")
            itemSelected?.let {
                Log.e(">>>", it)
                adapter.addItem(
                    Item(it, 10500.0)
                )
            }
        }else if (result.resultCode == RESULT_CANCELED){
            Toast.makeText(this,"no one item selected", Toast.LENGTH_SHORT).show()
        }
    }
}