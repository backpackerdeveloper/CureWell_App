package com.shubhamtripz.curewell

import android.os.Parcel
import android.os.Parcelable

data class CureDataClass(var dataImage:Int, var dataTitle:String, var dataDesc: String, var dataDetailImage: Int):
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImage)
        parcel.writeString(dataTitle)
        parcel.writeString(dataDesc)
        parcel.writeInt(dataDetailImage)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<CureDataClass> {
        override fun createFromParcel(parcel: Parcel): CureDataClass {
            return CureDataClass(parcel)
        }
        override fun newArray(size: Int): Array<CureDataClass?> {
            return arrayOfNulls(size)
        }
    }
}


