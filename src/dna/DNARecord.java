package dna;


//
// FastqRecord and FastaRecord should implement this.
//
// Remember that in implementing classes, the methods
// listed in the interface have to be public.
//


public interface DNARecord 
{
	//gets the Defline of the lines
	public String	getDefline();
	
	//gets the Sequence of the lines
	public String getSequence();
}
