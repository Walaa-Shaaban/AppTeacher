package com.selwan.schools365teacher.ui.login


import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.main.MainNavigationActivity
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
        lateinit var getView :View
    }
    private lateinit var viewModel: LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        getView = inflater.inflate(R.layout.login_fragment, container, false)
        return getView


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        textView3.setOnClickListener {

            if (!TextUtils.isEmpty(editText.text.toString()) && !TextUtils.isEmpty(editText2.text.toString())) {

                viewModel.getLoginMsg(editText.toString(), editText2.toString()).observe(this, Observer {
                    if (it.status == 200){

                        val snackbar =
                            Snackbar.make(
                                view!!,
                                it.message,
                                Snackbar.LENGTH_LONG
                            )
                        val sbView = snackbar.view
                        sbView.setBackgroundResource(R.color.green)
                        snackbar.show()
                        this.context!!.startActivity(Intent(this.context, MainNavigationActivity::class.java))
                    } else {
                        val snackbar =
                            Snackbar.make(
                                view!!,
                                "Error in login",
                                Snackbar.LENGTH_LONG
                            )
                        val sbView = snackbar.view
                        sbView.setBackgroundResource(R.color.redHighDelete)
                        snackbar.show()

                    }
                })


            } else {

                val snackbar =
                    Snackbar.make(
                        view!!,
                        "found field is empty",
                        Snackbar.LENGTH_LONG
                    )
                val sbView = snackbar.view
                sbView.setBackgroundResource(R.color.redHighDelete)
                snackbar.show()
            }
        }
    }



}
