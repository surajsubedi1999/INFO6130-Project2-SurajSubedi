package jlin2.examples.localtesting

import org.junit.Test
import org.junit.Assert.*

class EmailValidatorTest {

    // Test 1: Correct email address format, such as 123@abc.com
    @Test
    fun testCorrectEmailFormat() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    // Test 2: Correct email address subdomain format, such as 123@abc.co.ca
    @Test
    fun testCorrectSubdomainEmail() {
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    // Test 3: Incorrect email address format (incorrect domain), such as 123@abc
    @Test
    fun testIncorrectDomain() {
        assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    // Test 4: Incorrect email address format (with double dots), such as 123@abc..com
    @Test
    fun testDoubleDots() {
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }

    // Test 5: Incorrect email address format (without username), such as @abc.com
    @Test
    fun testNoUsername() {
        assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }

    // Test 6: Incorrect email address format (without domain), such as testing123
    @Test
    fun testNoDomain() {
        assertFalse(EmailValidator.isValidEmail("testing123"))
    }

    // Test 7: Incorrect email address format (empty string), such as ""
    @Test
    fun testEmptyString() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    // Test 8: Incorrect email address format (null), null
    @Test
    fun testNullInput() {
        assertFalse(EmailValidator.isValidEmail(null))
    }
}