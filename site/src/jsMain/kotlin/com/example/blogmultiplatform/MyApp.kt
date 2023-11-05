package com.example.blogmultiplatform

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.components.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.MutableSilkTheme
import com.varabyte.kobweb.silk.theme.colors.LegacyMutableSilkPalette
import com.varabyte.kobweb.silk.theme.colors.LegacyMutableSilkPalettes
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.button
import com.varabyte.kobweb.silk.theme.colors.palette.color

import org.jetbrains.compose.web.css.*

@InitSilk
fun updateTheme(ctx: InitSilkContext) {
    /*
    val p = ctx.theme.palettes
    p.light.background = Colors.LightSalmon
    p.light.color = Colors.Crimson
    p.light.button.set(
        default = Colors.DarkGray,
        hover = Colors.Yellow,
        focus = Colors.Yellow,
        pressed = Colors.Gray
    )
    p.dark.background = Colors.DarkBlue
    p.dark.color = Colors.PeachPuff
    // There are more you can set.
     */
}

@App
@Composable
fun MyApp(content: @Composable () -> Unit) {
    SilkApp {
        Surface(SmoothColorStyle.toModifier().minHeight(100.vh)) {
            content()
        }
    }
}
