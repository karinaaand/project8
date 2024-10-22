package com.example.project8

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project8.databinding.FragmentLoginBinding

// LoginFragment adalah fragment yang bertanggung jawab untuk menampilkan UI login
// dan menangani logika ketika pengguna mencoba untuk login ke dalam aplikasi.
class LoginFragment : Fragment() {
    // Deklarasi variabel binding untuk menghubungkan dengan layout menggunakan View Binding
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout fragment_login.xml dengan menggunakan View Binding
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Set listener untuk tombol login
        binding.btnLogin.setOnClickListener {
            // Mengambil input dari EditText Email dan Password
            val username = binding.Email.text.toString().trim() // Ambil dan trim input email
            val password = binding.Password.text.toString().trim() // Ambil dan trim input password

            // Menampilkan log input email dan password untuk keperluan debugging
            Log.d("LoginFragment", "Username: '$username', Password: '$password'")

            // Pola regex untuk memvalidasi format email
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

            // Memeriksa apakah username (email) sesuai dengan pola regex dan password tidak kosong
            if (username.matches(emailPattern.toRegex()) && password.isNotEmpty()) {
                // Jika login berhasil, pindah ke DashboardActivity
                val intent = Intent(activity, DashboardActivity::class.java)
                startActivity(intent) // Memulai aktivitas Dashboard
                requireActivity().finish() // Menutup LoginFragment agar pengguna tidak bisa kembali ke sini
            } else {
                // Menampilkan pesan kesalahan jika email atau password tidak valid
                if (!username.matches(emailPattern.toRegex())) {
                    // Jika email tidak valid, tampilkan pesan error di EditText Email
                    binding.Email.error = "Enter a valid email"
                }
                if (password.isEmpty()) {
                    // Jika password kosong, tampilkan pesan error di EditText Password
                    binding.Password.error = "Password cannot be empty"
                }
            }
        }

        // Navigasi ke tab Register ketika teks "Register" di-klik
        binding.txtRegister2.setOnClickListener {
            // Set tab yang aktif ke tab Register di MainActivity
            (activity as MainActivity).setCurrentTab(1) // Asumsi kamu punya tab Register di MainActivity
        }

        // Mengembalikan root view dari layout ini
        return binding.root
    }
}
