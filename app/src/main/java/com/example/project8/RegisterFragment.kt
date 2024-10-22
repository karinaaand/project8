package com.example.project8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project8.databinding.FragmentRegisterBinding

// Kelas RegisterFragment untuk menangani logika dan tampilan pendaftaran
class RegisterFragment : Fragment() {

    // Variabel untuk binding view dengan elemen-elemen yang ada di layout fragment_register.xml
    private lateinit var binding: FragmentRegisterBinding

    // Fungsi ini dipanggil saat fragment membuat tampilan (view)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menggunakan View Binding untuk menghubungkan layout dengan fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        // Ketika tombol Register diklik
        binding.btnRegister.setOnClickListener {
            // Logika untuk pendaftaran, misalnya validasi data dan pendaftaran ke server
            // Untuk sekarang, dianggap pendaftaran sukses dan langsung diarahkan ke tab Login

            // Menggunakan metode setCurrentTab dari MainActivity untuk mengarahkan ke tab Login (index 0)
            (activity as MainActivity).setCurrentTab(0)
        }

        // Mengembalikan root dari objek binding sebagai tampilan utama fragment ini
        return binding.root
    }
}
