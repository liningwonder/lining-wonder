package com.lining.wonder.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author liningwonder
 */
public class NetworkUtil {

    public static LinkedHashSet<InetAddress> getLocalAddress() {
        final LinkedHashSet<InetAddress> ipSet = new LinkedHashSet<InetAddress>();
        Enumeration<NetworkInterface> networkInterfaces;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            return ipSet;
        }
        if (networkInterfaces == null) {
            return ipSet;
        }
        while (networkInterfaces.hasMoreElements()) {
            //网卡
            final NetworkInterface networkInterface = networkInterfaces.nextElement();
            //IP
            final Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                final InetAddress inetAddress = inetAddresses.nextElement();
                if (inetAddress != null && (!inetAddress.isLoopbackAddress()) &&  (inetAddress instanceof Inet4Address)) {
                    ipSet.add(inetAddress);
                }
            }
        }
        return ipSet;
    }

    public static String getLocalHost() {
        try {
            LinkedHashSet<InetAddress> localAddressList = getLocalAddress();
            if (0 < localAddressList.size()) {
                Iterator<InetAddress> iterator = localAddressList.iterator();
                if (iterator.hasNext()) {
                    return iterator.next().getHostAddress();
                }
            }
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getLocalHost());
    }

}
