package Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.ImageIcon;

/**
 * AssetLoader
 */
public class AssetLoader {
    private HashMap<String, URL> assets = new HashMap<>();


    public AssetLoader(String dirName) {
        File dir = new File(dirName);
        loadAssets(dir);
    }

    /**
     * Method that goes through all files of a given directory
     * If the file is a text files, search for call of asset reading method
     * In case there is such a method, load the asset in the assets map
     * @param dir
     */
    private void loadAssets(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    loadAssets(file);
                }
                else if (!file.getName().equals("AssetLoader.java")) {
                    this.searchForAsset(file);
                }
            }
        }
    }


    /**
     * Read through the whole file to find call of asset
     * @param file
     */
    private void searchForAsset(File file) {
        try {
            Scanner sc = new Scanner(file);
            String toFind = "getAsset(\"";
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains(toFind)) {
                    String resourceName = line.substring(line.lastIndexOf(toFind) + toFind.length(), line.indexOf("\")"));
                    if (!this.assets.containsKey(resourceName))
                        this.assets.put(resourceName, this.getClass().getResource("../resources/" + resourceName + ".png"));
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public URL getAsset(String name) {
        return this.assets.get(name);
    }

    public void printError(String name) {
        System.out.println("Warning: Couln't find ressource " + name);
    }
}
