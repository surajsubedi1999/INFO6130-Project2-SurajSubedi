package jlin2.examples.localtesting

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

/**
 * An Email format validator for [android.widget.EditText].
 */
class EmailValidator : TextWatcher {

    internal var isValid = false

    override fun afterTextChanged(editableText: Editable) {
        isValid = isValidEmail(editableText)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) = Unit

    companion object {

        /**
         * Email validation pattern.
         */
        private val EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        /**
         * Validates if the given input is a valid email address.
         *
         * @param email The email to validate.
         * @return `true` if the input is a valid email, `false` otherwise.
         */
        fun isValidEmail(email: CharSequence?): Boolean {
            // 1. Check for null or empty
            if (email == null || email.isEmpty()) {
                return false
            }

            // 2. Check for double dots
            if (email.toString().contains("..")) {
                return false
            }

            // 3. Check if has @ symbol
            if (!email.contains("@")) {
                return false
            }

            // 4. Split email into parts
            val parts = email.toString().split("@")
            if (parts.size != 2) {
                return false
            }

            val localPart = parts[0]
            val domainPart = parts[1]

            // 5. Check local part not empty
            if (localPart.isEmpty()) {
                return false
            }

            // 6. Check domain part not empty
            if (domainPart.isEmpty()) {
                return false
            }

            // 7. Check domain contains dot
            if (!domainPart.contains(".")) {
                return false
            }

            // 8. Final regex validation
            return EMAIL_PATTERN.matcher(email).matches()
        }
    }
}