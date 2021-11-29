package com.pm.aa.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pm.aa.R
import com.pm.aa.data.entities.Product
import com.pm.aa.data.viewmodel.ProductViewModel
import com.pm.aa.utils.Utils.Companion.hideKeyboard
import kotlinx.android.synthetic.main.custom_row.*
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {

    private lateinit var mProductViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        setHasOptionsMenu(true)

        mProductViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add_garrafa, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        hideKeyboard()

        if (item.itemId == R.id.menu_add) {
           addProduct()
        }

        return super.onOptionsItemSelected(item)
    }
    private fun addProduct() {
        if (!isValid()) {
            return Toast.makeText(
                requireContext(),
                getString(R.string.empty_product_name),
                Toast.LENGTH_LONG
            ).show()
        }

        val product = Product(0, productName.text.toString(), productMarca.text.toString(),productTeor.text.toString())

        mProductViewModel.addProduct(product)

        Toast.makeText(
            requireContext(),
            getString(R.string.product_successfully_added),
            Toast.LENGTH_LONG
        ).show()

        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }

    private fun isValid() : Boolean {
        return !TextUtils.isEmpty(productName.text.toString())
    }
}
