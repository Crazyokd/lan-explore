package com.sxrekord.thread;

import java.util.Random;

// 信号灯法解决生产者消费者问题

/**
 * @author Rekord
 * @date 2022/7/7 9:44
 */
public class TestPC2 {
    public static void main(String[] args) {
        ProgramBuffer programBuffer = new ProgramBuffer();

        new Thread(new Player(programBuffer)).start();
        new Thread(new Audience(programBuffer)).start();
    }
}

class Player implements Runnable {
    private ProgramBuffer programBuffer;

    public Player(ProgramBuffer programBuffer) {
        this.programBuffer = programBuffer;
    }
    Random rand = new Random();

    private Program[] programs = {new Program("阿甘正传"), new Program("美丽人生"), new Program("美丽心灵")};

    @Override
    public void run() {
        while (true) {
            programBuffer.play(programs[rand.nextInt(programs.length)]);
        }
    }
}

class Audience implements Runnable {
    private ProgramBuffer programBuffer;

    public Audience(ProgramBuffer programBuffer) {
        this.programBuffer = programBuffer;
    }
    @Override
    public void run() {
        while (true) {
            programBuffer.watch();
        }
    }
}

class Program {
    private String movie;

    public Program() {}

    public Program(String movieName) {
        movie = movieName;
    }
    @Override
    public String toString() {
        return movie;
    }
}

class ProgramBuffer {
    private Program program;

    boolean flag = true;

    public synchronized void play(Program program) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.program = program;
        System.out.println("Player play the " + program);
        flag = !flag;
        this.notifyAll();
    }

    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Audience watch the " + program);
        flag = !flag;
        this.notifyAll();
    }
}

