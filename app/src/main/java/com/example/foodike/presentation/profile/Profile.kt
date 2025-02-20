package com.example.foodike.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.foodike.R
import com.example.foodike.presentation.profile.components.ProfileCard
import com.example.foodike.presentation.util.Screen

@Composable
fun Profile(
    viewModel: ProfileViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = stringResource(R.string.back))
            }
        }
        Row(
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
            ) {
                Text(
                    text = "Josue Palma",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "holaxd@gmail.com ",
                    modifier = Modifier.alpha(0.5f),
                )

            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = stringResource(R.string.display_picture)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.edit),
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.clickable {

                        },
                        fontWeight = FontWeight.Bold
                    )
                }


            }


        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            color = Color.Black
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            ProfileCard(
                title = stringResource(R.string.saved_addresses),
                subtext = stringResource(R.string.add_edit_and_delete_saved_addresses),
                onClick = {

                }
            )
            ProfileCard(
                title = stringResource(R.string.payments_and_refunds),
                subtext = stringResource(R.string.information_about_refunds_and_payments),
                onClick = {
                }
            )
            ProfileCard(
                title = stringResource(R.string.online_ordering_help),
                subtext = stringResource(R.string.information_about_ordering_food),
                onClick = {
                }
            )
            ProfileCard(
                title = stringResource(R.string.about),
                subtext = stringResource(R.string.about_the_app),
                onClick = {
                },
                dividerVisibility = false
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                modifier = Modifier.width(200.dp),
                onClick = {
                    viewModel.onEvent(ProfileEvent.PerformLogout {
                        navController.navigate(Screen.Onboarding.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                        }
                    })
                }
            ) {
                Text(
                    text = stringResource(R.string.log_out),
                    fontSize = 16.sp,
                )
            }
        }
    }
}

