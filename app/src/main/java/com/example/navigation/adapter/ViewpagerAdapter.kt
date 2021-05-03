package com.example.navigation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.navigation.fragment.VideoCallFragment
import com.example.navigation.fragment.VoiceCallFragment

class ViewpagerAdapter(supportFragmentManager: FragmentManager):
        FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
        return when (position){
            0 ->{
                VoiceCallFragment()
            }else ->{
                return VideoCallFragment()
            }
        }
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Voice Call"
            else -> "Video Call"

        }
    }

}