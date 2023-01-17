package com.saadahmedsoft.fakestoreapp.view.dashboard.tabs.products.adapter

import com.saadahmedsoft.base.BaseRecyclerAdapter
import com.saadahmedsoft.fakestoreapp.R
import com.saadahmedsoft.fakestoreapp.databinding.ItemLayoutProductBinding
import com.saadahmedsoft.fakestoreapp.services.model.product.ProductResponse
import com.saadahmedsoft.interfaces.OnItemActionListener
import com.saadahmedsoft.kotlinhelper.helper.invisible
import com.saadahmedsoft.kotlinhelper.helper.onClicked
import com.saadahmedsoft.kotlinhelper.helper.onLongPressed
import com.saadahmedsoft.kotlinhelper.helper.visible
import com.squareup.picasso.Picasso

class ProductAdapter(private val listener: OnItemActionListener<ProductResponse>) : BaseRecyclerAdapter<ProductResponse, ItemLayoutProductBinding>() {
    override val layoutRes: Int
        get() = R.layout.item_layout_product

    override fun onBind(binding: ItemLayoutProductBinding, item: ProductResponse, position: Int) {
        binding.item = item
        Picasso.get().load(item.image).into(binding.ivProductImage)

        if (position % 3 == 0) binding.tvOutOfStock.visible()
        else binding.tvOutOfStock.invisible()

        binding.root.onClicked {
            listener.onItemClickListener(it, item, position)
        }

        binding.root.onLongPressed {
            listener.onItemLongPressListener(it, item, position)
            true
        }
    }
}