package com.example.project8

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.project8.databinding.ActivityDashboardBinding

// DashboardActivity adalah activity yang menampilkan halaman utama setelah user berhasil login.
// Activity ini juga menyediakan menu opsi untuk mengakses profil dan logout.
class DashboardActivity : AppCompatActivity() {

    // Menggunakan View Binding untuk menghubungkan layout dengan kode.
    private lateinit var binding: ActivityDashboardBinding

    // onCreate() dijalankan saat activity dibuat.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi binding untuk mengakses elemen-elemen di layout activity_dashboard.xml
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root) // Menetapkan tampilan activity

        // Set toolbar yang ada di layout sebagai ActionBar dari activity ini
        setSupportActionBar(binding.toolbar)
    }

    // onCreateOptionsMenu() digunakan untuk menambahkan menu opsi ke toolbar.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate menu dari file XML menu_options.xml dan menampilkannya di toolbar
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    // onOptionsItemSelected() dipanggil ketika item di menu opsi dipilih.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                // Jika item Profile dipilih, kita mengganti fragment saat ini dengan ProfileFragment.
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, ProfileFragment()) // Mengganti fragment yang ada dengan ProfileFragment
                    .commit()
                true
            }
            R.id.action_logout -> {
                // Jika item Logout dipilih, kita mengarahkan user kembali ke MainActivity dengan tab login yang dipilih.
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("TAB_POSITION", 0) // Menyetel posisi tab ke 0 untuk tab Login
                startActivity(intent) // Memulai MainActivity
                finish() // Menutup DashboardActivity agar tidak dapat diakses kembali setelah logout
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
