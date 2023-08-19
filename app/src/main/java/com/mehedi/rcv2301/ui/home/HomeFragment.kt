package com.mehedi.rcv2301.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mehedi.rcv2301.R
import com.mehedi.rcv2301.databinding.FragmentHomeBinding
import com.mehedi.rcv2301.models.Love
import com.mehedi.rcv2301.ui.full.FullFragment
import com.mehedi.rcv2301.ui.input.InputFragment
import com.mehedi.rcv2301.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
), CountAdapter.LoveListener {
    private lateinit var adapter: CountAdapter

    lateinit var bundle: Bundle

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bundle = Bundle()



        viewModel.getAllLove().observe(viewLifecycleOwner) {

            adapter = CountAdapter(
                this@HomeFragment,
                requireContext(),
                it
            )
            binding.countRCV.adapter = adapter

        }


        binding.createPostBtn.setOnClickListener {

            bundle.putString(InputFragment.Submit, InputFragment.Submit)
            findNavController().navigate(R.id.action_homeFragment_to_inputFragment, bundle)


        }
    }

    override fun loveItemClick(love: Love) {

        bundle.putParcelable(FullFragment.KEY, love)
        findNavController().navigate(R.id.action_homeFragment_to_fullFragment, bundle)


    }

    override fun deleteLoveItem(love: Love) {
        viewModel.deleteLove(love)
    }

    override fun updateLoveItem(love: Love) {
        bundle.putString(InputFragment.Update, InputFragment.Update)
        bundle.putParcelable(InputFragment.KEY, love)
        findNavController().navigate(R.id.action_homeFragment_to_inputFragment, bundle)
    }


}