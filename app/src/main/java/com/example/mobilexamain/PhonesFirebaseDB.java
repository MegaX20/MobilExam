package com.example.mobilexamain;

public class PhonesFirebaseDB {
    String battery;
//    String buy;
    String cpu;
    String camera;
    String gpu;
    String memory;
    String price;
    String screen;
    String video;

    public PhonesFirebaseDB() {

    }

    public PhonesFirebaseDB(String battery,/* String buy,*/ String cpu, String camera, String gpu, String memory, String price, String screen, String video) {
        this.battery = battery;
//        this.buy = buy;
        this.cpu = cpu;
        this.camera = camera;
        this.gpu = gpu;
        this.memory = memory;
        this.price = price;
        this.screen = screen;
        this.video = video;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    /*public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }*/

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }


}

