package com.anri.exampleapp.ui.delegates

import android.view.ViewGroup
import com.anri.exampleapp.R
import com.anri.exampleapp.base.adapter.AdapterDelegate
import com.anri.exampleapp.base.adapter.BaseViewHolder
import com.anri.exampleapp.databinding.ItemCharacterBinding
import com.anri.exampleapp.domain.model.PostModel
import com.anri.exampleapp.domain.model.characters.Character
import com.anri.exampleapp.misc.loadImage

class CharacterViewHolder(val parent: ViewGroup) : BaseViewHolder(parent, R.layout.item_character) {

    lateinit var binding: ItemCharacterBinding

    override fun bind(model: PostModel, viewHolder: BaseViewHolder) {
        model as Character
        binding = ItemCharacterBinding.bind(itemView)
        with(binding) {
            ivImageCharacter.loadImage(model.imageUrl)
            tvName.text = model.name
            tvStatus.text = model.status
            tvRace.text = model.species
            tvSex.text = model.gender
        }
    }
}

class CharacterDelegate : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder =
        CharacterViewHolder(parent)

    override fun isValidType(postModel: PostModel): Boolean = postModel is Character
}

