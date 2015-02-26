@Grapes(
        @Grab(group='joda-time', module='joda-time', version='2.7')
)
import org.joda.time.DateTime

import groovy.util.GroovyTestCase

/**
 * Created by markwagner on 2/20/15.
 */
class DateParserTests extends GroovyTestCase {

    private DateParser parser

    def void setUp(){
        parser = new DateParser()
    }

    def void testCanParseDateTime() {
        def dateTime = new DateTime(2013,1,1,9,30)
        def result = parser.parse(dateTime)

        assert '01/01/2013 - 09:30 AM' == result
    }

    def void testWillThrowAnErrorWhenNullDateTimeIsProvided() {
        shouldFail(IllegalArgumentException){
            parser.parse(null)
        }
    }
}
