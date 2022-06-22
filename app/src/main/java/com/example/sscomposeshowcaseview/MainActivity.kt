package com.example.sscomposeshowcaseview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowcaseExample()
        }
    }
}

@Composable
private fun ShowcaseExample() {
    val targets = remember { mutableStateMapOf<String, ShowcaseProperty>() }
    val context = LocalContext.current

    Scaffold(topBar = { TopAppBar(target = targets) }) {
        Column(modifier = Modifier.padding(it)) {
            Posts(target = targets)
        }
    }

    ShowCaseTarget(targets = targets) {
        Toast.makeText(context, "Thank you! Intro Completed", Toast.LENGTH_SHORT)
            .show()
    }
}

@Composable
private fun TopAppBar(target: SnapshotStateMap<String, ShowcaseProperty>) {
    TopAppBar(title = { Text(text = "SSShowcaseView") },
        navigationIcon = {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
        }
    )
}

@Composable
private fun Posts(target: SnapshotStateMap<String, ShowcaseProperty>) {
    LazyColumn {
        items(items = Data.userList) { item ->
            PostItem(post = item, target = target)
        }
    }
}

@Composable
fun PostItem(post: Item, target: SnapshotStateMap<String, ShowcaseProperty>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        UserProfile(post = post, target = target)
        Divider(Modifier.fillMaxWidth(), thickness = 1.dp)
        UserPost(post = post, target = target)
    }
}

@Composable
fun UserProfile(post: Item, target: SnapshotStateMap<String, ShowcaseProperty>) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.onGloballyPositioned {
            target["profile"] = ShowcaseProperty(
                index = 6,
                coordinates = it,
                title = "Profile",
                subTitle = "User Profile with name and picture",
                showCaseType = ShowcaseType.ANIMATED_RECTANGLE
            )
        }) {
        Image(
            painter = painterResource(id = post.profilePic),
            contentDescription = "User profile pic",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .size(30.dp)
        )
        Text(text = post.name, modifier = Modifier.weight(1f))
        Image(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More icon",
            modifier = Modifier
                .padding(10.dp)
                .onGloballyPositioned {
                    target["more"] = ShowcaseProperty(
                        index = 1,
                        coordinates = it,
                        title = "More options",
                        subTitle = "Click here to see options",
                        showCaseType = ShowcaseType.ANIMATED_RECTANGLE
                    )
                }
        )
    }
}

@Composable
fun UserPost(post: Item, target: SnapshotStateMap<String, ShowcaseProperty>) {
    val isLikeClicked = remember { mutableStateOf(true) }
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = post.profilePic),
            contentDescription = "User post",
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, bottom = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { isLikeClicked.value = !isLikeClicked.value }) {
                    Icon(
                        imageVector = if (isLikeClicked.value) Icons.Default.FavoriteBorder else Icons.Filled.Favorite,
                        contentDescription = "Fav",
                        modifier = Modifier
                            .size(30.dp)
                            .onGloballyPositioned {
                                target["like"] = ShowcaseProperty(
                                    index = 2,
                                    coordinates = it,
                                    title = "LIke Post",
                                    subTitle = "Click here to like post",
                                    showCaseType = ShowcaseType.ANIMATED_RECTANGLE
                                )
                            }
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "add",
                        modifier = Modifier
                            .size(28.dp)
                            .onGloballyPositioned {
                                target["comment"] = ShowcaseProperty(
                                    index = 3,
                                    coordinates = it,
                                    title = "Comment button",
                                    subTitle = "Click here to add comment on post",
                                    showCaseType = ShowcaseType.ANIMATED_RECTANGLE
                                )
                            }
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Share",
                        modifier = Modifier
                            .size(23.dp)
                            .onGloballyPositioned {
                                target["share"] = ShowcaseProperty(
                                    index = 4,
                                    coordinates = it,
                                    title = "Share button",
                                    subTitle = "Click here to Share post with others",
                                    showCaseType = ShowcaseType.ANIMATED_RECTANGLE
                                )
                            }
                    )
                }
            }
            IconButton(modifier = Modifier
                .align(Alignment.CenterEnd),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "Save",
                    modifier = Modifier
                        .size(25.dp)
                        .onGloballyPositioned {
                            target["save"] = ShowcaseProperty(
                                index = 5,
                                coordinates = it,
                                title = "Save button",
                                subTitle = "Click here to save post",
                                showCaseType = ShowcaseType.ANIMATED_RECTANGLE
                            )
                        }
                )
            }
        }
    }
}

@Preview
@Composable
fun MainActivityPreview() {
    Surface {
        ShowcaseExample()
    }
}