package com.jer.hirexpat.ui.livingCostVisa

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jer.hirexpat.R
import com.jer.hirexpat.ui.theme.HireXpatTheme

@Composable
fun LivingCostPage(
    modifier: Modifier =  Modifier
        .fillMaxSize()
        .background(colorResource(R.color.cream)),

) {
    Column (modifier = modifier

            .verticalScroll(rememberScrollState())
        ,){
        
        tumbnail()
        livingCost()
        visaReq()
        
        
        
    }
    
}


@Composable
fun tumbnail(
    modifier: Modifier = Modifier
) {
    Box (
        modifier = modifier
    ){
        Image(
            painter = painterResource(R.drawable.monas),
            contentDescription = "searchbar banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(260.dp)
        )

        Text(
            text = stringResource(R.string.jakarta),
            fontSize = 35.sp,
            color = colorResource(R.color.orange),
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(25.dp, top = 200.dp),

            )
    }
}

@Composable
fun livingCost(
    modifier: Modifier = Modifier.padding(16.dp)
) {
//    Text(text = "Ini nanti diisi living cost", )
}

@Composable
fun visaReq(
    modifier: Modifier = Modifier.padding(16.dp)
) {
    Column (
        modifier = Modifier.padding(16.dp),
        horizontalAlignment =  Alignment.Start
    ) {

        Card {

        }
        Text(
            text = "Visa Requirements",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(R.string.visa),
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LivingCostPreview(){
    HireXpatTheme {
//        visaReq()
        LivingCostPage()
    }
}