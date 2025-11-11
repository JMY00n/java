package chapter7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Location {
	double longitude; // 경도
	double latitude; // 위도

	public Location(double longtitude, double latitude) {
		this.longitude = longtitude;
		this.latitude = latitude;
	}
	
	public String toString() {
		return this.longitude + "\t" + this.latitude;
	}
}

public class LocationManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Location> hm = new HashMap<String, Location>();

		System.out.println("도시, 경도, 위도를 입력하세요.");

		for (int i = 0; i < 4; i++) { // 4개의 도시만 입력
			String inputLine = sc.nextLine();
			
			String[] parts = inputLine.trim().split(",\\s*");
			
			if (parts.length != 3) {
				System.out.println("입력 형식이 올바르지 않습니다. 다시 입력해주세요.");
				i--;
				continue;
			}
			
			String city = parts[0];
			
			try {
				double longtitude = Double.parseDouble(parts[1].trim());
				double latitude = Double.parseDouble(parts[2].trim());
				
				Location newLocation = new Location(longtitude, latitude);
				
				hm.put(city, newLocation);
			} catch (NumberFormatException e) {
				System.out.println("경도와 위도는 숫자만 입력해야 합니다. 다시 입력해주세요.");
				i--;
			}
		}
		
		// 이후 해쉬맵에 있는 모든 도시 출력
		System.out.println("------------------------------------");
		for (Map.Entry<String, Location> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue().toString());
		}
		System.out.println("------------------------------------");
		
		// 도시 이름 검색
		while (true) {
			System.out.print("도시 이름 >> ");
			String searchCity = sc.next();
			if (searchCity.trim().equalsIgnoreCase("그만")) {
				System.out.println("프로그램을 종료합니다...");
				return;
			}
			
			if (hm.containsKey(searchCity)) {
				Location searchLocation = hm.get(searchCity);
				System.out.println(searchCity + "\t" + searchLocation.longitude + "\t" + searchLocation.latitude);
			} else {
				System.out.print(searchCity + "은(는) 없습니다.");
				sc.close();
				System.out.println();
			}
		}
		
		
	}
}
