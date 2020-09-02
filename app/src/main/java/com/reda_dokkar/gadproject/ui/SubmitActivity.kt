package com.reda_dokkar.gadproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.reda_dokkar.gadproject.R
import com.reda_dokkar.gadproject.data.viewModel.SubmitVm
import kotlinx.android.synthetic.main.activity_submit.*
import kotlinx.android.synthetic.main.dialog_confirmation.view.*
import kotlinx.android.synthetic.main.dialog_result.view.*

class SubmitActivity : AppCompatActivity() {

    private lateinit var submitVm:SubmitVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        submitVm = ViewModelProvider(this).get(SubmitVm::class.java)

        submitVm.getSubmitLv().observe(this,
            Observer<Boolean> {

                val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this,R.style.DialogAnimation)
                val inflater: LayoutInflater = this.layoutInflater
                val dialogView: View = inflater.inflate(R.layout.dialog_result, null)
                val mDialog = builder.setView(dialogView)
                    .create()
                mDialog.setCancelable(true)
                mDialog.setCanceledOnTouchOutside(true)

                if(!it){
                    dialogView.dialog_res_img.setImageResource(R.drawable.ic_error)
                    dialogView.dialog_res_txt.text = "Submission not successful"
                }

                mDialog.show()



            })
    }

    fun submit(view: View) {

        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this,R.style.DialogAnimation)
        val inflater: LayoutInflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.dialog_confirmation, null)
        val mDialog = builder.setView(dialogView)
            .create()
        mDialog.setCancelable(false)
        mDialog.setCanceledOnTouchOutside(false)

        dialogView.confirmation_close.setOnClickListener {
            mDialog.dismiss()
        }

        dialogView.confirmation_yes.setOnClickListener {

            submitVm.submit(
                submit_email.text.toString(),
                submit_first_name.text.toString(),
                submit_last_name.text.toString(),
                submit_link.text.toString()
            )

            mDialog.dismiss()
        }

        mDialog.show()

    }


    fun back(view: View) {
        onBackPressed()
    }


    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent(this,MainActivity::class.java))
    }
}