package co.edu.icesi.orderapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import co.edu.icesi.orderapp.model.Item
import java.text.NumberFormat

class ItemAdapter : Adapter<ItemView>() {
    val items = ArrayList<Item>()

    init {
        items.add(Item("Chuleta", 80000.0))
        items.add(Item("Cerveza", 3500.0))
        items.add(Item("Pollo", 12800.0))
    }

    fun addItem(item:Item){
        items.add(item)
        notifyDataSetChanged()
    }

    //list's items scaffolding method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item, null, false)
        return ItemView(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemView, position: Int) {
        val data = items[position]
        holder.nameItem.text = data.name
        holder.priveItem.text =  "$ ${data.price}"
    }


}