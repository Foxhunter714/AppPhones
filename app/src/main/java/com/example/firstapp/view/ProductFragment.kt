package com.example.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.firstapp.R
import com.example.firstapp.model.db.ProductMini
import com.example.firstapp.model.db.Repository
import com.example.firstapp.viewmodel.ProductViewModel

private var productList = ArrayList<ProductMini>()
internal lateinit var adapter: ProductAdapter
private lateinit var productViewModel: ProductViewModel

class ProductFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ProductAdapter(productList)
        productRecycler.adapter = adapter

        val productViewModel: ProductViewModel by activityViewModels()
        productViewModel.listProduct.observe(viewLifecycleOwner, Observer{
            adapter.updateItems(it)
        })
        var datos = Repository(view.context).loadApiData()
        adapter.productSelected.observe(viewLifecycleOwner, Observer{
        })
    }
}