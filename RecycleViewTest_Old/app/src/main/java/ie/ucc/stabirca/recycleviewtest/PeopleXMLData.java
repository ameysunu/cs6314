package ie.ucc.stabirca.recycleviewtest;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class PeopleXMLData {
    // ivars
    private Context context;
    private Person [] data;

    public PeopleXMLData(Context context){
        this.context = context;

        //get data from XML

        //1. establish i/p string and parse document
        InputStream stream = context.getResources().openRawResource(R.raw.people);
        DocumentBuilder builder = null;
        Document document = null;

        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(stream);
        } catch (Exception e){

        }

        //2. slice the document
        NodeList nameList = document.getElementsByTagName("name");
        NodeList addressList = document.getElementsByTagName("address");
        NodeList urlList = document.getElementsByTagName("url");
        NodeList imageList = document.getElementsByTagName("image");
        NodeList phoneList = document.getElementsByTagName("phone");

        //3. make the data
        data = new Person[nameList.getLength()];
        for (int i =0; i< data.length; i++){
            //extract string info
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String address = addressList.item(i).getFirstChild().getNodeValue();
            String phone = phoneList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();

            data[i] = new Person(name, address, phone, url, image);
        }
    }

    public Person getPerson(int i ){
        return  data[i];
    }
    public int getLength(){
        return data.length;
    }
    public String [] getNames(){
        String names[] = new String[getLength()];
        for(int i=0; i<names.length; i++){
            names[i] = getPerson(i).getName();
        }
        return names;
    }
}
