package cn.ting97.year2021.apr.d27;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className ip2Integer
 * @Description ip地址 和 int 互转
 * @date 2021-04-27
 */
public class Ip2Integer {
    /**
     * ip地址 转 int
     *
     * @param ipAddress ip地址
     * @return int数字
     */
    public int ip2Integer(String ipAddress) {
        String[] address = ipAddress.split("\\.");
        int res = 0;
        for (int i = 0; i < address.length - 1; i++) {
            res += Integer.parseInt(address[i]);
            res <<= 8;
        }
        res += Integer.parseInt(address[address.length - 1]);
        return res;
    }

    /**
     * int 转 ip地址
     *
     * @param ip int
     * @return ip地址
     */
    public String integer2Ip(Integer ip) {
        int mod = 1 << 8;
        List<Integer> ipList = new LinkedList<>();
        while (ip != 0) {
            // 计算机以补码的形式去保存所有数据，当ip为负数时表示ip最高位段超过127
            // 所以需要 & 0xff 用于将数据还原
            ipList.add(0, (ip % mod) & 0xFF);
            // 无符号右移，可以省略符号位进行右移
            ip >>>= 8;
        }
        return ipList.stream().map(Object::toString).collect(Collectors.joining("."));
    }

    public static void main(String[] args) {
        String ipAddress = "255.255.255.255";
        Ip2Integer ip2Integer = new Ip2Integer();
        int ip = ip2Integer.ip2Integer(ipAddress);
        System.out.println("ip2Integer.ip2Integer(ipAddress) = " + ip);
        System.out.println("ip2Integer.integer2Ip(ip) = " + ip2Integer.integer2Ip(ip));
    }
}
