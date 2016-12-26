package pastry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class Inventory {

	private final String DATA_FILE = "C:\\Users\\Iulia\\workspace\\pastry\\src\\pastry\\data.csv";

	private Vector<Vector<String>> data = new Vector<Vector<String>>();

	private File file;

	public Inventory() {
		this.file = new File(DATA_FILE);
	}

	public void load() {
		String line = new String();
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.file));
			while ((line = br.readLine()) != null) {
				Vector<String> data = new Vector<String>();
				StringTokenizer st1 = new StringTokenizer(line, ",");
				while (st1.hasMoreTokens()) {
					String nextToken = st1.nextToken();
					data.add(nextToken);
				}
				this.data.add(data);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(this.file));
			for (Vector<String> d : this.data) {
				for (int i = 0; i < d.size(); i++) {
					bw.write(d.get(i));
					if (i != d.size() - 1) {
						bw.write(",");
					}
				}
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}

	}

	public Vector<Vector<String>> getData() {
		return data;
	}

	public void addCake(Vector<String> cake) {
		this.data.add(cake);
	}

	public void buyCake(int rowNum, String newVal) {
		this.data.get(rowNum).set(1, newVal);
	}
	
}
