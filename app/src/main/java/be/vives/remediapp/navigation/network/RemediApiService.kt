package be.vives.remediapp.navigation.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

enum class RemediApiFilter(val value: String) {SHOW_RESULTS("results")}

//private const val BASE_URL = "https://api.fda.gov/drug/drugsfda.json"
private const val BASE_URL = "https://api.fda.gov/drug/event.json?api_key=qsJrIMSchWPKGxXGG4Okfjo1UeA1awPBzeCECDS4&search"
// SEARCH_TERM = "search=field:term"
// API_KEY = "qsJrIMSchWPKGxXGG4Okfjo1UeA1awPBzeCECDS4"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()


interface RemediApiService {
    @GET("results")
    fun getProperties(@Query("filter") type : String):
            Deferred<List<MedicationProperty>>
}

object RemediApi {
    val retrofitService: RemediApiService by lazy {
        retrofit.create(RemediApiService::class.java)
    }
}