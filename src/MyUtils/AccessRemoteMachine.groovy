package Utils.MyUtils

/*import jcifs.smb.NtlmPasswordAuthentication
import jcifs.smb.SmbFile
import jcifs.smb.SmbFileOutputStream*/

/**
 * Created by subrahmanayamv on 10/10/14.
 */
class AccessRemoteMachine {
    def "abc"(){

        given:""
        /*String user = "nrentala:Snooky@123";
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
        String path = "smb://10.176.141.219/Neelima/myone.txt";
        SmbFile sFile = new SmbFile(path, auth);
        SmbFileOutputStream sfos = new SmbFileOutputStream(sFile);
        sfos.write("Hi Neelima".getBytes());*/

        //  Runtime.getRuntime().exec("cmd /C bat.bat",null, new File("C:\\RV\\shared"));
        //  Process proc= Runtime.getRuntime().exec("C://RV//shared//bat.bat");

        /* ServerSocket server
         ServerSocket(4444).
         server.setReuseAddress(true);
         server= new ServerSocket(4444);
         println(server.isBound())*/

        /*Runtime rt = Runtime.getRuntime();
        rt.exec("cmd.exe /c cd \"C://RV//shared\" & start cmd.exe /k \"java -jar selenium-server-standalone-2.42.2.jar\"");*/

        /*    BufferedReader f = new BufferedReader(new FileReader("C:/RV/shared/here.txt"))
            String content
            while ((content = f.readLine()) != null) {
                // convert to char and display it
                println content.trim().split("    ")[4].trim()
               // System.out.print(content.trim());
               }*/



        cleanup:""
    }
    }