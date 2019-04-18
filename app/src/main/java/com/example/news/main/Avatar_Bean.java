package com.example.news.main;

public class Avatar_Bean {


    /**
     * code : success
     * data : {"width":720,"height":1280,"filename":"ss.png","storename":"5cb72581700d7.png","size":688693,"path":"/2019/04/17/5cb72581700d7.png","hash":"MP8wnBREqhotGvb","timestamp":1555506561,"ip":"221.221.151.201","url":"https://i.loli.net/2019/04/17/5cb72581700d7.png","delete":"https://sm.ms/delete/MP8wnBREqhotGvb"}
     */

    private String code;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * width : 720
         * height : 1280
         * filename : ss.png
         * storename : 5cb72581700d7.png
         * size : 688693
         * path : /2019/04/17/5cb72581700d7.png
         * hash : MP8wnBREqhotGvb
         * timestamp : 1555506561
         * ip : 221.221.151.201
         * url : https://i.loli.net/2019/04/17/5cb72581700d7.png
         * delete : https://sm.ms/delete/MP8wnBREqhotGvb
         */

        private int width;
        private int height;
        private String filename;
        private String storename;
        private int size;
        private String path;
        private String hash;
        private int timestamp;
        private String ip;
        private String url;
        private String delete;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getStorename() {
            return storename;
        }

        public void setStorename(String storename) {
            this.storename = storename;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDelete() {
            return delete;
        }

        public void setDelete(String delete) {
            this.delete = delete;
        }
    }
}
