package com.example.project8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// MainActivity adalah activity utama yang mengelola TabLayout dan ViewPager2 untuk navigasi antar tab.
class MainActivity : AppCompatActivity() {
    // Deklarasi variabel untuk TabLayout, ViewPager2, dan ViewPagerAdapter
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    // Metode onCreate dipanggil ketika activity pertama kali dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Menghubungkan layout activity_main.xml

        // Inisialisasi TabLayout dan ViewPager2 dari layout
        tabLayout = findViewById(R.id.tabLayout) // Mengambil elemen TabLayout dari layout
        viewPager = findViewById(R.id.viewPager) // Mengambil elemen ViewPager2 dari layout

        // Inisialisasi ViewPagerAdapter yang digunakan untuk mengelola fragment di tiap tab
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter // Set adapter ke ViewPager2

        // Menghubungkan TabLayout dengan ViewPager2 menggunakan TabLayoutMediator
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Menentukan judul untuk setiap tab berdasarkan posisinya
            tab.text = when (position) {
                0 -> "Login" // Tab 0 menampilkan fragment Login
                1 -> "Register" // Tab 1 menampilkan fragment Register
                2 -> "Dashboard" // Tab 2 menampilkan fragment Dashboard (bila ada)
                3 -> "Profile" // Tab 3 menampilkan fragment Profile (bila ada)
                else -> null // Posisi di luar jangkauan
            }
        }.attach() // Lampirkan mediator untuk menghubungkan TabLayout dengan ViewPager

        // Cek apakah ada intent yang meminta tab tertentu (misalnya tab Login) dan atur tab yang diinginkan
        val tabPosition = intent.getIntExtra("TAB_POSITION", 0) // Ambil posisi tab dari Intent, default 0 (Login)
        setCurrentTab(tabPosition) // Panggil fungsi untuk mengatur tab yang aktif
    }

    // Fungsi untuk mengatur tab yang aktif berdasarkan posisi yang diterima
    fun setCurrentTab(position: Int) {
        viewPager.setCurrentItem(position, true) // Set tab yang aktif berdasarkan posisi yang diberikan
    }
}
