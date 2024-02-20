package com.example.assignment2_tristanjohnsagucio

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment2_tristanjohnsagucio.ui.theme.Assignment2TristanJohnSagucioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment2TristanJohnSagucioTheme {
                // A surface container using the 'background' color from the theme
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

    var currentStep by remember { mutableStateOf(1) }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(getImageRes(currentStep)),
                contentDescription = stringResource(getImageDescriptionRes(currentStep)),
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(20.dp)
                    .height(400.dp)
                    .clickable {
                        currentStep = getNextStep(currentStep)
                    }
            )
            Text(text = stringResource(getImageDescriptionRes(currentStep)))
            Text(text = stringResource(getTextRes(currentStep)))
            androidx.compose.foundation.layout.Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    modifier = Modifier.padding(20.dp),
                    onClick = { currentStep = getPreviousStep(currentStep) }) {
                    Text("Previous")
                }
                Spacer(modifier = Modifier.width(20.dp))

                Button(
                    modifier = Modifier
                        .padding(20.dp),
                    onClick = { currentStep = getNextStep(currentStep) }) {
                    Text("Next")
                }
            }
        }
    }
}

// Function to get the next step
private fun getNextStep(currentStep: Int): Int {
    return if (currentStep == 3) 1 else currentStep + 1
}

// Function to get the previous step
private fun getPreviousStep(currentStep: Int): Int {
    return if (currentStep == 1) 3 else currentStep - 1
}

// Function to get the image resource based on current step
private fun getImageRes(currentStep: Int): Int {
    return when (currentStep) {
        1 -> R.drawable.neom
        2 -> R.drawable.university
        else -> R.drawable.cake
    }
}

// Function to get the image description resource based on current step
private fun getImageDescriptionRes(currentStep: Int): Int {
    return when (currentStep) {
        1 -> R.string.neom_description
        2 -> R.string.university_description
        else -> R.string.cake_description
    }
}


private fun getTextRes(currentStep: Int): Int {
    return when (currentStep) {
        1 -> R.string.neom
        2 -> R.string.university
        else -> R.string.cake
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment2TristanJohnSagucioTheme {
        Greeting("Android")
    }
}