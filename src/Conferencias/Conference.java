package Conferencias;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Conference implements IConference {
	private List<String> tracks;
	private List<Integer> times;
	private static final String Separador = ";";

	List<String> track1 = new ArrayList<String>();
	List<String> track2 = new ArrayList<String>();

	public Conference() throws IOException{
		tracks = new ArrayList<String>();
		times = new ArrayList<Integer>();
		readFileInput();
		imprimeValues();
		writeFile();
	}

	@Override
	public void readFileInput() throws IOException{ 
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(".\\resources\\entrada.csv")));
		String linha = null;
		while ((linha = reader.readLine()) != null) {
			String[] dadosConferencia = linha.split(Separador);
			tracks.add(dadosConferencia[0]);
			dadosConferencia[1] = dadosConferencia[1].replace("min", "");
			times.add(Integer.parseInt(dadosConferencia[1]));
		}
		reader.close();
	}

	@Override
	public void imprimeValues(){
		ITracks presentations = new Track();
		track1 = presentations.listValueTrack1(tracks, times);
		track2 = presentations.listValueTrack2(tracks, times);

		for (int i=0;i<track1.size();i++){
			System.out.println(track1.get(i));
		}

		for (int i=0;i<track2.size();i++){
			System.out.println(track2.get(i));
		}

		tracks.clear();
		times.clear();

	}

	@Override
	public void writeFile(){
		String FILENAME = "C:\\ConferenceSchedule\\Schedule.txt";
		File fileFolder = new File("c:\\ConferenceSchedule");
		fileFolder.mkdir();
		String concatena = "";

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));

			for (int i=0;i<track1.size();i++){
				concatena = concatena+""+track1.get(i)+"\n";
			}

			for (int i=0;i<track2.size();i++){
				concatena = concatena + track2.get(i)+"\n";
			}

			bw.write(concatena);
			bw.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void main(String[]args) throws IOException{
		new Conference();
	}

}

