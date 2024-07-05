package crud.example.com.ui.components

import android.content.res.Configuration
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.crud.R
import crud.example.com.ui.navigation.createScreenRoute
import crud.example.com.ui.navigation.deleteScreenRoute
import crud.example.com.ui.navigation.editScreenRoute
import crud.example.com.ui.navigation.homeScreenRoute
import crud.example.com.ui.theme.CRUDTheme

@Composable
fun TabBar(navController: NavController?, screen: Int){
    var selectedItem by remember { mutableIntStateOf(screen) }
    val items = listOf("Home", "Criar","Alterar", "Deletar")
    val itemsIcon = listOf(R.drawable.icon_home, R.drawable.icon_pen, R.drawable.iconicon_email, R.drawable.icon_person)
    val navigates = listOf(homeScreenRoute, createScreenRoute, editScreenRoute, deleteScreenRoute)
    CRUDTheme {
        NavigationBar(
            containerColor = Color.Transparent,
        ){
            items.forEachIndexed { index, item ->

                NavigationBarItem(
                    icon = { Icon(painter = painterResource(itemsIcon[index]), contentDescription = item) },
                    label = {
                        if (selectedItem == index){
                            Text(item, style = MaterialTheme.typography.bodyMedium)
                        }else  Text(item, style = MaterialTheme.typography.labelLarge)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor=  MaterialTheme.colorScheme.onPrimary,
                        indicatorColor = MaterialTheme.colorScheme.secondary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                        unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                    ),
                    selected = selectedItem == index,
                    onClick = {
                        if (selectedItem != index){
                            navController?.popBackStack(navigates[index], inclusive = false)
                        }
                        selectedItem = index
                    }
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 5,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Default Preview Dark"
)
@Composable
fun PreviewTabBar(){
    val navController = rememberNavController()
    TabBar(navController, 0)
}