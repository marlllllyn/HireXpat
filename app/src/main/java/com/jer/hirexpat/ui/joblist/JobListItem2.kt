package com.jer.hirexpat.ui.joblist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jer.hirexpat.R
import com.jer.hirexpat.model.JobData
import com.jer.hirexpat.model.JobList
import com.jer.hirexpat.response.JobResponse


@Composable
fun JobListItem2(

    title: String,
    company: String,
    photoUrl: String,
//    navigateToDetail: (Long) -> Unit,
    modifier: Modifier = Modifier
) {



    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .width(400.dp),



        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth(),

            ){
            AsyncImage(

                model = photoUrl,


                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(60.dp)
                    .clip(RectangleShape)
            )

            Text(
                text = title,
//                text = list.position_available ?: "jobTitle Finance",
//                text = list2.title,

                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 16.dp)
            )
            Text(
                text = company,
//                text = list2.description,
//                text = list2.publisher,
//                text = list.name ?: "company finance",
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                modifier = Modifier

                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp)

            )



        }
    }

}