package com.kaixuan.djstudy.other.simple1;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 火车篇的查询工厂
 */

public class TicketFactory {
    static Map<String, Ticket> sTicketMap = new HashMap<>();

    public Ticket getTicket(String from, String to) {
        String kry = from + "_" + to;

        Ticket ticket = sTicketMap.get(kry);

        if (ticket != null) {
            return ticket;
        }

        ticket = new Ticket(from, to);

        sTicketMap.put(kry, ticket);

        return ticket;
    }
}
