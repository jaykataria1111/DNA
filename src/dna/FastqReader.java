package dna;

import java.io.*;


/**
 * Reads lines from a BufferedReader and builds a FastqReader.
 * @author jayka
 *
 */


public class FastqReader 
{
	BufferedReader theBufferedReader ;
	
	
	
	/**
	 * The following ctor initializes a buffered Reader.
	 * @param theBufferedReader is the new instance which is going to be initialized.
	 */
	public FastqReader(BufferedReader theBufferedReader) {
		this.theBufferedReader = theBufferedReader;
	}


	/**
	 * THe following method reads fastq Records 
	 * @return THe fastq Record that was read from the bufferedREader
	 * @throws IOExceptionif there are I/O errors 
	 * @throws RecordFormatException if there are any problems in the delfine.
	 */
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		String defline  = theBufferedReader.readLine();
		String sequence = theBufferedReader.readLine();
	     String plusSign = theBufferedReader.readLine();
		String quality = theBufferedReader.readLine();
		FastqRecord fastq = new FastqRecord(defline,sequence,quality);
		
		if(defline == null)
	    return null;
		return fastq;
		

	}
}
