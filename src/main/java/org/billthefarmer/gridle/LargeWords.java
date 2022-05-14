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
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;

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

public class LargeWords
{
    private static char gridle[][];

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

        wordList = new ArrayList<String>(Arrays.asList(WORDS));
        wordList.addAll(Arrays.asList(MoreWords.WORDS));

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

        for (String word: wordList.toArray(new String[0]))
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

        gridle = new char[Large.SIZE][];

        for (String word: wordList.toArray(new String[0]))
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
            gridle[1] = new char[Large.SIZE];
            Arrays.fill(gridle[1], ' ');
            s = getWord(word.charAt(2));
            if (s == null)
                continue;

            gridle[2] = s.toCharArray();
            gridle[3] = new char[Large.SIZE];
            Arrays.fill(gridle[3], ' ');
            s = getWord(word.charAt(4));
            if (s == null)
                continue;

            gridle[4] = s.toCharArray();
            gridle[5] = new char[7];
            Arrays.fill(gridle[5], ' ');
            s = getWord(word.charAt(6));
            if (s == null)
                continue;
            gridle[6] = s.toCharArray();

            gridle[1][0] = word.charAt(1);
            gridle[3][0] = word.charAt(3);
            gridle[5][0] = word.charAt(5);

            word = getWord(gridle[0][2], gridle[2][2], gridle[4][2],
                           gridle[6][2]);
            if (word == null)
                continue;

            gridle[1][2] = word.charAt(1);
            gridle[3][2] = word.charAt(3);
            gridle[5][2] = word.charAt(5);

            word = getWord(gridle[0][4], gridle[2][4], gridle[4][4],
                           gridle[6][4]);
            if (word == null)
                continue;

            gridle[1][4] = word.charAt(1);
            gridle[3][4] = word.charAt(3);
            gridle[5][4] = word.charAt(5);

            word = getWord(gridle[0][6], gridle[2][6], gridle[4][6],
                           gridle[6][6]);
            if (word == null)
                continue;

            gridle[1][6] = word.charAt(1);
            gridle[3][6] = word.charAt(3);
            gridle[5][6] = word.charAt(5);

