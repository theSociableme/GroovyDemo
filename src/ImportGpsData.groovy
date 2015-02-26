@Grapes(
        @Grab(group = 'org.codehaus.groovy.modules.http-builder',
                module = 'http-builder',
                version = '0.6')
)
import groovyx.net.http.RESTClient

def file = new File('../data/fells_loop.gpx')

println file.exists()

def slurper = new XmlSlurper();
def gpx = slurper.parse(file)

gpx.with {
    println name
    println ''
    println desc
    println ''
    println attributes()['version']
    println attributes()['creator']
}

def forecastApi = new RESTClient('https://api.forecast.io/')
def apiKey ='f106310bab9d2b16dfaa442bb6b380e7'

gpx.rte.rtept.each({
    println it.@lat
    println it.@lon

    def parser = new DateParser()
    println parser.parse(it.time.toString())

    def queryString = "forecast/$apiKey/${it.@lat},${it.@lon},${it.time}"
    def response = forecastApi.get(path: queryString)

    println response.data.currently.summary
    println response.data.currently.temperature + " degrees"

})