package arch.module.userprofile.data.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class SchoolInfo(
        @SerializedName("nextLessonTimestamp")
        var nextLessonDate: Date? = null,
        @SerializedName("nextLessonEndedTimestamp")
        var nextLessonEndedTimestamp: Date? = null,
        @SerializedName("canCancelNextLessonForFree")
        val isCanCancelNextLessonForFree: Boolean = false,
        @SerializedName("status")
        var status: SchoolInfoStatus = SchoolInfoStatus.STATUS_STUDYING_NOT_ACTIVE,
        @SerializedName("lessonsSchedule")
        var lessonsSchedule: List<Date> = Collections.emptyList(), // проверить бывает ли null
        @SerializedName("paidLessonsNum")
        var paidLessonsNum: Int = 0,
        @SerializedName("freeLessonCancellationNum")
        val freeLessonCancellationNum: Int = 0,
        @SerializedName("referralLink")
        var referralLink: String? = null,
        var firstPaymentDateTime: Date? = null
) {
    val isSchoolUser: Boolean
        get() = SchoolInfoStatus.STATUS_STUDYING_NOT_ACTIVE == status
}

enum class SchoolInfoStatus {
    @SerializedName("studying_active")
    STATUS_STUDYING_ACTIVE,
    @SerializedName("studying_paused")
    STATUS_STUDYING_PAUSED,
    @SerializedName("studying_not_active")
    STATUS_STUDYING_NOT_ACTIVE,

    // После запроса начала занятий, до звонка
    @SerializedName("studying_requested")
    STATUS_STUDYING_REQUESTED,

    // Отдельная составляющая предыдущего статуса. После звонка, до пробного занятия.
    @SerializedName("after_call")
    STATUS_AFTER_CALL,

    // После пробного занятия, до подбора преподавателя
    @SerializedName("after_trial")
    STATUS_SEARCHING_FOR_TEACHER,
    @SerializedName("school_error")
    STATUS_SCHOOL_ERROR,
    @SerializedName("lost")
    LOST
}