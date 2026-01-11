package com.paarth.campusconnect.repository

import com.paarth.campusconnect.model.*
import kotlinx.datetime.LocalDate

@Suppress("unused")
class CampusRepository {

    /* Timetable */

    fun getWeeklyTimetable(): List<ClassSession> {
        return listOf(

            /* Montag */

            ClassSession("TCS-611", "Software Engineering", WeekDay.MONDAY, "08:00", "08:55", "LT-8", SessionType.LECTURE),
            ClassSession("TCS-693", "Full Stack Web Development", WeekDay.MONDAY, "09:00", "09:55", "LT-8", SessionType.LECTURE),
            ClassSession("TCS-614", "Computer Networks-II", WeekDay.MONDAY, "09:55", "10:50", "LT-8", SessionType.LECTURE),
            ClassSession("XCS-601", "Soft Skills", WeekDay.MONDAY, "11:10", "12:05", "LT-8", SessionType.LECTURE),

            ClassSession("", "Lunch Break", WeekDay.MONDAY, "12:05", "13:00", "", SessionType.LUNCH),

            ClassSession("PCS-601", "Compiler Design Lab", WeekDay.MONDAY, "13:00", "14:50", "Lab-1", SessionType.LAB),
            ClassSession("", "Placement Preparation", WeekDay.MONDAY, "15:10", "17:55", "", SessionType.PLACEMENT),

            /* tuesday */

            ClassSession("TCS-611", "Software Engineering", WeekDay.TUESDAY, "08:00", "08:55", "Online", SessionType.LECTURE),
            ClassSession("TCS-614", "Computer Networks-II", WeekDay.TUESDAY, "09:00", "09:55", "LT-8", SessionType.LECTURE),
            ClassSession("TCS-693", "Full Stack Web Development", WeekDay.TUESDAY, "09:55", "10:50", "LT-8", SessionType.LECTURE),
            ClassSession("TCS-601", "Compiler Design", WeekDay.TUESDAY, "11:10", "12:05", "LT-8", SessionType.LECTURE),

            ClassSession("", "Lunch Break", WeekDay.TUESDAY, "12:05", "13:00", "", SessionType.LUNCH),

            ClassSession("PCS-601", "Compiler Design Lab", WeekDay.TUESDAY, "13:00", "14:50", "Lab-1", SessionType.LAB),
            ClassSession("", "Placement Preparation", WeekDay.TUESDAY, "15:10", "17:55", "", SessionType.PLACEMENT),

            /* mittwoch */

            ClassSession("PCS-611", "Software Engineering Lab", WeekDay.WEDNESDAY, "08:00", "10:50", "Lab-1", SessionType.LAB),
            ClassSession("TCS-614", "Computer Networks-II", WeekDay.WEDNESDAY, "11:10", "12:05", "LT-8", SessionType.LECTURE),
            ClassSession("TCS-601", "Compiler Design", WeekDay.WEDNESDAY, "12:05", "13:00", "LT-8", SessionType.LECTURE),

            ClassSession("", "Lunch Break", WeekDay.WEDNESDAY, "13:00", "13:55", "", SessionType.LUNCH),

            ClassSession("TCS-693", "Full Stack Web Development", WeekDay.WEDNESDAY, "13:55", "14:50", "LT-8", SessionType.LECTURE),
            ClassSession("TCS-661", "Computer Graphics", WeekDay.WEDNESDAY, "15:10", "16:05", "Online", SessionType.LECTURE),

            ClassSession("", "Placement Preparation", WeekDay.WEDNESDAY, "16:05", "17:55", "", SessionType.PLACEMENT),

            /* dienstag */

            ClassSession("XCS-601", "Career Skills (QAR)", WeekDay.THURSDAY, "08:00", "08:55", "LT-8", SessionType.LECTURE),
            ClassSession("TCS-601", "Compiler Design", WeekDay.THURSDAY, "09:00", "09:55", "LT-8", SessionType.LECTURE),

            ClassSession("PCS-611", "Software Engineering Lab", WeekDay.THURSDAY, "11:10", "12:05", "Lab-1", SessionType.LAB),

            ClassSession("", "Lunch Break", WeekDay.THURSDAY, "12:05", "13:00", "", SessionType.LUNCH),

            ClassSession("PCS-693", "Full Stack Web Development Lab", WeekDay.THURSDAY, "13:00", "14:50", "Lab-1", SessionType.LAB),

            ClassSession("", "Placement Preparation", WeekDay.THURSDAY, "15:10", "17:55", "", SessionType.PLACEMENT),

            /* freitag */

            ClassSession("PCS-693", "Full Stack Web Development Lab", WeekDay.FRIDAY, "08:00", "08:55", "Lab-1", SessionType.LAB),
            ClassSession("XCS-601", "Verbal Skills", WeekDay.FRIDAY, "09:00", "09:55", "LT-8", SessionType.LECTURE),
            ClassSession("TCS-601", "Compiler Design", WeekDay.FRIDAY, "11:10", "12:05", "LT-8", SessionType.LECTURE),

            ClassSession("", "Lunch Break", WeekDay.FRIDAY, "12:05", "13:00", "", SessionType.LUNCH),

            ClassSession("TCS-614", "Computer Networks-II", WeekDay.FRIDAY, "13:00", "13:55", "LT-8", SessionType.LECTURE),
            ClassSession("TCS-693", "Full Stack Web Development", WeekDay.FRIDAY, "13:55", "14:50", "LT-8", SessionType.LECTURE),
            ClassSession("TCS-631", "Network Programming", WeekDay.FRIDAY, "15:10", "16:05", "Online", SessionType.LECTURE),

            ClassSession("", "Placement Preparation", WeekDay.FRIDAY, "16:05", "17:55", "", SessionType.PLACEMENT)
        )
    }

