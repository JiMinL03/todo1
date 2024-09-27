package com.sohyun.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

            class TodoAdapter(private var todos: List<Todo>, context: Context):
        RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() { //구글에서 지원함

            class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
                //데이터와 xml 파일을 연결시켜 view를 만듦
                val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
                //TodoViewHolder는 RecyclerView의 각 항목(View)에 대한 데이터를 보관하는 역할을 함
                //각 RecyclerView 항목을 구성하는 뷰
            }

            //인터페이스
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder { //viewHolder의 객체를 데이터에 올리는 부분
                val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false) //inflate는 xml 파일 전체 불러오는 메서드
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) { //실제 데이터 연결
        val todo = todos[position]
        holder.contentTextView.text = todo.content
    }

    override fun getItemCount(): Int = todos.size
}