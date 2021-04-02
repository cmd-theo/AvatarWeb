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
/*
 * Fonction qui à partir d'une langue et d'un texte génère de l'audio
 * contient un Pattern Matching afin de selectionner la voix en fonction de la langue entrée
 * en cas d'erreur renvoi "error"
*/  
  def speak(langue : String, texte : String) : Unit = {
    try{
    ap.cancel();
    ap = new AudioPlayer()
    
    langue match {
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