package sheridan.wrimicha.final_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sheridan.wrimicha.final_project.R
import sheridan.wrimicha.final_project.databinding.FragmentJogInputBinding
import sheridan.wrimicha.final_project.databinding.FragmentJogOutputBinding

class JogOutputFragment : Fragment() {
    private lateinit var binding: FragmentJogOutputBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJogOutputBinding.inflate(inflater, container, false)

        binding.backOut.setOnClickListener {
            findNavController().navigate(R.id.action_jogOutputFragment_to_launchFragment)

        }

        // Inflate the layout for this fragment
        return binding.root
    }

}