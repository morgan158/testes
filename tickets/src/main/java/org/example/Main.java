package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "https://downloader.disk.yandex.ru/disk/797097c8c87bf09a462e03640ec99f55bc34593d58c9e6710d1812c3a4a4c4e3/628e0d6d/tYeYlYQMDWrLhsxckWkAuCkOJ5jZvUtacPYjm4O1lHBvgY-9DFje5CmZfQbwDgRv9Lgigws3Rf9-BpL1JPiycQ%3D%3D?uid=0&filename=tickets.json&disposition=attachment&hash=y3RyV4SxKwCTcLKtEujCjQ/0rBQGpLKQwWNjzBIJnWIF5bi3a4KNfLeuQWIN0a0xq/J6bpmRyOJonT3VoXnDag%3D%3D&limit=0&content_type=text%2Fplain&owner_uid=332089970&fsize=3277&hid=c0515b8717b42e59e386be1dd1dc994f&media_type=text&tknv=v2";
        ReaderJson readerJson = new ReaderJson();
        var tickets = readerJson.readJson(path);
        CalculateTicketsUtil util = new CalculateTicketsUtil();
        util.averageTimeFly(tickets);
        util.calcPercentile(tickets);
    }
}
