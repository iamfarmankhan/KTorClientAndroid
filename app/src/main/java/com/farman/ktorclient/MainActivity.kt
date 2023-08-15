package com.farman.ktorclient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.farman.ktorclient.data.MoviesRepositoryImpl
import com.farman.ktorclient.data.Resource
import com.farman.ktorclient.data.RestApiClient
import com.farman.ktorclient.model.PopularMoviesResponse
import com.farman.ktorclient.ui.theme.KTorClientTheme
import io.ktor.client.HttpClient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KTorClientTheme {
                // A surface container using the 'background' color from the theme
                LaunchedEffect(key1 = Unit){
                    val httpClient = RestApiClient().getHttpClient()
                    val moviesRepositoryImpl =  MoviesRepositoryImpl(httpClient)
                    val response = moviesRepositoryImpl.getPopularMovies()
                    when(response){
                        is Resource.Success->{
                            Log.d("Farman","Success ${response.result.results}")
                        }
                        is Resource.Failure->{
                            Log.d("Farman","Failure : ${response.errorBody.status_code}")
                        }
                        is Resource.Loading->{

                        }
                        else->{

                        }
                    }

                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KTorClientTheme {
        Greeting("Android")
    }
}