            return gridle;
        }

        return null;
    }

    // randomise
    private static void randomise(List<String> list)
    {
        int index = 0;
        for (String w: list.toArray(new String[0]))
        {
            int r = random.nextInt(list.size());
            list.set(index++, list.get(r));
            list.set(r, w);
        }
    }

    // randomise
    public static char[][] randomise(char gridle[][])
    {
        char puzzle[][] = new char[Large.SIZE][];
        for (int i = 0; i < Large.SIZE; i++)
            puzzle[i] = Arrays.copyOf(gridle[i], Large.SIZE);

        for (int row = 0; row < Large.SIZE; row++)
        {
            for (int col = 0; col < Large.SIZE; col++)
            {
                if ((puzzle[row][col] == ' ') ||
                    (row == 0 && col == 0) ||
                    (row == 0 && col == 6) ||
                    (row == 2 && col == 2) ||
                    (row == 2 && col == 4) ||
                    (row == 4 && col == 2) ||
                    (row == 4 && col == 4) ||
                    (row == 6 && col == 0) ||
                    (row == 6 && col == 6))
                    continue;

                int r = random.nextInt(Large.SIZE);
                int c = random.nextInt(Large.SIZE);

                while ((puzzle[r][c] == ' ') ||
                       (r == 0 && c == 0) ||
                       (r == 0 && c == 6) ||
                       (r == 2 && c == 2) ||
                       (r == 2 && c == 4) ||
                       (r == 4 && c == 2) ||
                       (r == 4 && c == 4) ||
                       (r == 6 && c == 0) ||
                       (r == 6 && c == 6))
                {
                    r = random.nextInt(Large.SIZE);
                    c = random.nextInt(Large.SIZE);
                }

                char ch = puzzle[row][col];
                puzzle[row][col] = puzzle[r][c];
                puzzle[r][c] = ch;
            }
        }

        return puzzle;
    }

    // getWord
    private static String getWord(char a, char b, char c, char d)
    {
        Iterator<String> iterator = getIterator(a);
        while (iterator.hasNext())
        {
            String word = iterator.next();
            if (usedSet.contains(word))
                continue;
            if (word.charAt(2) == b &&
                word.charAt(4) == c &&
                word.charAt(6) == d)
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

    // WordsTask
    public static class WordsTask
            extends AsyncTask<Void, char[][], char[][]>
    {
        private WeakReference<Large> largeWeakReference;

        // WordsTask
        public WordsTask(Large large)
        {
            largeWeakReference = new WeakReference<>(large);
        }

        // doInBackground
        @Override
        protected char[][] doInBackground(Void... params)
        {
            final Large large = largeWeakReference.get();
            if (large == null)
                return null;

            char gridle[][] = getGridle();
            while (gridle == null)
                gridle = getGridle();
            publishProgress(gridle);

            return randomise(gridle);
        }

        // onProgressUpdate
        protected void onProgressUpdate(char[][]... gridles)
        {
            final Large large = largeWeakReference.get();
            if (large == null)
                return;

            large.setGridle(gridles[0]);
        }

        // onPostExecute
        @Override
        protected void onPostExecute(char puzzle[][])
        {
            final Large large = largeWeakReference.get();
            if (large == null)
                return;

            large.setPuzzle(puzzle);
        }
    }

    public static final String WORDS[] =
    {
        "abandon", "abashed", "abashes", "abasing", "abating", "abdomen",
        "abducts", "abetted", "abettor", "abeyant", "abiding", "ability",
        "abjured", "abjures", "ablauts", "abolish", "aborted", "abounds",
        "abraded", "abrades", "abreast", "abridge", "abscess", "abscond",
        "absence", "absents", "absinth", "absolve", "absorbs", "abstain",
        "abusing", "abusive", "abysmal", "abysses", "acacias", "academy",
        "acceded", "accedes", "accents", "accepts", "acclaim", "accords",
        "accosts", "account", "accrete", "accrued", "accrues", "accurst",
        "accused", "accuser", "accuses", "acerbic", "acetate", "acetone",
        "achieve", "acidify", "acidity", "acolyte", "aconite", "acquire",
        "acquits", "acreage", "acrobat", "acronym", "acrylic", "actinic",
        "actions", "actress", "actuary", "actuate", "acutely", "adagios",
        "adamant", "adapted", "adapter", "addenda", "addicts", "addling",
        "address", "adduced", "adduces", "adeptly", "adhered", "adheres",
        "adipose", "adjoins", "adjourn", "adjudge", "adjunct", "adjured",
        "adjures", "adjusts", "admiral", "admired", "admirer", "admires",
        "admixed", "admixes", "adopted", "adorers", "adoring", "adorned",
        "adrenal", "adsorbs", "adulate", "advance", "adverbs", "adverse",
        "adverts", "advices", "advised", "adviser", "advises", "advisor",
        "aerated", "aerates", "aerator", "aerials", "aerobic", "aerosol",
        "affable", "affably", "affairs", "affects", "affirms", "affixed",
        "affixes", "afflict", "affords", "affrays", "affront", "against",
        "ageless", "agendas", "aggress", "agilely", "agility", "agitate",
        "agonies", "agonize", "aground", "aileron", "ailment", "aimless",
        "airbase", "airbeds", "aircrew", "airdrop", "airflow", "airguns",
        "airhole", "airiest", "airings", "airlane", "airless", "airlift",
        "airline", "airlock", "airmail", "airpark", "airport", "airship",
        "airsick", "airways", "aitches", "alarmed", "albinos", "albumen",
        "albumin", "alchemy", "alcohol", "alcoves", "alerted", "alertly",
        "alexics", "alfalfa", "alfredo", "algebra", "aliases", "alights",
        "aligned", "aliment", "alimony", "alkalis", "allayed", "alleged",
        "alleges", "allegro", "allergy", "alloted", "allowed", "alloyed",
        "alluded", "alludes", "allured", "allures", "alluvia", "allying",
        "almanac", "almonds", "almoner", "aloofly", "alpacas", "already",
        "alright", "altered", "alumnae", "alumnus", "alveoli", "alyssum",
        "amalgam", "amassed", "amasses", "amateur", "amatory", "amazing",
        "ambient", "ambling", "amended", "amenity", "amiable", "amiably",
        "ammeter", "ammonia", "amnesia", "amnesty", "amoebae", "amoebas",
        "amoebic", "amongst", "amorist", "amorous", "amounts", "amperes",
        "amphora", "amplest", "amplify", "ampoule", "amputee", "amulets",
        "amusing", "anaemia", "anaemic", "anagram", "analogy", "analyse",
        "analyst", "analyze", "anarchy", "anatomy", "anchors", "anchovy",
        "ancient", "andante", "andiron", "anemone", "aneroid", "angelic",
        "angelus", "angered", "anglers", "angling", "angoras", "angrier",
        "angrily", "anguish", "angular", "aniline", "animals", "animate",
        "animism", "animist", "anionic", "aniseed", "anklets", "anneals",
        "annexed", "annexes", "annoyed", "annuals", "annuity", "annular",
        "anodyne", "anoints", "anomaly", "anonyms", "anoraks", "another",
        "answers", "antacid", "anteing", "antenna", "anthems", "anthers",
        "anthill", "anthrax", "antigen", "antilog", "antique", "antlers",
        "antonym", "anxiety", "anxious", "anybody", "anymore", "anyroad",
        "anyways", "aphasia", "aphasic", "aphides", "apishly", "apogees",
        "apology", "apostle", "apparel", "appeals", "appears", "appease",
        "appends", "applaud", "applied", "applies", "appoint", "apposed",
        "apposes", "apprise", "approve", "apricot", "apropos", "aptness",
        "aquaria", "aquatic", "aquavit", "aqueous", "arbiter", "arbours",
        "arcades", "archaic", "archers", "archery", "arching", "archway",
        "arclike", "ardours", "arduous", "arguing", "aridity", "arigato",
        "arising", "armadas", "armband", "armfuls", "armhole", "armless",
        "armlets", "armload", "armoire", "armored", "armoury", "armpits",
        "arousal", "aroused", "arouses", "arraign", "arrange", "arrases",
        "arrayed", "arrears", "arrests", "arrival", "arrived", "arrives",
        "arrowed", "arsenal", "arsenic", "article", "artiest", "artisan",
        "artiste", "artists", "artless", "ascends", "ascents", "ascetic",
        "ascribe", "asepsis", "aseptic", "asexual", "ashamed", "ashbins",
        "ashcans", "ashiest", "ashtray", "asinine", "askance", "asocial",
        "aspects", "asperse", "asphalt", "aspired", "aspires", "aspirin",
        "assails", "assault", "assayed", "assayer", "assegai", "assents",
        "asserts", "asshole", "assigns", "assists", "assizes", "assorts",
        "assuage", "assumed", "assumes", "assured", "assures", "astound",
        "astride", "asunder", "asylums", "atavism", "atelier", "atheism",
        "atheist", "athirst", "athlete", "athwart", "atishoo", "atlases",
        "atomize", "atoning", "atrophy", "attaboy", "attache", "attacks",
        "attains", "attempt", "attends", "attests", "attired", "attires",
        "attorns", "attract", "attuned", "auction", "audible", "audibly",
        "audited", "auditor", "augment", "augured", "aunties", "aurally",
        "aureola", "aureole", "auricle", "aurorae", "auroras", "austere",
        "autarky", "authors", "automat", "autopsy", "autumns", "availed",
        "avarice", "avatars", "avenged", "avenger", "avenges", "avenues",
        "average", "averred", "averted", "aviator", "avidity", "avocado",
        "avocets", "avoided", "avowals", "avowing", "awaited", "awakens",
        "awaking", "awarded", "awesome", "awfully", "awkward", "awnings",
        "axially", "axolotl", "azaleas", "azimuth", "babbled", "babbler",
        "babbles", "baboons", "babying", "babyish", "bacilli", "backbit",
        "backers", "backing", "backlog", "backups", "badgers", "badness",
        "baffled", "baffles", "bagfuls", "baggage", "baggier", "bagging",
        "bagnios", "bagpipe", "bagsful", "bailees", "baileys", "bailiff",
        "bailing", "bailors", "baiting", "baklava", "balance", "balcony",
        "baldest", "balding", "baldric", "baleful", "balking", "ballade",
        "ballads", "ballast", "ballets", "balloon", "ballots", "balmier",
        "balsams", "bambino", "bamboos", "bananas", "bandage", "bandbox",
        "bandeau", "bandied", "bandier", "bandies", "banding", "bandits",
        "baneful", "bangers", "banging", "bangles", "banians", "bankers",
        "banking", "banners", "banning", "bannock", "banquet", "banshee",
        "bantams", "banters", "baobabs", "baptism", "baptize", "barbell",
        "barbels", "barbers", "bargain", "bargees", "barging", "barkeep",
        "barkers", "barking", "barmaid", "baronet", "baroque", "barrack",
        "barrage", "barrels", "barrier", "barring", "barrows", "barters",
        "bascule", "baseman", "bashful", "bashing", "baskets", "basking",
        "bassets", "bassoon", "bastard", "basting", "bastion", "batches",
        "bathers", "bathing", "bathtub", "batiste", "batsman", "batsmen",
        "battens", "batters", "battery", "battier", "batting", "battled",
        "battles", "battues", "baubles", "bauxite", "bawbees", "bawdier",
        "bawdily", "bawling", "bayonet", "bazaars", "bazooka", "beached",
        "beaches", "beacons", "beadier", "beading", "beadles", "beagles",
        "beakers", "beaming", "bearded", "bearers", "bearing", "bearish",
        "beastly", "beaters", "beatify", "beating", "beatnik", "beavers",
        "because", "beckons", "becomes", "bedaubs", "bedbugs", "bedding",
        "bedecks", "bedevil", "bedewed", "bedfast", "bedlams", "bedpans",
        "bedpost", "bedrock", "bedroom", "bedside", "bedsits", "bedsore",
        "bedtime", "beeches", "beefier", "beefing", "beehive", "beeline",
        "beerier", "beeswax", "beetled", "beetles", "befalls", "befouls",
        "beggars", "beggary", "begging", "begonia", "begorra", "begrime",
        "beguile", "behaved", "behaves", "beheads", "behests", "behinds",
        "beholds", "behoved", "behoves", "bejewel", "belated", "belayed",
        "belched", "belches", "beldame", "beliefs", "believe", "bellboy",
        "bellhop", "bellies", "bellman", "bellows", "belongs", "beloved",
        "belting", "beltway", "belying", "bemoans", "bemused", "bemuses",
        "benched", "bencher", "benches", "bending", "beneath", "benefit",
        "benzene", "benzine", "bequest", "berated", "berates", "bereave",
        "berries", "berserk", "berthed", "beseech", "beseems", "besides",
        "besiege", "besmear", "bespeak", "bespoke", "bestial", "besting",
        "bestirs", "bestows", "bestrew", "bestrid", "betaken", "betakes",
        "bethels", "bethink", "betimes", "betoken", "betrays", "betroth",
        "betters", "betting", "between", "betwixt", "beveled", "bewails",
        "bewitch", "bezique", "biassed", "biasses", "bibbing", "bickers",
        "bicycle", "bidders", "bidding", "biffing", "bifocal", "biggest",
        "bighead", "bigness", "bigoted", "bigotry", "bigwigs", "bikinis",
        "bilious", "bilking", "billets", "billies", "billing", "billion",
        "billows", "billowy", "biltong", "binders", "bindery", "binding",
        "biology", "biplane", "birched", "birches", "birdies", "biretta",
        "birthed", "biscuit", "bisects", "bishops", "bismuth", "bistros",
        "bitched", "bitches", "bittern", "bitters", "bittier", "bitumen",
        "bivalve", "bivouac", "bizarre", "bizonal", "blabbed", "blabber",
        "blacked", "blacken", "blacker", "blackly", "bladder", "blaming",
        "blander", "blandly", "blanker", "blanket", "blankly", "blaring",
        "blarney", "blasted", "blatant", "blather", "blazers", "blazing",
        "blazons", "bleaker", "bleakly", "bleated", "bleeder", "bleeped",
        "blemish", "blended", "blender", "blessed", "blesses", "blether",
        "blights", "blinded", "blinder", "blindly", "blinked", "blister",
        "blitzed", "blitzes", "bloated", "bloater", "blocked", "blonder",
        "blondes", "blooded", "bloomed", "bloomer", "blossom", "blotchy",
        "blotted", "blotter", "blouses", "blowers", "blowfly", "blowgun",
        "blowier", "blowing", "blowout", "blubber", "bluebag", "bluejay",
        "bluffed", "bluffer", "bluffly", "blunder", "blunted", "blunter",
        "bluntly", "blurred", "blurted", "blushed", "blushes", "bluster",
        "boarded", "boarder", "boasted", "boaster", "boaters", "boating",
        "boatman", "boatmen", "bobbies", "bobbing", "bobbins", "bobbles",
        "bobcats", "bobsled", "bobtail", "bodices", "bodings", "bodkins",
        "boffins", "bogeyed", "boggier", "boggled", "boggles", "boilers",
        "boiling", "boldest", "boleros", "bollard", "boloney", "bolster",
        "bolting", "bombard", "bombast", "bombers", "bombing", "bonanza",
        "bonbons", "bondage", "bonding", "bonfire", "boniest", "bonitos",
        "bonkers", "bonnets", "bonnier", "bonnily", "bonuses", "boobies",
        "boobing", "boodles", "boogies", "boohoos", "bookend", "bookers",
        "bookies", "booking", "bookish", "booklet", "booming", "boorish",
        "boosted", "booster", "bootees", "booting", "bootleg", "boozers",
        "boozier", "boozily", "boozing", "boppers", "bopping", "boracic",
        "borders", "boredom", "borough", "borrows", "borscht", "borstal",
        "borzois", "bossier", "bossing", "bossman", "botched", "botcher",
        "botches", "bothers", "bottled", "bottles", "bottoms", "boudoir",
        "boulder", "bounced", "bouncer", "bounces", "bounded", "bounden",
        "bounder", "bouquet", "bourbon", "bourses", "bovines", "bowlers",
        "bowlful", "bowline", "bowling", "bowsers", "bowshot", "bowwows",
        "boxcars", "boxfuls", "boxwood", "boycott", "boyhood", "bracing",
        "bracken", "bracket", "bradawl", "bragged", "braided", "braille",
        "brained", "braised", "braises", "braking", "bramble", "branchy",
        "branded", "brasher", "brashly", "brasses", "bravado", "bravely",
        "bravery", "bravest", "braving", "bravura", "brawled", "brawler",
        "braying", "brazier", "brazing", "breaded", "breadth", "breaker",
        "breakup", "breasts", "breathe", "breaths", "breathy", "breeder",
        "breezed", "breezes", "brevets", "brevity", "brewers", "brewery",
        "brewing", "bribers", "bribery", "bribing", "bridged", "bridges",
        "bridled", "bridles", "briefed", "briefer", "briefly", "brigade",
        "brigand", "brimful", "brimmed", "brindle", "brinier", "brioche",
        "brisker", "brisket", "briskly", "bristle", "bristly", "brittle",
        "broaden", "broader", "broadly", "brocade", "brogues", "broiled",
        "broiler", "brokers", "bromide", "bromine", "bronchi", "broncos",
        "bronzed", "bronzes", "brooded", "brooder", "brooked", "brothel",
        "brother", "brought", "browned", "browner", "brownie", "browsed",
        "browses", "bruised", "bruiser", "bruises", "brushed", "brushes",
        "brusque", "brutish", "bubbled", "bubbles", "buckets", "bucking",
        "buckled", "buckler", "buckles", "buckram", "bucolic", "buddies",
        "budding", "budgets", "budgies", "budging", "buffalo", "buffers",
        "buffets", "buffing", "buffoon", "bugaboo", "bugbear", "bugeyed",
        "buggers", "buggery", "buggies", "bugging", "buglers", "bugling",
        "bugrake", "builder", "buildup", "bulbous", "bulbuls", "bulgier",
        "bulgily", "bulging", "bulkier", "bulkily", "bulldog", "bullets",
        "bullied", "bullies", "bulling", "bullion", "bullish", "bullock",
        "bulrush", "bulwark", "bumbled", "bumbles", "bumboat", "bummers",
        "bumming", "bumpers", "bumpier", "bumpily", "bumping", "bumpkin",
        "bunched", "bunches", "bundled", "bundles", "bunging", "bungled",
        "bungler", "bungles", "bunions", "bunkers", "bunking", "bunnies",
        "bunters", "bunting", "buoyant", "buoying", "burbled", "burbles",
        "burdens", "burdock", "bureaus", "bureaux", "burette", "burgeon",
        "burgess", "burgher", "burglar", "burgled", "burgles", "burials",
        "burking", "burlier", "burners", "burning", "burnish", "burnous",
        "burping", "burring", "burrows", "bursars", "bursary", "burthen",
        "burtons", "burying", "busbies", "bushels", "bushier", "bushing",
        "busiest", "buskers", "busking", "bustard", "busting", "bustled",
        "bustles", "busying", "butcher", "butches", "butlers", "butters",
        "buttery", "butting", "buttock", "buttons", "buzzard", "buzzers",
        "buzzing", "bygones", "bypaths", "byroads", "bywords", "cabanas",
        "cabaret", "cabbage", "cabbies", "cabinet", "cabling", "caboose",
        "cachets", "caching", "cachous", "cackled", "cackler", "cackles",
        "cadaver", "caddied", "caddies", "caddish", "cadence", "cadenza",
        "cadgers", "cadging", "cadmium", "caesura", "caftans", "cagiest",
        "cagoule", "cahoots", "caimans", "caiques", "caisson", "cajoled",
        "cajoles", "calcify", "calcine", "calcium", "calculi", "calends",
        "caliber", "calibre", "caliper", "caliphs", "calking", "callboy",
        "callers", "calling", "callous", "calmest", "calming", "calomel",
        "caloric", "calorie", "calumny", "calving", "calyces", "calypso",
        "cambers", "cambric", "cameras", "camions", "campers", "camphor",
        "camping", "campion", "canapes", "canards", "canasta", "cancans",
        "cancels", "cancers", "candela", "candied", "candies", "candles",
        "candour", "canines", "cankers", "cannery", "cannier", "cannily",
        "canning", "cannons", "cantata", "canteen", "canters", "canting",
        "cantons", "cantors", "canvass", "canyons", "capable", "capably",
        "capered", "capital", "capping", "caprice", "capsize", "capstan",
        "capsule", "captain", "caption", "captive", "captors", "capture",
        "carabao", "carafes", "caramel", "caravan", "caraway", "carbide",
        "carbine", "carbons", "carboys", "carcass", "cardiac", "carding",
        "careens", "careers", "careful", "cargoes", "caribou", "carious",
        "carload", "carmine", "carnage", "carotid", "carouse", "carpals",
        "carpets", "carping", "carport", "carried", "carrier", "carries",
        "carrion", "carrots", "carroty", "carsick", "cartage", "cartels",
        "carting", "cartons", "cartoon", "carvers", "carving", "cascade",
        "cascara", "caseous", "cashews", "cashier", "cashing", "casings",
        "casinos", "caskets", "casques", "cassava", "cassock", "casters",
        "casting", "castled", "castles", "castoff", "casuals", "casuist",
        "catalog", "catalpa", "catarrh", "catcall", "catcher", "catches",
        "catchup", "catered", "caterer", "catfish", "cathode", "catkins",
        "catlike", "catnaps", "catsups", "cattier", "cattily", "cattish",
        "catwalk", "causing", "caustic", "cautery", "caution", "cavalry",
        "caveats", "caveman", "cavemen", "caverns", "cavorts", "cayenne",
        "ceasing", "cedilla", "ceiling", "cellars", "cellist", "cements",
        "censers", "censing", "censors", "censure", "centaur", "centavo",
        "centers", "centime", "central", "centred", "centres", "centric",
        "century", "ceramic", "cereals", "cerises", "certain", "certify",
        "cession", "cesspit", "chafers", "chaffed", "chafing", "chagrin",
        "chained", "chaired", "chaises", "chalets", "chalice", "chalked",
        "chamber", "chamois", "champed", "chanced", "chancel", "chances",
        "changed", "changes", "channel", "chanted", "chanter", "chantey",
        "chantry", "chaotic", "chapels", "chaplet", "chapped", "chapter",
        "charade", "charged", "charger", "charges", "charier", "charily",
        "chariot", "charity", "charmed", "charmer", "charnel", "charred",
        "charted", "charter", "chasers", "chasing", "chassis", "chasten",
        "chaster", "chateau", "chatted", "chattel", "chatter", "chawing",
        "cheapen", "cheaper", "cheaply", "cheated", "checked", "checker",
        "checkup", "cheddar", "cheeked", "cheeped", "cheered", "cheerio",
        "cheeses", "cheetah", "chemise", "chemist", "chequer", "cheques",
        "cherish", "cheroot", "cherubs", "chervil", "chevron", "chewing",
        "chicane", "chicken", "chicory", "chidden", "chiding", "chiefly",
        "chiffon", "chigger", "chignon", "chigoes", "chilled", "chiller",
        "chiming", "chimney", "chinked", "chinwag", "chipped", "chipper",
        "chirped", "chirrup", "chisels", "chivied", "chivies", "chloric",
        "chocked", "choicer", "choices", "chokers", "choking", "cholera",
        "chomped", "chooses", "chopped", "chopper", "chorale", "chorine",
        "chortle", "chowder", "chromed", "chromic", "chronic", "chucked",
        "chuckle", "chugged", "chukkas", "chukker", "chummed", "churned",
        "chutney", "cicadas", "cicalas", "cinched", "cinches", "cinders",
        "cinemas", "ciphers", "circled", "circles", "circlet", "circuit",
        "cirques", "cistern", "citadel", "citizen", "citrons", "citrous",
        "civilly", "civvies", "clacked", "claimed", "clamber", "clammed",
        "clamors", "clamour", "clamped", "clanged", "clanger", "clanked",
        "clapped", "clapper", "claques", "clarify", "clarion", "clarity",
        "clashed", "clashes", "clasped", "classed", "classes", "classic",
        "clatter", "clauses", "clawing", "cleaned", "cleaner", "cleanly",
        "cleanse", "cleanup", "cleared", "clearer", "clearly", "cleaved",
        "cleaver", "cleaves", "clement", "clerics", "clerked", "clewing",
        "cliched", "cliches", "clicked", "clients", "climate", "climbed",
        "climber", "clinics", "clinked", "clinker", "clipped", "clipper",
        "clippie", "cliques", "cliquey", "cloaked", "clobber", "cloches",
        "clocked", "clogged", "clopped", "closely", "closest", "closets",
        "closeup", "closing", "closure", "clothed", "clothes", "clotted",
        "cloture", "clouded", "clouted", "clovers", "clowned", "cloying",
        "clubbed", "clucked", "clumped", "clunked", "cluster", "clutter",
        "coached", "coaches", "coaling", "coaming", "coarsen", "coarser",
        "coastal", "coasted", "coaster", "coatees", "coating", "coaxial",
        "coaxing", "cobbled", "cobbler", "cobbles", "cobwebs", "cocaine",
        "cochlea", "cockade", "cockers", "cockier", "cocking", "cockles",
        "cockpit", "coconut", "cocoons", "cocotte", "codding", "coddled",
        "coddles", "codeine", "codfish", "codgers", "codices", "codicil",
        "codling", "codlins", "coequal", "coerced", "coerces", "coevals",
        "coexist", "coffees", "coffers", "coffins", "cogency", "cognacs",
        "cognate", "cognize", "cohabit", "cohered", "coheres", "cohorts",
        "coiling", "coinage", "coiners", "coining", "coition", "coldest",
        "colicky", "colitis", "collage", "collars", "collate", "collect",
        "colleen", "college", "collide", "collier", "collies", "collude",
        "cologne", "colonel", "colored", "colossi", "colours", "coltish",
        "columns", "combats", "combers", "combine", "combing", "combust",
        "comfier", "comfits", "comfort", "comfrey", "comical", "comings",
        "command", "commend", "comment", "commies", "commits", "commode",
        "commons", "commune", "commute", "compact", "company", "compare",
        "compass", "compeer", "compels", "compere", "compete", "compile",
        "complex", "comport", "compose", "compost", "compote", "compute",
        "comrade", "concave", "conceal", "concede", "conceit", "concept",
        "concern", "concert", "conches", "concise", "concoct", "concord",
        "concurs", "concuss", "condemn", "condign", "condoms", "condone",
        "condors", "conduct", "conduit", "confabs", "confers", "confess",
        "confide", "confine", "confirm", "conform", "confuse", "confute",
        "congeal", "congers", "congest", "conical", "conifer", "conjoin",
        "conjure", "conkers", "conking", "connect", "conning", "connive",
        "connote", "conquer", "consent", "consign", "consist", "console",
        "consols", "consort", "consuls", "consult", "consume", "contact",
        "contain", "contemn", "contend", "content", "contest", "context",
        "contort", "contour", "control", "contuse", "convene", "convent",
        "convert", "conveys", "convict", "convoke", "convoys", "cookers",
        "cookery", "cookies", "cooking", "cookout", "coolant", "coolers",
        "coolest", "coolies", "cooling", "coolish", "coopers", "copecks",
        "copiers", "copilot", "copings", "copious", "coppers", "coppery",
        "coppice", "copping", "copulas", "copyboy", "copycat", "copying",
        "copyist", "coracle", "corbels", "cordage", "cordial", "cording",
        "cordite", "cordons", "corkage", "corkers", "corking", "corncob",
        "corneal", "corneas", "corners", "cornets", "cornice", "cornier",
        "corning", "corolla", "coronae", "coronas", "coroner", "coronet",
        "corpora", "corpses", "corrals", "correct", "corries", "corrode",
        "corrupt", "corsage", "corsair", "corsets", "cortege", "corvees",
        "coshing", "cosiest", "cosines", "cossets", "costard", "costers",
        "costing", "costive", "costume", "coterie", "cottage", "cottars",
        "couched", "couches", "cougars", "coughed", "couldst", "coulomb",
        "coulter", "council", "counsel", "counted", "counter", "country",
        "coupled", "coupler", "couples", "couplet", "coupons", "courage",
        "courier", "coursed", "courser", "courses", "courted", "courtly",
        "cousins", "couture", "covered", "coverts", "coveted", "cowards",
        "cowbell", "cowbird", "cowboys", "cowered", "cowgirl", "cowhand",
        "cowheel", "cowherd", "cowhide", "cowlick", "cowling", "cowpats",
        "cowries", "cowshed", "cowskin", "cowslip", "coxcomb", "coyness",
        "coyotes", "crabbed", "cracked", "cracker", "crackle", "crackup",
        "cradled", "cradles", "crafted", "crafter", "cragged", "crammed",
        "crammer", "cramped", "crampon", "cranial", "craning", "cranium",
        "cranked", "crapped", "crashed", "crasher", "crashes", "crassly",
        "craters", "crating", "cravats", "cravens", "craving", "crawled",
        "crawler", "crayons", "crazier", "crazily", "crazing", "creaked",
        "creamed", "creamer", "creased", "creases", "created", "creates",
        "creator", "creches", "credits", "creedal", "creeper", "cremate",
        "creoles", "crested", "cretins", "crevice", "crewing", "crewman",
        "crewmen", "cribbed", "cricked", "cricket", "criming", "crimped",
        "crimson", "cringed", "cringes", "crinkle", "crinkly", "crinoid",
        "cripple", "crisped", "crisper", "crisply", "critics", "critter",
        "croaked", "crochet", "crocked", "crofter", "cronies", "crooked",
        "crooned", "crooner", "cropped", "cropper", "croquet", "crosier",
        "crossed", "crosser", "crosses", "crossly", "crouton", "crowbar",
        "crowded", "crowing", "crowned", "crucial", "crucify", "crudely",
        "crudest", "crudity", "cruelly", "cruelty", "cruised", "cruiser",
        "cruises", "crumble", "crumbly", "crumpet", "crumple", "crunchy",
        "crupper", "crusade", "crushed", "crusher", "crushes", "crusted",
        "crybaby", "cryptic", "crystal", "cubical", "cubicle", "cubists",
        "cuckold", "cuckoos", "cuddled", "cuddles", "cudgels", "cuffing",
        "cuirass", "cuisine", "culling", "culotte", "culprit", "cultist",
        "culture", "culvert", "cumbers", "cumulus", "cunning", "cupcake",
        "cupfuls", "cupolas", "cupping", "curable", "curably", "curacao",
        "curacoa", "curates", "curator", "curbing", "curdled", "curdles",
        "curette", "curfews", "curious", "curlers", "curlews", "curlier",
        "curling", "currant", "current", "curried", "curries", "currish",
        "cursing", "cursive", "cursory", "curtail", "curtain", "curtest",
        "curving", "cushier", "cushion", "cussing", "custard", "custody",
        "customs", "cutaway", "cutback", "cuticle", "cutlass", "cutlers",
        "cutlery", "cutlets", "cutouts", "cutters", "cutting", "cuttles",
        "cutworm", "cyanide", "cycling", "cyclist", "cyclone", "cygnets",
        "cymbals", "cynical", "cypress", "czarina", "dabbing", "dabbled",
        "dabbler", "dabbles", "dacoits", "dacoity", "dactyls", "daddies",
        "daemons", "daftest", "daggers", "dahlias", "dailies", "dairies",
        "daisies", "dallied", "dallies", "damaged", "damages", "damming",
        "damning", "dampens", "dampers", "dampest", "damping", "dampish",
        "damsels", "damsons", "dancers", "dancing", "dandier", "dandies",
        "dandify", "dandily", "dandled", "dandles", "dangers", "dangled",
        "dangles", "dankest", "daphnes", "dappled", "dapples", "daresay",
        "darkens", "darkest", "darkies", "darling", "darning", "darting",
        "dashing", "datable", "datives", "daubers", "daubing", "daunted",
        "dauphin", "dawdled", "dawdler", "dawdles", "dawning", "dayboys",
        "daygirl", "dayroom", "daytime", "dazedly", "dazzled", "dazzles",
        "deacons", "deadens", "deadpan", "deafens", "deafest", "dealers",
        "dealing", "deanery", "dearest", "dearies", "deathly", "debacle",
        "debarks", "debased", "debases", "debated", "debater", "debates",
        "debauch", "debited", "deboned", "debones", "debouch", "debrief",
        "debtors", "debunks", "debuted", "decades", "decamps", "decants",
        "decayed", "decease", "deceits", "deceive", "decency", "decibel",
        "decided", "decides", "decimal", "decking", "deckles", "declaim",
        "declare", "decline", "decoded", "decoder", "decodes", "decoked",
        "decokes", "decorum", "decoyed", "decreed", "decrees", "decried",
        "decries", "deduced", "deduces", "deducts", "deeming", "deepens",
        "deepest", "defaced", "defaces", "defamed", "defames", "default",
        "defeats", "defects", "defence", "defends", "defense", "defiant",
        "deficit", "defiled", "defiler", "defiles", "defined", "defines",
        "deflate", "deflect", "deforms", "defraud", "defrays", "defrock",
        "defrost", "deftest", "defunct", "defused", "defuses", "defying",
        "degauss", "degrade", "degrees", "dehorns", "deified", "deifies",
        "deigned", "deities", "dejects", "delayed", "deleted", "deletes",
        "delight", "delimit", "deliver", "delouse", "deltoid", "deluded",
        "deludes", "deluged", "deluges", "delving", "demands", "demeans",
        "dements", "demerit", "demesne", "demigod", "demists", "demonic",
        "demoted", "demotes", "demotic", "denials", "denizen", "denoted",
        "denotes", "densely", "densest", "density", "dentals", "denting",
        "dentist", "denture", "denuded", "denudes", "denying", "deodars",
        "departs", "depends", "depicts", "deplane", "deplete", "deplore",
        "deploys", "deports", "deposed", "deposes", "deposit", "deprave",
        "depress", "deprive", "deputed", "deputes", "derails", "derange",
        "derated", "derates", "derbies", "derided", "derides", "derived",
        "derives", "derrick", "dervish", "desalts", "descale", "descant",
        "descend", "descent", "deserts", "deserve", "designs", "desired",
        "desires", "desists", "despair", "despise", "despite", "despoil",
        "despond", "despots", "dessert", "destine", "destiny", "destroy",
        "details", "detains", "detects", "detente", "detests", "detours",
        "detract", "detrain", "devalue", "develop", "deviant", "deviate",
        "devices", "devilry", "devious", "devised", "devisee", "devises",
        "devoted", "devotee", "devours", "dewdrop", "dewiest", "dewlaps",
        "dewpond", "diadems", "diagram", "dialect", "dialing", "dialled",
        "diamond", "diapers", "diarchy", "diaries", "diarist", "diatoms",
        "dibbers", "dibbing", "dibbled", "dibbles", "diciest", "dickers",
        "dickier", "dickies", "dictate", "diction", "dictums", "diddled",
        "diddles", "diehard", "diesels", "dietary", "dieting", "differs",
        "diffuse", "digests", "diggers", "digging", "digital", "dignify",
        "dignity", "digraph", "digress", "dilated", "dilates", "dilemma",
        "diluted", "dilutes", "dimmest", "dimming", "dimness", "dimpled",
        "dimples", "dimwits", "dingier", "dingily", "dingles", "dingoes",
        "dinkier", "dinners", "dinning", "diocese", "dioxide", "diploma",
        "dipoles", "dippers", "dipping", "diptych", "directs", "direful",
        "dirndls", "dirtied", "dirtier", "dirties", "dirtily", "disable",
        "disarms", "disavow", "disband", "disbars", "disbuds", "discard",
        "discern", "discord", "discuss", "disdain", "disease", "disgust",
        "dishful", "dishier", "dishing", "dishorn", "disking", "dislike",
        "dismast", "dismays", "dismiss", "disobey", "disowns", "dispels",
        "display", "disport", "dispose", "dispute", "disrobe", "disrupt",
        "dissect", "dissent", "distaff", "distant", "distend", "distils",
        "distort", "disturb", "disused", "ditched", "ditches", "dithers",
        "ditties", "diurnal", "diverge", "diverse", "diverts", "divided",
        "divider", "divides", "divined", "diviner", "divines", "divisor",
        "divorce", "divulge", "divvied", "divvies", "dizzied", "dizzier",
        "dizzies", "dizzily", "dobbins", "dockers", "dockets", "docking",
        "doctors", "dodders", "doddery", "doddles", "dodgems", "dodgier",
        "dodging", "doeskin", "doffing", "dogcart", "dogfish", "doggies",
        "dogging", "doggone", "doglegs", "dogtrot", "dogwood", "doilies",
        "doleful", "dollars", "dollies", "dollops", "dolmens", "dolphin",
        "doltish", "domains", "dominie", "donated", "donates", "donjons",
        "donkeys", "donning", "donnish", "doodled", "doodles", "dooming",
        "doorman", "doormat", "doormen", "doorway", "dopiest", "dormant",
        "dormers", "dormice", "dosages", "dossers", "dossier", "dotards",
        "dottier", "dotting", "doubled", "doubles", "doublet", "doubted",
        "doubter", "douches", "doughty", "dourest", "dousing", "dovecot",
        "dowager", "dowdier", "dowdily", "dowered", "downers", "downier",
        "downing", "dowries", "dowsers", "dowsing", "doyenne", "doziest",
        "drabber", "drachma", "drachms", "drafted", "draftee", "dragged",
        "draggle", "dragnet", "dragons", "dragoon", "drained", "drapers",
        "drapery", "draping", "drastic", "dratted", "draught", "drawers",
        "drawing", "drawled", "dreaded", "dreamed", "dreamer", "dredged",
        "dredger", "dredges", "dressed", "dresser", "dresses", "dribble",
        "driblet", "drifted", "drifter", "drilled", "drinker", "dripped",
        "drivels", "drivers", "driving", "drizzle", "drizzly", "drogues",
        "droller", "droning", "drooled", "drooped", "droplet", "dropout",
        "dropped", "dropper", "droshky", "drought", "drovers", "drowned",
        "drowsed", "drowses", "drubbed", "drudged", "drudges", "drugged",
        "drugget", "drummed", "drummer", "drunken", "drunker", "dryness",
        "drywall", "dualism", "dubbing", "dubbins", "dubiety", "dubious",
        "duchess", "duchies", "ducking", "ductile", "dudgeon", "dueling",
        "duelled", "dueller", "duennas", "duffers", "dugongs", "dugouts",
        "dukedom", "dullard", "dullest", "dulling", "dumbest", "dumdums",
        "dummies", "dumpers", "dumpier", "dumping", "dungeon", "dunking",
        "dunnest", "dunning", "duodena", "durable", "durably", "durbars",
        "duskier", "dustbin", "dusters", "dustier", "dusting", "dustman",
        "dustmen", "dustpan", "dustups", "duteous", "dutiful", "dwarfed",
        "dwelled", "dweller", "dwindle", "dynamic", "dynamos", "dynasts",
        "dynasty", "eagerer", "eagerly", "eaglets", "earache", "eardrop",
        "eardrum", "earldom", "earlier", "earlobe", "earmark", "earmuff",
        "earners", "earnest", "earning", "earplug", "earring", "earshot",
        "earthed", "earthen", "earthly", "earwigs", "easiest", "eastern",
        "eatable", "ebbtide", "ebonite", "echelon", "echoing", "eclairs",
        "eclipse", "eclogue", "ecology", "economy", "ecstasy", "eddying",
        "edgiest", "edgings", "edibles", "edifice", "edified", "edifies",
        "editing", "edition", "editors", "educate", "educing", "eeriest",
        "effaced", "effaces", "effects", "effendi", "efforts", "effused",
        "effuses", "eggcups", "egghead", "egoists", "egotism", "egotist",
        "egotrip", "eidetic", "eighths", "ejected", "ejector", "elapsed",
        "elapses", "elastic", "elating", "elation", "elbowed", "elderly",
        "elected", "elector", "elegant", "elegiac", "elegies", "element",
        "elevate", "elevens", "elicits", "eliding", "elision", "elitism",
        "elitist", "elixirs", "ellipse", "eloping", "eluding", "elusion",
        "elusive", "elusory", "embalms", "embanks", "embargo", "embarks",
        "embassy", "emblems", "embrace", "embroil", "embryos", "emended",
        "emerald", "emerged", "emerges", "emetics", "emigres", "eminent",
        "emirate", "emitted", "emoting", "emotion", "emotive", "empanel",
        "empathy", "emperor", "empires", "empiric", "emplane", "employs",
        "emporia", "empower", "empress", "emptied", "emptier", "empties",
        "emptily", "emulate", "emulous", "enabled", "enables", "enacted",
        "enamels", "enamour", "encamps", "encased", "encases", "enchain",
        "enchant", "enclave", "enclose", "encoded", "encodes", "encomia",
        "encored", "encores", "encrust", "endemic", "endgame", "endings",
        "endives", "endless", "endorse", "endowed", "enduing", "endured",
        "endures", "endways", "endwise", "enemies", "enfolds", "enforce",
        "engaged", "engages", "engines", "engraft", "engrave", "engross",
        "engulfs", "enhance", "enigmas", "enjoins", "enjoyed", "enlarge",
        "enlists", "enliven", "ennoble", "enounce", "enplane", "enraged",
        "enrages", "enroled", "ensigns", "ensiled", "ensiles", "enslave",
        "ensnare", "ensuing", "ensured", "ensures", "entails", "entente",
        "entered", "enteric", "enthral", "enthuse", "enticed", "entices",
        "entitle", "entombs", "entrain", "entrant", "entraps", "entreat",
        "entrees", "entries", "entropy", "entrust", "entwine", "envelop",
        "envenom", "envious", "environ", "envying", "enwraps", "enzymes",
        "epaulet", "epicure", "epigram", "episode", "epistle", "epitaph",
        "epithet", "epitome", "eponyms", "epsilon", "equable", "equably",
        "equally", "equated", "equates", "equator", "equerry", "equines",
        "equinox", "erasers", "erasing", "erasure", "erected", "erectly",
        "eremite", "ermines", "eroding", "erosion", "erosive", "erotica",
        "errands", "erratic", "erratum", "erudite", "erupted", "escaped",
        "escapee", "escapes", "escarps", "escheat", "eschews", "escorts",
        "escudos", "espouse", "espying", "esquire", "essayed", "essence",
        "estates", "esteems", "estuary", "etchers", "etching", "eternal",
        "ethanol", "ethical", "eugenic", "eunuchs", "euphony", "evacuee",
        "evading", "evangel", "evasion", "evasive", "evening", "evicted",
        "evident", "eviller", "evinced", "evinces", "evoking", "evolved",
        "evolves", "exacted", "exactly", "exalted", "examine", "example",
        "exceeds", "excepts", "excerpt", "excised", "excises", "excited",
        "excites", "exclaim", "exclude", "excreta", "excrete", "excused",
        "excuses", "execute", "exempts", "exerted", "exhaled", "exhales",
        "exhaust", "exhibit", "exhorts", "exhumed", "exhumes", "exigent",
        "exiling", "existed", "exiting", "exogamy", "expands", "expanse",
        "expects", "expends", "expense", "experts", "expiate", "expired",
        "expires", "explain", "explode", "exploit", "explore", "exports",
        "exposed", "exposes", "expound", "express", "expunge", "extends",
        "extinct", "extract", "extreme", "extrude", "exuding", "exulted",
        "eyeball", "eyebath", "eyebrow", "eyecups", "eyedrop", "eyefuls",
        "eyelash", "eyeless", "eyelets", "eyelids", "eyeshot", "eyesore",
        "eyewash", "fabrics", "facaded", "facades", "facials", "facings",
        "faction", "factors", "factory", "factual", "faculty", "faddier",
        "faddily", "faddish", "fadeout", "faeries", "fagging", "faggots",
        "faience", "failing", "failure", "fainted", "fainter", "faintly",
        "fairest", "fairies", "fairish", "fairway", "falcons", "fallacy",
        "falling", "falloff", "fallout", "falsely", "falsies", "falsify",
        "falsity", "falters", "famines", "fanatic", "fancied", "fancier",
        "fancies", "fancily", "fanfare", "fannies", "fanning", "fantasy",
        "faraway", "farmers", "farming", "farrago", "farrier", "farrows",
        "farther", "farting", "fascias", "fascism", "fascist", "fashion",
        "fastens", "fastest", "fasting", "fatally", "fateful", "fathead",
        "fathers", "fathoms", "fatigue", "fatless", "fatness", "fattens",
        "fattest", "fattier", "fatties", "fatting", "fattish", "fatuity",
        "fatuous", "faucets", "faulted", "favored", "favorer", "favours",
        "fawning", "fearful", "fearing", "feasted", "feather", "feature",
        "febrile", "federal", "feebler", "feedbag", "feeders", "feeding",
        "feelers", "feeling", "feigned", "feinted", "felines", "felling",
        "fellows", "felspar", "felucca", "females", "femoral", "fencers",
        "fencing", "fenders", "ferment", "fernier", "ferrets", "ferried",
        "ferries", "ferrous", "ferrule", "fertile", "ferules", "fervent",
        "fervors", "fervour", "festers", "festive", "festoon", "fetched",
        "fetches", "fetlock", "fetters", "feuding", "fevered", "fewness",
        "fiancee", "fiances", "fiascos", "fibbers", "fibbing", "fibrous",
        "fibulas", "fiction", "fictive", "fiddled", "fiddler", "fiddles",
        "fidgets", "fidgety", "fiefdom", "fielded", "fielder", "fiercer",
        "fierier", "fierily", "fiestas", "fifteen", "fifthly", "fifties",
        "fighter", "figment", "figural", "figured", "figures", "filbert",
        "filched", "filches", "filings", "fillets", "fillies", "filling",
        "fillips", "filmdom", "filmier", "filming", "filters", "finable",
        "finales", "finally", "finance", "finches", "finders", "finding",
        "finesse", "fingers", "finical", "finicky", "finnans", "firearm",
        "firebox", "firebug", "firedog", "firefly", "fireman", "firemen",
        "firkins", "firmest", "firming", "firstly", "firtree", "fiscals",
        "fishers", "fishery", "fishier", "fishing", "fissile", "fission",
        "fissure", "fistula", "fitment", "fitness", "fitters", "fittest",
        "fitting", "fixated", "fixates", "fixedly", "fixture", "fizzier",
        "fizzing", "fizzled", "fizzles", "flaccid", "flagged", "flagons",
        "flailed", "flakier", "flaking", "flaming", "flanges", "flanked",
        "flannel", "flapped", "flapper", "flaring", "flashed", "flasher",
        "flashes", "flatcar", "flatlet", "flatten", "flatter", "flattop",
        "flaunts", "flavors", "flavour", "flawing", "flaying", "fleabag",
        "fleapit", "flecked", "fledged", "fledges", "fleeced", "fleeces",
        "fleeing", "fleeted", "fleeter", "fleetly", "fleshly", "flexing",
        "flicked", "flicker", "flights", "flighty", "flipped", "flipper",
        "flirted", "flitted", "flivver", "floated", "floater", "flocked",
        "flogged", "flooded", "floored", "flopped", "florins", "florist",
        "flotsam", "flounce", "floured", "flouted", "flowers", "flowery",
        "flowing", "flubbed", "fluency", "fluffed", "flukier", "flummox",
        "flunked", "flunkey", "flushed", "flushes", "fluster", "fluting",
        "flutist", "flutter", "fluvial", "flyaway", "flyblew", "flyblow",
        "flyleaf", "flyover", "flypast", "foaling", "foamier", "foaming",
        "focally", "focused", "focuses", "fogbank", "foggier", "foggily",
        "fogging", "foghorn", "foglamp", "foibles", "foiling", "folders",
        "folding", "foliage", "foliate", "folkway", "follies", "follows",
        "foments", "fondant", "fondest", "fondled", "fondles", "fondues",
        "foolery", "fooling", "foolish", "footage", "footers", "footing",
        "footled", "footles", "footman", "footmen", "footpad", "footsie",
        "foppish", "foraged", "forages", "forayed", "forbade", "forbear",
        "forbids", "forbore", "forceps", "forcing", "fording", "forearm",
        "foreign", "foreleg", "foreman", "foremen", "foresaw", "foresee",
        "forests", "foretop", "forever", "forfeit", "forgave", "forgers",
        "forgery", "forgets", "forging", "forgive", "forgoes", "forgone",
        "forkful", "forking", "forlorn", "formats", "forming", "formula",
        "forsake", "forsook", "forties", "fortify", "fortune", "forward",
        "forwent", "fossils", "fosters", "foulest", "fouling", "founded",
        "founder", "foundry", "fourths", "fowlers", "fowling", "foxhole",
        "foxhunt", "foxiest", "foxtrot", "fragile", "frailer", "frailty",
        "framing", "franked", "franker", "frankly", "frantic", "fraught",
        "fraying", "frazzle", "freaked", "freckle", "freebie", "freedom",
        "freeing", "freeman", "freemen", "freesia", "freeway", "freezer",
        "freezes", "freight", "frescos", "freshen", "fresher", "freshet",
        "freshly", "fretful", "fretsaw", "fretted", "friable", "fridges",
        "friends", "friezes", "frigate", "frights", "frilled", "fringed",
        "fringes", "frisked", "frisson", "fritter", "frivols", "frizzed",
        "frizzes", "frizzle", "frogged", "frogman", "frogmen", "frolics",
        "frontal", "fronted", "frosted", "frothed", "frowned", "frowsts",
        "frowsty", "fruited", "fuchsia", "fuckers", "fucking", "fuddled",
        "fuddles", "fudging", "fuelled", "fuggier", "fuhrers", "fulcrum",
        "fulfill", "fulfils", "fullers", "fullest", "fulling", "fulmars",
        "fulsome", "fumbled", "fumbler", "fumbles", "funding", "funeral",
        "funfair", "fungoid", "fungous", "funkier", "funking", "funnels",
        "funnier", "funnies", "funnily", "furbish", "furious", "furling",
        "furlong", "furnace", "furnish", "furrier", "furring", "furrows",
        "further", "furtive", "fusions", "fussier", "fussily", "fussing",
        "fusspot", "fustian", "fustier", "futures", "fuzzier", "fuzzily",
        "gabbled", "gabbles", "gadgets", "gaffers", "gaffing", "gagging",
        "gaggles", "gainers", "gainful", "gaining", "gainsay", "gaiters",
        "gallant", "galleon", "gallery", "galleys", "galling", "gallons",
        "gallops", "gallows", "galumph", "gambits", "gambled", "gambler",
        "gambles", "gamboge", "gambols", "gamiest", "gammons", "ganders",
        "gangers", "ganglia", "gangway", "gannets", "garaged", "garages",
        "garbage", "garbing", "garbled", "garbles", "gardens", "gargled",
        "gargles", "garland", "garment", "garners", "garnets", "garnish",
        "garrets", "garters", "gasbags", "gaseous", "gashing", "gaskets",
        "gasmask", "gasping", "gassier", "gassing", "gastric", "gateaux",
        "gateway", "gathers", "gauchos", "gaudier", "gaudies", "gaudily",
        "gauging", "gaunter", "gauzier", "gavotte", "gawkier", "gawking",
        "gawping", "gayness", "gazebos", "gazelle", "gazette", "gazumps",
        "gearbox", "gearing", "geezers", "geishas", "gelatin", "gelding",
        "gelling", "gemlike", "genders", "general", "generic", "genesis",
        "genetic", "genital", "genteel", "gentian", "gentile", "gentler",
        "genuine", "geology", "germane", "gerunds", "gestalt", "gesture",
        "getaway", "getting", "gewgaws", "geysers", "ghastly", "gherkin",
        "ghettos", "ghosted", "ghostly", "gibbers", "gibbets", "gibbons",
        "gibbous", "giblets", "giddier", "giddily", "gifting", "giggled",
        "giggles", "gigolos", "gilders", "gilding", "gillies", "gimbals",
        "gimlets", "gimmick", "gingham", "ginmill", "ginning", "ginseng",
        "gipsies", "giraffe", "girders", "girding", "girdled", "girdles",
        "girlish", "gizzard", "glacial", "glacier", "gladden", "gladder",
        "glamour", "glanced", "glances", "glaring", "glasses", "glazier",
        "glazing", "gleamed", "gleaned", "gleaner", "gleeful", "glibber",
        "gliders", "gliding", "glimmer", "glimpse", "glinted", "glisten",
        "glister", "glitter", "gloated", "globule", "glories", "glorify",
        "glossed", "glosses", "glottal", "glottis", "glowers", "glowing",
        "glucose", "glueing", "gluiest", "glummer", "glutted", "glutton",
        "gnarled", "gnashed", "gnashes", "gnawing", "gnocchi", "goading",
        "goalies", "goatees", "gobbets", "gobbled", "gobbler", "gobbles",
        "goblets", "goblins", "goddess", "godhead", "godless", "godlier",
        "godlike", "godowns", "godsend", "godsons", "goggled", "goggles",
        "golfers", "golfing", "gollies", "gondola", "gonging", "goobers",
        "goodbye", "goodies", "goodish", "goofier", "goofing", "gooiest",
        "goosing", "gophers", "gorging", "gorgons", "goriest", "gorilla",
        "gormand", "gosling", "gospels", "gossips", "gossipy", "gouache",
        "gouging", "goulash", "gourmet", "goutier", "governs", "gowning",
        "grabbed", "grabber", "gracias", "gracing", "grading", "gradual",
        "grafted", "grafter", "grammar", "grampus", "granary", "grandad",
        "grandee", "grander", "grandly", "grandma", "grandpa", "granges",
        "granite", "granted", "granule", "graphed", "graphic", "grapnel",
        "grapple", "grasped", "grassed", "grasses", "graters", "gratify",
        "grating", "gravels", "gravely", "gravest", "gravity", "gravure",
        "graying", "grazier", "grazing", "greased", "greaser", "greases",
        "greater", "greatly", "greaves", "greener", "greenly", "greeted",
        "gremlin", "grenade", "greyest", "greying", "greyish", "griddle",
        "grieved", "grieves", "griffin", "griffon", "grilled", "grilles",
        "grimace", "grimier", "griming", "grimmer", "grinder", "gringos",
        "grinned", "gripers", "griping", "gripped", "gristle", "gristly",
        "grizzle", "grizzly", "groaned", "grocers", "grocery", "groined",
        "groomed", "grooved", "groover", "grooves", "groping", "grossed",
        "grosser", "grosses", "grossly", "grouchy", "grounds", "grouped",
        "groupie", "groused", "grouses", "grovels", "growers", "growing",
        "growled", "growler", "growths", "groynes", "grubbed", "grudged",
        "grudges", "gruffer", "gruffly", "grumble", "grunted", "guarded",
        "gudgeon", "guessed", "guesses", "guested", "guffaws", "guiding",
        "guilder", "guineas", "guipure", "guitars", "gulches", "guldens",
        "gullets", "gullies", "gulling", "gulping", "gumboil", "gumboot",
        "gumdrop", "gummier", "gumming", "gumshoe", "gunboat", "gundogs",
        "gunfire", "gunners", "gunnery", "gunning", "gunplay", "gunroom",
        "gunshot", "gunwale", "guppies", "gurgled", "gurgles", "gushers",
        "gushier", "gushily", "gushing", "gussets", "gustier", "gutless",
        "gutsier", "gutters", "gutting", "guvnors", "guzzled", "guzzler",
        "guzzles", "gymnast", "gymslip", "gypping", "gypsies", "gyrated",
        "gyrates", "habitat", "habited", "habitue", "hackers", "hacking",
        "hackles", "hackney", "hacksaw", "haddock", "haggard", "haggled",
        "haggles", "hailing", "haircut", "hairdos", "hairier", "hairnet",
        "hairpin", "halberd", "halcyon", "halfway", "halibut", "halloos",
        "hallows", "hallway", "halters", "halting", "halving", "halyard",
        "hamlets", "hammers", "hamming", "hammock", "hampers", "hamster",
        "handbag", "handful", "handgun", "handier", "handily", "handing",
        "handled", "handler", "handles", "handout", "handsaw", "hangars",
        "hangdog", "hangers", "hanging", "hangman", "hangmen", "hangout",
        "hangups", "hankies", "hansoms", "hapless", "happens", "happier",
        "happily", "harbors", "harbour", "hardens", "hardest", "hardier",
        "hardtop", "harelip", "haricot", "harking", "harlots", "harmful",
        "harming", "harmony", "harness", "harpers", "harpies", "harping",
        "harpist", "harpoon", "harried", "harrier", "harries", "harrows",
        "harsher", "harshly", "hartals", "harvest", "hashing", "hashish",
        "hassled", "hassles", "hassock", "hastens", "hastier", "hastily",
        "hatband", "hatched", "hatches", "hatchet", "hateful", "hatfuls",
        "hatless", "hatpins", "hatreds", "hatters", "hauberk", "haughty",
        "haulage", "haulers", "haulier", "hauling", "haunted", "hautboy",
        "hauteur", "havered", "hawkers", "hawking", "hawkish", "hawsers",
        "haycock", "hayfork", "hayrick", "haywire", "hazards", "haziest",
        "headers", "headier", "heading", "headman", "headmen", "headset",
        "headway", "healers", "healing", "healthy", "heaping", "hearers",
        "hearing", "hearken", "hearsay", "hearses", "hearten", "hearths",
        "heaters", "heathen", "heather", "heating", "heavens", "heavier",
        "heavies", "heavily", "heaving", "heckled", "heckler", "heckles",
        "hectare", "hectors", "hedging", "heedful", "heeding", "heehaws",
        "heeling", "heftier", "heftily", "heifers", "heighho", "heights",
        "heinous", "heiress", "hellcat", "hellish", "helmets", "helpers",
        "helpful", "helping", "hemline", "hemlock", "hemming", "henbane",
        "hennaed", "hepatic", "heralds", "herbage", "herding", "heretic",
        "hermits", "hernias", "heroics", "heroine", "heroism", "heronry",
        "herring", "herself", "hexagon", "hibachi", "hiccups", "hickory",
        "hideous", "hideout", "hidings", "highboy", "highest", "highway",
        "hijacks", "hillier", "hillock", "himself", "hinders", "hinging",
        "hinting", "hipbath", "hipline", "hippies", "hipster", "hirsute",
        "hissing", "history", "hitched", "hitches", "hitless", "hitters",
        "hitting", "hoarded", "hoarder", "hoarier", "hoarser", "hoaxers",
        "hoaxing", "hobbies", "hobbled", "hobbles", "hobnail", "hobnobs",
        "hocking", "hogging", "hoggish", "hogwash", "hoisted", "holdall",
        "holders", "holding", "holdups", "holiday", "holiest", "hollers",
        "holloas", "hollows", "holster", "homburg", "homerun", "homiest",
        "homonym", "honesty", "honeyed", "honkies", "honking", "honored",
        "honoree", "honours", "hooding", "hoodlum", "hoodoos", "hookahs",
        "hookers", "hooking", "hookups", "hooping", "hoorays", "hooters",
        "hooting", "hoovers", "hopeful", "hoppers", "hopping", "horizon",
        "hormone", "hornets", "hornier", "horrify", "horrors", "horsier",
        "hosanna", "hosiers", "hosiery", "hospice", "hostage", "hostels",
        "hostess", "hostile", "hosting", "hostler", "hotbeds", "hotdogs",
        "hotfoot", "hothead", "hotpots", "hottest", "hounded", "housing",
        "hovered", "hoverer", "howdahs", "however", "howlers", "howling",
        "hoydens", "hubbies", "hubcaps", "huddled", "huddles", "huffier",
        "huffily", "huffing", "huffish", "hugging", "hulking", "hulling",
        "humanly", "humbled", "humbler", "humbles", "humbugs", "humdrum",
        "humerus", "humidor", "humming", "hummock", "humours", "humping",
        "hunched", "hunches", "hundred", "hungers", "hunkers", "hunters",
        "hunting", "hurdled", "hurdler", "hurdles", "hurlers", "hurling",
        "hurrahs", "hurrays", "hurried", "hurries", "hurtful", "hurting",
        "hurtled", "hurtles", "husband", "hushing", "huskier", "huskies",
        "huskily", "husking", "hussars", "hussies", "hustled", "hustler",
        "hustles", "hutches", "hutment", "hutting", "huzzahs", "hybrids",
        "hydrant", "hydrate", "hydride", "hygiene", "hymnals", "hymning",
        "hyphens", "iambics", "iceberg", "iceboat", "icecaps", "icecube",
        "icefall", "icefloe", "icefree", "icepack", "icepick", "icerink",
        "icicles", "ideally", "idiotic", "idolize", "idyllic", "igneous",
        "ignited", "ignites", "ignoble", "ignobly", "ignored", "ignores",
        "iguanas", "illegal", "illicit", "illness", "illumed", "illumes",
        "imagery", "imagine", "imaging", "imbibed", "imbibes", "imitate",
        "immense", "immerse", "immoral", "immured", "immures", "impacts",
        "impairs", "impalas", "impaled", "impales", "imparts", "impasse",
        "impeach", "impeded", "impedes", "impends", "imperil", "impetus",
        "impiety", "impinge", "impious", "implant", "implied", "implies",
        "implode", "implore", "imports", "imposed", "imposes", "impound",
        "impress", "imprint", "improve", "impugns", "impulse", "inanely",
        "inanity", "inaptly", "inboard", "inbound", "inbreed", "inbuilt",
        "incense", "inching", "incised", "incises", "incisor", "incited",
        "incites", "incline", "include", "incomes", "incubus", "indents",
        "indexed", "indexer", "indexes", "indices", "indicts", "indoors",
        "indrawn", "induced", "induces", "inducts", "indulge", "indwell",
        "indwelt", "ineptly", "inertia", "inertly", "inexact", "infancy",
        "infants", "infarct", "infects", "inferno", "infests", "infidel",
        "infield", "inflame", "inflate", "inflect", "inflict", "inflows",
        "informs", "infract", "infused", "infuses", "ingenue", "ingests",
        "ingoing", "ingrain", "ingress", "ingrown", "inhabit", "inhaled",
        "inhaler", "inhales", "inherit", "inhibit", "inhuman", "initial",
        "injects", "injured", "injures", "inkiest", "inkling", "inkpads",
        "inkpots", "inkwell", "inmates", "innards", "innings", "inquest",
        "inquiet", "inquire", "inquiry", "inroads", "insects", "inserts",
        "inshore", "insider", "insides", "insight", "insipid", "insists",
        "insofar", "insoles", "inspans", "inspect", "inspire", "install",
        "instant", "instate", "instead", "insteps", "instils", "insular",
        "insulin", "insults", "insured", "insurer", "insures", "integer",
        "intends", "intense", "intents", "interim", "interns", "intoned",
        "intones", "introit", "intrude", "intuits", "invaded", "invader",
        "invades", "invalid", "invents", "inverse", "inverts", "invests",
        "invited", "invites", "invoice", "invoked", "invokes", "involve",
        "inwards", "iodized", "iodizes", "ionized", "ionizes", "irately",
        "iridium", "irksome", "ironies", "ironing", "islands", "isobars",
        "isolate", "isotope", "issuing", "isthmus", "italics", "itchier",
        "itching", "itemize", "iterate", "ivories", "jabbers", "jabbing",
        "jackals", "jackass", "jackdaw", "jackets", "jackpot", "jaggier",
        "jagging", "jaguars", "jailers", "jailing", "jammier", "jamming",
        "jangled", "jangles", "janitor", "jarfuls", "jarring", "jasmine",
        "jaunted", "javelin", "jawbone", "jaywalk", "jazzier", "jazzily",
        "jazzing", "jealous", "jeepers", "jeering", "jellaba", "jellied",
        "jellies", "jemmied", "jemmies", "jennies", "jerboas", "jerkier",
        "jerkily", "jerking", "jerkins", "jerries", "jerseys", "jesters",
        "jesting", "jetties", "jetting", "jeweled", "jeweler", "jewelry",
        "jibbing", "jiggers", "jigging", "jiggled", "jiggles", "jigsaws",
        "jilting", "jimjams", "jimmied", "jimmies", "jingled", "jingles",
        "jinxing", "jitneys", "jitters", "jittery", "jobbers", "jobbery",
        "jobbing", "jobless", "jockeys", "jocular", "joggers", "jogging",
        "joggled", "joggles", "joiners", "joinery", "joining", "jointed",
        "jointly", "jollied", "jollier", "jollies", "jollify", "jollily",
        "jollity", "joltier", "jolting", "jonquil", "joshing", "jostled",
        "jostles", "jotters", "jotting", "journal", "journey", "jousted",
        "jowlier", "joyless", "joyride", "jubilee", "judders", "judging",
        "jugfuls", "jugging", "juggled", "juggler", "juggles", "jugular",
        "juicier", "juicing", "jujitsu", "jujubes", "jukebox", "jumbled",
        "jumbles", "jumpers", "jumpier", "jumpily", "jumping", "jungles",
        "juniors", "juniper", "junkets", "junkies", "junking", "jurists",
        "juryman", "jurymen", "justice", "justify", "jutting", "kaffirs",
        "kaisers", "kampong", "katydid", "keenest", "keening", "keepers",
        "keeping", "kelvins", "kennels", "kenning", "kernels", "kestrel",
        "ketches", "ketchup", "kettles", "keyhole", "keyless", "keynote",
        "kibbutz", "kickers", "kicking", "kickoff", "kidders", "kiddies",
        "kidding", "kidnaps", "kidneys", "killers", "killing", "killjoy",
        "kiloton", "kimonos", "kindest", "kindled", "kindles", "kindred",
        "kinetic", "kinfolk", "kingcup", "kingdom", "kingpin", "kinkier",
        "kinking", "kinship", "kinsman", "kinsmen", "kippers", "kipping",
        "kirtles", "kissers", "kissing", "kitchen", "kitschy", "kittens",
        "kitties", "klaxons", "knacker", "knapped", "knavery", "knavish",
        "kneaded", "kneecap", "kneeing", "kneeled", "knifing", "knights",
        "knitted", "knitter", "knobble", "knobbly", "knocked", "knocker",
        "knotted", "knoweth", "knowing", "knuckle", "kotowed", "kowtows",
        "krisses", "kumquat", "kwachas", "laagers", "labeled", "labials",
        "labored", "laborer", "labours", "laciest", "lackeys", "lacking",
        "laconic", "lacquer", "lactate", "lactose", "lacunae", "lacunas",
        "ladders", "laddies", "ladling", "ladybug", "laggard", "lagging",
        "lagoons", "laicize", "lambast", "lambent", "lambing", "lambkin",
        "laments", "lamming", "lampoon", "lamprey", "lancers", "lancets",
        "lancing", "landaus", "landing", "languid", "languor", "langurs",
        "lankier", "lankily", "lanolin", "lantern", "lanyard", "lapdogs",
        "lapping", "lapsing", "lapwing", "larceny", "larches", "larders",
        "larding", "largely", "largest", "lariats", "larrups", "lasagna",
        "lascars", "lashing", "lassies", "lassoed", "lassoes", "lasting",
        "latched", "latches", "latency", "lateral", "lathers", "lathery",
        "latrine", "lattice", "lauding", "laughed", "launder", "laundry",
        "laurels", "lawless", "lawsuit", "lawyers", "laxness", "layered",
        "layette", "layoffs", "layover", "lazaret", "laziest", "leached",
        "leaches", "leaders", "leading", "leafage", "leafier", "leafing",
        "leaflet", "leagued", "leagues", "leakage", "leakier", "leakily",
        "leaking", "leanest", "leaning", "leaping", "learned", "learner",
        "leashes", "leasing", "leather", "leavens", "leaving", "lechers",
        "lechery", "leching", "lectern", "lecture", "ledgers", "leeches",
        "leerier", "leering", "leeward", "leftist", "legally", "legatee",
        "legates", "legends", "leggier", "legging", "leghorn", "legible",
        "legibly", "legions", "legless", "legroom", "legumes", "leisure",
        "lemming", "lenders", "lending", "lengths", "lengthy", "lenient",
        "lentils", "leonine", "leopard", "leotard", "leprosy", "leprous",
        "lesbian", "lesions", "lessees", "lessens", "lessons", "lessors",
        "letdown", "letters", "letting", "lettuce", "levants", "leveled",
        "levered", "leveret", "levying", "lewdest", "lexical", "lexicon",
        "liaised", "liaises", "liaison", "libbers", "liberal", "liberty",
        "libidos", "library", "licence", "license", "licitly", "licking",
        "lidless", "liftboy", "lifters", "lifting", "liftman", "liftmen",
        "ligated", "ligates", "lighted", "lighten", "lighter", "lightly",
        "lignite", "likable", "likened", "lilting", "limbers", "limeade",
        "limiest", "limited", "limning", "limpets", "limping", "linctus",
        "lindens", "lineage", "lineman", "linemen", "lineout", "lingams",
        "lingers", "lingoes", "lingual", "linings", "linkage", "linkboy",
        "linking", "linkman", "linkmen", "linkups", "linnets", "linocut",
        "linseed", "lintels", "lioness", "lionize", "liquefy", "liqueur",
        "liquids", "liquors", "lisping", "listens", "listing", "literal",
        "lithely", "lithium", "litotes", "litters", "littler", "liturgy",
        "livable", "lividly", "livings", "lizards", "loaders", "loading",
        "loafers", "loafing", "loamier", "loaning", "loathed", "loathes",
        "loathly", "lobbied", "lobbies", "lobbing", "lobster", "lobular",
        "lobules", "locales", "locally", "located", "locates", "lockers",
        "lockets", "locking", "lockjaw", "locknut", "lockout", "lockups",
        "locusts", "lodgers", "lodging", "loftier", "loftily", "lofting",
        "logbook", "loggers", "loggias", "logging", "logical", "logjams",
        "loiters", "lollies", "lolling", "lollops", "longbow", "longest",
        "longhop", "longing", "longish", "longrun", "loofahs", "lookers",
        "looking", "lookout", "looming", "loonier", "loonies", "loopier",
        "looping", "loosely", "loosens", "loosest", "loosing", "looters",
        "looting", "lopping", "loquats", "lorries", "lotions", "lottery",
        "lotuses", "loudest", "lounged", "lounger", "lounges", "louring",
        "lousier", "loutish", "louvred", "louvres", "lovable", "lowborn",
        "lowbred", "lowbrow", "lowdown", "lowered", "lowland", "lowlier",
        "lowness", "loyally", "loyalty", "lozenge", "lubbers", "lucerne",
        "lucidly", "luckier", "luckily", "luffing", "luggage", "luggers",
        "lugging", "lughole", "lugsail", "lullaby", "lulling", "lumbago",
        "lumbers", "lumpier", "lumping", "lumpish", "lunatic", "lunched",
        "lunches", "lunging", "lurched", "lurcher", "lurches", "lurgies",
        "luridly", "lurking", "lushest", "lustful", "lustier", "lustily",
        "lyceums", "lychees", "lynched", "lynches", "lyrical", "macabre",
    };
}
