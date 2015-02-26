@Grapes(
        @Grab(group='joda-time', module='joda-time', version='2.7')
)

import org.joda.time.DateTime

/**
 * Created by markwagner on 2/20/15.
 */
class DateParser {

    def String parse(time){
        if(time == null)
            throw new IllegalArgumentException()

        use(DateTimeCategory){
            def printableTime = new DateTime(time)
            printableTime.createPrintableTime()
        }
    }
}
