package sheridan.sharm212.workout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sheridan.sharm212.workout.databinding.FragmentLaunchBinding
import sheridan.sharm212.workout.databinding.FragmentLaunchBinding.inflate


class LaunchFragment : Fragment() {

    private lateinit var binding: FragmentLaunchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaunchBinding.inflate(inflater, container, false)
        binding.jogging.setOnClickListener {
            findNavController().navigate(R.id.action_launchFragment_to_jogInputFragment)

        }

        // Inflate the layout for this fragment
return binding.root
    }

}