package com.example.exoplayertest

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class ExpoPlayerFragment : Fragment() {

    private lateinit var viewPager: ViewPager2

    private val mp4Url = "https://html5demos.com/assets/dizzy.mp4"
    private val dashUrl = "https://storage.googleapis.com/wvmedia/clear/vp9/tears/tears_uhd.mpd"

    private val videoURL =
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217163353/Screenrecorder-2020-12-17-16-32-03-350.mp4"

    private var uriList: List<Uri> = mutableListOf(
        Uri.parse(videoURL), Uri.parse(dashUrl),
        Uri.parse(mp4Url)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player_exo, container, false)

        viewPager = view.findViewById(R.id.view_pager)

        val adapter = ViewPagerAdapter(uriList, requireActivity())
        viewPager.adapter = adapter

        return view
    }


    inner class ViewPagerAdapter(private val uriList: List<Uri>, fa: FragmentActivity) :
        FragmentStateAdapter(fa) {


        override fun getItemCount(): Int = uriList.size
        override fun createFragment(position: Int): Fragment = MediaFragment(uriList[position])


    }

}