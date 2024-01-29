package com.jer.hirexpat.ui.joblist

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.jer.hirexpat.R
import com.jer.hirexpat.ViewModelFactory
import com.jer.hirexpat.di.Injection

import com.jer.hirexpat.model.JobList

import com.jer.hirexpat.response.JobResponse

import com.jer.hirexpat.ui.theme.HireXpatTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun JobListPage(
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
//    viewModel: JobViewModel,
    viewModel: JobViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())),
    )  {

    LaunchedEffect(Unit, block = {
        viewModel.getGameList()
    })


//    val jobListViewModel = viewModel(modelClass = JobListViewModel::class.java)
//    val jobs by jobListViewModel.jobs.collectAsState()

    val list2: JobList = JobList(
        id = 1,
        jobTitle = "",
        company = "",
        photoJob = "https://1.bp.blogspot.com/-XZ6MbjHG1Hg/X7et-BwPofI/AAAAAAAAG1c/pG9jLcYdDu0GjPyaVp4BXPcNbREMvoWNACLcBGAsYHQ/s800/Salinan%2Bdari%2BTanpa%2Bjudul.png"
    )

    val sortedJob by viewModel.sortedJob.collectAsState()
    val query by viewModel.query
    Box (modifier = modifier){

        val listState = rememberLazyListState()


        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 80.dp),
            modifier = modifier,

            )
        {


            item {
                SearchBar(
//                    query = "",
                    query = query,
//                    onQueryChange = {},
                    onQueryChange = viewModel::search,
                    modifier = Modifier.background(colorResource(R.color.orange)),

                    )
            }

            // Ini untuk data dummy
//            sortedJob.forEach { (initial, job) ->
//
//
//                items(job, key = {it.id}) {
//                    JobListItem(
//                        list = it,
////                        title = it.jobTitle,
////                        company = it.company,
////                        photoUrl = it.photoJob,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .animateItemPlacement(tween(durationMillis = 100))
//                            .clickable {
//                                navigateToDetail(it.id)
//                            }
//
//
//                    )
//                }
//            }



            items(viewModel.listListan) { game ->

                JobListItem2(
//                    list = game,
                    title = game.position_available,
                    company = game.name,
                    list2.photoJob,
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateItemPlacement(tween(durationMillis = 100))
                        .clickable {
                            navigateToDetail(game.ID_company)
                        })

            }



        }
        

    }
}




@Composable
fun JobListItem(

    list: JobList,

    modifier: Modifier = Modifier
) {



    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .width(400.dp)
            .background(colorResource(R.color.cream)),



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
//            AsyncImage
            AsyncImage(
                model = list.photoJob,


                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(60.dp)
                    .clip(RectangleShape)
            )

            Text(
//                text = title,
                text = list.jobTitle,

                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 16.dp)
            )
            Text(

                text = list.company,
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

@Preview(showBackground = true)
@Composable
fun Previewwkwkw(){


    HireXpatTheme {

//        JobListItem(title = "wkwkwk", company = "pppppppppp", photoUrl = "")
        JobListPage(

            navigateToDetail = {},
        )
    }
}