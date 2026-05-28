package org.example.util;

import java.util.List;
import java.util.Scanner;

public class Utility {

    private Scanner S = new Scanner(System.in);

    public String lString ()
    {
        return S.nextLine();
    }

    public int lInt ()
    {
        int numero = S.nextInt();

        S.nextLine();

        return numero;
    }

    public Long lLong()
    {
        Long numero = S.nextLong();

        S.nextLine();

        return numero;
    }

    public double  lDouble()
    {
        double numero = S.nextDouble();

        S.nextLine();

        return numero;
    }

    public void delay(int time) {
        try
        {
            Thread.sleep(time);
        }catch(InterruptedException e)
        {
            System.err.println("Erro no Delay !");
        }
    }

    public void cls (int lines)
    {
        for(int i = 0;i < lines; i++)
        {
            System.out.println();
        }
    }

    public boolean isValid (List list, long id)
    {
        for(List list : list.getId)   
    }
}
