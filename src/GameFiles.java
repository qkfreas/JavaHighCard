/**
  * Quinn Freas
  * Final Project: High Card
  * @author: Quinn Freas
  */

import java.io.File;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class GameFiles {
	private DataOutputStream output = null;
	private DataInputStream input = null;
	private File f;

	GameFiles(){}

// gets the record file
	private File getFile() throws IOException {
		f = new File("records.dat");
		if(!f.exists())
			f.createNewFile();

		return f;
	}

// creates empty file
	public void createEmptyFile() {
		try {
			getFile();
			f.createNewFile();
		}
		catch (IOException ioe) {

		}
	}

// retrieves previous game record
	public String getRecord() {
		String record = "";
		try {
			input = new DataInputStream(new FileInputStream(getFile()));
			if (input.available() < 1) record = "No record to show";

			while (input.available() > 0) {
				record += "Wins: " + input.readByte() + "\n";
				record += "Losses: " + input.readByte() + "\n";
				record += "Ties: " + input.readByte() + "\n";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}
// records data
	public void setRecord(int w, int l, int t) {
		try {
			input = new DataInputStream(new FileInputStream(getFile()));
			while (input.available() > 0) {
				w += input.readByte();
				l += input.readByte();
				t += input.readByte();
			}
			output = new DataOutputStream(new FileOutputStream(getFile()));
			output.writeByte(w);
			output.writeByte(l);
			output.writeByte(t);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}