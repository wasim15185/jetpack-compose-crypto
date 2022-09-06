package co.nimblehq.compose.crypto.ui.screens.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import co.nimblehq.compose.crypto.R
import co.nimblehq.compose.crypto.extension.toFormattedString
import co.nimblehq.compose.crypto.ui.theme.*
import co.nimblehq.compose.crypto.ui.theme.Dimension.Dp13
import kotlin.math.abs

@Suppress("FunctionNaming", "LongMethod")
@Composable
fun PriceChange(
    priceChangePercentage24hInCurrency: Double,
    modifier: Modifier,
    iconPaddingEnd: Dp
) {
    val isPositiveNumber = priceChangePercentage24hInCurrency >= 0

    Row(modifier = modifier) {
        Icon(
            modifier = Modifier
                .padding(end = iconPaddingEnd)
                .align(alignment = Alignment.CenterVertically),
            painter = if (isPositiveNumber) {
                painterResource(id = R.drawable.ic_guppie_green_arrow_up)
            } else {
                painterResource(id = R.drawable.ic_fire_opal_arrow_down)
            },
            tint = if (isPositiveNumber) {
                Color.GuppieGreen
            } else {
                Color.FireOpal
            },
            contentDescription = null
        )

        Text(
            text = stringResource(
                R.string.coin_profit_percent,
                abs(priceChangePercentage24hInCurrency).toFormattedString()
            ),
            style = if (isPositiveNumber) {
                Style.guppieGreenMedium16()
            } else {
                Style.fireOpalGreenMedium16()
            }
        )
    }
}

@Suppress("FunctionNaming")
@Composable
@Preview
fun PriceChangePreview() {
    ComposeTheme {
        PriceChange(
            priceChangePercentage24hInCurrency = coinItemPreview.priceChangePercentage24hInCurrency,
            modifier = Modifier,
            iconPaddingEnd = Dp13
        )
    }
}
