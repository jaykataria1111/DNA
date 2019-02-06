package dna;

/**
 * The following class describes a FastqRecord. 
 * @author jayka
 *
 */


public class FastqRecord implements DNARecord 
{
	String defline;
	String sequence;
	String quality;

	/**
	 * THe following constructor initializes a FastqRecord.
	 * @param defline is the defline of the FastqRecord.
	 * @param sequence is the sequence of the FastqRecord.
	 * @param quality is the quality of the FastqRecord.
	 * @throws RecordFormatException  id the defline is faulty.
	 */
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException 
	{
		if(defline.substring(0,1).equals("@"))
		{
			this.defline = defline;
			this.sequence = sequence;
			this.quality = quality;
		}
		else
		{
			throw new RecordFormatException("Bad 1st char in defline in fastq record");
		}
	}


	@Override
	public String getDefline() {

		return defline;
	}


	@Override
	public String getSequence() {

		return sequence;
	}




	/**
	 * The following method checks for deep quality for two FastqRecords.
	 * @param that is the FastqRecord that you have to check, whether it is equal.
	 * @return Returns whether the two fastqRecords are equal.
	 */
	public boolean equals(FastqRecord that)
	{
		if(this.defline.equals(that.defline) && this.sequence.equals(that.sequence) && this.quality.equals(that.quality))
			return true;
		else 
			return false;
	}


	

	/**
	 * THe following method checks if the qualty of the Fastqrecord is low.
	 * @return true if the quality is low.
	 */
	public boolean qualityIsLow()
	{
	     boolean flag = quality.contains("!");	
		return flag;
	}


	/**
	 * THe following method returns the sum of hashcodes of all the instance variables 
	 * @return Returns the sum of the hashcodes of the instacnce variables.
     */
	public int hashCode()
	{
		return defline.hashCode() +sequence.hashCode() + quality.hashCode();
	}

	
		

}
