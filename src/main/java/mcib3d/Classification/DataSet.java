/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcib3d.Classification;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

/**
 *
 * @author thomasb
 */
public class DataSet {

    Attributes attributes = null;
    Instances instances = null;
    int classIndex = -1;

    public DataSet(String name, Attributes atts) {
        instances = new Instances(name, atts.getArrayList(), atts.size());
        attributes = atts;
        instances.setClass(atts.getClassAttribute());
    }

    public void addData(Data data) {
        instances.add(data.getData());
    }

    public Instances getInstances() {
        return instances;
    }

    public int size() {
        return instances.size();
    }

    

}
