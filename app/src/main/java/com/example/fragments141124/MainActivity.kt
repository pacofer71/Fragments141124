package com.example.fragments141124

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.example.fragments141124.fragments.FragmentInicio
import com.example.fragments141124.fragments.FragmentMenu

class MainActivity : AppCompatActivity(), OnFragmentActionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarFragments()
    }

    private fun cargarFragments() {
        val fgMenu=FragmentMenu()
        val fgInicio=FragmentInicio()
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fcv_menu, fgMenu)
            add(R.id.fcv_principal, fgInicio)
        }
    }

    override fun onClickImagenMenu(btn: Int) {
        val i=Intent(this, DosActivity::class.java).apply {
            putExtra("BOTONPULSADO", btn)
        }
        startActivity(i)
    }
}