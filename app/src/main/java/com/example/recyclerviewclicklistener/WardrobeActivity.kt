package com.example.recyclerviewclicklistener

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WardrobeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ClothingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wardrobe)


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Мой гардероб"


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val clothingList = createClothingList()


        adapter = ClothingAdapter(clothingList, this)
        recyclerView.adapter = adapter
    }

    private fun createClothingList(): List<ClothingItem> {
        return listOf(
            ClothingItem(R.drawable.jeans1, "Levi's 501 Original", "Классические прямые джинсы, темно-синий деним"),
            ClothingItem(R.drawable.jeans2, "Levi's 511 Slim", "Зауженные джинсы, светло-голубой цвет"),
            ClothingItem(R.drawable.jeans3, "Levi's 512 Taper", "Зауженные джинсы с заниженной посадкой"),
            ClothingItem(R.drawable.jacket1, "Levi's Trucker Jacket", "Классическая джинсовая куртка"),
            ClothingItem(R.drawable.tshirt1, "Levi's Logo Tee", "Белая футболка с классическим логотипом"),
            ClothingItem(R.drawable.shirt1, "Levi's Western Shirt", "Джинсовая рубашка в ковбойском стиле"),
            ClothingItem(R.drawable.jeans4, "Levi's 721 High Rise", "Джинсы с высокой посадкой для женщин"),
            ClothingItem(R.drawable.shorts1, "Levi's 501 Shorts", "Джинсовые шорты классического кроя"),
            ClothingItem(R.drawable.jacket2, "Levi's Sherpa Trucker", "Джинсовая куртка с подкладкой"),
            ClothingItem(R.drawable.hoodie1, "Levi's Logo Hoodie", "Толстовка с капюшоном и логотипом"),
            ClothingItem(R.drawable.jeans5, "Levi's 502 Regular Taper", "Джинсы регулярного кроя, черный цвет"),
            ClothingItem(R.drawable.shirt2, "Levi's Barstow Denim", "Приталенная джинсовая рубашка"),
            ClothingItem(R.drawable.jacket3, "Levi's Leather Jacket", "Кожаная куртка в байкерском стиле"),
            ClothingItem(R.drawable.tshirt2, "Levi's Graphic Tee", "Футболка с винтажным принтом"),
            ClothingItem(R.drawable.jeans6, "Levi's 514 Straight", "Прямые джинсы стандартного кроя"),
            ClothingItem(R.drawable.skirt1, "Levi's Denim Skirt", "Джинсовая юбка классической длины"),
            ClothingItem(R.drawable.sweater1, "Levi's Logo Sweater", "Свитер с вышитым логотипом"),
            ClothingItem(R.drawable.jeans7, "Levi's 311 Shaping Skinny", "Моделирующие узкие джинсы"),
            ClothingItem(R.drawable.jacket4, "Levi's Down Jacket", "Зимняя куртка с утеплителем"),
            ClothingItem(R.drawable.shorts2, "Levi's 505 Shorts", "Джинсовые шорты свободного кроя")
        )
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
            else -> super.onOptionsItemSelected(item)
        }
    }
}