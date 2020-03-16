import platform.UIKit.UIDevice

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() + " ${UIDevice.currentDevice.systemVersion}"
}

actual fun String.dateFormatToMilliseconds(format: String): Long {
    val formatter = NSDateFormatter()
    formatter.dateFormat = parseFormat
    return formatter.dateFromString(this)?.timeIntervalSince1970?.toLong()
        ?: throw Exception("Failed")
}