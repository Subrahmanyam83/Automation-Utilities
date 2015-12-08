
package Utils.MyUtils

import Utils.BaseSpec
import com.sun.net.httpserver.HttpsParameters
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.client.utils.URIBuilder
import org.apache.http.conn.HttpClientConnectionManager
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.conn.BasicHttpClientConnectionManager
import org.apache.http.message.BasicNameValuePair


/**
* Created by subrahmanayamv on 5/22/14.
*/

class RestUtil extends BaseSpec{

    HttpClient httpclient;
    HttpClientConnectionManager connectionManager;

    def createHttpConnection(){

        HttpClientBuilder builder = HttpClientBuilder.create()
        connectionManager = new BasicHttpClientConnectionManager()
        builder.setConnectionManager(connectionManager)
        httpclient = builder.build()
    }

    def httpGetResponse() {

        given:
        createHttpConnection()
        HttpGet h = new HttpGet("http://www.google.com")
        HttpResponse r = httpclient.execute(h)
        println(r)

        and:""
        assert true
    }

    def httpPostResponse(){

        String username = "subrahmanyam.venkat@affinnova.com"
        String password = "Affinnova"

        given:
        createHttpConnection()
        HttpPost post = new HttpPost("http://dweb4s1.dev.affinnova.com/platformservices/j_spring_security_check")
        URIBuilder uriBuilder = new URIBuilder(post.getURI()).addParameter("j_username",username)
                .addParameter("j_password",password)
        post.setURI(uriBuilder.build())
        //post.setHeader("Content-Type", "application/x-www-form-urlencoded")
        HttpResponse response = httpclient.execute(post);
        println(response)

//        String jsession = response.getHeaders("Set-Cookie")[0].getValue().split(";")[0]
//        jsession = jsession.replace("JSESSIONID=","")
//        println jsession
    }

    def httpPostResponseSetParams(){

        String username = "subrahmanyam.venkat@affinnova.com"
        String password = "Affinnova"

        given:""
        createHttpConnection()
        HttpPost post = new HttpPost("http://dweb4s1.dev.affinnova.com/platformservices/j_spring_security_check")

        ArrayList<String, String> postParameters = new ArrayList<String, String>()
        postParameters.add(new BasicNameValuePair("j_username",username))
        postParameters.add(new BasicNameValuePair("j_password",password))
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(postParameters)

        post.setEntity(formEntity)

        HttpResponse response = httpclient.execute(post);

        String jsession = response.getHeaders("Set-Cookie")[0].getValue().split(";")[0]
        jsession = jsession.replace("JSESSIONID=","")
        println jsession


    /*** Another way to add parameters ****
        HttpUriRequest req = RequestBuilder.post().setUri("http://dweb4s1.dev.affinnova.com/platformservices/j_spring_security_check").addParameter("j_username", username).addParameter("j_password", password).build()
        HttpResponse response = httpclient.execute(req)
        ****/


        and:""
        assert true

    }
}

