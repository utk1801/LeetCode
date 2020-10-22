import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FileSystem {
    private class File {
        private String fileName;
        private String content;

        public File(String fileName, String content) {
            this.fileName = fileName;
            this.content = content;
        }

        void addContent(String c) {
            content = content + c;
        }
    }

    private class Directory {
        private String pathName;
        private HashMap<String, File> files = new HashMap<>();
        private HashMap<String, Directory> directories = new HashMap<>();

        public Directory(String pathName) {
            this.pathName = pathName;
        }
    }

    private Directory root = new Directory("/");

    public FileSystem() {
    }

    private List<String> ls(Directory root) {
        List<String> ret = new ArrayList<>();
        if(root.files.size() != 0) {
            for(String file: root.files.keySet()) {
                ret.add(file);
            }
        }
        if(root.directories.size() != 0) {
            for(String path: root.directories.keySet()) {
                ret.add(path);
            }
        }
        Collections.sort(ret);
        return ret;
    }

    public List<String> ls(String path) {
        String[] paths = path.split("/");
        Directory p = root;
        for(int i = 1;i <= paths.length - 1;++i) {
            if(p.directories.containsKey(paths[i])) {
                p = p.directories.get(paths[i]);
            } else {
                List<String> ret = new ArrayList<>();
                ret.add(paths[paths.length - 1]);
                return ret;
            }
        }
        return ls(p);
    }

    public void mkdir(String path) {
        String[] paths = path.split("/");
        Directory p = root;
        for(int i = 1;i < paths.length;++i) {
            if(!p.directories.containsKey(paths[i])) {
                Directory d = new Directory(paths[i]);
                p.directories.put(paths[i], d);
            }
            p = p.directories.get(paths[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] paths = filePath.split("/");
        Directory p = root;
        for(int i = 1;i < paths.length - 1;++i) {
            p = p.directories.get(paths[i]);
        }
        if(!p.files.containsKey(paths[paths.length - 1])) {
            File file = new File(paths[paths.length - 1], content);
            p.files.put(paths[paths.length - 1], file);
        } else {
            File file = p.files.get(paths[paths.length - 1]);
            file.addContent(content);
        }
    }

    public String readContentFromFile(String filePath) {
        String[] paths = filePath.split("/");
        Directory p = root;
        for(int i = 1;i < paths.length - 1;++i) {
            p = p.directories.get(paths[i]);
        }
        File file = p.files.get(paths[paths.length - 1]);
        return file.content;
    }
}
/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */