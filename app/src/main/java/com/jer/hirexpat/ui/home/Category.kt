package com.jer.hirexpat.ui.home

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jer.hirexpat.R
import com.jer.hirexpat.ui.theme.HireXpatTheme

@Composable
fun Category(
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(color = colorResource(R.color.orange))
    ) {
        Card (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .size(width = 50.dp, height = 60.dp)
                .clickable {  }
            ,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),

            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            ){
                Image(
                    painterResource(R.drawable.it),
                    contentDescription = null,

                )
                Text(
                    text = "IT",
                    fontSize = 8.sp,
                    modifier = Modifier
                        .padding(top = 2.dp)


                )
            }
        }

        Card (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .size(width = 50.dp, height = 60.dp)
                .clickable {  }
            ,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),

            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            ){
                Image(
                    painterResource(R.drawable.design),
                    contentDescription = null,

                    )
                Text(
                    text = "Design",
                    fontSize = 8.sp,
                    modifier = Modifier
                        .padding(top = 2.dp)


                )
            }
        }

        Card (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .size(width = 50.dp, height = 60.dp)
                .clickable {  }
            ,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),

            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            ){
                Image(
                    painterResource(R.drawable.hrd),
                    contentDescription = null,

                    )
                Text(
                    text = "HRD",
                    fontSize = 8.sp,
                    modifier = Modifier
                        .padding( 2.dp)


                )
            }
        }

        Card (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .size(width = 50.dp, height = 60.dp)
                .clickable {  }
            ,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),

            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            ){
                Image(
                    painterResource(R.drawable.marketing),
                    contentDescription = null,


                    )
                Text(
                    text = "Marketing",
                    fontSize = 6.sp,
                    modifier = Modifier
                        .padding(top = 2.dp)


                )
            }
        }


        Card (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .size(width = 50.dp, height = 60.dp)
                .clickable {  }
            ,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),

            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            ){
                Image(
                    painterResource(R.drawable.engineering),
                    contentDescription = null,


                    )
                Text(
                    text = "Engineering",
                    fontSize = 6.sp,
                    modifier = Modifier
                        .padding(top = 2.dp)


                )
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun previewshfguegh(){
    HireXpatTheme {
        Category()
    }
}


//import androidx.annotation.DrawableRes
//import androidx.annotation.StringRes
//import com.jer.hirexpat.R
//
//data class CategoryList(
//    @DrawableRes val imageCategory: Int,
//    @StringRes val textCategory: Int
//)
//
//val dummyCategory = listOf(
////    Icons.Default.Menu to "",
//    R.drawable.icon_category_all to R.string.category_all,
//    R.drawable.icon_category_americano to R.string.category_americano,
//    R.drawable.icon_category_cappuccino to R.string.category_cappuccino,
//    R.drawable.icon_category_espresso to R.string.category_espresso,
//    R.drawable.icon_category_frappe to R.string.category_frappe,
//    R.drawable.icon_category_latte to R.string.category_latte,
//    R.drawable.icon_category_macchiato to R.string.category_macchiato,
//    R.drawable.icon_category_mocha to R.string.category_mocha,
//).map { Category(it.first, it.second) }