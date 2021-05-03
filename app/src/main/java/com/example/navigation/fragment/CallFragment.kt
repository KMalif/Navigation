package com.example.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigation.adapter.ViewpagerAdapter
import com.example.navigation.databinding.FragmentCallBinding

    class CallFragment : Fragment() {
    private lateinit var binding: FragmentCallBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentCallBinding.inflate(layoutInflater)

        val fragmentCallViewPager = ViewpagerAdapter(childFragmentManager)
        binding.viewPagerCall.adapter = fragmentCallViewPager
        binding.tabsCall.setupWithViewPager(binding.viewPagerCall)
        return binding.root
    }

}