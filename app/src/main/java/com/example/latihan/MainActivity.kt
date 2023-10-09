package com.example.latihan

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView2)

        val username = intent.getParcelableExtra<User>("User")?.username
        val password = intent.getParcelableExtra<User>("User")?.password
        tv.text = "Username $username dan Password $password"

        val btnImplicit: Button = findViewById(R.id.btn_implicit)
        btnImplicit.setOnClickListener(this)

        val btnShare: Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener(this)

        val btnFragment: Button = findViewById(R.id.btn_fragment)
        btnFragment.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_share -> {
                val message = "Hallo tes"
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"
                startActivity(intent)
            }
                R.id.btn_implicit -> {
                    val intent = android.content.Intent()
                    intent.putExtra("history", "Anda sudah login")
                    setResult(androidx.appcompat.app.AppCompatActivity.RESULT_OK, intent)
                    finish()

                }
                R.id.btn_fragment -> {
                    val intent = Intent(this@MainActivity, Fragment::class.java)
                    startActivity(intent)
                }
            }
        }
    }