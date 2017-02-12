package com.myproject;

import java.util.List;
import java.util.Map;

/**
 * Created by robinwang on 11/9/16.
 */
public class OndemandTree {
    private List<OndemandTree> folders;
    private List<Asset> assets;
    private String path;
    private Map<String, String> metadataMap;

    public OndemandTree() {
    }

    public OndemandTree(String path) {
        this.path = path;
    }
    public OndemandTree(List<OndemandTree> folders, List<Asset> assets, String path, Map<String, String> metadataMap) {
        this.folders = folders;
        this.assets = assets;
        this.path = path;
        this.metadataMap = metadataMap;
    }


    public void addFolders(List<OndemandTree> folders) {
        folders.addAll(folders);
    }

    public void addAssets(List<Asset> assets) {
        assets.addAll(assets);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Network");
        for(OndemandTree node : folders)
        {
            sb.append(node.toString());
        }
        return sb.toString();

//        return "OndemandTree{" +
//                "folders=" + folders +
//                ", assets=" + assets +
//                ", path='" + path + '\'' +
//                ", metadataMap=" + metadataMap +
//                '}';
    }
}
