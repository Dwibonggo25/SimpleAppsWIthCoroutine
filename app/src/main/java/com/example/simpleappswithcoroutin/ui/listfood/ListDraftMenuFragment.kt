package com.example.simpleappswithcoroutin.ui.listfood


import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.example.simpleappswithcoroutin.R
import com.example.simpleappswithcoroutin.databinding.FragmentListDraftMenuBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ListDraftMenuFragment : Fragment() {

    private lateinit var viewModel : ListDraftMenuViewmodel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var binding: FragmentListDraftMenuBinding

    private lateinit var adapter : ListFoodAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListDraftMenuViewmodel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_draft_menu, container, false)
        binding.apply {
            vm = viewModel
            binding.setLifecycleOwner(activity)
            binding.executePendingBindings()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter  = ListFoodAdapter ()
        binding.foodsList.adapter = adapter
        viewListFood (adapter)

        super.onViewCreated(view, savedInstanceState)
    }

    private fun viewListFood(adapter: ListFoodAdapter) {
        viewModel.foods.observe(viewLifecycleOwner){foods->
            adapter.submitList(foods)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.filter_zone -> {
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
