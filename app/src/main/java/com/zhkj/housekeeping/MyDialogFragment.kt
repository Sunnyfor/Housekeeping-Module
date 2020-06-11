package com.zhkj.housekeeping

import android.app.Dialog
import android.app.DialogFragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.view.*


/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/9 17:00
 */
class MyDialogFragment() : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = LayoutInflater.from(activity).inflate(R.layout.activity_main, null, false)

        val build = AlertDialog.Builder(activity)
            .setTitle("测试")
            .setView(view)

        view.button.setOnClickListener {
            activity?.startActivityForResult(Intent(activity, BActivity::class.java), 0)
        }
        return build.create()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(activity, "调用了onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(activity, "调用了Stop", Toast.LENGTH_SHORT).show()
    }
}