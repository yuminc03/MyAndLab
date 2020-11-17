package kr.hs.emirim.s2019w20.myandlab.ch06advwidget

import android.app.TabActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tab.*
import kr.hs.emirim.s2019w20.myandlab.R

@Suppress("DEPRECATION")
class TabWidgetActivity : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        val tabHost = this.tabHost

        val tabSpecSong = tabHost.newTabSpec("SONG")
            .setIndicator("음악별")
            .setContent(R.id.tabSong)
        tabHost.addTab(tabSpecSong)

        val tabSpecArtist = tabHost.newTabSpec("ARTIST")
            .setIndicator("가수별")
            .setContent(R.id.tabAritist)
        tabHost.addTab(tabSpecArtist)

        val tabSpecAlbum = tabHost.newTabSpec("ALBUM")
            .setIndicator("앨범별")
            .setContent(R.id.tabAlbum)
        tabHost.addTab(tabSpecAlbum)

        tabHost.currentTab = 0
        
    }
}