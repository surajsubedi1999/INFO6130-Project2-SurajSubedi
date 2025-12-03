package com.example.android.testing.espresso.BasicSample

import org.junit.Test
import org.junit.Assert.*

class EmailValidatorTest {

    @Test
    fun testCorrectEmailFormat() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test
    fun testCorrectSubdomainEmail() {
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test
    fun testIncorrectDomain() {
        assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test
    fun testDoubleDots() {
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }

    @Test
    fun testNoUsername() {
        assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }

    @Test
    fun testNoDomain() {
        assertFalse(EmailValidator.isValidEmail("testing123"))
    }

    @Test
    fun testEmptyString() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun testNullInput() {
        assertFalse(EmailValidator.isValidEmail(null))
    }
}