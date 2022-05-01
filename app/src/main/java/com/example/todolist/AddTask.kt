package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        //Making the buttons work
        var pressed_todo=0
        var pressed_meeting=0
        var pressed_email=0
        var pressed_phone=0
        val date = findViewById<EditText>(R.id.editTextDueDate)
        //To-do button

        val AddTodoButton = findViewById<Button>(R.id.todo_button)

        AddTodoButton.setOnClickListener(){
            pressed_todo=1
            val TodoTitle = findViewById<EditText>(R.id.editTextTaskTitle)
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("todo_button", pressed_todo)
                putExtra("todo_title",TodoTitle.getText().toString())
                putExtra("date",date.getText().toString())
            }
            startActivity(intent)
        }

        val AddMeetingButton = findViewById<Button>(R.id.meeting_button)
        AddMeetingButton.setOnClickListener(){
            pressed_meeting=1
            val MeetingTitle = findViewById<EditText>(R.id.editTextTaskTitle)
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("meeting_button", pressed_meeting)
                putExtra("meeting_title",MeetingTitle.getText().toString())
                putExtra("date",date.getText().toString())
            }
            startActivity(intent)
        }

        val AddEmailButton = findViewById<Button>(R.id.email_button)
        AddEmailButton.setOnClickListener(){
            pressed_email=1
            val EmailTitle = findViewById<EditText>(R.id.editTextTaskTitle)
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("email_button", pressed_email)
                putExtra("email_title",EmailTitle.getText().toString())
                putExtra("date",date.getText().toString())
            }
            startActivity(intent)
        }

        val AddPhoneButton = findViewById<Button>(R.id.phone_button)
        AddPhoneButton.setOnClickListener(){
            pressed_phone=1
            val PhoneTitle = findViewById<EditText>(R.id.editTextTaskTitle)
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("phone_button", pressed_phone)
                putExtra("phone_title",PhoneTitle.getText().toString())
                putExtra("date",date.getText().toString())
            }
            startActivity(intent)
        }


    }


}