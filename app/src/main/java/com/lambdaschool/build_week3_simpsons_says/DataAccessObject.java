package com.lambdaschool.build_week3_simpsons_says;

import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class DataAccessObject {

    /* ENDPOINTS
    Post to /register
    Params: Username and password

    Post to /login
    Params: Username and password

    Get to /favorites
    You will retrieve all these from the db and put them in array for sending out, but not for returning to user
    Header should provide username from auth unless you want this done different

    Post to /favorites
    Params: an id number to add to the users favorites
    header should provide username from auth unless you want this done different

    Post to /search
    Params: a string to search
    This should be behind an auth header

    (THIS PART IS STRETCH DON'T WORRY ABOUT THIS UNTIL THE END)
    Post to /generator
    params: a string to pass on
    This should be behind an auth header*/
    public ArrayList<Quote> getData() {
        ArrayList<Quote> quoteArrayList = new ArrayList<>();
        String[] mockDataStringArray = mockData.split("\n");
        for (int i = 0; i < mockDataStringArray.length; ++i) {
            if (mockDataStringArray[i].contains(", ")) {
                mockDataStringArray[i] = mockDataStringArray[i].replace(", ", " ");
            }
            String[] eachLine = mockDataStringArray[i].split(",");
                Quote quote = new Quote(Integer.parseInt(eachLine[0]), eachLine[7], eachLine[9]);
                quoteArrayList.add(quote);

        }
        return quoteArrayList;

/*        new Thread(new Runnable() {
            @Override
            public void run() {
                String contents = NetworkAdapter.fileParse(Environment.getDataDirectory().getPath(), "simpsons_quotes_paired.csv");
            }
        }).start();*/
    }

    private String mockData = "0,32,209,\"Miss Hoover: No, actually, it was a little of both. Sometimes when a disease is in all the magazines and all the news shows, it's only natural that you think you have it.\",TRUE,464,3,Miss Hoover,Springfield Elementary School,\"No, actually, it was a little of both. Sometimes when a disease is in all the magazines and all the news shows, it's only natural that you think you have it.\"\n" +
            "1,32,210,Lisa Simpson: (NEAR TEARS) Where's Mr. Bergstrom?,TRUE,9,3,Lisa Simpson,Springfield Elementary School,Where's Mr. Bergstrom?\n" +
            "2,32,211,Miss Hoover: I don't know. Although I'd sure like to talk to him. He didn't touch my lesson plan. What did he teach you?,TRUE,464,3,Miss Hoover,Springfield Elementary School,I don't know. Although I'd sure like to talk to him. He didn't touch my lesson plan. What did he teach you?\n" +
            "3,32,212,Lisa Simpson: That life is worth living.,TRUE,9,3,Lisa Simpson,Springfield Elementary School,That life is worth living.\n" +
            "4,32,213,\"Edna Krabappel-Flanders: The polls will be open from now until the end of recess. Now, (SOUR) just in case any of you have decided to put any thought into this, we'll have our final statements. Martin?\",TRUE,40,3,Edna Krabappel-Flanders,Springfield Elementary School,\"The polls will be open from now until the end of recess. Now, just in case any of you have decided to put any thought into this, we'll have our final statements. Martin?\"\n" +
            "5,32,214,Martin Prince: (HOARSE WHISPER) I don't think there's anything left to say.,TRUE,38,3,Martin Prince,Springfield Elementary School,I don't think there's anything left to say.\n" +
            "6,32,215,Edna Krabappel-Flanders: Bart?,TRUE,40,3,Edna Krabappel-Flanders,Springfield Elementary School,Bart?\n" +
            "7,32,216,Bart Simpson: Victory party under the slide!,TRUE,8,3,Bart Simpson,Springfield Elementary School,Victory party under the slide!\n" +
            "9,32,218,Lisa Simpson: (CALLING) Mr. Bergstrom! Mr. Bergstrom!,TRUE,9,374,Lisa Simpson,Apartment Building,Mr. Bergstrom! Mr. Bergstrom!\n" +
            "10,32,219,\"Landlady: Hey, hey, he Moved out this morning. He must have a new job -- he took his Copernicus costume.\",TRUE,469,374,Landlady,Apartment Building,\"Hey, hey, he Moved out this morning. He must have a new job -- he took his Copernicus costume.\"\n" +
            "11,32,220,Lisa Simpson: Do you know where I could find him?,TRUE,9,374,Lisa Simpson,Apartment Building,Do you know where I could find him?\n" +
            "12,32,221,Landlady: I think he's taking the next train to Capital City.,TRUE,469,374,Landlady,Apartment Building,I think he's taking the next train to Capital City.\n" +
            "13,32,222,\"Lisa Simpson: The train, how like him... traditional, yet environmentally sound.\",TRUE,9,374,Lisa Simpson,Apartment Building,\"The train, how like him... traditional, yet environmentally sound.\"\n" +
            "14,32,223,\"Landlady: Yes, and it's been the backbone of our country since Leland Stanford drove that golden spike at Promontory point.\",TRUE,469,374,Landlady,Apartment Building,\"Yes, and it's been the backbone of our country since Leland Stanford drove that golden spike at Promontory point.\"\n" +
            "15,32,224,\"Lisa Simpson: I see he touched you, too.\",TRUE,9,374,Lisa Simpson,Apartment Building,\"I see he touched you, too.\"\n" +
            "17,32,226,\"Bart Simpson: Hey, thanks for your vote, man.\",TRUE,8,3,Bart Simpson,Springfield Elementary School,\"Hey, thanks for your vote, man.\"\n" +
            "18,32,227,Nelson Muntz: I didn't vote. Voting's for geeks.,TRUE,101,3,Nelson Muntz,Springfield Elementary School,I didn't vote. Voting's for geeks.\n" +
            "19,32,228,\"Bart Simpson: Well, you got that right. (TO TERRI AND SHERRI) Thanks for your vote, girls.\",TRUE,8,3,Bart Simpson,Springfield Elementary School,\"Well, you got that right. Thanks for your vote, girls.\"\n" +
            "20,32,229,Terri/sherri: We forgot.,TRUE,467,3,Terri/sherri,Springfield Elementary School,We forgot.\n" +
            "21,32,230,\"Bart Simpson: Well, don't sweat it. Just so long as a couple of people did... right, Milhouse?\",TRUE,8,3,Bart Simpson,Springfield Elementary School,\"Well, don't sweat it. Just so long as a couple of people did... right, Milhouse?\"\n" +
            "22,32,231,Milhouse Van Houten: Uh oh.,TRUE,25,3,Milhouse Van Houten,Springfield Elementary School,Uh oh.\n" +
            "23,32,232,Bart Simpson: Lewis?,TRUE,8,3,Bart Simpson,Springfield Elementary School,Lewis?\n" +
            "24,32,233,Bart Simpson: (LOUDER) Somebody must have voted.,TRUE,8,3,Bart Simpson,Springfield Elementary School,Somebody must have voted.\n" +
            "25,32,234,\"Milhouse Van Houten: What about you, Bart? Didn't you vote?\",TRUE,25,3,Milhouse Van Houten,Springfield Elementary School,\"What about you, Bart? Didn't you vote?\"\n" +
            "26,32,235,Bart Simpson: Uh oh.,TRUE,8,3,Bart Simpson,Springfield Elementary School,Uh oh.\n" +
            "28,32,237,Wendell Borton: Yayyyyyyyyyyyyyy!,TRUE,53,3,Wendell Borton,Springfield Elementary School,Yayyyyyyyyyyyyyy!\n" +
            "30,32,238,Bart Simpson: (TO MRS. KRABAPPEL) I demand a recount.,TRUE,8,3,Bart Simpson,Springfield Elementary School,I demand a recount.\n" +
            "31,32,239,\"Edna Krabappel-Flanders: One for Martin, two for Martin. Would you like another recount?\",TRUE,40,3,Edna Krabappel-Flanders,Springfield Elementary School,\"One for Martin, two for Martin. Would you like another recount?\"\n" +
            "32,32,240,Bart Simpson: (SADLY) No.,TRUE,8,3,Bart Simpson,Springfield Elementary School,No.\n" +
            "33,32,241,\"Edna Krabappel-Flanders: (RELISHING IT) Well, I just want to make sure. One for Martin. Two for Martin.\",TRUE,40,3,Edna Krabappel-Flanders,Springfield Elementary School,\"Well, I just want to make sure. One for Martin. Two for Martin.\"\n" +
            "34,32,242,\"Kid Reporter: (TO MARTIN) This way, Mister President!\",TRUE,470,3,Kid Reporter,Springfield Elementary School,\"This way, Mister President!\"\n" +
            "36,32,244,\"Conductor: Now boarding on track 5, The afternoon delight coming to Shelbyville, Parkville, andâ€¦..\",TRUE,41,375,Conductor,Train Station,\"Now boarding on track 5, The afternoon delight coming to Shelbyville, Parkville, andâ€¦..\"\n" +
            "37,32,245,\"Lisa Simpson: Mr. Bergstrom! Hey, Mr. Bergstrom!\",TRUE,9,375,Lisa Simpson,Train Station,\"Mr. Bergstrom! Hey, Mr. Bergstrom!\"\n" +
            "38,32,246,\"BERGSTROM: Hey, Lisa.\",TRUE,465,375,BERGSTROM,Train Station,\"Hey, Lisa.\"\n" +
            "39,32,247,\"Lisa Simpson: Hey, Lisa, indeed.\",TRUE,9,375,Lisa Simpson,Train Station,\"Hey, Lisa, indeed.\"\n" +
            "40,32,248,BERGSTROM: What? What is it?,TRUE,465,375,BERGSTROM,Train Station,What? What is it?\n" +
            "41,32,249,\"Lisa Simpson: Oh, I mean, were you just going to leave, just like that?\",TRUE,9,375,Lisa Simpson,Train Station,\"Oh, I mean, were you just going to leave, just like that?\"\n" +
            "42,32,250,\"BERGSTROM: Ah, I'm sorry, Lisa. You know, it's the life of the substitute teacher: he's a fraud. Today he might be wearing gym shorts, tomorrow he's speaking French, or, or, or pretending to know how to run a band saw, or God knows what.\",TRUE,465,375,BERGSTROM,Train Station,\"Ah, I'm sorry, Lisa. You know, it's the life of the substitute teacher: he's a fraud. Today he might be wearing gym shorts, tomorrow he's speaking French, or, or, or pretending to know how to run a band saw, or God knows what.\"\n" +
            "43,32,251,Lisa Simpson: You can't go! You're the best teacher I'll ever have.,TRUE,9,375,Lisa Simpson,Train Station,You can't go! You're the best teacher I'll ever have.\n" +
            "44,32,252,\"BERGSTROM: Ah, that's not true. Other teachers will come along who...\",TRUE,465,375,BERGSTROM,Train Station,\"Ah, that's not true. Other teachers will come along who...\"\n" +
            "45,32,253,\"Lisa Simpson: Oh, please.\",TRUE,9,375,Lisa Simpson,Train Station,\"Oh, please.\"\n" +
            "46,32,254,\"BERGSTROM: No, I can't lie to you, I am the best. But, you know, they need me over in the projects of Capital City.\",TRUE,465,375,BERGSTROM,Train Station,\"No, I can't lie to you, I am the best. But, you know, they need me over in the projects of Capital City.\"\n" +
            "47,32,255,Lisa Simpson: But I need you too.,TRUE,9,375,Lisa Simpson,Train Station,But I need you too.\n" +
            "48,32,256,BERGSTROM: That's the problem with being middle class. Anybody who really cares will abandon you for those who need it more.,TRUE,465,375,BERGSTROM,Train Station,That's the problem with being middle class. Anybody who really cares will abandon you for those who need it more.\n" +
            "49,32,257,\"Lisa Simpson: (SNIFFLING) I, I understand. Mr. Bergstrom, I'm going to miss you.\",TRUE,9,375,Lisa Simpson,Train Station,\"I, I understand. Mr. Bergstrom, I'm going to miss you.\"\n" +
            "50,32,258,BERGSTROM: I'll tell you what...,TRUE,465,375,BERGSTROM,Train Station,I'll tell you what...\n" +
            "51,32,259,\"BERGSTROM: Whenever you feel like you're alone and there's nobody you can rely on, this is all you need to know.\",TRUE,465,375,BERGSTROM,Train Station,\"Whenever you feel like you're alone and there's nobody you can rely on, this is all you need to know.\"\n" +
            "52,32,260,\"Lisa Simpson: (CHOKED UP) Thank you, Mr. Bergstrom.\",TRUE,9,375,Lisa Simpson,Train Station,\"Thank you, Mr. Bergstrom.\"\n" +
            "53,32,261,Conductor: All aboard!,TRUE,41,375,Conductor,Train Station,All aboard!\n" +
            "54,32,262,\"Lisa Simpson: So, I guess this is it? It you don't mind I'll just run alongside the train as it speeds you from my life?\",TRUE,9,375,Lisa Simpson,Train Station,\"So, I guess this is it? It you don't mind I'll just run alongside the train as it speeds you from my life?\"\n" +
            "55,32,263,\"BERGSTROM: Goodbye, Lisa honey. It'll be okay. Just read the note.\",TRUE,465,375,BERGSTROM,Train Station,\"Goodbye, Lisa honey. It'll be okay. Just read the note.\"\n" +
            "57,33,5,Homer Simpson: (INDIGNANT) Never thrown a party? What about that big bash we had with all the champagne and musicians and holy men and everything?,TRUE,2,5,Homer Simpson,Simpson Home,Never thrown a party? What about that big bash we had with all the champagne and musicians and holy men and everything?\n" +
            "58,32,265,\"Homer Simpson: (MULLING IT OVER, LOW, TO HIMSELF) Bart didn't get one vote?! Oh, this is the worst thing that ever happened to us. (TRYING TO CONVINCE HIMSELF) Alright, allright, spilled milk, spilled milk, spilled milk. (NOTICING LISA) What are you so mopey about?\",TRUE,2,5,Homer Simpson,Simpson Home,\"Bart didn't get one vote?! Oh, this is the worst thing that ever happened to us. Alright, allright, spilled milk, spilled milk, spilled milk. What are you so mopey about?\"\n" +
            "59,32,266,Lisa Simpson: Nothing.,TRUE,9,5,Lisa Simpson,Simpson Home,Nothing.\n" +
            "60,32,267,\"Marge Simpson: Lisa, tell your father.\",TRUE,1,5,Marge Simpson,Simpson Home,\"Lisa, tell your father.\"\n" +
            "61,32,268,Lisa Simpson: Mr. Bergstrom left today.,TRUE,9,5,Lisa Simpson,Simpson Home,Mr. Bergstrom left today.\n" +
            "62,32,269,Homer Simpson: Oh.,TRUE,2,5,Homer Simpson,Simpson Home,Oh.\n" +
            "63,32,270,Lisa Simpson: He's gone. Forever.,TRUE,9,5,Lisa Simpson,Simpson Home,He's gone. Forever.\n" +
            "64,32,271,Homer Simpson: And?,TRUE,2,5,Homer Simpson,Simpson Home,And?\n" +
            "65,32,272,Lisa Simpson: I didn't think you'd understand.,TRUE,9,5,Lisa Simpson,Simpson Home,I didn't think you'd understand.\n" +
            "66,32,273,\"Homer Simpson: Hey, just because I don't care doesn't mean I don't understand.\",TRUE,2,5,Homer Simpson,Simpson Home,\"Hey, just because I don't care doesn't mean I don't understand.\"\n" +
            "67,32,274,\"Lisa Simpson: (FIGHTING BACK TEARS) I'm glad I'm not crying because I would hate for you to think that what I'm about to say is based on emotion. But you, sir, are a baboon!\",TRUE,9,5,Lisa Simpson,Simpson Home,\"I'm glad I'm not crying because I would hate for you to think that what I'm about to say is based on emotion. But you, sir, are a baboon!\"\n" +
            "68,32,275,Homer Simpson: (SHOCKED) Me?,TRUE,2,5,Homer Simpson,Simpson Home,Me?\n" +
            "69,32,276,\"Lisa Simpson: Yes, you! Baboon, baboon, baboon, baboon!\",TRUE,9,5,Lisa Simpson,Simpson Home,\"Yes, you! Baboon, baboon, baboon, baboon!\"\n" +
            "70,32,277,Homer Simpson: I don't think you realize what you're saying.,TRUE,2,5,Homer Simpson,Simpson Home,I don't think you realize what you're saying.\n" +
            "71,32,278,Lisa Simpson: Baboon!,TRUE,9,5,Lisa Simpson,Simpson Home,Baboon!\n" +
            "72,32,279,\"Bart Simpson: Whoa, somebody was bound to say it one day. I just can't believe it was her.\",TRUE,8,5,Bart Simpson,Simpson Home,\"Whoa, somebody was bound to say it one day. I just can't believe it was her.\"\n" +
            "73,32,280,\"Homer Simpson: (SHOCKED) Did you hear that, Marge? She called me a baboon! The stupidest, ugliest, smelliest ape of them all!\",TRUE,2,5,Homer Simpson,Simpson Home,\"Did you hear that, Marge? She called me a baboon! The stupidest, ugliest, smelliest ape of them all!\"\n" +
            "74,32,281,\"Marge Simpson: Homer, you are not allowed to have hurt feelings right now. There's a little girl upstairs who needs you. Her confidence in her father is shaken, and no little girl can be happy unless she has faith in her Daddy.\",TRUE,1,5,Marge Simpson,Simpson Home,\"Homer, you are not allowed to have hurt feelings right now. There's a little girl upstairs who needs you. Her confidence in her father is shaken, and no little girl can be happy unless she has faith in her Daddy.\"\n" +
            "75,32,282,Homer Simpson: (READING THE SIGN) Go Away.,TRUE,2,5,Homer Simpson,Simpson Home,Go Away.\n" +
            "76,32,283,\"Homer Simpson: Lisa, don't hold anything back. You can tell me. Are you crying because you called Daddy a baboon?\",TRUE,2,5,Homer Simpson,Simpson Home,\"Lisa, don't hold anything back. You can tell me. Are you crying because you called Daddy a baboon?\"\n" +
            "77,32,284,Lisa Simpson: No!,TRUE,9,5,Lisa Simpson,Simpson Home,No!\n" +
            "78,32,285,Homer Simpson: Nuts.,TRUE,2,5,Homer Simpson,Simpson Home,Nuts.\n" +
            "79,32,286,Homer Simpson: (ANNOYED GRUNT) This isn't going well at all.,TRUE,2,5,Homer Simpson,Simpson Home,This isn't going well at all.\n" +
            "80,32,287,\"Lisa Simpson: Look, if you just want me to forgive you --\",TRUE,9,5,Lisa Simpson,Simpson Home,\"Look, if you just want me to forgive you --\"\n" +
            "81,32,288,\"Homer Simpson: No, no, no. I just wish I knew what to say.\",TRUE,2,5,Homer Simpson,Simpson Home,\"No, no, no. I just wish I knew what to say.\"\n" +
            "82,32,289,\"Homer Simpson: Although, maybe this will help. Now you lost someone special and it hurts. I'm lucky because I never lost anyone special to me. Everyone special to me is under this roof.\",TRUE,2,5,Homer Simpson,Simpson Home,\"Although, maybe this will help. Now you lost someone special and it hurts. I'm lucky because I never lost anyone special to me. Everyone special to me is under this roof.\"\n" +
            "84,33,6,Marge Simpson: That was our wedding.,TRUE,1,5,Marge Simpson,Simpson Home,That was our wedding.\n" +
            "85,33,7,Homer Simpson: Oh.,TRUE,2,5,Homer Simpson,Simpson Home,Oh.\n" +
            "86,33,8,\"Marge Simpson: (LOOKS UP) Children, it's time for you to go to bed.\",TRUE,1,5,Marge Simpson,Simpson Home,\"Children, it's time for you to go to bed.\"\n" +
            "87,32,291,\"Homer Simpson: (PATS HER HEAD) It's true. Now, you'll have lots of special people in your life, Lisa. There's probably some place where they all get together, and the food is real good, and guys like me are serving drinks. (BEAT) Oh well, maybe I can't explain all this, but I can fix your doll house for you. At least, I'm good at monkey work. You know... monkey. You know what I mean?\",TRUE,2,5,Homer Simpson,Simpson Home,\"It's true. Now, you'll have lots of special people in your life, Lisa. There's probably some place where they all get together, and the food is real good, and guys like me are serving drinks. Oh well, maybe I can't explain all this, but I can fix your doll house for you. At least, I'm good at monkey work. You know... monkey. You know what I mean?\"\n" +
            "88,32,292,Lisa Simpson: Yeah.,TRUE,9,5,Lisa Simpson,Simpson Home,Yeah.\n" +
            "89,32,293,Homer Simpson: I can hold these nails in place with my tail.,TRUE,2,5,Homer Simpson,Simpson Home,I can hold these nails in place with my tail.\n" +
            "90,32,294,Lisa Simpson: You're so silly.,TRUE,9,5,Lisa Simpson,Simpson Home,You're so silly.\n" +
            "91,32,295,Homer Simpson: Gimme a banana.,TRUE,2,5,Homer Simpson,Simpson Home,Gimme a banana.\n" +
            "92,32,296,Lisa Simpson: I don't have any banana.,TRUE,9,5,Lisa Simpson,Simpson Home,I don't have any banana.\n" +
            "93,32,297,\"Homer Simpson: Come on, you're holding out on me.\",TRUE,2,5,Homer Simpson,Simpson Home,\"Come on, you're holding out on me.\"\n" +
            "94,32,298,\"Lisa Simpson: I'm sorry I called you a baboon, Dad.\",TRUE,9,5,Lisa Simpson,Simpson Home,\"I'm sorry I called you a baboon, Dad.\"\n" +
            "95,32,299,Homer Simpson: Think nothing of it.,TRUE,2,5,Homer Simpson,Simpson Home,Think nothing of it.\n" +
            "96,32,300,\"Homer Simpson: Hey, what's the matter, son?\",TRUE,2,5,Homer Simpson,Simpson Home,\"Hey, what's the matter, son?\"\n" +
            "97,32,301,\"Bart Simpson: (SHAKING HEAD) Ah, Dad, if just me, Milhouse and Lewis had voted...\",TRUE,8,5,Bart Simpson,Simpson Home,\"Ah, Dad, if just me, Milhouse and Lewis had voted...\"\n" +
            "98,32,302,\"Homer Simpson: Hey son, would you have gotten any money for being class president?\",TRUE,2,5,Homer Simpson,Simpson Home,\"Hey son, would you have gotten any money for being class president?\"\n" +
            "99,32,303,Bart Simpson: No.,TRUE,8,5,Bart Simpson,Simpson Home,No.\n" +
            "100,32,304,Homer Simpson: Would you have to do extra work?,TRUE,2,5,Homer Simpson,Simpson Home,Would you have to do extra work?\n";
}
