package Models;

import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;
import java.net.URISyntaxException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

/**
 * AssetLoader
 */

public class AssetLoader {
    private HashMap<String, Object> assets = new HashMap<>();
    private File dir;

    public AssetLoader(String dirName) {
        this.dir = new File(dirName);
        try {
            loadAssetsInDirectory();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that goes through all files of a given directory
     * If the file is a text files, search for call of asset reading method
     * In case there is such a method, load the asset in the assets map
     * @param dir
     */
    private void loadAssetsInDirectory() throws URISyntaxException, IOException {
        URI resource;

        if (!this.dir.isDirectory()) //trow error ?
            return;
        resource = getClass().getClassLoader().getResource(this.dir.getName()).toURI();
        List<File> collect = Files.walk(Paths.get(resource))
                .filter(Files::isRegularFile)
                .map(x -> x.toFile())
                .collect(Collectors.toList());
        for (File file : collect)
            this.assets.put(file.getName().replaceFirst("[.^][^.]+$", ""), loadAsset(file));
    }


    /**
     * Read through the whole file to find call of asset
     * @param file
     */
    private Object loadAsset(File file) throws IOException  {
        if (file.getName().replaceFirst(".+[.]", "").equals("png"))
            return (ImageIO.read(file));
        return (file);
    }

    public Object get(String name) {
        return (this.assets.get(name));
    }

    public void printError(String name) {
        System.out.println("Warning: Couln't find ressource " + name);
    }
}
