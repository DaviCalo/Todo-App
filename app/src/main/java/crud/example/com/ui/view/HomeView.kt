package crud.example.com.ui.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import crud.example.com.ui.components.TabBar
import crud.example.com.ui.theme.CRUDTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController){
    var selectedItem by remember { mutableIntStateOf(0) }
    CRUDTheme {
        Scaffold(
            topBar = { },
            bottomBar = { TabBar(navController = navController, screen = 0) }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                val options = listOf("1","2","3")
                Text(text = "sa", modifier = Modifier.padding(innerPadding), color = MaterialTheme.colorScheme.primary)
                SingleChoiceSegmentedButtonRow {
                    options.forEachIndexed { index, option ->
                        SegmentedButton(
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                        ){
                            Text(text = option)
                        }
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Default Preview Dark"
)
@Composable
fun PreviewHome(){
    val navController = rememberNavController()
    HomeView(navController)
}