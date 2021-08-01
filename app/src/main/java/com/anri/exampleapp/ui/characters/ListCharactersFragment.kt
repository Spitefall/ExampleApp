package com.anri.exampleapp.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anri.exampleapp.R
import com.anri.exampleapp.base.BaseFragment
import com.anri.exampleapp.databinding.FragmentListBinding
import com.anri.exampleapp.ui.characters.adapter.CharacterAdapter
import com.anri.exampleapp.ui.listeners.OnScrollListener
import com.anri.exampleapp.ui.model.Loader

class ListCharactersFragment : BaseFragment(R.layout.fragment_list) {

    private val binding by viewBinding(FragmentListBinding::bind)

    private val vmListCharacters by viewModels<ListCharactersViewModel>(
        factoryProducer = { factory },
        ownerProducer = { requireActivity() }
    )

    private val characterAdapter by lazy {
        CharacterAdapter(

        )
    }

    private val onScrollListener by lazy {
        object :
            OnScrollListener(itemCountRecycler = { (binding.rvList.layoutManager as LinearLayoutManager).itemCount },
                firstVisibleItemPosition = { (binding.rvList.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition() }) {
            override fun onLoadMore() {
                vmListCharacters.loadCharacters()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivTitleImage.setImageResource(R.mipmap.characters_image)
        binding.tvTitle.setText(R.string.title_characters)
        binding.rvList.adapter = characterAdapter
    }

    override fun onStart() {
        super.onStart()
        binding.rvList.addOnScrollListener(onScrollListener)
        binding.refresh.setOnRefreshListener {
            vmListCharacters.resetPage()
            onScrollListener.reset()
        }
    }

    override fun onStop() {
        super.onStop()
        binding.rvList.removeOnScrollListener(onScrollListener)
        binding.refresh.setOnRefreshListener(null)
    }

    override fun onDestroyView() {
        binding.rvList.adapter = null
        super.onDestroyView()
    }

    override fun initViewModel() {
        vmListCharacters.characterList.observe(viewLifecycleOwner, {
            characterAdapter.submitList(it)
        })
        vmListCharacters.entriesRefreshing.observe(viewLifecycleOwner, {
            onScrollListener.updateRefreshing(it)
            when {
                (characterAdapter.isEmpty() && it) -> characterAdapter.submitItem(Loader())
                !it -> binding.refresh.isRefreshing = false
            }
        })
    }
}