package org.example.util;

import java.util.Scanner;

public class utility {

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

    public int lLong()
    {
        Long numero = S.nextInt();

        S.nextLine();

        return numero;
    }
}
