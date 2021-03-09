package Implementations

object Tolerance{

	/**
	 * Hamming
	 */
	// factory

	def hamming(s1: String, s2: String): Int = {
			s1.zip(s2).count(pair => pair._1 != pair._2)
			//else(s1.toList).zip(s2.toList).filter(current => current._1 != current._2).length
			//Math.abs(s2.length-s1.length())
	} 
	hamming("rara","xx")

	def correct(s1: String, s2: String):Boolean = {
			if (s1.length+1 == s2.length) {
				var lfin: List[String] = List()
						for(i <- 0 to s1.length()){
							lfin = lfin++List(s1.take(i)++" "++s1.takeRight(s1.size-i))
						}
				println("LFiN: " +s1 + " : " + lfin) 
				correctBis(s2, lfin)
			}
			else if(s1.length() == s2.length() && hamming(s1, s2) <= 1) true
			else false
	}

	def correctBis(s2: String, lfin: List[String]) : Boolean = {
	   for(i <- lfin){
	     if(hamming(s2, i)<=1) return true
	   }
	   false
	}
	
	//def correctBis(s1: String, s2: String)
	correct("Mairie","Theatre")
	//hamming("mairie","theatre")
}  