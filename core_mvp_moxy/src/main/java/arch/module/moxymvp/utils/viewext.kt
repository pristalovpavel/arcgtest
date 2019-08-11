package arch.module.moxymvp.utils

import android.widget.EditText


val EditText?.trimmedText: String
    get() {
        val text = this?.text ?: return ""
        return text.toString().trim { it <= ' ' }
    }