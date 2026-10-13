package com.priyabajaria.cs501.campuseventexplorer.data

/**
 * The application's single source of event data. Screens never receive a
 * CampusEvent through navigation; they look one up here by ID instead.
 */
object EventRepository {

    val events: List<CampusEvent> = listOf(
        CampusEvent(
            id = 101L,
            title = "Mobile Development Meetup",
            category = "Tech",
            location = "CAS 214",
            time = "Tue, Oct 20 · 6:30 PM",
            description = "Bring a laptop and a half-finished app. Students demo what they're " +
                    "building in Jetpack Compose, trade navigation and state-management tips, and " +
                    "pair up to debug. Pizza provided; all experience levels welcome."
        ),
        CampusEvent(
            id = 102L,
            title = "Fall Career Fair",
            category = "Career",
            location = "GSU Metcalf Ballroom",
            time = "Wed, Oct 21 · 11:00 AM",
            description = "Over 120 employers recruiting for internships and full-time roles " +
                    "across engineering, finance, healthcare and the arts. Bring printed resumes " +
                    "and dress business casual. Career Services will run on-site resume reviews."
        ),
        CampusEvent(
            id = 103L,
            title = "Jazz Night on the Esplanade",
            category = "Music",
            location = "Hatch Shell Lawn",
            time = "Thu, Oct 22 · 7:00 PM",
            description = "The student jazz ensemble plays standards and original arrangements " +
                    "by the river. Bring a blanket; hot cider is free while it lasts. Moves to the " +
                    "Tsai Performance Center in case of rain."
        ),
        CampusEvent(
            id = 104L,
            title = "Intro to Machine Learning Workshop",
            category = "Tech",
            location = "CDS 1646",
            time = "Fri, Oct 23 · 2:00 PM",
            description = "A hands-on two-hour session covering regression, classification and " +
                    "model evaluation in Python. Notebooks are provided, so you only need a laptop " +
                    "and a Google account. No prior ML background required."
        ),
        CampusEvent(
            id = 105L,
            title = "Terriers vs. Huskies Hockey",
            category = "Sports",
            location = "Agganis Arena",
            time = "Sat, Oct 24 · 7:00 PM",
            description = "Cheer on the Terriers in the season's first rivalry game. Students " +
                    "get in free with a valid ID; doors open one hour before puck drop. Wear red " +
                    "for the student-section photo."
        ),
        CampusEvent(
            id = 106L,
            title = "Mindful Mornings Yoga",
            category = "Wellness",
            location = "FitRec Studio 2",
            time = "Mon, Oct 26 · 8:00 AM",
            description = "A gentle 45-minute flow to start the week, led by a certified " +
                    "instructor. Mats are available to borrow. Suitable for complete beginners and " +
                    "anyone who wants a calm reset before class."
        ),
        CampusEvent(
            id = 107L,
            title = "Global Food Festival",
            category = "Culture",
            location = "Marsh Plaza",
            time = "Tue, Oct 27 · 12:00 PM",
            description = "Student cultural organizations serve dishes from more than 30 " +
                    "countries, with live music and dance performances throughout the afternoon. " +
                    "Tasting tickets are $1 each, and proceeds go to student scholarships."
        ),
        CampusEvent(
            id = 108L,
            title = "Resume Review Drop-In",
            category = "Career",
            location = "Career Development Office, 100 Bay State Rd",
            time = "Wed, Oct 28 · 3:00 PM",
            description = "Get one-on-one feedback on your resume or cover letter from a career " +
                    "advisor. Sessions are 15 minutes, first come, first served. Bring a printed " +
                    "copy or have the file ready on your phone."
        ),
        CampusEvent(
            id = 109L,
            title = "Open Mic Poetry Night",
            category = "Arts",
            location = "Howard Thurman Center",
            time = "Thu, Oct 29 · 8:00 PM",
            description = "Read your own work or just come to listen. Sign-up sheet opens at " +
                    "7:45 PM with five-minute slots. A relaxed, supportive crowd, with coffee and " +
                    "snacks on the house."
        ),
        CampusEvent(
            id = 110L,
            title = "Hackathon Kickoff",
            category = "Tech",
            location = "Photonics Center Atrium",
            time = "Fri, Oct 30 · 6:00 PM",
            description = "Form teams, hear sponsor challenges and start a 36-hour build " +
                    "sprint. Mentors are on hand all weekend, and prizes go to the best mobile, web " +
                    "and social-impact projects. Registration is required."
        )
    )

    /** Returns the event with [id], or null when no such event exists. */
    fun findById(id: Long): CampusEvent? = events.firstOrNull { it.id == id }

    /**
     * Pure filter: derived from the query every time, never stored as its own
     * mutable list. Matches title or category, case-insensitively.
     */
    fun filter(query: String): List<CampusEvent> {
        val q = query.trim()
        if (q.isEmpty()) return events
        return events.filter {
            it.title.contains(q, ignoreCase = true) ||
                    it.category.contains(q, ignoreCase = true)
        }
    }
}