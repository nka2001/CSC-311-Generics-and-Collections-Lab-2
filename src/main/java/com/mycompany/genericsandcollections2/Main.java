/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.genericsandcollections2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soblab
 */
public class Main {

    public static void main(String[] args) {

        try {
            Queue<String> q1 = new LinkedList<String>();//part 1, create a queue

            File f = new File("QueueData.txt");//file that contains the test data

            Scanner scan = new Scanner(f);//scanner that reads in the file data

            while (scan.hasNext()) {//fill the queue usiing the scanner
                String str = scan.nextLine();//create a string from scanners next
                q1.add(str);//add that string to the queue 
            }

            System.out.println("Print all Items in Queue: \n");
            printAllItems(q1);

            Queue<String> pq1 = new PriorityQueue<String>();//priority queue for part 2

            pq1.addAll(q1);//adds all the elements from the first queue to the second queue 

            System.out.println("\n Print and Remove from Priority Queue: \n");
            printAndRemove(pq1);
            System.out.println("Size of Priority Queue after removing: " + pq1.size());

            Map<Integer, String> m1 = new HashMap<Integer, String>();//map for part 3, HASHMAP IS FASTER FOR LOOKUPS roughly O(1) assuming good hash function

            File f2 = new File("MapData.txt");//file that contains the test data for the map

            Scanner scan2 = new Scanner(f2);//scanner that reads in the file data

            while (scan2.hasNext()) {//fill the map using the scanner
                int regNum = scan2.nextInt();//gets the key
                String curr = scan2.next();//gets the value

                m1.put(regNum, curr);//adds it to the map

            }

            System.out.println("\n Searching Map: \n");
            searchMyMap(m1);

            Set<String> s1 = new TreeSet<String>();//set for part 4

            File f3 = new File("SetData.txt");//file that contains the test data

            Scanner scan4 = new Scanner(f3);//scanner that reads in the file data

            while (scan4.hasNext()) {//fills the set using the scanner
                String curr = scan4.next();
                s1.add(curr);
            }

            System.out.println("\n Print Set: \n");
            printSet(s1);

        } catch (FileNotFoundException ex) {//if any file was not found 
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * this method takes a queue as a parameter, it will print the contents of
     * the queue using an iterator
     *
     * @param q
     */
    public static void printAllItems(Queue<String> q) {

        Iterator<String> iter;
        iter = q.iterator();

        while (iter.hasNext()) {
            String curr = iter.next();
            System.out.println(curr);
        }

    }

    /**
     * this method takes a queue as a parameter, it will print the contents of
     * the queue using an iterator and the POP (poll) method, this is how the
     * queue is printed as a priority queue
     *
     * @param q
     */
    public static void printAndRemove(Queue<String> q) {

        Iterator<String> iter;
        iter = q.iterator();

        while (iter.hasNext()) {
            System.out.println(q.poll() + ", ");
        }

    }

    /**
     * this method takes a map as a parameter and it will search the map based
     * on a user given key value, then the method will check for that value, if
     * its found then it will print its value, if not just print not found
     *
     * @param m1
     */
    public static void searchMyMap(Map<Integer, String> m1) {

        Scanner scan3 = new Scanner(System.in);
        System.out.println("Please enter a region number");
        int num = scan3.nextInt();

        if (m1.get(num) != null) {
            String str = m1.get(num);
            System.out.println("Found: " + str);
        } else {
            System.out.println("item not found based on key");
        }

    }

    /**
     * this method takes a set as a parameter, it will print out the contents of
     * the set, in the file, there are duplicate entries in the set and this
     * method only prints one entry for each, NO DUPLICATES
     *
     * @param s
     */
    public static void printSet(Set<String> s) {

        for (String str : s) {
            System.out.println(str);
        }

    }

}
