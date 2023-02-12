package com.umutg.lolchampionsapp.common

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.umutg.lolchampionsapp.databinding.ErrorDialogBinding

class ErrorDialog(
    context: Context,
    private val text: String,
    private val listener: ErrorDialogListener
) : AppCompatDialog(context) {

    init {
        setCancelable(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ErrorDialogBinding = ErrorDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTransparentBackground()

        binding.tvErrorMessage.text = text

        binding.btnTryAgain.setOnClickListener {
            dismiss()
            listener.onTryAgain()
        }


    }
}

fun AppCompatDialog.setTransparentBackground() {
    window?.setBackgroundDrawableResource(android.R.color.transparent)
}


fun showErrorDialog(context: Context, text: String?, listener: ErrorDialogListener) {

    val errorDialog =
        ErrorDialog(context = context, text = text ?: "Something went wrong.", listener = listener)
    errorDialog.show()
}


interface ErrorDialogListener {
    fun onTryAgain()
}