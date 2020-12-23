package com.malkinfo.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var doneBtn:Button
    private lateinit var editName:EditText
    private lateinit var displayText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**set Button find Id*/
        doneBtn = findViewById(R.id.done_button)
        editName = findViewById(R.id.nickname_edit)
        displayText = findViewById(R.id.nickname_text)
        /**set btn action*/
        doneBtn.setOnClickListener { addNickname(it) }
        displayText.setOnClickListener { updateNickname(it) }
    }

    fun clickHandlerFunction(view: View) {addNickname(view)}
    private fun addNickname(v:View){
        /**set visibility All Text */
        editName.visibility = View.GONE
        v.visibility = View.GONE
        displayText.visibility = View.VISIBLE
        /**set the editText To display Text*/
        displayText.text = editName.text.toString()

        /** Hide the keyboard.*/
        val inputMethodManeger = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManeger.hideSoftInputFromWindow(currentFocus?.windowToken,0)
    }
    private fun updateNickname(v:View){
        /**set visibility All Text*/
        editName.visibility = View.VISIBLE
        v.visibility = View.VISIBLE
        doneBtn.visibility = View.VISIBLE
        displayText.visibility = View.GONE
        /**set text Focus*/
        editName.setText("")
        editName.requestFocus()

        /** Show the keyboard*/
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editName,0)
    }
}