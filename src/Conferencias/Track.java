package Conferencias;

import java.util.ArrayList;
import java.util.List;

public class Track implements ITracks{

	@Override
	public List<String> listValueTrack1(List<String> tracks, List<Integer> times) {
		int conth = 1;
		int contq = 1;
		List<String> firstTrack = new ArrayList<String>();

		firstTrack.add("Início da primeira trilha");

		for (int i=0;i<times.size();i++){
			if(times.get(i)==60 && conth<=3){
				firstTrack.add(tracks.get(i)+", "+times.get(i)+" minutos"); 
				conth = conth + 1;
				tracks.remove(i);
				times.remove(i);
			}
		}

		for (int i=0;i<times.size();i++){
			if(times.get(i)==45 && contq<=5){
				firstTrack.add(tracks.get(i)+", "+times.get(i)+" minutos");
				contq = contq + 1;
				tracks.remove(i);
				times.remove(i);
			}
		}

		firstTrack.add("Networking Event iniciando as 16h45");
		firstTrack.add("Fim da primeira trilha \n\n");

		return firstTrack;
	}

	@Override
	public List<String> listValueTrack2(List<String> tracks, List<Integer> times) {
		int conth = 1;
		int contq = 1;
		int contf = 1;

		List<String> secondTrack = new ArrayList<String>();
		secondTrack.add("Início da segunda trilha");
		for (int i=0;i<times.size();i++){
			if(times.get(i)==60 && conth<=2){
				secondTrack.add(tracks.get(i)+", "+times.get(i)+" minutos"); 
				conth = conth + 1;
				tracks.remove(i);
				times.remove(i);
			}
		}

		for (int i=0;i<times.size();i++){
			if(times.get(i)==30 && contq<=7){
				secondTrack.add(tracks.get(i)+", "+times.get(i)+" minutos"); 
				contq = contq + 1;
			}
		}

		for (int i=0;i<times.size();i++){
			if(times.get(i)==45 && contf<=1){
				secondTrack.add(tracks.get(i)+", "+times.get(i)+" minutos");
				contf = contf + 1;
				tracks.remove(i);
				times.remove(i);
			}
		}

		secondTrack.add("Networking Event iniciando as 16h15");
		secondTrack.add("Fim da segunda trilha");


		return secondTrack;
	}

}
