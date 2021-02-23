package Implementations

object Tolerance{
  
/**
 * Hamming
 */
 // factory
  
	def hamming(s1: String, s2: String): Int = {
			if (s1.length != s2.length) Math.abs(s2.length-s1.length())
			else s1.zip(s2).count(pair => pair._1 != pair._2)
		  //else(s1.toList).zip(s2.toList).filter(current => current._1 != current._2).length
	} 
	//hamming("rara","xx")
	
	def correct(s1: String, s2: String):Boolean = {
	  if((hamming(s1,s2)<= 1)) return true else false 
	} 
	//correct("rara","rare") *
} 