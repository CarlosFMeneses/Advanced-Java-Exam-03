/*
Carlos F. Meneses
03/30/2015
Bergen Community College
Advanced Java Programming

Exam 3, Part 2
*/
/**
Bowling2.java: Reads scores of each team member from file "Scores2.txt". 
Computes the average, and then displays each bowler's name, their average 
and the team average into file "Averages1.txt". But only if the scores are
valid (scores between 0 and 300).
*/

import java.nio.file.*;
import java.io.*;
import static java.nio.file.AccessMode.*;

public class Bowling2
{
   public static void main(String[] args)
   {
      Path readFile = Paths.get("Scores2.txt");
      Path writeFile = Paths.get("Averages2.txt");
      String sIn = "";
      String sOut = "";
      String delimiter = ",";
      String[] entry = new String[4];
      int numBowlers = 0;
      String name ="";
      int game1 = 0, game2 = 0, game3 = 0, game4 = 0, game5 = 0;
      int teamTotal = 0;
      double bowlerAverage = 0, teamAverage = 0;
      
      try
      {
         InputStream input = new BufferedInputStream(Files.newInputStream(readFile));
         BufferedReader reader = new BufferedReader(new InputStreamReader(input));
         
         OutputStream output = new BufferedOutputStream(Files.newOutputStream(writeFile));
         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

         numBowlers = Integer.parseInt(reader.readLine());
         
         // System.out.println("numBowlers = " + numBowlers);
         
         for (int sub = 0;sub < numBowlers; ++sub)
         {
            sIn = reader.readLine();
            // System.out.println("s = " + sIn);
            entry = sIn.split(delimiter);
            
            name = entry[0];
            game1 = Integer.parseInt(entry[1]);
            game2 = Integer.parseInt(entry[2]);
            game3 = Integer.parseInt(entry[3]);
            game4 = Integer.parseInt(entry[4]);
            game5 = Integer.parseInt(entry[5]);
           
            if (game1 <0 || game1 > 300)
					throw (new InvalidDataInput());
            if (game2 <0 || game2 > 300)
					throw (new InvalidDataInput());
            if (game3 <0 || game3 > 300)
					throw (new InvalidDataInput());
            if (game4 <0 || game4 > 300)
					throw (new InvalidDataInput());
            if (game5 <0 || game5 > 300)
					throw (new InvalidDataInput());
            
            bowlerAverage = (game1 + game2 + game3) / 3;
            teamTotal += game1 + game2 + game3;
            
            sOut = name + " - " + bowlerAverage + System.getProperty("line.separator");
            writer.write(sOut, 0, sOut.length());   
         }
         teamAverage = teamTotal / 9;
         writer.write(System.getProperty("line.separator") + "The Team Total Pins = " + teamTotal);
         writer.write(System.getProperty("line.separator") + "The Team Average = " + teamAverage);
         
         writer.close();
         reader.close();
      }
      
      catch(InvalidDataInput idi)
      {
        System.out.println("Message: " + idi);
      }
   }
}