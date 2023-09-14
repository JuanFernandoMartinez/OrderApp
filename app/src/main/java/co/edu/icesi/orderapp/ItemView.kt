package co.edu.icesi.orderapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.edu.icesi.orderapp.databinding.ItemBinding

class ItemView(root: View) : ViewHolder(root) {
    private val binding = ItemBinding.bind(root)

    val nameItem = binding.nameItem
    val priveItem = binding.priceItem
}