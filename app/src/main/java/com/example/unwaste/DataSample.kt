package com.example.unwaste

data class DataSample(
    val latitude: Double,
    val longitude: Double,
    val title: String
    )

val placeMarkers= listOf(
    // Iowa City Food Donation
    DataSample(41.6641, -91.5383, "University Of Iowa Food Pantry"),
    DataSample(41.6482, -91.5303, "CommUnity Crisis Services"),
    DataSample(41.6408, -91.5299, "Shelter House Iowa City - Food Distribution Center"),

    // Coralville Food Donation
    DataSample(41.6823, -91.5819, "Coralville Community Food"),
    DataSample(41.6697, -91.5680, "Coralville Ecumenical Food Pantry - Food Distribution Center"),

    // Compost sites
    DataSample(41.6361, -91.4836, "East Side Recycling Center"),
    DataSample(41.6496, -91.6274, "Iowa City Landfill and Recycling Center")
)
