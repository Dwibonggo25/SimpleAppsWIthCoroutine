package com.example.simpleappswithcoroutin.ui.detailfoods

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.simpleappswithcoroutin.R
import com.example.simpleappswithcoroutin.databinding.FragmentDetailFoodsMenuBinding
import com.example.simpleappswithcoroutin.ui.listfood.ListDraftMenuViewmodel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailFoodsMenuFragment : Fragment() {

    private lateinit var viewModel : DetailFoodsMenuViewmodel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var binding: FragmentDetailFoodsMenuBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailFoodsMenuViewmodel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_foods_menu, container, false)
        binding.apply {
            vm = viewModel
            binding.setLifecycleOwner(activity)
            binding.executePendingBindings()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val foodId = DetailFoodsMenuFragmentArgs.fromBundle(arguments).foodId

        viewModel.setFoodId(foodId)

        super.onViewCreated(view, savedInstanceState)

    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
