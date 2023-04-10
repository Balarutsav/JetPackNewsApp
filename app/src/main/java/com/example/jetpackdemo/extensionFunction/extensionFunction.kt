package com.example.jetpackdemo.extensionFunction

import android.widget.EditText



fun String.isValidEmail(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.checkIsEmpty(): Boolean {
    return this.trim().isEmpty()
}