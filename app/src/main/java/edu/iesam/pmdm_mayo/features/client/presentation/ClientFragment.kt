package edu.iesam.pmdm_mayo.features.client.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.pmdm_mayo.databinding.FragmentClientsBinding
import edu.iesam.pmdm_mayo.features.client.presentation.adapter.ClientAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClientFragment: Fragment() {

    private var _binding: FragmentClientsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ClientViewModel by viewModel()
    private lateinit var adapter: ClientAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClientsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ClientAdapter()
        binding.recyclerViewClients.adapter = adapter
        binding.recyclerViewClients.layoutManager = LinearLayoutManager(requireContext())

        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            if (state.isLoading == true) {
                Log.d("@dev", "Loading..")
            } else {
                Log.d("@dev", "Loaded")
            }

            state.errorApp?.let { }

            adapter.submitList(state.clients)
        }
        viewModel.loadClients()
    }
}