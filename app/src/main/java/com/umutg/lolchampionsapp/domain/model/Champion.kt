package com.umutg.lolchampionsapp.domain.model

data class Champion(
    var id: String,
    var name: String,
    var title: String,
    var lore: String,
    var blurb: String,
    var image: String,
    var championSpell: List<ChampionSpell>
)