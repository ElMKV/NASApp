//package com.example.nasapp;
//
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;
//
//public class Comet {
//
//    @SerializedName("id")
//    @Expose
//    private String id;
//    @SerializedName("neo_reference_id")
//    @Expose
//    private String neoReferenceId;
//    @SerializedName("name")
//    @Expose
//    private String name;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getNeoReferenceId() {
//        return neoReferenceId;
//    }
//
//    public void setNeoReferenceId(String neoReferenceId) {
//        this.neoReferenceId = neoReferenceId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
//

package com.example.nasapp;;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NearNarthObjects {
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("id")
    @Expose
    int id;

    public NearNarthObjects(String name, int id) {

        this.name = name;
        this.id = id;
    }

    public int getId() {return id;}
    public void setid(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


}





