package dna;

import java.io.*;

/**
 * Writes a fasta record to a print writer.
 * @author jayka
 *
 */

public class FastaWriter 
{

	PrintWriter thePrintWriter;	

	/**
	 * initializes a fastawriter.
	 * @param thePrintWriter
	 */
	public FastaWriter(PrintWriter pw) {
		// TODO Auto-generated constructor stub
		this.thePrintWriter = pw;
	}

    /**
     * Writes a fasta record 
     * @param rec is the fasta record to be written 
     * @throws IOException incase of an illegal fasta exception.
     */
	public void writeRecord(FastaRecord rec) throws IOException
	{
         thePrintWriter.write(rec.getDefline());
         thePrintWriter.println();
         thePrintWriter.write(rec.getSequence());
         thePrintWriter.println();
	}
}
