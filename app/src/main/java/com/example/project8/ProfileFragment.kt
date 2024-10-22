package com.example.project8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.project8.databinding.FragmentProfileBinding

// Kelas ProfileFragment untuk menampilkan profil pengguna
class ProfileFragment : Fragment() {

    // Fungsi ini dipanggil ketika layout fragment di-inflate
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Meng-inflate layout 'fragment_profile.xml' dan mengembalikannya sebagai View
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    // Fungsi ini dipanggil setelah view di-inflate dan siap digunakan
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mencari elemen TextView di dalam layout yang terinflate menggunakan id
        val profileName = view.findViewById<TextView>(R.id.profileName)
        val profileNIM = view.findViewById<TextView>(R.id.profileNIM)

        // Menetapkan teks ke TextView untuk menampilkan Nama dan NIM pengguna
        profileName.text = "Nama: Karina Andriani"
        profileNIM.text = "NIM: 23/520201/SV/23215"
    }
}
