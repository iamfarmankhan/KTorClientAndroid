package com.farman.ktorclient.data

import com.farman.ktorclient.model.Movie
import com.farman.ktorclient.model.PopularMoviesResponse

interface MovieRepository {
    suspend fun getPopularMovies():Resource<PopularMoviesResponse>
}