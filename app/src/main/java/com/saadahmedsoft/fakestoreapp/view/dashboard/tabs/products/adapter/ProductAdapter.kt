package com.saadahmedsoft.fakestoreapp.view.dashboard.tabs.products.adapter

import android.annotation.SuppressLint
import android.graphics.Paint
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
import java.text.DecimalFormat

class ProductAdapter(private val listener: OnItemActionListener<ProductResponse>) : BaseRecyclerAdapter<ProductResponse, ItemLayoutProductBinding>() {
    override val layoutRes: Int
        get() = R.layout.item_layout_product

    @SuppressLint("SetTextI18n")
    override fun onBind(binding: ItemLayoutProductBinding, item: ProductResponse, position: Int) {
        binding.item = item
        Picasso.get().load(item.image).into(binding.ivProductImage)

        if (position % 3 == 0) binding.tvOutOfStock.visible()
        else binding.tvOutOfStock.invisible()

        binding.category.text = item.category?.let { capitalizeAllFirstChars(it) }

        val tenPercentAdditionOfPrice = item.price!! * 10 / 100 + item.price!! //Though our response does not contains any other price, So I'm generating main product price by increasing the price by 10%
        binding.tvMainPrice.text = "৳ ${DecimalFormat("##.##").format(tenPercentAdditionOfPrice)}"
        binding.tvMainPrice.paintFlags = binding.tvMainPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        binding.root.onClicked {
            listener.onItemClickListener(it, item, position)
        }

        binding.root.onLongPressed {
            listener.onItemLongPressListener(it, item, position)
            true
        }
    }

    private fun capitalizeAllFirstChars(s: String): String {
        val chars = s.toCharArray()
        val sb = StringBuilder()

        for (i in chars.indices) {
            if (i == 0 || chars[i - 1] == ' ') sb.append(chars[i].uppercaseChar())
            else sb.append(chars[i])
        }

        return sb.toString()
    }
}