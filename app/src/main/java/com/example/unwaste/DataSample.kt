package com.example.unwaste

// Some food donation places and composting sites around Iowa City and Coralville
data class DataSample(
    val latitude: Double,
    val longitude: Double,
    val title: String,
    val contact: String,
    val hours: String
    )

// TODO: Dummy values for contact and hours for now
val placeMarkers = listOf(
    // Iowa City Food Donation
    DataSample(41.6641, -91.5383, "University Of Iowa Food Pantry", "Contact: (555) 123-4567", "Hours: 9 AM - 5 PM"),
    DataSample(41.6482, -91.5303, "CommUnity Crisis Services", "Contact: (555) 987-6543", "Hours: 24/7"),
    DataSample(41.6408, -91.5299, "Shelter House Iowa City - Food Distribution Center", "Contact: (555) 789-0123", "Hours: 8 AM - 6 PM"),

    // Coralville Food Donation
    DataSample(41.6823, -91.5819, "Coralville Community Food", "Contact: (555) 321-6549", "Hours: 10 AM - 4 PM"),
    DataSample(41.6697, -91.5680, "Coralville Ecumenical Food Pantry - Food Distribution Center", "Contact: (555) 234-5678", "Hours: 9 AM - 5 PM"),

    // Compost sites
    DataSample(41.6361, -91.4836, "East Side Recycling Center", "Contact: (555) 876-5432", "Hours: 8 AM - 5 PM"),
    DataSample(41.6496, -91.6274, "Iowa City Landfill and Recycling Center", "Contact: (555) 789-1234", "Hours: 7 AM - 4:30 PM")
)

