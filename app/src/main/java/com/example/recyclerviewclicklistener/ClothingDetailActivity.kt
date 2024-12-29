package com.example.recyclerviewclicklistener

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ClothingDetailActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var titleView: TextView
    private lateinit var descriptionView: TextView
    private lateinit var btnEdit: Button

    private lateinit var clothingItem: ClothingItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clothing_detail)


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Детали гардероба"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        imageView = findViewById(R.id.imageView)
        titleView = findViewById(R.id.tvTitle)
        descriptionView = findViewById(R.id.tvDescription)
        btnEdit = findViewById(R.id.btnEdit)


        clothingItem = intent.getSerializableExtra("CLOTHING_ITEM") as ClothingItem


        imageView.setImageResource(clothingItem.image)
        titleView.text = clothingItem.title
        descriptionView.text = clothingItem.description


        btnEdit.setOnClickListener {
            showEditDialog()
        }
    }

    private fun showEditDialog() {
        val dialog = EditClothingDialog(clothingItem) { updatedItem ->
            clothingItem = updatedItem
            titleView.text = clothingItem.title
            descriptionView.text = clothingItem.description
        }
        dialog.show(supportFragmentManager, "EditClothingDialog")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_exit -> {
                finishAffinity()
                true
            }
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}