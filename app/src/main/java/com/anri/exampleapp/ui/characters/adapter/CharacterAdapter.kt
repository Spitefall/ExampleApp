package com.anri.exampleapp.ui.characters.adapter

import com.anri.exampleapp.base.adapter.PostAdapter
import com.anri.exampleapp.ui.delegates.CharacterDelegate
import com.anri.exampleapp.ui.delegates.LoaderDelegate

class CharacterAdapter(

): PostAdapter(listOf(
    LoaderDelegate(),
    CharacterDelegate()
)) {
}