package com.example.blogmultiplatform.pages.fiddling

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.blogmultiplatform.navigation.Screen
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.outline
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.fa.FaFaceAngry
import com.varabyte.kobweb.silk.components.icons.fa.FaFaceSmile
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.icons.fa.IconStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.focus
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode

import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

// Based on : https://www.youtube.com/watch?v=F5B-CxJTKlg
// Export the whole js-part as a complete web deployment type in subfolder 'site':
// kobweb export --layout static  (in video at around : 36:35)
// This export can be found at ./site/.kobweb/site

@Page
@Composable
fun FiddlingPage(){
    val context = rememberPageContext()
    var name by remember { mutableStateOf("") }
    var colorMode by ColorMode.currentState
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            if(colorMode.isLight){
                FaFaceSmile(
                    modifier = Modifier
                        .color(if(colorMode.isLight)Colors.Blue else Theme.Blue.color)
                        .margin(right = 10.px),
                    style = IconStyle.OUTLINE,
                    size = IconSize.XXL
                )
            } else {
                FaFaceAngry(
                    modifier = Modifier
                        .color(if(colorMode.isLight)Colors.Blue else Theme.Blue.color)
                        .margin(right = 10.px),
                    style = IconStyle.OUTLINE,
                    size = IconSize.XXL
                )
            }
            P(
            attrs = Modifier
                .fontSize(40.px)
                .toAttrs()
            ){
              Text(value = if(colorMode.isLight)"Hello, $name" else "Piss off, $name")
            }
        }
        Input(
            type = InputType.Text,
            attrs = InputStyle.toModifier()
                .padding(topBottom = 10.px, leftRight = 10.px)
                .outline(
                    width = 0.px,
                    style = LineStyle.None,
                    color = Colors.Transparent
                )
                .fontSize(20.px)
                .backgroundColor(Theme.Gray.color)
                .transition(CSSTransition(property = "border", duration = 500.ms))
                .toAttrs {
                    placeholder(value = "Enter your name")
                    onInput { name = it.value }
                }
        )
        Button(
            modifier = Modifier.margin(top = 24.px),
            onClick = {
                colorMode = colorMode.opposite
            }
        ){
            Text(value = "Change Theme")
        }
        Button(
            modifier = Modifier.margin(top = 24.px),
            onClick = {
                context.router.navigateTo(Screen.HomePage.route)
            }
        ){
            Text(value = "Home")
        }
    }
}

val InputStyle by ComponentStyle {
    base {
        Modifier.border(
            width = 2.px,
            style = LineStyle.Solid,
            color = Theme.Gray.color
        )
    }
    focus {
        Modifier.border(
            width = 2.px,
            style = LineStyle.Solid,
            color = Theme.Blue.color
        )
    }
}
enum class Theme(val color: CSSColorValue){
    Gray(color = rgb(r = 238, g = 238, b = 238)),
    Blue(color = rgb(r = 28, g = 238, b = 238))
}