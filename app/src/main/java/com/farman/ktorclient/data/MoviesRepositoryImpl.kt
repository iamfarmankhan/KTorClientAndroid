package com.farman.ktorclient.data

import android.util.Log
import com.farman.ktorclient.model.ErrorBody
import com.farman.ktorclient.model.Movie
import com.farman.ktorclient.model.PopularMoviesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody

const val BASE_URL = "https://api.themoviedb.org/3/movie"
class MoviesRepositoryImpl(val httpClient: HttpClient):MovieRepository{
    override suspend fun getPopularMovies(): Resource<PopularMoviesResponse> {
         val POPULAR_MOVIES = "${BASE_URL}/popular"
        //https://ktor.io/docs/request.html  --- to check how to make different type of request
        //here handle error body also
        return try {
            val response = httpClient.get(POPULAR_MOVIES)
            Log.d("Farman","Response code ${response.status}")
            if (response.status.value==200) {
                Resource.Success(response.body<PopularMoviesResponse>())
            }
            else{
                Resource.Failure(response.body<ErrorBody>())
            }




        }
        catch (e:Exception){
            Log.d("Farman","Here in exception")
            e.printStackTrace()
            Resource.Failure(ErrorBody())
        }

    }
}