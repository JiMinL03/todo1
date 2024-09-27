package com.sohyun.todo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.sohyun.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //activity_main.xml
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val todos = listOf(
            Todo(1, "Title1", "내용1"),
            Todo(2, "Title2", "내용2"),
            Todo(3, "Title3", "내용3"),
            Todo(4, "Title4", "내용4"),
            Todo(5, "Title5", "내용5"),
            Todo(6, "Title6", "내용6")
        )

        todoAdapter = TodoAdapter(todos, this)
        binding.todoRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.todoRecyclerView.adapter = todoAdapter
    }
}