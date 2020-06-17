package com.sunny.zy.widget.dialog

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

class VersionUpdateDialog(context: Context, updateDetails: String, updateListener: (() -> Unit)?) :
    AlertDialog.Builder(context) {
    init {
        setTitle("新版本上线了")
        setMessage(updateDetails)
        setPositiveButton("马上尝试") { _: DialogInterface, _: Int ->
            updateListener?.invoke()
        }
        setNegativeButton("忽略") { _: DialogInterface, _: Int -> }
    }
}