package com.kyant.backdrop.catalog.destinations

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kyant.backdrop.catalog.CatalogDestination

@Composable
fun HomeContent(onNavigate: (CatalogDestination) -> Unit) {
    val isLightTheme = !isSystemInDarkTheme()
    val contentColor = if (isLightTheme) Color.Black else Color.White

    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .systemBarsPadding()
            .displayCutoutPadding()
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16f.dp)
    ) {
        BasicText(
            "背景目录",
            Modifier.padding(16f.dp, 40f.dp, 16f.dp, 16f.dp),
            style = TextStyle(contentColor, 28f.sp, FontWeight.Medium)
        )

        Column {
            Subtitle("液态玻璃组件")
            ListItem({ onNavigate(CatalogDestination.Buttons) }, "按钮")
            ListItem({ onNavigate(CatalogDestination.Toggle) }, "开关")
            ListItem({ onNavigate(CatalogDestination.Slider) }, "滑块")
            ListItem({ onNavigate(CatalogDestination.BottomTabs) }, "底部标签")
            ListItem({ onNavigate(CatalogDestination.Dialog) }, "对话框")

            Subtitle("系统界面")
            ListItem({ onNavigate(CatalogDestination.LockScreen) }, "锁屏 (SDF 纹理)")
            ListItem({ onNavigate(CatalogDestination.ControlCenter) }, "控制中心")
            ListItem({ onNavigate(CatalogDestination.Magnifier) }, "放大镜")

            Subtitle("实验")
            ListItem({ onNavigate(CatalogDestination.GlassPlayground) }, "玻璃游乐场")
            ListItem({ onNavigate(CatalogDestination.AdaptiveLuminanceGlass) }, "自适应亮度玻璃")
            ListItem({ onNavigate(CatalogDestination.ProgressiveBlur) }, "渐进模糊")
            ListItem({ onNavigate(CatalogDestination.ScrollContainer) }, "滚动容器")
            ListItem({ onNavigate(CatalogDestination.LazyScrollContainer) }, "惰性滚动容器")
        }
    }
}

@Composable
private fun Subtitle(label: String) {
    BasicText(
        label,
        Modifier
            .padding(16f.dp, 24f.dp, 16f.dp, 8f.dp)
            .fillMaxWidth(),
        style = TextStyle(Color(0xFF0088FF), 15f.sp, FontWeight.Medium)
    )
}

@Composable
private fun ListItem(
    onClick: () -> Unit,
    label: String
) {
    val isLightTheme = !isSystemInDarkTheme()
    val contentColor = if (isLightTheme) Color.Black else Color.White

    BasicText(
        label,
        Modifier
            .clickable(onClick = onClick)
            .padding(16f.dp)
            .fillMaxWidth(),
        style = TextStyle(contentColor, 17f.sp)
    )
}
