package com.moonlightsplitter.belajarcompose.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AffirmationModel(
    @DrawableRes val image: Int,
    @StringRes val title: Int
)
