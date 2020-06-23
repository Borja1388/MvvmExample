package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.home.ui.state.HomeState
import com.example.home.ui.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val nameLabel: TextView = view.findViewById(R.id.fragmenthome__label__title)
        val testButton: Button = view.findViewById(R.id.fragment__home__button_test)
        val progressBar : ProgressBar = view.findViewById(R.id.progressBar)
        viewModel.randomFactLiveData.observe(viewLifecycleOwner, Observer {state ->

            when(state){
                HomeState.Loading ->{
                    progressBar.visibility = View.VISIBLE
                    testButton.isEnabled = false
                }
                is HomeState.Success->{
                    progressBar.visibility = View.GONE
                    testButton.isEnabled = true
                    nameLabel.text = state.randomFactVo.text
                }
                is HomeState.Error ->{
                    progressBar.visibility = View.GONE
                    testButton.isEnabled = true
                    Toast.makeText(context,state.message,Toast.LENGTH_LONG).show()
                }
            }
        })
        testButton.setOnClickListener {
            viewModel.getRandomFact()

        }
    }
}
