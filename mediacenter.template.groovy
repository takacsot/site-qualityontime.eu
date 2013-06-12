//println "https://admin.mediacenter.hu/index_login.php".toURL().text

String url = "https://admin.mediacenter.hu/index_login.php"

/*@Grapes(@Grab(group='net.sourceforge.htmlunit', module='htmlunit', version='2.12'))
import com.gargoylesoftware.htmlunit.WebClient
def client = new WebClient()
def dlPage = client.getPage(url)
println dlPage.getWebResponse().getContentAsString()*/

@Grab( 'org.codehaus.groovy.modules.http-builder:http-builder:0.6' )
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.URLENC
def http = new HTTPBuilder( url )
http.post( path:'index_login.php',
           body:[ auser:'xxx' , apass:'xxx' ],
           requestContentType:URLENC ) { resp, reader ->
  println "Response status: ${resp.headers}"
  System.out << reader
}
def html = http.get(path:'index_admin.php')
println html

//fine. Next step is the FTP upload