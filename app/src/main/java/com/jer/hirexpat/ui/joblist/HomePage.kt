package com.jer.hirexpat.ui.joblist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.ImagePainter
import com.jer.hirexpat.R
import com.jer.hirexpat.ViewModelFactory

import com.jer.hirexpat.di.Injection

import com.jer.hirexpat.model.JobData
import com.jer.hirexpat.model.JobList
import com.jer.hirexpat.response.JobResponse

import com.jer.hirexpat.ui.home.Category
import com.jer.hirexpat.ui.home.HomeSection
import com.jer.hirexpat.ui.theme.HireXpatTheme
import java.time.format.TextStyle


@Composable
fun HomePage(
    modifier: Modifier = Modifier,

    ){
//    val viewModel  = JobViewModel()
    Scaffold {innerPadding ->
        Column(

            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .fillMaxWidth()
        ) {

            row1()
            row2()
            HomeSection(stringResource(R.string.section_category), content = { Category() })
            HomeSection(stringResource(R.string.section_jobRecomended), content = { JobRow(
//                listJob2 = viewModel.listListan
                JobData.jobRandom
            ) })

        }
    }
}




@Composable
fun row1(
    modifier: Modifier= Modifier,
    viewModel: JobViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository())),
) {
    val query by viewModel.query

    Box {
        Image(
            painter = painterResource(R.drawable.bgsearchbar),
            contentDescription = "searchbar banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(260.dp)
        )

        Column (
            modifier = modifier
        ){
            Row (
//                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier,
                ){
                imagePP()
                Column (
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically),

                ){
                    Text(
                        text = "Hello",
//                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        color = Color.Black,
                        style = typography.headlineMedium,
                    )

                    Text(
                        text = stringResource(R.string.nama),
                        fontWeight = FontWeight.Bold,
                        style = typography.titleLarge,
                        color = Color.Black,


                    )

                }




            }

            SearchBar(
//                query = "",
                query = query,
//                onQueryChange = {}
                onQueryChange = viewModel::search
            )
        }

    }
}

@Composable
fun row2(
    modifier: Modifier = Modifier,
){
    Row (
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ){
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),

            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ) {

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp),
            ){
                Image(imageVector = Icons.Default.Favorite, contentDescription = null)
                Text(text = "My Bookmark",
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .clickable {  }


                )
            }
        }


        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),

            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ) {

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp),
            ){
                Image(imageVector = Icons.Default.CheckCircle, contentDescription = null)
                Text(text = "My Application",
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .clickable {  }


                )
            }
        }
    }

}


@Composable
fun JobRow(

    listJob: List<JobList>,
    modifier: Modifier = Modifier
) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        modifier = modifier.clickable {  }
    ) {
        items(listJob, key = {it.id}) {job ->
            JobListItem(job)
        }

    }
}





@Composable
fun imagePP(){
    Image(
        painter = painterResource(R.drawable.foto),
        contentDescription = "user photo",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    HireXpatTheme {
        HomePage()
    }
}