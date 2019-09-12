package com.example.customrecycler.ui.home

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
import com.example.customrecycler.R
import com.example.customrecycler.databinding.FragmentSplashScreenBinding
import com.example.customrecycler.db.entity.Test
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : Fragment() {

    private lateinit var viewModel : HomeViewmodel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var binding: FragmentSplashScreenBinding

    private lateinit var adapter: SplashScreenAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewmodel::class.java)
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_splash_screen, container, false)
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
        //    refreshData(it)
        })

    }

    private fun initRecyclerView() {
        adapter = SplashScreenAdapter (activity!!, viewModel)
        val layoutmanager = LinearLayoutManager (activity)
        binding.recyclerview.layoutManager = layoutmanager
        binding.recyclerview.adapter = adapter
    }

    fun refreshData(data: List<Test>) {
        adapter.submitList(data)
    }
}
