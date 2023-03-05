// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.javierlabs.googlemapsapp.place

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.javierlabs.googlemapsapp.R
import java.io.InputStream
import java.io.InputStreamReader

//read a list of place JSON objects from places.json
class PlacesReader(private val context: Context) {

    //gson object to convert from JSON to Place object.
    private val gson = Gson()

    //inputstream that represents places.json
    private val inputStream: InputStream
        get() = context.resources.openRawResource(R.raw.places)

    //read the list of place JSON objects in the places.json
    //returns a list of place objects.
    fun read(): List<Place> {
        val itemType = object : TypeToken<List<PlaceResponse>>() {}.type
        val reader = InputStreamReader(inputStream)
        return gson.fromJson<List<PlaceResponse>>(reader, itemType).map {
            it.toPlace()
        }
    }
}