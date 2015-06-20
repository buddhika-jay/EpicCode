package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DancingPaires dancingPaires = new DancingPaires();
        dancingPaires.getInput();
        System.out.println(dancingPaires.calculate());
    }

    static class DancingPaires{
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        long k = 0;
        long[] boysHeight = new long[100000];
        long[] girlsHeight = new long[100000];
        boolean[][] map = new boolean[100000][100000];

        public void getInput(){
            n = scanner.nextInt();
            k = scanner.nextLong();
            //height of boys
            for(int i=0;i<n;++i){
                boysHeight[i] = scanner.nextLong();
            }
            for (int i=0;i<n;++i){
                girlsHeight[i] = scanner.nextLong();
            }
        }

        public int calculate(){
            int pairCount = 0;
            long minDiff = 1000000000;
            long maxDiff = 0;
            boolean[] availableGils = new boolean[100001];
            long currentDiff=0;
            int girl = 0;
            int boy = 0;
            boolean girlSelected = false;
            int selectedGirl=100001;

            for(int i=0;i<n;++i){
                availableGils[i] = true;
            }

            for(boy=0 ;boy<n;++boy){
                minDiff = 100000000;
                girlSelected=false;
                selectedGirl=100001;
                for (girl=0;girl<n;girl++){
                    if(availableGils[girl]){
                        currentDiff= boysHeight[boy]-girlsHeight[girl];
                        if(currentDiff<0){
                            currentDiff*=-1;
                        }
                        if ((currentDiff>maxDiff)&&(currentDiff<=k)){
                            girlSelected = true;
                            selectedGirl=girl;
                        }
                    }
                }
                if(girlSelected){
                    availableGils[selectedGirl]= false;
                    pairCount++;
                }
            }

            return pairCount;

            public void setMap(){
                for(boy=0;boy<n;++boy){
                    for (girl=0;girl<n;++girl){
                        currentDiff= boysHeight[boy]-girlsHeight[girl];
                        if(currentDiff<0){
                            currentDiff*=-1;
                        }
                        if (currentDiff<=k){
                            map[girl][boy]=true;
                        }
                    }
                }
            }

        }



    }

    static class PerfectHiring {

        Scanner scanner = new Scanner(System.in);
        int n = 0;
        long p = 0;
        int x = 0;
        long[] scores = new long[100000];

        public void getInput(){
            n = scanner.nextInt();//n
            p = scanner.nextLong();//p
            x = scanner.nextInt();//x
            for (int i=0; i<n;++i){
                scores[i] = scanner.nextLong();
            }
        }

        public int calculate(){
            int selectedId = 0;
            long max = 0;
            long temVal = 0;
            for(int i = 0; i<n; ++i){
                temVal = scores[i]*p;
                p-=x;
                if(temVal>max){
                    max = temVal;
                    selectedId = i;
                }
            }

            return selectedId+1;
        }
    }
}

