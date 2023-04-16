package com.example.prayertimequran.data.dataProviders.tfseerProvider

import android.content.Context
import com.example.prayertimequran.data.models.quran.Tfseer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.IOException
import java.nio.charset.StandardCharsets

class TfseerProvider (){
     fun getAllTfasser(context: Context): ArrayList<Tfseer>? {
        return try {
            val azkarFile = context.assets.open("tfseer.json")
            val size = azkarFile.available()
            val bytes = ByteArray(size)
            azkarFile.read(bytes)
            azkarFile.close()
            val tfserString = String(bytes, StandardCharsets.UTF_8)
            val gson = Gson()
            gson.fromJson(tfserString, object : TypeToken<List<Tfseer?>?>(){}.type)
        } catch (e: IOException) {
            e.printStackTrace()
            null

    }
    }


}