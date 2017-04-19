import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		String[] s = { "", "", "" };
		Scanner in = new Scanner(System.in);

		System.out.println("Enter 4c");
		//4cdata.txt
		s[0] = in.nextLine();
		System.out.println("Enter data");
		s[1] = in.nextLine();
		System.out.println("Enter txt");
		s[2] = in.nextLine();
		
		ArrayList<Double> maja = null;
		try {
			maja = getData(s);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(maja);
		
	//	mean(maja);
		System.out.println("Mean " + mean(maja) + " Mediana" + median(maja) );
		System.out.println("maja.get(maja.size()/2)" +maja.get(maja.size()/2));

	}

	public static ArrayList<Double> getData(String[] s) throws IOException, NumberFormatException {
		URL dataSource = new URL("http://ww2.amstat.org/publications/jse/v9n2/" + s[0] +  s[1] + "." +  s[2]);
		BufferedReader data = new BufferedReader(new InputStreamReader(dataSource.openStream()));
		ArrayList<Double> windData = new ArrayList<>();
		String inputLine;
		while ((inputLine = data.readLine()) != null) {

			windData.add(Double.parseDouble(inputLine.substring(20)));
			data.close();

		}
		return windData;
	}
	
	public static double  mean (ArrayList<Double> weather) {
		double sum = 0;
		for (Double d : weather) {
			sum+=d;
		}
		return sum/weather.size();
	}
	
	
	public static double median (ArrayList<Double> weather) {
		Collections.sort(weather);
		if (weather.size()/2==0) {
	
			return (weather.get(weather.size()/2) + weather.get(weather.size()/2-1))/2;
		}
		else return weather.get(weather.size() / 2);
	}

}
