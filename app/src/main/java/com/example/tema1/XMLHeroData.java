package com.example.tema1;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLHeroData {
    private Context context;
    private Hero [] heroes;

    public XMLHeroData(Context context){
        this.context = context;

        // get the data from people.xml and parse it
        InputStream stream = this.context.getResources().openRawResource(R.raw.heroes);

        // create a document builder and make the xml tree document
        DocumentBuilder builder = null;
        Document xmlTree = null;

        try{
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlTree = builder.parse(stream);

        }catch(Exception e){

        }

        // slice xmlTree into NodeLists
        NodeList nameList = xmlTree.getElementsByTagName("name");
        NodeList aliasList = xmlTree.getElementsByTagName("alter-ego");
        NodeList abilitiesList = xmlTree.getElementsByTagName("abilities");
        NodeList actorList = xmlTree.getElementsByTagName("actor");
        NodeList plotList = xmlTree.getElementsByTagName("movie-plot");
        NodeList imageList= xmlTree.getElementsByTagName("image");
        NodeList logoList= xmlTree.getElementsByTagName("logo");
        NodeList urlList= xmlTree.getElementsByTagName("url");


        // traverse the NodeLists and make people
        heroes = new Hero [nameList.getLength()];
        for(int i = 0; i< heroes.length; i++){
            String name    = nameList.item(i).getFirstChild().getNodeValue();
            String alias = aliasList.item(i).getFirstChild().getNodeValue();
            String abilities   = abilitiesList.item(i).getFirstChild().getNodeValue();
            String actor   = actorList.item(i).getFirstChild().getNodeValue();
            String plot   = plotList.item(i).getFirstChild().getNodeValue();
            String image   = imageList.item(i).getFirstChild().getNodeValue();
            String logo  = logoList.item(i).getFirstChild().getNodeValue();
            String url=urlList.item(i).getFirstChild().getNodeValue();


            heroes[i] = new Hero(name, alias, abilities, actor, plot, image, logo, url);
        }
    }

    public Hero [] getHeroes(){return heroes;}
    public Hero getHero(int position){return heroes[position];}

}
