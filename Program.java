package mypackage;

import java.util.Arrays;
import java.util.Scanner;

public class Program 
{
    public static void main(String[] args) 
    {
		//BFS
        City istanbul = new City("İstanbul", 0);
        City ankara = new City("Ankara", 1);
        City izmir = new City("İzmir", 2);
        City bursa = new City("Bursa", 3);
        City adana = new City("Adana", 4);
        City gaziantep = new City("Gaziantep", 5);
        City konya = new City("Konya", 6);
        City diyarbakir = new City("Diyarbakır", 7);
        City antalya = new City("Antalya", 8);
        City mersin = new City("Mersin", 9);
        City kayseri = new City("Kayseri", 10);
        City sanliurfa = new City("Şanlıurfa", 11);
        City malatya = new City("Malatya", 12);
        City samsun = new City("Samsun", 13);
        City denizli = new City("Denizli", 14);
        City batman = new City("Batman", 15);
        City trabzon = new City("Trabzon", 16);
        
        City[] bfsCities = {istanbul, ankara, izmir, bursa, adana, gaziantep, konya, diyarbakir, antalya, mersin, kayseri, sanliurfa, malatya, samsun, denizli, batman, trabzon};
                
        //DFS cities
        String[] dfsCities = {"İstanbul", "Ankara", "İzmir", "Bursa", "Adana", "Gaziantep", "Konya", "Diyarbakır", "Antalya", "Mersin", "Kayseri", "Şanlıurfa", "Malatya", "Samsun", "Denizli", "Batman", "Trabzon"};
    	
        //Adjacency matrix
        int[][] adjacencyMatrix = 
        {
        	// İstanbul Ankara İzmir Bursa Adana Gaziantep Konya Diyarbakır Antalya Mersin Kayseri Şanlıurfa Malatya Samsun Denizli Batman Trabzon
            {0, 449, 99999, 153, 99999, 99999, 645, 99999, 690, 956, 776, 99999, 99999, 737, 649, 99999, 99999},
            // Ankara
            {449, 0, 591, 389, 484, 705, 266, 1003, 483, 501, 317, 848, 682, 402, 483, 99999, 732},
            // İzmir
            {99999, 591, 0, 333, 898, 1118, 560, 99999, 451, 911, 874, 99999, 99999, 1003, 238, 99999, 99999},
            // Bursa
            {153, 389, 333, 0, 856, 1075, 507, 99999, 546, 869, 715, 1212, 1049, 750, 480, 99999, 1091},
            // Adana
            {99999, 484, 898, 856, 0, 225, 346, 525, 649, 95, 307, 369, 389, 719, 758, 618, 851},
            // Gaziantep
            {99999, 705, 1118, 1075, 225, 0, 568, 315, 785, 311, 357, 151, 251, 803, 974, 409, 838},
            // Konya
            {645, 266, 560, 507, 346, 568, 0, 866, 303, 360, 306, 702, 729, 663, 386, 964, 896},
            //Diyarbakır
            {99999, 1003, 99999, 99999, 525, 315, 866, 0, 99999, 610, 571, 182, 235, 803, 1276, 97, 586},
            // Antalya
            {690, 483, 451, 546, 649, 785, 303, 99999, 0, 631, 610, 924, 99999, 99999, 217, 99999, 99999},
            // Mersin
            {956, 501, 911, 869, 95, 311, 360, 610, 631, 0, 99999, 99999, 99999, 99999, 99999, 99999, 99999},
            // Kayseri
            {776, 317, 874, 715, 307, 357, 306, 571, 610, 99999, 0, 99999, 99999, 99999, 99999, 99999, 99999},
            // Şanlıurfa
            {99999, 848, 99999, 1212, 369, 151, 702, 182, 924, 99999, 99999, 0, 99999, 99999, 99999, 99999, 99999},
            // Malatya
            {99999, 682, 99999, 1049, 389, 251, 729, 235, 99999, 99999, 99999, 99999, 0, 99999, 99999, 99999, 99999},
            // Samsun
            {737, 402, 1003, 750, 719, 803, 663, 803, 99999, 99999, 99999, 99999, 99999, 0, 99999, 858, 99999},
            // Denizli
            {649, 483, 238, 480, 758, 974, 386, 1276, 217, 99999, 99999, 99999, 99999, 99999, 0, 99999, 99999},
            // Batman
            {99999, 99999, 99999, 99999, 618, 409, 964, 97, 99999, 99999, 99999, 99999, 99999, 858, 99999, 0, 99999},
            // Trabzon
            {99999, 732, 99999, 1091, 851, 838, 896, 586, 99999, 99999, 99999, 99999, 99999, 99999, 99999, 99999, 0}
        };
        
        Scanner scanner = new Scanner(System.in);
        
        //Create a DFS instance
        DFS dfsAlgorithm = new DFS(adjacencyMatrix, dfsCities);
        //Create a BFS instance
        BFS bfsAlgorithm = new BFS(adjacencyMatrix, bfsCities);
        
        //Intro
        System.out.println("Welcome to The Shortest Path Finder Program! This program helps you find the shortest path between two cities of your choice.\nHere's the cities:");
        
        for (int i = 0; i < dfsCities.length; i++)
        	System.out.println(" * " + dfsCities[i]);
        
        System.out.println("Simply enter the starting city (from-city) and the destination city (to-city), and we'll calculate the shortest path for you.");
        
        while (true) 
        {
            try 
            {
                //Inputs                
                System.out.println("What is your starting city?");
                String to = scanner.nextLine();
                System.out.println("What is your destination city?");
                String from = scanner.nextLine();
                
                System.out.println();
                
                //Converting String to City
                City toBFS = findCityByName(to, bfsCities);
                City fromBFS = findCityByName(from, bfsCities);
                
                //DFS Calculate the shortest path
                long dfsStartTime = System.nanoTime();
                String[] shortestPath = dfsAlgorithm.dfs(to, from);
                long dfsEndTime = System.nanoTime();
                
                System.out.println("The shortest path found using the DFS algorithm."); 
                System.out.println("Shortest Path, DFS: " + Arrays.toString(shortestPath));
                System.out.println("Distance: " + dfsAlgorithm.calculatePathDistance(shortestPath) + "km");
                System.out.println("DFS Execution Time: " + (dfsEndTime - dfsStartTime) / 1_000_000.0 + " milliseconds");
                
                System.out.println();
                
                //BFS Calculate the shortest path
                long bfsStartTime = System.nanoTime();
                Path myPath = bfsAlgorithm.BFSPathFinder(toBFS, fromBFS);
                long bfsEndTime = System.nanoTime();
                
                System.out.println("The shortest path found using the BFS algorithm."); 
                System.out.println(myPath.toString());
                System.out.println("BFS Execution Time: " + (bfsEndTime - bfsStartTime) / 1_000_000.0 + " milliseconds");
                System.out.println("\nThank you for using our program!\n");
                break;
            } 
            catch (CityNotFoundException e) 
            {
                System.err.println(e.getMessage());
            }
        }        
        scanner.close();
    }
    
    //for BFS
    public static City findCityByName(String cityName, City[] cities) 
    {
        cityName = normalize(cityName);
        
        for (City city : cities) 
        {
            if (normalize(city.getName()).equalsIgnoreCase(cityName)) 
                return city;
        }
        
        throw new CityNotFoundException("City '" + cityName + "' cannot be found by the system. Please make sure that you write the city's name correctly.\n");
    }
	
    //Turkish characters fix
	private static String normalize(String input) 
	{
	    return input
	            .replace("İ", "I").replace("ı", "i")
	            .replace("Ğ", "G").replace("ğ", "g")
	            .replace("Ü", "U").replace("ü", "u")
	            .replace("Ş", "S").replace("ş", "s")
	            .replace("Ö", "O").replace("ö", "o")
	            .replace("Ç", "C").replace("ç", "c");
	}
}

