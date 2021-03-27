package Implementations

object Tolerance{

	/**
	 * @param s1 une chaine de caractere
	 * @param s2 une chaine de caractere
	 * @return la distance de hamming entre s1 et s2
	 */
	// factory

	def hamming(s1: String, s2: String): Int = {
	  val s1L = replace(s1.toLowerCase()) // pour ne pas prendre en compte les majuscules et miniscules 
	  val s2L = replace(s2.toLowerCase())
			s1L.zip(s2L).count(pair => pair._1 != pair._2)//le zip return une combinaison de paires de s1 et s2
			//else(s1.toList).zip(s2.toList).filter(current => current._1 != current._2).length
			//Math.abs(s2.length-s1.length())
	} 
	hamming("rara","xx")

	/**
	 * @param s1 une chaine de caractere
	 * @param s2 une chaine de caractere
	 * @return un boolean si la distance de hammming entre s1 et s2 et plus petite que 1
	 */
	def correct(s1: String, s2: String):Boolean = {
			if (s1.length+1 == s2.length) {
				var lfin: List[String] = List()
						for(i <- 0 to s1.length()){
							lfin = lfin++List(s1.take(i)++" "++s1.takeRight(s1.size-i))
						}
				//println("LFiN: " +s1 + " : " + lfin)  
				compareStringToList(s2, lfin)
			}
			else if(s1.length() == s2.length() && hamming(s1, s2) <= 1) true
			else false
	}
	/**
	 * @param s2 une chaine de caractere
	 * @param lfin une liste de chaines de caractéres
	 * @return true si la distance de hamming est plus petite que 1 en comparant s2 avec tous le chaine de caractéres de lfin
	 */
	def compareStringToList(s2: String, lfin: List[String]) : Boolean = {
	   for(i <- lfin){
	     if(hamming(s2, i)<=1) return true
	   }
	   false
	}
	
	def replace (s : String) : String = {
    var res:String = s
    res = res.replace("é", "e")
    res = res.replace("à" , "a")
    res = res.replace("è", "e")
    res = res.replace("î", "i")
    res = res.replace("ù", "u")
    res = res.replace("û", "u")
    res = res.replace("â", "a")
    res = res.replace("ç", "c")
    res = res.replace("ô","o")
    res
}

	replace("càrâctérè")
	//def correctBis(s1: String, s2: String)
	correct("Mairie","Theatre")
	//hamming("mairie","theatre")

}  