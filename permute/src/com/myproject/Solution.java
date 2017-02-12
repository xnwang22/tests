package com.myproject;

/**
 * Created by robinwang on 9/27/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        List<Asset> assets = new ArrayList<>();
        OndemandTree root = new OndemandTree();
        List<OndemandTree> folders =  new ArrayList<>();
        folders.add(new OndemandTree("TV"));
        folders.add(new OndemandTree("Movies"));
        OndemandTree networks = new OndemandTree("Networks");
        networks.addFolders(Arrays.asList(new OndemandTree("A-C"), new OndemandTree("D-F")));
        folders.add(networks);
        root.addFolders(folders);

        assets.add(new Asset());
        root.addAssets(assets);


    }

}
