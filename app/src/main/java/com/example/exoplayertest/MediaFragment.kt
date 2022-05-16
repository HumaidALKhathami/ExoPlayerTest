package com.example.exoplayertest

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class MediaFragment(private val uri: Uri) : Fragment() {

    private lateinit var player: ExoPlayer
    private lateinit var mediaItem: MediaItem
    private lateinit var playerView: StyledPlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        player = ExoPlayer.Builder(requireContext()).build()

        mediaItem = MediaItem.fromUri(uri)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_media, container, false)

        playerView = view.findViewById(R.id.player_view)

        if (playerView.player == null) {
            playerView.player = player
            player.apply {
                setMediaItem(mediaItem)
                prepare()
                play()
            }
        } else {
            player.playWhenReady = true
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        player.play()
    }

    override fun onPause() {
        player.pause()
        super.onPause()
    }
}