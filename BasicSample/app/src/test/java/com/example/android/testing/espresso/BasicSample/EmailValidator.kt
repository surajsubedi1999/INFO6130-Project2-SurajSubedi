package com.example.android.testing.espresso.BasicSample

import org.junit.Test
import org.junit.Assert.*

class EmailValidatorTest {

    @Test
    fun testCorrectEmailFormat() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }
}