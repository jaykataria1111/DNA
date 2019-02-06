package dna;

import java.io.*;
import java.util.*;


public class FileConverter 
{
	File fastq;
	File fasta;
	
	
	/**
	 * The following ctor initializes a File convertor object
	 * @param fastq is the FastqRecord.
	 * @param fasta is the FastaRecord.
	 */
	public FileConverter(File fastq, File fasta) {
		this.fastq = fastq;
		this.fasta = fasta;
	}



	/**
	 * Converts a Fastq file to a Fasta file.
	 * @throws IOException if you ecounter one.
	 */
	public void convert() throws IOException
	{
		// Build chain of readers.
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw =  new PrintWriter(fw);
		FastqReader fqr =  new FastqReader(br);
		FastaWriter faw = new FastaWriter(pw);
		
		while(true)
	 {
			try { 
		//fqr = new FastqReader(br);

		// Build chain of writers.

		
		
		// Read, translate, write.
		FastqRecord fast;
		
			fast = fqr.readRecord();
			FastaRecord fastar = new FastaRecord(fast);
			if(!fast.qualityIsLow())
			faw.writeRecord(fastar);
		}
			catch (RecordFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			catch(NullPointerException r)
			{
				break;	
			}
		
		} 
	 
		
		// Close fr, br, fw, and pw in reverse order of creation.
	    pw.close();
	    fw.close();
	    br.close();
	    fr.close();
	}
	
		
	
	public static void main(String[] args) throws RecordFormatException
	{
		System.out.println("Starting");
		try
		{
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists())
			{
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		}
		catch (IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
