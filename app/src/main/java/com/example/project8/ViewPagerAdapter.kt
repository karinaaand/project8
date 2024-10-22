package com.example.project8

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// ViewPagerAdapter adalah adapter yang digunakan untuk mengelola fragment di dalam ViewPager2.
// Adapter ini akan menentukan fragment mana yang ditampilkan untuk setiap tab di dalam ViewPager.
class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // Fungsi getItemCount() mengembalikan jumlah tab yang ada.
    // Dalam kasus ini, terdapat 2 tab, yaitu Login dan Register.
    override fun getItemCount(): Int = 2 // Jumlah tab (Login dan Register)

    // Fungsi createFragment() menentukan fragment mana yang akan ditampilkan berdasarkan posisi tab.
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LoginFragment() // Mengembalikan fragment untuk tab Login
            1 -> RegisterFragment() // Mengembalikan fragment untuk tab Register
            else -> throw IllegalStateException("Invalid position: $position") // Lempar pengecualian jika posisi tidak valid
        }
    }
}
