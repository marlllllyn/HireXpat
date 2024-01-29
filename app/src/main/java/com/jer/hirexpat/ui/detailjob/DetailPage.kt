package com.jer.hirexpat.ui.detailjob

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.jer.hirexpat.R
import com.jer.hirexpat.ViewModelFactory
import com.jer.hirexpat.di.Injection
import com.jer.hirexpat.model.JobList
import com.jer.hirexpat.response.JobResponse
import com.jer.hirexpat.ui.common.UiState

import com.jer.hirexpat.ui.livingCostVisa.LivingCostPage
import com.jer.hirexpat.ui.theme.HireXpatTheme

@Composable
fun DetailPage(
    jobId: Long,
    modifier: Modifier = Modifier.background(colorResource(R.color.cream)),
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateBack: () -> Unit
) {
    val navController = rememberNavController()
    val list: JobList = JobList(
        id = 1,
        jobTitle = "Job Title",
        company = "Company Name",
        photoJob = "https://1.bp.blogspot.com/-XZ6MbjHG1Hg/X7et-BwPofI/AAAAAAAAG1c/pG9jLcYdDu0GjPyaVp4BXPcNbREMvoWNACLcBGAsYHQ/s800/Salinan%2Bdari%2BTanpa%2Bjudul.png"
    )

    Box (modifier = Modifier.fillMaxSize()){



        viewModel.uiState2.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getRewardById2(
//                        jobId
                    )

                }
                is UiState.Success -> {
                    val data = uiState.data




                    DetailContent(
                        list.photoJob ,
                        data.position_available ?: "Personal Financial Advisor",
                        data.name ?: "Harapan Baru",
                        data.description ?: "Your trusted partner in financial services.",
                        onBackClick = navigateBack,
                        jobId = jobId
                    )

                    // ini untuk yang data dummy
//                    DetailContent(
//                        data.photoJob,
//                        data.jobTitle,
//                        data.company,
//                        data.descJob,
//                        onBackClick = navigateBack,
//                        jobId = jobId
//                    )



                }
                is UiState.Error -> {}
                else -> {}
            }
        }

        NavHost(navController = navController, startDestination = "detailPage") {

            composable(route = "detailPage") {
//                DetailPage(jobId) {}

            }
            composable(route = "LV") {
                LivingCostPage(modifier = Modifier.background(colorResource(R.color.cream)))
            }
        }

        Button(
            onClick = { navController.navigate("LV")},
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "L & V")

        }


    }





}




@Composable
fun DetailContent(
    photoUrl: String,
    title: String,
    company: String,
    desc: String,
    jobId: Long,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {



    Column(modifier = Modifier) {

        
        Box {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back),
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onBackClick() }
//                    .clickable { onBackClick() }
            )


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .verticalScroll(rememberScrollState()) ,
            ) {
                AsyncImage(
                    model = photoUrl,
                    contentDescription = null,
//                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(260.dp)
                        .clip(CircleShape),
                    alignment = Alignment.Center
                )


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.ExtraBold
                        ),
                    )
                    Text(
                        text = company,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.ExtraBold
                        ),
                    )
                    Text(
                        text = desc,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify,
                    )
                }
                Button(
                    onClick = {},
                    enabled = true,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = stringResource(R.string.apply), modifier = Modifier.padding(2.dp))
                }


            }


        }


    }



}

@Preview(showBackground = true)
@Composable
fun DetailPreview(){
    HireXpatTheme {
//        DetailContent("","","","",{})
    }
}
