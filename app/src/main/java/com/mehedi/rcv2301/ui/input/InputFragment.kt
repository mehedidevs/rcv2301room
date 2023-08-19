package com.mehedi.rcv2301.ui.input

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.mehedi.rcv2301.databinding.FragmentInputBinding
import com.mehedi.rcv2301.models.Love
import com.mehedi.rcv2301.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputFragment : BaseFragment<FragmentInputBinding>(FragmentInputBinding::inflate) {


    private val viewModel: InputViewModel by viewModels()


    companion object {
        const val KEY = "key"
        const val Update = "Update"
        const val Submit = "Submit"


    }

    private lateinit var _love: Love


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _love = Love()

        requireArguments().getString(Update)?.let {
            binding.submitButton.text = Update

            _love = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                requireArguments().getParcelable(KEY, Love::class.java)!!
            } else {
                requireArguments().getParcelable(KEY)!!
            }



            _love.let {

                binding.apply {

                    nameEditText.setText(it.name)
                    detailsEditText.setText(it.details)
                    imageUrl.setText(it.img)
                    submitButton.text = Update
                }

            }


        }

        requireArguments().getString(Submit)?.let {
            binding.submitButton.text = Submit

        }


        binding.submitButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val details = binding.detailsEditText.text.toString()
            val url = binding.imageUrl.text.toString()

            val love = Love(name = name, details = details, img = url, _id = _love._id)


            if (binding.submitButton.text.toString() == Submit) {
                viewModel.createLove(love)

            } else {
                viewModel.updateLove(love)
            }


        }

    }


}