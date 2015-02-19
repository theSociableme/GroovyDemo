def file = new File('../data/fells_loop.gpx')

println file.exists()

def slurper = new XmlSlurper();
def gpx = slurper.parse(file)

println gpx

