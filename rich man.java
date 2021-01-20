package com.company;

import java.util.Random;
import java.util.Scanner;
//---------------------------------
class Player{
    private int cash;
    private int po;
    private String name;
    private int life;
    private boolean stop;
    //物件
    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}
    public void setPo(int po){this.po = po;}
    public int getPo(){return this.po;}
    public void setCash(int cash){ this.cash = cash;}
    public int getCash(){return this.cash;}
    public void setLife(int life){this.life = life;}
    public int getLife(){return this.life;}
    public void setStop(boolean stop){this.stop = stop;}
    public boolean getStop(){return this.stop;}
    //-------------------------------------------------
}
class Block{
    int owner; //4:沒人 0-3:A~D
    int price; //該監獄費用
    String title; //監獄名稱
    //物件
    public void setTitle(String title){this.title = title;}
    public String getTitle(){return this.title;}
    public void setPrice(int price){this.price = price;}
    public int getPrice(){return this.price;}
    public void setOwner(int owner){ this.owner = owner;}
    public int getOwner(){return this.owner;}
    //-------------------------------------------------
}
class Chance{
    private int moneyC;
    private int moveC;
    private String viewC;
    //物件
    public void setViewC(String viewC){this.viewC = viewC;}
    public String getViewC(){return this.viewC;}
    public void setMoveC(int moveC){this.moveC = moveC;}
    public int getMoveC(){return this.moveC;}
    public void setMoneyC(int moneyC){this.moneyC = moneyC;}
    public int getMoneyC(){return this.moneyC;}
    //-------------------------------------------------
}
class Destiny{
    private int moneyD;
    private int moveD;
    private String viewD;
    //物件
    public void setViewD(String viewD){this.viewD = viewD;}
    public String getViewD(){return this.viewD;}
    public void setMoveD(int moveD){ this.moveD = moveD;}
    public int getMoveD(){return this.moveD;}
    public void setMoneyD(int moneyD){this.moneyD = moneyD;}
    public int getMoneyD(){return this.moneyD;}
}
//---------------------------------
public class Main {
    //靜態全域變數----------------------------------------------------------------------
    //block-------------
    static String [] block_title = {"　開　　始　","　宜蘭監獄　","　機　　會　","　基隆監獄　", "　法　　院　","　金門監獄　","　桃園監獄　","　台中監獄　","　命　　運　","　彰化監獄　",
            "　雲林監獄　","　嘉義監獄　","　飛　　機　","　台南監獄　","　機　　會　","　高雄監獄　","　競　　賽　","　屏東監獄　","　澎湖監獄　","　花蓮監獄　","　命　　運　", "　台東監獄　",
            "　台北監獄　","　綠島監獄　"};
    static int [] block_price ={0, 3000, 0, 3200, 0, 3500, 3700, 4000, 0, 4200, 4500, 4700, 0, 5000, 0, 5200, 0, 5500, 5700, 6000, 0, 6200, 6500, 6700};
    //chance------------
    static int [] chance_moneyC = {3000,-4000,-2000,3000,-5000};
    static String [] chance_viewC = {"搶銀行成功，獲得金額：３０００元！！","遭典獄長檢舉，罰款金額：４０００元！","搶來的錢包掉了，損失金額２０００元！",
            "撿到錢包，獲得金額：３０００元！！！", "監獄經營不善，繳納違約金５０００元！"};
    //destiny-----------
    static int [] destiny_moveD ={-5,2,-2,1,-3};
    static String [] destiny_viewD = {"遇到警察臨檢，必須往回退５步！！！！","遇到闖空門事件，前進２步！！！！！！","看到警察嚇跑，於是往後退了２步！！！",
            "巧遇同行，合作闖空門往前１步！！！！", "收到存證信函，被告者需後退３步！！！"};
    //-----------------------------------------------------------------------------
    //Maps-----------------------------
    public static void Map(String [] jail_data){
        System.out.println();
        System.out.println("　　　　　　｜　金門監獄　｜　桃園監獄　｜　台中監獄　｜　　　　　　｜　彰化監獄　｜　雲林監獄　｜　嘉義監獄　｜　　　　　　｜");
        System.out.println("　法　　院　｜　３５００　｜　３７００　｜　４０００　｜　命　　運　｜　４２００　｜　４５００　｜　４７００　｜　飛　　機　｜");
        System.out.println(jail_data[4]+"｜"+jail_data[5]+"｜"+jail_data[6]+"｜"+jail_data[7]+"｜"+jail_data[8]+"｜"+jail_data[9]+"｜"+jail_data[10]+"｜"+jail_data[11]+"｜"+jail_data[12]+"｜");
        System.out.println("－－－－－－＋－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－＋－－－－－－｜");
        System.out.println("　基隆監獄　｜　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　｜　台南監獄　｜");
        System.out.println("　３２００　｜　　　　　　　　　　　　　　玩家＿點數＿，移動到＿＿＿＿　　　　　　　　　　　　　　　　　　　　｜　５０００　｜");
        System.out.println(jail_data[3]+"｜　　　　　　　　　　　　　　機會：＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿　　　　　　　　　　　　　｜"+jail_data[13]+"｜");
        System.out.println("－－－－－－｜　　　　　　　　　　　　　　命運：＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿　　　　　　　　　　　　　｜－－－－－－｜");
        System.out.println("　　　　　　｜　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　｜　　　　　　｜");
        System.out.println("　機　　會　｜　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　｜　機　　會　｜");
        System.out.println(jail_data[2]+"｜　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　｜"+jail_data[14]+"｜");
        System.out.println("－－－－－－｜　　　　　　　　　　玩家Ａ　　　　　玩家Ｂ　　　　　玩家Ｃ　　　　　玩家Ｄ　　　　　　　　　　　｜－－－－－－｜");
        System.out.println("　宜蘭監獄　｜　　　　　　　　＄００００００　＄００００００　＄００００００　＄００００００　　　　　　　　　｜　高雄監獄　｜");
        System.out.println("　３０００　｜　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　｜　５２００　｜");
        System.out.println(jail_data[1]+"｜　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　｜"+jail_data[15]+"｜");
        System.out.println("－－－－－－＋－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－＋－－－－－－｜");
        System.out.println("　　　　　　｜　綠島監獄　｜　台北監獄　｜　台東監獄　｜　　　　　　｜　花蓮監獄　｜　澎湖監獄　｜　屏東監獄　｜　　　　　　｜");
        System.out.println("　開　　始　｜　６７００　｜　６５００　｜　６２００　｜　命　　運　｜　６０００　｜　５７００　｜　５５００　｜　競　　賽　｜");
        System.out.println(jail_data[0]+"｜"+jail_data[23]+"｜"+jail_data[22]+"｜"+jail_data[21]+"｜"+jail_data[20]+"｜"+jail_data[19]+"｜"+jail_data[18]+"｜"+jail_data[17]+"｜"+jail_data[16]+"｜");
        System.out.println();
    }
    public static void main(String[] args) {
        //宣告物件-------------------------------
        Player [] user = new Player[4];
        Block [] block = new Block[24];
        Chance [] card_c = new Chance[5];
        Destiny [] card_d = new Destiny[5];
        String [] user_id = {"Ａ","Ｂ","Ｃ","Ｄ","　"};
        String [] jail_data = new String[24];
        //初始設定
        for(int i = 0;i<5; i++){
            card_c[i] = new Chance();
            card_d[i] = new Destiny();
            //機會卡初始設定
            card_c[i].setMoneyC(chance_moneyC[i]);
            card_c[i].setViewC(chance_viewC[i]);
            //命運卡初始設定
            card_d[i].setMoveD(destiny_moveD[i]);
            card_d[i].setViewD(destiny_viewD[i]);
        }
        for(int i = 0;i<24; i++){
            block[i] = new Block();
            block[i].owner = 4;
            block[i].price = block_price[i];
            block[i].title = block_title[i];
        }
        //---------------------------------------
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("開始\"越獄風雲大富翁\"");
        System.out.println("請輸入玩家人數(最多4人，最少2人)");
        int player=0; //玩家
        int numi=0;
        //判斷人數是否<4---------------------------
        do{
            numi = sc.nextInt();
            if(numi>4 || numi<=1){
                System.out.println("人數最多4人，最少2人喔!");
            }
        }while(numi>4 || numi<=1);
        for (int j=0; j<numi;j++){
            user[j] = new Player();
            user[j].setPo(0);//初始設定位置0
            user[j].setCash(20000); //初始設定20000/人
            System.out.print("請輸入玩家"+(j+1)+"名稱:");
            user[j].setName(sc.next());;//players[j];
            user[j].setLife(1);
            user[j].setStop(false);
        }
        while (true) { //不管如何都要執行
            if(user[player].getStop()==false) {
                sc.nextLine(); //按下Enter後往下執行(空字串也可)
                System.out.println("玩家:" + user[player].getName() + " 原位置:" + user[player].getPo()); //原位置
                //骰骰子，擲出點數----------------------
                int p = ran.nextInt(6) + 1; //擲骰數
                user[player].setPo(user[player].getPo() + p); //位置=原位置+骰子數
                //開始(起點)模組-回到原點----------------
                if (user[player].getPo() > 23) {
                    user[player].setPo(user[player].getPo() - 24); //回原點需扣除原點
                    user[player].setCash(user[player].getCash() + 10000); //領錢囉
                }
                //分群--------------------------------
                int group = 0;
                switch (user[player].getPo()) {
                    //機會
                    case 2:
                    case 14:
                        group = 1;
                        break;
                    //命運
                    case 8:
                    case 20:
                        group = 2;
                        break;
                    //法院
                    case 4:
                        group = 3;
                        break;
                    //飛機
                    case 12:
                        group = 4;
                        break;
                    //競賽
                    case 16:
                        group = 5;
                        break;
                    case 0:
                        break;
                    //買賣歸屬
                    default:
                        group = 6;
                }
                //機會模組---------------------------
                if (group == 1) {
                    int cha = ran.nextInt(5);
                    user[player].setCash(user[player].getCash() + chance_moneyC[cha]);
                    System.out.println("走到機會，抽到的機會牌內容:" + chance_viewC[cha]);
                }
//            if(user[i].getPo()==2 || user[i].getPo()==14) {
//                int cha = ran.nextInt(2);
//                System.out.print(" 機會牌:" + player_chance[cha]);
//                if (cha == 0) user[i].setCash(user[i].getCash()-100000);
//                if (cha == 1) user[i].setCash(user[i].getCash()+2000);
//            }
                //命運模組---------------------------
                if (group == 2) {
                    int dis = ran.nextInt(5);
                    user[player].setPo(user[player].getPo() + destiny_moveD[dis]);
                    System.out.println("走到命運，抽到的命運牌內容:" + destiny_viewD[dis]);
                }
//            if(user[i].getPo()==8 || user[i].getPo()==20) {
//                int dis = ran.nextInt(2);
//                System.out.print(" 機會牌:" + player_chance[dis]);
//                if (dis == 0) user[i].setCash(user[i].getCash()-1000);
//                if (dis == 1) user[i].setCash(user[i].getCash()+20000);
//            }
                //法院模組---------------------------(暫停一天)
                if (group == 3) {
                    user[player].setStop(true);
//                user[i].setPo(user[i].getPo());
                }
                //飛機模組---------------------------(擲骰往前步數)
                if (group == 4) {
                    int mov = ran.nextInt(6) + 1;
                    System.out.println("走到飛機，隨機往前步數值為:"+mov);
                    user[player].setPo(user[player].getPo() + mov);
                }
                //競賽模組---------------------------(跟銀行比賽)
                if (group == 5) {
                    System.out.print("走到競賽場，須與銀行PK-----");
                    int pk_u = ran.nextInt(6) + 1;
                    int pk_s = ran.nextInt(6) + 1;
                    System.out.print("(玩家點數:" + pk_u + " 銀行點數:" + pk_s);
                    if (pk_u > pk_s) {
                        user[player].setCash(user[player].getCash() + 3000);
                        System.out.print(")玩家獲勝!玩家加3000~");
                    } else {
                        user[player].setCash(user[player].getCash() - 3000);
                        System.out.print(")銀行獲勝!玩家扣3000~");
                    }
                }
                //買賣歸屬---------------------------
                int pay_money = 0;
                if (group == 6) {
                    if (block[user[player].getPo()].getOwner() == 4) { //如果擁有者是自己，是否買?
                        System.out.println("監獄名稱:" + block[user[player].getPo()].title + "，此監獄無人購入，是否購買?(輸入1要，0不要)");
                        int buy = sc.nextInt();
                        if (buy == 1) {
                            if (user[player].getCash() > block[user[player].getPo()].getPrice()) { //確認玩家$>該監獄$
                                user[player].setCash(user[player].getCash() - block[user[player].getPo()].getPrice()); //踩到監獄，需購買
                                block[user[player].getPo()].owner = player;
                            }
                        }
                    } else {
                        if (block[user[player].getPo()].getOwner() != player) {//如果擁有者不是自己(要付錢)
                            pay_money = block[user[player].getPo()].getPrice() / 10 + 500; //要付的錢

                            user[player].setCash(user[player].getCash() - pay_money); //踩到別人擁有的監獄者，需扣錢
                            user[block[user[player].getPo()].getOwner()].setCash(user[block[user[player].getPo()].getOwner()].getCash() + pay_money);//監獄者，需加錢
//                        block[user[i].getPo()].getOwner()---該監獄擁有者編號()
                            System.out.println("此監獄屬於:" + (block[user[player].getPo()].getOwner() + 1) + "，需付款:" + pay_money);
//                        user[block[i].owner].setCash(user[block[i].owner].getCash()+pay_money);
                        }
                    }
                }
                //印出:骰子數 現在位置 $$-----------------
                System.out.println("骰子數:" + p + " 目前位置:" + user[player].getPo() + " 名稱:" + block[user[player].getPo()].title + " 財產:" + user[player].getCash());
                //破產模組------------------------------
                int cnt = 0;
                if (user[player].getCash() <= 0) {
                    System.out.println("玩家" + user[player].getName() + "已破產!");
                    user[player].setLife(0);
                    for (int b = 0; b < 24; b++) {
                        if (block[b].owner == player) {
                            block[b].owner = 4;
                        }
                    }
                }
                //玩家輪流-----------------------------
                do {
                    player++;
                    if (player > numi - 1) {
                        player = 0;
                    }
                } while (user[player].getLife() == 0); //如果有玩家破產

                //每次都檢查剩下玩家數
                for (int n = 0; n < numi; n++) {
                    if (user[n].getLife() == 1) cnt++;
                }
                if (cnt == 1) {
                    System.out.println("=======================================");
                    System.out.println("玩家" + user[player].getName() + " 贏得遊戲，遊戲結束!");
                    break;
                }
                cnt = 0;
                if (player == numi) player = 0; //重頭輪一圈
                //列印地圖-----------------------------
//                int length = 0; //計算要顯示(4-length)個空格
                String state;
                for (int i = 0; i < 24; i++) {
                    state = "";
                    for (int j = 0; j < player; j++) {
                        if (user[j].getPo() == i) { //抓出玩家位置並顯示在地圖上(該玩家位置==地圖編號)
                            state += user_id[j];
                        }
                        else{
                            state += user_id[4];
                        }
                    }
                    if(player<4){
                        for(int z=0;z<4-player;z++){
                            state +=user_id[4]; //user_id[4]=="　"
                        }
                    }
                    state = user_id[block[i].owner]+ state + user_id[4] ;
                    jail_data[i] = state;
                }
                Map(jail_data);
                //------------------------------------
            }
            else{
                user[player].setStop(false);
            }
        }
    }
}
 
