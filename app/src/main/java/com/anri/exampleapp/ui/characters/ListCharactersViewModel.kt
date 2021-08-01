package com.anri.exampleapp.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anri.exampleapp.domain.managers.CharacterManager
import com.anri.exampleapp.domain.model.characters.Character
import com.anri.exampleapp.misc.add
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ListCharactersViewModel @Inject constructor(private val manager: CharacterManager) : ViewModel() {

    private val _entriesRefreshing = MutableLiveData<Boolean>()
    val entriesRefreshing: LiveData<Boolean> = _entriesRefreshing
    private val _characterList = MutableLiveData<List<Character>>()
    val characterList: LiveData<List<Character>> = _characterList
    private var page = 0

    private val disposable = CompositeDisposable()

    init {
        loadCharacters()
    }

    fun resetPage() {
        page = 0
        loadCharacters()
    }

    fun loadCharacters() {
        _entriesRefreshing.value = true
        manager.getCharacters(page = page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if(page == 0) {
                    _characterList.value = it.second
                } else {
                    val list = _characterList.value?.toMutableList()
                    list?.let { list ->
                        list.addAll(it.second)
                        _characterList.value = list
                    }
                }
                page = it.first
                _entriesRefreshing.value = false
            },{
                _entriesRefreshing.value = false
            }).add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}