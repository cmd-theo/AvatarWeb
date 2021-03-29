package interface_UI
  import javax.sound.sampled.AudioInputStream
import marytts._
import marytts.util.data.audio._
class Marytts {

 
object Mary{
  
    private val voiceName:String = "mary"
    val marytts = new LocalMaryInterface();
    val ap = new AudioPlayer();

        try
        {
            val marytts = new LocalMaryInterface();
            marytts.setVoice(voiceName);
            val ap = new AudioPlayer();
        }
        catch 
        {
            case  throwable => print("error")
        }

    def say(input: String) = {
        try
        {
            val audio:AudioInputStream = marytts.generateAudio(input);

            ap.setAudio(audio);
            ap.start();
        }
        catch
        {
            case  throwable => print("error saying phrase")
        }
  }
}
}