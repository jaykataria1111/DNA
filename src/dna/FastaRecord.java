package dna;

/**
 * Describes a FastaRecord.
 * @author jayka
 *
 */

public class FastaRecord implements DNARecord 
{	
	String defline;
	String sequence;
	
	/**
	 * The following ctor initializes a FastaRecord.
	 * @param defline is the defline of the FastaRecord.
	 * @param sequence is the Sequence of the FastaRecord.
	 * @throws RecordFormatException if the defline is faulty.
	 */
	public FastaRecord(String defline, String sequence) throws RecordFormatException
	{
		if(defline.substring(0,1).equals(">"))
		{
			this.defline = defline;
			this.sequence = sequence;
		}
		else
		{
			throw new RecordFormatException("Bad defline in fasta record, there is no '>' in the start of the defline ");
		}
	}
	
	
	/**
	 * The following ctor. intitializes a Fasta Record with the help of a fastaRecord.
	 * @param fastqRec is the FastqRecord through which this record is initialized.
	 */
	public FastaRecord(FastqRecord fastqRec)
	{
		String def = ">";
		def = def + fastqRec.getDefline().substring(1);
		this.defline = def;
		this.sequence = fastqRec.getSequence();

	}

	
	
	@Override
	public String getDefline() {
		// TODO Auto-generated method stub
		return defline;
	}


	@Override
	public String getSequence() {
		// TODO Auto-generated method stub
		return sequence;
	}
	
	

	
	
	/**
	 * the following method checks for deep equality of the class.
	 * @param that is the FastaRecord which has to be compared.
	 * @return returns true if the Records are equal.
	 */
	public boolean equals(FastaRecord that)
	{
		if(this.sequence.equals(that.sequence) && this.defline.equals(that.defline))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	/**
	 * The following method returns the sum of hash codes of the instance variables.
	 * @return Returns the sum of the hashcode of the instance variables.
	 */
	public int hashcode()
	{
		return sequence.hashCode() + defline.hashCode();
	}
}
