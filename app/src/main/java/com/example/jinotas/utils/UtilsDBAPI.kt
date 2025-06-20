package com.example.jinotas.utils

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.jinotas.db.AppDatabase
import com.example.jinotas.db.Note
import io.github.cdimascio.dotenv.dotenv

object UtilsDBAPI {
    private lateinit var db: AppDatabase
    lateinit var localPendingNotes: MutableList<Note>
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")    // Método para obtener el ID del dispositivo
    val FILE = stringPreferencesKey("notes_list_style")
    private val dotenv = dotenv {
        directory = "/assets"
        filename = "env"
    }
    //Urls para CrudApi (retrofit)
    val URL_API_NOTES = dotenv["URL_API_NOTES"]
    val URL_API_TOKEN_USER = dotenv["URL_API_USER"]
    val API_TOKEN = dotenv["API_TOKEN"]

    //Esto es para almacenar en la api
//    suspend fun saveNoteToCloud(note: Note, context: Context) {
//        CrudApi.postNote(note, context)
//    }

    //Esto es para eliminar en la api
    suspend fun deleteNoteInCloud(note: Note, context: Context) {
        Log.e("deleteNote", note.toString())
//        if(note.id != null){
//            CrudApi().deleteNote(note.id!!)
//        }
    }
    //-------------------

    //Esto es para almacenar en la DB
    suspend fun saveNoteToLocalDatabase(note: Note, context: Context) {
        // Aquí almacenas la nota en NocoDB mediante una API
        db = AppDatabase.getDatabase(context)
        db.noteDAO().insertNote(note)
    }

    //Esto es para modificar en la DB
    suspend fun updateNoteInLocalDatabase(note: Note, context: Context) {
        db = AppDatabase.getDatabase(context)
        db.noteDAO().updateNote(note)
    }

    suspend fun deleteNoteInLocalDatabase(note: Note, context: Context) {
        db = AppDatabase.getDatabase(context)
        db.noteDAO().deleteNote(note)
    }
}