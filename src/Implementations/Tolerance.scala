package Implementations

object Tolerance{
  
/**
 * Hamming
 */
 // factory
  
	def hamming(s1: String, s2: String): Int = {
			if (s1.length != s2.length)
				return Math.abs(s2.length-s1.length())
				(s1.toList).zip(s2.toList)
				.filter(current => current._1 != current._2)
				.length
	} 
	//hamming("rara","xx")
	
	def correct(s1: String, s2: String):Boolean = {
	  if((hamming(s1,s2)== 0) || (hamming(s1,s2)== 1)) return true else false 
	}
	//correct("rara","rare") *
} 