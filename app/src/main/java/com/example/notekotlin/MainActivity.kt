package com.example.notekotlin

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notekotlin.ui.theme.NoteKotlinTheme
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnEditNote = findViewById<ImageButton>(R.id.imageButton)
        btnEditNote.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Ajouter une note")

            // Créer un champ de saisie (EditText) dans la boîte de dialogue
            val inputEditText = EditText(this)
            inputEditText.hint = "Saisissez votre note"

            alertDialogBuilder.setView(inputEditText)

            alertDialogBuilder.setPositiveButton("Enregistrer") { _, _ ->
                val enteredText = inputEditText.text.toString()
                if (enteredText.isNotEmpty()) {
                    // Créer un TextView pour afficher la note
                    val noteTextView = TextView(this)
                    noteTextView.text = enteredText

                    // Obtenir la zone des notes LinearLayout
                    val zoneDesNotes = findViewById<LinearLayout>(R.id.zone_des_notes)

                    // Ajouter le TextView à la zone des notes
                    zoneDesNotes.addView(noteTextView)
                }
            }

            alertDialogBuilder.setNegativeButton("Annuler") { _, _ ->
                // Rien ?
            }

            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }


}
