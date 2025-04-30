package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import com.example.artspace.ui.theme.PastelBlue
import com.example.artspace.ui.theme.PastelPink

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = PastelBlue
                ) {
                    Photoframe()
                }

            }
        }
    }
}

@Composable
fun Photoframe(){
    val currentImage = remember { mutableStateOf(1) }
    when (currentImage.value) {
        1 -> Img(R.drawable.img1, R.string.img12, R.string.img1, R.string.img11, { currentImage.value = 5 }, { currentImage.value = 2 })
        2 -> Img(R.drawable.img2, R.string.img22, R.string.img2, R.string.img21, { currentImage.value = 1 }, { currentImage.value = 3 })
        3 -> Img(R.drawable.img3, R.string.img32, R.string.img3, R.string.img31, { currentImage.value = 2 }, { currentImage.value = 4 })
        4 -> Img(R.drawable.img4, R.string.img42, R.string.img4, R.string.img41, { currentImage.value = 3 }, { currentImage.value = 5 })
        5 -> Img(R.drawable.img5, R.string.img52, R.string.img5, R.string.img51, { currentImage.value = 4 }, { currentImage.value = 1 })
    }
    }



@Composable
fun Img(
    drawableResourceId: Int,
    contentResourceId: Int,
    textResourceId: Int,
    text2ResourceId: Int,
    previous: () -> Unit,
    next: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(drawableResourceId),
                contentDescription = stringResource(contentResourceId),
                modifier = Modifier.height(250.dp)
                    .clip(RoundedCornerShape(16.dp))
                    //.shadow(8.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(textResourceId),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(text2ResourceId),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp)
                    .height(48.dp)
            ) {
                Button(
                    onClick = { previous() },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    elevation = ButtonDefaults.buttonElevation(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PastelPink,
                        contentColor = Color.Black
                    )) {
                    Text(text = "Previous")
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { next() },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    elevation = ButtonDefaults.buttonElevation(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PastelPink,
                        contentColor = Color.Black
                    )
                    ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Photoframe()
    }
}