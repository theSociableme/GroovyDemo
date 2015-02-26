@Grapes(
        @Grab(group='joda-time', module='joda-time', version='2.7')
)
import org.joda.time.format.DateTimeFormat

/**
 * Created by markwagner on 2/24/15.
 */
class DateTimeCategory {

    def static String createPrintableTime(dateTime){
        def format = DateTimeFormat.forPattern('MM/dd/yyyy - hh:mm aa')
        return dateTime.toString(format)
    }

}
