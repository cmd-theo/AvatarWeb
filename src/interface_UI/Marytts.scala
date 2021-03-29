package interface_UI
import javax.sound.sampled.AudioInputStream;
import marytts.LocalMaryInterface;
import marytts.config.LanguageConfig;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

class Marytts {

 
object Mary{
  
  private val tts : MaryInterface = new LocalMaryInterface()
  private var ap : AudioPlayer = new AudioPlayer()

  def speak(langue : String, texte : String) : Unit = {
    try{
    ap.cancel();
    ap = new AudioPlayer()
    
    langue.toLowerCase() match {
      case "de" => tts.setVoice("dfki-pavoque-neutral-hsmm")
      case "it" => tts.setVoice("istc-lucia-hsmm")
      case "en" => tts.setVoice("cmu-slt-hsmm")
      case _ => tts.setVoice("upmc-pierre-hsmm")
    }
    val audio : AudioInputStream = tts.generateAudio(texte)
    ap.setAudio(audio)
    ap.start()
  }
     catch 
        {
            case throwable:Throwable => print("error")
        }
  }
  
  

  
}


}