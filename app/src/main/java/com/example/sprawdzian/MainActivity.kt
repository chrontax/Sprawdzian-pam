package com.example.sprawdzian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprawdzian.ui.theme.Pink80
import com.example.sprawdzian.ui.theme.Purple80
import com.example.sprawdzian.ui.theme.PurpleGrey80
import com.example.sprawdzian.ui.theme.SprawdzianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize().background(Color(0xEE00EE))) {
                Weather("Warszawa", WeatherData(5f, WeatherType.Sunny)) {}
            }
        }
    }
}

enum class WeatherType(val icon: Int) {
    Sunny(R.drawable.ic_sunny),
    SunnyAndCloudy(R.drawable.ic_sunny_and_cloudy),
    Cloudy(R.drawable.ic_cloudy),
    Snow(R.drawable.ic_snow),
}
data class WeatherData(val temperature: Float, val type: WeatherType)

@Composable
fun Weather(city: String, current: WeatherData, forecasts: List<Pair<String, WeatherData>>, date: String, onClick: () -> Unit) {
    CurrentWeather(city, current)
    Spacer(modifier = Modifier.height(16.dp))
    Forecast(forecasts, date)
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CurrentWeather(city: String, data: WeatherData) {
    Column(modifier = Modifier.fillMaxWidth().padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(data.type.icon),
            contentDescription = null,
            modifier = Modifier.width(150.dp))
        Text("%.1f°C".format(data.temperature), fontWeight = FontWeight.Bold, fontSize = 64.sp)
        Text(city, fontSize = 24.sp)
    }
}

@Composable
fun Forecast(forecasts: List<Pair<String, WeatherData>>, date: String) {
    
}