package com.ar.domain.model.pokemonItemModel

import android.os.Parcel
import android.os.Parcelable

data class PokemonItemModel(
    var name: String? = null,
    var url: String? = null,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonItemModel> {
        override fun createFromParcel(parcel: Parcel): PokemonItemModel {
            return PokemonItemModel(parcel)
        }

        override fun newArray(size: Int): Array<PokemonItemModel?> {
            return arrayOfNulls(size)
        }
    }
}