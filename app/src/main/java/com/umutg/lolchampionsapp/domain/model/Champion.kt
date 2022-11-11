package com.umutg.lolchampionsapp.domain.model

data class Champion(
    var name: String,
    var description: String,
    var lore: String,
    var blurb: String,
    var championSpell: List<ChampionSpell>?
)