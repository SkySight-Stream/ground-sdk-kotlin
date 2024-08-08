package com.parrot.hellodrone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class MediaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        val videoView: VideoView = findViewById(R.id.video_view)

        // Get the video URI
        val videoUri: Uri = Uri.parse("android.resource://${packageName}/${R.raw.dummy}")

        // Set the video URI
        videoView.setVideoURI(videoUri)

        // Start playing the video
        videoView.start()
    }
}