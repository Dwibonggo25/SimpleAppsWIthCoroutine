package com.example.simpleappswithcoroutin.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleappswithcoroutin.R
import com.example.simpleappswithcoroutin.databinding.HomeFragmentBinding
import com.example.simpleappswithcoroutin.model.Todo
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : Fragment() {

    private lateinit var viewModel : HomeViewmodel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var binding: HomeFragmentBinding

    private lateinit var adapter: SplashScreenAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewmodel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        binding.apply {
            fragment = this@HomeFragment
            vm = viewModel
            binding.setLifecycleOwner(activity)
            binding.executePendingBindings()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        viewModel.userLiveData.observe (this, Observer {
          // refreshData(it)
            binding.tvHeader.setText(it.title)
        })

    }

    private fun initRecyclerView() {
        adapter = SplashScreenAdapter (activity!!, viewModel)
        val layoutmanager = LinearLayoutManager (activity)
        binding.recyclerview.layoutManager = layoutmanager
        binding.recyclerview.adapter = adapter
    }

    fun refreshData(data: List<Todo>) {
        adapter.submitList(data)
    }
}
