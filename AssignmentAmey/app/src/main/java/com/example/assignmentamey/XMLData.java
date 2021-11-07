package com.example.assignmentamey;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLData {
    private Context context;
    private PersonDetails[] data;

    public XMLData  (Context context) {
        this.context = context;
        //get data from xml

        //1. Establish a input stream and parse the document
        InputStream stream = context.getResources().openRawResource(R.raw.persons);
        DocumentBuilder builder = null;
        Document document = null;

        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(stream);
        } catch (Exception e) {
        }

        //2. slice document
        NodeList nameList = document.getElementsByTagName("name");
        NodeList imageList = document.getElementsByTagName("image");
        NodeList locationList = document.getElementsByTagName("location");
        NodeList urlList = document.getElementsByTagName("url");

//3. Make the Data

        data = new PersonDetails[nameList.getLength()];
        for (int i = 0; i < data.length; i++) {
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String location = locationList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();

            data[i] = new PersonDetails(image,name,location,url);
        }
    }

    public PersonDetails getName(int i){return data[i];}
    public PersonDetails[] getValues() {return data;}
    public int getLength(){return data.length;}


    public String [] getNames(){
        String names[] = new String[getLength()];
        for(int i=0;i<names.length;i++)
            names[i] = getName(i).getName();
        return names;
    }
    public String [] getUserLocation(){
        String location[] = new String[getLength()];
        for(int i=0;i<location.length;i++)
            location[i] = getName(i).getLocation();
        return location;
    }
    public String [] getImages(){
        String images[] = new String[getLength()];
        for(int i=0;i<images.length;i++)
            images[i] = getName(i).getImage();
        return images;
    }

    public String [] getUrl(){
        String names[] = new String[getLength()];
        for(int i=0;i<names.length;i++)
            names[i] = getName(i).getUrl();
        return names;
    }

}
