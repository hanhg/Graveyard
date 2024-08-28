import java.awt.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner scan = new Scanner(System.in);
    Random rng = new Random();
    StdDraw.enableDoubleBuffering();
    while(true)
    {
      StdDraw.disableDoubleBuffering();
      StdDraw.setCanvasSize(300, 300);
      StdDraw.setXscale(0,300);
      StdDraw.setYscale(0,300);

      StdDraw.setPenColor(0,0,0);//
      StdDraw.filledRectangle(150, 150, 150, 150); //clears background
      StdDraw.setPenColor(255,255,255);
      Font font = new Font("Arial", Font.BOLD, 12);
      StdDraw.setFont(font);
      StdDraw.setPenColor(255,255,255);

      int pointsX[] = {0, 50, 100, 150, 200, 250, 300, 0, 50, 100, 150, 200, 250, 300, 0, 50, 100, 150, 200, 250, 300, 0, 50, 100, 150, 200, 250, 300, 0, 50, 100, 150, 200, 250, 300, 0, 50, 100, 150, 200, 250, 300, 0, 50, 100, 150, 200, 250, 300};
      int pointsY[] = {300, 300, 300, 300, 300, 300, 300, 250, 250, 250, 250, 250, 250, 250, 200, 200, 200, 200, 200, 200, 200, 150, 150, 150, 150, 150, 150, 150, 100, 100, 100, 100, 100, 100, 100, 50, 50, 50, 50, 50, 50, 50, 0, 0, 0, 0, 0, 0, 0};
      /*
      for(int i = 0; i < 49; i++)
      {
        StdDraw.circle(pointsX[i],pointsY[i],2);
      }
      */ //Draws out each point

      int[] boxX = {25, 75, 125, 175, 225, 275, 25, 75, 125, 175, 225, 275, 25, 75, 125, 175, 225, 275, 25, 75, 125, 175, 225, 275, 25, 75, 125, 175, 225, 275, 25, 75, 125, 175, 225, 275};
      int[] boxY = {275, 275, 275, 275, 275, 275, 225, 225, 225, 225, 225, 225, 175, 175, 175, 175, 175, 175, 125, 125, 125, 125, 125, 125, 75, 75, 75, 75, 75, 75, 25, 25, 25, 25, 25, 25};

      int t=0,t1=0,t2=0;
      int[] horizLineX = new int[42], horizLineY = new int[42], horizLineX1 = new int[42], horizLineY1 = new int[42], vertLineX = new int[42], vertLineY = new int[42], vertLineX1 = new int[42], vertLineY1 = new int[42];
      int add = 0;
      int count = 0;
      for(int i = 0; i < 42; i++) //Horizontal Line Coordinates
      {
        horizLineX[i] = pointsX[i + add];
        horizLineY[i] = pointsY[i + add];
        horizLineX1[i] = pointsX[i + add + 1];
        horizLineY1[i] = pointsY[i + add + 1];
        count++;
        if(count == 6)
        {
          count = 0;
          add += 1;
        }
      }

      for(int i = 0; i < 42; i++) //Vertical Line Coordinates
      {
        vertLineX[i] = pointsX[i];
        vertLineY[i] = pointsY[i];
        vertLineX1[i] = pointsX[i+7];
        vertLineY1[i] = pointsY[i+7];
      }

      String preset = "";
      int q=0,a0=0,b=0,c=0,x=0,y=0,z=0,m[] = new int[42],n[] = new int[42];

      StdDraw.enableDoubleBuffering();
      do
      {
        System.out.print("Choose preset 1 2 or 3 >>> ");
        preset = scan.nextLine();
      }
      while(!(preset.equals("1") || preset.equals("2") || preset.equals("3") || preset.equals("OPEN") || preset.equals("GRID")));

      if(preset.equals("1"))
      {
        q = 0;
        a0 = 21;
        b = 5;
        c = 30;
        x = 35;
        y = 25;
        z = 10;
        int[] p = {1, 1, 1, 1, 1, 1, /**/0, 1, 1, 0, 1, 0, /**/0, 0, 1, 0, 0, 0, /**/0, 0, 1, 0, 0, 0,/**/ 0, 1, 1, 0, 1, 0, /**/0, 0, 0, 1, 0, 0, /**/ 1, 1, 1, 1, 1, 1}; // The /**/ indicates different rows

        int[] l = {1, 1, 0, 0, 0, 0, 1, /**/1, 0, 0, 1, 1, 1, 1, /**/ 1, 1, 1, 0, 1, 1, 1, /**/1, 1, 0, 0, 0, 1, 1,/**/ 1, 0, 1, 0, 1, 0, 1, /**/1, 0, 0, 0, 0, 1, 1};

        for(int i = 0; i < 42; i++)
        {
          m[i] = p[i];
          n[i] = l[i];
        }
      }
      else if(preset.equals("2"))
      {
        q = 5;
        a0 = 0;
        b = 29;
        c = 20;
        x = 25;
        y = 4;
        z = 28;
        int[] p = {1, 1, 1, 1, 1, 1, /**/0, 0, 0, 1, 1, 0, /**/0, 0, 0, 0, 0, 0, /**/1, 0, 1, 0, 0, 1,/**/ 0, 0, 0, 0, 1, 1, /**/0, 1, 0, 0, 0, 0, /**/ 1, 1, 1, 1, 1, 1}; // The /**/ indicates different rows

        int[] l = {1, 1, 0, 0, 0, 1, 1, /**/1, 1, 0, 1, 0, 1, 1, /**/ 1, 0, 0, 0, 0, 0, 1, /**/1, 0, 0, 1, 0, 0, 1,/**/ 1, 0, 0, 1, 1, 0, 1, /**/1, 1, 0, 0, 0, 1, 1};

        for(int i = 0; i < 42; i++)
        {
          m[i] = p[i];
          n[i] = l[i];
        }
      }
      else if(preset.equals("3"))
      {
        q = 33;
        a0 = 9;
        b = 29;
        c = 13;
        x = 0;
        y = 11;
        z = 35;
        int[] p = {1, 1, 1, 1, 1, 1, /**/0, 0, 0, 1, 0, 0, /**/1, 1, 0, 1, 0, 1, /**/0, 0, 0, 0, 0, 0,/**/ 0, 0, 0, 1, 0, 1, /**/0, 1, 0, 1, 0, 0, /**/ 1, 1, 1, 1, 1, 1}; // The /**/ indicates different rows

        int[] l = {1, 0, 0, 1, 0, 1, 1, /**/1, 0, 0, 0, 1, 0, 1, /**/ 1, 0, 1, 0, 0, 0, 1, /**/1, 1, 1, 1, 0, 0, 1,/**/ 1, 1, 0, 0, 0, 1, 1, /**/1, 0, 0, 0, 1, 0, 1};

        for(int i = 0; i < 42; i++)
        {
          m[i] = p[i];
          n[i] = l[i];
        }
      }
      else if(preset.equals("OPEN"))
      {
        q = 0;
        a0 = 35;
        b = 35;
        c = 35;
        x = 5;
        y = 30;
        z = 35;
        int[] p = {1, 1, 1, 1, 1, 1, /**/0, 0, 0, 0, 0, 0, /**/0, 0, 0, 0, 0, 0, /**/0, 0, 0, 0, 0, 0,/**/ 0, 0, 0, 0, 0, 0, /**/0, 0, 0, 0, 0, 0, /**/ 1, 1, 1, 1, 1, 1}; // The /**/ indicates different rows

        int[] l = {1, 0, 0, 0, 0, 0, 1, /**/1, 0, 0, 0, 0, 0, 1, /**/ 1, 0, 0, 0, 0, 0, 1, /**/1, 0, 0, 0, 0, 0, 1,/**/ 1, 0, 0, 0, 0, 0, 1, /**/1, 0, 0, 0, 0, 0, 1};

        for(int i = 0; i < 42; i++)
        {
          m[i] = p[i];
          n[i] = l[i];
        }

      }
      else if(preset.equals("GRID"))
      {
        q = 5;
        a0 = 3;
        b = 14;
        c = 29;
        x = 8;
        y = 25;
        z = 34;
        int[] p = {1, 1, 1, 1, 1, 1, /**/1, 0, 1, 0, 1, 0, /**/0, 1, 0, 1, 0, 1, /**/0, 1, 0, 1, 0, 1, /**/ 1, 0, 1, 0, 1, 0,  /**/1, 0, 1, 0, 1, 0, /**/ 1, 1, 1, 1, 1, 1}; // The /**/ indicates different rows

        int[] l = {1, 1, 1, 1, 1, 1, 1, /**/1, 0, 0, 0, 0, 0, 1, /**/ 1, 1, 1, 1, 1, 1, 1, /**/1, 0, 0, 0, 0, 0, 1,/**/ 1, 1, 1, 1, 1, 1, 1, /**/1, 0, 0, 0, 0, 0, 1};

        for(int i = 0; i < 42; i++)
        {
          m[i] = p[i];
          n[i] = l[i];
        }
      }
      
      //You can alter this part to create the lines for the maze
      int[] horizLines = {1, 1, 1, 1, 1, 1, /**/0, 1, 1, 0, 1, 0, /**/0, 0, 1, 0, 0, 0, /**/0, 0, 1, 0, 0, 0,/**/ 0, 1, 1, 0, 1, 0, /**/0, 0, 0, 1, 0, 0, /**/ 1, 1, 1, 1, 1, 1}; // The /**/ indicates different rows

      int[] vertLines = {1, 1, 0, 0, 0, 0, 1, /**/1, 0, 0, 1, 1, 1, 1, /**/ 1, 1, 1, 0, 1, 1, 1, /**/1, 1, 0, 0, 0, 1, 1,/**/ 1, 0, 1, 0, 1, 0, 1, /**/1, 0, 0, 0, 0, 1, 1};

      for(int i = 0; i < 42; i++)
      {
        horizLines[i] = m[i];
        vertLines[i] = n[i];
      }

      for(int i = 0; i < 42; i++)
      {
        if(horizLines[i] == 1)
          StdDraw.line(horizLineX[i], horizLineY[i], horizLineX1[i], horizLineY1[i]);
        if(vertLines[i] == 1)
          StdDraw.line(vertLineX[i], vertLineY[i], vertLineX1[i], vertLineY1[i]);
      }

      int[] top = new int[36], bottom = new int[36], left = new int[36], right = new int[36]; //Box lines
      add = 0;
      count = 0;
      for(int i = 0; i < 36; i++)
      {
        top[i] = i;
        bottom[i] = i + 6;
        right[i] = i + 1 + add;
        left[i] = i + add;
        count++;
        if(count == 6)
        {
          add++;
          count = 0;
        }
      }

      int targets = 0; 
      int target = x, target1 = y, target2 = z;

      //Player
      int start = q;
      int currentBox = start; //starting box uses index counting
      int botBox = a0; //box of bot
      int botBox1 = b;
      int botBox2 = c;

      StdDraw.picture(boxX[target], boxY[target], "sparkle.PNG");//targets
      StdDraw.picture(boxX[target1], boxY[target1], "sparkle.PNG");
      StdDraw.picture(boxX[target2], boxY[target2], "sparkle.PNG");

      StdDraw.circle(boxX[start], boxY[start], 18);//start
      StdDraw.text(boxX[start], boxY[start], "start");

      StdDraw.picture(boxX[currentBox], boxY[currentBox], "player1.PNG");//player
      StdDraw.setPenColor(212,24,11);
      StdDraw.picture(boxX[botBox], boxY[botBox], "ghost.PNG");//enemy 1
      StdDraw.setPenColor(118,11,212);
      StdDraw.picture(boxX[botBox1], boxY[botBox1], "ghost.PNG");//enemy 2
      StdDraw.setPenColor(255,255,255);
      StdDraw.setPenColor(11, 31, 212);
      StdDraw.picture(boxX[botBox2], boxY[botBox2], "ghost.PNG");// enemy 3
      int dead = 0;
      System.out.println("\nBring all the sparkles back to the start \nwhile avoiding those other guys\nGhosts wander at random- use that to your advantage\n\nW is up; A is left; D is right; S is down");

      StdDraw.show();
      while(dead == 0)
      {
        StdDraw.enableDoubleBuffering();
        String choice = "";
        do
        {
          System.out.print("Enter W A S D to move >>> ");
          choice = scan.nextLine();
        }
        while(!(choice.equalsIgnoreCase("w") || choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("s") || choice.equalsIgnoreCase("d")));

        if(choice.equalsIgnoreCase("w"))
        {
          if(horizLines[top[currentBox]] == 0)
          {
            StdDraw.setPenColor(0,0,0);//
            StdDraw.filledCircle(boxX[currentBox], boxY[currentBox], 20);
            StdDraw.setPenColor(255,255,255);
            currentBox -= 6;
            StdDraw.picture(boxX[currentBox], boxY[currentBox], "player1.PNG"); //player
          }
          else
          {
            System.out.println("This way is blocked!");
            continue;
          }
        }

        else if(choice.equalsIgnoreCase("s"))
        {
          if(horizLines[bottom[currentBox]] == 0)
          {
            StdDraw.setPenColor(0,0,0);//
            StdDraw.filledCircle(boxX[currentBox], boxY[currentBox], 20);
            StdDraw.setPenColor(255,255,255);
            currentBox += 6;
            StdDraw.picture(boxX[currentBox], boxY[currentBox], "player1.PNG"); //player
          }
          else
          {
            System.out.println("This way is blocked!");
            continue;
          }
        }

        else if(choice.equalsIgnoreCase("a"))
        {
          if(vertLines[left[currentBox]] == 0)
          {
            StdDraw.setPenColor(0,0,0);//
            StdDraw.filledCircle(boxX[currentBox], boxY[currentBox], 20);
            StdDraw.setPenColor(255,255,255);
            currentBox -= 1;
            StdDraw.picture(boxX[currentBox], boxY[currentBox], "player1.PNG");//player
          }
          else
          {
            System.out.println("This way is blocked!");
            continue;
          }
        }

        else if(choice.equalsIgnoreCase("d"))
        {
          if(vertLines[right[currentBox]] == 0)
          {
            StdDraw.setPenColor(0,0,0);//
            StdDraw.filledCircle(boxX[currentBox], boxY[currentBox], 20);
            StdDraw.setPenColor(255,255,255);
            currentBox += 1;
            StdDraw.picture(boxX[currentBox], boxY[currentBox], "player1.PNG");//player
          }
          else
          {
            System.out.println("This way is blocked!");
            continue;
          }
        }
        if(botBox == currentBox || botBox1 == currentBox || botBox2 == currentBox)
        {
          dead++;
          break;
        }


        //deadly bot
        StdDraw.setPenColor(212,24,11);
        int w=0, a=0, s=0, d=0;
        int bot;
        choice = "";
        do
        {
          bot = rng.nextInt(100) + 1;
          if(bot >= 75)
            choice = "w";
          else if(bot >= 50)
            choice = "s";
          else if(bot >= 25)
            choice = "a";
          else
            choice = "d";
          if(choice.equalsIgnoreCase("w") && w == 0)
          {
            if(horizLines[top[botBox]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox], boxY[botBox], 20);
              StdDraw.setPenColor(212,24,11);
              botBox -= 6;
              StdDraw.picture(boxX[botBox], boxY[botBox], "ghost.PNG");
            }
            else
            {
              w++;
              continue;
            }
          }

          else if(choice.equalsIgnoreCase("s") && s == 0)
          {
            if(horizLines[bottom[botBox]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox], boxY[botBox], 20);
              StdDraw.setPenColor(212,24,11);
              botBox += 6;
              StdDraw.picture(boxX[botBox], boxY[botBox], "ghost.PNG");
            }
            else
            {
              s++;
              continue;
            }
          }

          else if(choice.equalsIgnoreCase("a") && a == 0)
          {
            if(vertLines[left[botBox]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox], boxY[botBox], 20);
              StdDraw.setPenColor(212,24,11);
              botBox -= 1;
              StdDraw.picture(boxX[botBox], boxY[botBox], "ghost.PNG");
            }
            else
            {
              a++;
              continue;
            }
          }

          else if(choice.equalsIgnoreCase("d") && d == 0)
          {
            if(vertLines[right[botBox]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox], boxY[botBox], 20);
              StdDraw.setPenColor(212,24,11);
              botBox += 1;
              StdDraw.picture(boxX[botBox], boxY[botBox], "ghost.PNG");
            }
            else
            {
              d++;
              continue;
            }
          }
        }
        while(false);

        if(botBox == currentBox || botBox1 == currentBox || botBox2 == currentBox)
        {
          dead++;
          break;
        }

        //deadly bot2
        StdDraw.setPenColor(118,11,212);
        int w1=0, a1=0, s1=0, d1=0;
        int bot1;
        choice = "";
        do
        {
          bot1 = rng.nextInt(100) + 1;
          if(bot1 >= 75)
            choice = "w";
          else if(bot1 >= 50)
            choice = "s";
          else if(bot1 >= 25)
            choice = "a";
          else
            choice = "d";
          if(choice.equalsIgnoreCase("w") && w1 == 0)
          {
            if(horizLines[top[botBox1]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox1], boxY[botBox1], 20);
              StdDraw.setPenColor(118,11,212);
              botBox1 -= 6;
              StdDraw.picture(boxX[botBox1], boxY[botBox1], "ghost.PNG");
            }
            else
            {
              w1++;
              continue;
            }
          }

          else if(choice.equalsIgnoreCase("s") && s1 == 0)
          {
            if(horizLines[bottom[botBox1]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox1], boxY[botBox1], 20);
              StdDraw.setPenColor(118,11,212);
              botBox1 += 6;
              StdDraw.picture(boxX[botBox1], boxY[botBox1], "ghost.PNG");
            }
            else
            {
              s1++;
              continue;
            }
          }

          else if(choice.equalsIgnoreCase("a") && a1 == 0)
          {
            if(vertLines[left[botBox1]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox1], boxY[botBox1], 20);
              StdDraw.setPenColor(118,11,212);
              botBox1 -= 1;
              StdDraw.picture(boxX[botBox1], boxY[botBox1], "ghost.PNG");
            }
            else
            {
              a1++;
              continue;
            }
          }

          else if(choice.equalsIgnoreCase("d") && d1 == 0)
          {
            if(vertLines[right[botBox1]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox1], boxY[botBox1], 20);
              StdDraw.setPenColor(118,11,212);
              botBox1 += 1;
              StdDraw.picture(boxX[botBox1], boxY[botBox1], "ghost.PNG");
            }
            else
            {
              d1++;
              continue;
            }
          }
        }
        while(false);
        StdDraw.show();

        if(botBox == currentBox || botBox1 == currentBox || botBox2 == currentBox)
        {
          dead++;
          break;
        }

        //deadly bot 3
        StdDraw.setPenColor(11,31,212);
        int w2=0, a2=0, s2=0, d2=0;
        int bot2;
        choice = "";
        do
        {
          bot2 = rng.nextInt(100) + 1;
          if(bot2 >= 75)
            choice = "w";
          else if(bot2 >= 50)
            choice = "s";
          else if(bot2 >= 25)
            choice = "a";
          else
            choice = "d";
          if(choice.equalsIgnoreCase("w") && w2 == 0)
          {
            if(horizLines[top[botBox2]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox2], boxY[botBox2], 20);
              StdDraw.setPenColor(11,31,212);
              botBox2 -= 6;
              StdDraw.picture(boxX[botBox2], boxY[botBox2], "ghost.PNG");
            }
            else
            {
              w2++;
              continue;
            }
          }

          else if(choice.equalsIgnoreCase("s") && s2 == 0)
          {
            if(horizLines[bottom[botBox2]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox2], boxY[botBox2], 20);
              StdDraw.setPenColor(11,31,212);
              botBox2 += 6;
              StdDraw.picture(boxX[botBox2], boxY[botBox2], "ghost.PNG");
            }
            else
            {
              s2++;
              continue;
            }
          }

          else if(choice.equalsIgnoreCase("a") && a2 == 0)
          {
            if(vertLines[left[botBox2]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox2], boxY[botBox2], 20);
              StdDraw.setPenColor(11,31,212);
              botBox2 -= 1;
              StdDraw.picture(boxX[botBox2], boxY[botBox2], "ghost.PNG");
            }
            else
            {
              a2++;
              continue;
            }
          }

          else if(choice.equalsIgnoreCase("d") && d2 == 0)
          {
            if(vertLines[right[botBox2]] == 0)
            {
              StdDraw.setPenColor(0,0,0);//
              StdDraw.filledCircle(boxX[botBox2], boxY[botBox2], 20);
              StdDraw.setPenColor(11,31,212);
              botBox2 += 1;
              StdDraw.picture(boxX[botBox2], boxY[botBox2], "ghost.PNG");
            }
            else
            {
              d2++;
              continue;
            }
          }
        }
        while(false);
        StdDraw.setPenColor(255,255,255);





        
        if(currentBox == target && t == 0)
        {
          targets++;
          t++;
        }
        if(!(t > 0))
        {
          StdDraw.picture(boxX[target], boxY[target], "sparkle.PNG");
        }

        if(currentBox == target1 && t1 == 0)
        {
          targets++;
          t1++;
        }
        if(!(t1 > 0))
        {
          StdDraw.picture(boxX[target1], boxY[target1], "sparkle.PNG");
        }

        if(currentBox == target2 && t2 == 0)
        {
          targets++;
          t2++;
        }
        if(!(t2 > 0))
        {
          StdDraw.picture(boxX[target2], boxY[target2], "sparkle.PNG");
        }





        if(currentBox == start && targets == 3)
        {
          break;
        }

        if(botBox == currentBox || botBox1 == currentBox || botBox2 == currentBox)
        {
          dead++;
          break;
        }
        StdDraw.circle(boxX[start], boxY[start], 18);//start
        StdDraw.text(boxX[start], boxY[start], "start");
      }
      StdDraw.show();
      StdDraw.disableDoubleBuffering();
      if(dead > 0)
      {
        StdDraw.picture(boxX[botBox], boxY[botBox], "ghost.PNG");
        StdDraw.picture(boxX[botBox1], boxY[botBox1], "ghost.PNG");
        StdDraw.picture(boxX[botBox2], boxY[botBox2], "ghost.PNG");
        Font font1 = new Font("DejaVu Serif", Font.BOLD, 55);
        StdDraw.setFont(font1);
        StdDraw.pause(1000);
        StdDraw.setPenColor(18,18,18);
        StdDraw.filledRectangle(150,150,150,150);
        StdDraw.setPenColor(112, 0, 6);
        StdDraw.text(150,150, "You Died");
        StdDraw.setPenColor(0,0,0);
        StdDraw.pause(3000);
      }
      else
      {
        
        StdDraw.picture(boxX[botBox], boxY[botBox], "ghost.PNG");
        StdDraw.picture(boxX[botBox1], boxY[botBox1], "ghost.PNG");
        StdDraw.picture(boxX[botBox2], boxY[botBox2], "ghost.PNG");
        Font font1 = new Font("Dialog", Font.BOLD, 20);
        StdDraw.setFont(font1);
        int winY = 300;
        StdDraw.pause(1000);
        StdDraw.setPenColor(0,0,0);
        StdDraw.filledRectangle(150,150,150,150);
        StdDraw.picture(45, 150,"terrain.PNG");
        StdDraw.picture(255, 150,"terrainflip.png");
        count = 0;
        while(winY > 0)
        {
          StdDraw.setPenColor(0,0,0);
          StdDraw.picture(150, winY, "player1.PNG");
          StdDraw.pause(25);
          StdDraw.filledCircle(150, winY, 20);
          winY -= 6;
          count++;
          if(count == 10)
          {
            StdDraw.setPenColor(9, 181, 49);
            StdDraw.text(250,250, "You Win!");
          }
        }
        StdDraw.setPenColor(0,0,0);
        StdDraw.pause(3000);
      }
      StdDraw.setPenColor(0,0,0);
    }
  }
}