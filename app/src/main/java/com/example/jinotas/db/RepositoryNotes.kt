package com.example.jinotas.db

import androidx.lifecycle.LiveData

class RepositoryNotes(private val noteDAO: NoteDAO, private val tokenDAO: TokenDAO) {

    fun getNoteOrderByDate(): ArrayList<Note> {
        return noteDAO.getNoteOrderByDate() as ArrayList<Note>
    }

    fun getNoteOrderByTitle(): ArrayList<Note> {
        return noteDAO.getNoteOrderByTitle() as ArrayList<Note>
    }

    fun getNotesList(): ArrayList<Note> {
        return noteDAO.getNotesList() as ArrayList<Note>
    }

    fun getNoteByTitle(filter: String): ArrayList<Note> {
        return noteDAO.getNoteByTitle(filter) as ArrayList<Note>
    }

    fun getAllNotesLive(): LiveData<ArrayList<Note>> {
        return noteDAO.getAllNotesLive() as LiveData<ArrayList<Note>>
    }

    fun insertToken(token: Token) {
        tokenDAO.insertToken(token)
    }

    fun updateToken(token: Token){
        tokenDAO.updateToken(token)
    }

    fun deleteToken(token: Token){
        tokenDAO.deleteToken(token)
    }

    fun getToken(): String {
        return tokenDAO.getToken()
    }

    fun updateNote(note: Note){
        noteDAO.updateNote(note = note)
    }

    fun insertNote(note: Note){
        noteDAO.insertNote(note)
    }

    fun deleteNote(note: Note){
        noteDAO.deleteNote(note)
    }
}