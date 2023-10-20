package com.moonlightsplitter.belajarcompose.data.source

import com.moonlightsplitter.belajarcompose.R
import com.moonlightsplitter.belajarcompose.data.model.AffirmationModel

class DataSource {

    fun getAffirmations(): List<AffirmationModel> {
        return listOf(
            AffirmationModel(R.drawable.affirmation1, R.string.affirmation1),
            AffirmationModel(R.drawable.affirmation2, R.string.affirmation2),
            AffirmationModel(R.drawable.affirmation3, R.string.affirmation3),
            AffirmationModel(R.drawable.affirmation4, R.string.affirmation4),
            AffirmationModel(R.drawable.affirmation5, R.string.affirmation5)
        )
    }
}