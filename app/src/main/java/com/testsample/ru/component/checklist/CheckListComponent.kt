package com.testsample.ru.component.checklist

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.testsample.ru.ui.theme.SampleForArcticAppTheme
import com.testsample.ru.R
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign

@ExperimentalFoundationApi
@Composable
fun CheckList(
    titleScreen: String,
    contentList: List<ListModel>,
    navigateTo: () -> Unit
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val (title, list, btn) = createRefs()

        Text(
            titleScreen, style = TextStyle(
                fontFamily = FontFamily(Font(R.font.montserrat_bold)), fontSize = 36.sp
            ), modifier = Modifier
                .wrapContentSize()
                .constrainAs(title) {
                    start.linkTo(parent.start, margin = 24.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                    top.linkTo(parent.top, margin = 24.dp)
                }, textAlign = TextAlign.Center
        )

        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(list) {
                    top.linkTo(title.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                },

            // content padding
//            contentPadding = PaddingValues(
//                start = 12.dp,
//                top = 16.dp,
//                end = 12.dp,
//                bottom = 16.dp
//            ),
            content = {
                items(contentList.size) { index ->
                    CheckListItem(contentList[index])
                }
            }
        )


        Button(
            onClick = {
                navigateTo.invoke()
            },
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.supernova),
                disabledBackgroundColor = colorResource(id = R.color.gray)
            ),
            shape = RoundedCornerShape(36),
            modifier = Modifier
                .constrainAs(btn) {
                    start.linkTo(parent.start, margin = 24.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                }
        ) {
            Text(
                text = stringResource(id = R.string.continue_btn),
                modifier = Modifier.padding(56.dp, 12.dp, 56.dp, 12.dp),
                style = TextStyle(
                    color = colorResource(id = R.color.black),
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    fontSize = 16.sp
                )
            )
        }
    }
}

@Composable
fun CheckListItem(model: ListModel) {

    val isVisible = remember { mutableStateOf(false) }

    ConstraintLayout(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
    ) {

        val (card, desc) = createRefs()

        Card(
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(card) {
                    start.linkTo(parent.start, margin = 0.dp)
                    end.linkTo(parent.end, margin = 0.dp)
                    top.linkTo(parent.top, margin = 8.dp)
                }
                .clickable(onClick = {
                    isVisible.value = !isVisible.value
                }),
            shape = RoundedCornerShape(16.dp),
            elevation = 4.dp,
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .size(80.dp)
                    .background(
                        if (isVisible.value) {
                            colorResource(id = R.color.activeColor)
                        } else {
                            colorResource(id = R.color.white)
                        }
                    )
            ) {

                val (image, check) = createRefs()

                Image(
                    modifier = Modifier
                        .height(45.dp)
                        //.roundedCornerClipModifier(56.dp)
                        .constrainAs(image) {
                            start.linkTo(parent.start, margin = 0.dp)
                            end.linkTo(parent.end, margin = 0.dp)
                            top.linkTo(parent.top, margin = 8.dp)
                            bottom.linkTo(parent.bottom, margin = 8.dp)
                        },
                    //.clip(RoundedCornerShape(56.dp))
                    //.padding(24.dp),
                    painter = painterResource(model.image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                if (isVisible.value) {
                    Image(
                        modifier = Modifier
                            .wrapContentSize()
                            //.roundedCornerClipModifier(56.dp)
                            .constrainAs(check) {
                                start.linkTo(parent.start, margin = 0.dp)
                                end.linkTo(parent.end, margin = 0.dp)
                                top.linkTo(parent.top, margin = 8.dp)
                                bottom.linkTo(parent.bottom, margin = 8.dp)
                            },
                        //.clip(RoundedCornerShape(56.dp))
                        //.padding(24.dp),
                        painter = painterResource(R.drawable.ic_check),
                        contentDescription = "",
                        contentScale = ContentScale.Inside
                    )
                }
            }
        }

        Text(
            text = model.title,
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(desc) {
                    start.linkTo(parent.start, margin = 0.dp)
                    end.linkTo(parent.end, margin = 0.dp)
                    top.linkTo(card.bottom, margin = 8.dp)
                },
            style = TextStyle(
                color = colorResource(id = R.color.black),
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                fontSize = 16.sp
            ), textAlign = TextAlign.Center
        )

//        if (ifLastItem) {
//            Spacer(Modifier.fillMaxWidth().height(68.dp))
//        }
    }
}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.roundedCornerClipModifier(size: Dp): Modifier = composed {
    val shape = RoundedCornerShape(size)
    clip(shape)
}

@ExperimentalFoundationApi
@Preview
@Composable
fun CheckListPreview() {
    SampleForArcticAppTheme {

        CheckList(
            stringResource(id = R.string.title_1),
            listOf(
                ListModel(
                    stringResource(id = R.string.competence),
                    R.drawable.ic_screen_1_1
                ),
                ListModel(
                    stringResource(id = R.string.attitude),
                    R.drawable.ic_screen_1_2
                ),
                ListModel(
                    stringResource(id = R.string.achievement),
                    R.drawable.ic_screen_1_3
                ),
                ListModel(
                    stringResource(id = R.string.creative),
                    R.drawable.ic_screen_1_4
                ),
                ListModel(
                    stringResource(id = R.string.physiological),
                    R.drawable.ic_screen_1_5
                ),
                ListModel(
                    stringResource(id = R.string.social),
                    R.drawable.ic_screen_1_6
                ),
                ListModel(
                    stringResource(id = R.string.fear),
                    R.drawable.ic_screen_1_7
                ),
                ListModel(
                    stringResource(id = R.string.power),
                    R.drawable.ic_screen_1_8
                ),
                ListModel(
                    stringResource(id = R.string.success),
                    R.drawable.ic_screen_1_9
                )
            ), {

            }
        )
    }
}
