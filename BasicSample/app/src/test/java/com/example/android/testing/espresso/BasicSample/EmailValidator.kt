package com.example.android.testing.espresso.BasicSample

object EmailValidator {

    fun isValidEmail(email: String?): Boolean {
        if (email == null || email.isEmpty()) {
            return false
        }

        // Basic email validation pattern
        val pattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}".toRegex()

        return pattern.matches(email)
    }
}