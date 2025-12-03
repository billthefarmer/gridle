////////////////////////////////////////////////////////////////////////////////
//
//  Gridle - An android word game.
//
//  Copyright (C) 2022	Bill Farmer
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
//  Bill Farmer	 william j farmer [at] yahoo [dot] co [dot] uk.
//
///////////////////////////////////////////////////////////////////////////////

package org.billthefarmer.gridle;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Words
{

    public static final String WORDS_FILE      = "Words.txt";
    public static final String ENGLISH_FILE    = "English.txt";
    public static final String ITALIAN_FILE    = "Italian.txt";
    public static final String SPANISH_FILE    = "Spanish.txt";
    public static final String CATALAN_FILE    = "Catalan.txt";
    public static final String FRENCH_FILE     = "French.txt";
    public static final String PORTUGUESE_FILE = "Portuguese.txt";
    public static final String GERMAN_FILE     = "German.txt";
    public static final String DUTCH_FILE      = "Dutch.txt";
    public static final String AFRIKAANS_FILE  = "Afrikaans.txt";
    public static final String SWEDISH_FILE    = "Swedish.txt";

    private static char gridle[][];

    private static List<String> words;
    private static List<String> wordList;

    private static List<String> aList;
    private static List<String> bList;
    private static List<String> cList;
    private static List<String> dList;
    private static List<String> eList;
    private static List<String> fList;
    private static List<String> gList;
    private static List<String> hList;
    private static List<String> iList;
    private static List<String> jList;
    private static List<String> kList;
    private static List<String> lList;
    private static List<String> mList;
    private static List<String> nList;
    private static List<String> oList;
    private static List<String> pList;
    private static List<String> qList;
    private static List<String> rList;
    private static List<String> sList;
    private static List<String> tList;
    private static List<String> uList;
    private static List<String> vList;
    private static List<String> wList;
    private static List<String> xList;
    private static List<String> yList;
    private static List<String> zList;

    private static Iterator<String> aIterator;
    private static Iterator<String> bIterator;
    private static Iterator<String> cIterator;
    private static Iterator<String> dIterator;
    private static Iterator<String> eIterator;
    private static Iterator<String> fIterator;
    private static Iterator<String> gIterator;
    private static Iterator<String> hIterator;
    private static Iterator<String> iIterator;
    private static Iterator<String> jIterator;
    private static Iterator<String> kIterator;
    private static Iterator<String> lIterator;
    private static Iterator<String> mIterator;
    private static Iterator<String> nIterator;
    private static Iterator<String> oIterator;
    private static Iterator<String> pIterator;
    private static Iterator<String> qIterator;
    private static Iterator<String> rIterator;
    private static Iterator<String> sIterator;
    private static Iterator<String> tIterator;
    private static Iterator<String> uIterator;
    private static Iterator<String> vIterator;
    private static Iterator<String> wIterator;
    private static Iterator<String> xIterator;
    private static Iterator<String> yIterator;
    private static Iterator<String> zIterator;

    private static Set<String> usedSet;

    private static Random random;

    // getGridle
    public static char[][] getGridle()
    {
        if (random == null)
            random = new Random(new Date().getTime());

        wordList = new ArrayList<String>(words);

        randomise(wordList);

        aList = new ArrayList<String>();
        bList = new ArrayList<String>();
        cList = new ArrayList<String>();
        dList = new ArrayList<String>();
        eList = new ArrayList<String>();
        fList = new ArrayList<String>();
        gList = new ArrayList<String>();
        hList = new ArrayList<String>();
        iList = new ArrayList<String>();
        jList = new ArrayList<String>();
        kList = new ArrayList<String>();
        lList = new ArrayList<String>();
        mList = new ArrayList<String>();
        nList = new ArrayList<String>();
        oList = new ArrayList<String>();
        pList = new ArrayList<String>();
        qList = new ArrayList<String>();
        rList = new ArrayList<String>();
        sList = new ArrayList<String>();
        tList = new ArrayList<String>();
        uList = new ArrayList<String>();
        vList = new ArrayList<String>();
        wList = new ArrayList<String>();
        xList = new ArrayList<String>();
        yList = new ArrayList<String>();
        zList = new ArrayList<String>();

        for (String word: wordList)
        {
            switch (word.charAt(0))
            {
            case 'a': aList.add(word); break;
            case 'b': bList.add(word); break;
            case 'c': cList.add(word); break;
            case 'd': dList.add(word); break;
            case 'e': eList.add(word); break;
            case 'f': fList.add(word); break;
            case 'g': gList.add(word); break;
            case 'h': hList.add(word); break;
            case 'i': iList.add(word); break;
            case 'j': jList.add(word); break;
            case 'k': kList.add(word); break;
            case 'l': lList.add(word); break;
            case 'm': mList.add(word); break;
            case 'n': nList.add(word); break;
            case 'o': oList.add(word); break;
            case 'p': pList.add(word); break;
            case 'q': qList.add(word); break;
            case 'r': rList.add(word); break;
            case 's': sList.add(word); break;
            case 't': tList.add(word); break;
            case 'u': uList.add(word); break;
            case 'v': vList.add(word); break;
            case 'w': wList.add(word); break;
            case 'x': xList.add(word); break;
            case 'y': yList.add(word); break;
            case 'z': zList.add(word); break;
            }
        }

        gridle = new char[Gridle.SIZE][];

        for (String word: wordList)
        {
            aIterator = aList.iterator();
            bIterator = bList.iterator();
            cIterator = cList.iterator();
            dIterator = dList.iterator();
            eIterator = eList.iterator();
            fIterator = fList.iterator();
            gIterator = gList.iterator();
            hIterator = hList.iterator();
            iIterator = iList.iterator();
            jIterator = jList.iterator();
            kIterator = kList.iterator();
            lIterator = lList.iterator();
            mIterator = mList.iterator();
            nIterator = nList.iterator();
            oIterator = oList.iterator();
            pIterator = pList.iterator();
            qIterator = qList.iterator();
            rIterator = rList.iterator();
            sIterator = sList.iterator();
            tIterator = tList.iterator();
            uIterator = uList.iterator();
            vIterator = vList.iterator();
            wIterator = wList.iterator();
            xIterator = xList.iterator();
            yIterator = yList.iterator();
            zIterator = zList.iterator();

            usedSet = new HashSet<String>();
            usedSet.add(word);

            String s = getWord(word.charAt(0));
            if (s == null)
                continue;

            gridle[0] = s.toCharArray();
            gridle[1] = new char[Gridle.SIZE];
            Arrays.fill(gridle[1], ' ');
            s = getWord(word.charAt(2));
            if (s == null)
                continue;

            gridle[2] = s.toCharArray();
            gridle[3] = new char[Gridle.SIZE];
            Arrays.fill(gridle[3], ' ');
            s = getWord(word.charAt(4));
            if (s == null)
                continue;

            gridle[4] = s.toCharArray();

            gridle[1][0] = word.charAt(1);
            gridle[3][0] = word.charAt(3);

            word = getWord(gridle[0][2], gridle[2][2], gridle[4][2]);
            if (word == null)
                continue;

            gridle[1][2] = word.charAt(1);
            gridle[3][2] = word.charAt(3);

            word = getWord(gridle[0][4], gridle[2][4], gridle[4][4]);
            if (word == null)
                continue;

            gridle[1][4] = word.charAt(1);
            gridle[3][4] = word.charAt(3);

            return gridle;
        }

        return null;
    }

    // randomise
    private static void randomise(List<String> list)
    {
        int index = 0;
        for (String w: list)
        {
            int r = random.nextInt(list.size());
            list.set(index++, list.get(r));
            list.set(r, w);
        }
    }

    // randomise
    public static char[][] randomise(char gridle[][])
    {
        char puzzle[][] = new char[Gridle.SIZE][];
        for (int i = 0; i < Gridle.SIZE; i++)
            puzzle[i] = Arrays.copyOf(gridle[i], Gridle.SIZE);

        for (int row = 0; row < Gridle.SIZE; row++)
        {
            for (int col = 0; col < Gridle.SIZE; col++)
            {
                if ((puzzle[row][col] == ' ') ||
                    (row == 0 && col == 0) ||
                    (row == 0 && col == 4) ||
                    (row == 2 && col == 2) ||
                    (row == 4 && col == 0) ||
                    (row == 4 && col == 4))
                    continue;

                int r = random.nextInt(Gridle.SIZE);
                int c = random.nextInt(Gridle.SIZE);

                while ((puzzle[row][col] == gridle[r][c]) ||
                       (puzzle[r][c] == ' ') ||
                       (r == 0 && c == 0) ||
                       (r == 0 && c == 4) ||
                       (r == 2 && c == 2) ||
                       (r == 4 && c == 0) ||
                       (r == 4 && c == 4))
                {
                    r = random.nextInt(Gridle.SIZE);
                    c = random.nextInt(Gridle.SIZE);
                }

                char ch = puzzle[row][col];
                puzzle[row][col] = puzzle[r][c];
                puzzle[r][c] = ch;
            }
        }

        return puzzle;
    }

    // getWord
    private static String getWord(char a, char b, char c)
    {
        Iterator<String> iterator = getIterator(a);
        while (iterator.hasNext())
        {
            String word = iterator.next();
            if (usedSet.contains(word))
                continue;
            if (word.charAt(2) == b &&
                word.charAt(4) == c)
            {
                usedSet.add(word);
                return word;
            }
        }

        return null;
    }

    // getWord
    private static String getWord(char c)
    {
        Iterator<String> iterator = getIterator(c);
        while (iterator.hasNext())
        {
            String word = iterator.next();
            if (usedSet.contains(word))
                continue;

            usedSet.add(word);
            return word;
        }

        return null;
    }

    // getIterator
    private static Iterator<String> getIterator(char c)
    {
        switch (c)
        {
        case 'a': return aIterator;
        case 'b': return bIterator;
        case 'c': return cIterator;
        case 'd': return dIterator;
        case 'e': return eIterator;
        case 'f': return fIterator;
        case 'g': return gIterator;
        case 'h': return hIterator;
        case 'i': return iIterator;
        case 'j': return jIterator;
        case 'k': return kIterator;
        case 'l': return lIterator;
        case 'm': return mIterator;
        case 'n': return nIterator;
        case 'o': return oIterator;
        case 'p': return pIterator;
        case 'q': return qIterator;
        case 'r': return rIterator;
        case 's': return sIterator;
        case 't': return tIterator;
        case 'u': return uIterator;
        case 'v': return vIterator;
        case 'w': return wIterator;
        case 'x': return xIterator;
        case 'y': return yIterator;
        case 'z': return zIterator;
        }

        return null;
    }

    public static void setLanguage(Context context, int l)
    {
        words = new ArrayList<String>();

        switch (l)
        {
        default:
        case Gridle.ENGLISH:
            readWords(context, WORDS_FILE, words);
            break;

        case Gridle.ITALIAN:
            readWords(context, ITALIAN_FILE, words);
            break;

        case Gridle.SPANISH:
            readWords(context, SPANISH_FILE, words);
            break;

        case Gridle.CATALAN:
            readWords(context, CATALAN_FILE, words);
            break;

        case Gridle.FRENCH:
            readWords(context, FRENCH_FILE, words);
            break;

        case Gridle.PORTUGUESE:
            readWords(context, PORTUGUESE_FILE, words);
            break;

        case Gridle.GERMAN:
            readWords(context, GERMAN_FILE, words);
            break;

        case Gridle.DUTCH:
            readWords(context, DUTCH_FILE, words);
            break;

        case Gridle.AFRIKAANS:
            readWords(context, AFRIKAANS_FILE, words);
            break;

        case Gridle.SWEDISH:
            readWords(context, SWEDISH_FILE, words);
            break;
        }
    }

    // readWords
    private static void readWords(Context context, String file,
                                  Collection<String> collection)
    {
        try (BufferedReader reader = new BufferedReader
             (new InputStreamReader(context.getAssets().open(file))))
        {
            String line;
            while ((line = reader.readLine()) != null)
                collection.add(line);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