    /* Deadlines */

    fun getDeadlines(): List<Deadline> {
        return listOf(
            Deadline("TCS-601 Compiler Design Assignment", LocalDate(2026, 1, 11)),
            Deadline("TCS-614 Networks Quiz", LocalDate(2026, 1, 12)),
            Deadline("TCS-693 Full Stack Project Review", LocalDate(2026, 1, 15))
        )
    }

    /* Announcements */

    fun getAnnouncements(): List<Announcement> {
        return listOf(

            /*Exam */

            Announcement(
                "Mid-Semester Exams",
                "Mid-semester examinations will commence from 15th January as per the academic calendar.",
                LocalDate(2026, 1, 8),
                AnnouncementType.EXAM
            ),
            Announcement(
                "End-Semester Practical Exams",
                "End-semester practical examinations will be conducted during the last week of January.",
                LocalDate(2026, 1, 14),
                AnnouncementType.EXAM
            ),

            /*Admin */

            Announcement(
                "Holiday Notice",
                "The university will remain closed on 12th January on account of a public holiday.",
                LocalDate(2026, 1, 9),
                AnnouncementType.ADMIN
            ),
            Announcement(
                "Library Timings Update",
                "Library timings have been extended till 9:00 PM on weekdays.",
                LocalDate(2026, 1, 11),
                AnnouncementType.ADMIN
            ),

            /*Academic*/

            Announcement(
                "Compiler Design Assignment",
                "Assignment 2 has been uploaded on the LMS. Submission deadline is 10th January.",
                LocalDate(2026, 1, 7),
                AnnouncementType.ACADEMIC
            ),
            Announcement(
                "Software Engineering Case Study",
                "Case study topics have been released. Refer to LMS for detailed instructions.",
                LocalDate(2026, 1, 13),
                AnnouncementType.ACADEMIC
            ),

            /*Placement*/

            Announcement(
                "Infosys Placement Drive",
                "Registrations for the Infosys on-campus placement drive are now open. Apply before 18th January.",
                LocalDate(2026, 1, 6),
                AnnouncementType.PLACEMENT
            ),
            Announcement(
                "Mock Interview Sessions",
                "Mock interviews for final year students will begin from 20th January.",
                LocalDate(2026, 1, 16),
                AnnouncementType.PLACEMENT
            ),

            /*event*/

            Announcement(
                "Tech Fest Registrations",
                "Registrations for the annual tech fest are now open for all departments.",
                LocalDate(2026, 1, 5),
                AnnouncementType.EVENT
            ),
            Announcement(
                "Hackathon Announcement",
                "A 24-hour inter-college hackathon will be आयोजित next month. Details coming soon.",
                LocalDate(2026, 1, 17),
                AnnouncementType.EVENT
            )
        )
    }

    /*Profile  */

    fun getStudentProfile(): StudentProfile {
        return StudentProfile(
            name = "Paarth Singh",
            rollNumber = "CS2023XX",
            course = "B.Tech Computer Science",
            year = "3rd Year"
        )
    }
}
