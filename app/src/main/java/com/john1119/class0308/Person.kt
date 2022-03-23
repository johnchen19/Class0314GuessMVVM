package com.john1119.class0308

import android.os.Parcel
import android.os.Parcelable
//NO NEED to add plugin in build.gradle ,but difficult
class Person(var name:String?,var age:Int,var height:Float,var weight:Float) :Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readFloat()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}