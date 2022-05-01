package com.example.todolist


import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        var data = ArrayList<ItemsViewModel>()

        // This loop will create 10 Views containing
        // the image with the count of view

        //for (i in 1..10) {
        //    data.add(ItemsViewModel(R.drawable.clock_icon, "Meeting", "test"))
        //}

        //Creating the new activity
        fun new_task(){
            val message = "message"
            val intent = Intent(this, AddTask::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)

        }

        //This will make the button work
        val addButton = findViewById<Button>(R.id.AddButton);
        addButton.setOnClickListener(){
            new_task()
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        //Getting the values of the buttons
        //To-do button
        val info = getIntent()
        var pressed_todo = info.getIntExtra("todo_button",0)
        var tittle_todo = info.getStringExtra("todo_title")
        var date_todo = info.getStringExtra("date")
        if (pressed_todo==1){
            data.add(ItemsViewModel(R.drawable.todo_icon, tittle_todo.toString(), date_todo.toString()))
            //val adapter = CustomAdapter(data)
            //recyclerview.adapter = adapter
            adapter.notifyItemInserted(data.size-1)
            pressed_todo=0
        }
        //Meeting button
        var pressed_meeting = info.getIntExtra("meeting_button",0)
        var tittle_meeting = info.getStringExtra("meeting_title")
        var date_meeting = info.getStringExtra("date")
        if (pressed_meeting==1){
            data.add(ItemsViewModel(R.drawable.clock_icon, tittle_meeting.toString(), date_meeting.toString()))
            //adapter = CustomAdapter(data)
            //recyclerview.adapter = adapter
            adapter.notifyItemInserted(data.size-1)
            pressed_meeting=0
        }

        //Email button
        var pressed_email = info.getIntExtra("email_button",0)
        var tittle_email = info.getStringExtra("email_title")
        var date_email = info.getStringExtra("date")
        if (pressed_email==1){
            data.add(ItemsViewModel(R.drawable.email_icon, tittle_email.toString(), date_email.toString()))
            //adapter = CustomAdapter(data)
            //recyclerview.adapter = adapter
            adapter.notifyItemInserted(data.size-1)
            pressed_email=0
        }

        //Phone button
        var pressed_phone = info.getIntExtra("phone_button",0)
        var tittle_phone = info.getStringExtra("phone_title")
        var date_phone = info.getStringExtra("date")
        if (pressed_phone==1){
            data.add(ItemsViewModel(R.drawable.phone_icon, tittle_phone.toString(), date_phone.toString()))
            //adapter = CustomAdapter(data)
            //recyclerview.adapter = adapter
            adapter.notifyItemInserted(data.size-1)
            pressed_email=0
        }



    }

}
