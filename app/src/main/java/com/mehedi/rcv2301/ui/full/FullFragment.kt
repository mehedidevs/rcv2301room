package com.mehedi.rcv2301.ui.full

import android.os.Build
import android.os.Bundle
import android.view.View
import coil.load
import com.mehedi.rcv2301.databinding.FragmentFullBinding
import com.mehedi.rcv2301.models.Love
import com.mehedi.rcv2301.ui.input.InputFragment
import com.mehedi.rcv2301.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullFragment : BaseFragment<FragmentFullBinding>(FragmentFullBinding::inflate) {
    companion object {
        const val KEY = "Key"

    }

    private lateinit var _love: Love

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _love = Love()

        _love = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable(KEY, Love::class.java)!!
        } else {
            requireArguments().getParcelable(KEY)!!
        }




        _love.let {

            binding.apply {

                nameTextView.text = it.name
                detailsTextView.text = it.details
                imageView.load(it.img)


            }


        }
    }


}