package com.mahesh.reminder.screens

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.InputChip
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mahesh.reminder.R
import com.mahesh.reminder.ScheduleActivity
import com.mahesh.reminder.SecondScreenActivity

import com.mahesh.reminder.components.AppToolbar
import com.mahesh.reminder.components.NavigationDrawerBody
import com.mahesh.reminder.components.NavigationDrawerHeader

import com.mahesh.reminder.data.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere","inside_NavigationItemClicked")
                    Log.d("ComingHere","${it.itemId} ${it.title}")
                })
        }

    ) {
            paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = Color(R.color.white)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {

                Scroll(Modifier)
//                Greeting2()


            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scroll(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
        modifier = modifier
            .requiredHeight(height = 644.dp)
    ) {
        val context = LocalContext.current

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .requiredWidth(width = 343.dp)
                .requiredHeight(height = 36.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color(0xffe3e3e8))
                .padding(horizontal = 6.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.icnsearch),
                contentDescription = "icnSearch",
                colorFilter = ColorFilter.tint(Color(0xff8e8e92)),
                modifier = Modifier
                    .requiredSize(size = 20.dp))
            Text(
                text = "Search",
                color = Color(0xff8e8e92),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 17.sp))
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            modifier = Modifier
                .requiredWidth(width = 343.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp))
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.Start),
                    modifier = Modifier
                        .requiredWidth(width = 343.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(11.dp, Alignment.Top),
                        modifier = Modifier
                            .weight(weight = 0.5f)
                            .clip(shape = RoundedCornerShape(12.dp))
                            .background(color = Color.White)
                            .padding(top = 10.dp,
                                bottom = 8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    context.startActivity(Intent(context, ScheduleActivity::class.java))
                                }
                                .padding( start = 12.dp, end = 16.dp )
                        ) {
                            Text(
                                text = "05",
                                color = Color.Black,
                                textAlign = TextAlign.End)
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(start = 12.dp, end = 16.dp)
                        ) {
                            Text(
                                text = "Today",
                                color = Color(0xff8e8e92),
                                style = TextStyle(
                                    fontSize = 17.sp))
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(11.dp, Alignment.Top),
                        modifier = Modifier
                            .weight(weight = 0.5f)
                            .clip(shape = RoundedCornerShape(12.dp))
                            .background(color = Color.White)
                            .padding(top = 10.dp, bottom = 8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 12.dp, end = 16.dp)
                        ) {
                            Text(
                                text = "10",
                                color = Color.Black,
                                textAlign = TextAlign.End)
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(start = 12.dp, end = 16.dp)
                        ) {
                            Text(
                                text = "Scheduled",
                                color = Color(0xff8e8e92),
                                style = TextStyle(
                                    fontSize = 17.sp))
                        }
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(11.dp, Alignment.Top),
                    modifier = Modifier
                        .requiredWidth(width = 343.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(color = Color.White)
                        .padding(top = 10.dp, bottom = 8.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "15",
                            color = Color.Black,
                            textAlign = TextAlign.End)
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(start = 12.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "All",
                            color = Color(0xff8e8e92),
                            style = TextStyle(fontSize = 17.sp))
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                modifier = Modifier
                    .requiredHeight(height = 90.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                    modifier = Modifier
                        .padding(start = 12.dp)
                ) {
                    Text(
                        text = "My Lists",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .requiredWidth(width = 84.dp))

                    Spacer(modifier = Modifier.height(10.dp))

                    var context = LocalContext.current
                    Text(
                        text = "Add New Reminder",
                        color = Color.Red,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .clickable {
                                context.startActivity(Intent(context, ScheduleActivity::class.java))
                            }
                    )
                }
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 343.dp)
                        .requiredHeight(height = 54.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .requiredWidth(width = 343.dp)
                            .requiredHeight(height = 54.dp)
                            .clip(shape = RoundedCornerShape(12.dp))
                            .background(color = Color.White)
                            .padding(start = 12.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.Top)
                            ) {
                                Text(
                                    text = "Reminders",
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 17.sp))
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(end = 12.dp)
                        ) {
                            Text(
                                text = "1",
                                color = Color(0xff8e8e92),
                                textAlign = TextAlign.Center,
                                style = TextStyle(fontSize = 17.sp))
                            Image(
                                painter = painterResource(id = R.drawable.icnarrowright),
                                contentDescription = "icnArrowRight",
                                modifier = Modifier
                                    .requiredWidth(width = 18.dp)
                                    .requiredHeight(height = 24.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 660.dp)
            .background(color = Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 53.dp,
                    y = 22.dp
                )
                .requiredWidth(width = 253.dp)
                .requiredHeight(height = 47.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = Color(0xff9bc0ec)))
        androidx.compose.material3.Text(
            text = "Search here",
            color = Color.Black.copy(alpha = 0.62f),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 18.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 129.dp, y = 35.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Image(
            painter = painterResource(id = R.drawable.box),
            contentDescription = "Vector 15",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 315.dp,
                    y = 89.dp
                )
                .requiredSize(size = 11.dp)
                .clip(shape = RoundedCornerShape(2.dp))
                .border(
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(2.dp)
                ))
        Image(
            painter = painterResource(id = R.drawable.box),
            contentDescription = "Vector 16",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 329.dp,
                    y = 89.dp
                )
                .requiredSize(size = 11.dp)
                .clip(shape = RoundedCornerShape(2.dp))
                .border(
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(2.dp)
                ))
        Image(
            painter = painterResource(id = R.drawable.box),
            contentDescription = "Vector 17",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 315.dp,
                    y = 101.dp
                )
                .requiredSize(size = 11.dp)
                .clip(shape = RoundedCornerShape(2.dp))
                .border(
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(2.dp)
                ))
        Image(
            painter = painterResource(id = R.drawable.box),
            contentDescription = "Vector 14",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 329.dp,
                    y = 101.dp
                )
                .requiredSize(size = 11.dp)
                .clip(shape = RoundedCornerShape(2.dp))
                .border(
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(2.dp)
                ))
        Image(
            painter = painterResource(id = R.drawable.box),
            contentDescription = "Vector 7",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = (-10).dp,
                    y = 619.dp
                )
                .requiredWidth(width = 381.dp)
                .border(border = BorderStroke(1.dp, Color.White)))
        Image(
            painter = painterResource(id = R.drawable.box),
            contentDescription = "Vector 18",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 315.dp,
                    y = 89.dp
                )
                .requiredSize(size = 11.dp)
                .clip(shape = RoundedCornerShape(2.dp))
                .border(
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(2.dp)
                ))
        Image(
            painter = painterResource(id = R.drawable.box),
            contentDescription = "Vector 19",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 329.dp,
                    y = 89.dp
                )
                .requiredSize(size = 11.dp)
                .clip(shape = RoundedCornerShape(2.dp))
                .border(
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(2.dp)
                ))
        Image(
            painter = painterResource(id = R.drawable.box),
            contentDescription = "Vector 20",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 315.dp,
                    y = 101.dp
                )
                .requiredSize(size = 11.dp)
                .clip(shape = RoundedCornerShape(2.dp))
                .border(
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(2.dp)
                ))

        androidx.compose.material3.Text(
            text = "My Reminder ",
            color = Color.Black,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 46.dp,
                    y = 89.dp
                )
                .requiredWidth(width = 196.dp)
                .requiredHeight(height = 30.dp)
        )
        val localContext = LocalContext.current
        Image(
            painter = painterResource(id = R.drawable.today_img),
            contentDescription = " 1",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 20.dp,
                    y = 176.dp
                )
                .requiredWidth(width = 100.dp)
                .requiredHeight(height = 100.dp)
                .clip(shape = RoundedCornerShape(20.dp))

                .clickable {
                    localContext.startActivity(
                        Intent(localContext, SecondScreenActivity::class.java)
                    )
                }
        )


        Image(
            painter = painterResource(id = R.drawable.schedule_img),
            contentDescription = " 19",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 210.dp, y = 176.dp)
                .requiredWidth(width = 100.dp)
                .requiredHeight(height = 100.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .clickable {
                    localContext.startActivity(
                        Intent(localContext, SecondScreenActivity::class.java)
                    )
                }

        )
        androidx.compose.material3.Text(
            text = "Today Reminder ( 04 )",
            color = Color.Black,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 20.dp, y = 290.dp)
        )
        androidx.compose.material3.Text(
            text = " Scheduled ",
            color = Color.Black,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 210.dp,
                    y = 290.dp
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
//    Greeting2()
}