package com.example.finalhomework.bean;

import com.example.finalhomework.R;

import java.util.ArrayList;

public class GoodsInfo {
    public long rowid; // 行号
    public int sn; // 序号
    public String name; // 名称
    public String desc; // 描述
    public float price; // 价格
    public String thumb_path; // 小图的保存路径
    public String pic_path; // 大图的保存路径
    public int thumb; // 小图的资源编号
    public int pic; // 大图的资源编号

    public GoodsInfo() {
        rowid = 0L;
        sn = 0;
        name = "";
        desc = "";
        price = 0;
        thumb_path = "";
        pic_path = "";
        thumb = 0;
        pic = 0;
    }

    // 声明一个手机商品的名称数组
    private static String[] mNameArray = {
            "霍格沃茨城堡", "钢铁侠头盔", "树屋", "中央咖啡厅老友记", "守望先锋破坏球", "玩变小黄人","钢琴","阿波罗火箭土星五号"
    };
    // 声明一个手机商品的描述数组
    private static String[] mDescArray = {
            "乐高旗舰店官网 71043哈利波特成年高难度霍格沃茨城堡拼装积木",
            "乐高旗舰店官网 76165超级英雄钢铁侠头盔高难度积木玩具",
            "乐高旗舰店官网 Ideas系列21318树屋成年高难度积木玩具",
            "乐高旗舰店官网 Ideas系列21319中央咖啡厅老友记成年高难度积木",
            "乐高旗舰店官网 守望先锋系列75976破坏球送礼儿童积木玩具",
            "乐高旗舰店官网 75551玩变小黄人益智送礼儿童积木玩具",
            "乐高旗舰店官网 Ideas系列21323钢琴成年高难度积木玩具",
            "乐高旗舰店官网 Ideas系列92176阿波罗火箭土星五号益智积木玩具"
    };
    // 声明一个手机商品的价格数组
    private static float[] mPriceArray = {3999, 599, 1699, 699, 169, 499,3199,1099};
    // 声明一个手机商品的小图数组
    private static int[] mThumbArray = {
            R.drawable.lego1_s, R.drawable.lego2_s, R.drawable.lego3_s,
            R.drawable.lego4_s, R.drawable.lego5_s, R.drawable.lego6_s,
            R.drawable.lego7_s, R.drawable.lego9_s
    };
    // 声明一个手机商品的大图数组
    private static int[] mPicArray = {
            R.drawable.lego1, R.drawable.lego2, R.drawable.lego3,
            R.drawable.lego4, R.drawable.lego5, R.drawable.lego6,
            R.drawable.lego7, R.drawable.lego8
    };

    // 获取默认的手机信息列表
    public static ArrayList<GoodsInfo> getDefaultList() {
        ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
        for (int i = 0; i < mNameArray.length; i++) {
            GoodsInfo info = new GoodsInfo();
            info.name = mNameArray[i];
            info.desc = mDescArray[i];
            info.price = mPriceArray[i];
            info.thumb = mThumbArray[i];
            info.pic = mPicArray[i];
            goodsList.add(info);
        }
        return goodsList;
    }
}