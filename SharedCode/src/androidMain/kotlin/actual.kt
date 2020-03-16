import java.text.SimpleDateFormat
import java.util.*

actual fun platformName(): String {
    return "Android"
}

actual fun String.dateFormatToMilliseconds(format: String): Long = SimpleDateFormat(format, Locale.getDefault()).parse(this).time